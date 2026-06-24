

public class MajorityElement {
    //     // using brute force
    // public static int majorityEle(int[] arr){
    //     int n = arr.length;
    //     for(int i=0; i<n; i++){
    //         int count = 0;
    //         for(int j=0; j<n; j++){
    //             if(arr[j] == arr[i]){
    //                 count++;
    //             }
    //         }
    //         // check if frquency is greater than n/2:
    //         // Time Complexity: O(N2), where N = size of the given array. Reason: For every
    //         // element of the array the inner loop runs for N times. And there are N
    //         // elements in the array. So, the total time complexity is O(N2). Space
    //         // Complexity: O(1) as we use no extra space.

    //         if(count > n/2){
    //             return arr[i];
    //         }
    //     }
    //     return -1;
    // }

    // using better approach
    // using hashmap

    // public static int majorElement(int arr[]){
    //     HashMap<Integer,Integer> maps = new HashMap<>();
    //     int n = arr.length;
    //     for(int i=0; i<n; i++){
    //         int value = maps.getOrDefault(arr[i], 0);
    //         maps.put(arr[i], value+1);
    //     }
    //     for(Map.Entry<Integer,Integer> it : maps.entrySet()){
    //         if(it.getValue() > (n/2)){
    //             return it.getKey();
    //         }
    //     }
    //     return -1;
    // }

    public static int majorEle(int[] arr){
        // time complexity is: 0(N)+O(N) where N is size of the element
        // space complexity is: O(1)
        int cnt = 0 ;
        int el = 0 ;
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(cnt == 0){
                cnt = 1;
                el = arr[i];
            }
            else if(arr[i] == el){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        int cnt1 = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == el){
                cnt1++;
            }
            if(cnt1 > n/2){
                return el;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // int arr[] = {2,3,2,5,3,2,2};
        // int res = majorityEle(arr);
        // System.out.println("The majority element is: "+res);
        // int arr[] = {2,5,2,1,2,2,3};
        // int res = majorElement(arr);
        // System.out.println("The majority element is: "+res);

        int arr[] = {2,3,2,5,3,2,2};
        int res = majorEle(arr);
        System.out.println("The majority element is: "+res);
    }
}
