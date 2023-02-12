import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Counting_Liars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] G = new int[1001];
        int[] L = new int[1001];
        int g = 0, l =0;
        for(int i = 0; i < n; i++) {
            if(sc.next().equals("G")) {
                G[g] = sc.nextInt();
                g++;
                continue;
            }
            L[l] = sc.nextInt();
            l++;
        }
        Arrays.sort(G);
        Arrays.sort(L, 0, l);

        G = reverseArray(G);

        //l = L[0];
        //g = G[0];
        int lying = 0;
        int compare = Integer.MAX_VALUE;
        for(int least = 0; least < L.length; least++) {
            lying = least;
            for(int greatest: G) {
                if(L[least] < greatest)
                    lying ++;
            }
            compare = Math.min(compare, lying);
        }
        System.out.println(compare);
        //if(l < g) {
            /*
            int indexG = 1;
            int indexL = 1;
            while(l < g) {
                if(Math.abs(L[indexL] - l) < Math.abs(g - G[indexG])) {
                    l = L[indexL];
                    indexL ++;
                    lying ++;
                }
                else {
                    g = G[indexG];
                    indexG++;
                    lying++;
                }
            }*/

        //}
        //System.out.println(lying);
    }
    public static int[] reverseArray(int[] arr) {
        int length = arr.length;
        for(int i = 0; i < length / 2; i++) {
            int temp = arr[length-1-i];
            arr[length-1-i] = arr[i];
            arr[i] = temp;

        }
        return arr;
    }
}
