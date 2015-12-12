/*
 * Runnable to control the player character
 */

package player;

import javax.swing.JOptionPane;

import exception.SkillCardUnusableException;
import input.InputUtility;
import input.InputUtility.CommandKey;
import screen.GameScreen;

public class GameLoop implements Runnable {

	private PlayerCharacter player;
	
	public GameLoop() {
		this.player = PlayerStatus.getPlayer().getPlayerCharacter();
	}

	public void run() {
		
		final long FRAME_RATE = 30;
		final long UPDATE_TIME = 1000000000 / FRAME_RATE;
		
		long lastUpdateTime = System.nanoTime();

		while (true) {

			long now = System.nanoTime();

			while (now - lastUpdateTime < UPDATE_TIME) {
				now = System.nanoTime();
				Thread.yield();
			}

			lastUpdateTime = now;
		
			if (InputUtility.getKeyTriggered(CommandKey.EXIT)) {
				InputUtility.clearKeyPressed();
				if (JOptionPane.showConfirmDialog(null, "Are you sure want to exit?", "Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					synchronized (this) {
						this.notifyAll();
					}
				}
			}
		
			playerInputUpdate();

			synchronized (GameScreen.getScreen()) {
				GameScreen.getScreen().notifyAll();
			}

		}

	}
	
	private void playerInputUpdate() {
	
		player.updateBoundaries();
		player.fall();
		
		if (player.getFreezePlayerControlCount() <= 0) {

			synchronized (PlayerStatus.getPlayer().getHand()) {
				if (InputUtility.getKeyPressed(CommandKey.LEFT))
					player.walk(PlayerCharacter.LEFT);
				else if (InputUtility.getKeyPressed(CommandKey.RIGHT))
					player.walk(PlayerCharacter.RIGHT);
				else
					player.walk(PlayerCharacter.IDLE);

				if (InputUtility.getKeyTriggered(CommandKey.JUMP)) {
					if (player.isOnGround())
						player.jump();
					else
						try {
							PlayerStatus.getPlayer().useCard(SkillCard.DOUBLE_JUMP);
						} catch (SkillCardUnusableException e) {}
				}

				if (InputUtility.getKeyTriggered(CommandKey.SLASH)) {
					if (InputUtility.getKeyPressed(CommandKey.UP)) {
						try {
							PlayerStatus.getPlayer().useCard(SkillCard.SKY_UPPERCUT);
						} catch (SkillCardUnusableException e) {
							player.slash();
						}
					}
					else
						player.slash();
				}

				if (InputUtility.getKeyTriggered(CommandKey.DASH)) {
					if (InputUtility.getKeyPressed(CommandKey.LEFT) || InputUtility.getKeyPressed(CommandKey.RIGHT)) {
						try {
							PlayerStatus.getPlayer().useCard(SkillCard.GLACIAL_DRIFT);
						} catch (SkillCardUnusableException e) {}
					}
				}
				
				if (InputUtility.getKeyTriggered(CommandKey.HAND)) {
					if (InputUtility.getKeyPressed(CommandKey.DOWN))
						try {
							PlayerStatus.getPlayer().useCard(SkillCard.ICE_SUMMON);
						} catch (SkillCardUnusableException e) {}
				}
				
				if (InputUtility.getKeyTriggered(CommandKey.DRAW)) {
					try {
						PlayerStatus.getPlayer().useCard(SkillCard.CONCENTRATION);
					} catch (SkillCardUnusableException e) {}
				}

			}

		}
		else {
			player.decreseFreezePlayerControlCount();
		}

		player.moveX();
		player.moveY();

		InputUtility.clearKeyTriggered();
	}

}