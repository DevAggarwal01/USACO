import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pw.println(findMin(0,0,0));
        pw.close();
    }
    public static long findMin(int index, long sum1, long sum2) {
        if(index == N){
            return Math.abs(sum1-sum2);
        }
        return Math.min(findMin(index+1, sum1+arr[index],sum2),findMin(index+1, sum1, sum2+arr[index]));
    }
}
