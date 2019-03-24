package function;

/**
 *
 * @author SebastianBernthJepse
 */
public class Block2x1 implements Block{
    private int length = 1;
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
