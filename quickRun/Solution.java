package quickRun;

/*
There are two wooden sticks of lengths A and B repsectively.
Each stick can be cut into multiple shorter sticks of integer lengths.
Your goal is to construct the largest possible square.

To do this, you must cut four sticks of the same length (note that there can be some leftover pieces).
What is the longest side of the square that you can achieve?

Find and fix a bug in the given implementation of a function:
class Solution {public int solution(int A, int B);}

Current solution method contains issue for some inputs need to fix the bug in the implementation. You can modify at most one line.
 */

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(10, 21));
        System.out.println(solution(13, 11));
    }

    static int countPieces(int length, int stick1, int stick2) {
        return (stick1 / length) + (stick2 / length);
    }

    static boolean canFormSquare(int length, int stick1, int stick2) {
        return countPieces(length, stick1, stick2) >= 4;
    }

    public static int solution(int A, int B) {
        for (int length = Math.min(A, B); length > 0; length--) {
            if (canFormSquare(length, A, B)) {
                return length;
            }
        }
        return 0;
    }
}
