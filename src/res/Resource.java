package res;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Resource {

	public static BufferedImage tileGround, tileLeft, tileRight, tileMid, tileTop, tileTopLeft, tileTopRight, tileIce;
	public static BufferedImage checkPoint, usedCheckPoint;
	public static BufferedImage[] mana = new BufferedImage[21], maxMana = new BufferedImage[21];
	public static BufferedImage slash;
	public static BufferedImage doubleJump, glacialDrift, iceSummon, skyUppercut, concentration;
	public static BufferedImage[] standSprite = new BufferedImage[2];
	public static BufferedImage[][] jumpSprite = new BufferedImage[2][4];
	public static BufferedImage[][] walkSprite = new BufferedImage[2][6];
	public static BufferedImage[][] cutSprite = new BufferedImage[2][9];
	public static BufferedImage[][] dashSprite = new BufferedImage[2][1];
	public static BufferedImage[][] iceSummonSprite = new BufferedImage[2][8];
	public static BufferedImage[] cardAnimation = new BufferedImage[12];
	public static BufferedImage background;
	public static BufferedImage title, startButton, loadButton, exitButton;
	public static BufferedImage upButton, leftButton, downButton, rightButton, dButton, escButton, fButton, rButton,
			sButton, spaceButton, eButton, plusButton;
	public static BufferedImage walkContent, jumpContent, yourHandContent, doublejumpContent, glacialDriftContent,
			iceSummonContent, skyUppercutContent, exitContent, returnContent, theEndContent, concentrationContent,
			checkpointContent, yourManaContent;

	public static InputStream tutorialMap, easyMap, normalMap, hardMap, finalMap;
	public static Clip titleBGM, stageBGM;
	public static AudioInputStream cardAudioIn, checkPointAudioIn, dashAudioIn, doubleJumpAudioIn, iceSummonAudioIn, jumpAudioIn, skyUppercutAudioIn;
	public static AudioFormat cardAudioFormat, checkPointAudioFormat, dashAudioFormat, doubleJumpAudioFormat, iceSummonAudioFormat, jumpAudioFormat, skyUppercutAudioFormat;
	public static byte[] cardSound, checkPointSound, dashSound, doubleJumpSound, iceSummonSound, jumpSound, skyUppercutSound;

	private static ClassLoader loader = Resource.class.getClassLoader();

	static {

		// Load tileset ..
		try {
			tileGround = ImageIO.read(loader.getResource("res/tile/tile_ground.png"));
		} catch (IOException e) {
			tileGround = null;
		}
		try {
			tileLeft = ImageIO.read(loader.getResource("res/tile/tile_left.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			tileLeft = null;
		}
		try {
			tileRight = ImageIO.read(loader.getResource("res/tile/tile_right.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			tileRight = null;
		}
		try {
			tileMid = ImageIO.read(loader.getResource("res/tile/tile_mid.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			tileMid = null;
		}
		try {
			tileTop = ImageIO.read(loader.getResource("res/tile/tile_top.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			tileTop = null;
		}
		try {
			tileIce = ImageIO.read(loader.getResource("res/tile/tile_ice.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			tileIce = null;
		}

		try {
			checkPoint = ImageIO.read(loader.getResource("res/tile/checkpoint.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			checkPoint = null;
		}
		try {
			usedCheckPoint = ImageIO.read(loader.getResource("res/tile/usedcheckpoint.png"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			usedCheckPoint = null;
		}
		try {
			tileTopLeft = ImageIO.read(loader.getResource("res/tile/tile_topleft.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			tileTopLeft = null;
		}
		try {
			tileTopRight = ImageIO.read(loader.getResource("res/tile/tile_topright.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			tileTopRight = null;
		}

		// Load mana,maxMana and slash
		for (int i = 0; i <= 20; i++) {
			try {
				mana[i] = ImageIO.read(loader.getResource("res/mana/" + i + ".png"));
			} catch (IOException e) {
				mana[i] = null;
			}
		}
		for (int i = 0; i <= 20; i++) {
			try {
				maxMana[i] = ImageIO.read(loader.getResource("res/mana/m" + i + ".png"));
			} catch (IOException e) {
				maxMana[i] = null;
			}
		}
		try {
			slash = ImageIO.read(loader.getResource("res/mana/slash.png"));
		} catch (IOException e) {
			slash = null;
		}

		try {
			doubleJump = ImageIO.read(loader.getResource("res/card/DoubleJump.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			doubleJump = null;
		}
		try {
			glacialDrift = ImageIO.read(loader.getResource("res/card/GlacialDrift.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			glacialDrift = null;
		}
		try {
			iceSummon = ImageIO.read(loader.getResource("res/card/IceSummon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			iceSummon = null;
		}
		try {
			skyUppercut = ImageIO.read(loader.getResource("res/card/SkyUppercut.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			skyUppercut = null;
		}

		try {
			concentration = ImageIO.read(loader.getResource("res/card/Concentration.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			concentration = null;
		}
		// Load sprite
		try {
			standSprite[0] = ImageIO.read(loader.getResource("res/sprite/stand/stl0.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			standSprite[0] = null;
		}
		try {
			standSprite[1] = ImageIO.read(loader.getResource("res/sprite/stand/str0.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			standSprite[1] = null;
		}
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 3; j++) {
				try {
					jumpSprite[i][j] = ImageIO.read(loader.getResource("res/sprite/jump/j" + i + "_" + j + ".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					jumpSprite[i][j] = null;
				}
			}
		}

		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 5; j++) {
				try {
					walkSprite[i][j] = ImageIO.read(loader.getResource("res/sprite/walk/w" + i + "_" + j + ".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					walkSprite[i][j] = null;
				}
			}
		}
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 8; j++) {
				try {
					cutSprite[i][j] = ImageIO.read(loader.getResource("res/sprite/cut/c" + i + "_" + j + ".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					cutSprite[i][j] = null;
				}
			}
		}
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 0; j++) {
				try {
					dashSprite[i][j] = ImageIO.read(loader.getResource("res/sprite/dash/d" + i + "_" + j + ".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					dashSprite[i][j] = null;
				}
			}
		}

		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 7; j++) {
				try {
					iceSummonSprite[i][j] = ImageIO
							.read(loader.getResource("res/sprite/icesummon/i" + i + "_" + j + ".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					iceSummonSprite[i][j] = null;
				}
			}
		}

		for (int i = 0; i <= 11; i++) {
			try {
				cardAnimation[i] = ImageIO.read(loader.getResource("res/card/animation/card_" + i + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				cardAnimation = null;
			}
		}

		try {
			background = ImageIO.read(loader.getResource("res/map/background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			background = null;
		}

		// Load title image
		try {
			title = ImageIO.read(loader.getResource("res/title/title.png"));
		} catch (IOException e1) {
			title = null;
		}
		try {
			startButton = ImageIO.read(loader.getResource("res/title/new.png"));
		} catch (IOException e) {
			startButton = null;
		}
		try {
			loadButton = ImageIO.read(loader.getResource("res/title/load.png"));
		} catch (IOException e) {
			loadButton = null;
		}
		try {
			exitButton = ImageIO.read(loader.getResource("res/title/exit.png"));
		} catch (IOException e) {
			exitButton = null;
		}

		// load tutorial button
		try {
			upButton = ImageIO.read(loader.getResource("res/map/tutorial/up.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			upButton = null;
		}
		try {
			leftButton = ImageIO.read(loader.getResource("res/map/tutorial/left.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			leftButton = null;
		}
		try {
			downButton = ImageIO.read(loader.getResource("res/map/tutorial/down.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			downButton = null;
		}
		try {
			rightButton = ImageIO.read(loader.getResource("res/map/tutorial/right.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			rightButton = null;
		}
		try {
			dButton = ImageIO.read(loader.getResource("res/map/tutorial/D.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			dButton = null;
		}
		try {
			escButton = ImageIO.read(loader.getResource("res/map/tutorial/esc.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			escButton = null;
		}
		try {
			fButton = ImageIO.read(loader.getResource("res/map/tutorial/F.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			fButton = null;
		}
		try {
			rButton = ImageIO.read(loader.getResource("res/map/tutorial/R.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			rButton = null;
		}
		try {
			sButton = ImageIO.read(loader.getResource("res/map/tutorial/S.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			sButton = null;
		}
		try {
			spaceButton = ImageIO.read(loader.getResource("res/map/tutorial/space.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			spaceButton = null;
		}
		try {
			eButton = ImageIO.read(loader.getResource("res/map/tutorial/E.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			eButton = null;
		}
		try {
			plusButton = ImageIO.read(loader.getResource("res/map/tutorial/plus.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			plusButton = null;
		}

		// load Content
		try {
			walkContent = ImageIO.read(loader.getResource("res/map/content/walk.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			walkContent = null;
		}
		try {
			jumpContent = ImageIO.read(loader.getResource("res/map/content/jump.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			jumpContent = null;
		}
		try {
			yourHandContent = ImageIO.read(loader.getResource("res/map/content/yourhand.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			yourHandContent = null;
		}
		try {
			exitContent = ImageIO.read(loader.getResource("res/map/content/exit.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			exitContent = null;
		}
		try {
			returnContent = ImageIO.read(loader.getResource("res/map/content/return.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			returnContent = null;
		}
		try {
			doublejumpContent = ImageIO.read(loader.getResource("res/map/content/doublejump.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			doublejumpContent = null;
		}
		try {
			glacialDriftContent = ImageIO.read(loader.getResource("res/map/content/glacialdrift.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			glacialDriftContent = null;
		}
		try {
			iceSummonContent = ImageIO.read(loader.getResource("res/map/content/icesummon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			iceSummonContent = null;
		}
		try {
			skyUppercutContent = ImageIO.read(loader.getResource("res/map/content/skyuppercut.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			skyUppercutContent = null;
		}
		try {
			theEndContent = ImageIO.read(loader.getResource("res/map/content/the_end.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			theEndContent = null;
		}
		try {
			concentrationContent = ImageIO.read(loader.getResource("res/map/content/concentration.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			concentrationContent = null;
		}
		try {
			checkpointContent = ImageIO.read(loader.getResource("res/map/content/checkpoint.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			checkpointContent = null;
		}
		try {
			yourManaContent = ImageIO.read(loader.getResource("res/map/content/yourmana.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			yourManaContent = null;
		}



		tutorialMap = loader.getResourceAsStream("res/map/tutorial.map");
		easyMap = loader.getResourceAsStream("res/map/easy.map");
		normalMap = loader.getResourceAsStream("res/map/normal.map");
		hardMap = loader.getResourceAsStream("res/map/hard.map");
		finalMap = loader.getResourceAsStream("res/map/final.map");

		//load sound
		try {
			titleBGM = AudioSystem.getClip();
			titleBGM.open(AudioSystem.getAudioInputStream(loader.getResourceAsStream("res/sound/titleBGM.wav")));
		} catch (LineUnavailableException e) {
		} catch (UnsupportedAudioFileException e) {
		} catch (IOException e) {}

		try {
			stageBGM = AudioSystem.getClip();
			stageBGM.open(AudioSystem.getAudioInputStream(loader.getResourceAsStream("res/sound/stageBGM.wav")));
		} catch (LineUnavailableException e) {
		} catch (UnsupportedAudioFileException e) {
		} catch (IOException e) {}

		cardAudioIn = readAudio(loader.getResourceAsStream("res/sound/soundeffect/card.wav"));
		cardAudioFormat = cardAudioIn.getFormat();
		cardSound = getByteArray(cardAudioIn, cardAudioFormat);

		checkPointAudioIn = readAudio(loader.getResourceAsStream("res/sound/soundeffect/checkpoint.wav"));
		checkPointAudioFormat = checkPointAudioIn.getFormat();
		checkPointSound = getByteArray(checkPointAudioIn, checkPointAudioFormat);

		dashAudioIn = readAudio(loader.getResourceAsStream("res/sound/soundeffect/dash.wav"));
		dashAudioFormat = dashAudioIn.getFormat();
		dashSound = getByteArray(dashAudioIn, dashAudioFormat);

		doubleJumpAudioIn = readAudio(loader.getResourceAsStream("res/sound/soundeffect/doublejump.wav"));
		doubleJumpAudioFormat = doubleJumpAudioIn.getFormat();
		doubleJumpSound = getByteArray(doubleJumpAudioIn, doubleJumpAudioFormat);

		iceSummonAudioIn = readAudio(loader.getResourceAsStream("res/sound/soundeffect/icesummon.wav"));
		iceSummonAudioFormat = dashAudioIn.getFormat();
		iceSummonSound = getByteArray(iceSummonAudioIn, iceSummonAudioFormat);

		jumpAudioIn = readAudio(loader.getResourceAsStream("res/sound/soundeffect/jump.wav"));
		jumpAudioFormat = jumpAudioIn.getFormat();
		jumpSound = getByteArray(jumpAudioIn, jumpAudioFormat);

		skyUppercutAudioIn = readAudio(loader.getResourceAsStream("res/sound/soundeffect/skyuppercut.wav"));
		skyUppercutAudioFormat = dashAudioIn.getFormat();
		skyUppercutSound = getByteArray(skyUppercutAudioIn, skyUppercutAudioFormat);

	}
	
	private static AudioInputStream readAudio(InputStream in) {
		try {
			return AudioSystem.getAudioInputStream(in);
		} catch (Exception e) {
			return null;
		}
	}
	
	private static byte[] getByteArray(AudioInputStream audioIn, AudioFormat format) {
		try {
			int size = (int)(format.getFrameSize() * audioIn.getFrameLength());
			byte[] audioByte = new byte[size];
			audioIn.read(audioByte, 0, size);
			return audioByte;
		} catch (IOException e) {
			return null;
		}
	}

}
