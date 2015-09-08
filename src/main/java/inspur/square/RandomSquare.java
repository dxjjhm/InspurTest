package inspur.square;

import java.io.FileWriter;
import java.io.IOException;

public class RandomSquare {

	public static void main(String[] args) {

		// 随机产生一个 n x n 的 01 矩阵
		int n = 1000;
		try {
			FileWriter fw = new FileWriter("src/main/java/inspur/square/matrix1.in");
			fw.write("" + n + " " + n + "\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					fw.write("" + randomZeroOne() + " ");
				}
				fw.write("\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Write fiel Down!");

	}

	public static int randomZeroOne() {
		double w = Math.random();
		if (w > 0.7)
			return 0;
		else
			return 1;
	}

}
