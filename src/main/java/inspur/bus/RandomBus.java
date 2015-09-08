package inspur.bus;

import java.io.FileWriter;
import java.io.IOException;

public class RandomBus {

	// 随机构建1000 x 1000的方阵， 每个元素的大小在0到1000000之间， int型可以满足要求
	public static void main(String[] args) {

		int n = 1000;
		int[][] matrix = new int[n][n];
		int countNonZero = 0; // 记录非零元素
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = randomNumber(0, 1000000);
				if (matrix[i][j] != 0) {
					countNonZero++;
				}
			}
		}

		try {
			FileWriter fw = new FileWriter("src/main/java/inspur/bus/bus1.in");
			fw.write("" + n + " " + n + " " + countNonZero + "\n");
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <=n; j++) {
					fw.write("" + i + " " + j + " " + matrix[i-1][j-1] + "\n");
				}
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done!");

	}

	public static int randomNumber(int a, int b) {
		return (int) (Math.random() * Math.abs(b - a)) + a;
	}

}
