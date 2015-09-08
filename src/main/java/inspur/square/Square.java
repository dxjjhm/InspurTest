package inspur.square;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Square {

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		run();
		long end = System.currentTimeMillis();
		System.out.println("耗费时间 = " + (end - begin) + "ms");
	}

	public static void run() {
		int R = 0;
		int C = 0;
		int[][] matrix;
		int[][] matrixB;

		try {
			BufferedReader in = new BufferedReader(new FileReader("src/main/java/inspur/square/matrix1.in"));
			String line = in.readLine();
			String[] firstLine = line.split(" ");
			R = Integer.parseInt(firstLine[0]);
			C = Integer.parseInt(firstLine[1]);
			System.out.println("R = " + R + ", C = " + C);
			matrix = new int[R][C];
			matrixB = new int[R][C];
			int i = 0;
			while ((line = in.readLine()) != null) {
				String[] temp = line.split(" ");
				for (int j = 0; j < temp.length; j++) {
					matrix[i][j] = Integer.parseInt(temp[j]);
				}
				i++;
			}

			int max = 1;
			for (int l = 0; l < R; l++) {
				for (int m = 0; m < C; m++) {
					matrixB[l][m] = maxSquare(matrix, l, m, R - 1, C - 1);
					if (matrixB[l][m] > max) {
						max = matrixB[l][m];
					}
				}
			}

//			System.out.println("=============================================");
//			for (int l = 0; l < R; l++) {
//				for (int m = 0; m < C; m++) {
//					System.out.printf("%d ", matrixB[l][m]);
//				}
//				System.out.println();
//			}
			System.out.println("=============================================");
			System.out.println("最大面积 = " + max);

			FileWriter fw = new FileWriter("src/main/java/inspur/square/matrix.out");
			fw.write("" + max);
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int maxSquare(int[][] matrix, int l, int m, int R, int C) { // 本函数只适合在本题使用
		if (matrix[l][m] == 1) {
			int diagonal = (R - l) < (C - m) ? (R - l) : (C - m);
			int maxSquare = 1;
			for (int i = 1; i < diagonal; i++) {
				int expectedSum = (i + 1) * (i + 1);
				int realSum = 0;
				for (int p = 0; p <= i; p++) {
					for (int q = 0; q <= i; q++) {
						realSum += matrix[l + p][m + q];
					}
				}
				if (expectedSum != realSum) {
					break;
				} else {
					maxSquare = realSum;
				}
			}
			return maxSquare;
		} else {
			return 0;
		}

	}

}
