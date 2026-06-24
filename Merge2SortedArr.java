public class Merge2SortedArr {
    // brute force
    /*
     * TIME complexity:O(M+N)+O(M+N)
     * space complexity: O(N+M)
     */
    // void merge(long arr1[],long arr2[],int n,int m){
    //     long arr3[] = new long[n+m];
    //     int left = 0;
    //     int right = 0;
    //     int index = 0;
    //     while(left<n && right<m){
    //         if(arr1[left] <= arr2[right]){
    //             arr3[index] = arr1[left];
    //             left++;
    //             index++;
    //         }
    //         else{
    //             arr3[index] = arr2[right];
    //             right++;
    //             index++;
    //         }
    //     }
    //     while(left < n){
    //         arr3[index++] = arr1[left++];
    //     }
    //     while(right<m){
    //         arr3[index++] = arr2[right++];
    //     }
    //     for(int i=0; i<n+m; i++){
    //         if(i<n)arr1[i] = arr3[i];
    //         else arr2[i-n] = arr3[i];
    //     }
    // }

    // better approach
    /*
     * time complexity: O(min(n,m)+O(n log n)+O(m log m))
     * space complexity: O(1)
    //  */
    // void merge(long arr1[],long arr2[],int n,int m){
    //     int left = n-1;
    //     int right = 0;
    //     while(left >= 0 && right < m){
    //         if(arr1[left] > arr2[right]){
    //             long temp = arr1[left];
    //             arr1[left] = arr2[right];
    //             arr2[right] = temp;
    //             left--;
    //             right++;
    //         }
    //         else{
    //             break;
    //         }
    //     }
    //     Arrays.sort(arr1,0,n);
    //     Arrays.sort(arr2,0 ,m);
    // }

    // optimal approach

    // public void merge(int nums1[],int m, int nums2[],int n){
    //     int i = m-1;
    //     int j = n-1;
    //     int k = m+n-1;
    //     while(i>=0 && j>=0){
    //         if(nums1[i] > nums2[j]){
    //             nums1[k--] = nums1[i--];
    //         }
    //         else{
    //             nums1[k--] = nums2[j--];
    //         }
    //     }
    //     while(j >= 0){
    //         nums1[k--] = nums2[j--];
    //     }
    // }

    // 2nd optimal approach

    public void swapIfGreater(long arr1[],long arr2[],int indx1,int indx2){
        if(arr1[indx1] > arr2[indx2]){
            long temp = arr1[indx1];
            arr1[indx1] = arr2[indx2];
            arr2[indx2] = temp;
        }
    }
    void merge(long arr1[],long arr2[],int n,int m){
        int len = n+m;
        int gap = (len/2)+(len%2);
        while(gap > 0){
            int left = 0;
            int right = left+gap;
            while(right < len){
                // arr1 and arr2
                if(left < n && right >=n){
                    swapIfGreater(arr1, arr2, left,right-n);
                }
                else if(left >= n){
                    swapIfGreater(arr1, arr2, left-n, right-n);
                }
                else{
                    swapIfGreater(arr1, arr2, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (gap/2)+(gap%2);
        }
    }
    public static void main(String[] args) {
        // long arr1[] = {1,3,5};
        // long arr2[] = {2,4,6};
        // int n = arr1.length;
        // int m = arr2.length;
        // Merge2SortedArr obj = new Merge2SortedArr();
        // obj.merge(arr1, arr2, n, m);
        // for(long num:arr1){
        //     System.out.print(num+" ");
        // }
        // System.out.println();
        // for(long num:arr2){
        //     System.out.print(num+" ");
        // }
        // System.out.println();

        // long arr1[] = {1,3,5};
        // long arr2[] = {2,4,6};
        // int n = arr1.length;
        // int m = arr2.length;
        // Merge2SortedArr obj = new Merge2SortedArr();
        // obj.merge(arr1, arr2, n, m);
        // for(long num:arr1){
        //     System.out.print(num+" ");
        // }
        // System.out.println();
        // for(long num:arr2){
        //     System.out.print(num+" ");
        // }
        // System.out.println();

        // int nums1[] = {1,3,5,0,0};
        // int nums2[] = {2,4,6};
        // int m = 3;
        // int n = 3;
        // new Merge2SortedArr().merge(nums1, m, nums2, n);
        // for(int num:nums1){
        //     System.out.print(num+" ");
        // }

        long arr1[] = {1,3,5};
        long arr2[] = {2,4,6};
        int m = arr1.length;
        int n = arr2.length;
        Merge2SortedArr obj = new Merge2SortedArr();
        obj.merge(arr1, arr2, n, m);
        for(long num:arr1){
            System.out.print(num+" ");
        }
        System.out.println();
        for(long num:arr2){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
