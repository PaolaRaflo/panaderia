
var url = this.window.location.pathname;
var partesUrl = url.split("/");
var route = partesUrl[partesUrl.length-1];
$(document).ready(function() {
    
    
    const apiUrlModulos = "http://panaderia.app.informaticapp.com:3027/api/v1/modulos";
    const apiUrlUsuarios = "http://panaderia.app.informaticapp.com:3027/api/v1/usuarios/user/id";
    const apiUrlViewAccesos = "http://panaderia.app.informaticapp.com:3027/api/v1/view_accesos";
    let jwtToken = sessionStorage.getItem("token");
    function validar_conexion() {
        $.ajax({
            url: apiUrlUsuarios,
            method: "GET",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            success: function(response) {
                // console.log(response);
                var array = response.toString().split("|");
                var iduser = array[0];
                var idperfil = array[1];
                // console.log(array);
                $.ajax({
                    url: apiUrlViewAccesos,
                    method: "GET",
                    headers: {
                        "Authorization": `Bearer ${jwtToken}`
                    },
                    success: function(accesos) {
                        var array = [];
                        var html = '';
                        var modulo_padre_activo_id = '';
                        for (let i = 0; i < accesos.length; i++) {
                            if(accesos[i].idperfil == idperfil && accesos[i].iduser == iduser) {

                                if(route == "index.html") {
                                    url = "views/"+accesos[i].url;
                                } else {
                                    url = accesos[i].url;
                                }

                                // console.log(url);
                                
                                if(array.indexOf(accesos[i].moduloPadre) == -1 && i > 0) {
                                    html += '</ul>';
                                }
                                if(array.indexOf(accesos[i].moduloPadre) == -1) {
                                    html += '<a href="#'+accesos[i].moduloPadre.replace(/ /g, "")+'" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">';
                                    html += '   <span class="las la-cog"></span><span>'+accesos[i].moduloPadre+'</span>';
                                    html += '</a>';
                                    html += '<ul class="collapse list-unstyled" id="'+accesos[i].moduloPadre.replace(/ /g, "")+'">';
                                    array.push(accesos[i].moduloPadre);
                                }
                                if(accesos[i].url == route) {
                                    modulo_padre_activo_id = accesos[i].moduloPadre.replace(/ /g, "");
                                    $("#"+accesos[i].moduloPadre.replace(/ /g, "")).addClass("show");
                                    
                                    html += '<li ><a class="active" href="'+url+'">'+accesos[i].modulo+'</a></li>';
                                } else {
                                    html += '<li><a href="'+url+'">'+accesos[i].modulo+'</a></li>';
                                }
                                

                            
                            }
                            
                        }
                        $("#menu_accesos").html(html);
                        var html = '<a id="cerrar_sesion" href="" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">';
                        html += '   <span class="las la-cog"></span><span>Cerrar Sesión</span>';
                        html += '</a>';
                        $("#menu_accesos").append(html);

                        $("#cerrar_sesion").click(function() {
                            sessionStorage.removeItem("token");
                            if(route == "index.html") {
                                window.location = "login.html";
                            } else {
                                window.location = "../login.html";
                            }
                            // alert("cerrar sesion");
                        })

                        $("#"+modulo_padre_activo_id).addClass("show");
                    },
                    error: function(xhr, status, error) {
                        console.error("Error al cargar modulos:", status, error);
                    }
                });
            
            },
            error: function(xhr, status, error) {
                alert("Sesion Expirada");
                if(route == "index.html") {
                    window.location = "login.html";
                } else {
                    window.location = "../login.html";
                }
            }
        });
    }

    validar_conexion();

    function loadUsuarios() {
        $.ajax({
            url: apiUrlUsuarios,
            method: "GET",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            success: function(response) {
                
            },
            error: function(xhr, status, error) {
                console.error("Error al cargar usuarios:", status, error);
            }
        });
    }

    // Cargar usuarios al cargar la página
    loadUsuarios();

})