package stringSearch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Emil on 2015-12-08.
 */
public class SearchUI {
    private JFrame frame;

    public SearchUI() {

    }

    public void initGUI() {

        JPanel pnlTest = new JPanel();
        pnlTest.setBorder(BorderFactory.createTitledBorder("Text to search in:"));
        pnlTest.setBounds(18, 29, 150, 170);
        pnlTest.setLayout(null);
        frame.add(pnlTest);

        JTextArea tf = new JTextArea();
        tf.setBounds(360,29,250,170);
        tf.setBorder(BorderFactory.createTitledBorder("Output:"));
        tf.setEditable(false);
        frame.add(tf);

        ButtonGroup grpText = new ButtonGroup();
        ButtonGroup grpAlgo = new ButtonGroup();
        JRadioButton rbtnWorst = new JRadioButton("WorstCase",true);
        JRadioButton rbtnBibeln = new JRadioButton("Bibeln",false);

        JRadioButton rbtnNaiv = new JRadioButton("Naiv",true);
        JRadioButton rbtnBoyerMoore = new JRadioButton("Boyer Moore",false);
        JRadioButton rbtnKMP = new JRadioButton("KMP",false);

        JPanel pnlAlgo = new JPanel();
        pnlAlgo.setBorder(BorderFactory.createTitledBorder("Algorithm:"));
        pnlAlgo.setBounds(190, 29, 150, 170);
        pnlAlgo.setLayout(null);
        frame.add(pnlAlgo);

        rbtnNaiv.setBounds(5,35,100,17);
        rbtnBoyerMoore.setBounds(5, 65, 100, 17);
        rbtnKMP.setBounds(5,95,100,17);

        pnlAlgo.add(rbtnKMP);
        pnlAlgo.add(rbtnNaiv);
        pnlAlgo.add(rbtnBoyerMoore);

        rbtnWorst.setBounds(5,35, 100, 17);
        rbtnBibeln.setBounds(5,65,80,17);
        pnlTest.add(rbtnWorst);
        pnlTest.add(rbtnBibeln);

        grpText.add(rbtnWorst);
        grpText.add(rbtnBibeln);

        grpAlgo.add(rbtnKMP);
        grpAlgo.add(rbtnNaiv);
        grpAlgo.add(rbtnBoyerMoore);

        JTextField tf1 = new JTextField();
      //widtch hieght
        tf1.setBounds(5,100,135,50);
        tf1.setBorder(BorderFactory.createTitledBorder("SearchString:"));
        pnlTest.add(tf1);

        pnlTest.setBackground(Color.WHITE);
        rbtnWorst.setBackground(Color.WHITE);
        rbtnBibeln.setBackground(Color.WHITE);
        pnlAlgo.setBackground(Color.WHITE);
        rbtnBoyerMoore.setBackground(Color.WHITE);
        rbtnKMP.setBackground(Color.WHITE);
        rbtnNaiv.setBackground(Color.WHITE);

        tf1.addActionListener(new EnterListener());

    }

    public void startUI() {
        frame = new JFrame();
        frame.setBounds(0, 0, 630, 260);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("String Searcher");
        initGUI();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }


    public static void main(String[] args) {
        SearchUI ui = new SearchUI();
        ui.startUI();
    }

    private class EnterListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("ENTERPRESSED");
        }
    }
}
