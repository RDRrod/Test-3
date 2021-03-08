import java.sql.*;
import end_v1.Connect;
import static java.lang.reflect.Array.set;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Shop extends javax.swing.JFrame {

    
    public Shop() {
        initComponents();
        Demo();
    }
    
    public ArrayList<Videocard> getUserList(){
        ArrayList<Videocard> videocardsList = new ArrayList<Videocard>();
        Connection connect =Connect.getConnect();
        String query="Select*from Videocards";
        ResultSet rs;
        try{
        Statement stmt = connect.createStatement();
        rs = stmt.executeQuery(query);
        Videocard videocard;
        while(rs.next())
        {
            videocard = new Videocard(rs.getInt("videoid"),rs.getString("manufacture"),rs.getString("model"),rs.getInt("graphic_cores"),rs.getInt("memory_size"),rs.getInt("price"),rs.getInt("perf"),rs.getInt("tdp"), rs.getByte("count") );
            videocardsList.add(videocard);
        }
        }
        catch(Exception e){
        e.printStackTrace();
        }
        return videocardsList;
    }
    
    public void Demo(){
        ArrayList<Videocard> list= getUserList();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        Object[] row = new Object[9];
        for (int i=0; i<list.size(); i++){
            row[0]=list.get(i).getVideoid();
            row[1]=list.get(i).getManufacture();
            row[2]=list.get(i).getModel();
            row[3]=list.get(i).getGraphic_cores();
            row[4]=list.get(i).getMemory_size();
            row[5]=list.get(i).getPrice();
            row[6]=list.get(i).getPerfomance();
            row[7]=list.get(i).getTdp();
            row[8]=list.get(i).getCount();
            model.addRow(row);
            
            
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setLocation(new java.awt.Point(240, 230));
        setMinimumSize(new java.awt.Dimension(1200, 600));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/end_v1/delete1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 30, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "VideoId", "Manufacture", "Model", "Graphic cores", "Memory size", "Price", "Perfomance", "TDP"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 690, -1));

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 90, 120, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Sum");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 300, -1, -1));

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setText("Buy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 350, 180, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("Balance");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, -1, -1));

        jButton3.setText("Check");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 90, -1, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 180, -1, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, 40, 30));

        jTextField4.setEditable(false);
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 300, 110, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("Quantity");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 270, -1, -1));

        jTextField5.setEditable(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 230, 90, 30));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 180, 40, 30));

        jButton4.setText("SUM");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 300, -1, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel6.setText("Shop");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        //closing the window 
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        //Receiving and displaying user balance  
        try{
            Connection connect =Connect.getConnect();
            Statement stmt = connect.createStatement();
            String query3 = "SELECT balance FROM Human where id='1';";
            ResultSet rs = stmt.executeQuery(query3);
            int balance = 0;
            while (rs.next()) {
                balance = rs.getInt("balance");
            }
        jTextField1.setText(""+balance);}
        catch(Exception e){}
    }//GEN-LAST:event_jButton3ActionPerformed
  
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        // System for buying a vidocard and writing off money from the user's currency wallet 
        
        int videoid = Integer.parseInt(jTextField2.getText());
        int count = Integer.parseInt(jTextField3.getText());
        
        try{
            Connection connect =Connect.getConnect();
            Statement stmt = connect.createStatement();
            
             String query3 = "SELECT price FROM videocards where videoid='"+jTextField2.getText()+"';";
            ResultSet rs = stmt.executeQuery(query3);
            int s = 0;
            while (rs.next()) {
                s = rs.getInt("price");
            }
            count = Integer.parseInt(jTextField3.getText());
            int sum= s*count;
            jTextField5.setText(""+s);
            jTextField4.setText(""+sum);
            
            String query4 = "Select balance from Human where id='1';";
            ResultSet rs1 = stmt.executeQuery(query4);
            int balance =0;
            while (rs1.next()) {
                balance = rs1.getInt("balance");
            }
            System.out.println(sum+balance);
            if (sum<balance){
                
                stmt.executeUpdate("UPDATE Videocards set count = count + "+count+" WHERE videoid = '"+videoid+"';"
                   + " Update Human set balance = balance - "+sum+" where id='1'");
                JOptionPane.showMessageDialog(null,"Complited");
            setVisible(false);
            }
            else JOptionPane.showMessageDialog(null, "Not enough money");
            
            
        }catch(Exception e2){
            JOptionPane.showMessageDialog(null, "Doesn't update");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
    
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        //Displaying the price of a video card with a specific index  
         try{
            Connection connect =Connect.getConnect();
            Statement stmt = connect.createStatement();
            String query3 = "SELECT price FROM videocards where videoid='"+jTextField2.getText()+"';";
            ResultSet rs = stmt.executeQuery(query3);
            int s = 0;
            while (rs.next()) {
                s = rs.getInt("price");
            }
            int count = Integer.parseInt(jTextField3.getText());
            int sum= s*count;
            jTextField5.setText(""+s);
            jTextField4.setText(""+sum);
            
            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Doesn't update");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed

    }//GEN-LAST:event_jTextField5ActionPerformed

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Shop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
