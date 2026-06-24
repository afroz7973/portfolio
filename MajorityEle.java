

public class MajorityEle {
    // public static int majorEle(int[] arr){
    //     // this is using brute force 
    //     // time complexity is: O(N2)
    //     int n = arr.length;
    //     for(int i=0; i<n; i++){
    //         int count = 0;
    //         for(int j=0; j<n; j++){
    //             if(arr[j] == arr[i]){
    //                 count++;
    //             }
    //         }
    //         if(count > n/2){
    //             return arr[i];
    //         }
    //     }
    //     return -1;
    // }

    // public static int maajorEle(int[] arr){
    //     HashMap<Integer,Integer> maps = new HashMap<>();
    //     int n = arr.length;
    //     for(int i=0; i<n; i++){
    //         int values = maps.getOrDefault(arr[i], 0);
    //         maps.put(arr[i], values+1);
    //     }
    //     for(Map.Entry<Integer,Integer> it : maps.entrySet()){
    //         if(it.getValue() > n/2){
    //             return it.getKey();
    //         }
    //     }
    //     return -1;
    // }

    // public static int majorElement(int arr[]){
    //     // Optimal Approach: Moore’s Voting Algorithm:

    //     int el = 0;
    //     int cnt = 0;
    //     int n = arr.length;
    //     for(int i=0; i<n; i++){
    //         if(cnt == 0){
    //             cnt = 1;
    //             el = arr[i];
    //         }
    //         else if(arr[i] == el){
    //             cnt++;
    //         }
    //         else{
    //             cnt--;
    //         }
    //     }
    //     int cnt1 = 0;
    //     for(int i=0; i<n; i++){
    //         if(arr[i] == el) cnt1++;
    //     }
    //     if(cnt1 > n/2){
    //         return el;
    //     }
    //     return -1;
    // }

    public static int majorElement(int arr[]){
        // oprtimal approach
        // using boyer moore's algorithm
        int n = arr.length;
        int el = 0;
        int cnt =0;
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
                return  el;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        // int arr[] = {2,2,1,1,2,2,3};
        // int ans = majorEle(arr);
        // System.out.println("The majority element is: "+ans);

        // int arr[] = {2,2,1,1,2,2,3};
        // int res = maajorEle(arr);
        // System.out.println("The majority element is: "+res);

        // int arr[] = {2,2,1,1,2,2,3};
        // int ans = majorElement(arr);
        // System.out.println("The majority element is: "+ans);

        int arr[] = {2,2,1,1,1,2,2,1,1};
        int res = majorElement(arr);
        System.out.println("The majority elemeny is: "+res);
    }
}
