package inspur.lottery;

import java.util.HashSet;
import java.util.Set;

public class Lottery {

	private Set<String> lottery;

	// 使用了集合中元素不可重复的属性
	public Lottery() {
		lottery = new HashSet<>();
		while (lottery.size() < 7) {
			lottery.add(""+randomNumber(1,33));
		}
	}

	public static int randomNumber(int begin, int end) {
		return (int) (Math.random() * (end - begin)) + 1;
	}
	
	public String toString() {
		String result = lottery.toString();
		result = result.substring(1, result.length()-1);
		result = result.replace(",", "");
		return result;
	}

}
