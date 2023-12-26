import java.util.Scanner;

public class Matrix_transponieren {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] matrix = matrix_einlesen(4, input);
		matrix_auslesen(matrix);
		System.out.println("Ist die Matrix transponiert?");
		if(ist_matrix_transponiert(matrix)) {
			System.out.println("Ja");
		} else {
			System.out.println("Nein");
		}

	}
	
	public static int[][] matrix_einlesen(int n, Scanner input){
		int[][] matrix = new int[n][n];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++){
				System.out.println("Gebe eien ganze Zahl ein");
				matrix[i][j] = input.nextInt();
			}
		}
		return matrix;
	}
	
	public static void matrix_auslesen(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean ist_matrix_transponiert(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(i == j) {
					continue;
				}
				if(matrix[i][j] != matrix[j][i]) {
					return false;
				}
			}
		}
		return true;
	}

}
