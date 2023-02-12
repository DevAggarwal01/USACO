import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i]=Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long max = 0;
        long tuition=0;
        for(int i = 0; i < N; i++) {
            long x = arr[i]*(N-i);
            if(x > max) {
                max = x;
                tuition = arr[i];
            }
//            max = Math.max(arr[i]*(N-i), max);
        }

        pw.println(max + " " + tuition);
        pw.close();
    }
}
