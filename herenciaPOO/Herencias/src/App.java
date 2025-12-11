public class App {
    public static void main(String[] args) throws Exception {
        Vehiculo v1 = new Vehiculo(); //Creo una clase vehiculo con el constructor por defecto para comprobar que funciona
        Coche c1 = new Coche(340, 200); //La clase coche no pide los parametros ruedas ni capacidad ya que los declaramos por defecto
        Bicicleta b1 = new Bicicleta("montaña"); //Se podria hacer un Regex si conocieramos los tipos de bicicleta para que el usuario no escriba cualquier cosa
        Turismo t1 = new Turismo(400,  360, 0, "rojo"); //Comprobamos que la subclase utiliza los paramteros de la superclase coche (a su vez tambien las de la clase padre de este solo que no las declaramos)
        Turismo t2 = new Turismo(t1); //El constructor de copia funciona correctamente

        
        t1.arrancar(); // arranca el turismo 1
        t1.acelerar(360); // acelera, esto no funciona con valores superiores a la velocidad maxima

        System.out.println(v1);
        System.out.println("");
        System.out.println(b1);
        System.out.println("");
        System.out.println(t1);
        System.out.println("");
        System.out.println(t1.calcularTiempo(300)); // dira el tiempo en horas en numeros enteros
    }
}
