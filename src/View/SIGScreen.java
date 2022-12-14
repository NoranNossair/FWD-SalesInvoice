/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.InvController;
import Model.Invoice_Header;
import Model.InvoicesTableModel;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Noran Nossair
 */
public class SIGScreen extends javax.swing.JFrame {

    /**
     * Creates new form SIGScreen
     */
    public SIGScreen() {
        controller = new InvController(this);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        headerTable = new javax.swing.JTable();
        headerTable.getSelectionModel().addListSelectionListener(controller);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invNumLbl = new javax.swing.JLabel();
        invDateLbl = new javax.swing.JLabel();
        cstNameLbl = new javax.swing.JLabel();
        invTotalLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lineTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        createInvBtn = new javax.swing.JButton();
        createInvBtn.addActionListener(controller);
        deleteInvBtn = new javax.swing.JButton();
        deleteInvBtn.addActionListener(controller);
        createItemBtn = new javax.swing.JButton();
        createItemBtn.addActionListener(controller);
        deleteItemBtn = new javax.swing.JButton();
        deleteItemBtn.addActionListener(controller);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadFileBtn = new javax.swing.JMenuItem();
        loadFileBtn.addActionListener(controller);
        saveFileBtn = new javax.swing.JMenuItem();
        saveFileBtn.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        headerTable.setToolTipText("");
        jScrollPane1.setViewportView(headerTable);

        jLabel1.setText("Invoice Number");

        jLabel2.setText("Invoice Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Invoice Total");

        invNumLbl.setText("-");

        invDateLbl.setText("-");

        cstNameLbl.setText("-");

        invTotalLbl.setText("-");

        lineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(lineTable);

        jLabel9.setText("Invoices Table");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Invoice Items");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        createInvBtn.setText("Create New Invoice");
        createInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createInvBtnActionPerformed(evt);
            }
        });

        deleteInvBtn.setText("Delete Invoice");

        createItemBtn.setText("Create");
        createItemBtn.setActionCommand("Create");
        createItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createItemBtnActionPerformed(evt);
            }
        });

        deleteItemBtn.setText("Delete");

        jMenu1.setText("File");

        loadFileBtn.setText("Load File");
        jMenu1.add(loadFileBtn);

        saveFileBtn.setText("Save File");
        saveFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileBtnActionPerformed(evt);
            }
        });
        jMenu1.add(saveFileBtn);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(invNumLbl)
                            .addComponent(invDateLbl)
                            .addComponent(cstNameLbl)
                            .addComponent(invTotalLbl)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(createInvBtn)
                .addGap(18, 18, 18)
                .addComponent(deleteInvBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createItemBtn)
                .addGap(62, 62, 62)
                .addComponent(deleteItemBtn)
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(invNumLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(invDateLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cstNameLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(invTotalLbl))
                        .addGap(51, 51, 51)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createItemBtn)
                    .addComponent(deleteItemBtn)
                    .addComponent(deleteInvBtn)
                    .addComponent(createInvBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createInvBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createInvBtnActionPerformed

    private void saveFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveFileBtnActionPerformed

    private void createItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createItemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createItemBtnActionPerformed

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
            java.util.logging.Logger.getLogger(SIGScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SIGScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SIGScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SIGScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SIGScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createInvBtn;
    private javax.swing.JButton createItemBtn;
    private javax.swing.JLabel cstNameLbl;
    private javax.swing.JButton deleteInvBtn;
    private javax.swing.JButton deleteItemBtn;
    private javax.swing.JTable headerTable;
    private javax.swing.JLabel invDateLbl;
    private javax.swing.JLabel invNumLbl;
    private javax.swing.JLabel invTotalLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable lineTable;
    private javax.swing.JMenuItem loadFileBtn;
    private javax.swing.JMenuItem saveFileBtn;
    // End of variables declaration//GEN-END:variables
    private ArrayList<Invoice_Header> invoice_Headers;
    private InvController controller = new InvController(this);
    public InvoicesTableModel invoicesTableModel;

    public JLabel getCstNameLbl() {
        return cstNameLbl;
    }

    public JTable getHeaderTable() {
        return headerTable;
    }

    public JLabel getInvDateLbl() {
        return invDateLbl;
    }

    public JLabel getInvNumLbl() {
        return invNumLbl;
    }

    public JLabel getInvTotalLbl() {
        return invTotalLbl;
    }

    public JTable getLineTable() {
        return lineTable;
    }

    public InvController getController() {
        return controller;
    }

    public InvoicesTableModel getInvoicesTableModel() {
        if (invoicesTableModel == null) {
            invoicesTableModel = new InvoicesTableModel(getInvoice_Headers());
        }
        return invoicesTableModel;
    }
    public int getNextInvoiceNum(){
        int num = 0;
        for (Invoice_Header invoice_Header : getInvoice_Headers()){
            if(invoice_Header.getCstID() > num)
                num = invoice_Header.getCstID();
        }
        return ++num;
    }

    public void setInvoicesTableModel(InvoicesTableModel invoicesTableModel) {
        this.invoicesTableModel = invoicesTableModel;
    }

    public void setInvoice_Headers(ArrayList<Invoice_Header> invoice_Headers) {
        this.invoice_Headers = invoice_Headers;
    }

    public ArrayList<Invoice_Header> getInvoice_Headers() {
        if (invoice_Headers == null) invoice_Headers = new ArrayList<>();
        return invoice_Headers;
    }
    
    //public ArrayList<Invoice_Header> invoice_Headers(){
        //return invoice_Headers;
    //}
    public void setInvoice_Header(ArrayList<Invoice_Header> invoice_Headers){
        this.invoice_Headers = invoice_Headers;
    }

}
