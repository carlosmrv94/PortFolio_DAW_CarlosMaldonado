public class Vehiculo {

    protected int numero_ruedas;
    protected int capacidad; // he declarado estos atributos, pero cada subclase tiene unos valores por defecto asi que no usaran la palabra reservada super todavia
    
    public Vehiculo() { // Los constructores y getters y setters. No he considerado oportuno necesitar el toString de vehiculo
        this.numero_ruedas = 4;
        this.capacidad = 5;
    }
    
    public Vehiculo(int numero_ruedas, int capacidad) {
        this.numero_ruedas = numero_ruedas;
        this.capacidad = capacidad;
    }

    public int getNumero_ruedas() {
        return numero_ruedas;
    }
    public void setNumero_ruedas(int numero_ruedas) {
        this.numero_ruedas = numero_ruedas;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
