import javax.swing.*;
import java.util.ArrayList;

public class Server implements IServer {
    private ArrayList<User> users;

    public Server() { this.users = new ArrayList<User>(); }

    /*public void sendMessage(String message, User emitter, User receiver) {
        if(users.contains(receiver)) {
            receiver.receiveMessage(message);
        }
    }
     */
    @Override
    public void sendMessage(String message, User emitter, JTextArea result) {
        for(User user : users) {
            if(user != emitter) {
                user.receiveMessage(message, emitter.toString(), result);
            }
        }
    }
}
