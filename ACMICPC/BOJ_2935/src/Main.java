import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(sc.next());
        String b = sc.next();
        BigInteger c = new BigInteger(sc.next());

        if (b.equals("+"))
            System.out.println(a.add(c));
        else
            System.out.println(a.multiply(c));
    }
}
