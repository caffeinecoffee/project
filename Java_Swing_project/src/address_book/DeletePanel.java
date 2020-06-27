package address_book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class DeletePanel extends JPanel implements MouseListener, ActionListener {
	DBConnect DBConnect = new DBConnect();
	private JButton refreshButton = new JButton("새로고침");
	private DefaultTableModel model;
	private JTable searchTable;
	private JScrollPane dataScrollPane;
	private String[] header = { "이름", "휴대폰번호", "직장", "이메일", "관계" };

	public DeletePanel() {
		setLayout(null);

		this.add(refreshButton);
		refreshButton.setBounds(20, 15, 100, 20);
		refreshButton.addActionListener(this);

		model = new DefaultTableModel(header, 0);
		searchTable = new JTable(model);
		dataScrollPane = new JScrollPane(searchTable);
		dataScrollPane.setBounds(20, 50, 760, 300);
		this.add(dataScrollPane, null);

		searchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		searchTable.addMouseListener(this);

		DBConnect.SelectAllData(searchTable);
		this.setBounds(0, 50, 800, 400);
		this.setVisible(false);
	}

	public void Visible(boolean a) {
		if (a) {
			this.setVisible(a);
		} else {
			this.setVisible(a);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getButton() == 1) {
			DBConnect.DeleteData(searchTable);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DBConnect.SelectAllData(searchTable);
	}

}
