public class ReverseInt {
    public static int revInt(int n){
        int revNum = 0;
        while(n!=0){
            int lastDig = n%10;
            n = n/10;
            revNum = (revNum*10)+lastDig;
        }
        return revNum;
    }
    public static void main(String[] args) {
        int n = 1235;
        System.out.println(revInt(n));
    }
}
