

public class Palindromes {
    // public static int palindromes(int n){
    //     int revNum = 0;
    //     int dup = n;
    //     while(n!=0){
    //         int lastDigit = n%10;
    //         revNum = (revNum*10)+lastDigit;
    //         n = n/10;
    //     }
    //     if(revNum == dup){
    //         System.out.println("true");
    //     }
    //     else{
    //         System.out.println("False");
    //     }
    //     return dup ;
    // }

    // public static void palindromeNum(){
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter the number: ");
    //     int n = sc.nextInt();
    //     int revNum = 0;
    //     int dup = n;
    //     while(n>0){
    //         int lastDig = n%10;
    //         revNum = (revNum*10)+lastDig;
    //         n = n/10;
    //     }
    //     if(revNum == dup){
    //         System.out.println("True");
    //     }
    //     else{
    //         System.out.println("False");
    //     }
        
    // }

    public static boolean isPalindrome(int n){
        int revNum = 0;
        int duplicate = n;
        while(n>0){
            int lastDig = n%10;
            revNum = (revNum*10)+lastDig;
            n = n/10;
        }
        if(revNum == duplicate){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        return  revNum == duplicate;
        
    }
    public static void main(String[] args) {
        // int n = 121;
        // palindromeNum();
        int n = 121;
        isPalindrome(n);
    }
}
