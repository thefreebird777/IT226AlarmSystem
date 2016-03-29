import org.w3c.dom.Node;

import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AlarmBase {
    Main mainObject = new Main();
    public static Node node;
    public static int alarmDay;
    public static int alarmMonth;
    public static int alarmHour;
    public static int alarmMinute;
    public static String alarmMessage;
    public static int alarmDate;
    public static Sound sound = new Sound();

    //date alarm
    public AlarmBase(Node node, int alarmH, int alarmM, String alarmMessage, int alarmDay, int alarmMonth) {
        super();
        setNode(node);
        setDateAlarmHour(alarmH);
        setDateAlarmMinute(alarmM);
        setAlarmMessage(alarmMessage);
        setAlarmDay(alarmDay);
        setAlarmMonth(alarmMonth);
    }

    //countdown alarm
    public AlarmBase(int alarmH, int alarmM, String alarmMessage) {
        super();
        setTimerAlarmHour(alarmH);
        setTimerAlarmMinute(alarmM);
        setAlarmMessage(alarmMessage);
    }


    public static void main(String args[]) {
        Calendar c = new GregorianCalendar();

    }

    public static AlarmBase createTimer(int hour, int minute, String message) {
        AlarmBase alarm2 = new AlarmBase(hour, minute, alarmMessage);
        alarm2.checkAlarm(hour, minute, message);
        return alarm2;
    }

    public static AlarmBase createTimer(int hour, int minute, String message, int day, int month) {
        AlarmBase alarm2 = new AlarmBase(node, hour, minute, alarmMessage, day, month);
        alarm2.checkAlarm(hour, minute, message, month, day);
        return alarm2;
    }

    public void checkAlarm(final int hr, final int min, final String message) {
        Thread t = new Thread() {

            public void run() {
                int checkingTime = 0;
                while (checkingTime == 0) {
                    Calendar c = new GregorianCalendar();
                    int hours = c.get(Calendar.HOUR) + 12;
                    int mins = c.get(Calendar.MINUTE);
                    if (hr < hours || (hr == hours && min <= mins)) {
                        if (message.equals("")) {
                            sound.makeSound();
                            JOptionPane.showMessageDialog(null, "Time is UP!");
                            sound.stop();
                            mainObject.deletion(getNode());
                            break;
                        } else {
                            sound.makeSound();
                            JOptionPane.showMessageDialog(null, message);
                            sound.stop();
                            mainObject.deletion(getNode());
                            break;
                        }
                    }
                }
            }
        };
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
        
    }

    public void checkAlarm(final int hr, final int min, final String message, final int mnth, final int dy) {
        Thread t = new Thread() {

            public void run() {
                int checkingTime = 0;
                while (checkingTime == 0) {
                    Calendar c = new GregorianCalendar();
                    int hours = c.get(Calendar.HOUR) + 12;
                    int mins = c.get(Calendar.MINUTE);
                    int month = c.get(Calendar.MONTH) + 1;
                    int day = c.get(Calendar.DAY_OF_MONTH);
                    if (mnth < month || (mnth == month && dy <= day)) {
                        if (hr < hours || (hr == hours && min <= mins)) {
                            if (message.equals("")) {
                                sound.makeSound();
                                JOptionPane.showMessageDialog(null, "Time is UP!");
                                sound.stop();
                                mainObject.deletion(getNode());
                                break;
                            } else {
                                sound.makeSound();
                                JOptionPane.showMessageDialog(null, message);
                                sound.stop();
                                mainObject.deletion(getNode());
                                break;
                            }
                        }
                    }
                }
            }
        };
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
    }

    public void setDateAlarmHour(int alarmH) {
        if ((alarmH >= 0) && (alarmH <= 24))
            this.alarmHour = 8;
        else
            System.out.println("invalid alarm hour");
    }

    public int getDateAlarmHour() {
        return alarmHour;
    }

    public void setTimerAlarmHour(int alarmH) {
        Calendar c = new GregorianCalendar();
        int hours = c.get(Calendar.HOUR);
        if ((alarmH >= 0) && (alarmH <= 24))
            this.alarmHour = alarmH + hours;
        else
            System.out.println("invalid alarm hour");
    }

    public void setDateAlarmMinute(int alarmH) {
        if ((alarmH >= 0) && (alarmH <= 24))
            this.alarmHour = alarmH;
        else
            System.out.println("invalid alarm hour");
    }

    public void setTimerAlarmMinute(int alarmM) {
        Calendar c = new GregorianCalendar();
        int mins = c.get(Calendar.MINUTE);
        if ((alarmM >= 0) && (alarmM <= 59))
            this.alarmMinute = alarmM + mins;
        else
            System.out.println("invalid alarm minute");
    }

    public void setAlarmMessage(String alarmMessage) {
        this.alarmMessage = alarmMessage;
    }

    public void setAlarmMonth(int alarmMonth) {
        Calendar c = new GregorianCalendar();
        int fireMonth = c.get(Calendar.MONTH);
        //month must be greater than 1
        if ((alarmMonth >= 0) && (alarmMonth <= 12))
            this.alarmMonth += (fireMonth + 1);
        else
            System.out.println("invalid alarm month");
    }

    public void setAlarmDay(int alarmDay) {
        Calendar c = new GregorianCalendar();
        int day = c.get(Calendar.DAY_OF_MONTH);
        if ((alarmDay >= 0) && (alarmDay <= 31))
            this.alarmDay = alarmDay + day;
        else
            System.out.println("invalid alarm day");
    }

    public static void setNode(Node node) {
        AlarmBase.node = node;
    }

    public static Node getNode() {
        return node;
    }
}