package it226;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class AlarmClock extends javax.swing.JFrame {

    /**
     * Creates new form AlarmClock
     */
    public AlarmClock() {
        initComponents();
    }
    String message="";
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hourField = new javax.swing.JTextField();
        minuteField = new javax.swing.JTextField();
        submitBut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageText = new javax.swing.JTextArea();
        hourLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dayField = new javax.swing.JTextField();
        monthField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        hourField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        hourField.setToolTipText("Hours");

        minuteField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        minuteField.setToolTipText("minutes");

        submitBut.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        submitBut.setText("Submit");
        submitBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Current Time:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Time of alarm:");

        messageText.setColumns(20);
        messageText.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        messageText.setRows(5);
        messageText.setText("Enter message Here:");
        messageText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageTextMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(messageText);

        hourLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        hourLabel.setText("HH:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Current Date:");

        dateLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        dateLabel.setText("HH:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Date of alarm:");

        dayField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        dayField.setToolTipText("days");

        monthField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        monthField.setToolTipText("months");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(hourField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel1)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(hourLabel))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(monthField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel3)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(dateLabel))
                                                                        .addComponent(minuteField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(dayField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 187, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(129, 129, 129)
                                                .addComponent(submitBut, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(hourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(hourField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minuteField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(monthField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dayField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(submitBut, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButActionPerformed

        if(this.hourField.getText().equals("")||this.minuteField.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Error: Invalid Field");
            this.dispose();
            return;
        }
        int hour= Integer.parseInt(this.hourField.getText());
        int minute= Integer.parseInt(this.minuteField.getText());
        int month= Integer.parseInt(this.monthField.getText());
        int day= Integer.parseInt(this.dayField.getText());
        Calendar temp = new GregorianCalendar(2016, month, day);
        int monthLength=temp.getActualMaximum(Calendar.DAY_OF_MONTH);
        if(hour<0){
            JOptionPane.showMessageDialog(this, "Error: Hour times can only\n be positive");
            return;
        }
        if(hour>=24){
            JOptionPane.showMessageDialog(this, "Error: For timers 24 hours or longer \n please use an alarm clock");
            return;
        }
        if(minute>59||minute<0){
            JOptionPane.showMessageDialog(this, "Error: Minute times can only\n be between 0-59");
            return;
        }
        if(month<1||month>=12){
            JOptionPane.showMessageDialog(this, "Error: Months can only\n be between 1-12");
            return;
        }
        if(day>monthLength||day<0){
            JOptionPane.showMessageDialog(this, "Error: Invalid day of month");
            return;
        }
        JOptionPane.showMessageDialog(this, "Timer Set!");
        if(this.messageText.getText().equals("Enter message Here:")){
            this.messageText.setText("");
        }
        else{
            message=messageText.getText();
        }

        AlarmBase timer= AlarmBase.createTimer(hour,minute,message,day,month);

        this.dispose();
    }//GEN-LAST:event_submitButActionPerformed

    private void messageTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageTextMouseClicked
        if(this.messageText.getText().equals("Enter message Here:")){
            this.messageText.setText("");
        }
    }//GEN-LAST:event_messageTextMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Calendar c = new GregorianCalendar();
        int hours=0;
        if(c.get(Calendar.AM_PM)==1){
            hours = c.get(Calendar.HOUR)+12;
        }
        else{
            hours=c.get(Calendar.HOUR);
        }
        int mins = c.get(Calendar.MINUTE);
        if(mins<10){
            this.hourLabel.setText(hours+":0"+mins);
        }
        else{
            this.hourLabel.setText(hours+":"+mins);
        }
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH)+1;
        int year = c.get(Calendar.YEAR);
        this.dateLabel.setText(month+"/"+day+"/"+year);
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlarmClock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlarmClock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlarmClock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlarmClock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlarmClock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dayField;
    private javax.swing.JTextField hourField;
    private javax.swing.JLabel hourLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea messageText;
    private javax.swing.JTextField minuteField;
    private javax.swing.JTextField monthField;
    private javax.swing.JButton submitBut;
    // End of variables declaration//GEN-END:variables
}