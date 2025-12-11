<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Alumnos</title>
    {{-- php artisan make:migration create_alumno_table
        php artisan migrate --}}
    {{-- php artisan make:model Alumno --}}
    {{--  php artisan db:wipe   --}}
    {{--  php artisan make:factory AlumnoFactory --}}
    {{-- php artisan db:seed --}}
</head>
<body>
    <h1>{{$aula->nombre}}</h1>
    <ul>
        @foreach ($alumnos as $alu)
            <li>{{$alu->nombre}} {{$alu->apellido}}</li>
        @endforeach
    </ul>
</body>
</html>