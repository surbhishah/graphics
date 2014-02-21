package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;

public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JApplet lineApplet = new LinesApplet();
		lineApplet.init();
		lineApplet.start();
		
		
	}

}
