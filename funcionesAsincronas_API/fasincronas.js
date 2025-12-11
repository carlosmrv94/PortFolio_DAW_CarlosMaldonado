/**
 * Creacion de promesa
 *
 * @param resolve Palabra reservada cuando se cumple la promesa
 * @param reject Palabra reservada cuando no se cumple la promesa
 *
 */

/* const aplicarDescuento = new Promise((resolve, reject) => {
  setTimeout(() => {
    const descuento = true
    if(descuento){
        resolve('Descuento aplicado')
    }
    else{
        reject('No se puede aplicar el descuento')
    }
  },2000);
});

console.log(aplicarDescuento) //! ESTO TARDARA LOS DOS SEGUNDOS DEL TIMEOUT DENTRO DE LA FUNCION , DEVOLVERA PENDIENTE
console.log('hola'); //! ESTO SE VERA AL CARGAR EL DOCUMENTO

setTimeout(() => {
    console.log(aplicarDescuento) 
}, 3000); */

//! ESTO SALDRIA DESPUES DE 5 SEG

/*
 *.then cuando se cumple la promesa quiero capturar el resultado
 *.catch cuando no se cumple la promesa quiero capturar el resultado
 */

/* aplicarDescuento
    .then(resultado => {
        console.log(resultado) //! SI SE CUMPLE LA PROMESA
    })
    .catch(error => {
        console.log(error) //! SI NO SE CUMPLE
    })

//* FETCH API */
// MANDA SOLICITUDES DE DATOS A OTRO SERVIDOR, SE RECUPERAN NORMALMENTE CON JSON

/* const url = "datos.txt"

fetch(url)
    .then(respuesta => {
        console.log(respuesta)
        console.log(respuesta.status)
        console.log(respuesta.statusText)
        console.log(respuesta.url)

        return respuesta.text()
        //! EL RETURN DEL PRIMER .THEN SE PASA COMO PARAMETRO AL SEGUNDO .THEN
    })
    .then(datos => {
        console.log(datos)
    })
    .catch(error=>{console.log(error)})
 */

const url2 = "https://dragonball-api.com/api/characters?page=1&limit=20";

fetch(url2)
  .then((respuesta) => respuesta.json())
  //.then(resultado => console.log((resultado)))
  .then((resultado) => {
    mostrarDatos(resultado);
  })
  .catch((error) => {
    console.log(error);
  });

function mostrarDatos(resultado) {
  resultado.items.forEach((element) => {
    let img = document.createElement("img");
    let body = document.querySelector("body");
    img.src = element.image;
    body.appendChild(img);
    console.log(element.image)
    /*   console.log(element.name)
            console.log(element.race) */
  });
}
