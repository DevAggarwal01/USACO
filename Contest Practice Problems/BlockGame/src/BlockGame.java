import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BlockGame {
    static String[][] arr;
    static int[] alphabet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("blocks.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new String[Integer.valueOf(st.nextToken())][2];
        alphabet = new int[26];
        for(int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            int[] count1 = new int[26];
            int[] count2 = new int[26];
            String word1 = st.nextToken();
            String word2 = st.nextToken();
            for(int x=0; x < word1.length();x++) {
                count1[((int) word1.charAt(x))-97]++;
            }
            for(int x=0; x < word2.length();x++) {
                count2[((int) word2.charAt(x))-97]++;
            }
            for(int x = 0; x < count1.length; x++) {
                alphabet[x]+=Math.max(count1[x], count2[x]);
            }
        }
        for(int x = 0; x < alphabet.length; x++) {
            pw.println(alphabet[x]);
        }
        pw.close();
    }
}
