package edu.lemon.matrixmult;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class MatrixMultMultiThread implements Matrix {

    Logger logger = Logger.getLogger(Matrix.class.getName());
    public int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int n = matrixA.length;
        int[][] result = new int[n][n];

        ExecutorService executorService = Executors.newFixedThreadPool(8);

        for (int i = 0; i < n; i++) {
            final int row = i;
            executorService.submit(() -> {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        result[row][j] += matrixA[row][k] * matrixB[k][j];
                    }
                }
            });
        }
        executorService.shutdown();

        while (!executorService.isTerminated()){
            logger.info(String.valueOf(executorService.isTerminated()));
        }

        return result;
    }
}

