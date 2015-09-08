package inspur.bus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Bus {

	public static void main(String[] args) {

		long begin = System.currentTimeMillis();
		run();
		long end = System.currentTimeMillis();
		System.out.println("耗费时间 = " + (end - begin) + "ms");

	}

	public static void run() {
		int n = 0;
		int m = 0;
		int k = 0;
		int[][] matrix;
		// 读入文件, 构建矩阵
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/main/java/inspur/bus/bus1.in"));
			String line = in.readLine();
			String[] firstLineSplit = line.split(" ");
			n = Integer.parseInt(firstLineSplit[0]);
			m = Integer.parseInt(firstLineSplit[1]);
			k = Integer.parseInt(firstLineSplit[2]);
			matrix = new int[n][m];
			while ((line = in.readLine()) != null) {
				String[] temp = line.split(" ");
				int x = Integer.parseInt(temp[0]) - 1; // 因为java数组下标从0开始计数
				int y = Integer.parseInt(temp[1]) - 1;
				int value = Integer.parseInt(temp[2]);
				matrix[x][y] = value;
			}
			in.close();

			// 运算，得出结果
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (i == 0 && j > 0) {
						matrix[i][j] += matrix[i][j - 1];
					} else if (j == 0 && i > 0) {
						matrix[i][j] += matrix[i - 1][j];
					} else if (i > 0 && j > 0) { // i >0 && j>0
						int A = matrix[i][j] + matrix[i][j - 1];
						int B = matrix[i][j] + matrix[i - 1][j];
						matrix[i][j] = A > B ? A : B;
					} else {
						// i = j = 0
						// do nothing
					}
				}
			}

			System.out.println("============Answer===============");
			System.out.println(matrix[n - 1][m - 1]);

			// 输出文件
			FileWriter fw = new FileWriter("src/main/java/inspur/bus/bus.out");
			fw.write("" + matrix[n - 1][m - 1]);
			fw.close();
			System.out.println("Write File Down!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
