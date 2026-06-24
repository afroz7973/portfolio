public class RecursionBasics {
    static int count = 0;
    public static void recFunc(){
        // base case
        if(count == 3) return;
        System.out.println(count);
        // count incremented
        count = count+1;
        recFunc();
    }
    public static void main(String[] args) {
        recFunc();
    }
}
