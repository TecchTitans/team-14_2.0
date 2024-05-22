import main.java.org.skloch.game.DialogueBox;
import main.java.org.skloch.game.GameScreen;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

// integration test

public class DialogueBoxTest {
    private GameScreen gameScreen;
    private DialogueBox dialogueBox;

    @Before
    public void setUp(){
        gameScreen = mock(GameScreen.class);
        dialogueBox = mock(DialogueBox.class);
        gameScreen.dialogueBox = dialogueBox;

        when(gameScreen.getDialogueBox()).thenReturn(dialogueBox);
    }

    @Test
    public void testDialogueBoxSetText() {
        String text = "This is a unit test message";
        gameScreen.getDialogueBox().setText(text);
        verify(dialogueBox).setText(text);
    }

}