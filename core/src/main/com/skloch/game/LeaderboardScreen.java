package main.com.skloch.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

/**
 * A screen to display a leaderboard showing the top 10 players.
 */
public class LeaderboardScreen implements Screen {
    final HustleGame game;
    private Stage leaderboardStage;
    OrthographicCamera camera;
    private Viewport viewport;

    public LeaderboardScreen(final HustleGame game, Screen previousScreen) {
        this.game = game;
        this.game.leaderboardScreen = this;

        leaderboardStage = new Stage(new FitViewport(game.WIDTH, game.HEIGHT));
        Gdx.input.setInputProcessor(leaderboardStage);

        camera = new OrthographicCamera();
        viewport = new FitViewport(game.WIDTH, game.HEIGHT, camera);
        camera.setToOrtho(false, game.WIDTH, game.HEIGHT);

        // Create the window
        Window leaderboardMenu = new Window("", game.skin);
        leaderboardStage.addActor(leaderboardMenu);

        // Table for UI elements in window
        Table leaderboardTable = new Table();
        leaderboardMenu.add(leaderboardTable).prefHeight(600);

        // Table for things inside the scrollable widget
        Table scrollTable = new Table();

        // Scrollable widget
        ScrollPane scrollWindow = new ScrollPane(scrollTable, game.skin);
        scrollWindow.setFadeScrollBars(false);

        // Add elements to show the players and their score ordered from first to last.
        // There are 3 columns and 10 rows.
        int numRows  = game.leaderboard.length;
        int numColumns = 3;
        int padding = 10;
        for (int i = 0; i < numRows * numColumns; i++) {
            int row = i / numColumns;
            int col = i % numColumns;

            if (game.leaderboard[row] == null) {
                continue;
            }

            TextButton currentCell;
            switch (col) {
                // Position field
                case 0:
                {
                    currentCell = new TextButton(String.valueOf(row + 1), game.skin);
                    currentCell.align(Align.center);
                    currentCell.setDisabled(true);
                    scrollTable.add(currentCell).width(100f).pad(padding);
                    break;
                }
                // Name field
                case 1:
                {
                    currentCell = new TextButton(game.leaderboard[row][0], game.skin);
                    currentCell.align(Align.center);
                    currentCell.setDisabled(true);
                    scrollTable.add(currentCell).width(600f).pad(padding);
                    break;
                }
                // Score field
                case 2:
                {
                    currentCell = new TextButton(game.leaderboard[row][1], game.skin);
                    currentCell.align(Align.center);
                    currentCell.setDisabled(true);
                    scrollTable.add(currentCell).width(300f).pad(padding);
                    break;
                }
            }

            // All columns have been created for that row so start a new row.
            if ((col + 1) == numColumns) {
                scrollTable.row();
            }
        }

        leaderboardTable.add(scrollWindow).height(350).width(
                scrollTable.getPrefWidth() +
                padding * numColumns +
                scrollWindow.getScrollBarWidth()
        );
        leaderboardTable.row();

        // Exit button
        TextButton exitButton = new TextButton("Exit", game.skin);
        leaderboardTable.add(exitButton).width(300).padLeft(15).padTop(15);

        leaderboardMenu.pack();

        leaderboardMenu.setSize(1200, 600);

        // Centre the window
        leaderboardMenu.setX((viewport.getWorldWidth() / 2) - (leaderboardMenu.getWidth() / 2));
        leaderboardMenu.setY((viewport.getWorldHeight() / 2) - (leaderboardMenu.getHeight() / 2));

        // Listener for exit button
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                game.soundManager.playButton();
                dispose();
                game.setScreen(previousScreen);
                previousScreen.resume();
            }
        });
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw blue background
        game.blueBackground.draw();

        leaderboardStage.act(delta);
        leaderboardStage.draw();

        // Volumes should be between 0 and 1
        //game.soundManager.setMusicVolume(musicSlider.getValue() / 100);
        //game.soundManager.setSfxVolume(sfxSlider.getValue() / 100);

        camera.update();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
