package delacruz.chatapp.Models;

/**
 * Created by Ramon on 7/28/16.
 */
public class User {

    private String userName;

    private String useremail;

    public User() {}

    public User(String userName, String useremail) {
        this.userName = userName;
        this.useremail= useremail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }


}
