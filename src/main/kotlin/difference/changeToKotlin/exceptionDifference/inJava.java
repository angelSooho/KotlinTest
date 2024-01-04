package difference.changeToKotlin.exceptionDifference;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class inJava {

    public static void main(String[] args) throws IOException {
        inJava inJava = new inJava();
        int result = inJava.parseIntOrThrow("123");
        System.out.println(result);
        inJava.readFile();
        inJava.readFile("a.txt");
    }

    private int parseIntOrThrow(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("주어진 %s는 숫자가 아닙니다.", str));
        }
    }

    public void readFile() throws IOException {
        File currentFile = new File(".");
        File file = new File(currentFile.getAbsolutePath() + "/a.txt");
        BufferedReader bf = new BufferedReader(new FileReader(file));
        System.out.println(bf.readLine());
        bf.close();
    }

    public void readFile(String path) throws IOException {
        try (BufferedReader bf = new BufferedReader((new FileReader(path)))) {
            System.out.println(bf.readLine());
        }
    }
}
