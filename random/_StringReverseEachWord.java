package random;

import java.util.Arrays;

public class _StringReverseEachWord {

    public static void main(String []args){
        String str = "My name is John";
        System.out.println("Original String:\n"+str);
        withoutUsingLambdaExpression(str);
        usingLambdaExpression(str);
    }

    public static void withoutUsingLambdaExpression(String str){
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            result.append(words[i]);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        str = result.toString();
        System.out.println("Without using Lambda Expression:\n"+str);
    }

    public static void usingLambdaExpression(String str){
        str = Arrays.stream(str.split(" "))
                .map(s -> new StringBuilder(s).reverse().toString())
                .reduce((s1, s2) -> s1 + " " + s2)
                .get();

        System.out.println("Using Lambda Expression:\n"+str);
    }
}
