package romejanic.clip.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class QuickLinksWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = 5071338148081597945L;
	
	JLabel desc1 = new JLabel("Quicks links allow you to");
	JLabel desc2 = new JLabel("easily enter a file name at");
	JLabel desc3 = new JLabel("the directory you want. Just");
	JLabel desc4 = new JLabel("click a link to insert it!");
	
	private static JButton desktop = new JButton("Desktop");

	public QuickLinksWindow(){
		
		super("Quick Links"); setBounds(300, 300, 150, 400); setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container con = getContentPane(); JPanel pane = new JPanel(); con.add(pane);
		
		pane.add(desc1);
		pane.add(desc2);
		pane.add(desc3);
		pane.add(desc4);
		pane.add(func_120020_c());
		
		setVisible(true); setResizable(false);
		
	}
	
    private static JComponent func_120020_c()
    {
        JPanel var1 = new JPanel();
        
        var1.add(desktop);
        
        JScrollPane var2 = new JScrollPane(var1, 22, 30);
        var2.setBorder(new TitledBorder(new EtchedBorder(), "Quick Links"));
        return var2;
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
