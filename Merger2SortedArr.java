public class Merger2SortedArr {
    //optimal approach
    /*
     * time complexity: O(N+M), we traverse both the array exactly once
     * space complexity: O(1), constant extra space is used to store pointers.
     */
    // public void merge(int[] arr1,int m,int[] arr2,int n){
    //     int i = m-1;
    //     int j = n-1;
    //     int k = m+n-1;
    //     while(i>=0 && j>=0){
    //         if(arr1[i]>arr2[j]){
    //             arr1[k--] = arr1[i--];
    //         }
    //         else{
    //             arr1[k--] = arr2[j--];
    //         }
    //     }
    //     while(j>=0){
    //         arr1[k--] = arr2[j--];
    //     }
    // }

    // brute force
    /*
     * time complexity: O(N+M)+O(N+M)
     * Spce complexity: O(N+M)
     */
    // void merge(long arr1[],long arr2[],int n, int m){
    //     long[] arr3 = new long[n+m];
    //     int left = 0;
    //     int right = 0;
    //     int index = 0;
    //     while(left < n && right < m){
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
    //     while(right < m){
    //         arr3[index++] = arr2[right++];
    //     }
    //     for(int i=0; i<n+m; i++){
    //         if(i<n) arr1[i]=arr3[i];
    //         else arr2[i-n] = arr3[i];
    //     }
    // }

    // better approach
    /*
     * time complexity: O(min(n,m)) + O(N log N) + O(M log M)
     * space complexity: O(1)
     */
    // void merge(long arr1[],long arr2[],int n, int m){
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
    //     Arrays.sort(arr2,0,m);
    // }

    // 2nd optimal solution

    public void swapIfGreater(long arr1[],long arr2[],int indx1,int indx2){
        if(arr1[indx1] > arr2[indx2]){
            long temp = arr1[indx1];
            arr1[indx1] = arr2[indx2];
            arr2[indx2] = temp;
        }
    }

    public void merge(long arr1[],long arr2[],int n, int m){
        int len = m+n;
        int gap = (len/2)+(len%2);
        while(gap > 0){
            int left = 0;
            int right = left+gap;
            while(right < len){
                // arr1 and arr2
                if(left < n && right >= n){
                    swapIfGreater(arr1, arr2, left,right-n);
                }
                else if(left >= n){
                    swapIfGreater(arr1, arr2, left-n,right-n);
                }
                else{
                    swapIfGreater(arr1, arr2, left,right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (gap/2)+(gap%2);
        }
    }
    public static void main(String[] args) {
        // int arr1[] = {1,3,5,0,0,0};
        // int arr2[] = {2,4,6};
        // int m=3, n=3;
        // new Merger2SortedArr().merge(arr1, m, arr2, n);
        // for(int num:arr1){
        //     System.out.print(num+" ");
        // }
        // long arr1[] = {1,3,5};
        // long arr2[] = {2,4,6};
        // int n = arr1.length;
        // int m = arr2.length;
        // Merger2SortedArr obj = new Merger2SortedArr();
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
        // Merger2SortedArr obj = new Merger2SortedArr();
        // obj.merge(arr1, arr2, n, m);
        // for(long num:arr1){
        //     System.out.print(num+" ");
        // }
        // System.out.println();
        // for(long num:arr2){
        //     System.out.print(num+" ");
        // }
        // System.out.println();

        long arr1[] = {1,3,5};
        long arr2[] = {2,4,6};
        int n = arr1.length;
        int m = arr2.length;
        Merger2SortedArr obj = new Merger2SortedArr();
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
