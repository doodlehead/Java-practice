public class CompareVersionNumbers {

    //Return 1 if v1 > v2
    //Return -1 if v1 < v2
    //Strings only contain digits and '.' also must ignore leading zeroes
    //Runtime: 1 ms
    //Memory usage: 36.9 MB
    public int compareVersion(String version1, String version2) {
        String[] t1 = version1.split("\\.");
        String[] t2 = version2.split("\\.");

        int c1, c2;
        for (int i = 0; i < Integer.max(t1.length, t2.length); i++) {
            c1 = (i < t1.length) ? Integer.parseInt(t1[i]) : 0;
            c2 = (i < t2.length) ? Integer.parseInt(t2[i]) : 0;

            if (c1 > c2)
                return 1;
            else if (c1 < c2)
                return -1;
        }
        return 0;
    }
}
