import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Maximum_Distance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] xVal = new int[Integer.parseInt(st.nextToken())];
        int[] yVal = new int[xVal.length];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < xVal.length;i++) {
            xVal[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < yVal.length;i++) {
            yVal[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for(int x = 0; x<xVal.length;x++) {
            for(int y = 0; y<yVal.length;y++) {
                int distance = (int) (Math.pow(xVal[x]-xVal[y],2)+Math.pow(yVal[x]-yVal[y],2));
                max = Math.max(distance, max);
            }
        }
        pw.println(max);
        pw.close();
    }
}
