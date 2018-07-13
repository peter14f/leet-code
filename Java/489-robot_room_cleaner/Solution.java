import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    interface Robot {
        // returns true if next cell is open and robot moves into the cell.
        // returns false if next cell is obstacle and robot stays on the current cell.
        public boolean move();
        public void turnLeft();
        public void turnRight();
        public void clean();
    }

    enum Direction {
        UP,
        RIGHT,
        DOWN,
        LEFT,
    }

    private String keyForCell(int x, int y) {
        return x + "," + y;
    }

    public void cleanRoom(Robot robot) {
        // The robot initially faces up
        Direction curDir = Direction.UP;
        Set<String> visited = new HashSet<>();
        dfsCleanRoom(robot, curDir, 0, 0, visited);
    }

    // note that this method is supposed to be called on a particular cell 
    // (x, y) once
    private void dfsCleanRoom(Robot r, Direction curDir, 
            int x, int y, Set<String> visited) {
        Direction origDir = curDir;
        r.clean();
        visited.add(keyForCell(x, y));

        // UP
        faceUp(r, curDir);
        curDir = Direction.UP;
        if (!visited.contains(keyForCell(x-1, y)) && r.move()) {
            dfsCleanRoom(r, curDir, x-1, y, visited);
            curDir = Direction.DOWN;
        }
        // RIGHT
        faceRight(r, curDir);
        curDir = Direction.RIGHT;
        if (!visited.contains(keyForCell(x, y+1)) && r.move()) {
            dfsCleanRoom(r, curDir, x, y+1, visited);
            curDir = Direction.LEFT;
        }
        // DOWN
        faceDown(r, curDir);
        curDir = Direction.DOWN;
        if (!visited.contains(keyForCell(x+1, y)) && r.move()) {
            dfsCleanRoom(r, curDir, x+1, y, visited);
            curDir = Direction.UP;
        }
        // LEFT
        faceLeft(r, curDir);
        curDir = Direction.LEFT;
        if (!visited.contains(keyForCell(x, y-1)) && r.move()) {
            dfsCleanRoom(r, curDir, x, y-1, visited);
            curDir = Direction.RIGHT;
        }

        // go back to the cell where we came from
        // if at origin, we're done
        if (x==0 && y==0) {
            return;
        }

        if (origDir == Direction.UP) {
            faceDown(r, curDir);
            r.move();
        } else if (origDir == Direction.RIGHT) {
            faceLeft(r, curDir);
            r.move();
        } else if (origDir == Direction.DOWN) {
            faceUp(r, curDir);
            r.move();
        } else { // LEFT
            faceRight(r, curDir);
            r.move();
        }
    }

    private void faceUp(Robot r, Direction curDir) {
        switch (curDir) {
            case UP:
                break;
            case RIGHT:
                r.turnLeft();
                break;
            case DOWN:
                r.turnRight();
                r.turnRight();
                break;
            case LEFT:
                r.turnRight();
        }
    }

    private void faceRight(Robot r, Direction curDir) {
        switch (curDir) {
            case UP:
                r.turnRight();
                break;
            case RIGHT:
                break;
            case DOWN:
                r.turnLeft();
                break;
            case LEFT:
                r.turnRight();
                r.turnRight();
                break;
        }
    }

    private void faceDown(Robot r, Direction curDir) {
        switch (curDir) {
            case UP:
                r.turnRight();
                r.turnRight();
                break;
            case RIGHT:
                r.turnRight();
                break;
            case DOWN:
                break;
            case LEFT:
                r.turnLeft();
                break;
        }
    }
    
    private void faceLeft(Robot r, Direction curDir) {
        switch (curDir) {
            case UP:
                r.turnLeft();
                break;
            case RIGHT:
                r.turnRight();
                r.turnRight();
                break;
            case DOWN:
                r.turnRight();
                break;
            case LEFT:
                break;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
