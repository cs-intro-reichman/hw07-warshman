/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		
		*/
		// curve(Integer.parseInt(args[0]),
		// 		Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		// 		Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
		snowFlake(Integer.parseInt(args[0]));
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
			return;
		}

		StdDraw.line(x1, y1, x2, y2);
		double pX = ((Math.sqrt(3) / 6) * (y1 - y2)) + (0.5 * (x1 + x2));
		double pY = ((Math.sqrt(3) / 6) * (x2 - x1)) + (0.5 * (y1 + y2));
		double thirdOfX = x1 + (x2 - x1)/3;
		double thirdOfY = y1 + (y2 - y1)/3;
		double twoThirdsX = x1 + 2*(x2 - x1)/3;
		double twoThirdsY = y1 + 2*(y2 - y1)/3;
		StdDraw.line(thirdOfX, thirdOfY, pX, pY);
		StdDraw.line(pX, pY, twoThirdsX, twoThirdsY);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setPenRadius(0.003);
		StdDraw.line(x1 + (x2 - x1)/3, y1 + (y2 - y1)/3, x1 + 2*(x2 - x1)/3, y1 + 2*(y2 - y1)/3);
		StdDraw.setPenColor(StdDraw.BLACK);

		curve(n-1, thirdOfX, thirdOfY, pX, pY);
		curve(n-1, pX, pY, twoThirdsX, twoThirdsY);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		curve(n,0.2, 0.8, 0.9, 0.8);
		curve(n,0.9, 0.8, 0.55, 0.8 - (0.35 * Math.sqrt(3)));
		curve(n, 0.55, 0.8 - (0.35 * Math.sqrt(3)), 0.2, 0.8);
	}
}
