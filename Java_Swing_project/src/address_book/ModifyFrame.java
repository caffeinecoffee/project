package address_book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ModifyFrame extends JFrame implements ActionListener {
	AddPanel addPanel = new AddPanel();

	public ModifyFrame(AddressDTO adto, String oldCellNumber) {
		addPanel = new AddPanel(adto, oldCellNumber);
		addPanel.getDataModifyButton().addActionListener(this);
		this.add(addPanel);
		this.setSize(800, 450);
		this.setLocation(600, 225);
		this.setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(addPanel.getDataModifyButton())) {
			dispose();
		}
	}
}
