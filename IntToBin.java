/** Returns the binary representation of a given integer. */
public class IntToBin {

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("Binary representation of " + x + " is: " + toBinary(x));
    }

    /** Returns the binary representation of the given integer, as a string of 0's and 1's.  */
   public static String toBinary(int x) {

    // Base case
    if (x == 0) {
        return "";
    }

    // Find the largest p such that 2^p <= x
    int p = 0;
    while (Math.pow(2, p + 1) <= x) {
        p++;
    }

    int highestPower = (int) Math.pow(2, p);

    // Output the leading 1
    String result = "1";

    // Subtract the highest power of 2
    x -= highestPower;

    // For the remaining bits, we recurse on the remainder,
    // but must ensure zeros are included when needed
    String remainderBinary = toBinary(x);

    // Pad with zeros so total length matches p remaining bits
    while (remainderBinary.length() < p) {
        remainderBinary = "0" + remainderBinary;
    }

    return result + remainderBinary;
}
}