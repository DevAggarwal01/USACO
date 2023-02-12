import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LonelyPhoto {
    static String cows;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cows = st.nextToken();
        for(int i = 0; i < N-3;i++) {
            // discard any combos of 3 with all letters same
            if(!cows.substring(i,i+3).contains("G")||!cows.substring(i,i+3).contains("H")) {
                continue;
            }
            // determine lonely cow type - G or H
            char lonely = ' ';
            count++;
            if(cows.charAt(i)== cows.charAt(i+1))
                lonely = cows.charAt(i+2);
            else if(cows.charAt(i+1)== cows.charAt(i+2))
                lonely = cows.charAt(i);
            else
                lonely=cows.charAt(i+1);
            int x = i + 3;
            try {
                while (lonely != cows.charAt(x)) {
                    x++;
                    count++;
                }
            } catch (StringIndexOutOfBoundsException e) {

            }
            // index x = character that equals lonely

        }
        pw.println(count);
        pw.close();


    }
}
