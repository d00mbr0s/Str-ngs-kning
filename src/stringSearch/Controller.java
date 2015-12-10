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

    public Controller() {
        ui.startUI();
    }

    public void searchCooser() {

    }

    public void searchNaiv(String searchString) {

    }

    public void searchKmp(String searchString) {

    }

    public void searchBoyer(String searchString) {
        String textToSearch = "";
        ArrayList<Integer> al = new ArrayList<>();
        try {
            char[] a = readFile.readFile("./src/bible-en.txt");
            textToSearch = String.valueOf(a);

            naiv.stringSearch(textToSearch, searchString,al);
            for(int i : al) {
                System.out.println(i);
            }
            System.out.println("Antal matchningar: " + al.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Controller();
    }
}
