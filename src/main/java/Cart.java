
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aashi
 */
public class Cart extends javax.swing.JFrame {

    /**
     * Creates new form Cart
     */
    String user;
    double balance = 0;
    double donation=0;
    Connection conn;
    ResultSet rs;
    double price=0;
    double tax=0;
    double service=0;
    
    ArrayList<String> pid = new ArrayList<>();
    ArrayList<String> pname = new ArrayList<>();
    ArrayList<Integer> qty=new ArrayList<>();
    ArrayList<Integer> costs=new ArrayList<>();
    int len=0;
    DefaultListModel mod=new DefaultListModel();
    public Cart(String st) {
        initComponents();
        System.out.println("Welcome: "+st);
        if(!"NULL".equals(st))
            l1.setText("Hi "+st);
        else
            l1.setText("Guest Mode");
        user=st;
        la1.setModel(mod);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/aidkart","root","aashish2000");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ItemPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try{
            Statement s;
            String query="Select * from wallet where username='"+user+"'";
            s=conn.createStatement();
            rs=s.executeQuery(query);
            
            while(rs.next())
            {
                l8.setText(rs.getString("balance"));
                l9.setText(rs.getString("donation"));                
            }
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
        try {
            Statement s;
            String query="Select * from cart where username='"+user+"'";
            s=conn.createStatement();
            
            rs=s.executeQuery(query);
            
            String line="";
            
            
            line+=String.format("%1$"+"15"+ "s", "PID");
            line+=" | ";
            line+=String.format("%1$"+"15"+ "s", "Product");
            line+=" | ";
            line+=String.format("%1$"+"15"+ "s", "Price");
            line+=" | ";
            line+=String.format("%1$"+"15"+ "s", "Qty");
            mod.addElement(line);
            line="";
            while(rs.next())
            {
                len+=1;
                pid.add(rs.getString("pid"));
                pname.add(rs.getString("pname"));
                qty.add(rs.getInt("qty"));
                costs.add(rs.getInt("price"));
                
                line+=String.format("%1$"+"15"+ "s", rs.getString("pid"));
                line+=" | ";
                line+=String.format("%1$"+"15"+ "s", rs.getString("pname"));
                line+=" | ";
                line+=String.format("%1$"+"15"+ "s", rs.getString("price"));
                line+=" | ";
                line+=String.format("%1$"+"15"+ "s", rs.getString("qty"));
                price+=rs.getInt("price")*rs.getInt("qty");
                mod.addElement(line);
                line="";
            }
            //mod.addElement(String.format("%1$"+"55"+ "s", Integer.toString(price)));
            
            tax=price*0.15;
            service=price*0.1;
            price+=(tax+service);
            l7.setText(Double.toString(tax));
            l6.setText(Double.toString(service));
            l5.setText(Double.toString(price));
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l6 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        la1 = new javax.swing.JList<>();
        jButton9 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        l7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        l8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        l9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        l6.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        l6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(l6);
        l6.setBounds(1090, 250, 170, 50);

        l1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        l1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l1MouseClicked(evt);
            }
        });
        getContentPane().add(l1);
        l1.setBounds(1040, 0, 200, 50);

        jButton1.setText("Buy Now");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1020, 420, 110, 23);

        la1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jScrollPane1.setViewportView(la1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(160, 180, 720, 300);

        jButton9.setText("Back");
        jButton9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(50, 10, 140, 30);

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("           AidKart");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel13);
        jLabel13.setBounds(220, 0, 790, 50);

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Select Items you wish to remove from cart and then click remove");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel14);
        jLabel14.setBounds(160, 140, 510, 30);

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Service Charges");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel15);
        jLabel15.setBounds(900, 250, 170, 50);

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Total Price");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel16);
        jLabel16.setBounds(900, 320, 170, 50);

        l5.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        l5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(l5);
        l5.setBounds(1090, 320, 170, 50);

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Tax");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel17);
        jLabel17.setBounds(900, 180, 170, 50);

        l7.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        l7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(l7);
        l7.setBounds(1090, 180, 170, 50);

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Account Balance");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel18);
        jLabel18.setBounds(350, 520, 170, 50);

        l8.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        l8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(l8);
        l8.setBounds(540, 520, 170, 50);

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Total Donations");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel19);
        jLabel19.setBounds(350, 600, 170, 50);

        l9.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        l9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(l9);
        l9.setBounds(540, 600, 170, 50);

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Shopping Cart");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel20);
        jLabel20.setBounds(160, 70, 720, 50);

        jButton2.setText("View Transactions");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1040, 70, 200, 40);

        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(710, 140, 170, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setExtendedState(Cart.MAXIMIZED_BOTH); 
    }//GEN-LAST:event_formWindowOpened

    private void l1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_l1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            Statement s;
            String query="Select * from wallet where username='"+user+"'";
            s=conn.createStatement();
            rs=s.executeQuery(query);
            
            PreparedStatement stmt;
            
            while(rs.next())
            {
                balance=rs.getDouble("balance");
                System.out.println("Balance: "+Double.toString(balance));
            }
            if(balance>=price)
            {
                donation=service*0.2;
                balance-=price;
                System.out.println(Double.toString(balance));
                
                stmt=conn.prepareStatement("Update wallet set balance="+Double.toString(balance)+", donation="+Double.toString(donation)+" where username='"+user+"'");               
                stmt.execute();
                
                JOptionPane.showMessageDialog(this,"Thank You For Purchasing from AidKart!");
                
                for(int j=0;j<qty.size();j++)
                {
                    stmt=conn.prepareStatement("Insert into transactions values(?,?,?,?,NOW(),?)");       

                    stmt.setString(1,user);
                    stmt.setString(2,pid.get(j));
                    stmt.setString(3,pname.get(j));
                    stmt.setInt(4,costs.get(j));
                    //stmt.setString(5,"CURDATE()");
                    stmt.setInt(5,qty.get(j));
                    stmt.execute();
                }
                stmt=conn.prepareStatement("Delete from cart where username=?");
                stmt.setString(1,user);
                stmt.execute();
                mod.removeAllElements();
                Cart page=new Cart(user);
                dispose();
                page.setVisible(true);
                
            }
            
            else
            {
                JOptionPane.showMessageDialog(this,"You do not have sufficient Balance!");                               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            Statement s;
            String query="Select * from wallet where username='"+user+"'";
            s=conn.createStatement();
            rs=s.executeQuery(query);
            
            while(rs.next())
            {
                l8.setText(rs.getString("balance"));
                l9.setText(rs.getString("donation"));                
            }
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        ProductPage page=new ProductPage(user);
        page.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        PreparedStatement stmt;
        int[] selectedIx = la1.getSelectedIndices();
        for(int i=0;i<selectedIx.length;i++)
        {
            if(selectedIx[i]!=0)
            {
                try {
                    stmt=conn.prepareStatement("Delete from cart where username=? and pid=?");
                    stmt.setString(1,user);
                    stmt.setString(2,pid.get(selectedIx[i]-1));
                    stmt.execute();
                    mod.remove(selectedIx[i]);
                } catch (SQLException ex) {
                    Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        Cart page=new Cart(user);
        dispose();
        page.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Transaction trans=new Transaction(user);
        trans.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cart("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JLabel l7;
    private javax.swing.JLabel l8;
    private javax.swing.JLabel l9;
    private javax.swing.JList<String> la1;
    // End of variables declaration//GEN-END:variables
}
