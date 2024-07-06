$(document).ready(function() {
    const apiUrlModulos = "http://panaderia.app.informaticapp.com:3027/api/v1/modulos";
    const apiUrlModulosPadre = "http://panaderia.app.informaticapp.com:3027/api/v1/view_modulos_padre";
    const apiUrlViewModulos = "http://panaderia.app.informaticapp.com:3027/api/v1/view_modulos";
    // let jwtToken = prompt("Por favor ingrese su token:");
    let jwtToken = sessionStorage.getItem("token");
  
    function load_select_modulos_padre() {
        $.ajax({
            url: apiUrlModulosPadre,
            method: "GET",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            success: function(response) {
              
                response.forEach(modulo => {
                    $("#idPadre").append(`
                        <option value="${modulo.idModulo}">${modulo.modulo}</option>
                    `);
                    $("#editModuloPadre").append(`
                        <option value="${modulo.idModulo}">${modulo.modulo}</option>
                    `);
                });
            },
            error: function(xhr, status, error) {
                console.error("Error al cargar modulos padre:", status, error);
            }
        });
    }
    load_select_modulos_padre();

    // Función para cargar y mostrar la lista de modulos
    function loadModulos() {
        $.ajax({
            url: apiUrlViewModulos,
            method: "GET",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            success: function(response) {
                let modulosTableBody = $("#modulosTableBody");
                modulosTableBody.empty();
                response.forEach(modulo => {
                    modulosTableBody.append(`
                        <tr>
                            <td>${modulo.idModulo}</td>
                            <td>${modulo.modulo}</td>
                            <td>${modulo.url}</td>
                            <td>${modulo.orden}</td>
                            <td>${modulo.moduloPadre}</td>
                           
                            <td>
                                <button class="btn btn-primary editModulo" data-id="${modulo.idModulo}" data-toggle="modal" data-target="#editarModuloModal">Editar</button>
                                <button class="btn btn-danger deleteModulo" data-id="${modulo.idModulo}">Eliminar</button>
                            </td>
                        </tr>
                    `);
                });
                $("#moduloForm")[0].reset();
                $("#editarModuloForm")[0].reset();
            },
            error: function(xhr, status, error) {
                console.error("Error al cargar modulos:", status, error);
            }
        });
    }

    // Cargar modulos al cargar la página
    loadModulos();

    // Escuchar el evento submit del formulario para registrar modulos
    $("#moduloForm").submit(function(e) {
        e.preventDefault();

        const nuevoModulo = {
            modulo: $("#modulo").val(),
            url: $("#url").val(),
            orden: $("#orden").val(),
            idPadre: $("#idPadre").val(),
         
           
        };

        console.log(JSON.stringify(nuevoModulo));

        // Realizar la petición POST para registrar el nuevo modulo
        $.ajax({
            url: apiUrlModulos,
            method: "POST",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            contentType: "application/json",
            data: JSON.stringify(nuevoModulo),
            success: function() {
                alert("Modulo registrado exitosamente");
                $("#nuevoModuloModal").modal("hide");
                loadModulos(); // Recargar la lista de modulos
            },
            error: function(xhr, status, error) {
                console.error("Error al registrar modulo:", status, error);
            }
        });
    });

    // Abrir modal de editar modulo y cargar datos del modulo seleccionado
    $("#modulosTableBody").on("click", ".editModulo", function() {
        let idmodulo = $(this).data("id");

        // Realizar una petición GET para obtener los datos del modulo específico
        $.ajax({
            url: `${apiUrlModulos}/${idmodulo}`,
            method: "GET",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            success: function(modulo) {
                // Llenar el formulario de editar modulo con los datos obtenidos
                $("#editModuloId").val(modulo.idModulo);
                $("#editModulo").val(modulo.modulo);
                $("#editUrl").val(modulo.url);
                $("#editOrden").val(modulo.orden);
                $("#editModuloPadre").val(modulo.idPadre);
                
            
            },
            error: function(xhr, status, error) {
                console.error("Error al cargar datos del modulo:", status, error);
            }
        });
    });

    // Submit del formulario de editar modulo
    $("#editarModuloForm").submit(function(e) {
        e.preventDefault();

        const idmodulo = $("#editModuloId").val();
        const modulo = {
            modulo: $("#editModulo").val(),
            url: $("#editUrl").val(),
            orden: $("#editOrden").val(),
            idPadre: $("#editModuloPadre").val(),
            
           
        };
        //alert(jwtToken);
        // Realizar la petición PUT para actualizar los datos del modulo
        $.ajax({
            url: `${apiUrlModulos}/${idmodulo}`,
            method: "PUT",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            contentType: "application/json",
            data: JSON.stringify(modulo),
            success: function() {
                alert("Modulo actualizado exitosamente");
                $("#editarModuloModal").modal("hide");
                loadModulos(); // Recargar la lista de modulos
            },
            error: function(xhr, status, error) {
                console.error("Error al actualizar modulo:", status, error);
            }
        });
    });

    // Eliminar modulo
    $("#modulosTableBody").on("click", ".deleteModulo", function() {
        let idmodulo = $(this).data("id");

        $.ajax({
            url: `${apiUrlModulos}/${idmodulo}`,
            method: "DELETE",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            success: function() {
                alert("Modulo eliminado exitosamente");
                loadModulos(); // Recargar la lista de modulos
            },
            error: function(xhr, status, error) {
                console.error("Error al eliminar modulo:", status, error);
            }
        });
    });
});
