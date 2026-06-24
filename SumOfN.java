
import java.util.Scanner;
public class SumOfN {
    // public static void Nsum(int i, int sum){
    //     // using parameterised function
    //     if(i<1){
    //         System.out.println(sum);
    //         return;
    //     }
    //     Nsum(i-1, sum+i);
    // }
    // using functional recursion
    public static int NsumFun(int n){
        if(n == 0) {
            return 0;
        }
        else{
            return n+NsumFun(n-1);
        }
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the number: ");
        // int n = sc.nextInt();
        // Nsum(n, 0);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        System.out.println(NsumFun(n));
    }
}
