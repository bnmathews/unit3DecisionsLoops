import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import info.gridworld.actor.Actor;

/**
 * The test class GameOfLifeTest.
 *
 * @author  @bnmathews
 * @version 15 November 2014
 */
public class GameOfLifeTest
{
    /**
     * Default constructor for test class GameOfLifeTest
     */
    public GameOfLifeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testInitialState()
    throws InterruptedException
    {
        /* expected pattern for initial state
         *  (X: alive; -: dead)
         * 
         *    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 
         *  0 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  1 - - - X - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  2 - - - - X - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  3 - - - - - X - - - -  -  -  -  -  -  -  -  -  -  -  X  -  -  -  -  -  -  -  -  -  
         *  4 - - - - X - - - - -  -  -  -  -  -  -  -  -  -  -  X  -  -  -  -  -  -  -  -  -  
         *  5 - - - - - - - X X X  -  -  -  -  -  -  -  -  X  X  -  -  -  -  -  -  -  -  -  -   
         *  6 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  X  -  -  -  -  -  -  -  -  
         *  7 - - - - - - - - X -  -  -  -  -  -  -  -  -  -  -  -  -  X  X  -  -  -  -  -  -    
         *  8 - - - - - - - - - X  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         *  9 - - - - - - - - X -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 10 - - - - - - - - - X  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         * 11 - - - - - - - - X -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   
         * 12 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 13 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 14 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 15 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 16 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   
         * 17 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 18 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 19 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 20 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   
         */
        
        System.out.println("Please select option 'A' for this test to execute properly!\n"); 
        
        GameOfLife game = new GameOfLife();
        final int ROWS = game.getNumRows();
        final int COLS = game.getNumCols();

        for(int row = 0; row < ROWS; row++) //Check each row
        {
            for(int col = 0; col < COLS; col++) //Check each column
            {
                // in this example, an alive cell has a non-null actor and a dead cell has a null actor
                Actor cell = game.getActor(row, col);

                // if the cell at the current row and col should be alive, assert that the actor is not null
                if(     (col == 3 && row == 1) ||
                        (col == 4 && row == 2) ||
                        (col == 5 && row == 3) ||
                        (col == 4 && row == 4) ||
                        (col == 7 && row == 5) ||
                        (col == 8 && row == 5) ||
                        (col == 9 && row == 5) ||
                        (col == 8 && row == 7) ||
                        (col == 9 && row == 8) ||
                        (col == 8 && row == 9) ||
                        (col == 9 && row == 10) ||
                        (col == 8 && row == 11) ||
                        (col == 18 && row == 5) ||
                        (col == 19 && row == 5) ||
                        (col == 20 && row == 3) ||
                        (col == 20 && row == 4) ||
                        (col == 21 && row == 6) ||
                        (col == 22 && row == 7) ||
                        (col == 23 && row == 7))
                {
                    assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                }
                else // else, the cell should be dead; assert that the actor is null
                {
                    assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                }
            }
        }
    }
    
    @Test
    public void testInitialState2()
    throws InterruptedException
    {
        /* expected pattern for initial state
         *  (X: alive; -: dead)
         * 
         *    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29
         *  0 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  1 - - - X - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - 
         *  2 - - - - X - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  3 - - X X X - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - 
         *  4 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  5 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  6 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - 
         *  7 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         *  8 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         *  9 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         * 10 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - 
         * 11 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         * 12 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   
         * 14 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 15 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 16 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   
         * 17 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   
         * 18 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 19 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -     
         * 20 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   
         */
        
        System.out.println("Please select option 'B' for this test to execute properly!\n"); 
        
        GameOfLife game = new GameOfLife();
        final int ROWS = game.getNumRows();
        final int COLS = game.getNumCols();

        for(int row = 0; row < ROWS; row++) //Check each row
        {
            for(int col = 0; col < COLS; col++) //Check each column
            {
                // in this example, an alive cell has a non-null actor and a dead cell has a null actor
                Actor cell = game.getActor(row, col);

                // if the cell at the current row and col should be alive, assert that the actor is not null
                if(     (col == 3 && row == 1) ||
                        (col == 4 && row == 2) ||
                        (col == 4 && row == 3) ||
                        (col == 3 && row == 3) ||
                        (col == 2 && row == 3))
                {
                    assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                }
                else // else, the cell should be dead; assert that the actor is null
                {
                    assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                }
            }
        }
    }

