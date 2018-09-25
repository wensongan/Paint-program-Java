import java.awt.Color;
import java.awt.Graphics;
/*Author:Wenson Gan
 * 
 * Date: 4/28/2017
 * 
 * Description:Defines the abstract classes and values for shapes 
 */
public abstract class Shape {
    private Color color;
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    // Parameterized constructor method
    public Shape(int x1, int x2, int y1, int y2, Color color) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color;
    }
    
    //Returns x1 value
    public int getX1() {
        return x1;
    }

    //Returns x2 value
    public int getX2() {
        return x2;
    }
    
    //Returns y1 value
    public int getY1() {
        return y1;
    }
    
    //Returns y2 value
    public int getY2() {
        return y2;
    }
    
    //Returns color value
    public Color getColor() {
        return color;
    }
    
    //Modifies x1 value
    public void setX1(int newX1) {
        if (newX1 < 0) {
            System.err.println("invalid coordinate, value set to 0");
            x1 = 0;
        }
        else {
            x1 = newX1;
        }
    }
    
    //Modifies x2 value
    public void setX2(int newX2) {
        if (newX2 < 0) {
            System.err.println("invalid coordinate, value set to 0");
            x2 = 0;
        }
        else {
            x2 = newX2;
        }
    }
    
    //Modifies y1 value
    public void setY1(int newY1) {
        if (newY1 < 0) {
            System.err.println("invalid coordinate, value set to 0");
            y1 = 0;
        }
        else {
            y1 = newY1;
        }
    }
    
    //Modifies y2 value
    public void setY2(int newY2) {
        if (newY2 < 0) {
            System.err.println("invalid coordinate, value set to 0");
            y2 = 0;
        }
        else {
            y2 = newY2;
        }
    }
    
    //Modifies color value
    public void setColor(Color newColor) {
        color = newColor;
    }
    
    //Draws shape
    public abstract void draw( Graphics g );
}