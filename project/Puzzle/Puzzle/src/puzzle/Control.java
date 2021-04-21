package puzzle;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Control {

    private Timer timer;
    private PuzzleGUI p;
    private JPanel pn;
    private int size = 3;
    private JButton[][] matrix;
    private boolean isGameStart = false;
    private int moveCount = 0;

    public Control(PuzzleGUI p, JPanel pn) {
        this.p = p;
        this.pn = pn;
        addButton();
    }
    public void countTime() {
        p.lblCountTime.setText("0");
        timer = new Timer(1000, new ActionListener() {
            int second = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                second++;
                p.lblCountTime.setText(String.valueOf(second));
            }
        });
        timer.start();
    }

    public void run() {
//        this.countMove();
        this.countTime();
        this.addButton();
        isGameStart = true;
    }

    public void addButton() {
        size = p.cbxSize.getSelectedIndex() + 3;
        pn.removeAll();
        pn.setLayout(new GridLayout(size, size, 10, 10));
        pn.setPreferredSize(new Dimension(size * 60, size * 60));
        matrix = new JButton[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton btn = new JButton(i * size + j + 1 + "");
                matrix[i][j] = btn;
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (isGameStart) {
                            // kiem tra button co move sang duoc o trong ko 
                            if (checkMove(btn)) {
                                moveButton(btn);
                                if (checkWin()) {
                                    isGameStart = false;
                                    JOptionPane.showMessageDialog(null, "You won!");
                                    timer.stop();
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Press New Game to start");
                        }
                    }
                });
                pn.add(btn);
            }
        }
        matrix[size - 1][size - 1].setText("");
        randomMatrix();
        p.pack();
    }

    public Point getPosition() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j].getText().equals("")) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    public void randomMatrix() {
        for (int i = 0; i < 1000; i++) {
            Point p = getPosition();
            int x = p.x;
            int y = p.y;
            Random r = new Random();
            int n = r.nextInt(4);
            switch (n) {
                case 0://up
                    if (y > 0) {
                        matrix[x][y].setText(matrix[x][y - 1].getText());
                        matrix[x][y - 1].setText("");
                    }
                    break;
                case 1:
                    if (y < size - 1) {
                        matrix[x][y].setText(matrix[x][y + 1].getText());
                        matrix[x][y + 1].setText("");
                    }
                    break;
                case 2:
                    if (x > 0) {
                        matrix[x][y].setText(matrix[x - 1][y].getText());
                        matrix[x - 1][y].setText("");
                    }
                    break;
                case 3:
                    if (x < size - 1) {
                        matrix[x][y].setText(matrix[x + 1][y].getText());
                        matrix[x + 1][y].setText("");
                    }
                    break;
            }
        }

    }

    public boolean checkMove(JButton btn) {
        if (btn.getText().equals("")) {
            return false;
        }
        Point p = getPosition();
        Point p1 = null;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j].getText().equals(btn.getText())) {
                    p1 = new Point(i, j);
                }
            }
        }
        if (p.x == p1.x && Math.abs(p.y - p1.y) == 1) {
            return true;
        }
        if (p.y == p1.y && Math.abs(p.x - p1.x) == 1) {
            return true;
        }
        return false;
    }

    public void moveButton(JButton btn) {
        Point p = getPosition();
        matrix[p.x][p.y].setText(btn.getText());
        btn.setText("");
    }

    public boolean checkWin() {
        if (!matrix[size - 1][size - 1].getText().equals("")) {
            return false;
        }
        int a = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a++;
                if ((i != size - 1) && (j != size - 1)) {
                    if (!matrix[i][j].getText().equals(a + "")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void newGame() {
        if (isGameStart) {
            timer.stop();
            int confirm = JOptionPane.showConfirmDialog(null, "Do you must"
                    + " be want to make new game?", "New Game", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                this.run();
            } else if (confirm == JOptionPane.NO_OPTION) {
                timer.start();
            }
        } else {
            this.run();
        }
    }
}
