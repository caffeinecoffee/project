package address_book;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Address extends JFrame implements ActionListener {
	private ButtonPanel buttonPanel = new ButtonPanel();
	SearchPanel searchPanel = new SearchPanel();
	AddPanel addPanel = new AddPanel();
	ModifyPanel modifyPanel = new ModifyPanel();
	DeletePanel deletePanel = new DeletePanel();
	ImportPanel importPanel = new ImportPanel();
	ExportPanel exportPanel = new ExportPanel();

	public Address() {
		setLayout(null);
		this.add(buttonPanel);
		this.add(searchPanel);
		this.add(addPanel);
		this.add(modifyPanel);
		this.add(deletePanel);
		this.add(importPanel);
		this.add(exportPanel);

		buttonPanel.getSearchButton().addActionListener(this);
		buttonPanel.getAddButton().addActionListener(this);
		buttonPanel.getModifyButton().addActionListener(this);
		buttonPanel.getDeleteButton().addActionListener(this);
		buttonPanel.getImpExpButton().addActionListener(this);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(800, 450);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(buttonPanel.getSearchButton())) {
			searchPanel.Visible(true);
			addPanel.Visible(false);
			modifyPanel.Visible(false);
			deletePanel.Visible(false);
			importPanel.Visible(false);
			exportPanel.Visible(false);
		} else if (e.getSource().equals(buttonPanel.getAddButton())) {
			searchPanel.Visible(false);
			addPanel.Visible(true);
			modifyPanel.Visible(false);
			deletePanel.Visible(false);
			importPanel.Visible(false);
			exportPanel.Visible(false);
		} else if (e.getSource().equals(buttonPanel.getModifyButton())) {
			searchPanel.Visible(false);
			addPanel.Visible(false);
			modifyPanel.Visible(true);
			deletePanel.Visible(false);
			importPanel.Visible(false);
			exportPanel.Visible(false);
		} else if (e.getSource().equals(buttonPanel.getDeleteButton())) {
			searchPanel.Visible(false);
			addPanel.Visible(false);
			modifyPanel.Visible(false);
			deletePanel.Visible(true);
			importPanel.Visible(false);
			exportPanel.Visible(false);
		} else if (e.getSource().equals(buttonPanel.getImpExpButton())) {
			searchPanel.Visible(false);
			addPanel.Visible(false);
			modifyPanel.Visible(false);
			deletePanel.Visible(false);
			importPanel.Visible(true);
			exportPanel.Visible(true);
		}
	}

	public static void main(String[] args) {
		new Address();
	}
}
