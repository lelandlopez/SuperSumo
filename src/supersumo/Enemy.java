/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supersumo;

import java.util.ArrayList;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import java.awt.Rectangle;
/**
 *
 * @author Leland
 */
public class Enemy {
    
    float x;
    float y;
    Image enemyTexture = null;
    float moveSpeed;
    float angle;
    int health;
    Rectangle rect;
    
    public Enemy(float x, float y) throws SlickException {
        this.enemyTexture = new Image("content/enemy.bmp");
        this.x = x;
        this.y = y;
        rect = new Rectangle((int)x, (int)y, enemyTexture.getHeight(), enemyTexture.getWidth());
        this.health = 100;
    }
    
    public void update(ArrayList<Player> players){
        
        for(int i = 0; i < players.size(); i++){
            for(int x = 0; x < players.get(i).primaryWeapon.bullets.size(); x++){
                if(this.collides((int)players.get(i).primaryWeapon.bullets.get(x).x,
                        (int)players.get(i).primaryWeapon.bullets.get(x).y,
                        players.get(i).primaryWeapon.bullets.get(x).bulletTexture.getHeight(),
                                players.get(i).primaryWeapon.bullets.get(x).bulletTexture.getWidth())){
                    this.health-= players.get(i).primaryWeapon.bullets.get(x).damage;
                    players.get(i).primaryWeapon.bullets.get(x).isActive = false;

                }
            }
        }
        if(this.health == 0){
            System.out.println("im dead");
        }
        
    }
    
    public void draw() {
        this.enemyTexture.draw(x, y);
    }
    
    public boolean collides(int x, int y, int height, int width) {
        Rectangle a = new Rectangle(x, y, height, width);
        if(this.rect.intersects(a)){
            return true;
        }
        else return false;
    }
    
}
