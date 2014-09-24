package tetris;

/**
 *
 * @author hudson.sales
 */
import java.util.Random;

public class Shape {

    private Tetrominoes pieceShape;
    private int[][] coords;
    private int[][][] coordsTable;

    static enum Tetrominoes {

        NoShape, ZShape, SShape, LineShape, TShape, SquareShape, LShape, MirroredLShape;

        private Tetrominoes() {
        }
    }

    public Shape() {
        this.coords = new int[4][2];
        setShape(Tetrominoes.NoShape);
    }

    public void setShape(Tetrominoes shape) {
        this.coordsTable = new int[][][]{{{0, 0}, {0, 0}, {0, 0}, {0, 0}}, {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}}, {{0, -1}, {0, 0}, {1, 0}, {1, 1}}, {{0, -1}, {0, 0}, {0, 1}, {0, 2}}, {{-1, 0}, {0, 0}, {1, 0}, {0, 1}}, {{0, 0}, {1, 0}, {0, 1}, {1, 1}}, {{-1, -1}, {0, -1}, {0, 0}, {0, 1}}, {{1, -1}, {0, -1}, {0, 0}, {0, 1}}};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                this.coords[i][j] = this.coordsTable[shape.ordinal()][i][j];
            }
        }
        this.pieceShape = shape;
    }

    private void setX(int index, int x) {
        this.coords[index][0] = x;
    }

    private void setY(int index, int y) {
        this.coords[index][1] = y;
    }

    public int x(int index) {
        return this.coords[index][0];
    }

    public int y(int index) {
        return this.coords[index][1];
    }

    public Tetrominoes getShape() {
        return this.pieceShape;
    }

    public void setRandomShape() {
        Random r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;
        Tetrominoes[] values = Tetrominoes.values();
        setShape(values[x]);
    }

    public int minX() {
        int m = this.coords[0][0];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, this.coords[i][0]);
        }
        return m;
    }

    public int minY() {
        int m = this.coords[0][1];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, this.coords[i][1]);
        }
        return m;
    }

    public Shape rotateLeft() {
        if (this.pieceShape == Tetrominoes.SquareShape) {
            return this;
        }
        Shape result = new Shape();
        result.pieceShape = this.pieceShape;
        for (int i = 0; i < 4; i++) {
            result.setX(i, y(i));
            result.setY(i, -x(i));
        }
        return result;
    }

    public Shape rotateRight() {
        if (this.pieceShape == Tetrominoes.SquareShape) {
            return this;
        }
        Shape result = new Shape();
        result.pieceShape = this.pieceShape;
        for (int i = 0; i < 4; i++) {
            result.setX(i, -y(i));
            result.setY(i, x(i));
        }
        return result;
    }
}
