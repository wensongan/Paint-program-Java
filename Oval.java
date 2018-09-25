import java.awt.Color;
import java.awt.Graphics;
/*Author: wenson gan
 * 
 * Date = 2016/11/28
 * 
 * 
 * Description:creates an oval object
*/

public class Oval extends FillableShape {
    
    //Create Oval object
    public Oval(int x1, int x2, int y1, int y2, Color color, boolean filled){
        super(x1, x2, y1, y2, color, filled);
    }
       
    //Draws Oval object
    public void draw(Graphics g){
        g.setColor(getColor());
        if (getFilled()){
            g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
        else{
            g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
                
    }
}
