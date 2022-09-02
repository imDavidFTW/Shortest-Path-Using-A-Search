import java.util.Map;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.PriorityQueue;


// Lastly a pathplanning class was made
// the main purpose of this class was to navigate the world
// from an agent to a goal/goals and calculating the shortest path
// inside the pathplanning class a private class node was used to represent each 
// piece of the world and contained functions to navigate in
// the matrix. These nodes stored a predecessor, distanceTraveled and the
// command (up, left, right, and down) used to get to that spot from the predecessor
// The shortest path was displayed on the world when the string of the world was
// printed.
class PathPlanning
{
    private class Node extends Position implements Comparable<Node>
    {
        private int distanceTraveled;
        private Node predecessor;
        private String command;

        private Node(int i, int j) {
            super(i, j);
            this.distanceTraveled = 0;
            this.predecessor = null;
            this.command = "start";
        }

        private Node(Position p) {
            this(p.i, p.j);
        }

        private int cost() {
            return this.distanceTraveled + this.distance(last);
        }

        @Override
        public int compareTo(Node u) {
            return this.cost() - u.cost();
        }

        private Node up() {
            return new Node(i - 1, j);
        }

        private Node right() {
            return new Node(i, j + 1);
        }

        private Node down() {
            return new Node(i + 1, j);
        }

        private Node left() {
            return new Node(i, j - 1);
        }

        private Map<String, Node> successor() {
            return Map.of("up", up(), "right", right(), "down", down(), "left", left());
        }
    }

    private World world;
    private Node first;
    private Node last;

    // This private constructor can be called from within this class to carry out the path planning algorithm
    // on a first and last positions other than the ones specified by world (i.e. other than agent and goal).
    private PathPlanning(World world, Position first, Position last) {
        this.world = world;
        this.first = new Node(first);
        this.last = new Node(last);
        aStarSearch();
    }

    public PathPlanning(World world) {
        this.world = world;
        if(world.getGoalB() != null){
            PathPlanning planA = new PathPlanning(world, world.getAgent(), world.getGoalA());
            PathPlanning planB = new PathPlanning(world, world.getAgent(), world.getGoalB());
            if(planA.distanceTraveled() != -1 && planB.distanceTraveled() != -1){
                if(planA.distanceTraveled() < planB.distanceTraveled()){
                    this.first = planA.last;
                    this.last = new Node(world.getGoalB());
                }
                else{
                    this.first = planB.last;
                    this.last = new Node(world.getGoalA());
                }
            }
            else{
                this.first = new Node(world.getAgent());
                if(planA.distanceTraveled() == -1)
                    this.last = new Node(world.getGoalA());
                else
                    this.last = new Node(world.getGoalB());
            }
       	}
       	else{
           	this.first = new Node(world.getAgent());
            this.last = new Node(world.getGoal());
       	}
        aStarSearch();
    }

    private void aStarSearch() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
        HashSet<Node> visited = new HashSet<Node>();
        priorityQueue.add(first);
        visited.add(first);
        while(! priorityQueue.isEmpty()) {
            Node u = priorityQueue.remove();
            if(u.equals(last)) {
                last = u;
                return;
            }
            else {
                for(Map.Entry<String, Node> entry : u.successor().entrySet()) {
                    Node v = entry.getValue();
                    if(! visited.contains(v) && world.freeSpace(v)) {
                        v.distanceTraveled = u.distanceTraveled + 1;
                        v.predecessor = u;
                        v.command = entry.getKey();
                        priorityQueue.add(v);
                        visited.add(v);
                    }
                }
            }
        }
        last.distanceTraveled = -1;
    }

    public int distanceTraveled() {
        return last.distanceTraveled;
    }

    public LinkedList<Position> shortestPath() {
        LinkedList<Position> path = new LinkedList<Position>();
	    if(last.distanceTraveled < 0) {
	        return path;
        }
        for(Node u = last; u != null; u = u.predecessor) {
	        path.addFirst(u);
        }
     return path;
    }

    public LinkedList<String> commandSequence() {
        LinkedList<String> command = new LinkedList<String>();
        if(last.distanceTraveled < 0) {
            return command;
        }
        command.add("stop");
        for(Node u = last; u != null; u = u.predecessor) {
            command.addFirst(u.command);
        }
        return command;
    }
	
}
