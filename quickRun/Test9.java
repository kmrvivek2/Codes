package quickRun;

public class Test9 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        printSubArray(s);
    }

    private static void printSubArray(String s) {
        int p1 = 0, p2 = 0;

        for(int i = p1; i < s.length();i++){
            for(int j = i+1;j<= 1;j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    ++p1;
                    break;
                } else {
                    ++p2;
                }
            }
        }

        System.out.println("SubArray :"+s.substring(p1, p2) + " Length :"+(p2-p1));
    }
}
