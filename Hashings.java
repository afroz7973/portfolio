
import java.util.Scanner;


public class Hashings {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // // Input size
        // System.out.print("Enter the size of array: ");
        // int n = sc.nextInt();
        // // Input array
        // int[] arr = new int[n];
        // System.out.println("Enter the array elements: ");
        // for (int i = 0; i < n; i++) {
        //     arr[i] = sc.nextInt();
        // }
        // // Precompute
        // int[] hash = new int[10000];
        // for (int i = 0; i < n; i++) {
        //     hash[arr[i]] += 1;
        // }
        // // Query input
        // System.out.print("Enter number of queries: ");
        // int q = sc.nextInt();

        // System.out.println("Enter the query numbers: ");
        // while (q-- != 0) {
        //     int number = sc.nextInt();
        //     // Fetching
        //     System.out.println("Frequency of " + number + " = " + hash[number]);
        // }

        // sc.close();

        // character hashing 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();
            
        // precompute
        int[] hash = new int[256];
        for(int i=0; i<str.length(); i++){
            hash[str.charAt(i) ]++;
        }
        System.out.print("Enter the queries: ");
        int q = sc.nextInt();
        while(q-- > 0){
            char c = sc.next().charAt(0);
            // fetching
            System.out.println(hash[c]);
        }
    }
}
