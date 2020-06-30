package address_book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ModifyPanel extends JPanel implements MouseListener, ActionListener {
	DBConnect DBConnect = new DBConnect();
	private JButton refreshButton = new JButton("새로고침");
	DefaultTableModel model;
	JTable table;
	JScrollPane scroll;
	private JLabel Label = new JLabel("우클릭으로 수정");
	private String[] header = { "이름", "휴대폰번호", "직장", "이메일", "관계" };

	public ModifyPanel() {
		setLayout(null);
		
		this.add(refreshButton);
		refreshButton.setBounds(20, 15, 100, 20);
		refreshButton.addActionListener(this);
		this.add(Label);
		Label.setBounds(130, 15, 100, 20);
		
		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		scroll = new JScrollPane(table);
		scroll.setBounds(20, 50, 760, 300);
		this.add(scroll, null);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(this);

		DBConnect.SelectAllData(table);
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
//		int row = table.getSelectedRow();
//		int column = table.getSelectedColumn();
		String oldCellNumber = (String) table.getValueAt(table.getSelectedRow(), 1);
		if (e.getButton() == 1) {
			AddressDTO adto = DBConnect.SelectData(oldCellNumber);
			new ModifyFrame(adto, oldCellNumber);
			DBConnect.SelectAllData(table);
		}
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DBConnect.SelectAllData(table);
	}
}
