public class ArrRotation {
    // brute force
    /*
     * time complexity: O(N),we scan the entire array once to find the smallest
     * element where n is the size of the array
     * space complexity: O(1) We only use few extra variable to store the minimum value and its index,so the extra space used is constant
     * 
     */
    
    //  public int findRotation(int arr[]){
    //     int minVal = arr[0];
    //     int minIndex = 0;
    //     for(int i=1; i<arr.length; i++){
    //         if(arr[i] < minVal){
    //             minVal = arr[i];
    //             minIndex = i;
    //         }
    //     }
    //     return minIndex;
    //  }

    // better approach
    /*
     * time complexity: O(N) we traverse the array once to find the rotation point,
     * where n is the size of the array
     * space complexity: O(1) Only a few variables are used regardless of input size,so constant space 
     */
    
    // public int findRotation(int arr[]){
    //     for(int i=1; i<arr.length; i++){
    //         if(arr[i] > arr[i+1]){
    //             return i+1;
    //         }
    //     }
    //     return 0;
    // }

    // optimal approach
    /*
     * time complexity: O(log2 N) The binary search halves the search space each
     * iteration, where n is the size of the array
     * space complexity: O(1),Only a few variables are used regardless of the input size,so constant extra space
     */
    
    // public int findRotation(int arr[]){
    //     int low = 0;
    //     int high = arr.length-1;
    //     while(low < high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] > arr[high]){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid;
    //         }
    //     }
    //     return low;
    // }

    // brute force
    /*
     * time complexity: O(N),as we scan the entire array once to find the smallest
     * element.Where N is the size of array
     * space complexity: O(1),we only use few extra variable to store the minimum value and its index,so the extra space used is constant
     * 
     * 
     */
    // public int findRotation(int arr[]){
    //     int minVal = arr[0];
    //     int minIndex = 0;
    //     for(int i=0; i<arr.length; i++){
    //         if(arr[i] < minVal){
    //             minVal = arr[i];
    //             minIndex = i;
    //         }
    //     }
    //     return minIndex;
    // }

    // better approach
    /*
     * time complexity: O(N),we traverse the array to find the rotation point, where
     * n is the size of the array
     * space complexity: O(1),Only a few extra variables are used regardless of input size,so constant space
     */
    // public int findRotation(int arr[]){
    //     for(int i=0; i<arr.length-1; i++){
    //         if(arr[i] > arr[i+1]){
    //             return i+1;
    //         }
    //     }
    //     return 0;
    // } &&

    // optimal approach
    /*
     * time complexity: O(log2 N),The binary search halves the search space,each
     * iteration,Where N is the size of the array
     * space complexity:O(1),Only few variables are used regardless of input size,so constant extra space
     */
    public int findRotation(int arr[]){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            int mid = (low+high)/2;
            if(arr[mid] > arr[high]){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        // int arr[] = {5,6,7,1,2,3};
        // ArrRotation obj = new ArrRotation();
        // int result = obj.findRotation(arr);
        // System.out.println("The rotation of the element is: "+result);

        // int arr[] = {4,5,6,7,1,2,3};
        //  ArrRotation obj = new ArrRotation();
        // int result = obj.findRotation(arr);
        // System.out.println("The rotation of the element is: "+result);
        
        // int arr[] = {4,5,6,1,2,3};
        // ArrRotation obj = new ArrRotation();
        // int result = obj.findRotation(arr);
        // System.out.println("The rotation of the element is: "+result);

        int arr[] = {4,5,6,7,1,2,3};
        ArrRotation obj = new ArrRotation();
        int result = obj.findRotation(arr);
        System.out.println("The rotation of the element is: "+result);
    }
}
