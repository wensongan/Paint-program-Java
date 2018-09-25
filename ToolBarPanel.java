import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ToolBarPanel extends JFrame {
    private JButton undoButton;
    private JButton redoButton;
    private JButton clearButton;
    private JComboBox<String> colorChooser;
    private String[] colorNames = { "Grey", "Red", "Green", "Blue", "White" };
    private Color[] colorValues = { Color.LIGHT_GRAY, Color.RED, Color.GREEN, Color.BLUE, Color.WHITE };
    private JComboBox<String> shapeChooser;
    private String[] shapeNames ={"Line","Oval","Rectangle"};
    
    public ToolBarPanel(){
        super( "SuperPaint");
        setLayout(new FlowLayout());
        //
        //Creating undo button
        undoButton = new JButton("undo");
        //Create ButtonEventListener object
        ActionListener eventListener = new ButtonEventListener();
        //Associate event listenener with undo button
        undoButton.addActionListener(eventListener);
        add(undoButton);
        
        //Creating redo button
        redoButton = new JButton("redo");
        //Associate event listenener with redo button
        redoButton.addActionListener(eventListener);
        add(redoButton);
        
        //Creating clear button
        clearButton = new JButton("clear");
        //Associate event listenener with clear button
        clearButton.addActionListener(eventListener);
        add(clearButton);
        
        //Create a JComboBox, showing 5 values
        colorChooser = new JComboBox<String>(colorNames);
        colorChooser.setMaximumRowCount(5);
        
        //Create a JComboBox, showing 3 values at most
        shapeChooser = new JComboBox<String>(shapeNames);
        shapeChooser.setMaximumRowCount(3);
        
        //Add to regions of the BorderLayout
        
        //Create an ItemListener object that implements the itemStateChanged() method.
        ItemListener comboBoxListener = new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                //Changes the colour of the same being drawn
                getContentPane().setBackground(colorValues[ colorChooser.getSelectedIndex()]);
            }
        };
        colorChooser.addItemListener(comboBoxListener);
        add(colorChooser);
        
        shapeChooser.addItemListener(comboBoxListener);
        add(shapeChooser);
    }
    
    class ButtonEventListener implements ActionListener{
        //This method will be called when a button event occurs.
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getSource()== undoButton){
                System.out.println("undoButton clicked");
            }
            else if (e.getSource()== redoButton){
                System.out.println("redoButton clicked");
            }
            else if(e.getSource()== clearButton){
                System.out.println("clearButton clicked");
            }
        }
    }
}