$(document).ready(function() {
    const apiUrlPerfiles = "http://panaderia.app.informaticapp.com:3027/api/v1/perfiles";
    // let jwtToken = prompt("Por favor ingrese su token:");
    let jwtToken = sessionStorage.getItem("token");
    

    // Función para cargar y mostrar la lista de perfiles
    function loadPerfiles() {
        $.ajax({
            url: apiUrlPerfiles,
            method: "GET",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            success: function(response) {
                let perfilesTableBody = $("#perfilesTableBody");
                perfilesTableBody.empty();
                response.forEach(perfil => {
                    perfilesTableBody.append(`
                        <tr>
                            <td>${perfil.idPerfil}</td>
                            <td>${perfil.perfil}</td>
                           
                            <td>
                                <button class="btn btn-primary editPerfil" data-id="${perfil.idPerfil}" data-toggle="modal" data-target="#editarPerfilModal">Editar</button>
                                <button class="btn btn-danger deletePerfil" data-id="${perfil.idPerfil}">Eliminar</button>
                            </td>
                        </tr>
                    `);
                });
            },
            error: function(xhr, status, error) {
                console.error("Error al cargar perfiles:", status, error);
            }
        });
    }

    // Cargar perfiles al cargar la página
    loadPerfiles();

    // Escuchar el evento submit del formulario para registrar perfiles
    $("#perfilForm").submit(function(e) {
        e.preventDefault();

        const nuevoPerfil = {
            perfil: $("#perfil").val(),
         
           
        };

        // console.log(JSON.stringify(nuevoPerfil));

        // Realizar la petición POST para registrar el nuevo perfil
        $.ajax({
            url: apiUrlPerfiles,
            method: "POST",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            contentType: "application/json",
            data: JSON.stringify(nuevoPerfil),
            success: function() {
                alert("Perfil registrado exitosamente");
                $("#nuevoPerfilModal").modal("hide");
                loadPerfiles(); // Recargar la lista de perfiles
            },
            error: function(xhr, status, error) {
                console.error("Error al registrar perfil:", status, error);
            }
        });
    });

    // Abrir modal de editar perfil y cargar datos del perfil seleccionado
    $("#perfilesTableBody").on("click", ".editPerfil", function() {
        let idPerfil = $(this).data("id");

        // Realizar una petición GET para obtener los datos del perfil específico
        $.ajax({
            url: `${apiUrlPerfiles}/${idPerfil}`,
            method: "GET",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            success: function(perfil) {
                // Llenar el formulario de editar perfil con los datos obtenidos
                $("#editPerfilId").val(perfil.idPerfil);
                $("#editPerfil").val(perfil.perfil);
                
            
            },
            error: function(xhr, status, error) {
                console.error("Error al cargar datos del perfil:", status, error);
            }
        });
    });

    // Submit del formulario de editar perfil
    $("#editarPerfilForm").submit(function(e) {
        e.preventDefault();

        const idPerfil = $("#editPerfilId").val();
        const perfil = {
            perfil: $("#editPerfil").val(),
            
           
        };
        //alert(jwtToken);
        // Realizar la petición PUT para actualizar los datos del perfil
        $.ajax({
            url: `${apiUrlPerfiles}/${idPerfil}`,
            method: "PUT",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            contentType: "application/json",
            data: JSON.stringify(perfil),
            success: function() {
                alert("Perfil actualizado exitosamente");
                $("#editarPerfilModal").modal("hide");
                loadPerfiles(); // Recargar la lista de perfiles
            },
            error: function(xhr, status, error) {
                console.error("Error al actualizar perfil:", status, error);
            }
        });
    });

    // Eliminar perfil
    $("#perfilesTableBody").on("click", ".deletePerfil", function() {
        let idPerfil = $(this).data("id");

        $.ajax({
            url: `${apiUrlPerfiles}/${idPerfil}`,
            method: "DELETE",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            success: function() {
                alert("Perfil eliminado exitosamente");
                loadPerfiles(); // Recargar la lista de perfiles
            },
            error: function(xhr, status, error) {
                console.error("Error al eliminar perfil:", status, error);
            }
        });
    });
});
