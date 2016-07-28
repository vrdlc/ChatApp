package delacruz.chatapp.Models;

import lombok.Getter;
import lombok.Setter;

/**
* Model that stores User info, like usernames and passwords
 */
public class User {

    @Getter @Setter private String userName;

    @Getter @Setter private String useremail;

    public User() {}

    public User(String userName, String useremail) {
        this.userName = userName;
        this.useremail = useremail;
    }
}
