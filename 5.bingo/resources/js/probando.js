const numero = document.querySelector("#contador");
const inicio = document.querySelector("#inicio");
const reinicio = document.querySelector("#reinicio");
const bingo = [];
const numMarcados = [];

for (let i = 1; i <= 90; i++) {
    bingo.push(i);
}

document.addEventListener("DOMContentLoaded", () => {
    
    generarCarton();
});

const sleep = function (ms) {
    return new Promise((resolve) => setTimeout(resolve, ms));
    // funcion asincrona espera un segundo, especificado en milisegundos
};

reinicio.addEventListener("click", (_) => {
    location.reload(); //reinicia el dom
});

inicio.addEventListener("click", async () => {
    // especificamos async

    for (let index = 0; index < 90; index++) {
        let random = bingo[getRandomInt(0, bingo.length - 1)]; // la funcion nos da el index de forma aleatoria, pero siempre rescata uno que no haya leido anteriormente del array
        numero.textContent = random; // Esto hace referencia a la bola

        for (let c = 0; c < 3; c++) {
            for (let f = 0; f < 3; f++) {
                for (let col = 0; col < 9; col++) {
                    let num = document.querySelector(
                        "#c" + c + "f" + f + "col" + col
                    );
                    if (random == num.textContent) {
                        num.style.backgroundColor = "#90EE90"; // pintamos cualquier numero en los cartones que coincidan
                    }
                }
            }
        }

        let marcado = document.querySelector("#circulo" + random);
        marcado.style.backgroundColor = "#90EE90"; // pintamos el numero en la tabla principal

        numMarcados.push(random); // lo introducimos en la lista de descartados
        bingo.splice(bingo.indexOf(random), 1); // sacamos el numero del array para que no se repita

        comprobarLinea();

        if (comprobarBingo() == true) {
            break;
        }

        await sleep(200); // el comando await indica que parte del codigo es asincrona
    }
});

function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1) + min);
}

function generarCarton() {
    let carton = [[], [], []];

    for (let fila = 0; fila < 3; fila++) {
        for (let col = 0; col < 90; col = col + 10) {
            let num = getRandomInt(col, col + 10);

            let usados = [];
            while (usados.includes(num)) {
                num = getRandomInt(col, col + 10);
            }
            usados.push(num); 

            carton[fila][col / 10] = num;

            if (carton[fila][col / 10] == 0) {
                carton[fila][col / 10] = 1;
            } // arreglillo

            /* if (
                fila > 0 &&
                carton[fila - 1][col / 10] > carton[fila][col / 10]
            ) {
                let dummy = carton[fila - 1][col / 10];
                console.log(dummy);
                carton[fila - 1][col / 10] = carton[fila][col / 10];
                carton[fila][col / 10] = dummy;
            } */
        }
    }

            // ordenar filas
           
    for (let col = 0; col < 9; col++) {

        let filaOrd = []; // por cada columna creamos un array que usaremos como dummy

        for (let fila = 0; fila < 3; fila++) {
            filaOrd.push(carton[fila][col]); // introducimos los tres valores de la misma columna
        }
        
        filaOrd.sort(); // ordenamos

        for (let fila = 0; fila < 3; fila++) {
             carton[fila][col] = filaOrd[fila] // sustituimos el valor por el correspondiente en el array dummy
        }
       
        
    }
                
            
    let x = 12;
    while (x > 0) {
        let contador = 0;

        let f = getRandomInt(0, 2);
        let c = getRandomInt(0, 8);

        let izquierda = c > 0 && carton[f][c - 1] == "X" ? 1 : 0;
        let izquierda2 = c > 1 && carton[f][c - 2] == "X" ? 1 : 0;
        let derecha = c < 8 && carton[f][c + 1] == "X" ? 1 : 0;
        let derecha2 = c < 7 && carton[f][c + 2] == "X" ? 1 : 0;
        let arriba = f > 0 && carton[f - 1][c] == "X" ? 1 : 0;
        let arriba2 = f > 1 && carton[f - 2][c] == "X" ? 1 : 0;
        let abajo = f < 2 && carton[f + 1][c] == "X" ? 1 : 0;
        let abajo2 = f < 1 && carton[f + 2][c] == "X" ? 1 : 0;

        if (
            izquierda + derecha + izquierda2 + derecha2 < 2 &&
            arriba + abajo + abajo2 + arriba2 < 2 &&
            carton[f][c] != "X"
        ) {
            for (let i = 0; i < 9; i++) {
                if (carton[f][i] == "X") {
                    contador++;
                }
            }
            if (contador < 4) {
                carton[f][c] = "X";
                x--;
            }
        }
    }
    /* console.log(carton); */
    return carton;
}

const cartones = [generarCarton(), generarCarton(), generarCarton()];

const cartonesLineas = [[], [], []];

for (let c = 0; c < 3; c++) {
    for (let f = 0; f < 3; f++) {
        for (let col = 0; col < 9; col++) {
            let num = document.querySelector("#c" + c + "f" + f + "col" + col);
            num.textContent = cartones[c][f][col];
        }
    }
}

let cantada = false;

function comprobarLinea() {
    cartones.forEach((carton) => {
        carton.forEach((linea) => {
            let aciertos = 0;
            numMarcados.forEach((num) => {
                if (linea.includes(num)) {
                    aciertos++;
                }
            });
            if (aciertos == 5) {
                for (let col = 0; col < 9; col++) {
                    let num = document.querySelector(
                        "#c" +
                            cartones.indexOf(carton) +
                            "f" +
                            carton.indexOf(linea) +
                            "col" +
                            col
                    );
                    num.style.backgroundColor = "lightSalmon";
                }
                if (!cantada) {
                    alert(
                        "¡¡LINEA!! en el carton:" +
                            cartones.indexOf(carton) +
                            " linea: " +
                            carton.indexOf(linea)
                    );
                }
                cantada = true;
                aciertos = 0;
                linea.splice(0, 3);
                cartonesLineas[cartones.indexOf(carton)].push("L");
            }
        });
    });
}

function comprobarBingo() {
    let bingo = false;
    cartonesLineas.forEach((carton) => {
        if (carton.length == 3) {
            alert(
                "¡¡¡BINGO EN EL CARTON " +
                    cartonesLineas.indexOf(carton) +
                    "!!!"
            );
            let cartonhtml = document.querySelector(
                "#carton" + cartonesLineas.indexOf(carton)
            );
            cartonhtml.style.backgroundColor = "salmon";
            bingo = true;
        }
    });
    return bingo;
}
