import java.util.ArrayList;


public class Libro {

    private ArrayList<Pagina> paginas = new ArrayList<>();

    /**
     * El constructor crea automaticamente una instancia de la clase pagina, 
     * esto porque uno de los requisitos era que cada libro debe contar con una pagina
     * y creando una pagina 0, el numero de pagina y el index de las siguientes paginas que creemos coincidiran 
     * en principio.
     * El constructor no cuenta con parametros ya que el unico atributo con el que cuenta la clase Libro
     * son las paginas, que se crean dentro de la misma clase al tratarse de una composicion
     * 
     */
    public Libro() {
        Pagina p = new Pagina(0, "PAGINA 0");
        paginas.add(p);
        
    }

    /**
     * Este metodo crea una nueva pagina en la ultima posicion del array
     * declaramos la variable n con el mismo int que el ultimo index 
     * para poder usarlo en el constructor de Pagina, 
     * esto hace que el numero de pagina sea igual al index de manera automatica
     * 
     * 
     * @param t (String) es el texto contenido en cada pagina
     */

    public void nuevaPagina(String t) {
        Pagina p = new Pagina(paginas.size(), t);
        paginas.add(p);
    }
    
    /**
     * Sobrecargo el metodo para ahorrar tiempo al usuario, 
     * este asignara un string descriptivo por defecto a cada pagina con su numero correspondiente 
     */
    public void nuevaPagina() {
        int n = paginas.size();
        String t = "Contenido de la página " + n;
        Pagina p = new Pagina(n, t);
        paginas.add(p);
    }

    /**
     * Este metodo funcionara igual que el metodo nueva pagina
     * con la diferencia de que podremos escoger el index en el que esta nueva pagina ira
     * mediante un booleano nos aseguramos de que el metodo solo trabaje si el numero de pagina 
     * que queremos introducir no existe previamente.
     * Para esto creamos un 'for' que recorra todo el arrayList 
     * el 'if' dentro de este comprueba si el atributo numPag de cada objeto coincide con el que queremos introducir
     * si fuera asi el metodo no haria nada,
     * en caso contrario se crea una nueva en el index indicado
     * 
     * @param n (int) este numero sera tanto el index como el numero de pagina
     * @param t (String) texto que contendra la pagina insertada
     */

    public void insertarPagina(int n, String t) {

        boolean repetido = false;

        for (int i = 0; i < paginas.size(); i++) {
            if (paginas.get(i).getNumpag() == n) {
                repetido = true;
            }
        }

        if (repetido == false) {

            Pagina p = new Pagina(n, t);
            paginas.add(n, p);

        }

    }

    /**
     * Este metodo desde el extremo del usuario parece que intercambia dos objetos dentro del arrayList, 
     * siendo estos los de los index de los dos numeros introducidos.
     * En realidad el metodo crea un objeto Pagina de forma temporal, al que asignamos los atributos del primer objeto 
     * que queremos intercambiar (vamos a llamarlo pagina1), de forma que que el numero de pagina de 'temporal' sera 1 
     * y su contenido el contenido de la pagina 1. 
     * Despues asigna los valores de los atributos del siguiente objeto(pagina2) a pagina1.
     * Si no hubieramos creado la Pagina temporal los datos de pagina1 se perderian en este punto, pero 
     * ahora podemos usarla para asignar sus atributos a pagina2
     * 
     * los bucles 'while' del principio se aseguran de que si existen paginas faltantes, las paginas que se salen
     * del rango del arrayList no provoquen un error.
     *  
     * @param n (int) index de la primera pagina a intercambiar
     * @param n2 (int) index de la segunda pagina a intercambiar
     */

    public void intercambiarPaginas(int n, int n2) {

        while(n>=paginas.size()){
            n--;
        }
        while(n2>=paginas.size()){
            n2--;
        }
        Pagina temporal = new Pagina(paginas.get(n).getNumpag(), paginas.get(n).getTexto());
        paginas.get(n).setNumpag(paginas.get(n2).getNumpag());
        paginas.get(n).setTexto(paginas.get(n2).getTexto());
        paginas.get(n2).setNumpag(temporal.getNumpag());
        paginas.get(n2).setTexto(temporal.getTexto());
        
    }

    /**
     * Este metodo elimina la pagina seleccionada 
     * comprobando primero que el index forme parte del arrayListS
     * 
     * @param n (int) index de la pagina que queremos eliminar
     */
    public void eliminarPagina(int n) {
        if(n<=paginas.size()){
            paginas.remove(n);
        }
    }

    /**
     * Este metodo combina el de eliminar pagina e insertar pagina, 
     * desde la perspectiva del usuario estará reemplazando una pagina existente
     * 
     * @param n index de la pagina a reemplazar
     * @param t contenido de remplazo
     */
    public void reemplazarPagina(int n, String t) {
        this.eliminarPagina(n);
        this.insertarPagina(n, t);
    }

    /**
     * 
     * no hay return pero devuelve un SOUT
     * mediante el metodo de Pagina getTexto mostramos el texto de la misma
     * 
     * @param n index de la pagina de la que queremos mostrar el contenido
     * 
     * 
     */
    public void contenidoPagina(int n) {
        System.out.println(paginas.get(n).getTexto());

    }


   /**
    * 
    * no hay return pero devuelve un SOUT
    * crea un for que recorre el array extrayendo el toString del objeto que se encuentra dentro de 
    * cada index
    */

    public void mostrarContenido() {
        for (int i = 0; i < paginas.size(); i++) {
            System.out.println(paginas.get(i).toString());
        }
    }

    /**
     * Este método ordena las páginas
     * mediante el uso de dos bucles, el primer bucle recorre el array comprobando mediante un 'if' si el index y el atributo
     * numPag del objeto dentro de este concuerden, de no ser asi recorre un segundo bucle buscando el numPag que coincida
     * con este primer index, y cuando lo encuentra ejecuta el metodo intercambiar paginasS
     */
    public void ordenarPaginas(){
        for(int i = 0; i<paginas.size(); i++){
            if(i!=paginas.get(i).getNumpag()){
               for(int j = 0; j<paginas.size(); j++){
                if(i==paginas.get(j).getNumpag()){
                    this.intercambiarPaginas(i, j);
                }
               }
            }
        }
        
    }
    

    @Override
    public String toString() {
        return "Libro [paginas=" + paginas + "]";
    }

}

