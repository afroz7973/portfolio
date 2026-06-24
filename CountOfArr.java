public class CountOfArr {
    public static int  countNumber(int numb ,int arr[]){
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == numb){
                count = count+1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,5,2,1,3};
        System.out.println(countNumber(0, arr));
    }
}
