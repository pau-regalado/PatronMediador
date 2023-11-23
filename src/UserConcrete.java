import javax.swing.*;

public class UserConcrete extends User {


    public UserConcrete(IServer server) {
        super(server);

    }

    @Override
    public void receiveMessage(String receiver, String message, JTextArea result) {
        result.setText(result.getText() + "\n    " + receiver + " says: \"" + message + "\" . Received by: -- " + this);
    }
}
