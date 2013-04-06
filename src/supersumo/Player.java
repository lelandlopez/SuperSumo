/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supersumo;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import java.util.ArrayList;

/**
 *
 * @author Leland Lopez
 */

import org.newdawn.slick.Input;

public class Player {

    Image playerTexture = null;
    float x;
    float y;
    float moveSpeed = 5;
    double angle;
    boolean canShoot = true;
    int canShootFrames = 0;
    PrimaryWeapon primaryWeapon = new Pistol();
    int health = 100;
    boolean isActive = true;

    public Player() throws SlickException {
        this.playerTexture = new Image("content/red.bmp");
    }
    
    public void update(GameContainer gc) throws SlickException {
        Input input = gc.getInput();
        double dX = input.getMouseX() - this.getCenterX();
        double dY = input.getMouseY() - this.getCenterY();
        double radAngle;
        radAngle = Math.atan2(dY, dX);
        double angle = Math.toDegrees(radAngle);
        this.playerTexture.setRotation((float) angle);
        
        primaryWeapon.update(gc);

        if(input.isKeyDown(Input.KEY_ESCAPE)){
            gc.exit();
        }
        
        if(input.isKeyDown(Input.KEY_W)){
            this.y -= moveSpeed;
        }
        if(input.isKeyDown(Input.KEY_S)){
            this.y += moveSpeed;
        }
        
        if(input.isKeyDown(Input.KEY_A)){
            this.x -= moveSpeed;
        }
        
        if(input.isKeyDown(Input.KEY_D)){
            this.x += moveSpeed;
        }
        
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            if(primaryWeapon.canShoot()){
                this.primaryWeapon.shoot((double)angle, getCenterX(), getCenterY());
            }
        }

        if(input.isKeyDown(Input.KEY_LSHIFT)){
            primaryWeapon.reload();
        }
        
        if(this.health <= 0){
            this.isActive = false;
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
    
    public double getCenterX(){
        return this.x + this.playerTexture.getWidth()/2;
    }
    
    public double getCenterY(){
        return this.y + this.playerTexture.getHeight()/2;
    }

    public void draw() {
        this.playerTexture.draw(x, y);
        this.primaryWeapon.draw();
    }
}
