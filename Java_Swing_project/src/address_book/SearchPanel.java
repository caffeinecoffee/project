package address_book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SearchPanel extends JPanel implements ActionListener {
	// 검색, 추가, 수정, 삭제
	// 임포트, 익스포트 드래그 앤 드롭 액션
	// 이름, 휴대폰번호, 직장, 이메일, 그룹, 주소, 관계, 메모, 웹사이트, 메신저 계정()
	// 부분검색 기능 구현
	DBConnect DBConnect = new DBConnect();
	private JButton dataSearchButton = new JButton("검색");
	private JTextField searchField = new JTextField(20);
	private DefaultTableModel model;
	private JTable searchTable;
	private JScrollPane dataScrollPane;
	private String[] header = { "이름", "휴대폰번호", "직장", "이메일", "관계" };

	public SearchPanel() {
		setLayout(null);
		
		this.add(searchField);
		searchField.setBounds(20, 15, 150, 20);
		this.add(dataSearchButton);
		dataSearchButton.setBounds(180, 15, 60, 20);
		dataSearchButton.addActionListener(this);

		model = new DefaultTableModel(header, 0);
		searchTable = new JTable(model);
		dataScrollPane = new JScrollPane(searchTable);
		dataScrollPane.setBounds(20, 50, 760, 300);
		this.add(dataScrollPane, null);
		
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
	public void actionPerformed(ActionEvent e) {
		String name = searchField.getText().trim();
		if (name == null || name.equals("")) {
			DBConnect.SelectAllData(searchTable);
		} else {
			DBConnect.SelectData(searchTable, name);
		}
	}
}
