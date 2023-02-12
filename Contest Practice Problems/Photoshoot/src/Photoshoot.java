import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Photoshoot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String cows = st.nextToken();
        int count = 0;
        // for G to be odd, index%2==1
        for(int i = N-(N+1)%2; i > 0; i-=2) {
            if(cows.charAt(i)=='G'||cows.charAt(i)=='H'&&cows.charAt(i-1)=='H')
                continue;
            int oddG=0;
            int evenG=0;
            for(int x = 0; x <= i; x++) {
                if(cows.charAt(x)=='G') {
                    if(x%2==0) {
                        oddG++;
                    }
                    else
                        evenG++;
                }
            }
            if(oddG>evenG) {
                cows = reverse(cows, i);
                count++;
            }
        }

        pw.println(count);
        pw.close();
    }
    public static String reverse(String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, i+1));
        return sb.reverse()+str.substring(i+1);
    }
}
