//Problem 2.	Enter Numbers
package H_ExceptionsAndErrorHandling;

public class SquareRoot {
    public static void main(String[] args) {

        try {
            sqrt(-1);

        } catch (IllegalArgumentException ex) {

            System.err.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            System.out.println("Good bye");
        }
    }

    private static double sqrt(double value) throws IllegalArgumentException{
        if (value < 0)
            throw new IllegalArgumentException("Sqrt for negative numbers is undefined!");

        return Math.sqrt(value);
    }
}
