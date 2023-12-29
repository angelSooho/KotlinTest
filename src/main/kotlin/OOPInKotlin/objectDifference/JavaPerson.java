package OOPInKotlin.objectDifference;

import org.example.OOPInKotlin.objectDifference.KotlinPerson;
import org.example.OOPInKotlin.objectDifference.KotlinPersonKt;

public class JavaPerson {

    private static final int MIN_AGE = 1;

    public static JavaPerson newBaby(String name) {
        return new JavaPerson(name, MIN_AGE);
    }

    private String name;

    private int age;

    private JavaPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        KotlinPerson.Companion.newBaby("John");
        // Companion 객체에 이름이 있었다면 ex)객체 이름 Factory
        // KotlinPerson.Factory.newBaby("John");
        // 기본적으로는 Companion 객체의 이름은 생략 가능
        // Companion 객체의 이름을 생략하고 싶지 않다면 @JvmStatic 어노테이션을 사용
        KotlinPerson.newBaby("John");
    }

}
