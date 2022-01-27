import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paint extends JFrame{
    private final JComboBox<String> comboBox;
    private int x,y;
    private static final String[] STRINGS = {"Black", "Red", "Blue", "Green","Whitw"};
    private static final Color[] COLORS = {Color.BLACK, Color.RED, Color.BLUE,Color.GREEN,Color.WHITE};

    public Paint(){

        super("Paint");

        setLayout(new BorderLayout());

        JTextField nameDisp = new JTextField("BLACK"); // By  Default Selected Color will be Black
        nameDisp.setFont(new Font(null,Font.PLAIN,20));

        comboBox = new JComboBox<>(STRINGS);
        comboBox.setMaximumRowCount(3);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(nameDisp,BorderLayout.NORTH);
        c.add(comboBox,BorderLayout.SOUTH);
        c.add(new JLabel("Drag Mouse to Draw!",JLabel.CENTER));
        c.setVisible(true);
        comboBox.addItemListener(
            new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED){
                        nameDisp.setForeground(COLORS[comboBox.getSelectedIndex()]);
                        nameDisp.setText((String) comboBox.getSelectedItem());
                    }
                }
            }
        );

        c.addMouseMotionListener(
            new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    x = e.getX();
                    y = e.getY();
                    repaint();
                }
            }
        );
    }
    public void paint(Graphics graphics){
        graphics.setColor(COLORS[comboBox.getSelectedIndex()]);
        graphics.fillRect(x,y,10,10);
    }
}
