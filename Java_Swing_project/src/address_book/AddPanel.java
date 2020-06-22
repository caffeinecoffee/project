package address_book;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddPanel extends JPanel implements ActionListener {
	// 입력 길이 제한, 전화번호 숫자만 입력(입력 데이터 타입 제한), 데이터 추가 성공 or 실패 출력, 키값 중복 확인
	// 전화번호가 같은 데이터가 입력되면 수정할지 기존 데이터 유지할지 선택
	DBConnect DBConnect = new DBConnect();
	private Font font = new Font("돋움", Font.BOLD, 20);
	private Font successFont = new Font("돋움", Font.BOLD, 30);
	private JLabel nameAddLabel = new JLabel("이름");
	private JTextField nameAddField = new JTextField();
	private JLabel cellNumberAddLabel = new JLabel("전화번호");
	private JLabel cellNumberAddLabel1 = new JLabel("-");
	private JLabel cellNumberAddLabel2 = new JLabel("-");
	private JTextField cellNumberAddField1 = new JTextField();
	private JTextField cellNumberAddField2 = new JTextField();
	private JTextField cellNumberAddField3 = new JTextField();
	private JLabel companyAddLabel = new JLabel("회사");
	private JTextField companyAddField = new JTextField();
	private JLabel emailAddLabel = new JLabel("메일");
	private JTextField emailAddField = new JTextField();
	private JLabel websiteAddLabel = new JLabel("웹사이트");
	private JTextField websiteAddField = new JTextField();
	private JLabel classificationAddLabel = new JLabel("그룹");
	private JTextField classificationAddField = new JTextField();
	private JLabel domicileAddLabel = new JLabel("주소");
	private JTextField domicileAddField = new JTextField();
	private JLabel messengerAddLabel = new JLabel("메신저");
	private JTextField messengerAddField = new JTextField();
	private JLabel relationAddLabel = new JLabel("호칭");
	private JTextField relationAddField = new JTextField();
	private JLabel memoAddLabel = new JLabel("메모");
	private JTextArea memoAddTextArea = new JTextArea();

	private JTextArea dataSuccessArea = new JTextArea();
	private JButton dataAddButton = new JButton("데이터 추가");
	private JButton dataModifyButton = new JButton("데이터 수정");
	private JTextField oldCellNumberField = new JTextField();;

	public AddPanel() {
		setLayout(null);
		this.add(nameAddLabel);
		this.add(nameAddField);
		this.add(cellNumberAddLabel);
		this.add(cellNumberAddLabel1);
		this.add(cellNumberAddLabel2);
		this.add(cellNumberAddField1);
		this.add(cellNumberAddField2);
		this.add(cellNumberAddField3);
		this.add(companyAddLabel);
		this.add(companyAddField);
		this.add(emailAddLabel);
		this.add(emailAddField);
		this.add(websiteAddLabel);
		this.add(websiteAddField);
		this.add(classificationAddLabel);
		this.add(classificationAddField);
		this.add(domicileAddLabel);
		this.add(domicileAddField);
		this.add(messengerAddLabel);
		this.add(messengerAddField);
		this.add(relationAddLabel);
		this.add(relationAddField);
		this.add(memoAddLabel);
		this.add(memoAddTextArea);
		this.add(dataSuccessArea);
		this.add(dataAddButton);

		// Label, Field, Area 위치 조정
		nameAddLabel.setBounds(15, 15, 50, 40);
		nameAddField.setBounds(75, 20, 150, 30);
		cellNumberAddLabel.setBounds(243, 15, 100, 40);
		cellNumberAddField1.setBounds(343, 20, 40, 30);
		cellNumberAddLabel2.setBounds(388, 15, 100, 40);
		cellNumberAddField2.setBounds(403, 20, 55, 30);
		cellNumberAddLabel1.setBounds(463, 15, 100, 40);
		cellNumberAddField3.setBounds(478, 20, 55, 30);
		companyAddLabel.setBounds(545, 15, 50, 40);
		companyAddField.setBounds(595, 20, 150, 30);

		emailAddLabel.setBounds(15, 70, 50, 40);
		emailAddField.setBounds(75, 75, 150, 30);
		websiteAddLabel.setBounds(243, 70, 100, 40);
		websiteAddField.setBounds(343, 75, 150, 30);
		classificationAddLabel.setBounds(545, 70, 50, 40);
		classificationAddField.setBounds(595, 75, 150, 30);

		domicileAddLabel.setBounds(15, 130, 50, 40);
		domicileAddField.setBounds(75, 135, 150, 30);
		messengerAddLabel.setBounds(243, 130, 100, 40);
		messengerAddField.setBounds(343, 135, 150, 30);
		relationAddLabel.setBounds(545, 130, 50, 40);
		relationAddField.setBounds(595, 135, 150, 30);

		memoAddLabel.setBounds(15, 190, 50, 40);
		memoAddTextArea.setBounds(75, 195, 670, 100);

		dataSuccessArea.setBounds(165, 310, 400, 40);
		dataAddButton.setBounds(595, 310, 150, 40);

		nameAddLabel.setFont(font);
		nameAddField.setFont(font);
		cellNumberAddLabel.setFont(font);
		cellNumberAddLabel1.setFont(font);
		cellNumberAddLabel2.setFont(font);
		cellNumberAddField1.setFont(font);
		cellNumberAddField2.setFont(font);
		cellNumberAddField3.setFont(font);
		companyAddLabel.setFont(font);
		companyAddField.setFont(font);
		emailAddLabel.setFont(font);
		emailAddField.setFont(font);
		websiteAddLabel.setFont(font);
		websiteAddField.setFont(font);
		classificationAddLabel.setFont(font);
		classificationAddField.setFont(font);
		domicileAddLabel.setFont(font);
		domicileAddField.setFont(font);
		messengerAddLabel.setFont(font);
		messengerAddField.setFont(font);
		relationAddLabel.setFont(font);
		relationAddField.setFont(font);
		memoAddLabel.setFont(font);
		memoAddTextArea.setFont(font);
		dataSuccessArea.setFont(successFont);
		dataAddButton.setFont(font);

		dataAddButton.addActionListener(this);

		this.setBounds(0, 50, 800, 400);
		this.setVisible(false);
	}

	public AddPanel(List<String> list, String oldCellNumber) {
		setLayout(null);
		nameAddField.setText(list.get(0));
		oldCellNumberField.setText(oldCellNumber);
		String[] number = list.get(1).split("-");
		cellNumberAddField1.setText(number[0]);
		cellNumberAddField2.setText(number[1]);
		cellNumberAddField3.setText(number[2]);
		companyAddField.setText(list.get(2));
		emailAddField.setText(list.get(3));
		classificationAddField.setText(list.get(4));
		domicileAddField.setText(list.get(5));
		relationAddField.setText(list.get(6));
		memoAddTextArea.setText(list.get(7));
		websiteAddField.setText(list.get(8));
		messengerAddField.setText(list.get(9));
		this.add(nameAddLabel);
		this.add(nameAddField);
		this.add(cellNumberAddLabel);
		this.add(cellNumberAddLabel1);
		this.add(cellNumberAddLabel2);
		this.add(cellNumberAddField1);
		this.add(cellNumberAddField2);
		this.add(cellNumberAddField3);
		this.add(companyAddLabel);
		this.add(companyAddField);
		this.add(emailAddLabel);
		this.add(emailAddField);
		this.add(websiteAddLabel);
		this.add(websiteAddField);
		this.add(classificationAddLabel);
		this.add(classificationAddField);
		this.add(domicileAddLabel);
		this.add(domicileAddField);
		this.add(messengerAddLabel);
		this.add(messengerAddField);
		this.add(relationAddLabel);
		this.add(relationAddField);
		this.add(memoAddLabel);
		this.add(memoAddTextArea);
		this.add(dataSuccessArea);
		this.add(dataModifyButton);

		// Label, Field, Area 위치 조정
		nameAddLabel.setBounds(15, 15, 50, 40);
		nameAddField.setBounds(75, 20, 150, 30);
		cellNumberAddLabel.setBounds(243, 15, 100, 40);
		cellNumberAddField1.setBounds(343, 20, 40, 30);
		cellNumberAddLabel2.setBounds(388, 15, 100, 40);
		cellNumberAddField2.setBounds(403, 20, 55, 30);
		cellNumberAddLabel1.setBounds(463, 15, 100, 40);
		cellNumberAddField3.setBounds(478, 20, 55, 30);
		companyAddLabel.setBounds(545, 15, 50, 40);
		companyAddField.setBounds(595, 20, 150, 30);

		emailAddLabel.setBounds(15, 70, 50, 40);
		emailAddField.setBounds(75, 75, 150, 30);
		websiteAddLabel.setBounds(243, 70, 100, 40);
		websiteAddField.setBounds(343, 75, 150, 30);
		classificationAddLabel.setBounds(545, 70, 50, 40);
		classificationAddField.setBounds(595, 75, 150, 30);

		domicileAddLabel.setBounds(15, 130, 50, 40);
		domicileAddField.setBounds(75, 135, 150, 30);
		messengerAddLabel.setBounds(243, 130, 100, 40);
		messengerAddField.setBounds(343, 135, 150, 30);
		relationAddLabel.setBounds(545, 130, 50, 40);
		relationAddField.setBounds(595, 135, 150, 30);

		memoAddLabel.setBounds(15, 190, 50, 40);
		memoAddTextArea.setBounds(75, 195, 670, 100);

		dataSuccessArea.setBounds(165, 310, 400, 40);
		dataModifyButton.setBounds(595, 310, 150, 40);

		nameAddLabel.setFont(font);
		nameAddField.setFont(font);
		cellNumberAddLabel.setFont(font);
		cellNumberAddLabel1.setFont(font);
		cellNumberAddLabel2.setFont(font);
		cellNumberAddField1.setFont(font);
		cellNumberAddField2.setFont(font);
		cellNumberAddField3.setFont(font);
		companyAddLabel.setFont(font);
		companyAddField.setFont(font);
		emailAddLabel.setFont(font);
		emailAddField.setFont(font);
		websiteAddLabel.setFont(font);
		websiteAddField.setFont(font);
		classificationAddLabel.setFont(font);
		classificationAddField.setFont(font);
		domicileAddLabel.setFont(font);
		domicileAddField.setFont(font);
		messengerAddLabel.setFont(font);
		messengerAddField.setFont(font);
		relationAddLabel.setFont(font);
		relationAddField.setFont(font);
		memoAddLabel.setFont(font);
		memoAddTextArea.setFont(font);
		dataSuccessArea.setFont(successFont);
		dataModifyButton.setFont(font);

		dataModifyButton.addActionListener(this);

		this.setBounds(0, 50, 600, 400);
		this.setVisible(true);
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
		// TODO Auto-generated method stub
		if (e.getSource().equals(dataAddButton)) {
			try {
				int cnt = DBConnect.AddData(nameAddField.getText().trim(),
						cellNumberAddField1.getText().trim() + "-" + cellNumberAddField2.getText().trim() + "-"
								+ cellNumberAddField3.getText().trim(),
						companyAddField.getText().trim(), emailAddField.getText().trim(),
						websiteAddField.getText().trim(), classificationAddField.getText().trim(),
						domicileAddField.getText().trim(), messengerAddField.getText().trim(),
						relationAddField.getText().trim(), memoAddTextArea.getText().trim());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(dataModifyButton)) {
			DBConnect.UpdateData(nameAddField.getText().trim(), oldCellNumberField.getText().trim(),
					cellNumberAddField1.getText().trim() + "-" + cellNumberAddField2.getText().trim() + "-"
							+ cellNumberAddField3.getText().trim(),
					companyAddField.getText().trim(), emailAddField.getText().trim(), websiteAddField.getText().trim(),
					classificationAddField.getText().trim(), domicileAddField.getText().trim(),
					messengerAddField.getText().trim(), relationAddField.getText().trim(),
					memoAddTextArea.getText().trim());
		}
	}

	public JButton getDataModifyButton() {
		return dataModifyButton;
	}
}
