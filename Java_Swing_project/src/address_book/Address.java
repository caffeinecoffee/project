package address_book;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Address extends JFrame implements ActionListener {
	//데이터 추가되었을 때 알림창
	//데이터 추가되고 필드 정리
	//not null값이 null일때 알림창 띄우고 데이터베이스 연결 안함
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
		} else if (e.getSource().equals(buttonPanel.getAddButton())) {
			searchPanel.Visible(false);
			addPanel.Visible(true);
			modifyPanel.Visible(false);
			deletePanel.Visible(false);
		} else if (e.getSource().equals(buttonPanel.getModifyButton())) {
			searchPanel.Visible(false);
			addPanel.Visible(false);
			modifyPanel.Visible(true);
			deletePanel.Visible(false);
		} else if (e.getSource().equals(buttonPanel.getDeleteButton())) {
			searchPanel.Visible(false);
			addPanel.Visible(false);
			modifyPanel.Visible(false);
			deletePanel.Visible(true);
		}
	}

	public static void main(String[] args) {
		new Address();
	}
}
