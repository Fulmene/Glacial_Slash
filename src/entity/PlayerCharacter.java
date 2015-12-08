/*
 * The character being controlled by the player
 */

package entity;

import map.Terrain;
import render.Renderable;

public class PlayerCharacter implements Renderable {

	public static final int LEFT = -1, RIGHT = 1;
	private int x, y;
	private int jumpCounter;
	
	public PlayerCharacter() {
		// TODO Auto-generated constructor stub
		jumpCounter = 0;
	}
	
	public synchronized int getX() {
		return x;
	}
	
	public synchronized int getY() {
		return y;
	}

	// Motion
	public synchronized void walk(int direction) {
		x += direction;
		// TODO play walking animation
	}
	
	public synchronized void jump() {
		// TODO implement jump
		jumpCounter = 1;
	}
	
	public synchronized void highJump() {
		jumpCounter = 2;
	}
	
	public synchronized void fall() {
		// TODO implement jumping and falling
		// Gravitational fall
		if (jumpCounter > 0){
			y -= 2;
			jumpCounter--;
			if (Terrain.isRigid(PlayerStatus.getPlayer().getCurrentMap().getTerrain(x, y+1))) {
				y += 2;
				jumpCounter = 0;
			}
			else if (Terrain.isRigid(PlayerStatus.getPlayer().getCurrentMap().getTerrain(x, y))) {
				y++;
				jumpCounter = 0;
			}
		}
		else {
			if (Terrain.isAir(PlayerStatus.getPlayer().getCurrentMap().getTerrain(x, y))) {
				y++;
				// set speed later
			}
		}
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

}
