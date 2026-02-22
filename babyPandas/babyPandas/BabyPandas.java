import java.util.HashMap;

/**
 * BabyPandas.java
 * 
 * @author ESCUELA 2026-01
 */

public class BabyPandas {

    private HashMap<String, DataFrame> variables;
    private boolean lastOk;

    /**
     * Constructor de la clase BabyPandas.
     * Inicializa el HashMap de variables vacío y establece lastOk en false.
     * 
     * @author MurilloRubiano
     */
    public BabyPandas() {
        variables = new HashMap<String, DataFrame>();
        lastOk = false;
    }

    // Definea new variable
    /**
     * Define una nueva variable en el sistema.
     * La variable se crea sin DataFrame asignado (valor null).
     * Si la variable ya existe, la operación falla.
     * 
     * @param name el nombre de la variable a definir
     * @author MurilloRubiano
     */
    public void define(String name) {
        // pregunto si la variable No existe en el HasMap
        if (!variables.containsKey(name)) {
            variables.put(name, null);// se agrega con valor null porque aun no tiene DataFrame asignado.
            lastOk = true;
        } else {
            lastOk = false;// Registra si la operacion fue exitosa o no.
        }
    }

    // Assign a DataFrame to an existing variable
    // a := DataFrame
    /**
     * Asigna un DataFrame a una variable existente.
     * La primera fila del array se utiliza como nombres de columnas,
     * y las filas restantes como datos del DataFrame.
     * La variable debe haber sido definida previamente.
     * 
     * @param a         el nombre de la variable a la que se asignará el DataFrame
     * @param dataFrame array bidimensional donde la primera fila son los nombres de
     *                  columnas
     *                  y las demás filas son los datos
     * @author MurilloRubiano
     */
    public void assign(String a, String[][] dataFrame) {
        if (variables.containsKey(a)) {
            // toma la primera fila como columna
            String[] columns = dataFrame[0];

            // Se toman las demas filas como datos
            String[][] data = new String[dataFrame.length - 1][];
            for (int i = 0; i < data.length; i++) {
                data[i] = dataFrame[i + 1];
            }

            // Creamos el DataFrame y guardarlo
            DataFrame df = new DataFrame(data, columns);
            variables.put(a, df);
            lastOk = true;
        } else {
            lastOk = false;
        }

    }

    // Return DataFrame's shape
    public int[] shape(String a) {
        return null;
    }

    // Assigns the value of a unary operation to a variable
    // a = b op parameters
    // The operator characters are: 'r' select rows, 'c' select columns, '?' select
    // condition
    // The parameters for 'r' are [index1, index2, ...]
    // The parameters for 'c' are [column1, column2, ...]
    // The parameters for '?' are [valueColumn1, valueColumn2, ...]

    public void assignUnary(String a, String b, char op, String[] parameters) {
    }

    // Assigns the value of a binary operation to a variable
    // a = b op c
    // The operator characters are: 'r' concate by rows, 'c' concate by columns
    public void assignBinary(String a, String b, char op, String c) {
    }

    // Return some rows of the DataFrame
    public String head(String variable, int rows) {
        return null;
    }

    // If the last operation was successfully completed
    /**
     * Retorna el estado de la última operación realizada.
     * 
     * @return true si la última operación fue exitosa, false en caso contrario
     * @author MurilloRubiano
     */
    public boolean ok() {
        return lastOk;
    }
}
