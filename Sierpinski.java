/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {

		StdDraw.setCanvasSize(600, 600);
		StdDraw.setXscale(0, 10);
		StdDraw.setYscale(0, 10);

		double x1 = 0;
		double y1 = 0;

		double x2 = 10;
		double y2 = 0;

		double x3 = 5;
		double y3 = x3 * Math.sqrt(3);

		StdDraw.line(x1, y1, x2, y2);
		StdDraw.line(x2, y2, x3, y3);
		StdDraw.line(x3, y3, x1, y1);

		// input: base triangle to work on || output: upside down triangles and plugs in base triangles into its own function again
		sierpinski(n, x1, x2, x3, y1, y2, y3);

	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {

		if (n == 0) {
			return;
		}

		double rX1 = (x1 + x2)/2;
		double rX2 = (x3 + x2)/2;
		double rX3 = (x1 + x3)/2;

		double rY1 = y1;
		double rY2 = (y1 + y3)/2;
		double rY3 = rY2;

		StdDraw.line(rX1, rY1, rX2, rY2);
		StdDraw.line(rX2, rY2, rX3, rY3);
		StdDraw.line(rX3, rY3, rX1, rY1);
		
		sierpinski(n-1, x1, rX1, rX3, y1, rY1, rY3);
		sierpinski(n-1, rX1, x2, rX2, rY1, y2, rY2);
		sierpinski(n-1, rX3, rX2, x3, rY3, rY2, y3);
	}
}
