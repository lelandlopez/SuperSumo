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
    float speed;
    
    public Bullet(float x, float y)
            throws SlickException {
        this.x = x;
        this.y = y;
        bulletTexture = new Image("content/bullet.bmp");
    }
    
    public void draw() {
        this.bulletTexture.draw(x, y);
    }
}
