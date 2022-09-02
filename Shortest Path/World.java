import java.util.HashMap;
import java.util.LinkedList;

// The world was created second. The world
// was a matrix of size M x N which contained the obstacles, agent, and goal/goals
// various symbols represented each of these pieces on the world

class World
{
    private static final String[] elementName = new String[]{"free", "obs", "agent", "goal", "path", "goalA", "goalB"};
    private static final String[] elementSymbol = new String[]{" ", "#", "o", "x", ".","A", "B"};
    private static final HashMap<String, Integer> elementCode = new HashMap<String, Integer>();
    static {
        for(int k = 0; k < elementName.length; k++) {
            elementCode.put(elementName[k], k);
        }
    }

    private final int m;
    private final int n;
    private final int[][] matrix;
    private Position agent;
    private Position goal;
    private Position goalA;
    private Position goalB;

    private World(int m, int n, Position[] obstacle) {
        this.m = m;
        this.n = n;
        this.matrix = new int[m][n];
        for(Position obs : obstacle) {
            this.matrix[obs.i][obs.j] = elementCode.get("obs");
        }
    }

    public World(int m, int n, Position agent, Position goal, Position[] obstacle) {
        this(m, n, obstacle);
        this.matrix[agent.i][agent.j] = elementCode.get("agent");
        this.matrix[goal.i][goal.j] = elementCode.get("goal");
        this.agent = agent;
        this.goal = goal;
    }

    public World(int m, int n, Position agent, Position goalA, Position goalB, Position[] obstacle) {
        this(m, n, obstacle);
        this.matrix[agent.i][agent.j] = elementCode.get("agent");
        this.matrix[goalA.i][goalA.j] = elementCode.get("goalA");
        this.matrix[goalB.i][goalB.j] = elementCode.get("goalB");
        this.agent = agent;
        this.goalA = goalA;
        this.goalB = goalB;
    }


    public Position getAgent() {
        return new Position(agent.i, agent.j);
    }

    public Position getGoal() {
        return new Position(goal.i, goal.j);
    }

    public Position getGoalA() {
        return new Position(goalA.i, goalA.j);
    }

    public Position getGoalB() {
        if(this.goalB != null)
            return new Position(goalB.i, goalB.j);
        return null;
    }

    public void addPath(LinkedList<Position> path) {
        for(Position p : path) {
            if(matrix[p.i][p.j] == elementCode.get("free")) {
                matrix[p.i][p.j] = elementCode.get("path");
            }
        }
    }

    @Override
    public String toString() {
        String verticalWall = "==";
        String horizontalWall = "|";
        StringBuilder builder = new StringBuilder();
        builder.append(" ");
        for(int j = 0; j < n; j++) {
            builder.append(verticalWall);
        }
        builder.append("\n");
        for(int i = 0; i < m; i++) {
            builder.append(horizontalWall);
            for(int j = 0; j < n; j++) {
                builder.append(elementSymbol[matrix[i][j]] + " ");
            }
            builder.append(horizontalWall + "\n");
        }
        builder.append(" ");
        for(int j = 0; j < n; j++) {
            builder.append(verticalWall);
        }
        builder.append("\n");
        return builder.toString();
    }

    public boolean freeSpace(Position p) {
        return p.i >= 0 && p.i < m && p.j >= 0 && p.j < n && matrix[p.i][p.j] != elementCode.get("obs");
    }
}
