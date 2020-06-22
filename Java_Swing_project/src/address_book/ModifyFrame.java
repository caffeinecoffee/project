package address_book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;

public class ModifyFrame extends JFrame {
	public ModifyFrame(List<String> list, String oldCellNumber) {
		AddPanel addPanel = new AddPanel(list, oldCellNumber);
		this.add(addPanel);
		this.setSize(800, 450);
		this.setLocation(600, 225);
		this.setResizable(false);
		setVisible(true);
	}
}
