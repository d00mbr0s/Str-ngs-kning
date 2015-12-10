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
    private JTextArea tf;
    private ButtonGroup grpText;
    private ButtonGroup grpAlgo;
    private JTextField tf1;
    private JRadioButton rbtnWorst = new JRadioButton("WorstCase",true);
    private JRadioButton rbtnBibeln = new JRadioButton("Bibeln",false);
    private JRadioButton rbtnNaiv = new JRadioButton("Naiv",true);
    private JRadioButton rbtnBoyerMoore = new JRadioButton("Boyer Moore",false);
    private JRadioButton rbtnKMP = new JRadioButton("KMP",false);
    private JRadioButton rbtnAlfa = new JRadioButton("Alphabet",false);
    private Controller controller;
    private JButton btnSearch = new JButton("Search");


    public SearchUI(Controller controller) {
        this.controller = controller;
    }

    public void initGUI() {

        JPanel pnlTest = new JPanel();
        pnlTest.setBorder(BorderFactory.createTitledBorder("Text to search in:"));
        pnlTest.setBounds(18, 29, 150, 170);
        pnlTest.setLayout(null);
        frame.add(pnlTest);

        tf = new JTextArea();
        tf.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(tf);
        scrollPane.setBounds(18,220,320,170);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Output"));
        frame.add(scrollPane);

        grpText = new ButtonGroup();
        grpAlgo = new ButtonGroup();

        JPanel pnlAlgo = new JPanel();
        pnlAlgo.setBorder(BorderFactory.createTitledBorder("Algorithm:"));
        pnlAlgo.setBounds(190, 29, 150, 130);
        pnlAlgo.setLayout(null);
        frame.add(pnlAlgo);
        //xy w h
        btnSearch.setBounds(190,170,150,30);
        frame.add(btnSearch);


        rbtnNaiv.setBounds(5,35,100,17);
        rbtnBoyerMoore.setBounds(5, 65, 100, 17);
        rbtnKMP.setBounds(5,95,100,17);

        pnlAlgo.add(rbtnKMP);
        pnlAlgo.add(rbtnNaiv);
        pnlAlgo.add(rbtnBoyerMoore);

        rbtnWorst.setBounds(5,25, 100, 17);
        rbtnBibeln.setBounds(5,50,80,17);
        rbtnAlfa.setBounds(5,75,80,17);

        pnlTest.add(rbtnAlfa);
        pnlTest.add(rbtnWorst);
        pnlTest.add(rbtnBibeln);

        grpText.add(rbtnWorst);
        grpText.add(rbtnBibeln);
        grpText.add(rbtnAlfa);

        grpAlgo.add(rbtnKMP);
        grpAlgo.add(rbtnNaiv);
        grpAlgo.add(rbtnBoyerMoore);

        tf1 = new JTextField();
        tf1.setBounds(5,100,135,50);
        tf1.setBorder(BorderFactory.createTitledBorder("SearchString:"));
        tf1.setToolTipText("Enter text here");
        pnlTest.add(tf1);

        pnlTest.setBackground(Color.WHITE);
        rbtnWorst.setBackground(Color.WHITE);
        rbtnBibeln.setBackground(Color.WHITE);
        pnlAlgo.setBackground(Color.WHITE);
        rbtnBoyerMoore.setBackground(Color.WHITE);
        rbtnKMP.setBackground(Color.WHITE);
        rbtnNaiv.setBackground(Color.WHITE);
        rbtnAlfa.setBackground(Color.WHITE);

        EnterListener listener = new EnterListener();
        tf1.addActionListener(listener);
        btnSearch.addActionListener(listener);
        scrollPane.setBackground(Color.WHITE);

    }

    public void startUI() {
        frame = new JFrame();
        frame.setBounds(0, 0, 365, 440);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("String Searcher");
        initGUI();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    public JTextArea getTf() {
        return this.tf;
    }

    private class EnterListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (btnSearch == e.getSource()) {
                tf.setText("");
                if (rbtnAlfa.isSelected()) {
                    controller.setTextToSearch("Alfabet");
                }
                if (rbtnBibeln.isSelected()) {
                    controller.setTextToSearch("bible-en");
                }
                if (rbtnBoyerMoore.isSelected()) {
                    controller.setAlgorithm("boyer");
                }
                if (rbtnKMP.isSelected()) {
                    controller.setAlgorithm("kmp");
                }
                if (rbtnNaiv.isSelected()) {
                    controller.setAlgorithm("naiv");
                }
                if (rbtnWorst.isSelected()) {
                    controller.setTextToSearch("many-as");
                }
                controller.searchCooser(tf1.getText());
            }
        }
    }
}
