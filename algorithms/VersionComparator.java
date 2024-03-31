import java.util.Comparator;

public class VersionComparator implements Comparator<String> {
    @Override
    public int compare(String versionA, String versionB) {

        String[] partsA = versionA.split("\\.");
        String[] partsB = versionB.split("\\.");

        int i = 0, j = 0;

        Integer bias = null;

        while(i < partsA.length && j < partsB.length) {
            String a = partsA[i++];
            String b = partsB[j++];

            int result = comparePart(a, b);

            if(result == 0) {
                if(a.length() != b.length() && bias == null) {
                    bias = Integer.compare(b.length(), a.length());
                }
            }
            else {
                return result;
            }
        }

        return bias == null ? (partsA.length - partsB.length) : bias;
    }

    private int comparePart(String a, String b){

        int i = 0, j = 0;

        while(i < a.length() && a.charAt(i) == '0'){
            i++;
        }
        while(j < b.length() && b.charAt(j) == '0'){
            j++;
        }

        while(i < a.length() && j < b.length()){
            if(a.charAt(i) < b.charAt(j)){
                return -1;
            }
            if(a.charAt(i++) > b.charAt(j++)){
                return 1;
            }
        }

        if(i == a.length() && j == b.length()){
            return 0;
        }

        if(i == a.length()){
            return -1;
        }

        if(j == b.length()){
            return 1;
        }

        return 0;
    }
}
