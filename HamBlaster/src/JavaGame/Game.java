package JavaGame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {

    public static final String gameName = "Bucky Land!";
    // Two screens
    public static final int menu = 0;
    public static final int play = 1;

    public Game(String gameName) {
        super( gameName );

        this.addState( new Menu(menu) );
        this.addState( new Play(play) );
    }

    public void initStatesList( GameContainer gc ) throws SlickException {
        // Inits the two screens
        this.getState( menu ).init( gc, this );
        this.getState( play ).init( gc, this );
        // Sets menu as start screen
        this.enterState( menu );
    }


    public static void main( String[] args ) {
        AppGameContainer appgc;
        try{
            appgc = new AppGameContainer( new Game( gameName ) );
            appgc.setDisplayMode( 640, 360, false );
            appgc.start();
        }
        catch( SlickException e ) {
            e.printStackTrace();
        }
    }

}
