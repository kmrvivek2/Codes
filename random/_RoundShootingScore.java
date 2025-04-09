package random;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _RoundShootingScore {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("Enter number of targets or 0 to terminate:");
            int num = sc.nextInt();
            if(num == 0)
                break;
            System.out.println("Score :"+calScore(num));
            System.out.println("ScoreTech :"+calScoreTech(num));
        }
    }

    public static int calScore(int n){
        int result = 0;
        int count = 0;
        int initial = 1;

        while ((n-count) > 1){
            result += initial;
            count++;
            initial +=2;

            if(initial>n)
                initial = 2;
        }

        return result;
    }

    public static int calScoreTech(int n){
        int result = 0;
        int initial = 1;
        Set<Integer> set = new HashSet<>();
        for(int i=1; i<=n; i++){
            set.add(i);
        }

        while(set.size() != 1){
            result += initial;
            set.remove(initial);
            initial += 2;

            if(initial > n){
                initial = set.iterator().next();
            }
        }

        return result;
    }
}
