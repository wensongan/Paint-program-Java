import java.awt.Color;
import java.awt.Graphics;
/*Author:Wenson Gan
 * 
 * Date: 4/28/2017
 * 
 * Description:Defines the values and parameters needed to create a rectangle 
 */
public class Rectangle extends FillableShape{
    
    //Create Rectangle object
    public Rectangle(int x1, int x2, int y1, int y2, Color color, boolean filled){
        super(x1, x2, y1, y2, color, filled);
    }
       
    //Draws Rectangle object
    public void draw( Graphics g){
        g.setColor(getColor());
        if (getFilled()){
            g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
        else{
            g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
                
    }
}