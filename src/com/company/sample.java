package com.company;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
// to compile program javac -d . *.java
class window_ada1 extends WindowAdapter
{
    myframe1 f2;
   public window_ada1(myframe1 fr) {
        this.f2 = fr;} // end of constructor

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0); //this.f2.dispose();java
    }


} // end of class window_ada
class window_ada_diag1 extends Dialog implements WindowListener{
    int roll, j = 0;
    String titl;
    Statement st1 = null;
    ResultSet rs1 = null;
    Connection con1 = null;
    Label l2 = new Label("RECORDS TILL NOW..");
    Label [] la = new Label[4]; 
    public window_ada_diag1(Frame frm, String titl, boolean modal) {
        super(frm, titl, modal);
        setLayout(new FlowLayout());
        setSize(350,200);
        la[0] = new Label(); la[1] = new Label(); la[2] = new Label(); la[3] = new Label();
        add(l2);add(la[0]); add(la[1]); add(la[2]); add(la[3]); 
        setLocation(300,300);
        addWindowListener(this);
        this.titl = titl;
        this.setTitle("SAVED DETAILS FOR ENROLLMENT NO:" + this.titl);
       try {
        Class.forName("com.mysql.cj.jdbc.Driver");    
        con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");          
         if (!con1.isClosed()) {
                  String sr = "SELECT subject, sum(status) As Present, count(date) As Total  FROM student.exam where enroll=" +this.titl+" group by subject";
                  st1 = con1.createStatement();
                   if (st1.execute(sr)) { rs1 = st1.getResultSet();} }//end of outer if
                    while (rs1.next()) {
                     la[j].setText(rs1.getString(1) + "--> Attended " +  rs1.getInt(2)+ " Out of " +  rs1.getInt(3) + " Classes." ); 
                     j++;
                    }       
       } catch (Exception e) { System.out.println(e.getMessage());}
       finally { //con.close();
        }
    } // end of constructor

    @Override
    public void windowClosing(WindowEvent e) {
        setVisible(false);
    }
    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
} // end of window_ada_diag class

