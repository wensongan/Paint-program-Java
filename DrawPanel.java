import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/*Author:Wenson Gan
 * 
 * Date: 4/28/2017
 * 
 * Description:Contains draw Panel
 */ 
public class DrawPanel extends JPanel {
    private JButton undoButton;
    private JButton redoButton;
    private JButton clearButton;
    private JButton colorChooser;
    private JCheckBox fillBox;
    private JComboBox<String> shapeChooser;
    private String[] shapeNames ={"Line","Oval","Rectangle"};
    private JPanel mousePanel;
    private JPanel toolBarPanel;
    private JLabel mouseCoordinates;
    private Shape shape = null;
    private int selectedShape =0;
    private int numberOfShapes=0;
    private Color color = Color.BLACK;
    private boolean fillShape;
    private DynamicStack<FillableShape> shapes = new DynamicStack<>();
    private DynamicStack<FillableShape> temporaryShapes = new DynamicStack<>();
    private DynamicStack<FillableShape> undoShapes = new DynamicStack<>();
    private FillableShape currentShape = null;
    private FillableShape drawShape= null;
    public DrawPanel(JLabel mouseCoords, JButton undo,JButton redo,JButton clear,JCheckBox fill,JComboBox shape,JButton color) {
        
        //Catch arguments
        undoButton = undo;
        redoButton = redo;
        clearButton = clear;
        colorChooser = color;
        fillBox = fill;
        shapeChooser = shape;
        mouseCoordinates = mouseCoords;
        
        //Creating a ButtonEventListener object
        ActionListener eventListener = new ButtonEventListener();
        
        //Assign event listener
        colorChooser.addActionListener(eventListener);
        undoButton.addActionListener(eventListener);
        redoButton.addActionListener(eventListener);
        clearButton.addActionListener(eventListener);
        ItemListener lockBoxListener = new CheckBoxEventListener();
        ItemListener comboBoxListener = new ItemListener(){
            @Override
            public void itemStateChanged( ItemEvent e){
                //Assign index of shape
                selectedShape = shapeChooser.getSelectedIndex();
            }
        };
        shapeChooser.addItemListener(comboBoxListener);
        fillBox.addItemListener(lockBoxListener);
        
        //Tool Bar
        toolBarPanel = new JPanel(); 
        toolBarPanel.setLayout( new FlowLayout());
        
        
        
        //Set background Color white
        setBackground(Color.WHITE);
        
        //Event Listener for mouse
        MouseEventListener drawPanelListener = new MouseEventListener();
        addMouseListener(drawPanelListener);
        addMouseMotionListener(drawPanelListener);
      
        

        
        
    } 
    
    class ButtonEventListener implements ActionListener{
        //This method will be called when a button event occurs.
        @Override
        public void actionPerformed(ActionEvent e){
            //Will undo last shape drawn and add to undo dynamic stack
            if (e.getSource()== undoButton){
                if (shapes.size()>0){
                    undoShapes.push(shapes.pop());
                }
                else{
                }
                currentShape=null;
            }
            //Will redo last shape that was undid
            else if (e.getSource()== redoButton){
                if (undoShapes.size()>0){
                    shapes.push(undoShapes.pop());
                }
                else{
                }
            }
            //Clears shapes dynamic stack when pressed
            else if(e.getSource()== clearButton){
                shapes.clear();
                currentShape=null;
            }
            else if(e.getSource() == colorChooser){
                color = JColorChooser.showDialog(null, "Choose a color", color);
            }
            repaint();
        }
    }
    
    
    // Inner class for handling events on lockBox (JCheckBox)
    class CheckBoxEventListener implements ItemListener {
        // We override the itemStateChanged() method as required by the ActionListener Interface
        @Override 
        public void itemStateChanged( ItemEvent e ) {
            // When the user clicks the Filled we enable or disable the filled option
            if ( fillBox.isSelected()) {
                fillShape = true;
            } 
            else {
                fillShape = false;
            }
        }         
    }
    class MouseEventListener extends MouseAdapter {
        public void mouseMoved( MouseEvent event ) {
            //Updates the coordinates of the cursor when the user moves the mouse
            mouseCoordinates.setText( String.format( "(%d, %d)", 
                                             event.getX(), event.getY()  ));
        } 

        public void mousePressed( MouseEvent event ) {
            //Creates a shape on screen to visualize what the shape the user is drawing looks like
            if (shapeChooser.getSelectedIndex() == 0){
                currentShape = new Line( event.getX(), event.getX(), event.getY(), event.getY(), color );
            }
            else if(shapeChooser.getSelectedIndex() ==1){
                currentShape = new Oval( event.getX(), event.getX(), event.getY(), event.getY(), color, fillShape );
            }
            else if(shapeChooser.getSelectedIndex() ==2){
                currentShape = new Rectangle( event.getX(), event.getX(), event.getY(), event.getY(), color, fillShape );
            }
            //JVM calls paintComponent refreshing page
            repaint();
        } 
        

        public void mouseReleased( MouseEvent event){
            //Adds shape to shape dynamic stack and is drawn on screen
            shapes.push(currentShape);
            repaint();
            if (undoShapes.size()>0){
                undoShapes.clear();
            }
        }
        
        
        public void mouseDragged(MouseEvent event){
            //When the mouse is dragged the display of cursor coordinates is updated
            currentShape.setX2( event.getX());
            currentShape.setY2( event.getY());
            mouseCoordinates.setText( String.format( "(%d, %d)", 
                                             event.getX(), event.getY()  ));
            repaint();
        }
    }
    
    @Override
    public void paintComponent (Graphics g){
        //Is called when repaint() is called
        super.paintComponent(g);
        numberOfShapes=shapes.size();

            for(int counter=0;counter<numberOfShapes;counter++){
                temporaryShapes.push(shapes.pop());
            }
            for(int counter=0;counter<numberOfShapes;counter++){
                drawShape= temporaryShapes.pop();
                drawShape.draw(g);
                shapes.push(drawShape);
            }
        if(currentShape != null){
            currentShape.draw(g);
        }
        
            
    }
            
    
} 