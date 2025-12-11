public class Turismo extends Coche{
    
    private int v_actual;
    private String color;
    private boolean parado;

   
  

    
    public Turismo( int cilindrada, int velocidad_maxima, int v_actual, String color) {
      
        super( cilindrada, velocidad_maxima); //Aqui si heredan los valores de los atributos. usamos la palabra reservada super
        this.v_actual = v_actual;               //no quiere decir que necesite de un objeto coche previamente creado, si no que se entiende turismo como una clase coche. Por lo que tendra los atributos de este ademas de los especificos de su clase
        this.color = color;
      
    }

    public Turismo ( Turismo turismo) { //CONSTRUCTOR DE COPIA
        this.numero_ruedas = turismo.numero_ruedas;
        this.capacidad = turismo.capacidad;
        this.cilindrada = turismo.cilindrada;  
        this.velocidad_maxima = turismo.velocidad_maxima;  
        this.v_actual = turismo.v_actual;  
        this.color = turismo.color;  
        this.parado=true;
      
        
}

    public int getV_actual() {
        return v_actual;
    }
    public void setV_actual(int v_actual) {
        this.v_actual = v_actual;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isParado() {
        return parado;
    }
    public void setParado(boolean parado) {
        this.parado = parado;
    }


    public void arrancar(){
        if(this.parado==true && this.v_actual==0){ // solo arranca si esta parado y su velocidad es 0
            this.parado=false;
        } 
    };

    public void parar(){
        if(this.parado==false && v_actual==0){ //solo para si esta arrancado y su velocidad es 0
            this.parado=true;
        } 
    };

    public void acelerar(int velocidad){
        if(this.parado==false && this.v_actual>=0 && this.v_actual<=this.velocidad_maxima){
            //Esta condicion es comun a todos los metodos parado se refiere a motor apagado, la velocidad comprende entre 0 y la que introduzcamos como velocidad maxima
            this.v_actual = velocidad;
        }
    
    };

    public void frenar(){
        if(this.parado==false && this.v_actual>=0 && this.v_actual<=this.velocidad_maxima){
            this.v_actual = 0;
        }
    
    };

    public String calcularTiempo( int distancia){ // La distancia debe introducirse en kilometros
          if(this.parado==false && this.v_actual>=0 && this.v_actual<=this.velocidad_maxima){
             int horas = distancia/this.v_actual;
           
             String tiempo = "[ " + horas + " horas]" ;
             return tiempo;
          }else{String tiempo = "EL COCHE DEBE ESTAR EN MARCHA";
            return tiempo;}
    };
    
    @Override
    public String toString() {
        return "Coche [numero de ruedas= " + numero_ruedas + " capacidad= " + capacidad +  " cilindrada= " + cilindrada + "velocidad maxima= "+ velocidad_maxima + "velocidad actual= " + v_actual + " color= " + color + "]";
    }
}
    


