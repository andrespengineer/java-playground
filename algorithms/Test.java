import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();

        String[] versions = new String[] {
                "1.0",
                "1.1",
                "1.01",
                "2.0",
                "0.0.1",
                "00000",
                "1.0.00",
                "1.00.0",
                "000.000",
                "00000.001",
                "00.00.00.1.00.001",
                "01",
                "1",
                "1.1",
                "1.0.1",
                "1.00.1",
                "1.0.0.0000",
                "1.002.1.001.0"
        };

        new Solution().sortVersions(versions);
        System.out.println(Arrays.toString(versions));
    }
}

class Solution {

    public void sortVersions(String[] versions){
        Arrays.sort(versions, new VersionComparator());
    }

    public void sortVersionsPrioritizingParts(String[] versions){

        Arrays.sort(versions, (versionA, versionB) -> {

            String[] partsA = versionA.split("\\.");
            String[] partsB = versionB.split("\\.");

            if(partsA.length < partsB.length){
                return -1;
            }
            if(partsA.length > partsB.length){
                return 1;
            }

            Integer bias = null;

            for(int i = 0; i < partsA.length; i++){
                String partA = partsA[i];
                String partB = partsB[i];
                int ia = 0, ib = 0;

                int za = 0;
                while (ia < partA.length() && partA.charAt(ia) == '0') {
                    ia++;
                    za++;
                }

                int zb = 0;
                while (ib < partB.length() && partB.charAt(ib) == '0') {
                    ib++;
                    zb++;
                }

                if(ia == partsA.length && ib == partB.length()){
                    if(bias == null) {
                        bias = za - zb;
                    }
                }
                else if(ia == partA.length()){
                    if(bias == null) {
                        bias = -1;
                    }
                }
                else if(ib == partB.length()){
                    if(bias == null) {
                        bias = 1;
                    }
                }

                while(ia < partA.length() && ib < partB.length()){
                    if(partA.charAt(ia) < partB.charAt(ib)){
                        return bias != null ? bias : -1;
                    }
                    if(partA.charAt(ia) > partB.charAt(ib)){
                        return bias != null ? bias : 1;
                    }
                    ia++;
                    ib++;
                }
            }
            return 0;
        });
    }
}

class FastScanner {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    String next() {
        while (!st.hasMoreTokens())
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException ignore) {
            }
        return st.nextToken();
    }

    String nextLine(){
        try {
            return br.readLine();
        } catch (IOException e) {


        }
        return "";
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    int[] readArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    long nextLong() {
        return Long.parseLong(next());
    }
}
