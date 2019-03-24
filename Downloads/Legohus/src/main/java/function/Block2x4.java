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
public class Block2x4 implements Block{
    private int length = 4;
    private int width = 2;
    
    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getWidth() {
        return width;
    }
    
}
