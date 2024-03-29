package Entities;

import Engines.EntityEngine;

public abstract class Enemy extends Entity{
	protected int movDir;
	protected int onHitDamage;
	protected int lastPlayerX,lastPlayerY;
	protected boolean isFlying;
	protected int driftFactor;
	protected double savedXM, savedYM;
	protected double repulsionFactor;
	protected int lastHitTimer;
	protected int redShiftTime;
	/**
	 * initializes the enemy with values and setup information 
	 * @param mH - max health of the enemy
	 * @param sp - speed of the enemy
	 * @param aS - animation speed of the enemy
	 * @param xP - x position of the enemy
	 * @param yP - y position of the enemy
	 * @param h - height of the enemy
	 * @param w - width of the enemy
	 * @param oHD - on hit damage of the enemy
	 * @param dF - drift factor of the enemy (1 is no drift, 0 will throw an error)
	 * @param rF - repulsion factor of the enemy
	 * @param rST - red shift time of the enemy
	 */
	public Enemy(int mH, int sp, int aS, int xP, int yP, int w, int h, int oHD, boolean iF, int dF, double rF,int rST) {
		super(mH,sp,aS,xP,yP,w,h);
		this.onHitDamage = oHD;
		this.isFlying = iF;
		this.driftFactor = dF;
		this.repulsionFactor = rF;
		this.redShiftTime = rST;
	}
	/**
	 * basic update for all enemies
	 */
	public void update() {
		int[] temp = EntityEngine.getPlayerPosition();
		this.lastPlayerX = temp[0];
		this.lastPlayerY = temp[1];
	}
	/**
	 * knocks back the enemy based on the xspeed, yspeed and knockback factor of what hits it
	 * @param xSpeed - xspeed of the item knocking enemy back
	 * @param ySpeed - yspeed of the item knocking enemy back
	 * @param knockback - knockback factor of the item
	 */
	public void knockback(double xSpeed, double ySpeed, double knockback) {
		this.xSpeed += xSpeed*knockback;
		this.ySpeed += ySpeed*knockback;
	}
	/**
	 * unimplemented animate for all classes of type Enemy
	 */
	protected abstract void animate();
	/**
	 * unimplemented speed management for all classes of type Enemy
	 * @param angle - angle of the enemies movement
	 */
	protected abstract void manageSpeed(double angle);
	
	/**
	 * manages the AI of the enemy
	 */
	protected abstract void manageAI();
	/**
	 * returns the damage this enemy does on hit
	 * @return - the on hit damage of the enemy
	 */
	public int getOnHitDamage() {
		return this.onHitDamage;
	}
	/**
	 * repels the enemy from other enemies of its type (flying or non-flying)
	 * @param angle - angle between the enemies
	 * @param distance - distance between the enemies
	 */
	public void enemyRepulsion(double angle, double distance) {
		distance = distance == 0 ? 1 : distance;
		this.xSpeed -= Math.cos(angle) * this.repulsionFactor/distance;
		this.ySpeed -= Math.sin(angle) * this.repulsionFactor/distance;
	}
	/**
	 * returns whether the enemy is flying or not
	 * @return - boolean if it is flying
	 */
	public boolean getIsFlying() {
		return this.isFlying;
	}
	public void setLastHitTimer() {
		this.lastHitTimer = this.redShiftTime;
	}
}