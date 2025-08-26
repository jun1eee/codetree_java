import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long cnt;
	static ArrayList<Integer> nums = new ArrayList<>();

	static void f(int len) {
		if (len == N) {
			cnt++;
			return;
		}
		for (int i = 1; i <= 4; i++) {
			if (len + i > N)
				continue;
			nums.add(i);
			f(len + i);
			nums.remove(nums.size()-1);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		f(0);
		System.out.println(cnt);
	}
}
