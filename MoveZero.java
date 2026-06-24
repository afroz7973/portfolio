



public class MoveZero {
    // public static int[] zeroMove(int[] arr,int n){
    // this is brute force solution
    //     ArrayList<Integer> temp = new ArrayList<>();
    //     for(int i=0; i<n; i++){
    //         if(arr[i] != 0){
    //             temp.add(arr[i]);
    //         }
    //     }
    //     int nz = temp.size();
    //     for(int i=0; i<nz; i++){
    //         arr[i] = temp.get(i);
    //     }
    //     for(int i=nz; i<n; i++){
    //         arr[i] = 0;
    //     }
    //     return arr;
    // }

    // this optimal solution
    public static int[] zeroMoves(int[] arr,int n){
        int j = -1;
        for(int i=0; i<n; i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }
        if(j == -1) {
            return arr;
        }

        for(int i=j+1; i<n; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        // int arr[] = {1,2,0,3,0,4,0,2};
        // int n = arr.length;
        // zeroMove(arr, n);
        // System.out.println("Array after moving zero: ");
        // for(int i=0; i<n; i++){
        //     System.out.print(arr[i]+" ");
        // }
        int arr[] = {0,1,2,0,3,0,4,5};
        int n = arr.length;
        zeroMoves(arr, n);
        System.out.print("Array after removing zero: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        
    }
    
}
