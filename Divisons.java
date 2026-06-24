import java.util.ArrayList;
import java.util.List;

public class Divisons {

    // public static void printAllDiv(int n){
    //     for(int i=1; i<=n; i++){
    //         if(n%i == 0){
    //             System.out.print(i+" ");
    //         }
    //     }
    // }
    public static List<Integer> printAllDiv(int n){
        List <Integer> division = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(n%i == 0){
                division.add(i);
            }
        }
        return division;
    }
    public static void main(String[] args) {
        // int n = 8;
        // printAllDiv(n);
        int n = 12;
        System.out.println(printAllDiv(n));
    }
}



