package delacruz.chatapp.Models;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Model that stores Conversation info, including users and messages in the conversation
 */
public class Conversation {

    @Getter @Setter private String id;
    @Getter @Setter private ArrayList<User> users;
    @Getter @Setter private ArrayList<Message> convoMessages;

    public Conversation() {}


    public Conversation(String id, ArrayList<User> users, ArrayList<Message> convoMessages) {
        this.id = id;
        this.users= users;
        this.convoMessages = convoMessages;
    }
}
