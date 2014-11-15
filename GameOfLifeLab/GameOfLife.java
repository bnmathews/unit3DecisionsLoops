import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * "Game of Life" simulation
 * 
 * @author @bnmathews
 * @version 15 November 2014
 */
public class GameOfLife
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;
    
    // the game board will have 21 rows and 30 columns
    private final int ROWS = 21;
    private final int COLS = 30;
    
    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife()
    throws InterruptedException
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);
        ArrayList<Location> cellList = new ArrayList<Location>();
        
        // create a world based on the grid
        world = new ActorWorld(grid);
        
        String choice = "";
        
        // lets the user choose what population type they want
        while (!choice.toUpperCase().equals("A") && !choice.toUpperCase().equals("B") && !choice.toUpperCase().equals("C") && !choice.toUpperCase().equals("D"))
        {
            Scanner s = new Scanner(System.in);
            System.out.println("Would you like to create:");
            System.out.println("Pattern 1? [A]");
            System.out.println("Pattern 2? [B]");
            System.out.println("Pattern 3? [C]");
            System.out.println("Or a random pattern? [D]");
            System.out.print(">>");
            choice = s.next();
        }
        
        // decides what population generation method to use
        if (choice.toUpperCase().equals("A"))
        {
            populateGame();
        }
        else if (choice.toUpperCase().equals("B"))
        {
            populateGame2();
        }
        else if (choice.toUpperCase().equals("C"))
        {
            populateGame3();
        }
        else if (choice.toUpperCase().equals("D"))
        {
            randomPopulate();
        }
        
        // display the newly constructed and populated world
        world.show();
        
    }
    
    /**
     * Creates the actors randomly inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void randomPopulate()
    {
        // the grid of Actors that maintains the state of the game
        // (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();
        
        int rocks = 9001;
        
        int rockCount = 0;
        
        while ( (rocks != 0 && rocks > 630) || rocks < 0 ) // make sure an invalid number isn't entered
        {
            Scanner s = new Scanner(System.in);
            System.out.println("\nPick a number of cells to start with: ");
            System.out.println("-Entering '0' will randomly generate a number of cells ");
            System.out.println("-Only numbers from 0-630 are valid ");
            System.out.print(">>");
            rocks = s.nextInt();
        }
    
        Random r = new Random();
        
        if (rocks <= 0) // if the user wants to randomly generate a number of cells
        {
            Random r2 = new Random();
            rocks = r2.nextInt(630);
            System.out.println("\nGenerated " + rocks + " cells!");
        }
        
        Location loc = new Location(0, 0);
        
        for (int i = 0; i < rocks; i++)
        {
            int Y = r.nextInt(21);
            int X = r.nextInt(30);
            loc = new Location(Y, X);
            if (!grid.getOccupiedLocations().contains(loc)) // check to see if there is not already a cell in the current location
            {
                Rock rock = new Rock();
                world.add(loc,rock);
                rockCount++;
            }
            else // if there is a cell in the current location, try again for a new value
            {
                i--;
            }
        }
    }
    
     /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame()
    {
        // the grid of Actors that maintains the state of the game
        // (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();
    
        // locations of the cells initially alive
        int X1 = 3, Y1 = 1;
        int X2 = 4, Y2 = 2;
        int X3 = 5, Y3 = 3;
        int X4 = 4, Y4 = 4;
        int X5 = 7, Y5 = 5;
        int X6 = 8, Y6 = 5;
        int X7 = 9, Y7 = 5;
        int X8 = 8, Y8 = 7;
        int X9 = 9, Y9 = 8;
        int X10 = 8, Y10 = 9;
        int X11 = 9, Y11 = 10;
        int X12 = 8, Y12 = 11;
        int X13 = 18, Y13 = 5;
        int X14 = 19, Y14 = 5;
        int X15 = 20, Y15 = 3;
        int X16 = 20, Y16 = 4;
        int X17 = 21, Y17 = 6;
        int X18 = 22, Y18 = 7;
        int X19 = 23, Y19 = 7;
        
        // create and add rocks (a type of Actor) to the three intial locations
        Rock rock1 = new Rock();
        Location loc1 = new Location(Y1, X1);
        world.add(loc1,rock1);
        
        Rock rock2 = new Rock();
        Location loc2 = new Location(Y2, X2);
        world.add(loc2, rock2);
        
        Rock rock3 = new Rock();
        Location loc3 = new Location(Y3, X3);
        world.add(loc3, rock3);
        
        Rock rock4 = new Rock();
        Location loc4 = new Location(Y4, X4);
        world.add(loc4, rock4);
        
        Rock rock5 = new Rock();
        Location loc5 = new Location(Y5, X5);
        world.add(loc5, rock5);
        
        Rock rock6 = new Rock();
        Location loc6 = new Location(Y6, X6);
        world.add(loc6, rock6);
        
        Rock rock7 = new Rock();
        Location loc7 = new Location(Y7, X7);
        world.add(loc7, rock7);
        
        Rock rock8 = new Rock();
        Location loc8 = new Location(Y8, X8);
        world.add(loc8, rock8);
        
        Rock rock9 = new Rock();
        Location loc9 = new Location(Y9, X9);
        world.add(loc9, rock9);
        
        Rock rock10 = new Rock();
        Location loc10 = new Location(Y10, X10);
        world.add(loc10, rock10);
        
        Rock rock11 = new Rock();
        Location loc11 = new Location(Y11, X11);
        world.add(loc11, rock11);
        
        Rock rock12 = new Rock();
        Location loc12 = new Location(Y12, X12);
        world.add(loc12, rock12);
        
        Rock rock13 = new Rock();
        Location loc13 = new Location(Y13, X13);
        world.add(loc13, rock13);
        
        Rock rock14 = new Rock();
        Location loc14 = new Location(Y14, X14);
        world.add(loc14, rock14);
        
        Rock rock15 = new Rock();
        Location loc15 = new Location(Y15, X15);
        world.add(loc15, rock15);
        
        Rock rock16 = new Rock();
        Location loc16 = new Location(Y16, X16);
        world.add(loc16, rock16);
        
        Rock rock17 = new Rock();
        Location loc17 = new Location(Y17, X17);
        world.add(loc17, rock17);
        
        Rock rock18 = new Rock();
        Location loc18 = new Location(Y18, X18);
        world.add(loc18, rock18);
        
        Rock rock19 = new Rock();
        Location loc19 = new Location(Y19, X19);
        world.add(loc19, rock19);
    }
    
    /**
     * Creates the actors and inserts them into their initial starting positions in the grid, again
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame2()
    {
        // the grid of Actors that maintains the state of the game
        // (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();
        
        // locations of the cells initially alive
        int X1 = 3, Y1 = 1;
        int X2 = 4, Y2 = 2;
        int X3 = 4, Y3 = 3;
        int X4 = 3, Y4 = 3;
        int X5 = 2, Y5 = 3;
        
        // create and add rocks (a type of Actor) to the three intial locations
        Rock rock1 = new Rock();
        Location loc1 = new Location(Y1, X1);
        world.add(loc1,rock1);
        
        Rock rock2 = new Rock();
        Location loc2 = new Location(Y2, X2);
        world.add(loc2, rock2);
        
        Rock rock3 = new Rock();
        Location loc3 = new Location(Y3, X3);
        world.add(loc3, rock3);
        
        Rock rock4 = new Rock();
        Location loc4 = new Location(Y4, X4);
        world.add(loc4, rock4);
        
        Rock rock5 = new Rock();
        Location loc5 = new Location(Y5, X5);
        world.add(loc5, rock5);
    }
    
    /**
     * Creates the actors and inserts them into their initial starting positions in the grid, again
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame3()
    {
        // the grid of Actors that maintains the state of the game
        // (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();
        
        // locations of the cells initially alive
        int X1 = 5, Y1 = 7;
        int X2 = 5, Y2 = 8;
        int X3 = 4, Y3 = 9;
        int X4 = 6, Y4 = 9;
        int X5 = 5, Y5 = 10;
        int X6 = 5, Y6 = 11;
        int X7 = 5, Y7 = 12;
        int X8 = 5, Y8 = 13;
        int X9 = 4, Y9 = 14;
        int X10 = 6, Y10 = 14;
        int X11 = 5, Y11 = 15;
        int X12 = 5, Y12 = 16;
        
        // create and add rocks (a type of Actor) to the three intial locations
        Rock rock1 = new Rock();
        Location loc1 = new Location(X1, Y1);
        world.add(loc1,rock1);
        
        Rock rock2 = new Rock();
        Location loc2 = new Location(X2, Y2);
        world.add(loc2, rock2);
        
        Rock rock3 = new Rock();
        Location loc3 = new Location(X3, Y3);
        world.add(loc3, rock3);
        
        Rock rock4 = new Rock();
        Location loc4 = new Location(X4, Y4);
        world.add(loc4, rock4);
        
        Rock rock5 = new Rock();
        Location loc5 = new Location(X5, Y5);
        world.add(loc5, rock5);
        
        Rock rock6 = new Rock();
        Location loc6 = new Location(X6, Y6);
        world.add(loc6, rock6);
        
        Rock rock7 = new Rock();
        Location loc7 = new Location(X7, Y7);
        world.add(loc7, rock7);
        
        Rock rock8 = new Rock();
        Location loc8 = new Location(X8, Y8);
        world.add(loc8, rock8);
        
        Rock rock9 = new Rock();
        Location loc9 = new Location(X9, Y9);
        world.add(loc9, rock9);
        
        Rock rock10 = new Rock();
        Location loc10 = new Location(X10, Y10);
        world.add(loc10, rock10);
        
        Rock rock11 = new Rock();
        Location loc11 = new Location(X11, Y11);
        world.add(loc11, rock11);
        
        Rock rock12 = new Rock();
        Location loc12 = new Location(X12, Y12);
        world.add(loc12, rock12);
    }
    
    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     */
    public void createNextGeneration()
    throws InterruptedException
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */
        
        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();
        
        // create the new grid for future updating
        BoundedGrid<Actor> newGrid = new BoundedGrid<Actor>(ROWS,COLS);
       
        for (int c = 0; c < grid.getNumCols(); c++)
        {
            for (int r = 0; r < grid.getNumRows(); r++)
            {
                // create a location array based on the current row and column
                Location loc = new Location(r,c);
                
                // get the cell at the current location
                Actor actor = grid.get(loc);
                if (actor != null) // if a cell is found...
                {
                    // keep track of the amount of neighbors a cell has
                    int numNeighbors = grid.getOccupiedAdjacentLocations(loc).size();
                    if (grid.getEmptyAdjacentLocations(loc) == null || numNeighbors > 3 || numNeighbors < 2)
                    {
                        // if the cell has no neighbors, more than 3, or less than 2, then remove it
                    }
                    else // if the cell has 3 neighbors
                    {
                        // set the type of cell to the 'rock' actor
                        Rock rock = new Rock();
                        // put the cell in the new grid in the same place as the old grid
                        newGrid.put(loc, rock);
                    }
                }
                else if (actor == null) // if there is an empty space, look for neighboring cells
                {
                    if (grid.getOccupiedAdjacentLocations(loc).size() == 3) // if there are 3 cells around the empty space...
                    {
                            // set the type of cell to the 'rock' actor
                            Rock rock = new Rock();
                            // put the cell in the new grid
                            newGrid.put(loc, rock);
                    }
                }
            }
        }
        
        // start using the new grid, and remove the old one (dead cells)
        world.setGrid(newGrid);
    }
    
    /**
     * Returns the locations of all the live cells currently on screen.
     *
     * @pre     the grid has been created
     * @return  locations of the live cells on the current grid
     */
    public ArrayList<Location> getOccupied()
    {
        // get the current grid
        Grid<Actor> grid = world.getGrid();
        
        // return an array list of the locations of live cells
        return grid.getOccupiedLocations();
    }
    
    /**
     * Returns the actor at the specified row and column. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
    }

    /**
     * Returns the number of rows in the game board
     *
     * @return   the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }
    
    /**
     * Returns the number of columns in the game board
     *
     * @return   the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }
    
    /**
     * Returns a special response depending on how many generations were created
     *
     * @pre      the game has finished running, and has a generation count
     * @return   a response based on the number of generations
     */
    public String getResponse(String generation)
    {
        // converts the string input to an interger
        int gens = Integer.parseInt(generation);
        
        Random r = new Random();
        
        // so we can choose from 3 responses, gets a value from 0 to 2
        int respChoice = r.nextInt(3);
        
        String response = "";
        
        if (gens > 1000) // determines what the response will be depending on the genration number
        {
            if (respChoice == 0)
            {
                response = "a killer ";
            }
            if (respChoice == 1)
            {
                response = "a wicked sick ";
            }
            if (respChoice == 2)
            {
                response = "a staggering ";
            }
        }
        else if (gens > 500)
        {
            if (respChoice == 0)
            {
                response = "a fantastic ";
            }
            if (respChoice == 1)
            {
                response = "an excellent ";
            }
            if (respChoice == 2)
            {
                response = "an awesome ";
            }
        }
        else if (gens > 300)
        {
            if (respChoice == 0)
            {
                response = "a very nice ";
            }
            if (respChoice == 1)
            {
                response = "a great ";
            }
            if (respChoice == 2)
            {
                response = "a very respectable ";
            }
        }
        else if (gens > 100)
        {
            if (respChoice == 0)
            {
                response = "an above-average ";
            }
            if (respChoice == 1)
            {
                response = "a pretty good ";
            }
            if (respChoice == 2)
            {
                response = "an okay ";
            }
        }
        else if (gens > 30)
        {
            if (respChoice == 0)
            {
                response = "a decent ";
            }
            if (respChoice == 1)
            {
                response = "a mediocre ";
            }
            if (respChoice == 2)
            {
                response = "a passable ";
            }
        }
        else if (gens <= 30)
        {
            if (respChoice == 0)
            {
                response = "a measly ";
            }
            if (respChoice == 1)
            {
                response = "a dismal ";
            }
            if (respChoice == 2)
            {
                response = "a terrible ";
            }
        }
        
        return response;
    }
    
    /**
     * Returns a type of trophy based on how many generations were created
     *
     * @pre      the game has finished running, and has a generation count
     * @return   a trophy type based on the number of generations
     */
    public String getTrophy(String generation)
    {
        // converts the string input to an interger
        int gens = Integer.parseInt(generation);
        
        String trophy = "";
        
        if (gens > 1000) // determines what the trohpy / rank will be depending on the genration number
        {
            trophy = "PURE PLATINUM";
        }
        else if (gens > 500)
        {
            trophy = "PLATINUM";
        }
        else if (gens > 300)
        {
            trophy = "GOLD";
        }
        else if (gens > 100)
        {
            trophy = "SILVER";
        }
        else if (gens > 40)
        {
            trophy = "BRONZE";
        }
        else if (gens <= 40)
        {
            trophy = "STONE";
        }
        return trophy;
    }
    
    /**
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String[] args)
    throws InterruptedException
    {
        GameOfLife game = new GameOfLife();
        
        // controls if the program finishes or keeps running
        boolean doStop = false;
        
        // the amount of loops that have occurred
        int loops = 0;
        
        // the time between a phase of a loop
        int loopTime = 0; 
        
        // lets the program know whether or not a loop check should occur
        boolean doLoopCheck = false;
        
        // the original starting point in a loop
        String oldOccupied_Infinity = game.getOccupied().toString();
        
        String keepLooping = "";
        
        // basically just a while loop, but this is more useful as it makes it easy to get the final generation number
        for (int i = 1;doStop == false;i++) 
        {
                // check the placement of cells on the old (current) grid
                String oldOccupied = game.getOccupied().toString();
                
                // generate or destroy cells, make a new grid in the process
                game.createNextGeneration();
                
                // check the placement of cells on the fresh grid
                String newOccupied = game.getOccupied().toString();
                
                if (loopTime == 0)
                {
                    // reset the possible starting point of a new loop
                    oldOccupied_Infinity = game.getOccupied().toString();
                }
                
                if (newOccupied.equals(oldOccupied_Infinity) && doLoopCheck == false) // check if there is no loop check going on and a previous position has occured again
                {
                    // start looking for a loop, as it looks like one may happen now
                    doLoopCheck = true;
                }
                else if (newOccupied.equals(oldOccupied_Infinity) && doLoopCheck == true) // check if a loop check is happening and the loop closes
                {
                    // end the current loop check
                    doLoopCheck = false;
                    
                    // record the loop (must have 2 to clear as an infinite loop for failsafe reasons)
                    loops++;
                }
                
                if (doLoopCheck == true) // if a loop check is going on, then check how long the loop takes
                {
                    loopTime++;
                }
                
                if (loopTime == 20) // at this point if there is no loop going on, set up a new loop check
                {
                    // end the current loop check so a new one can happen
                    doLoopCheck = false;
                    
                    // reset the time a new loop may take
                    loopTime = 0;
                }
                
                if (loops == 2 && !keepLooping.toUpperCase().equals("Y")) // check if the user wants to continue the infinite loop
                {
                    Scanner s = new Scanner(System.in);
                    System.out.println("\nEven after " + game.getResponse(""+i) + i + " generations the game will not stabilize!");
                    System.out.println("Rank: " + game.getTrophy(""+i));
                    System.out.println("\nThis will go on forever if you let it - do you want to continue the loop? [Y/N]");
                    System.out.print(">>");
                    keepLooping = s.next();
                    if (keepLooping.toUpperCase().equals("N"))
                    {
                        doStop = true;
                        System.out.println("\nThe game has been stopped.");
                    }
                    else
                    {
                        System.out.println("\nAlright, it's your funeral.");
                    }
                }
                
                // wait 80 ticks (ms)
                Thread.sleep(80);
                
                if (oldOccupied.equals(newOccupied)) // check to see if there is still room for a new generation
                {
                    doStop = true;
                    System.out.println("\nAfter " + game.getResponse(""+i) + i + " generations, the game has ended.");
                    System.out.println("Rank: " + game.getTrophy(""+i));
                }
        }
    }
}
