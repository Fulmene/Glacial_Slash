package map;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import player.PlayerStatus;
import res.Resource;

public class FinalMap extends GameMap {
	
	private static final long serialVersionUID = 5109262143404618750L;

	private ManaSource finalManaSource;
	private boolean isWin;

	public FinalMap() {
		super(Resource.finalMap);
		finalManaSource = manaSources[manaSources.length-1];
		isWin = false;
	}
	
	@Override
	public void render(Graphics2D g) {
		super.render(g);
	}
		
	public void renderTheEndContent(Graphics2D g) {
		if (isWin)
			g.drawImage(Resource.theEndContent, null, 0, 0);
	}

	@Override
	public void collideManaSources(Rectangle collisionBox) {
		super.collideManaSources(collisionBox);
		if (finalManaSource.getBoundaries().intersects(collisionBox)) {
			isWin = true;
			PlayerStatus.getPlayer().savePlayer();
		}
	}

}
