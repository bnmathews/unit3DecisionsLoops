
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import info.gridworld.actor.Actor;

/**
 * The test class GameOfLifeTest.
 *
 * @author  @gcschmit
 * @version 19 July 2014
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
         *  0 X X X X X X X X X X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X
         *  1 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X
         *  2 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X
         *  3 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X
         *  4 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X
         *  5 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X 
         *  6 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X
         *  7 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X  
         *  8 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X  
         *  9 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X  
         * 10 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X
         * 11 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X 
         * 12 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X  
         * 13 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X  
         * 14 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X  
         * 15 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X  
         * 16 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X 
         * 17 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X 
         * 18 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X
         * 19 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X
         * 20 X X X X X X X X X X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X
         */
        
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
                        (col== 8 && row == 5) ||
                        (col== 9 && row == 5) ||
                        (col== 8 && row == 7) ||
                        (col== 9 && row == 8) ||
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
    public void testFinalState()
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
         *  8 - - - - - - - - X X  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         *  9 - - - - - - - X - -  X  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         * 10 - - - - - - - - X X  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - 
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
                if(     (col == 8 && row == 8) ||
                        (col == 8 && row == 8) ||
                        (col == 7 && row == 9) ||
                        (col == 10 && row == 9) ||
                        (col == 8 && row == 10) ||
                        (col == 9 && row == 10))
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
    public void testFinalState2()
    throws InterruptedException
    {
        /* verify that the actual pattern matches the expected pattern after 3 generations
         *  (X: alive; -: dead)
         * 
         *    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29
         *  0 - - - - - - - X X -  -  -  -  -  -  -  -  -  -  -  -  X  X  -  -  -  -  -  -  - 
         *  1 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  2 - - - - - - - - - -  -  -  -  -  X  X  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  3 - - - - - - - - - -  -  -  -  X  -  -  X  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  4 - - - - - - - - - -  -  -  -  -  X  X  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  5 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - 
         *  6 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         *  7 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X  
         *  8 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X    
         *  9 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 10 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  
         * 12 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X    
         * 13 X - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  X    
         * 14 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 15 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 16 - - - - - - - - - -  -  -  -  -  X  X  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 17 - - - - - - - - - -  -  -  -  X  -  -  X  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 18 - - - - - - - - - -  -  -  -  -  X  X  -  -  -  -  -  -  -  -  -  -  -  -  -  -    
         * 19 - - - - - - - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -     
         * 20 - - - - - - - X X -  -  -  -  -  -  -  -  -  -  -  -  X  X  -  -  -  -  -  -  - 
         */
        
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
                if(     (col == 7 && row == 0) ||
                        (col == 8 && row == 0) ||
                        (col == 14 && row == 2) ||
                        (col == 15 && row == 2) ||
                        (col == 21 && row == 0) ||
                        (col == 22 && row == 0) ||
                        (col == 13 && row == 3) ||
                        (col == 16 && row == 3) ||
                        (col == 14 && row == 4) ||
                        (col == 15 && row == 4) ||
                        (col == 0 && row == 7) ||
                        (col == 29 && row == 7) ||
                        (col == 0 && row == 8) ||
                        (col == 29 && row == 8) ||
                        (col == 0 && row == 12) ||
                        (col == 29 && row == 12) ||
                        (col == 0 && row == 13) ||
                        (col == 29 && row == 13) ||
                        (col == 14 && row == 16) ||
                        (col == 15 && row == 16) ||
                        (col == 13 && row == 17) ||
                        (col == 16 && row == 17) ||
                        (col == 14 && row == 18) ||
                        (col == 15 && row == 18) ||
                        (col == 7 && row == 20) ||
                        (col == 8 && row == 20) ||
                        (col == 21 && row == 20) ||
                        (col == 22 && row == 20))
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

