package stringSearch;

import java.util.ArrayList;

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
        int i = 0, j = 0, matchPosition = 0;
        boolean compared;
        ArrayList<Integer> posList = new ArrayList<>();

        while(i <= t.length()) {
            compared = false;
            operations++; //Om de är lika eller inte
            while(j < p.length() && i < t.length() && t.charAt(i) == p.charAt(j) ) {

                if(compared) {
                    operations++; //Fortsätter att vara lika
                }

                if(j == p.length()-1) {
                    posList.add(matchPosition);
                }
                j++;
                i++;
                compared = true;
            }

            if(j > 0 && temp[j-1] > 0) { //Om den stannar i mitten av en sökning
                matchPosition = i - temp[j - 1];
            }else { // Om j = 0, dvs när första tecknet inte stämde överrens så börja på nästa tecken igen
                if (matchPosition == i) { //Om det är på det första index i texten från där du började, öka till nästa
                    i++;
                }
                matchPosition = i; //Om det är matchning så är det på detta index
            }

            if(j != 0) {
                j = temp[j-1];
            } else {
                i++;
            }
        }
        return posList;
    }

    public int getOperations() {
        return this.operations;
    }

}