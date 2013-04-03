/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supersumo;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Leland Lopez
 */

import org.newdawn.slick.Input;

public class Player {

    Image playerTexture = null;
    float x;
    float y;

    public Player(String a)
            throws SlickException {
        this.playerTexture = new Image(a);
    }
    
    public void update(GameContainer gc){
        Input input = gc.getInput();
        double dX = input.getMouseX() - this.getCenterX();
        double dY = input.getMouseY() - this.getCenterY();
        double radAngle;
        radAngle = Math.atan2(dY, dX);
        double angle = Math.toDegrees(radAngle);
        this.playerTexture.setRotation((float) angle);
        
        if(input.isKeyDown(Input.KEY_ESCAPE)){
            gc.exit();
        }
        
        if(input.isKeyDown(Input.KEY_W)){
            this.y -= Math.cos(dY/Math.hypot(dX, dY));
            this.x += Math.sin(dX/Math.hypot(dX, dY));
        }
    }
    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public int getHeight(){
        return playerTexture.getHeight();
    }
    
    public int getWidth(){
        return playerTexture.getWidth();
    }
    
    public float getCenterX(){
        return this.x + this.playerTexture.getWidth()/2;
    }
    
    public float getCenterY(){
        return this.y + this.playerTexture.getHeight()/2;
    }

    public void draw() {
        this.playerTexture.draw(x, y);
    }
}
