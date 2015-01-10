package JavaGame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

        // Animations for moving in all directions plus current state
    Animation bucky, movingUp, movingDown, movingLeft, movingRight;
    Image worldMap;
        // User quits
    boolean quit = false;
    int[] duration = { 200, 200 };
    float buckyPositionX = 0;
    float buckyPositionY = 0;
    float shiftX = buckyPositionX + 320;
    float shiftY = buckyPositionY + 160;

    public Play( int state ){

    }

    public void init( GameContainer gc, StateBasedGame sbg ) throws SlickException {
        worldMap = new Image( "HamBlaster/res/world.png" );
        Image[] walkUp = { new Image( "HamBlaster/res/buckysBack.png" ), new Image( "HamBlaster/res/buckysBack.png" ) };
        Image[] walkDown = { new Image( "HamBlaster/res/buckysFront.png" ), new Image( "HamBlaster/res/buckysFront.png" ) };
        Image[] walkLeft = { new Image( "HamBlaster/res/buckysLeft.png" ), new Image( "HamBlaster/res/buckysLeft.png" ) };
        Image[] walkRight = { new Image( "HamBlaster/res/buckysRight.png" ), new Image( "HamBlaster/res/buckysRight.png" ) };

        movingUp = new Animation( walkUp, duration, false );
        movingDown = new Animation( walkDown, duration, false );
        movingLeft = new Animation( walkLeft, duration, false );
        movingRight = new Animation( walkRight, duration, false );
        bucky = movingDown;

    }

    public void render( GameContainer gc, StateBasedGame sbg, Graphics g ) throws SlickException {
        worldMap.draw( buckyPositionX, buckyPositionY );
        bucky.draw( shiftX, shiftY );
        g.drawString("Bucky's X: " + buckyPositionX + "\nBucky's Y: " + buckyPositionY, 400, 20 );

        if ( quit == true ) {
            g.drawString( "Resume ( R )", 250, 100 );
            g.drawString( "Main Menu ( M )", 250, 150 );
            g.drawString( "Quit Game ( Q )", 250, 200 );
            if( quit == false ) {
                g.clear();
            }
        }
    }

    public void update( GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException {

    }

    public int getID() {
        return 1;
    }
}
