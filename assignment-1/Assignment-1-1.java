import java.util.Scanner;
import java.util.stream.IntStream;

public class Assignment11 {
    public static int isNumeric(String s) {
        try {
            return Integer.parseInt(s);
        } catch(NumberFormatException e){
            return -1;
        }
    }
    public static void main(String[] args) {
        boolean q = true;
        while (q) {
            Scanner keyInput = new Scanner(System.in);
            System.out.println("Enter value of X: ");
            String x = keyInput.next();
            if (x.length() == 1 && x.charAt(0) == 'q') {
                System.out.println("exit successfully!");
                break;
            } else{
                int count = isNumeric(x);
                if (count > 0) {
                    IntStream.range(1, count+1).forEach(i -> System.out.println(i+count));
                } else {
                    System.out.println("Error input value is less than 0!");
                }
            }
        }
    }
}
