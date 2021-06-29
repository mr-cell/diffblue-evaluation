package mr.cell.diffblue;

public class Calculator {

    private Calculator() {

    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double min(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Illegal operand: " + b);
        }
        return a - b;
    }

    public static double div(double a, double b) {
        return a / b;
    }

    public static double mul(double a, double b) {
        return a * b;
    }
}
