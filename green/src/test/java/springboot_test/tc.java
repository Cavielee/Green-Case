package springboot_test;

import java.util.Scanner;

public class tc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i, j;
		if (t <= 5 & t >= 1) {
			for (i = 0; i < t; i++) {
				PointClass pc = new PointClass(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(),
						sc.nextInt(), sc.nextInt(), sc.nextInt());
				System.out.println(pc.isSquare());
			}

		}

	}

}

class PointClass {
	double x1,x2,x3,x4,y1,y2,y3,y4;

	public PointClass(double x1, double x2, double x3, double x4, double y1, double y2, double y3, double y4) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.y4 = y4;
	}



	public String isSquare(){
		double length1 = Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2);
		double length2 = Math.pow(x3-x4, 2) + Math.pow(y3-y4, 2);
		double length3 = Math.pow(x4-x2, 2) + Math.pow(y4-y2, 2);
		
		if (length1 == length2) {
			if ((x1-x2)/(y1-y2) == (x3-x4)/(y3-y4)) {
				if (length1 == length3)
					return "Yes";
			}
			return "No";
		}
		else
			return "No";
	}
	
}