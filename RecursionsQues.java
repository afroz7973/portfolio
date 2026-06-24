
import java.util.Scanner;
public class RecursionsQues {
    	
// Print 1 to N using recursion

    // public static void OnetoN(int i, int n){
    //     if(i>n) return;
    //     System.out.println(i);
    //     OnetoN(i+1, n);
    // }

    
// Print N to 1 using recursion
    // public static void NtoOne(int i, int n){
    //     if(i<1) return;
    //     System.out.println(i);
    //     NtoOne(i-1, n);
    // }
    // // Print 1 to N using backtracking
    public static void NusingBacktrack(int i, int n){
        if(i<1) return;
        // NusingBacktrack(i - 1, n); // 1 to n using backtack recursion first

        System.out.println(i); // later print  and same print first 
        NusingBacktrack(i-1, n); // n to 1 using backtack recursion later
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the number of times you want to print: ");
        // int n = sc.nextInt();
        // OnetoN(1, n);

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the number of times you want to print: ");
        // int n = sc.nextInt();
        // NtoOne(n, n);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of times you want to print: ");
        int n = sc.nextInt();
        NusingBacktrack(n, n);
    }
}
