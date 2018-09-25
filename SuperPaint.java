import javax.swing.JFrame;
/*Author:Wenson Gan
 * 
 * Date: 4/28/2017
 * 
 * Description:Test class for SUPER PAINT
 */ 
public class SuperPaint{
    public static void main( String[] args ) {
        //Create drawFrame
        DrawFrame application = new DrawFrame();
        
        //Set size of window and closing functions
        application.setSize( 480, 320 );
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.setVisible( true );
    }    
    
    
}