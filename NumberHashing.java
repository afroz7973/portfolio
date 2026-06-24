
import java.util.HashMap;
import java.util.Scanner;
public class NumberHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the array: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        // precompute
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<n; i++){
            int key = arr[i];
            int freq = 0;
            if(hash.containsKey(key)) freq = hash.get(key);
            freq++;
            hash.put(key, freq);
        }
        System.out.print("Enter the query: ");
        int qr = sc.nextInt();
        while(qr-- > 0){
            int number = sc.nextInt();
            // fetch
            if(hash.containsKey(number)) System.out.println(hash.get(number));
            else System.out.println(0);
        }
    }
}
