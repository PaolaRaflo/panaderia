$(document).ready(function() {
    const apiUrlUsuarios = "http://panaderia.app.informaticapp.com:3027/api/v1/usuarios";
    let jwtToken = prompt("Por favor ingrese su token:");

    // Función para cargar y mostrar la lista de usuarios
    function loadUsuarios() {
        $.ajax({
            url: apiUrlUsuarios,
            method: "GET",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            success: function(response) {
                let usuariosTableBody = $("#usuariosTableBody");
                usuariosTableBody.empty();
                response.forEach(usuario => {
                    usuariosTableBody.append(`
                        <tr>
                            <td>${usuario.id}</td>
                            <td>${usuario.firstname}</td>
                            <td>${usuario.lastname}</td>
                            <td>${usuario.username}</td>
                            <td>${usuario.role}</td>
                            <td>
                                <button class="btn btn-primary editUsuario" data-id="${usuario.id}" data-toggle="modal" data-target="#editarUsuarioModal">Editar</button>
                                <button class="btn btn-danger deleteUsuario" data-id="${usuario.id}">Eliminar</button>
                            </td>
                        </tr>
                    `);
                });
            },
            error: function(xhr, status, error) {
                console.error("Error al cargar usuarios:", status, error);
            }
        });
    }

    // Cargar usuarios al cargar la página
    loadUsuarios();

    // Escuchar el evento submit del formulario para registrar usuarios
    $("#usuarioForm").submit(function(e) {
        e.preventDefault();

        const nuevoUsuario = {
            firstname: $("#firstname").val(),
            lastname: $("#lastname").val(),
            username: $("#username").val(),
            password: $("#password").val(),
            role: "USER" // Puedes establecer el rol por defecto aquí, según tu lógica
        };

        // Realizar la petición POST para registrar el nuevo usuario
        $.ajax({
            url: apiUrlUsuarios,
            method: "POST",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            contentType: "application/json",
            data: JSON.stringify(nuevoUsuario),
            success: function() {
                alert("Usuario registrado exitosamente");
                $("#nuevoUsuarioModal").modal("hide");
                loadUsuarios(); // Recargar la lista de usuarios
            },
            error: function(xhr, status, error) {
                console.error("Error al registrar usuario:", status, error);
            }
        });
    });

    // Abrir modal de editar usuario y cargar datos del usuario seleccionado
    $("#usuariosTableBody").on("click", ".editUsuario", function() {
        let usuarioId = $(this).data("id");

        // Realizar una petición GET para obtener los datos del usuario específico
        $.ajax({
            url: `${apiUrlUsuarios}/${usuarioId}`,
            method: "GET",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            success: function(usuario) {
                // Llenar el formulario de editar usuario con los datos obtenidos
                $("#editUserId").val(usuario.id);
                $("#editFirstname").val(usuario.firstname);
                $("#editLastname").val(usuario.lastname);
                $("#editUsername").val(usuario.username);
                $("#editRole").val(usuario.role);
            },
            error: function(xhr, status, error) {
                console.error("Error al cargar datos del usuario:", status, error);
            }
        });
    });

    // Submit del formulario de editar usuario
    $("#editarUsuarioForm").submit(function(e) {
        e.preventDefault();

        const usuarioId = $("#editUserId").val();
        const usuario = {
            firstname: $("#editFirstname").val(),
            lastname: $("#editLastname").val(),
            username: $("#editUsername").val(),
            password: $("#editPassword").val(),
            role: $("#editRole").val()
        };

        // Realizar la petición PUT para actualizar los datos del usuario
        $.ajax({
            url: `${apiUrlUsuarios}/${usuarioId}`,
            method: "PUT",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            contentType: "application/json",
            data: JSON.stringify(usuario),
            success: function() {
                alert("Usuario actualizado exitosamente");
                $("#editarUsuarioModal").modal("hide");
                loadUsuarios(); // Recargar la lista de usuarios
            },
            error: function(xhr, status, error) {
                console.error("Error al actualizar usuario:", status, error);
            }
        });
    });

    // Eliminar usuario
    $("#usuariosTableBody").on("click", ".deleteUsuario", function() {
        let usuarioId = $(this).data("id");

        $.ajax({
            url: `${apiUrlUsuarios}/${usuarioId}`,
            method: "DELETE",
            headers: {
                "Authorization": `Bearer ${jwtToken}`
            },
            success: function() {
                alert("Usuario eliminado exitosamente");
                loadUsuarios(); // Recargar la lista de usuarios
            },
            error: function(xhr, status, error) {
                console.error("Error al eliminar usuario:", status, error);
            }
        });
    });
});
