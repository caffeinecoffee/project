package address_book;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ModifyPanel extends JPanel implements MouseListener {
	DBConnect DBConnect = new DBConnect();
	DefaultTableModel model;
	JTable table;
	JScrollPane scroll;
	private String[] header = { "�̸�", "�޴�����ȣ", "����", "�̸���", "����" };
	public ModifyPanel() {
		setLayout(null);
		
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
	
	public void Visible (boolean a) {
		if (a) {
			this.setVisible(a);
		}else {
			this.setVisible(a);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String cellNumber = (String) table.getValueAt(table.getSelectedRow(), 1);
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
}
