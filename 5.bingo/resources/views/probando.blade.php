<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bingo Game</title>
    @vite(['resources/css/app.css', 'resources/js/app.js'])
</head>

<body class="bg-gray-700 flex justify-center items-center min-h-screen p-10 pt-20">

<div class="flex flex-col">
    <div class="flex items-center gap-10">
        <div class="bg-gray-200 p-8 rounded-lg shadow-lg">
            <div class="grid grid-cols-10 gap-3">
               
                @for ($i = 0, $cont = 1; $i < 9; $i++)
                    @for ($e = 0; $e < 10; $e++, $cont++)
                        <div id="circulo{{$cont}}" class="rounded-full bg-white w-12 h-12 flex items-center justify-center text-lg font-semibold text-gray-900">
                            {{ $cont }}
                        </div>
                    @endfor
                @endfor
            </div>
        </div>

        <div class="flex flex-col items-center">
            <div id="contador" class="w-40 h-40 bg-yellow-500 text-center flex items-center justify-center text-5xl font-bold rounded-full text-cyan-50 shadow-lg">
                0
            </div>
            <button id="inicio" class="mt-6 px-4 py-2 bg-gray-500 text-white rounded-md text-lg hover:bg-gray-900 transition duration-200 shadow-md">Jugar</button>
            <button id="reinicio" class="mt-6 px-4 py-2 bg-gray-500 text-white rounded-md text-lg hover:bg-gray-900 transition duration-200 shadow-md">Reiniciar</button>
        </div>
    </div>


    <div class="grid grid-cols-3 gap-8 mt-10 mb-20">
        @for ($carton = 0; $carton < 3; $carton++)
            <div id="carton{{$carton}}" class="bg-white p-4 rounded-lg shadow-lg">
                <h2 class="text-center text-xl font-semibold mb-4">Cartón {{ $carton }}</h2>
                <div class="grid grid-cols-9 gap-2">
                    @for ($fila = 0; $fila < 3; $fila++)
                        @for ($col = 0; $col < 9; $col++)
                            <div id="c{{$carton}}f{{$fila}}col{{$col}}" name="carton{{$carton}}fila{{$fila}}" class="w-10 h-10 bg-gray-300 rounded flex items-center justify-center text-lg font-semibold text-gray-900">
                              
                            </div>
                        @endfor
                    @endfor
                </div>
            </div>
        @endfor
    </div>
</div>
</body>