<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
    body {
        width: 100vw;
        height: 100vh;
        background-color: lightblue;
        display: flex;
        flex-flow: column;
        justify-content: center;
        align-items: center;
    }

    .contenedor {
        width: 400px;
        height: 260px;
        display: flex;
        flex-flow: column;
        align-items: center;
        justify-content: center;
        gap: 10px;
        background-color: white;
        border-radius: 20px;
    }

    form{
        width: 400px;
        height: 260px;
        display: flex;
        flex-flow: column;
        align-items: center;
        justify-content: center;
        gap: 10px;
        background-color: white;
        border-radius: 20px;
    }

</style>

<body>
    <div class="contenedor">
        <form action="" method="post">
            <label for="email">Email: </label>
            <input type="email" id="email" name="email">
            <label for="password">Contraseña: </label>
            <input type="password" id="password" name="password">
            <input type="submit" id="enviar" value="enviar">
        </form>

        <?php

            session_start();

            $_SESSION['email'] = $_POST["email"];

            // setcookie('nombreCookie','valorCookie',time()+3600*24*31);
            setcookie('centro','medac',time()+20);

            
        ?>
    </div>
</body>

</html>