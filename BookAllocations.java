
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class BookAllocations {
    
    // brute force
    /*
     * time complexity: O(N*sum(arr[])-max(arr[])+1),where N is the size of
     * array,sum(arr[]) sum of all array element ,max(arr[]) maximum size of element
     * space complexity: O(1) as we are not using any extra space to solve this problem
     */
    // public int countStudents(ArrayList<Integer> arr,int pages){
    //     int n = arr.size();
    //     int students = 1;
    //     int pagesStudents = 0;
    //     for(int i=0; i<n; i++){
    //         if(pagesStudents + arr.get(i) <= pages){
    //             pagesStudents += arr.get(i);
    //         }
    //         else{
    //             students++;
    //             pagesStudents = arr.get(i);
    //         }
    //     }
    //     return students;
    // }

    // public int findPages(ArrayList<Integer> arr,int n,int m){
    //     if(m > n) return -1;
    //     int low = Collections.max(arr);
    //     int high = arr.stream().mapToInt(Integer::intValue).sum();
    //     for(int pages=low; pages <= high; pages++){
    //         if(countStudents(arr, pages) == m){
    //             return pages;
    //         }
    //     }
    //     return low;
    // }

    // optimal approach

   /*
    * time complexity: O(N*log(sum(arr[])-max(arr[])+1)),where N=size of the
    * array,sum(arr[]) is the sum of all array element and max(arr[])=maximum of
    * all array elemment
    * space complexity: O(1),since we are not using any extra space to solve this problem
    */

    public int countStudentss(ArrayList<Integer> arr,int pages){
        int n = arr.size();
        int studentss = 1;
        int pagesStudentss = 0;
        for(int i=0; i<n; i++){
            if(pagesStudentss + arr.get(i) <= pages){
                pagesStudentss += arr.get(i);
            }else{
                studentss++;
                pagesStudentss += arr.get(i);
            }
        }
        return studentss;
    }

    public int findPagess(ArrayList<Integer> arr,int n,int m){
        if(m > n){
            return -1;
        }
        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer:: intValue).sum();
        while(low <= high){
            int mid = (low+high)/2;
            int studentss = countStudentss(arr, mid);
            if(studentss > m){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25,46,28,49,24));
        int n = 5;
        int m = 4;
        BookAllocations obj = new BookAllocations();
        int result = obj.findPagess(arr, n, m);
        System.out.println("The answer is: "+result);

    }
}
