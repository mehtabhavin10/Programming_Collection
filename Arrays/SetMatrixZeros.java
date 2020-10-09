import java.util.*;

class SetMatrixZeros {

	public static void main(String[] args) {

		int[][] m = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
		setZeros(m);
	}

	static void setZeros(int[][] a) {

		int n = a.length;
		int m = a[0].length;

		boolean firstCol = false;


		for (int i = 0; i < n; i++) {

			if (a[i][0] == 0) firstCol = true;

			for (int j = 1; j < m; j++) {

				if (a[i][j] == 0) {

					a[i][0] = 0;
					a[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < n; i++) {

			for (int j = 1; j < m; j++) {

				if (a[i][0] == 0 || a[0][j] == 0) a[i][j] = 0;
			}
		}

		if (a[0][0] == 0) for (int j = 0; j < m; j++) a[0][j] = 0;

		if (firstCol) for (int i = 0; i < n; i++) a[i][0] = 0;


		System.out.println("Matrix: ");

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++)
				System.out.print(a[i][j] + " ");

			System.out.println();
		}
	}
}