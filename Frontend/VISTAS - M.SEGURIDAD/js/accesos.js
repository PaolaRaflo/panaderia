$(document).ready(function() {
    const apiUrlPerfiles = "http://panaderia.app.informaticapp.com:3027/api/v1/perfiles";
    const apiUrlViewModulos = "http://panaderia.app.informaticapp.com:3027/api/v1/view_modulos";
    const apiUrlAccesos = "http://panaderia.app.informaticapp.com:3027/api/v1/accesos";
   
    // let jwtToken = prompt("Por favor ingrese su token:");
    let jwtToken = sessionStorage.getItem("token");

    function load_select_perfiles() {
        $.ajax({
            url: apiUrlPerfiles,
            method: "GET",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            success: function(response) {
                $("#idperfil").append(`
                    <option value="">Seleccione</option>
                `);
                response.forEach(modulo => {
                    
                    $("#idperfil").append(`
                        <option value="${modulo.idPerfil}">${modulo.perfil}</option>
                    `);
                   
                });
            },
            error: function(xhr, status, error) {
                console.error("Error al cargar modulos padre:", status, error);
            }
        });
    }
    load_select_perfiles();

    function buscarEnDom(idperfil, elemento, object) {
        for(let j = 0; j < object.length; j++) {
            if(idperfil == object[j].idPerfil && object[j].idModulo == elemento.value && elemento.name == "idmodulos[]") {
                return elemento;
            }
        }
        return false;
    }

    function loadModulos() {
        $.ajax({
            url: apiUrlViewModulos,
            method: "GET",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            success: function(response) {
                // console.log(response);
                // aginacion de todos los modulos padres
                var modulos = [];
                for (let i = 0; i < response.length; i++) {
                    if(response[i]["idPadre"] == 1 && response[i]["idModulo"] > 1 ) {
                        modulos.push(response[i]);
                    }

                }
                // console.log(modulos);
                // asignacion de los modulos hijos a los modulos padres
                for (let j = 0; j < modulos.length; j++) {
                    modulos[j]['hijos'] = [];
                    for (let h = 0; h < response.length; h++) {
                        if(modulos[j].idModulo == response[h].idPadre) {
                            modulos[j]['hijos'].push(response[h]);
                        }
                        
                    }
                    
                }
                
                var html = '<div class="col-md-3">';
                var i = 1;
                for (let index = 0; index < modulos.length; index++) {

                    html += '<h5 style="cursor:pointer" class="padre todo">'+modulos[index]['modulo']+'</h5>';

                    for (let h = 0; h < modulos[index]["hijos"].length; h++) {
                        html += '<div class="checkbox checkbox-primary checkboxes" style="">';
                        html += '<input type="checkbox" name="idmodulos[]" value="'+modulos[index]["hijos"][h]['idModulo']+'">';
                        html += modulos[index]["hijos"][h]['modulo'];
                        html += '</div>';
                        
                    }
                   
                    if(i%4 == 0) {
                        html += '<div style="clear:both;"></div>';
                    }
                   
                    html += '</div>';
                    html += '<div class="col-md-3">';
                   
                   
                    i++;
                }
                $("#accesos").html(html);

                var padres = document.getElementsByClassName("padre");

                for(let i = 0; i < padres.length; i++){
                    padres[i].addEventListener("click", function(event) {
                        event.preventDefault();
                        var checks = this.parentNode.getElementsByClassName("checkboxes");
                        if(this.classList.contains('todo')) {
                            for(let j = 0; j < checks.length; j++){
                                checks[j].getElementsByTagName("input")[0].checked = true;
                            }

                            this.classList.add("ninguno");
                            this.classList.remove("todo");
                        } else {
                            if(this.classList.contains('ninguno')) {
                                for(let j = 0; j < checks.length; j++){
                                    checks[j].getElementsByTagName("input")[0].checked = false;
                                }

                                this.classList.add("todo");
                                this.classList.remove("ninguno");
                            }
                        }
                    })
                }

                // console.log(response);
            },
            error: function(xhr, status, error) {
                console.error("Error al cargar modulos:", status, error);
            }
        });
    }

    // Cargar modulos al cargar la página
    loadModulos();
    


    // Escuchar el evento submit del formulario para registrar perfiles
    document.getElementById("guardarPermisos").addEventListener("click", function(e) {
    
        e.preventDefault();
        var idperfil = $("#idperfil").val();

        var formulario = document.getElementById("formularioPermisos");
        var datosFormulario = new FormData(formulario);
    
         // Convertir FormData a un objeto JSON
        var objetoJSON = {};
        datosFormulario.forEach(function(value, key){
            // Si el campo es un array (termina con '[]'), agrégalos como un array
            if (key.endsWith('[]')) {
                var fieldName = key.slice(0, -2); // Elimina los corchetes del nombre
                if (!objetoJSON[fieldName]) {
                    objetoJSON[fieldName] = [];
                }
                objetoJSON[fieldName].push(value);
            } else {
                objetoJSON[key] = value;
            }
        });
        objetoJSON['idmodulos'] = objetoJSON['idmodulos'].join(",");
        // console.log(JSON.stringify(objetoJSON));
    

        $.ajax({
            url: `${apiUrlAccesos}/${idperfil}`,
            method: "DELETE",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            success: function() {
                // Realizar la petición POST para registrar los accesos
                $.ajax({
                    url: apiUrlAccesos,
                    method: "POST",
                    headers: {
                        "Authorization": `Bearer ${jwtToken}`
                    },
                    contentType: "application/json",
                    data: JSON.stringify(objetoJSON),
                    success: function() {
                        alert("Accesos registrados exitosamente");
                        window.location = "accesos.html";
                    },
                    error: function(xhr, status, error) {
                        console.error("Error al registrar perfil:", status, error);
                    }
                });
            },
            error: function(xhr, status, error) {
                console.error("Error al eliminar accesos:", status, error);
            }
        });

        
    });

    


    document.getElementsByName("idperfil")[0].addEventListener("change", function() {
        var idperfil = this.value;
        //alert(idperfil);
        if(idperfil != "") {
            $.ajax({
                url: apiUrlAccesos,
                method: "GET",
                headers: {
                    "Authorization": `Bearer ${jwtToken}`
                },
                success: function(response) {
                    // console.log(response);
                    var checks = document.getElementsByClassName("checkboxes");
                    for(let i = 0; i < checks.length; i++){
                        if(buscarEnDom(idperfil, checks[i].getElementsByTagName("input")[0], response)) {
                            checks[i].getElementsByTagName("input")[0].checked = true;
                        } else {
                            checks[i].getElementsByTagName("input")[0].checked = false;
                        }
                    }
                },
                error: function(xhr, status, error) {
                    console.error("Error al cargar accesos:", status, error);
                }
            });
        } else {
            var checks = document.getElementsByClassName("checkboxes");
            for(let i = 0; i < checks.length; i++){
                checks[i].getElementsByTagName("input")[0].checked = false;
            }
        }
    })
});
