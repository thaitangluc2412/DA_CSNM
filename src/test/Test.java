package test;

public class Test {
	public static void main(String[] args) {
		String timeMoney = "abcaaaa";
		timeMoney = timeMoney.replace(timeMoney.substring(timeMoney.length()-5), "");
		System.out.println(timeMoney);
	}
}
