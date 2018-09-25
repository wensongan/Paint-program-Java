import java.awt.Color;
import java.awt.Graphics;
/*Author:Wenson Gan
 * 
 * Date: 4/28/2017
 * 
 * Description:Defines the values and parameters needed to create a fillable shape 
 */
public abstract class FillableShape extends Shape{
    private boolean filled;
    
    // Parameterized constructor method
    public FillableShape(int x1, int x2, int y1, int y2, Color color, boolean filled) {
        super(x1, x2, y1, y2, color);
        setFilled(filled);
    }
    
    //returns filled value
    public boolean getFilled() {
        return filled;
    }
    //returns the lower x value
    public int getUpperLeftX() {
        if (getX1() < getX2()) {
            return getX1();
        }
        else {
            return getX2();
        }
    }
    
    //returns the lower y value
    public int getUpperLeftY() {
        if (getY1() < getY2()) {
            return getY1();
        }
        else {
            return getY2();
        }
    }
    
    //returns the width of shape
    public int getWidth() {
        return Math.abs(getX1()-getX2());
    }
    
    //returns the height of shape
    public int getHeight() {
        return Math.abs(getY1()-getY2());
    }
    
    //Defines the filled value of shape
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}