import java.awt.Color;
import java.awt.Graphics;
/*Author:Wenson Gan
 * 
 * Date: 4/28/2017
 * 
 * Description:Defines the values and parameters needed to create a rectangle 
 */
public class Line extends FillableShape{
    
    //Create line object
    public Line(int x1, int x2, int y1, int y2, Color color){
        super(x1, x2, y1, y2, color, false);
    }
       
    //Draws line object
    public void draw( Graphics g){
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }
    
}
