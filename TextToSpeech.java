import com.sun.speech.freetts.Gender;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class TextToSpeech implements ActionListener{
    JFrame myframe;
    JTextField textField = new JTextField();
    JButton speech = new JButton("Speak");
    JButton reset = new JButton("Reset");

    TextToSpeech() {
        prepareGUI();
        addComponents();
        addActionEvents();
    }

    public void prepareGUI() {
        myframe = new JFrame();
        myframe.setTitle("Text to Speech Project");
        myframe.setLayout(null);
        myframe.getContentPane().setBackground(Color.darkGray);
        myframe.setSize(500,500);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setVisible(true);
    }

    public void addComponents() {
        textField.setBounds(90,150, 300, 40);
        textField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        textField.setBackground(Color.red);
        textField.setForeground(Color.white);
        myframe.add(textField);

        speech.setBounds(70,250, 150, 50);
        speech.setBackground(Color.yellow);
        speech.setForeground(Color.black);
        speech.setFont(new Font("Times New Roman", Font.BOLD, 15));
        myframe.add(speech);

        reset.setBounds(270,250, 150, 50);
        reset.setBackground(Color.yellow);
        reset.setForeground(Color.black);
        reset.setFont(new Font("Arial", Font.BOLD, 15));
        myframe.add(reset);
    }

    public void addActionEvents() {
        speech.addActionListener(this);
        reset.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reset) {
            textField.setText("");
        }
        if (e.getSource() == speech) {
            Voice voice= VoiceManager.getInstance().getVoice("kevin");
           
            if (voice != null) {
                voice.allocate();
            }
            try {
                voice.setRate(170);
                voice.setPitch(100);
                voice.setVolume(10);
                voice.speak(textField.getText());
            } 
            catch (Exception f) {
                f.printStackTrace();
            }

        }

    }
}
