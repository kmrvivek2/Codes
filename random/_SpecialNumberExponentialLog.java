package random;

import java.util.Scanner;

public class _SpecialNumberExponentialLog {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("\nCount of SpecialNumber: "+countSpecialNumber(num));
    }

    public static int countSpecialNumber(int num){
        int count = 0;
        for(int i=1; i<=num; i++){
            if(!isSpecialNumber(i)){
                System.out.print(i+" ");
                count++;
            }
        }

        return count;
    }

    public static boolean isSpecialNumber(int num){
        if (num <= 1) {
            return false;
        }

        for (int base = 2; base <= Math.sqrt(num); base++) {
            double exponent = Math.log(num) / Math.log(base);
            if (exponent == (int) exponent) {
                return true;
            }
        }
        return false;
    }
}