
public class MedianOfTwoDiffArray {
    // brute force
    /*
     * time complexity: O(N1+N2),every element of both array is visited once
     * space complexity: O(N1+N2),To store the merged array
     */
    // public double medianOfTwoArr(int num1[],int num2[]){
    // List<Integer> merged = new ArrayList<>();
    // int i = 0;
    // int j = 0;
    // while(i < num1.length && j < num2.length){
    // if(num1[i] < num2[j]){
    // merged.add(num1[i++]);
    // }
    // else{
    // merged.add(num2[j++]);
    // }
    // }
    // while(i < num1.length){
    // merged.add(num1[i++]);
    // }
    // while(j < num2.length){
    // merged.add(num2[j++]);
    // }
    // int n = merged.size();
    // if(n % 2 == 1){
    // return merged.get(n/2);
    // }
    // return (merged.get(n/2-1)+merged.get(n/2))/2.0;
    // }

    // better approach

    /*
     * time complexity: O(N1+N2),every element of both arrray is visited once
     * space complexity: O(N1+N2),constant extra space is used
     */

    // public double medianOfTwoArr(int arr1[],int arr2[]){
    // int n1 = arr1.length;
    // int n2 = arr2.length;
    // int n = n1+n2;
    // int i=0;
    // int j=0;
    // int count=0;
    // int ind2 = n/2;
    // int ind1 = ind2-1;
    // int ind1el = -1;
    // int ind2el = -1;
    // while(i < n1 && j < n2){
    // if(arr1[i] < arr2[j]){
    // if(count == ind1) ind1el=arr1[i];
    // if(count == ind2) ind2el=arr1[i];
    // i++;
    // }
    // else{
    // if(count == ind1) ind1el=arr2[j];
    // if(count == ind2) ind2el=arr2[j];
    // j++;
    // }
    // count++;
    // }
    // while(i < n1){
    // if(count == ind1) ind1el=arr1[i];
    // if(count == ind2) ind2el=arr1[i];
    // count++;
    // i++;
    // }
    // while(j < n2){
    // if(count == ind1) ind2el=arr2[j];
    // if(count == ind2) ind2el=arr2[j];
    // count++;
    // j++;
    // }
    // if(n%2 == 1){
    // return (double) ind2el;
    // }
    // return (ind1el+ind2el)/2.0;
    // }

    // optimal approach

    /*
     * time complexity: O(log(min(n1,n2))) we are applying binary search on the
     * range [0,min(n1,n2)].
     * space complexity: O(1) constant variables are used
     */
    public double medianOfTwoArr(int num1[],int num2[]){
        if(num1.length > num2.length) return medianOfTwoArr(num2, num1);
        int n1 = num1.length;
        int n2 = num2.length;
        int low = 0;
        int high = n1;
        while(low <= high){
            int mid1 = (low+high)/2;
            int mid2 = (n1+n2+1)/2-mid1;
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE:num1[mid1-1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE:num2[mid2-1];
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE:num1[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE:num2[mid2];
            if(l1 <= r2 && l2 <= r1){
                if(n1+n2 % 2 == 0) return
                 Math.max(l1, l2)+Math.min(r1, r2)/2.0;
                 else  return Math.max(l1, l2);
            }
            else if(l1 > r2){
                high = mid1-1;
            }
            else{
                low = mid1+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr1[] = { 2, 3, 5, 7 }; // 1 2 3 4 5 6 7
        int arr2[] = { 1, 4, 6 };
        MedianOfTwoDiffArray obj = new MedianOfTwoDiffArray();
        double result = obj.medianOfTwoArr(arr1, arr2);
        System.out.println("The median of the arrays is: " + result);
    }
}
