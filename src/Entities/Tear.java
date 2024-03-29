package Entities;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Engines.EntityEngine;
import Tools.GameFileReader;

public abstract class Tear extends Entity{
	protected double angle;
	protected double originXSpeed;
	protected double originYSPeed;
	protected boolean destroy;
	protected int damage;
	protected double knockback;
	protected boolean destroyOnContact;
	protected ArrayList<Enemy> enemiesHit;
	public Tear(Entity e,int xPos,int yPos, double a, int damage, double kb,int w,int h,boolean dOC, int aI) {
		//call to the Entity constructor 
		super(1,14,aI,xPos,yPos,w,h);
		//initializing variables
		this.destroyOnContact = dOC;
		this.enemiesHit = new ArrayList<Enemy>();
		this.angle = a;
		this.originXSpeed = e.getXSpeed();
		this.originYSPeed = e.getYSpeed();
		this.destroy = false;
		this.damage = damage;
		this.knockback = kb;
		//setting the speed of the tear
		this.setSpeed();
	}
	/**
	 * sets the x and y speeds of the bullet based on the speed of the origin of the bullet
	 */
	protected void setSpeed() {
		this.xSpeed = this.originXSpeed;
		this.ySpeed = this.originYSPeed;
		this.xSpeed += Math.cos(this.angle)*this.speed;
		this.ySpeed += Math.sin(this.angle)*this.speed;
	}
	protected void managePosition() {
		this.xPos += (int)(this.xSpeed + (int)this.savedXM); //sets the position based on the speed, casting to int before adding to fix an issue with the negative adding
		this.yPos += (int)(this.ySpeed + (int)this.savedYM);
		this.savedXM = (this.savedXM % 1) + this.xSpeed% 1; //adds the remainder of speed for x
		this.savedYM = (this.savedYM % 1) + this.ySpeed % 1;
		if (EntityEngine.checkCollision_W(this) != 0)
			this.destroy = true;



	}
	/**
	 * runs the update for the tear
	 */
	public void update() {
		this.managePosition();
	}

	/**
	 * sets the destroy variable of the tear to true so that it is destroyed upon next tick
	 */
	public void destroy() {
		this.destroy = true;
	}
	/**
	 * gets the damage of the tear
	 * @return
	 */
	public int getDamage() {
		return this.damage;
	}
	/**
	 * returns the knockback of the tear
	 * @return - double knockback
	 */
	public double getKnockback() { 
	return this.knockback;
	}
	public boolean getIsDestroyed() {
		return this.destroy;
	}
	public boolean getDestroyOnContact() {
		return this.destroyOnContact;
	}
	public ArrayList<Enemy> getEnemiesHit() {
		return this.enemiesHit;
	}

}
