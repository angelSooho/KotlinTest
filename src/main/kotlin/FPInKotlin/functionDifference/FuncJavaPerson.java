package FPInKotlin.functionDifference;

public class FuncJavaPerson {

    private final String firstName;
    private final String lastName;
    private int age;

    public FuncJavaPerson(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int newYearAge() {
        System.out.println("멤버 함수");
        return this.age + 1;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }
}
