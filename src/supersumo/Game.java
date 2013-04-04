/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supersumo;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame {

    Ring ring;
    Player player1;

    public Game() {
        super("Super Sumo");
    }

    @Override
    public void init(GameContainer gc)
            throws SlickException {
        ring = new Ring();
        player1 = new Player();
        player1.setPosition(325, 325);
    }

    @Override
    public void update(GameContainer gc, int delta)
            throws SlickException {
        player1.update(gc);

    }

    public void render(GameContainer gc, Graphics g)
            throws SlickException {
        ring.draw();
        player1.draw();

    }

    public static void main(String[] args)
            throws SlickException {
        AppGameContainer app =
                new AppGameContainer(new Game());
        app.setDisplayMode(700, 700, false);
        app.setTargetFrameRate(60);
        app.start();
    }
}