package P0074;

public class Manager {
    Calculate c = new Executive();
    
    public void menu() {
        while(true){
            System.out.println("=== Welcome to calculator program ===");
            System.out.println(" 1. Addiion maxtrixes.");
            System.out.println(" 2. Subtraction matrixes.");
            System.out.println(" 3. Multiplication matrixes.");
            System.out.println(" 4. Exit.");
            System.out.print(" Enter your choice: ");
            int choice = Validate.checkInputLimit(1, 4);
            switch(choice){
                case 1:
                    additionMatrix();
                    break;
                case 2:
                    subtractionMatrix();
                    break;
                case 3: 
                    multiplicationMatrix();
                    break;
                case 4:
                    return;
            }
        }
    }
    
    public int[][] inputMatrix(int n){
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
    
    public void additionMatrix(){
        System.out.println("-------- Addition --------");
        int[][] matrix1 = inputMatrix(1);
        int[][] matrix2 = inputMatrix(2);
        if(!Validate.checkMatrixSameSize(matrix1, matrix2)){
            System.err.println("\n2 matrix need to be the same size!!!\n");
        }else {
            System.out.println("-------- Result --------");
            displayMatrix(matrix1);
            System.out.println("+");
            displayMatrix(matrix2);
            System.out.println("=");
            displayMatrix(c.additionMatrix(matrix1, matrix2));
        }
    }
    
    public void subtractionMatrix(){
        System.out.println("-------- Subtraction --------");
        int[][] matrix1 = inputMatrix(1);
        int[][] matrix2 = inputMatrix(2);
        if(!Validate.checkMatrixSameSize(matrix1, matrix2)){
            System.out.println("\n2 matrix need to be the same size!!!\n");
        }else {
            System.out.println("-------- Result --------");
            displayMatrix(matrix1);
            System.out.println("-");
            displayMatrix(matrix2);
            System.out.println("=");
            displayMatrix(c.subtractionMatrix(matrix1, matrix2));
        }
    }
    
    public void multiplicationMatrix(){
        System.out.println("-------- Multiplication --------");
        int[][] matrix1 = inputMatrix(1);
        int[][] matrix2 = inputMatrix(2);
        if(Validate.checkMatrixCanMultiplication(matrix1, matrix2)){
            System.out.println("\nThe number of rows of matrix 1 must be equal to the number of columns of matrix 2!!!\n");
        }else{
            System.out.println("-------- Result --------");
            displayMatrix(matrix1);
            System.out.println("*");
            displayMatrix(matrix2);
            System.out.println("=");
            displayMatrix(c.multiplicationMatrix(matrix1, matrix2));
        }
    }
}
