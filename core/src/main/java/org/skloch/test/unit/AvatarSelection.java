package main.java.org.skloch.test.unit;

/**
 * A class to declare which avatar has been selected
 * Used to test the avatar selection option
 */
public class AvatarSelection {
    private int selectedAvatar;

    public AvatarSelection() {
        this.selectedAvatar = 0;
    }

    public void selectAvatar(int avatarChoice) {
        if (avatarChoice !=1 && avatarChoice != 2) {
            throw new IllegalArgumentException("Invalid avatar choice");
        }
        this.selectedAvatar = avatarChoice;
    }

    public int getSelectedAvatar() {
        return selectedAvatar;
    }

}

