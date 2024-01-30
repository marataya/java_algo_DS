// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TestProgression {
    public static void main(String[] args) {
        Progression prog = new ArithmeticProgression();
        prog.printProgression(10);
        prog = new ArithmeticProgression(5);
        prog.printProgression(10);
        prog = new ArithmeticProgression(7, 8);
        prog.printProgression(10);
        prog = new GeometricProgression(3, 2);
        prog.printProgression(10);
        prog = new FibonacciProgression(1, 2);
        prog.printProgression(10);
    }
}
