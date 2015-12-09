package stringSearch;

import java.util.ArrayList;

public class BoyerMoore {

    public int[] preWorkPattern(String p) {
        int [] right = new int[256];
        for (int c = 0; c < right.length; c++) {
            right[c] = -1;
        }
        for (int j = 0; j < p.length(); j++) {
            right[p.charAt(j)] = j;
        }
         return right;
    }

    public ArrayList<Integer> search(String t, String p) {
        int[] right = preWorkPattern(p);
        ArrayList<Integer> newArrayInt = new ArrayList<>();
        int skip;
        for (int i = 0; i <= t.length() - p.length(); i += skip) {
            skip = 0;
            for (int j = p.length()-1; j >= 0; j--) {
                if (p.charAt(j) != t.charAt(i+j)) {
                    skip = Math.max(1, j - right[t.charAt(i+j)]);
                    break;
                }
            }
            if (skip == 0) {
                newArrayInt.add(i);
                skip++;
            }
        }
        if (newArrayInt.isEmpty()) {
            newArrayInt.add(-1);
        }
        return newArrayInt;
    }

    public static void main(String[] args) {
        String pat = "asdf";
        String txt = "asdf ghjk klll abc qwerty abc and poaslf abc";

        BoyerMoore boyermoore1 = new BoyerMoore();

        ArrayList<Integer> offset = boyermoore1.search(txt, pat);

        System.out.println("Found: "+ offset);
    }
}