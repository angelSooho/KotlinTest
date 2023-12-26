package changeToKotlin.typeDifference;

import domain.Person;

public class inJava {

    public static void main(String[] args) {
    }

    public static void printAgeIfPerson(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            System.out.println(person.getAge());
        }
    }
}
