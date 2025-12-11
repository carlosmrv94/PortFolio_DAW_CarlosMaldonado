public class Bicicleta extends Vehiculo{
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo; // idealmente un regex comprobaria que los datos introducidos tienen sentido
    }

    public Bicicleta(){
        this.numero_ruedas=2; // como mencionaba en la clase vehiculo, aunque heredan los parametros de la superclase no heredan los valores, ya que son especificos para las subclases
        this.capacidad=1;
    }

    public Bicicleta( String tipo) {
        this(); //no necesitamos pedir la capacidad o el numero de ruedas ya que el usuario no va a decidirlos
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Bicicleta [numero de ruedas= " + numero_ruedas + " capacidad: " + " tipo= " + tipo + "]";
    }

    
}
