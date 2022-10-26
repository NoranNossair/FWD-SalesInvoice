/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Noran Nossair
 */
public class Invoice_Line {
    
            private String product;
            private double price;
            private int count;
            private Invoice_Header inv;

    public Invoice_Line(String product, double price, int count, Invoice_Header inv) {
        this.product = product;
        this.price = price;
        this.count = count;
        this.inv = inv;
    }
    public double getTotal(){
        return count*price;
    }

    public Invoice_Header getInv() {
        return inv;
    }

    public void setInv(Invoice_Header inv) {
        this.inv = inv;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Invoice_Line{" + "num=" + inv.getCstID()+ "product=" + product + ", price=" + price + ", count=" + count + '}';
    }
            
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
               
    
}
