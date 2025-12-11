public class Contador {

    //*Creamos un atributo para numero */
    private int numero;


    //*un constructor por defecto que establezca el número como 0 */
    public Contador() {
        this.numero = 0;
    }

    //*un constructor por parámetros */
    public Contador(int numero) {

        this.numero = numero;

    }

    //*El metodo toString que ejecutara si usamos la variable creada junto al constructor en la instancia, sería un getter*/
    @Override
    public String toString() {
        return "[numero] " + this.numero;
    }

    //*un método que incremente en uno el número y otro que lo reduzca, serían setter */
    public void incrementar() { //@param numero
       this.numero++;
    }

    public void decrementar() {
       this.numero--;
    }


}
