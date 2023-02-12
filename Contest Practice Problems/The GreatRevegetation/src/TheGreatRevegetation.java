import java.util.*;
import java.io.*;
public class TheGreatRevegetation {
    static int pastures;
    static int cows;
    static ArrayList<Integer>[] fav;
    static PrintWriter pw;
    static boolean solved = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
        pw = new PrintWriter(new FileWriter("revegetate.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        pastures = Integer.parseInt(st.nextToken());
        cows = Integer.parseInt(st.nextToken());
        fav = new ArrayList[cows];
        for(int i = 0; i < cows; i++) {
            fav[i] = new ArrayList<>();
        }
        for(int i = 0; i < cows; i++) {
            st = new StringTokenizer(br.readLine());
            fav[i].add(Integer.parseInt(st.nextToken()));
            fav[i].add(Integer.parseInt(st.nextToken()));
        }
        int[] seeds = new int[pastures];
        dfs(seeds, 0);
    }

    public static void dfs(int[] seeds, int index) {
//        if(!solved) {
            if (index == pastures) {
                boolean correct = true;
                for (ArrayList<Integer> cow : fav) {
                    if (seeds[cow.get(0) - 1] == seeds[cow.get(1) - 1]) {
                        correct = false;
                    }
                }
                if (correct) {
                    solved = true;
                    for (int x : seeds)
                        pw.print(x);
                    pw.close();
                    System.exit(0);
                }
                return;
            } else if (index > 0) {
                boolean correct = true;
                for (ArrayList<Integer> cow : fav) {
                    int x = cow.get(0) - 1;
                    int y = cow.get(1) - 1;
                    if (x <= index && y <= index) {
                        if (seeds[x] == seeds[y]) {
                            correct = false;
                        }
                    }
                }
                if (!correct)
                    return;
            }

            for (int i = 1; i < 5; i++) {
                seeds[index] = i;
                dfs(seeds, index + 1);
            }
//        }
    }
}
