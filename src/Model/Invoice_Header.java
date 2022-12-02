/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Noran Nossair
 */
public class Invoice_Header {

    private int cstID;
    private String date;
    private String name;
    public ArrayList<Invoice_Line> lines;

    public Invoice_Header() {
    }
    
   

    public Invoice_Header(int cstID, String date, String name) {
        this.cstID = cstID;
        this.date = date;
        this.name = name;
    }
    
    
        public double getTotal(){
        double total = 0.0;
        for (Invoice_Line invoice_Line : getLines()) {
            total += invoice_Line.getLineTotal();
        }
        return total;
    }
    public ArrayList<Invoice_Line> getLines() {
        if (lines == null){
            lines = new ArrayList<>();
        }
        return lines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCstID() {
        return cstID;
    }

    public void setCstID(int cstID) {
        this.cstID = cstID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
    return "Invoice_Header {" + "cstID=" + cstID + ", date=" + date + ", name=" + name + '}';     
    }
    public String getAsCSV() {
    return cstID + "," + date + "," + name;
    }
}    
//}
    /*public Invoice_Header(int cstID, String date, String name, double Total, ArrayList<Invoice_Line> lines) {
        this.cstID = cstID;
        this.date = date;
        this.name = name;
        this.getTotal();
        this.lines = lines;
    
}*/

    
    
    

   
