import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Load_Balancing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] cows = new int[n][2];
        int xmin=1000000, ymin = 1000000;
        int xmax=0, ymax = 0;
        for(int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows[i][0] = x;
            cows[i][1] = y;
            xmin = Math.min(xmin, x);
            ymin = Math.min(ymin, y);
            xmax = Math.max(xmax, x);
            ymax = Math.max(ymax, y);
        }
        // use while loop if time limit exceeded
        if(xmin % 2 == 1)
            xmin++;
        if(ymin % 2 == 1)
            ymin++;

        int min = Integer.MAX_VALUE;
        for(int x = xmin; x < xmax; x+=2) {
            boolean noCow = true;
            for(int[] i : cows) {
                if(i[0] == x + 1) {
                    noCow = false;
                    break;
                }
            }
            if(noCow)
                continue;
            noCow = true;
            for(int y = ymin; y < ymax; y+=2) {
                for(int[] i : cows) {
                    if(i[1] == y + 1) {
                        noCow = false;
                        break;
                    }
                }
                if(noCow)
                    continue;
                int q1=0, q2=0, q3=0, q4 = 0;
                for(int[] i : cows) {
                    if(i[0] > x && i[1] > y)
                        q1++;
                    else if(i[0] < x && i[1] > y)
                        q2++;
                    else if(i[0] < x && i[1] < y)
                        q3++;
                    else if(i[0] > x && i[1] < y)
                        q4++;
                }
                min = Math.min(min, Math.max(q1, Math.max(q2, Math.max(q3,q4))));
            }
        }
        pw.print(min);
        pw.close();
    }
}
