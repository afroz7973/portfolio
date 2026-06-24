
import java.util.HashSet;



public class IntersectionOfArray {
    // public static HashSet<Integer> arrayIntersection(int[] arr1,int[] arr2){
    // using optimal solution for finding intersection
    //     HashSet<Integer> set =new HashSet<>();
    //     int n1 = arr1.length;
    //     int n2 = arr2.length;
    //     int vis[] = new int[arr2.length];
    //     for(int i=0; i<n1; i++){
    //         for(int j=0; j<n2; j++){
    //             if(arr1[i] == arr2[j] && vis[j] == 0){
    //                 set.add(arr1[i]);
    //                 vis[j] = 1;
    //                 break;
    //             }
    //         }   
    //     }
    //     return set;
    // }
    // using optimal solution

    public static HashSet<Integer> intersections (int arr1[],int arr2[],int n,int m){
        HashSet<Integer> sets = new HashSet<>();
        int i=0;
        int j=0;
        while(i < n && j < m){
            if(arr1[i] < arr2[j]){
                i++;
            }
            else if(arr2[j] < arr1[i]){
                j++;
            }
            else{
                sets.add(arr1[i]);
                i++; 
                j++;
            }
        }
        return sets;
    }
    public static void main(String[] args) {
        // int arr1[] = {1,2,3,4,5,6,7};
        // int n1 = arr1.length;
        // int arr2[] = {2,3,4,5,6,7,8};
        // int n2 = arr2.length;
        // HashSet<Integer> set = arrayIntersection(arr1, arr2);
        // System.out.print("Intersection of arr1 and arr2 is: ");
        // for(int num : set){
        //     System.out.print(num+" ");
        // }
        // System.out.println();
        int arr1[] = {1,2,3,4,5,6,7,8};
        int n1 = arr1.length;
        int arr2[] = {2,4,5,6,7,8,10};
        int n2 = arr2.length;

        HashSet<Integer> sets = intersections(arr1, arr2, n2, n2);
        System.out.print("Intersection of array1 and array2 is: ");
        for(int num : sets){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
