import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String[] sarr = s.split("-");

        for (int i = 0; i < sarr.length; i++) {
            System.out.print(sarr[i].charAt(0));
        }
    }
}
