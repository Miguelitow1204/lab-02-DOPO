import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase de pruebas unitarias para BabyPandas.
 * Verifica el correcto funcionamiento de las operaciones básicas
 * de definición, asignación y consulta de DataFrames.
 * 
 * @author MurilloRubiano con ayuda de Claude AI (Asistente)
 * @version 1.0
 */
public class BabyPandasTest {

    /** Instancia de BabyPandas para realizar las pruebas */
    private BabyPandas bp;

    /** Datos de prueba en formato de matriz de Strings */
    private String[][] data;

    /**
     * Configura el entorno de prueba antes de cada test.
     * Inicializa una instancia de BabyPandas y datos de prueba.
     */
    @Before
    public void setUp() {
        bp = new BabyPandas();
        data = new String[][] {
                { "Nombre", "Edad", "Profesión" }, // ← fila 0 = columnas
                { "Carlos", "35", "Profesor" },
                { "Ana", "42", "Doctor" },
                { "Jorge", "30", "Arquitecto" },
                { "Elena", "25", "Diseñador" }
        };
    }

    /**
     * Verifica que se pueda definir una variable de DataFrame correctamente.
     */
    @Test
    public void shouldDefineVariable() {
        bp.define("df1");
        assertTrue(bp.ok());
    }

    /**
     * Verifica que se puedan asignar datos a un DataFrame previamente definido.
     */
    @Test
    public void shouldAssignDataFrame() {
        bp.define("df1");
        bp.assign("df1", data);
        assertTrue(bp.ok());
    }

    /**
     * Verifica que se pueda obtener las dimensiones (shape) de un DataFrame.
     * Debe retornar un arreglo con [filas, columnas].
     */
    @Test
    public void shouldGetShape() {
        bp.define("df1");
        bp.assign("df1", data);
        assertArrayEquals(new int[] { 4, 3 }, bp.shape("df1"));
        assertTrue(bp.ok());
    }

    /**
     * Verifica que se puedan obtener las primeras n filas de un DataFrame.
     */
    @Test
    public void shouldGetHead() {
        bp.define("df1");
        bp.assign("df1", data);
        assertNotNull(bp.head("df1", 2));
        assertTrue(bp.ok());
    }

    /**
     * Verifica que no se pueda definir una variable que ya existe.
     * Debe retornar false en ok().
     */
    @Test
    public void shouldNotDefineExistingVariable() {
        bp.define("df1");
        bp.define("df1");
        assertFalse(bp.ok());
    }

    /**
     * Verifica que no se puedan asignar datos a una variable no definida.
     * Debe retornar false en ok().
     */
    @Test
    public void shouldNotAssignToUndefinedVariable() {
        bp.assign("df1", data);
        assertFalse(bp.ok());
    }

    /**
     * Verifica que no se pueda obtener el shape de una variable no definida.
     * Debe retornar false en ok().
     */
    @Test
    public void shouldNotGetShapeOfUndefinedVariable() {
        bp.shape("df1");
        assertFalse(bp.ok());
    }

    /**
     * Verifica que no se pueda obtener el head de una variable no definida.
     * Debe retornar false en ok().
     */
    @Test
    public void shouldNotGetHeadOfUndefinedVariable() {
        bp.head("df1", 2);
        assertFalse(bp.ok());
    }

    /**
     * Limpia el entorno después de cada test.
     * Libera la instancia de BabyPandas.
     */
    @After
    public void tearDown() {
        bp = null;
    }
}