package random;

/*
i)return -1 if all the character are repeating
ii)return " " if null string passed
iii) Output-0 ,The 0 should be return as a character
(iv) Array of Strings with same and additional inputs.
 */

import java.util.Arrays;
import java.util.stream.IntStream;

public class _findFirstNonReapetingChar {

    public static void main(String []args){
        String s ="apple";
        System.out.println("First non-repeating char in string: "+s+" is: "+findFirstNonReapetingCharWithoutStream(s));

        s = "papayazapmnapz";
        System.out.println("First non-repeating char in string: "+s+" is: "+findFirstNonReapetingCharWithoutStream(s));
        System.out.println("First non-repeating char in string: "+s+" is: "+findFirstNonReapetingCharWithStream(s));
    }

    public static char findFirstNonReapetingCharWithoutStream(String s){
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(s.indexOf(c) == s.lastIndexOf(c)){
                return c;
            }
        }
        return ' ';
    }

    public static char findFirstNonReapetingCharWithStream(String s){
        return IntStream.range(0, s.length())
                .mapToObj(s::charAt)
                .filter(c -> s.indexOf(c) == s.lastIndexOf(c))
                .findFirst()
                .orElse(' ');
    }
}
