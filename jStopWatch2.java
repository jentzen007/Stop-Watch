import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class jStopWatch2 implements ActionListener
{
    JFrame f = new JFrame();
    boolean started=false;
    public int counter = 0;
    JButton str,lapp,res,stp;
    JLabel l,l1,l4,l5,l6;
    int time=0;
    int seconds=0;
    int millisecconds=0;
    int minutes=0;
    int hours=0;
    int c;
    int q,w,m;
    JLabel l2,l3;
    String milliseconds_string = String.format("%03d", millisecconds);
    String seconds_string = String.format("%02d",seconds);
    String minutes_string = String.format("%02d",minutes);
    String hours_string = String.format("%02d",hours);
    Timer timer = new Timer(1000,new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            time+=1000;
            
            seconds=(time/1000)%60;
            
            minutes=(time/60000)%60;
            
            hours=(time/3600000)%24;
            String seconds_string = String.format("%02d",seconds);
            String minutes_string = String.format("%02d",minutes);
            String hours_string = String.format("%02d",hours);
            q = hours;
            w = minutes;
            m = seconds;
            
            l.setText(hours_string+" "+minutes_string+" "+seconds_string);
            if(seconds%2==0)
                {
                    l2.setForeground(Color.WHITE);
                    l3.setForeground(Color.WHITE);
                }
            else
                {
                    l2.setForeground(Color.black);
                    l3.setForeground(Color.black);
                }
           
        }
    });
   
    jStopWatch2()
    {
        f.getContentPane().setBackground(Color.black);
        f.setBounds(100,100,400,500);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        l = new JLabel();
        l1 = new JLabel();
        l4 = new JLabel();
        l5 = new JLabel();
        l6 = new JLabel();
        f.add(l1);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(l);
        l.setBounds(0,0,400,150);
        l.setForeground(Color.WHITE);
        l1.setBounds(0,210,400,150);
        l1.setForeground(Color.WHITE);
        l4.setBounds(0,250,400,150);
        l4.setForeground(Color.WHITE);
        l5.setBounds(0,290,400,150);
        l5.setForeground(Color.WHITE);
        l6.setBounds(0,330,400,150);
        l6.setForeground(Color.WHITE);
        str = new JButton("Start");
        f.add(str);
        str.addActionListener(this);
        stp = new JButton("Stop");
        f.add(stp);
        stp.addActionListener(this);
        stp.setBounds(133,150,133,50);
        str.setBounds(0,150,133,50);
        res = new JButton("Reset");
        f.add(res);
        lapp = new JButton("Lap");
        f.add(lapp);
        lapp.setBounds(0,200,400,50);
        lapp.addActionListener(this);
        res.addActionListener(this);
        res.setBounds(266,150,133,50);
        l.setText("00:00:00");
        l.setHorizontalAlignment(JTextField.CENTER);
        l2 = new JLabel();
        f.add(l2);
        l3 = new JLabel();
        f.add(l3);
        l2.setBounds(11,0,400,150);
        l2.setText("         :    ");
        l3.setText("              :");
        l3.setBounds(6,0,400,150);
        
        l.setFont(new Font("Trattatello",Font.BOLD,60));
        l2.setFont(new Font("Trattatello",Font.BOLD,60));
        l1.setFont(new Font("Trattatello",Font.BOLD,40));
        l4.setFont(new Font("Trattatello",Font.BOLD,40));
        l5.setFont(new Font("Trattatello",Font.BOLD,40));
        l6.setFont(new Font("Trattatello",Font.BOLD,40));
        l3.setFont(new Font("Trattatello",Font.BOLD,60));
        
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==str)
            {
                if(started==false)
                {
                    start();
                    started=true;
               }
            }
        if(ae.getSource()==stp)
            {
                if(started==true)
                    {
                        sttop();
                        started=false;
                        
                    }
            }
        if(ae.getSource()==res)
            reset();
        if(ae.getSource()==lapp)
            {
                if(started==true)
                    {
                        lap();
                        counter++;
                        counter%=4;
                    }
            }
    }
    void start()
    {
        timer.start();
    }
    void sttop()
    {
        timer.stop();
        f.getContentPane().setBackground(Color.black);
    }
    void reset()
    {
        time=0;
        seconds=0;
        millisecconds=0;
        minutes=0;
        hours=0;
        counter = 0;
        String milliseconds_string = String.format("%03d", millisecconds);
        String seconds_string = String.format("%02d",seconds);
        String minutes_string = String.format("%02d",minutes);
        String hours_string = String.format("%02d",hours);
        
        l.setText(hours_string+":"+minutes_string+":"+seconds_string);
        l1.setText("");
        l4.setText("");
        l5.setText("");
        l6.setText("");
    }
   
  
    void lap() {
         
    if (counter >= 0 && counter <= 3) {

        String lapTimeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        switch (counter) {
            case 0:
                l1.setText(lapTimeString);
                break;
            case 1:
                l4.setText(lapTimeString);
                break;
            case 2:
                l5.setText(lapTimeString);
                break;
            case 3:
                l6.setText(lapTimeString);
                break;
        }
    }
    }
   
    public static void main(String[] args)
    {
       jStopWatch2 watch = new jStopWatch2();
    }
}
