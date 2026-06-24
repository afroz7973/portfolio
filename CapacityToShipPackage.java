import java.util.Arrays;

public class CapacityToShipPackage {

    // brute force
    /*
     * 
     * Time complexity: O((sum_weight-max_weight)*N),where N is the number of the
     * packages.For each capacity between max weight and total sum, we simulate
     * shipping over N packages.
     * space complexity:O(1),only constant extra space is used
     */
    // public int dayNeeded(int weight[],int capacity){
    //     int day = 1;
    //     int currentLoad = 0;
    //     for(int w : weight){
    //         if(currentLoad + w > capacity){
    //             day++;
    //             currentLoad = w;
    //         }
    //         else{
    //             currentLoad += w;
    //         }
    //     }
    //     return day;
    // }
    // public int shipWithinDays(int weight[],int d){
    //     int left = Arrays.stream(weight).max().getAsInt();
    //     int right = Arrays.stream(weight).sum();
    //     for(int capacity=left; capacity <= right; capacity++){
    //         int needed = dayNeeded(weight, capacity);
    //         if(needed <= d){
    //             return capacity;
    //         }
    //     }
    //     return right;
    // }

    // optimal approach
    /*
     * time complexity:O(N*log(s)),where N is the number of packages and s is the
     * search space (sum_weight-max_weight).each binary search step takes
     * O(N),repeated(O(log s))
     * space complexity: O(1), constant extra space is used.
     */
    public int dayNeeded(int weight[],int capacity){
        int days = 1;
        int currentLoad = 0;
        for(int w : weight){
            if(currentLoad+w > capacity){
                days++;
                currentLoad = w;
            }
            else{
                currentLoad += w;
            }
        }
        return days;
    }
    public int shipWithinDays(int weight[],int d){
        int left = Arrays.stream(weight).max().getAsInt();
        int right = Arrays.stream(weight).sum();
        while(left < right){
            int mid = left+(right-left)/2;
            int needed = dayNeeded(weight, mid);
            if(needed <= d){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int weights[] = { 5, 4, 5, 2, 3, 4, 5, 6 };
        int d = 5;
        CapacityToShipPackage obj = new CapacityToShipPackage();
        int result = obj.shipWithinDays(weights, d);
        System.out.println("The minimum capacity needed is: " + result);
    }
}
