package inspur.lottery;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RandomLottery {

	
	public static void main(String[] args) {

		String classpath = RandomLottery.class.getClassLoader().getResource("").getPath();
		String packagePath = RandomLottery.class.getPackage().getName().replace('.', '/');
		String filePath = classpath + packagePath + "/lottery.in";
		System.out.println(filePath);
		
		// 产生total+1张彩票， 第一张是中奖号码
		int total = 10001;
		List<Lottery> lotteries = new ArrayList<>();
		for (int i = 0; i < total; i++) {
			Lottery temp = new Lottery();
			lotteries.add(temp);
		}
		try {
			FileWriter fw = new FileWriter(filePath);
			fw.write(""+total+"\n");
			for (int i = 0; i < lotteries.size(); i++) {
				fw.write(lotteries.get(i).toString() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Write Done!");
	}

}
