package address_book;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	private JButton searchButton = new JButton("검색");
	private JButton addButton = new JButton("추가");
	private JButton modifyButton = new JButton("수정");
	private JButton deleteButton = new JButton("삭제");
	private JButton ImpExpButton = new JButton("임포트 / 익스포트");

	public JButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getModifyButton() {
		return modifyButton;
	}

	public void setModifyButton(JButton modifyButton) {
		this.modifyButton = modifyButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	public JButton getImpExpButton() {
		return ImpExpButton;
	}

	public void setImpExpButton(JButton impExpButton) {
		ImpExpButton = impExpButton;
	}

	public ButtonPanel() {
		this.add(searchButton);
		this.add(addButton);
		this.add(modifyButton);
		this.add(deleteButton);
		this.add(ImpExpButton);
		this.setBounds(0, 0, 800, 50);
		this.setVisible(true);
	}
}
