<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel de Bingo</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .panel {
            display: flex;
            justify-content: space-between;
            align-items: center;
            width: 80%;
            max-width: 900px;
        }

        /* Estilos para la sección izquierda (Matriz 3x5) */
        .matriz {
            display: grid;
            grid-template-columns: repeat(5, 1fr);
            grid-template-rows: repeat(3, 1fr);
            gap: 20px;
        }

        .circulo {
            width: 80px;
            height: 80px;
            background-color: #ff7043;
            color: #fff;
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 24px;
            font-weight: bold;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
        }

        /* Estilos para la sección derecha (Círculo Grande) */
        .circulo-grande {
            width: 150px;
            height: 150px;
            background-color: #42a5f5;
            color: white;
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 48px;
            font-weight: bold;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.3);
        }

        /* Alinear ambas secciones en el panel */
        .matriz-container {
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
        
        .circulo-grande-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100%;
        }
    </style>
</head>
<body>

    <div class="panel">
        <!-- Sección de la Matriz 3x5 -->
        <div class="matriz-container">
            <div class="matriz">
                <div class="circulo">12</div>
                <div class="circulo">45</div>
                <div class="circulo">78</div>
                <div class="circulo">23</div>
                <div class="circulo">56</div>
                <div class="circulo">67</div>
                <div class="circulo">14</div>
                <div class="circulo">89</div>
                <div class="circulo">32</div>
                <div class="circulo">99</div>
                <div class="circulo">41</div>
                <div class="circulo">15</div>
                <div class="circulo">65</div>
                <div class="circulo">48</div>
                <div class="circulo">10</div>
            </div>
        </div>

        <!-- Sección del Círculo Grande -->
        <div class="circulo-grande-container">
            <div class="circulo-grande">50</div>
        </div>
    </div>

</body>
</html>
<?php /**PATH C:\xampp\htdocs\5.bingo\resources\views/bingo.blade.php ENDPATH**/ ?>