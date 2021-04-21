package java_notepad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.StringTokenizer;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class Java_notepad extends JFrame {

    static JTextArea mainarea;
    JMenuBar mbar;
    JMenu mnuFile, mnuEdit, mnuFormat, mnuHelp;
    JMenuItem itmNew, itmOpen, itmSave, itmSaveas, itmExit,
            itmCut, itmCopy, itmPaste, itmFontCol, itmFind, itmReplace;
    String filename;
    JFileChooser jc;
    String FileContent;
    UndoManager undo;
    UndoAction undoAction;
    RedoAction redoAction;
    String findText;
   // public static Java_notepad frmMain = new Java_notepad();

    public Java_notepad() {
        initComponent();

        itmSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        itmSaveas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAs();
            }
        });

        itmOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });

        itmNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open_new();
            }
        });
        itmExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        itmCut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainarea.cut();
            }
        });

        itmCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainarea.copy();
            }
        });

        itmPaste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainarea.paste();
            }
        });
        mainarea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undo.addEdit(e.getEdit());
                undoAction.update();
                redoAction.update();
            }
        });

        itmFontCol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = JColorChooser.showDialog(rootPane, "Chooser Font Color", Color.yellow);
                mainarea.setForeground(c);
            }
        });
//
//        itmFind.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new FindAndReplace(frmMain, false);
//            }
//        });
//        itmReplace.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new FindAndReplace(frmMain, false );
//            }
//        });

    }

    private void initComponent() {
        jc = new JFileChooser(".");
        mainarea = new JTextArea();
        undo = new UndoManager();
        ImageIcon iconUndo = new ImageIcon(getClass().getResource("/img/undo.png"));
        ImageIcon iconRedo = new ImageIcon(getClass().getResource("/img/redo.png"));
        undoAction = new UndoAction(iconUndo);
        redoAction = new RedoAction(iconRedo);

        getContentPane().add(mainarea);
        getContentPane().add(new JScrollPane(mainarea), BorderLayout.CENTER);
        setTitle("Untitled Notepad");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //menubar
        mbar = new JMenuBar();
        //menu
        mnuFile = new JMenu("File");
        mnuEdit = new JMenu("Edit");
        mnuFormat = new JMenu("Format");
        mnuHelp = new JMenu("Help");

        //add icon to menu item
        ImageIcon iconNew = new ImageIcon(getClass().getResource("/img/new.png"));
        ImageIcon iconOpen = new ImageIcon(getClass().getResource("/img/open.png"));
        ImageIcon iconSave = new ImageIcon(getClass().getResource("/img/Save.png"));
        ImageIcon iconSaveas = new ImageIcon(getClass().getResource("/img/Saveas.png"));
        ImageIcon iconExit = new ImageIcon(getClass().getResource("/img/Exit.png"));
        ImageIcon iconCut = new ImageIcon(getClass().getResource("/img/cut.png"));
        ImageIcon iconCopy = new ImageIcon(getClass().getResource("/img/copy.png"));
        ImageIcon iconPaste = new ImageIcon(getClass().getResource("/img/paste.png"));
        ImageIcon iconFind = new ImageIcon(getClass().getResource("/img/find.png"));
        ImageIcon iconReplace = new ImageIcon(getClass().getResource("/img/replace.png"));
        // menu item
        itmNew = new JMenuItem("New", iconNew);
        itmOpen = new JMenuItem("Open", iconOpen);
        itmSave = new JMenuItem("Save", iconSave);
        itmSaveas = new JMenuItem("Save as", iconSaveas);
        itmExit = new JMenuItem("Exit", iconExit);
        itmCut = new JMenuItem("Cut", iconCut);
        itmCopy = new JMenuItem("Copy", iconCopy);
        itmPaste = new JMenuItem("Paste", iconPaste);
        itmFontCol = new JMenuItem("Font Color");
        itmFind = new JMenuItem("Find", iconFind);
        itmReplace = new JMenuItem("Replace", iconReplace);

        // add menu item 
        mnuFile.add(itmNew);
        mnuFile.add(itmOpen);
        mnuFile.add(itmSave);
        mnuFile.add(itmSaveas);
        mnuFile.addSeparator();
        mnuFile.add(itmExit);

        mnuEdit.add(undoAction);
        mnuEdit.add(redoAction);
        mnuEdit.add(itmCut);
        mnuEdit.add(itmCopy);
        mnuEdit.add(itmPaste);
        mnuEdit.add(itmFind);
        mnuEdit.add(itmReplace);

        mnuFormat.add(itmFontCol);

        //adding short cut
        itmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        itmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        itmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        itmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        itmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        itmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

        //add mune item to mnu bar
        mbar.add(mnuFile);
        mbar.add(mnuEdit);
        mbar.add(mnuFormat);
        mbar.add(mnuHelp);

        // add menu bar to frame
        setJMenuBar(mbar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void save() {

        PrintWriter fout = null;
        int retval = -1;

        try {
            if (filename == null) {
                saveAs();
            } else {
                fout = new PrintWriter(new FileWriter(filename));
                String s = mainarea.getText();
                StringTokenizer st = new StringTokenizer(s, System.getProperty("line.separator"));
                while (st.hasMoreElements()) {
                    fout.println(st.nextToken());
                }
                JOptionPane.showMessageDialog(rootPane, "File saved");

            }
        } catch (IOException e) {

        } finally {
            if (fout != null) {
                fout.close();
            }
        }
    }

    private void saveAs() {
        PrintWriter fout = null;
        int retval = -1;
        try {
            retval = jc.showSaveDialog(this);

            if (retval == JFileChooser.APPROVE_OPTION) {
                fout = new PrintWriter(new FileWriter(jc.getSelectedFile()));
            }

            String s = mainarea.getText();
            StringTokenizer st = new StringTokenizer(s, System.getProperty("line.separator"));
            while (st.hasMoreElements()) {
                fout.println(st.nextToken());
            }
            JOptionPane.showMessageDialog(rootPane, "File saved");
            FileContent = mainarea.getText();
            filename = jc.getSelectedFile().getName();
            setTitle(filename = jc.getSelectedFile().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void open() {
        try {
            int retval = jc.showOpenDialog(this);
            if (retval == JFileChooser.APPROVE_OPTION) {
                mainarea.setText(null);
                Reader in = new FileReader(jc.getSelectedFile());
                char[] buff = new char[1000000];
                int nch;
                while ((nch = in.read(buff, 0, buff.length)) != -1) {
                    mainarea.append(new String(buff, 0, nch));
                }

            }
            filename = jc.getSelectedFile().getName();
            setTitle(filename = jc.getSelectedFile().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void open_new() {
        if (!mainarea.getText().equals("") && !mainarea.getText().equals(FileContent)) {

            if (filename == null) {
                int option = JOptionPane.showConfirmDialog(rootPane, "Do you want to save the changes?");
                if (option == 0) {
                    saveAs();
                    clear();

                } else if (option == 2) {

                } else {
                    clear();
                }
            } else {
                int option = JOptionPane.showConfirmDialog(rootPane, "Do you want to save the changes?");
                save();
                clear();
            }

        } else {
            clear();
        }
    }

    private void clear() {
        mainarea.setText(null);
        setTitle("Untitled Notepad");
        filename = null;
        FileContent = null;
    }

    class UndoAction extends AbstractAction {

        public UndoAction(ImageIcon undoIcon) {
            super("Undo", undoIcon);
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                undo.undo();
            } catch (CannotUndoException ex) {
                ex.printStackTrace();
            }
            update();
            redoAction.update();
        }

        protected void update() {
            if (undo.canUndo()) {
                setEnabled(true);
                putValue(Action.NAME, "Redo");
            } else {
                setEnabled(false);
                putValue(Action.NAME, "Redo");
            }
        }

    }

    class RedoAction extends AbstractAction {

        public RedoAction(ImageIcon redoIcon) {
            super("Redo", redoIcon);
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                undo.redo();
            } catch (CannotUndoException ex) {
                ex.printStackTrace();
            }
            update();
            undoAction.update();
        }

        protected void update() {
            if (undo.canUndo()) {
                setEnabled(true);
                putValue(Action.NAME, "Redo");
            } else {
                setEnabled(false);
                putValue(Action.NAME, "Redo");
            }

        }

    }

    public static void main(String[] args) {
        Java_notepad jn = new Java_notepad();
    }

    public static JTextArea getArea() {
        return mainarea;
    }
}
