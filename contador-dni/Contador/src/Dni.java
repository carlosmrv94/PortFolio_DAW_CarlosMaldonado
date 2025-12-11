import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dni {
//*Creamos el atributo DNI */
    private String DNI;
//*Creamos un constructor por defecto */
    public Dni() {
        this.DNI = "00000000";
    }
//*Si el método comprobar letra valida el DNI como correcto asignara el constructor por parámetro */
    public Dni(String DNI) {
        this();
        if (calcularLetra(DNI) != '?') {
            String dnitotal = DNI + calcularLetra(DNI);
            this.DNI = dnitotal;
        }
    }
//*metodo to String */
    public String toString() {
        return "[DNI] " + this.DNI;

    }

    public char calcularLetra(String dnix) { //@param dni especificado en el main
        // *El regex comprueba si hay 8 caracteres exactamente y estos son dígitos

        String regex = "[0-9]{8}";

        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(dnix);

        if (m.matches() == true) {

            // *Si el String coincide realizamos un parse para convertir el dni en un int
            int dninum = Integer.parseInt(dnix);
            // *calculamos el resto de este entre 23, esto es el cálculo para hayar la letra
            // de un DNI
            int resto = dninum % 23;
            // *Creamos un String con las letras en el orden que siguen las letras de DNI
            String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
            // *el caracter que haya en el número que hemos calculado sera la letra que
            // buscamos
            return letrasDNI.charAt(resto);

        } else {
            // !Si el parámetro introducido no fueran 8 digitos devolveria el caracter '?',
            // este por poner cualquiera no incluido en el alfabeto
            return '?';
        }

    }

}
