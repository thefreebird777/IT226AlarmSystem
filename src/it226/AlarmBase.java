package it226;

import org.w3c.dom.Node;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class AlarmBase {

	Main main = new Main();
	public static  Node node;
    public static int alarmDay;
    public static int alarmMonth;
    public static int alarmHour;
    public static int alarmMinute;
    public static String alarmMessage;
    public static int alarmDate;
	
    
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
	    	
//	    if(date alarm button is clicked) {
		//it226.AlarmBase alarm = new it226.AlarmBase(alarmHour, alarmMinute, alarmMessage, alarmDay, alarmMonth);
//		if(alarm.alarmDay == 0 && alarm.alarmDay == 0) {
//			
//		}
		//hour minute is entered
		//System.out.println(alarm.getDateAlarmHour() + ": " + alarm.alarmMinute);
		//current month and day
		//System.out.println(alarm.alarmMonth + " / " + alarm.alarmDay);


//			alarm.checkAlarm(alarmHour,alarmMinute);
//	    }
//	    if(countdown alarm button is clicked) {
		//	it226.AlarmBase alarm2 = new it226.AlarmBase(alarmDate, alarmDate, alarmMessage);
			//firetime of alarm
			//System.out.println(alarm2.alarmHour + ": " + alarm2.alarmMinute);
			//alarm2.checkAlarm(alarmHour,alarmMinute);
//	    }
		
	}
	public static AlarmBase createTimer(int hour, int minute,String message){
            AlarmBase alarm2 = new AlarmBase(hour, minute, alarmMessage);
			//firetime of alarm
			System.out.println(hour + ": " + minute);
			alarm2.checkAlarm(hour,minute,message);
                        return alarm2;
        }
        
	public void checkAlarm(final int hr, final int min, final String message) {
		Thread t = new Thread() {
			
			public void run() {
				int checkingTime = 0;
				while(checkingTime == 0) {
					Calendar c = new GregorianCalendar();
					int hours = c.get(Calendar.HOUR);
					int mins = c.get(Calendar.MINUTE);
					if(hr <= hours && min <= mins) {
                                            if(message.equals("")){
						JOptionPane.showMessageDialog(null, "Time is UP!");
						break;
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null, message);
						break;
                                            }
					}
				}
			}
		};
		t.setPriority(Thread.MIN_PRIORITY);
		t.start();
		main.deletion(getNode());
	}
	
	   public void setDateAlarmHour(int alarmH)
	   {
	           if((alarmH >= 0) && (alarmH <= 24))
	                   this.alarmHour = 8;
	           else
	            System.out.println("invalid alarm hour");
	   }
	   public int getDateAlarmHour() {
		   return alarmHour;
	   }
	   public void setTimerAlarmHour(int alarmH)
	   {
		   Calendar c = new GregorianCalendar();
		   int hours = c.get(Calendar.HOUR);
           if((alarmH >= 0) && (alarmH <= 24))
                   this.alarmHour = alarmH + hours;
           else
            System.out.println("invalid alarm hour");
	   }
	   public void setDateAlarmMinute(int alarmH)
	   {
	           if((alarmH >= 0) && (alarmH <= 24))
	                  this.alarmHour = alarmH;
	           else
	            System.out.println("invalid alarm hour");
	   }
	   public void setTimerAlarmMinute(int alarmM)
	   {
		   Calendar c = new GregorianCalendar();
		   int mins = c.get(Calendar.MINUTE);
           if((alarmM >= 0) && (alarmM <= 59))
                   this.alarmMinute = alarmM + mins;
           else
        	   System.out.println("invalid alarm minute");           
	   }
	   public void setAlarmMessage(String alarmMessage)
	   {
	           this.alarmMessage = alarmMessage;
	   }
	   public void setAlarmMonth(int alarmMonth)
	   {
		   Calendar c = new GregorianCalendar();
		   int fireMonth = c.get(Calendar.MONTH);
		   //month must be greater than 1
	           if((alarmMonth >= 0) && (alarmMonth <= 12))
	                   this.alarmMonth += (fireMonth + 1);
	           else
	                   System.out.println("invalid alarm month");
	   }
	   public void setAlarmDay(int alarmDay)
	   {
		   Calendar c = new GregorianCalendar();
		   int day = c.get(Calendar.DAY_OF_MONTH);
	           if((alarmDay >= 0) && (alarmDay <= 31))
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