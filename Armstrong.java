public class Armstrong {
    public static void narcissistNum(int n){
        int dup = n;
        int len = String.valueOf(n).length();
        int sum = 0;
        while(n>0){
            int lastDig = n%10;
            sum += Math.pow(lastDig, len);
            n = n/10;
        }
        if(sum == dup){
            System.out.println("This is an Armstrong.");
        }
        else{
            System.out.println("This is not Armstrong.");
        }
    }
    public static void main(String[] args) {
        int n=944;
        narcissistNum(n);
    }
}
