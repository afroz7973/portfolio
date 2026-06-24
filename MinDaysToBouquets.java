public class MinDaysToBouquets {
    // brute force
    /*
     * time complexity: O((max(arr[])-min(arr[])+1)*N),where {max(arr[])-> maximum
     * element of the array,min(arr[])-> minimum element of the array,N=size of the
     * array}.
     * space complexity: O(1),as we are not using any extra space to solve this problem
     */
    // public boolean isPossible(int bloomDay[],int days,int m,int k){
    //     int count = 0;
    //     int bouquets = 0;
    //     for(int bloom : bloomDay){
    //         if(bloom <= days){
    //             count++;
    //             if(count == k){
    //                 bouquets++;
    //                 count=0;
    //             }
    //         }
    //         else{
    //             count=0;
    //         }
    //     }
    //     return bouquets >= m;
    // }

    // public int minDayToMakeBouquets(int bloomDay[],int m,int k){
    //     long totalFlower = (long) m*k;
    //     if(totalFlower >= bloomDay.length){
    //         return -1;
    //     }
    //     int min = Arrays.stream(bloomDay).min().getAsInt();
    //     int max = Arrays.stream(bloomDay).max().getAsInt();
    //     for(int day=min; day<=max; day++){
    //         if(isPossible(bloomDay, day, m, k)){
    //             return day;
    //         }
    //     }
    //     return -1;
    // }

    // optimal approach

    /*
     * time complexity: O(1)O(log(max(arr[])-min(arr[])+1)*N),where {max(arr[])->
     * maximum element of the array,min(arr[]) -> minimum element of the
     * array,N=size of the array}
     * space complexity: O(h)O(1),as we are not using any extra space to solve this problem
     */
    // public boolean isPossible(int bloomDay[],int day,int m,int k){
    //     int count = 0;
    //     int bouquets = 0;
    //     for(int bloom : bloomDay){
    //         if(bloom <= day){
    //             count++;
    //             if(count == k){
    //                 bouquets++;
    //                 count=0;
    //             }
    //         }
    //         else{
    //             count = 0;
    //         }
    //     }
    //     return bouquets >= m;
    // }

    // public int minDayToMakeBouequets(int bloomDay[],int m,int k){
    //     long totalFlower = (long) m*k;
    //     if(totalFlower > bloomDay.length){
    //         return -1;
    //     }
    //     int min = Integer.MAX_VALUE;
    //     int max = Integer.MIN_VALUE;
    //     for(int bloom : bloomDay){
    //         min = Math.min(min, bloom);
    //         max = Math.max(max, bloom);
    //     }
    //     int low = min;
    //     int high = max;
    //     int ans = -1;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(isPossible(bloomDay, mid, m, k)){
    //             ans = mid;
    //             high = mid-1;
    //         }
    //         else{
    //             low = mid+1;
    //         }
    //     }
    //     return ans;
    // }

    // brute force

    /*
     * time complexity: O(max(arr[])-min(arr[])+1)*N,where max(arr[]) is the maximum
     * size of the array and min(arr[] is the minimum size of the array),N=Size of
     * the array
     * space complexity: O(1),as we are not using any extra space to solve this
     * problem
     */
    // public boolean isPossible(int bloomDay[],int days,int m,int k){
    //     int count = 0;
    //     int bouquets = 0;
    //      for(int bloom : bloomDay){
    //         if(bloom <= days){
    //             count++;
    //             if(count == k){
    //                 bouquets++;
    //                 count=0;
    //             }
    //         }
    //         else{
    //             count = 0;
    //         }
    //     }
    //     return bouquets >= m;
    // }

    // public int minDayToMakeBouquets(int bloomDay[],int m,int k){
    //     long totalFlower = (long) m*k;
    //     if(totalFlower >= bloomDay.length){
    //         return -1;
    //     }
    //     int min = Arrays.stream(bloomDay).min().getAsInt();
    //     int max = Arrays.stream(bloomDay).max().getAsInt();

    //     for(int day=min; day<=max; day++){
    //         if(isPossible(bloomDay, day, m, k)){
    //             return day;
    //         }
    //     }
    //     return -1;
    // }

    // optimal approach

    /*
     * time complexity: O(h)O(log(max(arr[])-min(arr[])+1)*N),where max(arr[])-> is
     * the maximum size of the array and min(arr[])-> is the minimum size of the
     * array.N=Size of the array.
     * space complexity: O(h)O(1) As we are not using any extra space to solve this problem
     */
    public boolean isPossible(int bloomDay[],int day,int m,int k){
        int count = 0;
        int bouquets = 0;
        for(int bloom : bloomDay){
            if(bloom <= day){
                count++;
                if(count == k){
                    bouquets++;
                    count = 0;
                }
            }
            else{
                count = 0;
            }
        }
        return bouquets >= m;
    }

    public int minDayToMakeBouquets(int bloomDay[],int m,int k){
        long required = (long) m*k;
        if(required > bloomDay.length){
            return -1;
        }
        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        for(int bloom : bloomDay){
            minDay = Math.min(minDay, bloom);
            maxDay = Math.max(maxDay, bloom);
        }
        int low = minDay;
        int high = maxDay;
        int ans = -1;
        while(low <= high){
            int mid = (low+high)/2;
            if(isPossible(bloomDay, mid, m, k)){
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
        int bloomDay[] = { 7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        MinDaysToBouquets obj = new MinDaysToBouquets();
        int result = obj.minDayToMakeBouquets(bloomDay, m, k);
        if(result == -1){
            System.out.println("We are not able to make flowers.");
        }
        else{
            System.out.println("We can make bouquets on day: "+result);
        }
    }
}
