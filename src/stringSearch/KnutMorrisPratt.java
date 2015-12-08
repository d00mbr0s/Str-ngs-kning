package stringSearch;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=GTJr8OvyEVQ
public class KnutMorrisPratt {

    public int[] pre (String p) {
        int[] preArray = new int[p.length()];
        preArray[0] = 0;
        int j = 0;
        for (int i = 1; i < p.length();) {
            if(p.charAt(i) == p.charAt(j) ) {
                preArray[i] = j + 1;
                j++;
                i++;
            } else {
                if(j != 0) {
                    j = preArray[j-1];
                } else {
                    preArray[i] = 0;
                    i++;
                }
            }
        }
        for(int i : preArray) {
            System.out.print(i + ", ");
        }
        return preArray;
    }

    public ArrayList<Integer> search(String t, String p) {
        int[] temp = pre(p);
        int i = 0, j = 0;
        ArrayList<Integer> posList = new ArrayList<>();

        while(i < t.length() && j < p.length()) {
            if(t.charAt(i) == p.charAt(j)) {
                j++;
                i++;
            } else {
                if(j != 0) {
                    j = temp[j-1];
                } else {
                    i++;
                }
            }
            if(j == p.length()) {
                posList.add(i-p.length());
                //  return i - p.length();
                j = 0;
            }
        }
        return posList;
    }

}