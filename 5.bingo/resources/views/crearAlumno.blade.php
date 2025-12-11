<!-- resources/views/alumnos/create.blade.php -->
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Alumno</title>
</head>
<body>
    <h1>Registrar Alumno</h1>

    @if(session('success'))
        <p>{{ session('success') }}</p>
    @endif

    <form action="{{ route('alumnos.store') }}" method="POST">
        @csrf

        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" id="nombre" value="{{ old('nombre') }}" required>
        @error('nombre')
            <div>{{ $message }}</div>
        @enderror

        <label for="apellidos">Apellidos:</label>
        <input type="text" name="apellidos" id="apellidos" value="{{ old('apellidos') }}" required>
        @error('apellidos')
            <div>{{ $message }}</div>
        @enderror

        <label for="email">Correo electrónico:</label>
        <input type="email" name="email" id="email" value="{{ old('email') }}" required>
        @error('email')
            <div>{{ $message }}</div>
        @enderror

        <label for="password">Contraseña:</label>
        <input type="password" name="password" id="password" required>
        @error('password')
            <div>{{ $message }}</div>
        @enderror

        <label for="password_confirmation">Confirmar Contraseña:</label>
        <input type="password" name="password_confirmation" id="password_confirmation" required>

        <label for="idaula">ID del Aula:</label>
        <input type="number" name="idaula" id="idaula" value="{{ old('idaula') }}" required>
        @error('idaula')
            <div>{{ $message }}</div>
        @enderror

        <button type="submit">Guardar Alumno</button>
    </form>
</body>
</html>
