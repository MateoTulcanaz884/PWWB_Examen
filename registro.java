 document.getElementById('registroForm').addEventListener('submit', function(e) {
            e.preventDefault();
            let valido = true;

            // Limpiar mensajes
            document.getElementById('errorNombre').textContent = '';
            document.getElementById('errorCorreo').textContent = '';
            document.getElementById('errorEdad').textContent = '';
            document.getElementById('errorLenguaje').textContent = '';

            const nombre = document.getElementById('nombre').value.trim();
            const correo = document.getElementById('correo').value.trim();
            const edad = parseInt(document.getElementById('edad').value);
            const lenguaje = document.getElementById('lenguaje').value;

            // Validación Nombre
            if (nombre.length < 3) {
                document.getElementById('errorNombre').textContent = 'El nombre debe tener al menos 3 caracteres.';
                valido = false;
            }

            // Validación Correo
            const regexCorreo = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!regexCorreo.test(correo)) {
                document.getElementById('errorCorreo').textContent = 'Ingrese un correo electrónico válido.';
                valido = false;
            }

            // Validación Edad
            if (isNaN(edad) || edad < 18 || edad > 99) {
                document.getElementById('errorEdad').textContent = 'La edad debe ser un número entre 18 y 99.';
                valido = false;
            }

            // Validación Lenguaje
            if (lenguaje === "") {
                document.getElementById('errorLenguaje').textContent = 'Seleccione un lenguaje de programación.';
                valido = false;
            }

            if (valido) {
                alert('Registro completado exitosamente.');
                this.reset();
            }
        });