package random;

import java.util.Scanner;

public class _MatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row :");
        int row = sc.nextInt();
        System.out.println("Enter column :");
        int column = sc.nextInt();

        int [][]arr = new int[row][column];
        for(int r = 0;r<row;r++){
            for(int c=0;c<column;c++){
                arr[r][c] = sc.nextInt();
            }
        }

        printMatrix(arr, "Original Matrix");

        System.out.print("Operation Clockwise:");
            printClockwise(arr);
        System.out.print("Operation AntiClockwise:");
            printAntiClockwise(arr);
    }

    public static void printClockwise(int [][]arr){
        int [][]transposedMatrix = transpose(arr);
        int rowCount = transposedMatrix.length;
        int colCount = transposedMatrix[0].length;


        // Reverse each rows
        for(int i = 0;i<rowCount/2;i++){
            for(int j = 0;j<colCount;j++){
                int temp = transposedMatrix[i][j];
                transposedMatrix[i][j] = transposedMatrix[rowCount - 1 - i][j];
                transposedMatrix[rowCount - 1 - i][j] = temp;
            }
        }

        printMatrix(transposedMatrix, "Clockwise Matrix");
    }

    public static void printAntiClockwise(int [][]arr){
        int [][]transposedMatrix = transpose(arr);
        int rowCount = arr.length;
        int colCount = arr[0].length;

        // Reverse each column
        for(int i = 0;i<colCount;i++){
            for(int j = 0;j<rowCount / 2;j++){
                int temp = transposedMatrix[i][j];
                transposedMatrix[i][j] = transposedMatrix[i][rowCount - 1 - j];
                transposedMatrix[i][rowCount - 1 - j] = temp;
            }
        }
        printMatrix(transposedMatrix, "AntiClockwise Matrix");
    }

    public static int[][] transpose(int [][]arr){

        int rowCount = arr.length;
        int columnCount = arr[0].length;
        int transpose[][] = new int[columnCount][rowCount];

        for(int i = 0;i<rowCount;i++){
            for(int j = 0;j<columnCount;j++){
                transpose[j][i] = arr[i][j];
            }
        }

        printMatrix(transpose, "Transpose Matrix");
        return transpose;
    }

    public static void printMatrix(int [][]arr, String heading){
        System.out.println("\n"+heading+":");
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}