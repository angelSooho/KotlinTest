package difference.changeToKotlin.functionDifference;

public class inJava {

    public static void main(String[] args) {
        inJava inJava = new inJava();
        System.out.println(inJava.max(1, 2));
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    private void repeat(String str, int num, boolean useNewLine) {
        for (int i = 1; i < num; i++) {
            if (useNewLine) {
                System.out.println(str);
            } else {
                System.out.print(str);
            }
        }
    }

    private void repeat(String str, int num) {
        repeat(str, num, false);
    }

    private void repeat(String str) {
        repeat(str, 3, false);
    }

    private void printAll(String... strs) {
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
