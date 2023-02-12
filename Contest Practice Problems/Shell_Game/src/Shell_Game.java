import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Shell_Game {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("shell.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int swaps = Integer.valueOf(st.nextToken());
        int[] shells = {0,1,2};
        int[] points = {0,0,0};
        for(int i = 0; i < swaps; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken())-1;
            int b = Integer.valueOf(st.nextToken())-1;
            int x = shells[a];
            shells[a] = shells[b];
            shells[b] = x;

            points[shells[Integer.valueOf(st.nextToken())-1]]++;
        }
        pw.print(Math.max(points[0], Math.max(points[1], points[2])));
        pw.close();
    }
}
