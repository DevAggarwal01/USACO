import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> weights = new ArrayList();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n*2; i++) {
            weights.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(weights);
        int sum = 0;
        for(int i = 0; i < n-1; i++) {
            int min = Math.abs(weights.get(0)-weights.get(1));
            int w1 = 0;
            for(int x = 0; x < weights.size()-1; x++) {
                int y = Math.min(min, Math.abs(weights.get(x)-weights.get(x+1)));
                if(y < min) {
                    min = y;
                    w1 = x;
                }
            }
            sum+= min;
            weights.remove(w1+1);
            weights.remove(w1);
        }
        pw.println(sum);
        pw.close();
    }
}
