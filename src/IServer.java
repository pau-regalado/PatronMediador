import javax.swing.*;

public interface IServer {
    public void sendMessage(String message, User emitter, JTextArea result);
    //public void sendMessage(String message, User emitter, User receiver);
}
