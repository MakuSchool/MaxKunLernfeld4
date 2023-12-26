
public class Matrix_Multiplikation {

	public static void main(String[] args) {
		int[][] matrix_one = {{1, 2, 1},{3, 1, 4}, {1, 5, 2}};
		int[][] matrix_two = {{2, 3},{4, 1},{1, 1}};
		int[][] matrix_three = matrizen_multi(matrix_one, matrix_two);
		for(int i = 0; i < matrix_three.length; i++) {
			for(int j = 0; j < matrix_three[i].length; j++) {
				System.out.print(matrix_three[i][j] + " ");
			}
			System.out.println();
		}
		

	}
	
	public static int[][] matrizen_multi(int[][] matrix_one, int[][] matrix_two){
		int[][] matrix = new int [matrix_one.length][matrix_two[0].length];
		int x;
		int z = 0;
		if(matrix_one[0].length == matrix_two.length) {
			for(int i=0; i < matrix_one.length; i++) {
				for(int j = 0; j < matrix_two[i].length; j++) {
					x = 0;
					for(int k = 0; k < matrix_one.length; k++) {
						z = matrix_one[i][k] * matrix_two[k][j];
						x += z;
					}
					matrix[i][j] = x;
					z = 0;
				}
			}
		} else {
			System.out.println("geht nicht");
		}
		return matrix;
	}
}