    @Test
    public void testFinalState()
    throws InterruptedException
    {
        /* verify that the actual pattern matches the expected pattern after 3 generations
         *  (X: alive; -: dead)
         * 
         *    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29
         *  0 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  1 - - - - - X X - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - 
         *  2 - - - - - X X - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  3 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - 
         *  4 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  5 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  6 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - 
         *  7 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         *  8 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         *  9 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         * 10 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - 
         * 11 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         * 12 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   
         * 14 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 15 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 16 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   
         * 17 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   
         * 18 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 19 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -     
         * 20 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   
         */
        
        System.out.println("Please select option 'A' for this test to execute properly!\n"); 
        
        GameOfLife game = new GameOfLife();
        final int ROWS = game.getNumRows();
        final int COLS = game.getNumCols();
        
        
        // a copy of the main() method of the GameofLife class - makes sure it gets all the way to the end
        boolean doStop = false;
        
        for (int i = 1;doStop == false;i++) 
        {
                // check the placement of cells on the old (current) grid
                String oldOccupied = game.getOccupied().toString();
                
                // generate or destroy cells, make a new grid in the process
                game.createNextGeneration();
                
                // check the placement of cells on the fresh grid
                String newOccupied = game.getOccupied().toString();
                
                if (oldOccupied.equals(newOccupied)) // check to see if there is still room for a new generation
                {
                    doStop = true;
                    System.out.println("After " + i + " generations, the game has ended.");
                }
        }

        if (doStop == true)
        {
            for(int row = 0; row < ROWS; row++) //Check each row
            {
                for(int col = 0; col < COLS; col++) //Check each column
                {
                    // in this example, an alive cell has a non-null actor and a dead cell has a null actor
                    Actor cell = game.getActor(row, col);
    
                    // if the cell at the current row and col should be alive, assert that the actor is not null
                    if(     (col == 5 && row == 1) ||
                            (col == 6 && row == 1) ||
                            (col == 5 && row == 2) ||
                            (col == 6 && row == 2))
                    {
                        assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                    }
                    else // else, the cell should be dead; assert that the actor is null
                    {
                        assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                    }
                }
            }
        }
    }
    
    @Test
    public void testFinalState2()
    throws InterruptedException
    {
        /* verify that the actual pattern matches the expected pattern after 3 generations
         *  (X: alive; -: dead)
         * 
         *    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29
         *  0 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  1 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - 
         *  2 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  3 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - 
         *  4 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  5 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  6 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - 
         *  7 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         *  8 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         *  9 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         * 10 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - 
         * 11 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         * 12 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   
         * 14 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 15 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 16 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   
         * 17 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   
         * 18 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 19 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  X  X  -  -  -  -  -  -  -  -     
         * 20 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  X  X  -  -  -  -  -  -  -  - 
         */
        
        System.out.println("Please select option 'B' for this test to execute properly!\n"); 
        
        GameOfLife game = new GameOfLife();
        final int ROWS = game.getNumRows();
        final int COLS = game.getNumCols();
        
        // a copy of the main() method of the GameofLife class - makes sure it gets all the way to the end
        boolean doStop = false;
        
        for (int i = 1;doStop == false;i++) 
        {
                // check the placement of cells on the old (current) grid
                String oldOccupied = game.getOccupied().toString();
                
                // generate or destroy cells, make a new grid in the process
                game.createNextGeneration();
                
                // check the placement of cells on the fresh grid
                String newOccupied = game.getOccupied().toString();
                
                if (oldOccupied.equals(newOccupied)) // check to see if there is still room for a new generation
                {
                    doStop = true;
                    System.out.println("After " + i + " generations, the game has ended.");
                }
        }

        if (doStop == true)
        {
            for(int row = 0; row < ROWS; row++) //Check each row
            {
                for(int col = 0; col < COLS; col++) //Check each column
                {
                    // in this example, an alive cell has a non-null actor and a dead cell has a null actor
                    Actor cell = game.getActor(row, col);
    
                    // if the cell at the current row and col should be alive, assert that the actor is not null
                    if(     (col == 20 && row == 19) ||
                            (col == 21 && row == 19) ||
                            (col == 20 && row == 20) ||
                            (col == 21 && row == 20))
                    {
                        assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                    }
                    else // else, the cell should be dead; assert that the actor is null
                    {
                        assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                    }
                }
            }
        }
    }
    
}

