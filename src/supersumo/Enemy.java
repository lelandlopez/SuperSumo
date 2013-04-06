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
    boolean isActive = true;
    int damage;
    double distance = 1000;
    int target;
    float vX;
    float vY;
    float speed = 1;

    public Enemy(float x, float y, ArrayList<Player> players) throws SlickException {
        this.enemyTexture = new Image("content/enemy.bmp");
        this.x = x;
        this.y = y;
        rect = new Rectangle((int) x, (int) y, enemyTexture.getHeight(), enemyTexture.getWidth());
        this.health = 100;
        this.damage = 100;
        for(int i = 0; i < players.size(); i++){
            if(Math.hypot(x - players.get(i).x, y - players.get(i).y)<distance){
                distance = Math.hypot(x - players.get(i).x, y - players.get(i).y);
                target = i;
            }
        }
        
    }

    public void update(ArrayList<Player> players) {
        
        double dX = players.get(target).getCenterX() - this.x - this.enemyTexture.getHeight()/2;
        double dY = players.get(target).getCenterY() - this.y - this.enemyTexture.getWidth()/2;
        double radAngle;
        radAngle = Math.atan2(dY, dX);
        double angle = Math.toDegrees(radAngle);
        this.enemyTexture.setRotation((float) angle);
        this.vX = (float) Math.cos(Math.toRadians(angle))*speed;
        this.vY = (float) Math.sin(Math.toRadians(angle))*speed;
        

        
        rect = new Rectangle((int)this.x, (int)this.y, this.enemyTexture.getHeight(), this.enemyTexture.getWidth());
        
        for (int i = 0; i < players.size(); i++) {
            for (int x = 0; x < players.get(i).primaryWeapon.bullets.size(); x++) {
                if (this.collides((int) players.get(i).primaryWeapon.bullets.get(x).x,
                        (int) players.get(i).primaryWeapon.bullets.get(x).y,
                        players.get(i).primaryWeapon.bullets.get(x).bulletTexture.getHeight(),
                        players.get(i).primaryWeapon.bullets.get(x).bulletTexture.getWidth())) {
                    this.health -= players.get(i).primaryWeapon.bullets.get(x).damage;
                    players.get(i).primaryWeapon.bullets.get(x).isActive = false;

                }

            }
            if (this.collides((int) players.get(i).x,
                    (int) players.get(i).y,
                    players.get(i).playerTexture.getHeight(),
                    players.get(i).playerTexture.getWidth())) {
                players.get(i).health -= this.damage;
                System.out.println("die bitch");
            }

        }
        
        this.x += vX;
        this.y += vY;
        
        
        
        
        
        if (this.health == 0) {
            isActive = false;
        }

    }

    public void draw() {
        this.enemyTexture.draw(x, y);
    }

    public boolean collides(int x, int y, int height, int width) {
        Rectangle a = new Rectangle(x, y, height, width);
        if (this.rect.intersects(a)) {
            return true;
        } else {
            return false;
        }
    }
}
