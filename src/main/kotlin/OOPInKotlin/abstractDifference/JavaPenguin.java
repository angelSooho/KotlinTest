package OOPInKotlin.abstractDifference;

public final class JavaPenguin extends JavaAnimal {

    private final int wingCount;

    public JavaPenguin(String species, int wingCount) {
        super(species, 4);
        this.wingCount = wingCount;
    }

    @Override
    public void move() {
        System.out.println("펭귄은 두 발로 걷고, 두 날개로 헤엄칩니다.");
    }

    @Override
    public int getLegCount() {
        return super.legCount + this.wingCount;
    }
}
