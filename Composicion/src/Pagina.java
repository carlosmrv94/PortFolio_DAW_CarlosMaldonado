public class Pagina {
    
    private int numpag;
    private String texto;
    
    /**
     * Este seria el constructor de la clase Pagina
     * a este solo se puede acceder desde la clase libro al tratarse
     * de una relacion de composicion
     * 
     * @param numpag
     * @param texto
     */
    public Pagina(int numpag, String texto) {
        this.numpag = numpag;
        this.texto = texto;
    }

    /**Los metodos de esta clase son los habituales getters y setters de los atributos, que necesitaremos en la clase
    * Libro 
     */
    public int getNumpag() {
        return numpag;
    }
    public void setNumpag(int numpag) {
        this.numpag = numpag;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /*He personalizado el toString para crear un listado mas facil de leer en el metodo
     * mostrarContenido de la clase Libro
     */
        @Override
    public String toString() {
        return "Pagina: " + numpag + ", contenido: " + texto ;
    }

    

}
