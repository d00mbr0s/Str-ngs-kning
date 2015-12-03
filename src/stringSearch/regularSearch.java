package stringSearch;

import java.util.ArrayList;

public class regularSearch {

    public void stringSearch(String T, String P, ArrayList<Integer> pos) {
        for(int i = 0; i <= T.length() - P.length(); i ++) {
            boolean mismatch = false;
            for(int j = 0; !mismatch && j < P.length(); j++) {
                mismatch = P.charAt(j) != T.charAt(i + j);
            }
            if(!mismatch) {
                pos.add(i);
            }
        }
    }

    public static void main(String[] args) {
        regularSearch rs = new regularSearch();
        ArrayList<Integer> al = new ArrayList<Integer>();
        rs.stringSearch("abcdeabclkljkjkabc", "hej", al);

        for(int i : al) {
            System.out.println(i);
        }
    }


}
