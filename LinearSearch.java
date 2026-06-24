public class LinearSearch {
    public static int searchLinear(int[] arr,int target){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {6,7,8,4,5,9};
        int n = arr.length;
        int target = 9;
        
        System.out.println(searchLinear(arr, target));
        

    }
}
