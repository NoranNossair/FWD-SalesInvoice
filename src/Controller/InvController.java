
package Controller;

import Model.Invoice_Header;
import Model.Invoice_Line;
import Model.InvoicesTableModel;
import Model.LinesTableModel;
import View.SIGScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class InvController implements ActionListener,ListSelectionListener {
    
    private SIGScreen frame;

    public InvController(SIGScreen frame) {
        this.frame = frame;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Welcome");
        
        switch (e.getActionCommand()) {
            case "Create New Invoice":
                NewInvoice();
                break;
            case "Delete Invoice":
                DeleteInvoice();
                break;
            case "Save":
                SaveItem();
                break;
            case "Cancel":
                CancelItem();
                break;
            case "Load File":
                LoadFile();
                break;
            case "Save File":
                SaveFile();
                break;
    }
    
}
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedIndex = frame.getHeaderTable().getSelectedRow();
        Invoice_Header currentInvoice = frame.getHeaders().get(selectedIndex);
        frame.getInvNumLbl().setText("" + currentInvoice.getCstID());
        frame.getInvDateLbl().setText(currentInvoice.getDate());
        frame.getCstNameLbl().setText(currentInvoice.getName());
        frame.getInvTotalLbl().setText("" + currentInvoice.getTotal());
        LinesTableModel linesTableModel = new LinesTableModel(currentInvoice.getLines());
        frame.getLineTable().setModel(linesTableModel);
        linesTableModel.fireTableDataChanged();
        
    }

    private void NewInvoice() {
       
    }

    private void DeleteInvoice() {
       
    }

    private void SaveItem() {
        
    }

    private void CancelItem() {
        
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
                    Invoice_Header invoice = new Invoice_Header(invoiceNum, invoiceDate,invoiceCst);
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
            ex.printStackTrace();
        }}

    private void SaveFile() {
       
    }

    
}
    

