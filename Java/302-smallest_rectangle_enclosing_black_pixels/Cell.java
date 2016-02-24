public class Cell {
    int row;
    int col;
    
    public Cell(int r, int c) {
        row = r;
        col = c;
    }
    
    public int hashCode() {
        return row * 10 + col;
    }
    
    public boolean equals(Object c) {
        Cell cc = (Cell)c;
        return (row == cc.row && col == cc.col);
    }
}
