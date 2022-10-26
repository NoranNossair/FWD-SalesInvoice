/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import javafx.scene.shape.Line;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Noran Nossair
 */
public class LinesTableModel extends AbstractTableModel{

    public LinesTableModel(ArrayList<Invoice_Line> lines) {
    }
    private ArrayList<Invoice_Line> invLines;
    private String [] columns = {"No.","Item Name","Item Price","Count", "Item Total"};

    @Override
    public int getRowCount() {
        return invLines.size();
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
        Invoice_Line line = invLines.get(rowIndex);
         switch (columnIndex) {
            case 0:return line.getInv();
            case 1:return line.getProduct();
            case 2:return line.getPrice();
            case 3:return line.getTotal();
            default:return "";
            
        }
        
    }
    
}
