class Main
{
    public static void main(String[] args) 
    {
        Position agent = new Position(4, 1);
        Position[] obstacle = {
            new Position(1, 4),
            new Position(2, 4),
            new Position(3, 4),
            new Position(4, 3),
            new Position(4, 4),
            new Position(4, 5),
            new Position(4, 6),
            new Position(5, 3),
            new Position(5, 6),
            new Position(6, 1),
            new Position(6, 2),
            new Position(6, 3),
            new Position(6, 6),
        };

        System.out.println();
        System.out.println("planning a path with one goal:");
        Position goal = new Position(5, 7);
        World world1 = new World(8, 9, agent, goal, obstacle);
        System.out.println(world1);
        PathPlanning plan1 = new PathPlanning(world1);
        System.out.println("length of shortest path: " + plan1.distanceTraveled());
        System.out.println("shortest path: " + plan1.shortestPath());
        System.out.println("command sequence: " + plan1.commandSequence());
        world1.addPath(plan1.shortestPath());
        System.out.println(world1);

        System.out.println();
        System.out.println("planning a path with two goals:");
        Position goalA = new Position(5, 7);
        Position goalB = new Position(0, 6);
        World world2 = new World(8, 9, agent, goalA, goalB, obstacle);
        System.out.println(world2);
        PathPlanning plan2 = new PathPlanning(world2);
        System.out.println("length of shortest path: " + plan2.distanceTraveled());
        System.out.println("shortest path: " + plan2.shortestPath());
        System.out.println("command sequence: " + plan2.commandSequence());
        world2.addPath(plan2.shortestPath());
        System.out.println(world2);

            System.out.println();
            System.out.println();


        Position agent3 = new Position(4, 1);
        Position[] obstacle3 = {
            new Position(1, 4),
            new Position(2, 4),
            new Position(3, 4),
            new Position(4, 3),
            new Position(4, 4),
            new Position(4, 5),
            new Position(4, 6),
            new Position(5, 3),
            new Position(5, 6),
            new Position(6, 1),
            new Position(6, 2),
            new Position(6, 3),
            new Position(6, 6),
            new Position(0,4),
        };

        System.out.println();
        System.out.println("planning a path with two goal:");
        Position goalA3 = new Position(5, 7);
        Position goalB3 = new Position(0, 6);
        World world4 = new World(8, 9, agent3, goalA3, goalB3, obstacle3);
        System.out.println(world4);
        PathPlanning plan4 = new PathPlanning(world4);
        System.out.println("length of shortest path: " + plan4.distanceTraveled());
        System.out.println("shortest path: " + plan4.shortestPath());
        System.out.println("command sequence: " + plan4.commandSequence());
        world4.addPath(plan4.shortestPath());
        System.out.println(world4);


        System.out.println();
        System.out.println();

        Position agent4 = new Position(4, 1);
        Position[] obstacle4 = 
        {
            new Position(1, 4),
            new Position(2, 4),
            new Position(3, 4),
            new Position(4, 3),
            new Position(4, 4),
            new Position(4, 5),
            new Position(4, 6),
            new Position(5, 3),
            new Position(5, 6),
            new Position(6, 1),
            new Position(6, 2),
            new Position(6, 3),
            new Position(6, 6),
            new Position(0,4),
            new Position(7,6),
            };

            System.out.println();
            System.out.println("planning a path with two goal:");
            Position goalA4 = new Position(5, 7);
            Position goalB4 = new Position(0, 6);
            World world5 = new World(8, 9, agent4, goalA4, goalB4, obstacle4);
            System.out.println(world5);
            PathPlanning plan5 = new PathPlanning(world5);
            System.out.println("length of shortest path: " + plan5.distanceTraveled());
            System.out.println("shortest path: " + plan5.shortestPath());
            System.out.println("command sequence: " + plan5.commandSequence());
            world5.addPath(plan5.shortestPath());
            System.out.println(world5);



            System.out.println();
            System.out.println();


            Position agent5 = new Position(4, 1);
                Position[] obstacle5 = {
                    new Position(2,4),
                    new Position(3,4),
                    new Position(5,3),
                    new Position(6, 2),
                    new Position(5,6),
                    new Position(6,3),
                    new Position(4, 4),
                    new Position(4, 3),
                    new Position(4, 5),
                    new Position(4, 7),
                    new Position(7,6),
                    new Position(4,8),
                    new Position(1,4),
                    new Position(4,6),
                    new Position(6,6),
                    new Position(6,1),
                };
        
                System.out.println();
                System.out.println("planning a path with two goal:");
                Position goalA5 = new Position(5, 7);
                Position goalB5 = new Position(0, 6);
                World world6 = new World(8, 9, agent5, goalA5, goalB5, obstacle5);
                System.out.println(world6);
                PathPlanning plan6 = new PathPlanning(world6);
                System.out.println("length of shortest path: " + plan6.distanceTraveled());
                System.out.println("shortest path: " + plan6.shortestPath());
                System.out.println("command sequence: " + plan6.commandSequence());
                world6.addPath(plan6.shortestPath());
                System.out.println(world6);

                System.out.println();
                System.out.println();

                Position agent2 = new Position(4, 1);
        Position[] obstacle2 = {
            new Position(2,4),
            new Position(3,4),
            new Position(5,3),
            new Position(6, 2),
            new Position(5,6),
            new Position(6,3),
            new Position(4, 4),
            new Position(4, 3),
            new Position(4, 5),
            new Position(4, 7),
            new Position(0,4),
            new Position(4,8),
            new Position(1,4),
            new Position(4,6),
            new Position(6,6),
            new Position(6,1),
        };

        System.out.println();
        System.out.println("planning a path with two goal:");
        Position goalA2 = new Position(5, 7);
        Position goalB2 = new Position(0, 6);
        World world3 = new World(8, 9, agent2, goalA2, goalB2, obstacle2);
        System.out.println(world3);
        PathPlanning plan3 = new PathPlanning(world3);
        System.out.println("length of shortest path: " + plan3.distanceTraveled());
        System.out.println("shortest path: " + plan3.shortestPath());
        System.out.println("command sequence: " + plan3.commandSequence());
        world3.addPath(plan3.shortestPath());
        System.out.println(world3);

            System.out.println();
            System.out.println();


        




    }
}
