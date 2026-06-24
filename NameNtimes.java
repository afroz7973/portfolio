
import java.util.Scanner;
public class NameNtimes {
    public static void nTimeName(int i, int n) {
        if (i > n)
            return;
        System.out.println("afrozz");
        nTimeName(i+1, n);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        nTimeName(1, n);
    }
}
