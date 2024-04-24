package com.skloch.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

public class LeaderboardScreen implements Screen {

    final HustleGame game;
    private Stage leaderboardStage;
    OrthographicCamera camera;
    private Viewport viewport;
    public Screen previousScreen;

    public LeaderboardScreen(final HustleGame game, Screen previousScreen) {
        this.game = game;
        this.game.leaderboardScreen = this;

        leaderboardStage = new Stage(new FitViewport(game.WIDTH, game.HEIGHT));
        Gdx.input.setInputProcessor(leaderboardStage);

        camera = new OrthographicCamera();
        viewport = new FitViewport(game.WIDTH, game.HEIGHT, camera);
        camera.setToOrtho(false, game.WIDTH, game.HEIGHT);

        // Set the size of the background to the viewport size, only need to do this once, this is then used by all
        // screens as an easy way of having a blue background
        game.blueBackground.getRoot().findActor("blue image").setSize(viewport.getWorldWidth(), viewport.getWorldHeight());

        // Make table to draw leaderboard cells
        Table buttonTable = new Table();
        buttonTable.setFillParent(true);
        leaderboardStage.addActor(buttonTable);

        // Draw leaderboard cells
        int buttonWidth = 200;
        int buttonHeight = 50;
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 3; col++) {
                int buttonIndex = row * 3 + col;
                if (col == 0) {
                    TextButton posButton = new TextButton(String.valueOf(row + 1), game.skin);
                    posButton.setDisabled(true);
                    buttonTable.add(posButton).width(buttonWidth).height(buttonHeight).pad(10);
                }
                else if (col == 1) {
                    TextButton nameButton = new TextButton("Player " + (row + 1), game.skin);
                    nameButton.setDisabled(true);
                    buttonTable.add(nameButton).width(buttonWidth).height(buttonHeight).pad(10);
                    //buttonTable.row();
                }
                else if (col == 2) {
                    TextButton scoreButton = new TextButton(String.valueOf((new Random()).nextInt()), game.skin);
                    scoreButton.setDisabled(true);
                    buttonTable.add(scoreButton).width(buttonWidth).height(buttonHeight).pad(10);
                }
            }
            buttonTable.row();
        }
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
