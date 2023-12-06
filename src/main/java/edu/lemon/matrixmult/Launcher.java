package edu.lemon.matrixmult;

public class Launcher {
    public static void main(String[] args) {
        MatrixMultSingleThread matrixMultSingleThread = new MatrixMultSingleThread();
        MatrixMultMultiThread matrixMultMultiThread = new MatrixMultMultiThread();

        calculate(matrixMultMultiThread);
        calculate(matrixMultSingleThread);
    }

    private static void calculate(Matrix matrix) {
        int[][] result;
        int[][] matrixA = fillMatrixWithRandomValues(1000, 1000);
        int[][] matrixB = fillMatrixWithRandomValues(1000, 100);

        long start = System.currentTimeMillis();
        result = matrix.multiply(matrixA, matrixB);
        long end = System.currentTimeMillis();
        System.out.println("Execution time is " + (end - start));

        printMatrix(result);
    }

    private static int[][] fillMatrixWithRandomValues(int size, int range) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int)(Math.random() * range);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] result) {
        for (int[] row : result) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
