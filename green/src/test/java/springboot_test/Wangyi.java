package springboot_test;

import java.util.Scanner;

public class Wangyi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int i, j;
		int num = 0;

		if (k == 0) {
			num = n * n;
		} else {
			for (i = k + 1; i <= n; i++) {
				for (j = 2; j <= n; j++) {
					if (j > i) {
						num++;
					} else if (j != i) {
						if (i % j >= k)
							num++;
					}
				}

			}
			num += n - k;
		}
		System.out.println(num);

	}

}
