public class Assignment12 {
    public int[] mergeTwoArray(int[] a, int[] b) {
        int a1 = a.length;
        int b1 = b.length;
        int c1 = a1 + b1;

        int[] c = new int[c1];

        System.arraycopy(a, 0, c, 0, a1);
        System.arraycopy(b, 0, c, a1, b1);
        return c;
    }
}
