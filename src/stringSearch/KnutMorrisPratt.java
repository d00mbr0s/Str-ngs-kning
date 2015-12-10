package stringSearch;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=GTJr8OvyEVQ
public class KnutMorrisPratt {
    private int operations;

    public int[] pre (String p) {
        operations = 0;
        int[] preArray = new int[p.length()];
        preArray[0] = 0;
        int j = 0;
        for (int i = 1; i < p.length();) {
            operations++;
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
        return preArray;
    }

    public ArrayList<Integer> search(String t, String p) {
        System.out.println("KMP");
        int[] temp = pre(p);
        int i = 0, j = 0;
        ArrayList<Integer> posList = new ArrayList<>();

        while(i < t.length() && j < p.length()) {
            operations++;
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
                i = (i - p.length()) +1;
            }
        }
        return posList;
    }

    public int getOperations() {
        return this.operations;
    }

}