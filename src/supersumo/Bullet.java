/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package supersumo;


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Leland
 */
public class Bullet {
    
    Image bulletTexture = null;
    float x;
    float y;
    float speed = 10;
    float vX;
    float vY;
    
    public Bullet(float x, float y, float angle)
            throws SlickException {
        this.x = x;
        this.y = y;
        this.vX = (float) Math.cos(Math.toRadians(angle))*speed;
        this.vY = (float) Math.sin(Math.toRadians(angle))*speed;
        bulletTexture = new Image("content/bullet.bmp");
    }
    
    public void update() {
        this.x += vX;
        this.y += vY;
        
    }
    
    public void draw() {
        this.bulletTexture.draw(x - bulletTexture.getHeight()/2, y - bulletTexture.getWidth()/2);
    }
}
