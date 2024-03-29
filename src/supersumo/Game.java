/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supersumo;

import java.util.ArrayList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import java.util.Random;

public class Game extends BasicGame {
    
    Random random = new Random();
    ArrayList<Player> players = new ArrayList<Player>();
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
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
        players.add(player1);
        
    }

    @Override
    public void update(GameContainer gc, int delta)
            throws SlickException {
        if(players.size() == 0){
            gc.exit();
        }
        for(int i = 0; i < players.size(); i++){
            players.get(i).update(gc);
            if(players.get(i).isActive == false){
                players.remove(i);
            }
        }
        if(enemies.size() == 0){
            enemies.add(new Enemy(random.nextInt(gc.getHeight()), random.nextInt(gc.getWidth()), players));
        }
        
        for(int i = 0; i < enemies.size(); i++){
            enemies.get(i).update(players);
            if(enemies.get(i).isActive == false){
                enemies.remove(i);
            }
        }
        

    }

    public void render(GameContainer gc, Graphics g)
            throws SlickException {
        ring.draw();
        for(int i = 0; i < players.size(); i++){
            players.get(i).draw();
        }
        for(int i = 0; i < enemies.size(); i++){
            enemies.get(i).draw();
        }

    }

    public static void main(String[] args)
            throws SlickException {
        AppGameContainer app =
                new AppGameContainer(new Game());
        app.setDisplayMode(700, 700, false);
        app.setTargetFrameRate(120);
        app.start();
    }
}