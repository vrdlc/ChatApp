package delacruz.chatapp.Models;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Ramon on 7/28/16.
 */
public class Message {
    private String id;
    private String convoId;
    private String messageContent;
    private String senderName;
    private ArrayList<User> receiverName;
    private Date postDate;

    public Message() {}

    public Message(String id, String convoId, String messageContent, String senderName, ArrayList<User> receiverName, Date postDate) {
        this.id = id;
        this.convoId = convoId;
        this.messageContent = messageContent;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.postDate = postDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConvoId() {
        return convoId;
    }

    public void setConvoId(String convoId) {
        this.convoId = convoId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public ArrayList<User> getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(ArrayList<User> receiverName) {
        this.receiverName = receiverName;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

}
