package nitishprasad.anugrahacomputersinternship;

import java.io.Serializable;

public class ProfileModel implements Serializable{

    String userName;
    int userImage;
    String description;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
