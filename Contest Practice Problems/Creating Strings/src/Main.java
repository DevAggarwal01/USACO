import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] letters;
    static ArrayList<String> permutations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        String x = st.nextToken();
        N= x.length();
        letters = new int[26];
        permutations = new ArrayList<>();
        for(int i = 0; i < x.length();i++) {
            letters[x.charAt(i)-'a'] ++;
        }
        find("");
        pw.println(permutations.size());
        for(String p: permutations) {
            pw.println(p);
        }
        pw.close();
    }
    public static void find(String p) {
        if(p.length() == N) {
            permutations.add(p);
            return;
        }
        for(int i = 0; i < 26;i++) {
            if(letters[i]>0) {
                letters[i]--;
                find(p + (char)('a'+i));
                letters[i]++;
            }
        }
    }
}
