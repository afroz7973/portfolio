
import java.util.Scanner;

public class Palindrome {
    public static boolean palindromCheck(int i, String s){
        if(i >= s.length()/2) return true;
        if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        return palindromCheck(i+1, s);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.nextLine();
        System.out.println(palindromCheck(0, str));
    }
}
