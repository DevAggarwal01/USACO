import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Leader {
    static int count;
    static int N;
    static String cows;
    static int[] limit;
    static int cow1 = 0;
    static int cow2 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cows = st.nextToken();
        st = new StringTokenizer(br.readLine());
        limit = new int[N];
        for(int i = 0; i < N; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }
        int maxIndex = Math.max(cows.indexOf("G"), cows.indexOf("H"));
        int lastG = cows.lastIndexOf("G");
        int lastH = cows.lastIndexOf("H");
        for(int i = 0; i <= maxIndex; i++) {
            int limitI = limit[i];
            for(int x = i+1; x <= maxIndex; x++) {
                if (cows.charAt(i) != cows.charAt(x)) {
                    int limitX = limit[x];
                    if (limitX >= lastG || limitX >= lastH || limitI >= lastG || limitI >= lastH) {
                        cow1 = i;
                        cow2 = x;
                        check();
                    }
                }
            }
        }
        pw.println(count);
        pw.close();
    }

    public static void check() { // time can get high when cows between are much less. Maybe create alternate method for determining if the list contains all Gs or Hs
        int limit1 = limit[cow1];
        int limit2 = limit[cow2];
        String breed1 = cows.substring(cow1, cow1+1);
        String breed2 = cows.substring(cow2, cow2+1);

        // determine if either cow has a list of all cows with the same breed
        String extract1 = cows.substring(0, cow1) + cows.substring(limit1);
        String extract2 = cows.substring(0, cow2) + cows.substring(limit2);
        boolean isLeader1 = !extract1.contains(breed1);
        boolean isLeader2 = !extract2.contains(breed2);
        if(!isLeader1 && !isLeader2) // if neither are leaders
            return;
        if(isLeader1 && isLeader2) {// if both are leaders
            count++;
            return;
        }
        // at least one leader exists at this point
        if(isLeader1) { // cow1 = leader
            if(cow1 > cow2 && cow1 < limit2) { // if cow1 is withing the bounds of cow2 then cow2 is a leader
                count++;
                return;
            }
        }
        else if (isLeader2) {
            if(cow2 > cow1 && cow2 < limit1) {
                count++;
                return;
            }
        }
    }
}
