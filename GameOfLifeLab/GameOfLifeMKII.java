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
 * @version 11 November 2014
 */
public class GameOfLifeMKII
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
    public GameOfLifeMKII()
    throws InterruptedException
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);
        ArrayList<Location> cellList = new ArrayList<Location>();
        
        // create a world based on the grid
        world = new ActorWorld(grid);
        
        // populate the game
        //populateGame();
        
        // populate the game for the second test variant, use one at a time!!
        //populateGame2();
        
        randomPopulate();
        
        // display the newly constructed and populated world
        world.show();
        
    }
    
    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
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
        
        Scanner s = new Scanner(System.in);
        System.out.print("Starting cells: ");
        int rocks = s.nextInt();
    
        // locations of the cells initially alive
        Random r = new Random();
        
        if (rocks <= 0)
        {
            Random r2 = new Random();
            rocks = r2.nextInt(600);
        }
        for (int i  = 0; i <= rocks; i++)
        {
            int Y = r.nextInt(20);
            int X = r.nextInt(30);
            Rock rock = new Rock();
            Location loc = new Location(Y, X);
            world.add(loc,rock);
        }
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
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String[] args)
    throws InterruptedException
    {
        GameOfLifeMKII game = new GameOfLifeMKII();
        
        boolean doStop = false;
        
        // basically just a while loop, but this is more useful as it makes it easy to get the final generation number
        for (int i = 1;doStop == false;i++) 
        {
                // check the placement of cells on the old (current) grid
                String oldOccupied = game.getOccupied().toString();
                
                // generate or destroy cells, make a new grid in the process
                game.createNextGeneration();
                
                // check the placement of cells on the fresh grid
                String newOccupied = game.getOccupied().toString();
                
                // wait 60 ticks (ms)
                Thread.sleep(60);
                
                if (oldOccupied.equals(newOccupied)) // check to see if there is still room for a new generation
                {
                    doStop = true;
                    System.out.println("After " + i + " generations, the game has ended.");
                }
        }
        
    }

}
