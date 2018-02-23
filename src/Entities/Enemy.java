package Entities;

import Engines.EntityEngine;

public abstract class Enemy extends Entity{
	protected int movDir;
	protected int onHitDamage;
	protected int lastPlayerX,lastPlayerY;
	protected boolean isFlying;
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
	 */
	public Enemy(int mH, int sp, int aS, int xP, int yP, int h, int w, int oHD, boolean iF) {
		super(mH,sp,aS,xP,yP,h,w);
		this.onHitDamage = oHD;
		this.isFlying = iF;
		int[] temp = EntityEngine.getPlayerPosition();
		this.lastPlayerX = temp[0];
		this.lastPlayerY = temp[1];
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
	 * unimplemented animate for all classes of type Enemy
	 */
	protected abstract void animate();
	
	/**
	 * returns the damage this enemy does on hit
	 * @return - the on hit damage of the enemy
	 */
	public int getOnHitDamage() {
		return this.onHitDamage;
	}
	
}