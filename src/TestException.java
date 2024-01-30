import org.jetbrains.annotations.NotNull;

public class TestException {
    static int DEFAULT = 45;
    public static void main(@org.jetbrains.annotations.NotNull String @NotNull [] args) {
        int n = DEFAULT;
        try {
            n = Integer.parseInt(args[0]);
            if (n < 0) {
                System.out.println("n must  be positive ");
                n = DEFAULT;
            }

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("no argument is specified for n. Using Default");
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer argument. Using default");
        }
        System.out.println("n = " + n);
    }
}
