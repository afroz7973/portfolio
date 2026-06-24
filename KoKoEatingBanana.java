import java.util.Arrays;

public class KoKoEatingBanana {
    // brute force
    /*
     * Time Complexity: O(n * max(arr[])), since for each possible speed we go
     * through
     * all the piles.
     * Space Complexity: O(1), since the algorithm does not use any additional space
     * or data structures.
     */
    // public int calculateTotalHour(int arr[], int hourly) {
    // int totalHours = 0;
    // for (int pile : arr) {
    // totalHours += (int) Math.ceil((double) pile / hourly);
    // }
    // return totalHours;
    // }

    // public int minEatingSpeed(int arr[],int speed){
    // int maxVal = Arrays.stream(arr).max().getAsInt();
    // for(int i=1; i<=maxVal; i++){
    // int hours = calculateTotalHour(arr, i);
    // if(hours <= speed){
    // return i;
    // }
    // }
    // return maxVal;
    // }

    // optimal approach
    /*
     * time complexity: O(N*log(max(arr[]))),we apply binary search on our search
     * space to reduce it into half at every step
     * space complexity: O(1),since the does not using any additional space or data
     * structure
     */

    public int calculateTotalHours(int arr[],int hourly){
        int totalH = 0;
        for(int banana : arr){
            totalH += (int) Math.ceil((double) banana/hourly);
        }
        return totalH;
    }

    public int minEatingSpeed(int arr[],int speed){
        int maxPiles = Arrays.stream(arr).max().getAsInt();
        int low = 1;
        int high = maxPiles;
        int ans = maxPiles;
        while(low <= high){
            int mid = (low+high)/2;
            int totalH = calculateTotalHours(arr, mid);
            if(totalH <= speed){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = { 7, 15, 6, 3 };
        int speed = 8;
        KoKoEatingBanana obj = new KoKoEatingBanana();
        int result = obj.minEatingSpeed(arr, speed);
        System.out.println("The minimum speed of eating banana hourly is: " + result);
    }
}
