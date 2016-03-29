package it226;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
 
public class Sound extends JFrame implements ActionListener {
 
    JButton btn, btn2;
    public static AudioClip click;
 
    public Sound() {
        setSize(400, 300);
        btn = new JButton("Play");
        btn2 = new JButton("Stop");
        setTitle("Play Alarm");
        setLayout(new FlowLayout());
        getContentPane().add(btn);
        getContentPane().add(btn2);
 
        btn.addActionListener(Sound.this);
        btn2.addActionListener(Sound.this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            URL urlClick = Sound.class.getResource("Alarm01.wav");
            click = Applet.newAudioClip(urlClick);
            click.loop();
        }
 
        if (e.getSource() == btn2) {
            
        }
    }
    public void makeSound(){
         URL urlClick = Sound.class.getResource("Alarm01.wav");
         click = Applet.newAudioClip(urlClick);
         click.loop();
    }
    public void stop(){
       click.stop(); 
    }
    
    public static void main(String[] args) {
       
    }
}