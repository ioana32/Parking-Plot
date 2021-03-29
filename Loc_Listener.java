import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Loc_Listener implements ActionListener {
	Administrator admin;
	public Loc_Listener(Administrator admin) {
		this.admin=admin;
	}
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob.getClass().getName().endsWith("JButton")) {
			 String component[] = ((JButton)ob).getActionCommand().split(" ");
		        if(((JButton)ob).getText().compareTo("")==0)
		            admin.addMasina(Integer.parseInt(component[0]), Integer.parseInt(component[1]));
		        else
		            admin.stergereMasina(Integer.parseInt(component[0]), Integer.parseInt(component[1]));


		}
	}
}
