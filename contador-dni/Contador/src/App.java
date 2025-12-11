public class App {
    public static void main(String[] args) throws Exception {
      
        //*Creamos una instancia de la clase contador sin introducir parámetros para que ejecute el constructor por defecto, y otra introduciendo parámetros */
        Contador c1 = new Contador();
        Contador c2 = new Contador(5);


        //*utilizando los métodos que he explicado en la clase Contador incrementamos y decrementamos las dos instancias al llamar a la variables c1 y c2 se ejecuta el toString sin necesidad de escribirlo */
        c1.decrementar();
        System.out.println(c1);

        c2.incrementar();
        System.out.println(c2);


        //*Creamos una instancia de la clase dni, introducimos un string de 8 digitos para que ejecute el constructor por parámetro*/
        Dni dnix1 = new Dni("35609294");
        
        //*Al estar en el constructor el metodo calcularLetra se ha ejecutado en nuestra clase, de haber sido un parámetro erroneo habria utilizado el constructor por defecto */
        System.out.println(dnix1);
    }
}
