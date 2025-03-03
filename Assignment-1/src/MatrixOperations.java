import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input for first matrix
        System.out.print("Enter rows and columns for Matrix 1: ");
        int rows1 = scanner.nextInt();
        int cols1 = scanner.nextInt();
        int[][] matrix1 = new int[rows1][cols1];
        System.out.println("Enter elements of Matrix 1:");
        inputMatrix(scanner, matrix1);
        
        // Input for second matrix
        System.out.print("Enter rows and columns for Matrix 2: ");
        int rows2 = scanner.nextInt();
        int cols2 = scanner.nextInt();
        int[][] matrix2 = new int[rows2][cols2];
        System.out.println("Enter elements of Matrix 2:");
        inputMatrix(scanner, matrix2);
        
        scanner.close();
        
        // Perform Addition
        if (rows1 == rows2 && cols1 == cols2) {
            System.out.println("Addition:");
            printMatrix(addMatrices(matrix1, matrix2));
        } else {
            System.out.println("Addition not possible due to dimension mismatch.");
        }
        
        // Perform Subtraction
        if (rows1 == rows2 && cols1 == cols2) {
            System.out.println("Subtraction:");
            printMatrix(subtractMatrices(matrix1, matrix2));
        } else {
            System.out.println("Subtraction not possible due to dimension mismatch.");
        }
        
        // Perform Multiplication
        if (cols1 == rows2) {
            System.out.println("Multiplication:");
            printMatrix(multiplyMatrices(matrix1, matrix2));
        } else {
            System.out.println("Multiplication not possible due to dimension mismatch.");
        }
    }
    
    private static void inputMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
    
    private static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }
    
    private static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
    
    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
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
    
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}