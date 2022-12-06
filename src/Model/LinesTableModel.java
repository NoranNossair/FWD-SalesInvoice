
package Model;

import java.util.ArrayList;
//import javafx.scene.shape.Line;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Noran Nossair
 */
public class LinesTableModel extends AbstractTableModel{
    private ArrayList<Invoice_Line> invoice_Lines;
    private String [] columns = {"No.","Item Name","Item Price","Count", "Item Total"};
    // public LinesTableModel(ArrayList<Invoice_Line> lines) {
    //}
    public LinesTableModel(ArrayList<Invoice_Line> invoice_Lines) {
        this.invoice_Lines = invoice_Lines;
    }
    //public ArrayList<Invoice_Line> invLines;

    public ArrayList<Invoice_Line> getInvoice_Lines() {
        return invoice_Lines;
    }
    

    @Override
    public int getRowCount() {
        //return invLines.size();
        return invoice_Lines.size();
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
        Invoice_Line invoice_Line = invoice_Lines.get(rowIndex);
        //Invoice_Line line = invoice_Lines.get(rowIndex);
         switch (columnIndex) {
            case 0:return invoice_Line.getInv().getCstID();
            case 1:return invoice_Line.getProduct();
            case 2:return invoice_Line.getPrice();
            case 3:return invoice_Line.getCount();
            case 4:return invoice_Line.getLineTotal();
            default:return "";
            
        }
        
    }
    
}
