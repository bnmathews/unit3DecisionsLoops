import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class GameOfLife
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;
    
    // the game board will have 5 rows and 5 columns
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
        
        // populate the game
        populateGame();
        
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
    private void populateGame()
    {
        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();
    
        // locations of the three cells initially alive
        /*
        int X1 = 3, Y1 = 1;
        int X2 = 4, Y2 = 2;
        int X3 = 5, Y3 = 3;
        int X4 = 4, Y4 = 4;
        int X5 = 7, Y5 = 5;
        */
       
        int X1 = 3, Y1 = 1;
        int X2 = 4, Y2 = 2;
        int X3 = 4, Y3 = 3;
        int X4 = 3, Y4 = 3;
        int X5 = 2, Y5 = 3;
       
        /*
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
        */
        
        // create and add rocks (a type of Actor) to the three intial locations
        Rock rock1 = new Rock();
        Location loc1 = new Location(Y1, X1);
        //grid.put(loc1, rock1);
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
        /*
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
        */
    }

    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    private void createNextGeneration()
    throws InterruptedException
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */
        
        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();
        BoundedGrid<Actor> newGrid = new BoundedGrid<Actor>(ROWS,COLS);
        
        //ArrayList<Location> occupied = grid.getOccupiedLocations();
        ArrayList<Location> cellList = new ArrayList<Location>();
        ArrayList<Location> deaths = new ArrayList<Location>();
        
        Location loc = new Location(0,0);

        System.out.println(grid.getOccupiedLocations());
        
        /* do something like ifneighbor() here for each actor found, iterate until all neighbors are accounted
         * for
        */
       
        //We need to start off fresh, so clear the grid first.
       
        for (int c = 0; c < grid.getNumCols(); c++)
        {
            for (int r = 0; r < grid.getNumRows(); r++)
            {
                loc = new Location(r,c);
                Actor actor = grid.get(loc);
                //System.out.println(actor);
                if (actor != null) //If a cell is found...
                {
                    System.out.println("Actor found at: " + loc);
                    System.out.println(grid.getOccupiedAdjacentLocations(loc));
                    
                    int numNeighbors = grid.getOccupiedAdjacentLocations(loc).size();
                    
                    System.out.println(numNeighbors);
                    if (grid.getEmptyAdjacentLocations(loc) == null)
                    {
                        System.out.println("No neighbor found.");
                        deaths.add(loc);
                    }
                    else if (numNeighbors > 3)
                    {
                        System.out.println("We should remove this one...");
                        deaths.add(loc);
                    }
                    else if (numNeighbors < 2)
                    {
                        System.out.println("We should remove this one as well...");
                        deaths.add(loc);
                    }
                    else
                    {
                        cellList.add(loc);
                        Rock rock = new Rock();
                        newGrid.put(loc, rock);
                    }
                }
                else if (actor == null) //If there is an empty space, look for neighboring cells.
                {
                    if (grid.getOccupiedAdjacentLocations(loc).size() == 3) //If there are 3 cells around the current one
                    {
                            cellList.add(loc);
                            Rock rock = new Rock();
                            newGrid.put(loc, rock);
                    }
                }
                //System.out.println(grid.getNeighbors(loc));
            }
        }
        
        world.setGrid(newGrid);
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
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }
    
    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
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
        GameOfLife game = new GameOfLife();
        //for (int i = 0;i<20;i++)
        //{
            game.createNextGeneration();
            //game.createNextGeneration();
            //game.createNextGeneration();
            //Thread.sleep(100);
        //}
    }

}
