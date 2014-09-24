package tetris;

/**
 *
 * @author hudson.sales
 */
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tetris
        extends JFrame {

    JLabel statusbar;

    public Tetris() {
        this.statusbar = new JLabel(" 0");
        add(this.statusbar, "South");
        Board board = new Board(this);
        add(board);
        board.start();

        setSize(200, 400);
        setTitle("Schumaker Team - Tetris");
        setDefaultCloseOperation(3);
    }

    public JLabel getStatusBar() {
        return this.statusbar;
    }

    public static void main(String[] args) {
        Tetris game = new Tetris();
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}
