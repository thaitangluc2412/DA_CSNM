package menu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SSCCE extends JPanel
{
    public SSCCE()
    {
        JTable table = new JTable(15, 5);
        add( new JScrollPane(table) );

        table.addMouseListener( new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                JTable source = (JTable)e.getSource();
                int row = source.rowAtPoint( e.getPoint() );
                int column = source.columnAtPoint( e.getPoint() );
                System.out.println(row + " " + column);
                if (! source.isRowSelected(row))
                    source.changeSelection(row, column, false, false);
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SSCCE(), BorderLayout.NORTH);
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}