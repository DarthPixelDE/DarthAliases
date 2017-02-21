
import org.junit.*;

/**
 * Eine JUnit4 Test Klasse, in NetBeans via "Test File" ausfuehren.
 *
 * @author Benedikt Nordhoff
 */
public class HelloWorldTest {

    HelloWorld deepThought;

    @BeforeClass
    // Wird vor dem ersten Test dieser Klasse ausgefuehrt.
    public static void setUpClass() throws Exception {
        System.out.println("Baue Computer zur berechnung der Antwort.");
    }

    @AfterClass
    // Wird nach dem letzten Test dieser Klasse ausgefuehrt.
    public static void tearDownClass() throws Exception {
        System.out.println("Baue Erde.");
    }

    @Before
    // Wird vor jedem Test dieser Klasse ausgefuehrt.
    public void setUp() {
        System.out.println("Starte Computer.");
        deepThought = new HelloWorld();
    }

    @After
    // Wird nach jedem Test dieser Klasse ausgefuehrt.
    public void tearDown() {
        System.out.println("Sad.");
        deepThought = null;
    }


    /* ------------ Tests ---------------- */
    @Test
    public void testAnswer() {
        Assert.assertEquals(
                "Die Korrekte Antwort wird berechnet.",
                42,
                deepThought.answer()
        );
    }

}
