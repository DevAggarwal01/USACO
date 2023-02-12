import java.io.*;
import java.util.*;

public class LivestockLineup {
    static int N;
    static int[] cowCount = {1,1,1,1,1,1,1,1};
    final static String[] names = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
    static ArrayList<String>[] adj;
    static ArrayList<String[]> perms = new ArrayList<>();
    static int count=0;
    static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
		pw = new PrintWriter("lineup.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        adj=new ArrayList[N];

        for(int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            adj[i].add(st.nextToken());
            st.nextToken();
            st.nextToken();
            st.nextToken();
            st.nextToken();
            adj[i].add(st.nextToken());
        }
		String[] names2 = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
        search(names2,names2.length,names2.length);
        // Collections.sort(perms);
        ArrayList<String[]> solution = new ArrayList<>();
        for(String[] order: perms) {
            boolean isRight=true;
            for(int i = 0; i < 8; i++) {
                for(ArrayList<String> x: adj) {
                    boolean check=false;
                    String checkFor;
                    if(x.get(0).equals(order[i])) {
                        checkFor = x.get(1);
                    }
                    else if(x.get(1).equals(order[i])) {
                        checkFor = x.get(0);
                    }
                    else {
                        continue;
                    }
                    // System.out.println(checkFor + " " + order[i]);
                    try {
                        if(order[i-1].equals(checkFor)) {
                            check = true;
                        }
                    }
                     catch(IndexOutOfBoundsException e) {
                        
                    }
                    try {
                        if(order[i+1].equals(checkFor)) {
                            check = true;
                        }
                    }
                    catch(IndexOutOfBoundsException e) {

                    }

                    if(check==false) {
                        isRight=false;
                    }
                }
                // System.out.println();
                if(isRight==false)
                    break;
            }
            if(isRight) {
                solution.add(order);
            }

        }
        ArrayList<String> sort = new ArrayList<>();
        for(int i = 0; i < solution.size(); i++) {
            String y = "";
            for(String x : solution.get(i)) {
                y+=x;
            }
            y+=i;
            sort.add(y);
        }
        Collections.sort(sort);
        String[] ans = solution.get(Integer.parseInt(sort.get(0).replaceAll("[^0-9]", "")));
        for(String x:ans) {
            pw.println(x);
        }
        pw.close();

    }
	public static void search(String a[], int size, int n)
    {
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1) {
            String[] x = new String[8];
            for(int i = 0; i < 8; i++) {
                x[i]=a[i];
            }
			perms.add(x);
		} 
        for (int i = 0; i < size; i++) {
            search(a, size - 1, n);
 
            // if size is odd, swap 0th i.e (first) and
            // (size-1)th i.e (last) element
            if (size % 2 == 1) {
                String temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            }
 
            // If size is even, swap ith
            // and (size-1)th i.e last element
            else {
                String temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }
    }
    // public static void search(String[] arr, int index) {
    //     if(index ==8) {
    //         System.out.println(Arrays.toString(arr));
    //         System.out.print(count);
    //         perms.add(arr);
    //         count++;
    //         return;
    //     }
    //     for(int i = 0; i < 8; i++) {
    //         if(cowCount[i]>0) {
    //             cowCount[i]--;
    //             arr[index]=names[i];
    //             search(arr, index+1);
    //             cowCount[i]++;
    //         }
    //     }
    // }
    public static void print(String[] ans) {
        
    }
}