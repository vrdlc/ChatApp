package delacruz.chatapp.Models;

import java.util.ArrayList;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Model that stores Message information, like sender, recipient, and content
 */
public class Message {
    @Getter @Setter private String id;
    @Getter @Setter private String convoId;
    @Getter @Setter private String messageContent;
    @Getter @Setter private String senderName;
    @Getter @Setter private ArrayList<User> receiverName;
    @Getter @Setter private Date postDate;

    public Message() {}

    public Message(String id, String convoId, String messageContent, String senderName, ArrayList<User> receiverName, Date postDate) {
        this.id = id;
        this.convoId = convoId;
        this.messageContent = messageContent;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.postDate = postDate;
    }
}