class myframe1 extends Frame implements ActionListener, ItemListener {
    int i = 1; 
    String str1, str2, str3;
    public int rol = 100000000;
    boolean exit;
    ResultSet rs;
    Thread th1;
    Label l1 = new Label();
    Button b1 = new Button("SUBMIT");
    public Choice c1 = new Choice();
    Checkbox cb1 = new Checkbox("HTML & CSS");
    Checkbox cb2 = new Checkbox("OOPS WITH JAVA");
    Checkbox cb3 = new Checkbox("JAVA SCRIPT");
    Checkbox cb4 = new Checkbox("C LANGUAGE");
    LocalDate date = java.time.LocalDate.now();
    String dt = date.toString();
    Connection con = null;
    //Statement st = null;
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (c1.getItemCount()!=0) {
        switch (c1.getSelectedIndex()) {
            case 0: this.setBackground(Color.gray); 
           rol = Integer.parseInt(c1.getSelectedItem());
            break;
            case 1: this.setBackground(Color.red); 
           rol = Integer.parseInt(c1.getSelectedItem());
            break;
            case 2: this.setBackground(Color.cyan);
           rol = Integer.parseInt(c1.getSelectedItem());
            break;
            case 3: this.setBackground(Color.green); 
           rol = Integer.parseInt(c1.getSelectedItem());
           break;
            default: rol = 100000000;
        }
        // l1.setText(c1.getSelectedItem());
           cb1.setState(false); cb2.setState(false);cb3.setState(false);cb4.setState(false);
       }
    }

    public myframe1(String str) {
        super(str);
        this.setTitle("DATE:" +dt);
            l1.setText("SELECT ENROLLMENT NO:");
            this.add(l1);
            this.add(c1);
            this.add(cb1); this.add(cb2); this.add(cb3); this.add(cb4);
            this.add(b1);
            c1.add("100000000");
            c1.add("100000001");
            c1.add("100000002");
            c1.add("100000003");
            c1.addItemListener(this);
            b1.addActionListener(this);
            addWindowListener(new window_ada1(this));
              
                
    } // end of constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean flag = false;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");    
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");    
            Statement st = con.createStatement(); 
            if (e.getSource() == b1 && ! con.isClosed()) {
                str2 = "Select * from exam where enroll = " + rol + " and date='" + dt + "'";
                rs =st.executeQuery(str2); rs = st.getResultSet();
                 if (rs.next()) { flag  = true; } 
                if (cb1.getState() == true && flag == false) {
                    str1 =  "INSERT INTO exam (enroll, date, status, subject) VALUES (" +rol + ",'" + dt + "',1,'" + cb1.getLabel() + "')";
                   int result = st.executeUpdate(str1); if (result == -1) System.out.println("DB Error!");
                } else if (cb1.getState() == false && flag == false) {
                    str1 =  "INSERT INTO exam (enroll, date, status, subject) VALUES (" +rol + ",'" + dt + "',0,'" + cb1.getLabel() + "')";
                    int result = st.executeUpdate(str1); if (result == -1) System.out.println("DB Error!");
                         } 
                         else if (cb1.getState() == true && flag == true) {
                            str3 =  "Update exam set status = 1 where enroll = " + rol + " and date = '" + dt + "' and subject = '" + cb1.getLabel() + "'";
                            int result = st.executeUpdate(str3); if (result == -1) System.out.println("DB Error!");
                         }
                         else if (cb1.getState() == false && flag == true) {
                            str3 =  "Update exam set status = 0 where enroll = " + rol + " and date = '" + dt +  "' and subject = '" + cb1.getLabel() + "'";
                            int result = st.executeUpdate(str3); if (result == -1) System.out.println("DB Error!");
                         }
                         if (cb2.getState() == true && flag == false) {
                            str1 =  "INSERT INTO exam (enroll, date, status, subject) VALUES (" +rol + ",'" + dt + "',1,'" + cb2.getLabel() + "')";
                            int result = st.executeUpdate(str1); if (result == -1) System.out.println("DB Error!");
                                            } else if (cb2.getState() == false && flag == false) {
                                                str1 =  "INSERT INTO exam (enroll, date, status, subject) VALUES (" +rol + ",'" + dt + "',0,'" + cb2.getLabel() + "')";
                                                int result = st.executeUpdate(str1); if (result == -1) System.out.println("DB Error!");
                                                     } 
                                                     else if (cb2.getState() == true && flag == true) {
                                                        str3 =  "Update exam set status = 1 where enroll = " + rol + " and date = '" + dt + "' and subject = '" + cb2.getLabel() + "'";
                                                        int result = st.executeUpdate(str3); if (result == -1) System.out.println("DB Error!");
                                                     }
                                                     else if (cb2.getState() == false && flag == true) {
                                                        str3 =  "Update exam set status = 0 where enroll = " + rol + " and date = '" + dt + "' and subject = '" + cb2.getLabel() + "'";
                                                        int result = st.executeUpdate(str3); if (result == -1) System.out.println("DB Error!");
                                                     }
                                                     if (cb3.getState() == true && flag == false) {
                                                        str1 =  "INSERT INTO exam (enroll, date, status, subject) VALUES (" +rol + ",'" + dt + "',1,'" + cb3.getLabel() + "')";
                                                        int result = st.executeUpdate(str1); if (result == -1) System.out.println("DB Error!");
                                                                        } else if (cb3.getState() == false && flag == false){
                                                                            str1 =  "INSERT INTO exam (enroll, date, status, subject) VALUES (" +rol + ",'" + dt + "',0,'" + cb3.getLabel() + "')";
                                                                            int result = st.executeUpdate(str1); if (result == -1) System.out.println("DB Error!");
                                                                                 } 
                                                                                 else if (cb3.getState() == true && flag == true) {
                                                                                    str3 =  "Update exam set status = 1 where enroll = " + rol + " and date = '" + dt + "' and subject = '" + cb3.getLabel() + "'";
                                                                                    int result = st.executeUpdate(str3); if (result == -1) System.out.println("DB Error!");
                                                                                 }
                                                                                 else if (cb3.getState() == false && flag == true) {
                                                                                    str3 =  "Update exam set status = 0 where enroll = " + rol + " and date = '" + dt + "' and subject = '" + cb3.getLabel() + "'";
                                                                                      int result = st.executeUpdate(str3); if (result == -1) System.out.println("DB Error!");
                                                                                 }
                                                                                 if (cb4.getState() == true && flag == false) {
                                                                                    str1 =  "INSERT INTO exam (enroll, date, status, subject) VALUES (" +rol + ",'" + dt + "',1,'" + cb4.getLabel() + "')";
                                                                                     int result = st.executeUpdate(str1); if (result == -1) System.out.println("DB Error!");
                                                                                                    } else if (cb4.getState() == false && flag == false) {
                                                                                                        str1 =  "INSERT INTO exam (enroll, date, status, subject) VALUES (" +rol + ",'" + dt + "',0,'" + cb4.getLabel() + "')";
                                                                                                        int result = st.executeUpdate(str1); if (result == -1) System.out.println("DB Error!");
                                                                                                             } 
                                                                                                             else if (cb4.getState() == true && flag == true) {
                                                                                                                str3 =  "Update exam set status = 1 where enroll = " + rol + " and date = '" + dt + "' and subject = '" + cb4.getLabel() + "'";
                                                                                                                
                                                                                                                int result = st.executeUpdate(str3); if (result == -1) System.out.println("DB Error!");
                                                                                                             }
                                                                                                             else if (cb4.getState() == false && flag == true) {
                                                                                                                str3 =  "Update exam set status = 0 where enroll = " + rol + " and date = '" + dt + "' and subject = '" + cb4.getLabel() + "'";
                                                                                                                
                                                                                                                int result = st.executeUpdate(str3); if (result == -1) System.out.println("DB Error!");
                                                                                                             }
                
                                                                                                            }            // end of outer if
            } catch (Exception e1) {System.out.println(e1.getMessage());}  
            window_ada_diag1 ada = new window_ada_diag1(this, c1.getSelectedItem(),true);
            ada.setVisible(true); 
    } // end of method
} //  end of class

public class sample {
    public static void main(String[] args) {
        myframe1 f = new myframe1("Hi");
        f.setSize(900,100);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        f.setBackground(Color.gray);
       
    }
}