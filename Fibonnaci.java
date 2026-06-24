
import java.util.Scanner;



public class Fibonnaci {
    public static int Fibo(int n){
        if(n <= 1){
            return n;
        }
        int last = Fibo(n-1);
        int slast = Fibo(n-2);
        return last+slast;
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the number: ");
        // int n = sc.nextInt();
        // System.out.println(Fibo(n));

        // int n = 6;
        // System.out.println(Fibo(n));
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        System.out.println(Fibo(n));

    }
}
