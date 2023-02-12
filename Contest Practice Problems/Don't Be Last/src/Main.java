import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class Main {
    static String[] names = {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("notlast.in")));
        PrintWriter pw = new PrintWriter(new FileWriter("notlast.out"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> log = new HashMap<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            log.put(name, log.containsKey(name)?log.get(name)+Integer.parseInt(st.nextToken()):Integer.parseInt(st.nextToken()));
        }
        int min = Integer.MAX_VALUE;
        for(String x : names) {
            min = Math.min(log.get(x),min);
        }
        int higher = Integer.MAX_VALUE;
        for(String x: names) {
            if(log.get(x)==min)
                log.remove(x);
        }
        min = Integer.MAX_VALUE;
        String ans = "";
        int count = 0;
        for(String x : names) {
            if(log.get(x)==null)
                continue;
            int y = Math.min(log.get(x),min);
            if(y <min) {
                min = y;
                ans = x;
            }
        }
        for(String x: names) {
            if(log.get(x)==null)
                continue;
            if (log.get(x) == min) {
                ans = x;
                count++;
            }
        }
        if(count>=2)
            pw.println("Tie");
        else
            pw.println(ans);
        pw.close();
    }
}
