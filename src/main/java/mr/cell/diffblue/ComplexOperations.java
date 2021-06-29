package mr.cell.diffblue;

public class ComplexOperations {

    public String publicMethod(String parameter, boolean flag) {
        String result;
        if (flag) {
            result = privateMethod1(parameter);
        } else {
            result = privateMethod2(parameter);
        }
        return result;
    }

    private String privateMethod1(String parameter) {
        return parameter;
    }

    private String privateMethod2(String parameter) {
        return parameter + parameter;
    }
}
