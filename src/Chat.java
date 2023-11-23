

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Chat extends JFrame {

    private ArrayList<UserConcrete> users = new ArrayList<>();
    private ArrayList<JButton> buttonsUser = new ArrayList<>();

    public Chat() {
        setTitle("Choose one user");
        setLocation(950, 300);
        setLayout(null);
        setSize(250, 300);

        JButton addUserButton = new JButton("Agregar Usuario");
        addUserButton.setBounds(15, 10, 150, 30);
        addUserButton.setBackground(Color.ORANGE);
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });
        add(addUserButton);

        setVisible(true);
    }

    private void addUser() {
        String nameUser = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
        if (nameUser != null && !nameUser.trim().isEmpty()) {
            IServer server = null;
            UserConcrete user = new UserConcrete(server);
            users.add(user);

            JButton buttonUser = new JButton(nameUser);
            buttonUser.setBounds(15, 50 + 40 * buttonsUser.size(), 150, 30);
            buttonUser.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showUserWindowEmitter(nameUser);
                    showUserWindowReceiver(nameUser);

                }
            });

            buttonsUser.add(buttonUser);
            add(buttonUser);
            repaint();
        }
    }


    private void showUserWindowEmitter(String nameUser) {
        JFrame userFrame = new JFrame(nameUser);
        userFrame.setSize(400, 300);

        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        userPanel.setBackground(Color.PINK);

        // Añadir un JTextArea para la opción de escribir
        JTextArea writeTextArea = new JTextArea(10, 30); // 5 filas, 30 columnas
        JScrollPane scrollPane = new JScrollPane(writeTextArea);
        userPanel.add(scrollPane);

        // Añadir un nuevo JTextArea
        JTextArea additionalTextArea = new JTextArea(2, 30);
        JScrollPane additionalScrollPane = new JScrollPane(additionalTextArea);
        userPanel.add(additionalScrollPane);

        JButton send = new JButton("Send");
        send.setBackground(new Color(190, 218, 252));
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField message = new JTextField();
                message.setVisible(true);
                message.setColumns(100);
                message.setBounds(40, 400, 400, 50);
                userPanel.add(message);

                // Código para enviar el mensaje
                // sender.sendMessage(userFinal, message.getText(), result);
                // message.setText(null);
            }
        });

        // Añadir el botón al panel
        userPanel.add(send);

        userFrame.add(userPanel);
        userFrame.setVisible(true);
    }



    private void showUserWindowReceiver(String nameUser) {
        JFrame userFrame = new JFrame(nameUser);
        userFrame.setSize(400, 300);

        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        userPanel.setBackground(Color.PINK);
        userPanel.setBounds(205, 250 , 150, 30);

        // Añadir un JTextArea para la opción de escribir
        JTextArea writeTextArea = new JTextArea(5, 30); // 5 filas, 30 columnas
        JScrollPane scrollPane = new JScrollPane(writeTextArea);
        userPanel.add(scrollPane);

        JButton send = new JButton("Send Ramdom Message");
        send.setBackground(new Color(190, 218, 252));
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //nameUser.sendMessage(userFinal, message.getText(), result);
                // message.setText(null);
            }
        });

        // Añadir el botón al panel
        userPanel.add(send);

        userFrame.add(userPanel);
        userFrame.setVisible(true);
    }

}
