import java.io.FileOutputStream;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

        FileOutputStream fichero = null;

        try{

            fichero = new FileOutputStream("prueba.dat");
/* 
            for (int i = 0; i < 6; i++) {

            fichero.write(i);

            } */

            fichero.write(15);

            fichero.close();

        }catch(IOException e){

            System.err.println( "Ha ocurrido un error: " + e.getLocalizedMessage() );
        }
    }
}

