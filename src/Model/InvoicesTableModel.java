
package Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Noran Nossair
 */
public class InvoicesTableModel extends AbstractTableModel{
    private ArrayList<Invoice_Header> invoice_Headers;
    private String [] columns = {"No.","Date","Customer","Total"};

    public InvoicesTableModel(ArrayList<Invoice_Header> invoice_Headers) {
        this.invoice_Headers = invoice_Headers;
    }
    
    @Override
    public int getRowCount() {
        return invoice_Headers.size();
       
    }

    @Override
    public int getColumnCount() {
        return columns.length;
       
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
       
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Invoice_Header invoice = invoice_Headers.get(rowIndex);
        switch (columnIndex) {
            case 0:return invoice.getCstID();
            case 1:return invoice.getDate();
            case 2:return invoice.getName();
            case 3:return invoice.getTotal();
            default:return "";
            
        }
    }
    
    
}
