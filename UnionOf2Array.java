
import java.util.ArrayList;
import java.util.HashMap;

public class UnionOf2Array {
    public static ArrayList<Integer> FindUnion(int[] arr1, int[] arr2, int n, int m) {
        // Time Compleixty : O( (m+n)log(m+n) ) . Inserting a key in map takes logN
        // times, where N is no of elements in map. At max map can store m+n elements
        // {when there are no common elements and elements in arr,arr2 are distntict}.
        // So Inserting m+n th element takes log(m+n) time. Upon approximation across
        // insertion of all elements in worst it would take O((m+n)log(m+n) time.
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> union = new ArrayList<>();
        for (int i = 0; i < n; i++)
            freq.put(arr1[i], freq.getOrDefault(arr1[i], 0) + 1);

        for (int i = 0; i < m; i++)
            freq.put(arr2[i], freq.getOrDefault(arr2[i], 0) + 1);
        for(int it : freq.keySet())
            union.add(it);
        return union;
    }

    public static void main(String[] args) {
        int n = 10,m = 7;
        int arr1[] = {2,4,5,6,1,2,8,9,7,1};
        int arr2[] = {1,5,2,4,8,9,10};
        ArrayList<Integer> union = FindUnion(arr1, arr2, n, m);
        System.out.println("Union of array1 and array2 is: ");
        for(int val : union)
        System.out.println(val+" ");
    }
}
