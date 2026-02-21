public class DataFrame {

    private String[][] data; // Matriz que almacena todos los valores de la tabla.
    private String[] columns; // Para guardar los Titulos de las columnas.
    private int rows;
    private int cols;

    /**
     * Constructor que crea un DataFrame con los datos y columnas especificados.
     * Solo se almacenan las filas válidas que coincidan con el número de columnas.
     * 
     * @param data    Matriz de datos con las filas y valores a almacenar
     * @param columns Array con los nombres de las columnas del DataFrame
     * @author Murillo-Rubiano
     */
    public DataFrame(String[][] data, String[] columns) {
        this.columns = columns;
        this.cols = columns.length;

        // Contamos las filas validas
        int validRows = 0;
        for (String[] row : data) {
            if (row.length == cols)
                validRows++;
        }

        // Guardamos solo las filas validas
        this.data = new String[validRows][cols];
        int index = 0;
        for (String[] row : data) {
            if (row.length == cols) {
                this.data[index] = row;
                index++;
            }
        }
        this.rows = validRows;
    }

    public DataFrame loc(int[] rows, String columns) {
        return null;
    }

    public DataFrame select(String[] values) {
        return null;
    }

    public DataFrame concat(DataFrame[] dfs, byte axis) {
        return null;
    }

    /**
     * Devuelve las dimensiones del DataFrame.
     * 
     * @return Array de enteros donde el primer elemento es el número de filas
     *         y el segundo es el número de columnas
     * @author Murillo-Rubiano
     */
    public int[] shape() {
        return new int[] { rows, cols };
    }

    // The columns are aligned, separated by three spaces, and include the index.
    // Nombre Edad Profesion
    // 0 Lucía 28 Ingeniero
    // 1 Carlos 35 Profesor
    // 2 Ana 42 Doctor
    // 3 Jorge 30 Arquitecto
    // 4 Elena 25 Diseñador
    /**
     * Devuelve una representación en cadena de las primeras n filas del DataFrame.
     * Las columnas están alineadas y separadas por espacios, e incluyen el índice.
     * 
     * Ejemplo de formato:
     * Nombre Edad Profesion
     * 0 Lucía 28 Ingeniero
     * 1 Carlos 35 Profesor
     * 
     * @param rows Número de filas a mostrar desde el inicio del DataFrame
     * @return String formateado con los encabezados y las filas solicitadas
     * @author Murillo-Rubiano
     */
    public String head(int rows) {
        StringBuilder sb = new StringBuilder();

        // Imprimir encabezados
        sb.append("   ");
        for (String col : columns) {
            sb.append(String.format("%10s", col));
        }
        sb.append("\n");

        // Imprimir filas
        int limit = Math.min(rows, this.rows);
        for (int i = 0; i < limit; i++) {
            sb.append(String.format("%3d", i));
            for (String val : data[i]) {
                sb.append(String.format("%10s", val));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Compara este DataFrame con otro DataFrame para verificar si son iguales.
     * Dos DataFrames son iguales si tienen las mismas dimensiones y todos sus
     * elementos en las mismas posiciones son iguales.
     * 
     * @param df DataFrame a comparar con este DataFrame
     * @return true si los DataFrames son iguales, false en caso contrario
     * @author Murillo-Rubiano
     */
    public boolean equals(DataFrame df) {
        if (this.rows != df.rows || this.cols != df.cols)
            return false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!this.data[i][j].equals(df.data[i][j]))
                    return false;
            }
        }
        return true;
    }

    /**
     * Compara este DataFrame con otro objeto.
     * Sobrescribe el método equals de Object para permitir comparaciones con
     * cualquier objeto.
     * 
     * @param o Objeto a comparar con este DataFrame
     * @return true si el objeto es un DataFrame igual a este, false en caso
     *         contrario
     * @author Murillo-Rubiano
     */
    public boolean equals(Object o) {
        return equals((DataFrame) o);
    }
}
