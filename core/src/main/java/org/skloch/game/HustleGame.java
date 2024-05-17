package main.java.org.skloch.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.Stage;
import org.json.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * A class that is initially created by DesktopLauncher, loads consistent files at the start of the game and initialises lots of important classes.
 * Loads the map, ui skin, text files and makes sound manager and more
 */
public class HustleGame extends Game {
	public SpriteBatch batch;
	public int WIDTH;
	public int HEIGHT;
	public Skin skin;
	public TiledMap map;
	private TiledMap eastMap;
	private TiledMap townMap;
	public String credits, tutorialText;
	public String[][] leaderboard;
	public String leaderboardFile;
	public GameScreen gameScreen;
	public MenuScreen menuScreen;
	public LeaderboardScreen leaderboardScreen;
	public ShapeRenderer shapeRenderer;
	public SoundManager soundManager;
	public Stage blueBackground;
	public int[] backgroundLayers, foregroundLayers, objectLayers;
	public int mapSquareSize;
	public float mapScale;
	public MapProperties mapProperties;
	private MapProperties eastMapProperties;
	private MapProperties townMapProperties;
	private boolean switchToTownMapCalled = false;


	/**
	 * A class to initialise a lot of the assets required for the game, including the map, sound and UI skin.
	 * An instance of this object should be shared to most screens to allow resources to be shared and disposed of
	 * correctly.
	 * Should be created in DesktopLauncher,
	 *
	 * @param width Width of the window
	 * @param height Height of the window
	 */
	public HustleGame (int width, int height) {
		WIDTH = width;
		HEIGHT = height;
	}

	/**
	 * Loads resources used throughout the game.
	 * Creates a new spritebatch
	 * Loads the UI skin to use
	 * Loads the map and configures which layers are background, foreground and object layers
	 * Loads a shape renderer for debug options
	 * Loads a sound manager to play sounds
	 * Loads credit and tutorial texts
	 * Creates a stage with a blue background for screens to use
	 */
	@Override
	public void create () {
		batch = new SpriteBatch();
		skin = new Skin(Gdx.files.internal("Interface/BlockyInterface.json"));
		// Maps
		TmxMapLoader mapLoader = new TmxMapLoader();
		//map = new TmxMapLoader().load("Maps/east_campus.tmx");
		eastMap = mapLoader.load("Maps/east_campus.tmx");
		townMap = mapLoader.load("Maps/Town.tmx");

		eastMapProperties = eastMap.getProperties();
		townMapProperties = townMap.getProperties();

		map = eastMap;
		mapProperties = eastMapProperties;

		// Define background, foreground and object layers
		// IMPORTANT: CHANGE THESE WHEN UPDATING THE LAYERS IN YOUR EXPORTED MAP FROM TILED
		// Bottom most layer on 'layers' tab is 0
		backgroundLayers = new int[] {0, 1, 2, 3, 4, 5, 6}; // Rendered behind player
		foregroundLayers = new int[] {7}; // Rendered in front of player
		objectLayers = new int[] {8}; // Rectangles for the player to collide with
		mapSquareSize = mapProperties.get("tilewidth", Integer.class);
		mapScale = 70f;

		shapeRenderer = new ShapeRenderer();
		soundManager = new SoundManager();

		// Make a stage with a blue background that any screen can draw
		Image blueImage = new Image(new Texture(Gdx.files.internal("Sprites/white_square.png")));
		blueImage.setColor(0.53f, 0.81f, 0.92f, 1);
		blueImage.setName("blue image");
		blueBackground = new Stage();
		blueBackground.addActor(blueImage);

		credits = readTextFile("Text/credits.txt");
		tutorialText = readTextFile("Text/tutorial_text.txt");

		leaderboardFile = "Jsons/leaderboard.json";
		leaderboard = parseLeaderboardJSON(leaderboardFile);

		this.setScreen(new MenuScreen(this));
	}

	public void switchToTownMap() {
		map = townMap;
		mapProperties = townMapProperties;
		switchToTownMapCalled = true;
	}

	public void switchToEastMap() {
		map = eastMap;
		mapProperties = eastMapProperties;
	}

	/**
	 * Very important, renders the game, remove super.render() to get a black screen
	 */
	@Override
	public void render () {
		super.render();
	}

	/**
	 * Disposes of elements that are loaded at the start of the game
	 */
	@Override
	public void dispose () {
		//batch.dispose();
		//blueBackground.dispose();
		//skin.dispose();
		//map.dispose();
		//shapeRenderer.dispose();
		soundManager.dispose();
	}

	/**
	 * Reads and returns text read from the provided text file path
	 * @param filepath The path to the text file
	 * @return The contents of the file as a String
	 */
	public String readTextFile(String filepath) {
		FileHandle file = Gdx.files.internal(filepath);

		if (!file.exists()) {
			System.out.println("WARNING: Couldn't load file " + filepath);
			return "Couldn't load " + filepath;
		} else {
			return file.readString();
		}
	}

	public void writeLeaderboardJSON(String filepath) {
		JSONArray playerArray = new JSONArray();

		for (int i = 0; i < leaderboard.length; i++) {
			if (leaderboard[i] == null) {
				continue;
			}

			JSONObject playerObject = new JSONObject();
			playerObject.put("name", leaderboard[i][0]);
			playerObject.put("score", leaderboard[i][1]);
			playerArray.put(playerObject);
		}

		JSONObject outputObject = new JSONObject();
		outputObject.put("players", playerArray);

		// Create directory where leaderboard will be stored.
		File file = new File(filepath);
		file.getParentFile().mkdirs();

		// Write file
		try (FileWriter writer = new FileWriter(filepath)) {
			writer.write(outputObject.toString());
		} catch (Exception e) {
			System.out.println("Failed to export leaderboard!");
		}
	}

	public String[][] parseLeaderboardJSON(String filepath) {
		ArrayList<String[]> leaderboardData = new ArrayList<>();

		FileHandle file = Gdx.files.internal(filepath);

		if (!file.exists()) {
			System.out.println("WARNING: Couldn't load file " + filepath);
			return new String[0][];
		} else {
			String contents = new String(file.readBytes());
			JSONObject obj = new JSONObject(contents);
			JSONArray players = obj.getJSONArray("players");

			for (int i = 0; i < players.length(); i++) {
				JSONObject playerData = players.getJSONObject(i);
				ArrayList<String> playerDataArray = new ArrayList<>();

				playerDataArray.add(playerData.getString("name"));
				playerDataArray.add(String.valueOf(playerData.getInt("score")));

				leaderboardData.add(playerDataArray.toArray(new String[0]));
			}
		}

		return leaderboardData.toArray(new String[0][]);
	}

	/**
	 * For testing
	 * Checks if map has been switched to town
	 */
	public boolean isSwitchToTownMapCalled() {
		return switchToTownMapCalled;
	}

}
