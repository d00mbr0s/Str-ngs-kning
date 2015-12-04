package stringSearch;


import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) {
        KnutMorrisPratt kmp = new KnutMorrisPratt();
        String t = "1002100210021002100210021002100210012";
        String p = "10012";
        System.out.println("t length " + t.length() + " p length " + p.length());
        System.out.println("KMP");
        System.out.println("Hittat i = " + kmp.search(t, p));


        System.out.println();
        System.out.println();
        System.out.println();

        ArrayList<Integer> positions = new ArrayList<>();
        regularSearch rs = new regularSearch();
        System.out.println("Naive Search");
        rs.stringSearch(t,p,positions);

        for(int i : positions) {
            System.out.print(" Hittat i position: " + i);
        }


    }
}
