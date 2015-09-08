package inspur.lottery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main4Lottery {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String filepathIn = Main4Lottery.class.getClassLoader().getResource("inspur/lottery/lottery.in").getPath();
		run(filepathIn);
		long end = System.currentTimeMillis();
		System.out.println("运行时间 = " + (end-start) + "ms");
		
	}
	
	public static void run(String filepath) {
		// 创建一个BingGo类用于存放中奖的张数
		//int[] bingGo = new int[7];
		BingGo bingGo = new BingGo();
		// 创建一个整数存放彩票的张数
		Integer totalLottery = 0;
		// 创建一个List<Set>存放所有的彩票
		List<Set<String>> allLottery = new ArrayList<>();
		// 读文件
		try {
			BufferedReader in = new BufferedReader(new FileReader(filepath));
			String line = in.readLine();
			totalLottery = Integer.parseInt(line);
			while ((line = in.readLine()) != null) {
				String[] temp = line.split(" ");
				Set<String> set = new HashSet<>();
				for (int i = 0; i < temp.length; i++) {
					set.add(temp[i]);
				}
				allLottery.add(set);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 下面判断中奖情况
		Set<String> target = allLottery.get(0);
		for (int i = 1; i < allLottery.size(); i++) {
			Set<String> result = new HashSet<>();
			result.addAll(target);
			Set<String> temp = allLottery.get(i);
			result.retainAll(temp);
			int setSize = result.size();
			switch (setSize) {
			case 7:
				bingGo.zeroAddOne();
				break;
			case 6:
				bingGo.firstAddOne();
				break;
			case 5:
				bingGo.secondAddOne();
				break;
			case 4:
				bingGo.thirdAddOne();
				break;
			case 3:
				bingGo.fourthAddOne();
				break;
			case 2:
				bingGo.fifthAddOne();
				break;
			case 1:
				bingGo.sixthAddOne();
				break;
			default:
				break;
			}
		}
		// 做一次检验
		if (bingGo.bingGoSum() > totalLottery) {
			System.out.println("算法错误，中奖的个数不可能大于购买的彩票数目!");
		}
		// 将结果写入到文件中
		try {
			FileWriter fw = new FileWriter("src/main/java/inspur/lottery/lottery.out");
			fw.write(bingGo.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done！");		
	}
}
