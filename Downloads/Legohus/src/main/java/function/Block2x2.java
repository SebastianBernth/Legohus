/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

/**
 *
 * @author SebastianBernthJepse
 */
public class Block2x2 implements Block{
    private int width = 2;
    private int length = 2;
    
    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getWidth() {
        return width;
    }
    
}
