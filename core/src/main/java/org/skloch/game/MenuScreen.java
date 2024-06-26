package main.java.org.skloch.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * A screen to display the game menu to the player has the buttons "Start", "Settings", "Leaderboard", "Credits, "Exit"
 * Also displays a tutorial window and an avatar select screen
 */
public class MenuScreen implements Screen {
    final HustleGame game;
    private final Stage menuStage;
    OrthographicCamera camera;
    private final Viewport viewport;
    private final Image titleImage;

    // MODIFIED: Added leaderboard button to menu
    /**
     * A class to display a menu screen, initially gives the player 4 options, Start, Settings, Credits, Quit
     * Upon hitting start, a tutorial window is shown, and then an avatar select screen is shown, and then it is
     * switched to GameScreen.
     * Settings switches to SettingsScreen
     * Credits switches to CreditsScreen
     * Quit exits the game
     *
     * @param game An instance of HustleGame with loaded variables
     */
    public MenuScreen(final HustleGame game) {
        this.game = game;
        this.game.menuScreen = this;
        // Create stage to draw UI on
        menuStage = new Stage(new FitViewport(game.WIDTH, game.HEIGHT));
        Gdx.input.setInputProcessor(menuStage);

        camera = new OrthographicCamera();
        viewport = new FitViewport(game.WIDTH, game.HEIGHT, camera);
        camera.setToOrtho(false, game.WIDTH, game.HEIGHT);

        // Set the size of the background to the viewport size, only need to do this once, this is then used by all
        // screens as an easy way of having a blue background
        game.blueBackground.getRoot().findActor("blue image").setSize(viewport.getWorldWidth(), viewport.getWorldHeight());

        // Title image
        titleImage = new Image(new Texture(Gdx.files.internal("title.png")));
        titleImage.setPosition((viewport.getWorldWidth() / 2f) - (titleImage.getWidth() / 2f), viewport.getWorldHeight() * 0.75f);
        menuStage.addActor(titleImage);

        // Play menu music
        game.soundManager.playMenuMusic();


        // Make avatar select table
        Table avatarSelectTable = makeAvatarSelectTable();
        menuStage.addActor(avatarSelectTable);
        avatarSelectTable.setVisible(false);


        // Make tutorial window
        Window tutorialWindow = makeTutorialWindow(avatarSelectTable);
        menuStage.addActor(tutorialWindow);
        tutorialWindow.setVisible(false);


        // Make table to draw buttons and title
        Table buttonTable = new Table();
        buttonTable.setFillParent(true);
        menuStage.addActor(buttonTable);


        // Create the buttons
//        Label title = new Label("Heslington Hustle", game.skin, "title"); // Old title, new uses a texture
        TextButton startButton = new TextButton("New Game", game.skin);
        TextButton settingsButton = new TextButton("Settings", game.skin);
        TextButton leaderboardButton = new TextButton("Leaderboard", game.skin);
        TextButton creditsButton = new TextButton("Credits", game.skin);
        TextButton exitButton = new TextButton("Exit", game.skin);

        // Add everything to the table using row() to go to a new line
        int buttonWidth = 340;
        buttonTable.add(startButton).uniformX().width(buttonWidth).padBottom(10).padTop(220);
        buttonTable.row();
        buttonTable.add(settingsButton).uniformX().width(buttonWidth).padBottom(10);
        buttonTable.row();
        buttonTable.add(leaderboardButton).uniformX().width(buttonWidth).padBottom(10);
        buttonTable.row();
        buttonTable.add(creditsButton).uniformX().width(buttonWidth).padBottom(30);
        buttonTable.row();
        buttonTable.add(exitButton).uniformX().width(buttonWidth);
        buttonTable.top();

        // Add listeners to the buttons so they do things when pressed

        // START GAME BUTTON - Displays the tutorial window
        ChangeListener c1;
        c1 = new ChangeListener() {
            @Override
            @ExcludeFromJacocoGeneratedReport
            public void changed(ChangeEvent event, Actor actor) {
                game.soundManager.playButton();
                buttonTable.setVisible(false);
                titleImage.setVisible(false);
                tutorialWindow.setVisible(true);

//                dispose();
//                game.setScreen(new GameScreen(game));
            }
        };
        startButton.addListener(c1);

        // SETTINGS BUTTON
        Screen thisScreen = this;
        settingsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.soundManager.playButton();
                game.setScreen(new SettingsScreen(game, thisScreen));
            }
        });

        // LEADERBOARD BUTTON
        leaderboardButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.soundManager.playButton();
                game.setScreen(new LeaderboardScreen(game, thisScreen));
            }
        });

        // CREDITS BUTTON
        creditsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.soundManager.playButton();
                game.setScreen(new CreditScreen(game, thisScreen));
            }
        });

        // EXIT BUTTON
        exitButton.addListener(new ChangeListener() {
               @Override
               public void changed(ChangeEvent event, Actor actor) {
                   game.soundManager.playButton();
                   game.dispose();
                   dispose();
                   Gdx.app.exit();
               }
           }
        );

        game.batch.setProjectionMatrix(camera.combined);

    }

    /**
     * Renders the main menu, and any windows that are displaying information
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        game.blueBackground.draw();

        // Make the stage follow actions and draw itself
        menuStage.setViewport(viewport);
        menuStage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        menuStage.draw();

    }

    /**
     * Correctly resizes the menu screen
     * @param width
     * @param height
     */
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        menuStage.getViewport().update(width, height);
    }

    // Other required methods
    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    /**
     * Correctly sizes the game when resuming it after a pause or switching screens
     * Fixes a small graphical bug
     */
    @Override
    public void resume() {
        Gdx.input.setInputProcessor(menuStage);

        // See the comment in the resume() function in GameScreen to see why this pointless line exists
        Gdx.input.setCursorPosition(Gdx.input.getX(), Gdx.input.getY());
    }

    /**
     * Dispose of all menu assets
     */
    @Override
    public void dispose() {
        menuStage.dispose();
    }

    /**
     * Generates a window to teach the player how to play the game
     * Displays the tutorial text shown in Text/tutorial_text.txt
     *
     * @return A small window to explain the game
     */
    public Window makeTutorialWindow(Table nextTable) {
        Window tutWindow = new Window("", game.skin);
        Table tutTable = new Table();
        tutWindow.add(tutTable).prefHeight(600).prefWidth(800-20);

        // Title
        Label title = new Label("How to play", game.skin, "button");
        tutTable.add(title).padTop(10);
        tutTable.row();

        // Table for things inside the scrollable widget
        Table scrollTable = new Table();

        // Scrollable widget
        ScrollPane scrollWindow = new ScrollPane(scrollTable, game.skin);
        scrollWindow.setFadeScrollBars(false);

        tutTable.add(scrollWindow).padTop(20).height(350).width(870);
        tutTable.row();

        Label text = new Label(game.tutorialText, game.skin, "interaction");
        text.setWrap(true);
        scrollTable.add(text).width(820f).padLeft(20);

        // Exit button
        TextButton continueButton = new TextButton("Continue", game.skin);
        tutTable.add(continueButton).bottom().width(300).padTop(10);

        tutWindow.pack();

        tutWindow.setSize(900, 600);

        // Centre the window
        tutWindow.setX((viewport.getWorldWidth() / 2) - (tutWindow.getWidth() / 2));
        tutWindow.setY((viewport.getWorldHeight() / 2) - (tutWindow.getHeight() / 2));



        continueButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.soundManager.playButton();
                tutWindow.setVisible(false);
                nextTable.setVisible(true);
            }
        });



        return tutWindow;
    }


    // MODIFIED FROM ORIGINAL: Selection now also has a name field for use in leaderboard
    /**
     * Creates an avatar selection screen, consisting of a label and two buttons
     *
     * @return A table containing UI elements
     */
    public Table makeAvatarSelectTable () {
        Table table = new Table();
        table.setFillParent(true);
        table.top();

        // Prompt
        Label title = new Label("Select your avatar", game.skin, "button");
        table.add(title).padBottom(120).padTop(80);
        table.row();

        // Image buttons
        Table buttonTable = new Table();
        table.add(buttonTable).width(600);

        ImageButton choice1 = new ImageButton(game.skin, "avatar1");
        choice1.setDisabled(true);
        buttonTable.add(choice1).left().expandX();
        ImageButton choice2 = new ImageButton(game.skin, "avatar2");
        choice2.setDisabled(true);
        buttonTable.add(choice2).right().expandX();

        // Name input field
        buttonTable.row();
        TextField nameField = new TextField("", game.skin);
        nameField.setMessageText("ENTER YOUR NAME HERE");
        nameField.setAlignment(Align.center);
        nameField.setMaxLength(12);
        buttonTable.add(nameField).colspan(2).padTop(10).width(600).height(100).center();

        // Choice buttons are disabled when the name field is empty. This makes the user enter a name.
        nameField.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                choice1.setDisabled(nameField.getText().isEmpty());
                choice2.setDisabled(nameField.getText().isEmpty());
            }
        });

        choice1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.soundManager.playButton();
                String name = nameField.getText();
                game.setScreen(new GameScreen(game, 1, name));
                game.soundManager.stopMenuMusic();
                dispose();
            }
        });

        choice2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.soundManager.playButton();
                String name = nameField.getText();
                game.setScreen(new GameScreen(game, 2, name));
                game.soundManager.stopMenuMusic();
                dispose();
            }
        });

        return table;
    }

}
