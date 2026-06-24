public class KthEleOfSortedArr {
    // optimal approach
    /*
     * time complexity: O(log(min(M,N))), where M and N is the size of the array.As
     * binary search applied on the range [max(0,k-N2),min(k,N1)],the range length
     * <= min(M,N)
     * space complexity: O(1), no extra space is used to solve this problem
     */
    public int kthEleOfArr(int a[],int b[],int k){
        int m = a.length;
        int n = b.length;
        if(m > n) return kthEleOfArr(b, a, k);
        int low = Math.max(0, k-m);
        int high = Math.min(k, m);
        int left = k;
        while(low <= high){
            int mid1 = (low+high)/2;
            int mid2 = left-mid1;
            int l1 = (mid1 > 0) ? a[mid1-1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1 < m) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n) ? b[mid2] : Integer.MAX_VALUE;
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            }
            else if(l1 > r2){
                high = mid1-1;
            }
            else{
                low = mid1+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = { 2, 5, 6, 8 };
        int b[] = { 1, 3, 4 };
        int k = 5;
        KthEleOfSortedArr obj = new KthEleOfSortedArr();
        int result = obj.kthEleOfArr(a, b, k);
        System.out.println("The kth element is: " + result);
    }
}
