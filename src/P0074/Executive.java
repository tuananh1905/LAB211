/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0074;

public class Executive implements Calculate {

    @Override
    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        if(matrix1.length != matrix2.length ||  matrix1[0].length != matrix2[0].length){
            return null;
        } 
        int row = matrix1.length;
        int column = matrix1[0].length;
        int[][] result = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    @Override
    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        if(matrix1.length != matrix2.length ||  matrix1[0].length != matrix2[0].length){
            return null;
        }
        int row = matrix1.length;
        int column = matrix1[0].length;
        int[][] result = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
//column matrix 1 = row matrix 2
    @Override
    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        if(matrix1[0].length != matrix2.length){
            return null;
        }
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
}
