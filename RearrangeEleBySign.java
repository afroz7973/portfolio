
import java.util.ArrayList;
import java.util.Arrays;


public class RearrangeEleBySign {
    // using brute force
    // time complexityO(N+N/2)
    // public static int[] ArrangeBySign(int arr[],int n){
    //     ArrayList<Integer> posIndex = new ArrayList<>();
    //     ArrayList<Integer> negIndex = new ArrayList<>();
    //     for(int i=0; i<n; i++){
    //         if(arr[i] > 0) posIndex.add(arr[i]);
    //         else negIndex.add(arr[i]);
    //     }
    //     for(int i=0; i<n/2; i++){
    //         arr[2*i] = posIndex.get(i);
    //         arr[2*i+1] = negIndex.get(i);
    //     }
    //     return arr;
    // }

    // variant2

    public static ArrayList<Integer> ReArrangeEle(ArrayList<Integer> arr,int n){
        // Rearrange Array Elements by Sign
        // for variant 2
        // Time Complexity: O(2*N) { The worst case complexity is O(2*N) which is a
        // combination of O(N) of traversing the array to segregate into neg and pos
        // array and O(N) for adding the elements alternatively to the main array}.

        //// Define 2 ArrayLists, one for storing positive
        // and other for negative elements of the array.

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Segregate the array into positives and negatives.
        for(int i=0; i<n; i++){
            if(arr.get(i) > 0){
                pos.add(arr.get(i));
            }
            else{
                neg.add(arr.get(i));
            }
            
        }

        // If positives are lesser than the negatives.

        if(pos.size() < neg.size()){
            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for(int i=0; i<pos.size(); i++){
                arr.set(2*i, pos.get(i));
                arr.set(2*i+1, pos.get(i));
            }
            int index = pos.size()*2;
            for(int i=pos.size(); i<neg.size(); i++){
                arr.set(index, neg.get(i));
                index++;
            } 
        }
        else{
            for(int i=0; i<neg.size(); i++){
                arr.set(2*i, pos.get(i));
                arr.set(2*i+1, neg.get(i));
            }
            int index = neg.size()*2;
            for(int i=neg.size(); i<pos.size(); i++){
                arr.set(index, pos.get(i));
                index++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        // int n = 4;
        // int arr[] = {2,3,-4,-6};
        // int[] ans = ArrangeBySign(arr, n);
        // for(int i=0; i<n; i++){
        //     System.out.print(ans[i]+" ");
        // }
        int n = 6;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,-4,-5,3,4));
        ArrayList<Integer> ans = ReArrangeEle(arr, n);
        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }

    }
}
