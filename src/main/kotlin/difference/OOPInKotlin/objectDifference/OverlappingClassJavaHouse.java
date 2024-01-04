package OOPInKotlin.objectDifference;

public class OverlappingClassJavaHouse {

    private String address;
    private LivingRoom livingRoom;

    public OverlappingClassJavaHouse(String address) {
        this.address = address;
        this.livingRoom = new LivingRoom(10);
    }

    // 1. 내부 클래스는 숨겨진 외부 클래스 정보를 거지고 있어,
    //    참조를 해지하지 못하는 경우 메모리 누수가 생길 수 있고,
    //    이를 디버깅하기 어렵다.
    // 2. 내부 클래스의 직렬화 형태가 명확하게 정의되지 않아,
    //    직렬화에 있어 제한이 있다.

    // Effective Java에서는 클래스 안에 클래스를 만들 때는
    // static 클래스를 사용하라고 얘기한다.
    public LivingRoom getLivingRoom() {
        return livingRoom;
    }

    public class LivingRoom {

        private double area;

        public LivingRoom(double area) {
            this.area = area;
        }

        // 내부 클래스에서는 외부 클래스의 private 필드에 접근 가능
        public String getAddress() {
            return OverlappingClassJavaHouse.this.address;
        }
    }

    public static void main(String[] args) {
        OverlappingClassJavaHouse house = new OverlappingClassJavaHouse("Seoul");
        System.out.println(house.getLivingRoom().getAddress());
    }
}
