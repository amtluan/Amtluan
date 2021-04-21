/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_notepad;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Hứa Minh Luân
 */
public class FindAndReplace extends JDialog implements ActionListener {

    boolean foundOne, isReplace;
    JTextField searchText, replaceText;
    JCheckBox cbCase, cbWhole;
    JRadioButton up, down;
    JLabel statusinfo;
    JFrame owner;
    JPanel north, center, south;

    public FindAndReplace(JFrame owner, boolean isReplace) {
        super(owner, true);
        this.isReplace = isReplace;

        north = new JPanel();
        center = new JPanel();
        south = new JPanel();
        if (isReplace) {
            setTitle("Find and Replae");
        } else {
            setTitle("Find");
            setFindPanel(north);
        }
        addComponent(center);
        statusinfo = new JLabel("Status Infor");
        south.add(statusinfo);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                dispose();
            }

        });
        getContentPane().add(north, BorderLayout.NORTH);
        getContentPane().add(center, BorderLayout.CENTER);
        getContentPane().add(south, BorderLayout.SOUTH);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        int x = (owner.getWidth() * 3 / 5) - (getWidth() / 2);
        int y = (owner.getHeight() * 3 / 5) - (getHeight() / 2);
        setLocation(x, y);

        setVisible(true);

    }

    private void addComponent(JPanel center) {
        JPanel east = new JPanel();
        JPanel west = new JPanel();
        center.setLayout(new GridLayout(1, 2));
        east.setLayout(new GridLayout(2, 1));
        west.setLayout(new GridLayout(2, 1));
        cbCase = new JCheckBox("Match Case", true);
        cbWhole = new JCheckBox("Mathch word", true);
        ButtonGroup group = new ButtonGroup();
        up = new JRadioButton("Search Up", false);
        down = new JRadioButton("Search Down", false);
        group.add(up);
        group.add(down);
        east.add(cbCase);
        east.add(cbWhole);
        east.setBorder(BorderFactory.createTitledBorder("Search Optioms:"));
        west.add(up);
        west.add(down);
        east.setBorder(BorderFactory.createTitledBorder("Search Directon:"));
        center.add(east);
        center.add(west);
    }

    private void setFindPanel(JPanel north) {
        final JButton NEXT = new JButton("Find Next");
        NEXT.addActionListener(this);
        NEXT.setEnabled(false);
        searchText = new JTextField(20);
        searchText.addActionListener(this);
        searchText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                boolean state = (searchText.getDocument().getLength() > 0);
                NEXT.setEnabled(true);
                foundOne = false;
            }

        });
        if (searchText.getText().length() > 0) {
            NEXT.setEnabled(true);

        }
        north.add(new JLabel("Find Word: "));
        north.add(searchText);
        north.add(NEXT);

    }

    private void setReplacePanel(JPanel north) {
        GridBagLayout grid = new GridBagLayout();
        north.setLayout(grid);
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.HORIZONTAL;
        JLabel lblFword = new JLabel(" Find Word");
        JLabel lblRword = new JLabel(" Find Word1");
        final JButton NEXT = new JButton("Replace");
        NEXT.addActionListener(this);
        NEXT.setEnabled(false);
        final JButton REPLACE = new JButton("Replace");
        REPLACE.addActionListener(this);
        REPLACE.setEnabled(false);
        searchText = new JTextField(20);
        replaceText = new JTextField(20);
        replaceText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                boolean state = (replaceText.getDocument().getLength() > 0);
                NEXT.setEnabled(true);
                REPLACE.setEnabled(true);
                foundOne = false;
            }

        });
        con.gridx = 0;
        con.gridy = 0;
        grid.setConstraints(lblFword, con);
        north.add(lblFword);
        con.gridx = 1;
        con.gridy = 0;
        grid.setConstraints(searchText, con);
        north.add(searchText);
        con.gridx = 2;
        con.gridy = 0;
        grid.setConstraints(NEXT, con);
        north.add(NEXT);
        con.gridx = 0;
        con.gridy = 1;
        grid.setConstraints(lblRword, con);
        north.add(lblRword);
        con.gridx = 1;
        con.gridy = 1;
        grid.setConstraints(replaceText, con);
        north.add(replaceText);
        con.gridx = 2;
        con.gridy = 1;
        grid.setConstraints(REPLACE, con);
        north.add(REPLACE);

    }

    private void setFinfAndReplacePanel() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(searchText) || e.getSource().equals(replaceText)) {
            validate();
        }
        Process();
    }

    private void Process() {
        if (isReplace) {
            statusinfo.setText("Replacing" + searchText.getText());
        } else {
            statusinfo.setText("Searching for " + searchText.getText());

        }
        int caret = Java_notepad.getArea().getCaretPosition();
        String word = getWord();
        String text = getAllText();
        caret = search(text, word, caret);
        if (caret < 0) {
            endResult(false, 0);
        }
    }

    private void endResult(boolean isReplaceAll, int tally) {
        String message = "";
        if (isReplace) {

        } else {
            String str = "";
            if (isSacrchDown()) {
                str = "Search Down";
            } else {
                str = "Search Up";

            }
            if (foundOne && !isReplace) {
                message = "End od" + str + "for " + searchText.getText();

            } else if (foundOne && !isReplace) {
                message = "End of Replace" + searchText.getText() + "with " + replaceText.getText();

            }
        }
        statusinfo.setText(message);

    }

    private int search(String text, String word, int caret) {
        boolean found = false;
        int all = text.length();
        int check = word.length();
        if (isSacrchDown()) {
            int add = 0;
            for (int i = caret + 1; i < (all - check); i++) {
                String temp = text.substring(i, (i + check));
                if (temp.equals(word)) {
                    if (wholeWordIsSelected()) {
                        if (checkForWholeWorld(check, text, add, caret)) {
                            caret = i;
                            found = true;
                            break;
                        }
                    } else {
                        caret = i;
                        found = true;
                        break;
                    }
                }

            }
        } else {
            int add = caret;
            for (int i = caret; i < check; i--) {
                add--;
                String temp = text.substring((i - check), i);

            }
        }
        Java_notepad.getArea().setCaretPosition(0);
        if (found) {
            Java_notepad.getArea().requestFocus();
            if (isSacrchDown()) {
                Java_notepad.getArea().select(caret, caret + check);

            } else {
                Java_notepad.getArea().select(caret, caret + check);
            }
            foundOne = true;
            return caret;
        } if(isReplace){
            String replace = replaceText.getText();
            Java_notepad.getArea().replaceSelection(replace);
            if(isSacrchDown()){
                Java_notepad.getArea().select(caret, check+ replace.length());
            }else{
                Java_notepad.getArea().select(caret-replace.length(), caret);
            }
        }
        return -1;

    }

    private String getAllText() {
        if (caseNotSeclected()) {
            return Java_notepad.getArea().getText().toLowerCase();

        }
        return Java_notepad.getArea().getText();
    }

    private String getWord() {
        if (caseNotSeclected()) {
            return searchText.getText().toLowerCase();

        }
        return searchText.getText();
    }

    private boolean caseNotSeclected() {
        return !cbCase.isSelected();
    }

    private boolean isSacrchDown() {
        return down.isSelected();
    }

    private boolean wholeWordIsSelected() {
        return cbWhole.isSelected();

    }

    private boolean checkForWholeWorld(int check, String text, int add, int caret) {
        int offsetLeft = (caret + add) - 1;
        int offsetRight = (caret + add) + check;

        if ((offsetLeft < 0) || offsetRight > text.length()) {
            return true;
        }
        return ((!Character.isLetterOrDigit(text.charAt(offsetLeft))) && (!Character.isLetterOrDigit(text.charAt(offsetRight))));
    }
}
