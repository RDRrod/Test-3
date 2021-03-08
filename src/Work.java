
import end_v1.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import java.util.Timer;
import java.util.TimerTask;


public class Work extends javax.swing.JFrame {

//     Creates new form Work
     
    public Work() {
        initComponents();
        Demo();
        CryptChecker();
        
        
    }
//    Writing data from database to arraylist 
    
    public ArrayList<Videocard> getUserList(){
        ArrayList<Videocard> videocardsList = new ArrayList<Videocard>();
        Connection connect =Connect.getConnect();
        String query="SELECT manufacture, model, perf, count, sum(perf * count) as overall\n" +
          "from videocards WHERE count > 0 group by manufacture, model, perf, count ;";
        ResultSet rs;
        try{
        Statement stmt = connect.createStatement();
        rs = stmt.executeQuery(query);
        Videocard videocard;
        String SQL = "SELECT videoid, manufacture, perf, count FROM videocards WHERE count > 0";
        while(rs.next())
        {
            videocard = new Videocard(rs.getString("manufacture"),rs.getString("model"),rs.getInt("perf"),rs.getInt("count"),rs.getInt("overall") );
            videocardsList.add(videocard);
        }
        }
        catch(Exception e){
        e.printStackTrace();
        }
        return videocardsList;
    }
    
//    Method filling the JTable from the data obtained above 
    
    public void Demo(){
        ArrayList<Videocard> list= getUserList();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        Object[] row = new Object[5];
        for (int i=0; i<list.size(); i++){
            row[0]=list.get(i).getManufacture();
            row[1]=list.get(i).getModel();
            row[2]=list.get(i).getPerfomance();
            row[3]=list.get(i).getCount();
            row[4]=list.get(i).getOverall();
            model.addRow(row);
            
            
        }
    }
    
    // The method that sends the necessary qsl - requests for their further display in the window in real time 
    
    public void CryptChecker(){
        try{
        Connection connect =Connect.getConnect();
        Statement stmt = connect.createStatement();
        //-----
            Timer timer = new Timer();
            TimerTask myTask = new TimerTask() { //Creating a timer that needs to update the current state of the crypto wallet in real time 
		@Override
        	public void run() {
                try {
                    String query = "select sum (perf * count) as sumoverall from videocards;";
                    ResultSet rs = stmt.executeQuery(query);
                    int sumoverall = 0;
                    while (rs.next()) {
                        sumoverall = rs.getInt("sumoverall"); //Recording the overall performance of purchased video cards 
                    }
                    jTextField1.setText(""+sumoverall); 
                    double criptPerHour = new calculator().getCriptPerHour(sumoverall); //A method called from another class to calculate performance in mining cryptocurrency 
                    String query5="Select crypt from human;";
                    ResultSet rs2 = stmt.executeQuery(query5);
                    double crypt = 0.0;
                    while (rs2.next()) {
                        crypt = rs2.getDouble("crypt"); //Current balance of the user's crypto wallet 
                    }
                    double cryptBalanceNow= new calculator().getCryptNow(crypt, criptPerHour); // A called method from another class that will change the amount of cryptocurrency in the window based on performance 
                    stmt.executeUpdate("Update human set crypt='"+cryptBalanceNow+"' where id='1'"); //send the result to the database 
                    String formattedDouble = String.format("%.2f", cryptBalanceNow ); //
                    jTextField3.setText(""+formattedDouble);

                }catch (Exception e) {
                    
                }
                    System.out.println("5 seconds");
                }
            };

            timer.schedule(myTask, 5000, 5000);
            timer.schedule(new TimerTask() {
		@Override
                public void run() {
                    System.out.println(" Run spcific task at given time.");
                timer.cancel();
                }
            }, 60000); //Refresh timer lasts 60 seconds 
            
            
//            int money = Integer.parseInt(jTextField4.getText());
//            jTextField3.setText(""+crypt);
//            double cryptBalanceNow= new calculator().getCryptNow(crypt, criptPerHour);
//            stmt.executeUpdate("Update human set crypt='"+cryptBalanceNow+"' where id='1'");
//            String formattedDouble = String.format("%.2f", cryptBalanceNow );
//            jTextField3.setText(""+formattedDouble);

        }
        catch(Exception e){ e.printStackTrace();}}

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(240, 230));
        setMinimumSize(new java.awt.Dimension(1200, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 600));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Manufacture", "Model", "Perfomance", "Quantity", "Overall performance "
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel1.setText("Work");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/end_v1/delete1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Whole farm perfomance");

        jTextField1.setEditable(false);

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setText("Check");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("Cryptocurrency mining p/h");

        jTextField2.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("Coins");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("Money");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jButton3.setText("Money");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(29, 29, 29)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(33, 33, 33)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton1)))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField2)
                                .addGap(400, 400, 400))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(400, 400, 400))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        // Window close button 
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        // Action on the "search" button to calculate the overall performance of all video cards and profitability 
        try{
            Connection connect =Connect.getConnect();
            Statement stmt = connect.createStatement();
            String query = "select sum (perf * count) as sumoverall from videocards;";
            ResultSet rs = stmt.executeQuery(query);
            int sumoverall = 0;
            while (rs.next()) {
                sumoverall = rs.getInt("sumoverall");
            }
            jTextField1.setText(""+sumoverall);
            double criptPerHour = new calculator().getCriptPerHour(sumoverall);
            jTextField2.setText(""+criptPerHour);
        }
        catch(Exception e){}  
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        //Action on the button that allows you to display the user's balance in jtextField 
        
        try{
        Connection connect =Connect.getConnect();
        Statement stmt = connect.createStatement();
            String query6="Select balance from human;";
            ResultSet rs3 = stmt.executeQuery(query6);
            int balance = 0;
            while (rs3.next()) {
                balance = rs3.getInt("balance");
            }
            jTextField4.setText(""+balance);
        
        }
        catch(Exception e){ e.printStackTrace();}
         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Work().setVisible(true);  //The appearance of the window 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
