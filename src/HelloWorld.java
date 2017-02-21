
/**
 *
 * Gibt die Antwort auf die Frage nach dem Leben, dem Universum und dem ganzen Rest.
 *
 * @author Benedikt Nordhoff
 *
 * @inv True
 *
 */
public class HelloWorld {

    /**
     * Methode die die Antwort berechnet
     *
     * @return Die Antwort!
     *
     * @pre True
     * @post result = 42
     */
    public int answer() {
        return 42;
    }

    /**
     * Main-Methode
     *
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args) {
        HelloWorld deepThought = new HelloWorld();
        System.out.println("The answer is: " + deepThought.answer());
    }
}
