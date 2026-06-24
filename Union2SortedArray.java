
import java.util.ArrayList;

public class Union2SortedArray {
    // public static ArrayList<Integer> findUnion(int[] arr1,int[] arr2,int n, int
    // m){
    // HashSet<Integer>set = new HashSet<>();
    // ArrayList<Integer> union = new ArrayList<>();
    // for(int i=0; i<n; i++){
    // set.add(arr1[i]);
    // }
    // for(int i=0; i<m; i++){
    // set.add(arr2[i]);
    // }
    // for (int it : set) {
    // union.add(it);
    // }
    // return union;
    // }

    // using two pointers
    // Time Complexity: O(m+n), Because at max i runs for n times and j runs for m
    // times. When there are no common elements in arr1 and arr2 and all elements in
    // arr1, arr2 are distinct.
    public static ArrayList<Integer> unionFind(int arr1[], int arr2[], int n, int m) {
        int i = 0; // pointer
        int j = 0;
        ArrayList<Integer> Union = new ArrayList<>(); // union arraylist
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) { // case 1 and 2
                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
            } else { // case 3
                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr2[j])
                    Union.add(arr2[j]);
                j++;
            }
        }
        while (i < n) { // if any element left in arr1
            if (Union.get(Union.size() - 1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }
        while (j < m) { // if any element left in arr2
            if (Union.get(Union.size() - 1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }
        return Union;
    }

    public static void main(String[] args) {
        // int arr1[] = {1,2,3,4,5,8,9,6};
        // int n = arr1.length;
        // int arr2[] = {5,2,6,4,9,1,10,15};
        // int m = arr2.length;
        // ArrayList<Integer> union = findUnion(arr1, arr2, n, m);
        // System.out.print("Union of two array is: ");
        // for(int val: union)

        // System.out.print(val+" ");
        int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int n = arr1.length;
        int arr2[] = { 2, 5, 6, 8, 11, 22 };
        int m = arr2.length;
        ArrayList<Integer> Union = unionFind(arr1, arr2, n, m);
        System.out.print("Union of arr1 and arr2 is: ");
        for (int val : Union)
            System.out.print(val + " ");
    }
}
