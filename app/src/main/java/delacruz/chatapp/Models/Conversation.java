package delacruz.chatapp.Models;

import java.util.ArrayList;

/**
 * Created by Ramon on 7/28/16.
 */
public class Conversation {

    private String id;
    private ArrayList<User> users;
    private ArrayList<Message> convoMessages;

    public Conversation() {}


    public Conversation(String id, ArrayList<User> users, ArrayList<Message> convoMessages) {
        this.id = id;
        this.users= users;
        this.convoMessages = convoMessages;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Message> getConvoMessages() {
        return convoMessages;
    }

    public void setConvoMessages(ArrayList<Message> convoMessages) {
        this.convoMessages = convoMessages;
    }
}
