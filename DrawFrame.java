import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
/*Author:Wenson Gan
 * 
 * Date: 4/28/2017
 * 
 * Description:Defines the values and parameters needed to create a rectangle 
 */ 
public class DrawFrame extends JFrame {
    private JButton colorChooser;
    private JComboBox<String> shapeChooser;
    private JButton undoButton;
    private JButton redoButton;
    private JButton clearButton;
    private String[] shapeNames ={"Line","Oval","Rectangle"};
    private JCheckBox fillBox;
    private JLabel mouseCoordinates;
    
    public DrawFrame(){
        super( "Super Paint Program" );
        
        //Create ToolBar Panel for all buttons
        JPanel toolBarPanel = new JPanel();
        JPanel mouseCoordinatesPanel = new JPanel();
        
        //Create Buttons
        undoButton = new JButton("undo");
        redoButton = new JButton("redo");
        clearButton = new JButton("clear");
        colorChooser = new JButton("color");
        
        //Create mouse coordinate panel
        mouseCoordinates = new JLabel ("(0, 0)");
        mouseCoordinatesPanel.add(mouseCoordinates);
        
        
        //Create JComboBoxes
        shapeChooser = new JComboBox<String>(shapeNames);
        
        //Create CheckBoxes
        fillBox = new JCheckBox("Filled");
        
        //Drop Down for Combo Boxes
        shapeChooser.setMaximumRowCount(3);
        
        //add widgets into the tool bar
        toolBarPanel.add(undoButton);
        toolBarPanel.add(redoButton);
        toolBarPanel.add(clearButton);
        toolBarPanel.add(colorChooser);
        toolBarPanel.add(shapeChooser);
        toolBarPanel.add(fillBox);
        
        DrawPanel drawingPanel = new DrawPanel (mouseCoordinates, undoButton, redoButton, clearButton, fillBox, shapeChooser, colorChooser);
        
        //add ToolBarPanel DrawPanel and MouseCoordinate Panel
        add(toolBarPanel, BorderLayout.NORTH);
        add(mouseCoordinatesPanel, BorderLayout.SOUTH);
        add(drawingPanel, BorderLayout.CENTER);
        

            
            
        
        
        
        
        
    }
}