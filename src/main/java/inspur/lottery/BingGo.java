package inspur.lottery;

public class BingGo {

	private int zero;
	private int first;
	private int second;
	private int third;
	private int fourth;
	private int fifth;
	private int sixth;

	public BingGo() {
		zero = 0;
		first = 0;
		second = 0;
		third = 0;
		fourth = 0;
		fifth = 0;
		sixth = 0;
	}

	public int getZero() {
		return zero;
	}

	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}

	public int getThird() {
		return third;
	}

	public int getFourth() {
		return fourth;
	}

	public int getFifth() {
		return fifth;
	}

	public int getSixth() {
		return sixth;
	}

	public synchronized void zeroAddOne() {
		this.zero++;
	}

	public synchronized void firstAddOne() {
		this.first++;
	}

	public synchronized void secondAddOne() {
		this.second++;
	}

	public synchronized void thirdAddOne() {
		this.third++;
	}

	public synchronized void fourthAddOne() {
		this.fourth++;
	}

	public synchronized void fifthAddOne() {
		this.fifth++;
	}

	public synchronized void sixthAddOne() {
		this.sixth++;
	}

	public int bingGoSum() {
		return zero + first + second + third + fourth + fifth + sixth;
	}

	@Override
	public String toString() {
		return "" + zero + " " + first + " " + second + " " + third + " " + fourth + " " + fifth + " " + sixth;
	}

}
