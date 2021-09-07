package P0074;

public class Manager {
    
    public static int menu() {
        System.out.println("=== Welcome to calculator program ===");
        System.out.println(" 1. Addiion maxtrixes.");
        System.out.println(" 2. Subtraction matrixes.");
        System.out.println(" 3. Multiplication matrixes.");
        System.out.println(" 4. Exit.");
        System.out.print(" Enter your choice: ");
        int choice = Validate.checkInputLimit(1, 4);
        return choice;
    }
    
    public static int[][] inputMatrix(int n){
        System.out.print("Enter row matrix "+n+": ");
        int row = Validate.checkInputInt();
        System.out.print("Enter column matrix "+n+": ");
        int column = Validate.checkInputInt();
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Enter matrix"+n+"["+i+"]"+"["+j+"]: ");
                matrix[i][j] = Validate.checkInputInt();
            }
        }
        return matrix;
    }
    
    public static void displayMatrix(int[][] matrix){
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("["+matrix[i][j]+"]");
            }
            System.out.println("");
        }
    }
    
    public static void additionMatrix(){
        System.out.println("-------- Addition --------");
        while(true){
            int[][] matrix1 = inputMatrix(1);
            int[][] matrix2 = inputMatrix(2);
            if(Validate.checkMatrixSameSize(matrix1, matrix2)){
                System.out.println("-------- Result --------");
                displayMatrix(matrix1);
                System.out.println("+");
                displayMatrix(matrix2);
                System.out.println("=");
                int row = matrix1.length;
                int column = matrix1[0].length;
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        int temp = matrix1[i][j] + matrix2[i][j];
                        System.out.print("[" + temp + "]");
                    }
                    System.out.println("");
                }
                return;
            }else {
                System.err.println("2 matrix need to be the same size.");
                System.out.println("Enter again. ");
            }
        }
    }
    
    public static void subtractionMatrix(){
        System.out.println("-------- Subtraction --------");
        while(true){
            int[][] matrix1 = inputMatrix(1);
            int[][] matrix2 = inputMatrix(2);
            if(Validate.checkMatrixSameSize(matrix1, matrix2)){
                System.out.println("-------- Result --------");
                displayMatrix(matrix1);
                System.out.println("-");
                displayMatrix(matrix2);
                System.out.println("=");
                int row = matrix1.length;
                int column = matrix1[0].length;
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        int temp = matrix1[i][j] - matrix2[i][j];
                        System.out.print("[" + temp + "]");
                    }
                    System.out.println("");
                }
                return;
            }else {
                System.err.println("2 matrix need to be the same size.");
                System.out.println("Enter again. ");
            }
        }
    }
    
    public static void multiplicationMatrix(){
        System.out.println("-------- Multiplication --------");
        while(true){
            int[][] matrix1 = inputMatrix(1);
            int[][] matrix2 = inputMatrix(2);
            if(Validate.checkMatrixCanMultiplication(matrix1, matrix2)){
                System.out.println("-------- Result --------");
                displayMatrix(matrix1);
                System.out.println("*");
                displayMatrix(matrix2);
                System.out.println("=");
                
                int[][] matrixResult = new int[matrix1.length][matrix2[0].length];
                for (int i = 0; i < matrix1.length; i++) {
                    for (int j = 0; j < matrix2[0].length; j++) {
                        for (int k = 0; k < matrix1[0].length; k++) {
                            matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                        }
                    }
                }
                displayMatrix(matrixResult);
                return;
            }else{
                System.err.println("Matrix 1 column and 2 row amount need to be the same.");
                System.out.println("Enter again.");
            }
        }
    }
}
