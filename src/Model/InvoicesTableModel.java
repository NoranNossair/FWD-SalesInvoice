
package Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Noran Nossair
 */
public class InvoicesTableModel extends AbstractTableModel{
    private ArrayList<Invoice_Header> invoice_Headers;
    public String [] columns = {"No.","Date","Customer","Total"};
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
       Invoice_Header invoice_Header = invoice_Headers.get(rowIndex);
        switch (columnIndex) {
            case 0:return invoice_Header.getCstID();
            case 1:return invoice_Header.getDate();
            case 2:return invoice_Header.getName();
            case 3:return invoice_Header.getTotal();
            default:return "";
            
        }
    }
    
    
}
