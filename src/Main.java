import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("APP");
        ventana.setBounds(700, 200,300, 150);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.PINK);

        JButton chat = new JButton("Chat");
        JButton group = new JButton("Grupo");
        chat.setBackground(Color.ORANGE);
        group.setBackground(Color.ORANGE);

        panel.add(chat);
        panel.add(group);

        ventana.add(panel);
        ventana.setVisible(true);

        chat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Chat chat1 = new Chat(); }
        });
        panel.add(chat);

        group.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Group group = new Group();
            }
        });
    }


}
