import java.util.Scanner;
public class Photoshoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String line = sc.next();
        int count = 0;
        for(int i = line.length()-1; i > 0; i--) {
            String y = line.substring(0, i+1);
            int[] x = countG(y);
            int oddG = x[0];
            int evenG = x[1];
            System.out.println(line + " i>>>" + i + "evenG >>>"+evenG + "oddG>>" + oddG);
            if(oddG > evenG) {
                line = reverse(line, i);
                count++;
            }

        }
        System.out.println(count);
    }
    public static int[] countG(String line) {
        int countEven = 0;
        int count = 0;
        for(int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'G') {
                count++;
                if (i % 2 == 1)
                    countEven++;
            }
        }
        int[] x = {count-countEven, countEven};
        return x;
    }
    public static String reverse(String line, int endRev) {
        String x = "";
        for(int i = endRev; i >= 0; i--) {
            x += line.substring(i, i +1);
        }
        return x + line.substring(endRev + 1);
    }
}
