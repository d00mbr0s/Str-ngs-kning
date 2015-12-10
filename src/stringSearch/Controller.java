package stringSearch;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Emil on 2015-12-09.
 */
public class Controller {
    private SearchUI ui = new SearchUI(this);
    private ReadFile readFile = new ReadFile();
    private regularSearch naiv = new regularSearch();
    private KnutMorrisPratt  kmp = new KnutMorrisPratt();
    private BoyerMoore boyer = new BoyerMoore();
    private String algorithm;
    private String textToSearch;

    public Controller() {
        ui.startUI();
    }

    public void setAlgorithm(String str) {
        this.algorithm = str;
    }

    public void setTextToSearch(String str) {
        this.textToSearch = str;
    }

    public void searchCooser(String searchString) {
        if (algorithm == "naiv") {
            searchNaiv(searchString, textToSearch);
        } else if (algorithm == "kmp") {
            searchKmp(searchString, textToSearch);
        } else if (algorithm == "boyer") {
            searchBoyer(searchString, textToSearch);
        }
    }

    //klar
    public void searchNaiv(String searchString, String textToSearchIn) {
        String textToSearch = "";
        ArrayList<Integer> al = new ArrayList<>();
        try {
            char[] a = readFile.readFile("./src/"+textToSearchIn+".txt");
            textToSearch = String.valueOf(a);

            naiv.stringSearch(textToSearch, searchString,al);
            for(int i : al) {
                ui.getTf().append("Found in position: "+i +"\n");
            }
            ui.getTf().append("\n"+"T length: "+textToSearch.length() +", P Length: " +searchString.length() +"\n");
            ui.getTf().append("T length * P Length: "+(textToSearch.length()*searchString.length()) +"\n");
            ui.getTf().append("T length + P Length: "+(textToSearch.length()+searchString.length()) +"\n");

            ui.getTf().append("\n"+"Amount of matches: " + al.size() + "\n");
            ui.getTf().append("\n" + "Amount of operations: " + naiv.getOperations());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchKmp(String searchString, String textToSearchIn) {
        String textToSearch = "";
        ArrayList<Integer> al;
        try {
            char[] a = readFile.readFile("./src/"+textToSearchIn+".txt");
            textToSearch = String.valueOf(a);
            al = kmp.search(textToSearch, searchString);
            for(int i :  al) {
                ui.getTf().append("Found in position: "+i +"\n");
            }
            ui.getTf().append("\n"+"T length: "+textToSearch.length() +", P Length: " +searchString.length() +"\n");
            ui.getTf().append("T length * P Length: "+(textToSearch.length()*searchString.length()) +"\n");
            ui.getTf().append("T length + P Length: "+(textToSearch.length()+searchString.length()) +"\n");

            ui.getTf().append("\n"+"Amount of matches: " + al.size() + "\n");
            ui.getTf().append("\n" + "Amount of operations: " + kmp.getOperations());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchBoyer(String searchString, String textToSearchIn) {
        String textToSearch = "";
        ArrayList<Integer> al;
        try {
            char[] a = readFile.readFile("./src/"+textToSearchIn+".txt");
            textToSearch = String.valueOf(a);
            al = boyer.search(textToSearch, searchString);
            for(int i :  al) {
                ui.getTf().append("Found in position: "+i +"\n");
            }
            ui.getTf().append("\n"+"T length: "+textToSearch.length() +", P Length: " +searchString.length() +"\n");
            ui.getTf().append("T length * P Length: "+(textToSearch.length()*searchString.length()) +"\n");
            ui.getTf().append("T length + P Length: "+(textToSearch.length()+searchString.length()) +"\n");

            ui.getTf().append("\n" + "Amount of matches: " + al.size() + "\n");
            ui.getTf().append("\n"+"Amount of operations: " + boyer.getOperations());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Controller();
    }
}
