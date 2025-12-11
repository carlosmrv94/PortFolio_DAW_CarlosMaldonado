public class Coche extends Vehiculo{

    protected int cilindrada; //Al ser otra clase padre estos atributos deben mostrarse como protegidos, para acceder desde todas las clases relacionadas
    protected int velocidad_maxima;

   

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getVelocidad_maxima() {
        return velocidad_maxima;
    }

    public void setVelocidad_maxima(int velocidad_maxima) {
        this.velocidad_maxima = velocidad_maxima;
    }

    public Coche(){
        this.numero_ruedas=4;
        this.capacidad=5;
    }

    public Coche( int cilindrada, int velocidad_maxima) {
        this();
        this.cilindrada = cilindrada;
        this.velocidad_maxima = velocidad_maxima;
    }

    @Override //Se pueden mostrar los atributos de la superclase
    public String toString() {
        return "Coche [numero de ruedas= " + numero_ruedas + " capacidad= " + " cilindrada= " + cilindrada + "velocidad maxima= "+velocidad_maxima+"]";
    }

    
}

