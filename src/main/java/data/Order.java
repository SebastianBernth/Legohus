/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author SebastianBernthJepse
 */
public class Order {
    private String email;
    private int height;
    private int length;
    private int width;
    private int block2x1;
    private int block2x2;
    private int block2x4;
    private int orderId;
    private boolean shipped;

    public Order(String email, int height, int length, int width, int brick2x1, int brick2x2, int brick2x4, int orderId, boolean shipped) {
        this.email = email;
        this.height = height;
        this.length = length;
        this.width = width;
        this.block2x1 = brick2x1;
        this.block2x2 = brick2x2;
        this.block2x4 = brick2x4;
        this.orderId = orderId;
        this.shipped = shipped;
    }
    
    public String getEmail() {
        return email;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getBrick2x1() {
        return block2x1;
    }

    public int getBrick2x2() {
        return block2x2;
    }

    public int getBrick2x4() {
        return block2x4;
    }

    public int getOrderId() {
        return orderId;
    }

    public boolean isShipped() {
        return shipped;
    }
}
