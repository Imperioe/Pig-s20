package edu.up.cs301;

import android.view.MotionEvent;
import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import edu.up.cs301.game.GameFramework.actionMessage.MyNameIsAction;
import edu.up.cs301.game.GameFramework.actionMessage.ReadyAction;
import edu.up.cs301.game.GameFramework.players.GamePlayer;
import edu.up.cs301.game.R;
import edu.up.cs301.pig.PigLocalGame;
import edu.up.cs301.pig.PigMainActivity;
import edu.up.cs301.pig.infoMessage.PigState;

import static org.junit.Assert.*;

/* @author Eric Imperio
 * @version 2020
 * Use this as a template to make your own tests
 * These are go tests to use
 * Additional tests are good as well
 * NOTE: Avoid tests that simply check one action.
 *    Example: You know that the following will set the expected value.
 *        a = b + 2;
 */
@RunWith(RobolectricTestRunner.class)
public class PigTests {

    public PigMainActivity activity;

    @Before
    public void setup() throws Exception {
        activity = Robolectric.buildActivity(PigMainActivity.class).create().resume().get();
    }

    //This does a full game to verify it works
    // Notice that it includes invalid moves
    // You can do it this way or have multiple unit tests that do this
    // Sometimes easier to just have one since this is turn-based
    @Test
    public void test_checkGamePlay() {
        //TODO: You need to implement this method
        //TODO: Modify the following for your game
        //Starting the game
        View view = activity.findViewById(R.id.playGameButton);
        activity.onClick(view);
        //Getting the created game
        PigLocalGame pigLocalGame = (PigLocalGame) activity.getGame();
        //Getting the players
        GamePlayer[] gamePlayers = pigLocalGame.getPlayers();
        //Sending the names of the players to the game
        for (GamePlayer gp : gamePlayers) {
            pigLocalGame.sendAction(new MyNameIsAction(gp, gp.getClass().toString()));
        }
        //Telling the game everyone is ready
        for (GamePlayer gp : gamePlayers) {
            pigLocalGame.sendAction(new ReadyAction(gp));
        }
        //TODO: Start Making moves here
        GamePlayer player1 = gamePlayers[0];
        GamePlayer player2 = gamePlayers[1];
        //Can I make two moves in a row?

        //Setting the expected outcome of the two lines above
        PigState match = new PigState();

        //Testing that I couldn't make two moves in a row
        assertTrue("Game States were not equal", ((PigState) pigLocalGame.getGameState()).equals(match));


        //Get to a finished game

        //Make sure player 1 won
        assertEquals("Player 1 did not win", 0, pigLocalGame.whoWon());
        //Check if you can move after game over
        assertTrue("Game States were not equal", ((PigState) pigLocalGame.getGameState()).equals(match));
    }

    //Tests focused on the state: copy constructors and equals
    //copy cons:  empty default state, in progress state, full board state
    //This tests the copy constructor when nothing is set
    @Test
    public void test_CopyConstructorOfState_Empty(){
        //TODO: Modify the following for your game
        PigState pigState = new PigState();
        PigState copyState = new PigState(pigState);
        assertTrue("Copy Constructor did not produce equal States", pigState.equals(copyState));
    }

    //Make state that looks like a game that'd be in progress
    @Test
    public void test_CopyConstructorOfState_InProgress(){
        //TODO: Modify the following for your game
        PigState pigState = new PigState();
        PigState copyState = new PigState(pigState);
        assertTrue("Copy Constructor did not produce equal States", pigState.equals(copyState));
    }

    // Make a state that has all values set to something (preferably not default)
    @Test
    public void test_CopyConstructorOfState_Full(){
        //TODO: Modify the following for your game
        PigState pigState = new PigState();
        PigState copyState = new PigState(pigState);
        assertTrue("Copy Constructor did not produce equal States", pigState.equals(copyState));
    }

    //These follow the same structure as copy but they test your equals method
    // Copy might fail because your equals is wrong
    // DO NOT make equals use copy while copy is using equals. You won't know which is broken easily.
    //Equals
    @Test
    public void test_Equals_State_Empty(){
        //TODO: Modify the following for your game
        PigState pigState = new PigState();
        PigState otherState = new PigState(pigState);
        assertTrue("Equals method did not agree the States where equal", pigState.equals(otherState));
    }

    @Test
    public void test_Equals_State_InProgress(){
        //TODO: Modify the following for your game
        PigState pigState = new PigState();
        PigState otherState = new PigState(pigState);
        assertTrue("Equals method did not agree the States where equal", pigState.equals(otherState));
    }

    @Test
    public void test_Equals_State_Full(){
        //TODO: Modify the following for your game
        PigState pigState = new PigState();
        PigState otherState = new PigState(pigState);
        assertTrue("Equals method did not agree the States where equal", pigState.equals(otherState));
    }
}