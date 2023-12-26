package changeToKotlin.rangeDifference;

public class inJava {
    public static void main(String[] args) {

        // range 0 to 10 UP
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        System.out.println();

        // range 10 to 0 Down
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }

        System.out.println();

        // range 0 to 10 step 2
        for (int i = 1; i <= 5; i+=2) {
            System.out.println(i);
        }

        // while 1 to 3
        int i = 0;
        while(i <= 3) {
            System.out.println(i);
            i++;
        }
    }
}
