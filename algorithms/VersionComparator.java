import java.util.Comparator;

public class VersionComparator implements Comparator<String> {
    @Override
    public int compare(String versionA, String versionB) {

        String[] partsA = versionA.split("\\.");
        String[] partsB = versionB.split("\\.");

        int i = 0, j = 0;

        while(i < partsA.length && j < partsB.length) {
            String a = partsA[i++];
            String b = partsB[j++];

            int result = comparePart(a, b);

            if(result != 0) {
                return result;
            }
        }

        if(checkLeftover(partsA, i)){
            return 1;
        }

        if(checkLeftover(partsB, j)){
            return -1;
        }

        return 0;
    }

    private boolean checkLeftover(String[] parts, int index){
        if(index >= parts.length){
            return false;
        }

        while(index < parts.length){
            String part = parts[index++];
            for(int i = 0; i < part.length(); i++){
                if(part.charAt(i) != '0'){
                    return true;
                }
            }
        }
        return false;
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
                return nextIsDigit(a, i) && nextIsPoint(b, j) ? 1 : -1;
            }

            if(a.charAt(i) > b.charAt(j)){
                return nextIsDigit(b, j) && nextIsPoint(a, i) ? -1 : 1;
            }

            i++;
            j++;
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

    private boolean nextIsDigit(String version, int index){
        if(++index >= version.length()){
            return false;
        }

        return Character.isDigit(version.charAt(index));
    }

    private boolean nextIsPoint(String version, int index){
        if(++index >= version.length()){
            return true;
        }

        return version.charAt(index) == '.';
    }
}
