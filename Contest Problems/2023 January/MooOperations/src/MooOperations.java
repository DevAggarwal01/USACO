import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MooOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int z = 0; z < N; z++) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            if(text.length()<3) {
                pw.println(-1);
                continue;
            }
            int ans = find(text);
            pw.println(ans);
        }
        pw.close();
    }
    public static int find(String text) {
        if(text.length()>3) {
            int valO = text.lastIndexOf("O");
            int val1 = text.indexOf("O");
            int num = text.length()-3;
            if(!text.substring(1, text.length()-1).contains("O")) {
                return -1;
            }
            if(val1!=-1) {
                if(text.charAt(val1-1)=='O') {
                    num++;
                }
                if(text.charAt(val1+1)=='M') {
                    num++;
                }
                return num;
            }
            else if(valO!=-1) {
                if(text.charAt(valO-1)=='O') {
                    num++;
                }
                if(text.charAt(valO+1)=='M') {
                    num++;
                }
                return num;
            }
            return -1;

        }
        else {
            if(text.length()==6)
                return 4;
            if(text.charAt(1)=='O') {
                int num = 0;
                if(text.charAt(0)=='O')
                    num++;
                if(text.charAt(2)=='M')
                    num++;
                return num;
            }
            return -1;
        }


    }
}
