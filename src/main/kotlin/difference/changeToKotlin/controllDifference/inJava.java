package difference.changeToKotlin.controllDifference;

public class inJava {

    public static void main(String[] args) {
        inJava inJava = new inJava();
        String str1 = inJava.validateScoreIsNotNegative(100);
        String str2 = inJava.validateScoreIsNotNegative(-1);
    }

    private String validateScoreIsNotNegative(int score) {
//        if (score < 0) {
//            throw new IllegalArgumentException(String.format("%s는 0보다 작을 수 없습니다.", score));
//        }
//        System.out.println(score);
//
        return score >= 50 ? "Pass" : "Fail";
    }

    private String getPassOrFail(int score) {
        if (score >= 50) {
            return "Pass";
        }
        return "Fail";
    }

    private String getGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        }
        return "F";
    }

    private void validate(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException(String.format("%s는 0보다 작거나 100보다 클 수 없습니다.", score));
        }
        System.out.println(score);
    }

    private boolean startWithA(Object obj) {
        if (obj instanceof String str) {
            return str.startsWith("A");
        }
        return false;
    }

    private void judgeNumber(int number) {
        if (number == 1 || number == 0 || number == -1) {
            System.out.println("1, 0, -1 중 하나입니다.");
        }
        System.out.println("1, 0, -1이 아닙니다.");
    }

    private void judgeNumber2(int number) {
        if (number == 0) {
            System.out.println("주어진 숫자는 0입니다.");
        }
        System.out.println("주어진 숫자는 0이 아닙니다.");
    }
}
