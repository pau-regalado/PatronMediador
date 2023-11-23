import javax.swing.*;

public abstract class User {
    public String name;
    private IServer server;
    public User(IServer server) {
        this.server = server;
    }



    public IServer getServer()  { return this.server; }
    public void setServer(IServer s)  { this.server = s; }

    public void comunicate(String message, JTextArea result)  { server.sendMessage(message, this, result); }

    public abstract void receiveMessage(String receiver, String message, JTextArea result);
    //public abstract void receiveMessage(String message, User receiver);

}
