public class App {
    public static void main(String[] args) throws Exception {

        /*Creo un libro, este se creara con una pagina 0 automaticamente */
        Libro l1 = new Libro();
        /*Creo paginas en orden natural */
        l1.nuevaPagina();
        l1.nuevaPagina();
        l1.nuevaPagina();
        l1.nuevaPagina();
        l1.nuevaPagina();

        /* Muestro el contenido del libro */
        System.out.println("");
        l1.mostrarContenido();

        /* Muestro el contenido de la pagina 2 */
        System.out.println("");
        l1.contenidoPagina(2);

        /* reemplazo la pagina 3 */
        System.out.println("");
        l1.reemplazarPagina(3, "nueva pagina 3");
        l1.mostrarContenido();

        /* intercambio las paginas 5 y 2 */
        System.out.println("");
        l1.intercambiarPaginas(5, 2);
        l1.mostrarContenido();

        /* reordeno las paginas */
        System.out.println("");
        l1.ordenarPaginas();
        l1.mostrarContenido();

        /* elimino la pagina 4 */
        System.out.println("");
        l1.eliminarPagina(4);
        l1.ordenarPaginas();
        l1.mostrarContenido();
       
        /* inserto una pagina en medio del array */
        System.out.println("");
        l1.insertarPagina(4, "pagina 4 insertada");
        l1.mostrarContenido();



    }
}
