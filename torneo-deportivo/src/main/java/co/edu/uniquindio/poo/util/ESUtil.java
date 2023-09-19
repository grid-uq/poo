/**
 * Clase utilitaria para el ingreso y salida de datos mediante el uso de cuadros de dialogo.
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.swing.JOptionPane;

public final class ESUtil {

    private ESUtil(){}

    /**
     * Permite mostrar un cuadro de dialogo con el mensaje dado
     * @param mensaje Mensaje que se desea mostrar al usuario.
     */
    public static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Diálogo de salida", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Permite mostrar un cuadro de dialogo con un mensaje de error dado
     * @param mensaje Mensaje de error que se desea mostrar al usuario.
     */
    public static void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Diálogo de error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Permite solicitar al usuario el ingreso de un dato
     * 
     * @param <T> Tipo de dato a ingresar
     * @param mensaje Mensaje que se mostrará al usuario para solicitar el dato
     * @param parser Función a ser usada para interpretar la información ingresada por el usuario y convertirla en un dato de tipo <T>
     * @param validator Función a ser usada para validar el dato ingresado por el usuario
     * @return El dato ingresado por el usuario
     */
    public static <T> T ingresarDato(String mensaje, Function<String,T> parser, Function<T,T> validator){
        T value = null;
        boolean invalido = true;
        do{
            try {
                String texto = JOptionPane.showInputDialog(null, mensaje,"Diálogo de entrada", JOptionPane.QUESTION_MESSAGE);
                value = parser.andThen(validator).apply(texto);
                invalido = false;
            }catch(Throwable t){
                mostrarError(t.getMessage());
            }
        }while (invalido);
        return value;
    }

    /**
     * Permite solicitar al usuario el ingreso de un dato
     * 
     * @param <T> Tipo de dato a ingresar
     * @param mensaje Mensaje que se mostrará al usuario para solicitar el dato
     * @param parser Función a ser usada para interpretar la información ingresada por el usuario y convertirla en un dato de tipo <T>
     * @return El dato ingresado por el usuario
     */
    public static <T> T ingresarDato(String mensaje, Function<String,T> parser){
        return ingresarDato(mensaje, parser,Function.identity());
    }

    /**
     * Función que permite envolver la función que interpreta el dato ingresado por el usuario y lo transforma 
     * con el fin de personalizar el mensaje de error cuando dicha función falla.
     * @param <T> Tipo de dato a ser obtenido
     * @param parser Función de interpretación que se desea envolver.
     * @param mensaje Mensaje de error que se desea mostrar en caso de error
     * @return Nueva función de interpretación con el mensaje de error personalizado.
     */
    public static <T> Function<String,T> createCustomParser(Function<String,T> parser,String mensaje){
        return (valor)->{
            try{
                return parser.apply(valor);
            }catch(Throwable exception){
                throw new RuntimeException(mensaje);
            }
        };
    }

    /**
     * Función que permite envolver la función que interpreta el dato ingresado por el usuario y lo transforma 
     * con el fin de personalizar el mensaje de error cuando dicha función falla.
     * @param <T> Tipo de dato a ser obtenido
     * @param validacion Función de validación que se desea envolver.
     * @param mensaje Mensaje de error que se desea mostrar en caso de error
     * @return Nueva función de validación con el mensaje de error personalizado.
     */
    public static <T> Function<T,T> createCustomValidator(Predicate<T> validacion,String mensaje){
        return (valor)->{
            if( !validacion.test(valor) ){
                throw new AssertionError(mensaje);
            }
            return valor;
        };
    }

    /**
     * Función muestra un mensaje al usuario y que permite ingresar un texto 
     * @param mensaje Mensaje a ser mostrado al usuario
     * @return Texto ingresado por el usuario
     */
    public static String ingresarTexto(String mensaje ){
        return ingresarDato(mensaje, Function.identity());      
    }

    /**
     * Función muestra un mensaje al usuario y que permite ingresar un dato entero, al cual se le aplica una función de validación dada
     * @param mensaje Mensaje a ser mostrado al usuario
     * @param validacion Función de validación a ser aplicada al dato ingresado por el usuario
     * @return Número entero ingresado por el usuario
     */
    public static int ingresarEntero(String mensaje,Function<Integer,Integer> validacion) {
        return ingresarDato(mensaje, createCustomParser(Integer::parseInt, "El valor ingresado no es un número entero") ,validacion);
    }
    
    /**
     * Función muestra un mensaje al usuario y que permite ingresar un dato entero
     * @param mensaje Mensaje a ser mostrado al usuario
     * @return Número entero ingresado por el usuario
     */
    public static int ingresarEntero(String mensaje) {
        return ingresarEntero(mensaje, Function.identity());
    }

    /**
     * Función muestra un mensaje al usuario y que permite ingresar un dato entero que sea mayor al limite dado
     * @param mensaje Mensaje a ser mostrado al usuario
     * @param limite limite inferior que restringe la entrada del usuario. El número ingresado debe ser mayor a este limite.
     * @return Número entero ingresado por el usuario
     */
    public static int ingresarEnteroMayorQue(String mensaje, int limite) {
        Predicate<Integer> validacion = numero->numero>limite;
        return ingresarEntero(mensaje, createCustomValidator(validacion,"El valor ingresado no es mayor que "+limite));
    }

    /**
     * Función muestra un mensaje al usuario y que permite ingresar un dato entero que sea menor al limite dado
     * @param mensaje Mensaje a ser mostrado al usuario
     * @param limite limite inferior que restringe la entrada del usuario. El número ingresado debe ser menor a este limite.
     * @return Número entero ingresado por el usuario
     */
    public static int ingresarEnteroMenorQue(String mensaje, int limite) {
        Predicate<Integer> validacion = numero->numero<limite;
        return ingresarEntero(mensaje, createCustomValidator(validacion,"El valor ingresado no es menor que "+limite));
    }

    /**
     * Función muestra un mensaje al usuario y que permite ingresar un dato entero que este dentro de un rango dado
     * @param mensaje Mensaje a ser mostrado al usuario
     * @param limiteInferior limite inferior que restringe la entrada del usuario. El número ingresado debe ser mayor o igual a este limite.
     * @param limiteSuperior limite inferior que restringe la entrada del usuario. El número ingresado debe ser menor o igual a este limite.
     * @return Número entero ingresado por el usuario
     */
    public static int ingresarEnteroEntre(String mensaje, int limiteInferior,int limiteSuperior) {
        Predicate<Integer> validacion = numero->numero>=limiteInferior&&numero<=limiteSuperior;
        return ingresarEntero(mensaje, createCustomValidator(validacion,"El valor ingresado no es está entre ["+limiteInferior+","+limiteSuperior+"]"));
    }

    /**
     * Función muestra un mensaje al usuario y que permite ingresar un dato real
     * @param mensaje Mensaje a ser mostrado al usuario
     * @return Número real ingresado por el usuario
     */    
    public static double ingresarReal(String mensaje) {
        return ingresarDato(mensaje, createCustomParser(Double::parseDouble, "El valor ingresado no es un número real"));
    }

    /**
     * Función muestra un mensaje al usuario y que permite ingresar un dato byte
     * @param mensaje Mensaje a ser mostrado al usuario
     * @return Número byte ingresado por el usuario
     */
    public static byte ingresarByte(String mensaje) {
        return ingresarDato(mensaje, createCustomParser(Byte::parseByte, "El valor ingresado no es un byte"));
    }

    /**
     * Función muestra un mensaje al usuario y que permite ingresar una fecha con el formato dd/MM/yyyy
     * @param mensaje Mensaje a ser mostrado al usuario
     * @return Número entero ingresado por el usuario
     */    
    public static LocalDate ingresarFecha(String mensaje) {
        Function<String,LocalDate> parser = texto-> LocalDate.parse(texto,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return ingresarDato(mensaje,createCustomParser(parser, "El valor ingresado no es una fecha en el formato (dd/mm/aaaa)") );
    }

    /**
     * Función muestra un mensaje al usuario y le pide que elija entre si o no
     * @param mensaje Mensaje a ser mostrado al usuario
     * @return Valor booleano seleccionado por el usuario
     */    
    public static boolean ingresarBooleano(String mensaje) {
        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, "Diálogo de confirmación",JOptionPane.YES_NO_OPTION);        
        return respuesta == JOptionPane.YES_OPTION;
    }

}
