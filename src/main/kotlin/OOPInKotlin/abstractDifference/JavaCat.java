package OOPInKotlin.abstractDifference;

public class JavaCat extends JavaAnimal {

    public JavaCat(String species) {
        super(species, 4);
    }

    @Override
    public void move() {
        System.out.println("고양이는 네 발로 걷습니다.");
    }
}
