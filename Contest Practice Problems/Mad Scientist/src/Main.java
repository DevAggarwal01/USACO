import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("breedflip.in")));
        PrintWriter pw = new PrintWriter(new FileWriter("breedflip.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String desire = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String orig = st.nextToken();
        int count = 0;
        for(int i = 0; i < N; i++) {
            int x = i;
            boolean mustSwitch = false;
            while(desire.charAt(x)!=orig.charAt(x)) {
                x++;
                mustSwitch=true;

            }
            if(mustSwitch) {
                count += 1;
                i = x;
            }
        }
        pw.println(count);
        pw.close();
    }
}
