
package Controller;

import Model.Invoice_Header;
import Model.Invoice_Line;
import Model.InvoicesTableModel;
import Model.LinesTableModel;
import View.InvoiceDialog;
import View.LineDialog;
import View.SIGScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class InvController implements ActionListener,ListSelectionListener {
    
    private SIGScreen frame;
    private InvoiceDialog invoiceDialog;
    private LineDialog lineDialog;

    public InvController(SIGScreen frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String actionCommand = e.getActionCommand();
            System.out.println("Welcome" + actionCommand);
            
            switch (actionCommand) {
                case "Load File":
                    LoadFile();
                    break;
                case "Save File":
                    SaveFile();
                    break;
                case "Create New Invoice":
                    createNewInvoice();
                    break;
                case "Delete Invoice":
                    deleteInvoice();
                    break;
                case "Create":
                    createNewItem();
                    break;
                case "Delete":
                    deleteItem();
                    break;
                case "createInvoiceCancel":
                    createInvoiceCancel();
                    break;
                case "createInvoiceOK":
                    createInvoiceOK();
                    break;
                case "createLineOK":
                    createLineOK();
                    break;
                case "createLineCancel":
                    createLineCancel();
                    break;
                    
            }   } catch (IOException ex) {
            Logger.getLogger(InvController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        @Override
        public void valueChanged(ListSelectionEvent e) {
        int selectedIndex = frame.getHeaderTable().getSelectedRow();
        if (selectedIndex != -1){
        System.out.println("selected" + selectedIndex);
        //int selectedIndex = frame.getHeaderTable().getSelectedRow();
        //ArrayList<Invoice_Header> invoice_Headers = frame.getInvoicesTableModel().invoice_Headers;
        //Invoice_Header currentInvoice = frame.getInvoicesTableModel().invoice_Headers.get(selectedIndex);
        Invoice_Header currentInvoice = frame.getInvoice_Headers().get(selectedIndex);
        frame.getInvNumLbl().setText("" + currentInvoice.getCstID());
        frame.getInvDateLbl().setText(currentInvoice.getDate() );
        frame.getCstNameLbl().setText(""+ currentInvoice.getName());
        frame.getInvTotalLbl().setText("" + currentInvoice.getTotal());
        //LinesTableModel linesTableModel = new LinesTableModel(currentInvoice.getLines());
        //ArrayList<Invoice_Line> linesTableModel = new ArrayList<Invoice_Line>(currentInvoice.getLines());
        LinesTableModel linesTableModel = new LinesTableModel(currentInvoice.getLines());
        frame.getLineTable().setModel(linesTableModel);
        linesTableModel.fireTableDataChanged();
        }
    }
        private void LoadFile() {
        JFileChooser fc = new JFileChooser();
        try {
            int result = fc.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fc.getSelectedFile();
                Path headerPath = Paths.get(headerFile.getAbsolutePath());
                List<String> headerLines = Files.readAllLines(headerPath);
                System.out.println("Invoices have been read");
                ArrayList<Invoice_Header> invoicesArray = new ArrayList<>();
                for(String headerLine : headerLines){
                    String headerParts[] = headerLine.split(",");
                    int invoiceNum = Integer.parseInt(headerParts[0]);
                    String invoiceDate = headerParts[1];
                    String invoiceCst = headerParts[2];
                    Invoice_Header invoice = new Invoice_Header(invoiceNum, invoiceDate, invoiceCst);
                    invoicesArray.add(invoice);
                }
                result = fc.showOpenDialog(frame);
                if(result == JFileChooser.APPROVE_OPTION){
                    File lineFile = fc.getSelectedFile();
                    Path linePath = Paths.get(lineFile.getAbsolutePath());
                    List<String> lineLines = Files.readAllLines(linePath);
                    System.out.println("Invoices Lines have been read");
                    for(String lineLine : lineLines){
                    String lineParts[] = lineLine.split(",");
                    int invoiceNum = Integer.parseInt(lineParts[0]);
                    String itemName = lineParts[1];
                    double itemPrice = Double.parseDouble(lineParts[2]);
                    int count = Integer.parseInt(lineParts[3]);
                    Invoice_Header inv = null;
                    for(Invoice_Header invoice : invoicesArray){
                        if(invoice.getCstID()== invoiceNum){
                            inv = invoice;
                            break;
                        }
                    }
                    Invoice_Line line= new Invoice_Line(itemName, itemPrice, count, inv);
                    inv.getLines().add(line);
                    }
                    System.out.println("read");
                }
                frame.setInvoice_Header(invoicesArray);
                InvoicesTableModel invoicesTableModel =  new InvoicesTableModel(invoicesArray);
                    frame.setInvoicesTableModel(invoicesTableModel);
                frame.getHeaderTable().setModel(invoicesTableModel);
                frame.getInvoicesTableModel().fireTableDataChanged();
            }
            
        }catch (IOException ex){
    }
}
        
        private void SaveFile() throws IOException {
            ArrayList<Invoice_Header> invoice_Headers = frame.getInvoice_Headers();
            String headers = "";
            String lines = "";
            for (Invoice_Header invoice_Header : invoice_Headers){
                String invCsv = invoice_Header.getAsCSV();
                headers += invCsv;
                headers += "\n";
                for(Invoice_Line invoice_Line : invoice_Header.getLines()){
                    String lineCSV = invoice_Line.getAsCSV();
                    lines += lineCSV;
                    lines += "\n"; 
                }
            }
            System.out.println("check point");
            try {
                JFileChooser fc = new JFileChooser();
            int result = fc.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION){
                File headerFile = fc.getSelectedFile();
                FileWriter hfw = new FileWriter(headerFile);
                hfw.write(headers);
                hfw.flush();
                hfw.close();
                result = fc.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION){
                File lineFile = fc.getSelectedFile();
                FileWriter lfw = new FileWriter(lineFile);
                lfw.write(lines);
                lfw.flush();
                lfw.close();
                }
            }
            } catch (Exception e) {
            }
        }
         
    private void createNewInvoice() {
        invoiceDialog = new InvoiceDialog(frame);
        invoiceDialog.setVisible(true);
    }

    private void deleteInvoice() {
        int selectedRow = frame.getHeaderTable().getSelectedRow();
        if (selectedRow != -1){
            frame.getInvoice_Headers().remove(selectedRow);
            frame.getInvoicesTableModel().fireTableDataChanged();
        }
    }

    private void createNewItem() {
        lineDialog = new LineDialog(frame);
        lineDialog.setVisible(true);
        
    }

    private void deleteItem() {
        //int selectedInv = frame.getHeaderTable().getSelectedRow();
        int selectedRow = frame.getLineTable().getSelectedRow();
        if (selectedRow !=-1){
            //Invoice_Header invoice_Header = frame.getHeaders().get(selectedInv);
            //invoice_Header.getLines().remove(selectedRow);
            //LinesTableModel linesTableModel = new LinesTableModel(invoice_Header.getLines());
            //frame.getLineTable().setModel(linesTableModel);
            LinesTableModel linesTableModel = (LinesTableModel) frame.getLineTable().getModel();
            linesTableModel.getLines().remove(selectedRow);
            linesTableModel.fireTableDataChanged();
            frame.getInvoicesTableModel().fireTableDataChanged();
        }
        
    }

    private void createInvoiceCancel() {
        invoiceDialog.setVisible(false);
        invoiceDialog.dispose();
        invoiceDialog = null;
    }

    private void createInvoiceOK() {
        String date = invoiceDialog.getInvDateField().getText();
        String customer = invoiceDialog.getCustNameField().getText();
        int num = frame.getNextInvoiceNum();
        Invoice_Header invoice_Header = new Invoice_Header(num, date, customer);
        frame.getInvoice_Headers().add(invoice_Header);
        frame.getInvoicesTableModel().fireTableDataChanged();
        invoiceDialog.setVisible(false);
        invoiceDialog.dispose();
        invoiceDialog = null;
    }
    
    private void createLineOK() {
        String item = lineDialog.getItemNameField().getText();
        String countStr = lineDialog.getItemCountField().getText();
        String priceStr = lineDialog.getItemPriceField().getText();
        int count = Integer.parseInt(countStr);
        double price = Double.parseDouble(priceStr);
        int selectedInvoice = frame.getHeaderTable().getSelectedRow();
        if (selectedInvoice != -1){
        Invoice_Header invoice_Header = frame.getInvoice_Headers().get(selectedInvoice);
        Invoice_Line invoice_Line = new Invoice_Line(item, price, count, invoice_Header);
        invoice_Header.getLines().add(invoice_Line);
        LinesTableModel linesTableModel = (LinesTableModel)frame.getLineTable().getModel();
        //linesTableModel.getInvoice_Lines().add(invoice_Line);
        linesTableModel.fireTableDataChanged();
        frame.getInvoicesTableModel().fireTableDataChanged();
        }
       lineDialog.setVisible(false);
       lineDialog.dispose();
       lineDialog = null;
    }

    private void createLineCancel() {
       lineDialog.setVisible(false);
       lineDialog.dispose();
       lineDialog = null;
    }
}
