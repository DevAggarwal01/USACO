import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SleepingInClass {
    public static ArrayList<Integer> test;
    public static int N;
    public static double sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testNum = Integer.parseInt(st.nextToken());
        for(int z = 0; z < testNum; z++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            test = new ArrayList<>();
            sum = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N;i++) {
                int e = Integer.parseInt(st.nextToken());
                test.add(e);
                sum+=e;
            }
            int ans = find(N);
            pw.println(ans);
        }
        pw.close();
    }

    public static int find(int n) {
        if(n==1) {
            return N-1;
        }
        double goal = sum/n;
        if(goal % 1!=0) {
            return find(n-1);
        }
        else {
            for(int i = 0; i < test.size();i++) {
                int current = test.get(i);
                if(current>goal) {
                    return find(n-1);
                }
                while(current<goal) {
                    int x = test.get(i+1);
                    test.remove(i+1);
                    current+=x;
                }
                if(current>goal) {
                    return find(n-1);
                }
                else {
                    test.set(i,current);
                }
            }

            return N-test.size();
        }

    }

    public static boolean equal() {
        for(int i = 0; i < test.size()-1;i++) {
            if(test.get(i)!=test.get(i+1))
                return false;
        }
        return true;
    }
}
