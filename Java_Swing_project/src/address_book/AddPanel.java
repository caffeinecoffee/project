package address_book;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddPanel extends JPanel implements ActionListener {
	DBConnect DBConnect = new DBConnect();
	AddressDTO adto = new AddressDTO();
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
	private JTextField oldCellNumberField = new JTextField();

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

	public AddPanel(AddressDTO adto, String oldCellNumber) {
		setLayout(null);
		nameAddField.setText(adto.getName());
		oldCellNumberField.setText(oldCellNumber);
		String[] number = adto.getCellNumber().split("-");
		cellNumberAddField1.setText(number[0]);
		cellNumberAddField2.setText(number[1]);
		cellNumberAddField3.setText(number[2]);
		companyAddField.setText(adto.getCompany());
		emailAddField.setText(adto.getEmail());
		classificationAddField.setText(adto.getClassification());
		domicileAddField.setText(adto.getDomicile());
		relationAddField.setText(adto.getRelation());
		memoAddTextArea.setText(adto.getMemo());
		websiteAddField.setText(adto.getWebsite());
		messengerAddField.setText(adto.getMessenger());
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
		adto.setName(nameAddField.getText().trim());
		adto.setCellNumber(cellNumberAddField1.getText().trim() + "-" + cellNumberAddField2.getText().trim() + "-"
				+ cellNumberAddField3.getText().trim());
		adto.setCompany(companyAddField.getText().trim());
		adto.setEmail(emailAddField.getText().trim());
		adto.setWebsite(websiteAddField.getText().trim());
		adto.setClassification(classificationAddField.getText().trim());
		adto.setDomicile(domicileAddField.getText().trim());
		adto.setMessenger(messengerAddField.getText().trim());
		adto.setRelation(relationAddField.getText().trim());
		adto.setMemo(memoAddTextArea.getText().trim());
		if (e.getSource().equals(dataAddButton)) {
			if (!adto.getCellNumber().equals("--")) {
				if (adto.getName() != null && !adto.getName().equals("") && adto.getName().length() != 0) {
					if (DBConnect.SearchData(adto.getCellNumber()) == 0) {
						int cnt = DBConnect.AddData(adto);
						if (cnt > 0) {
							dataSuccessArea.setText("데이터 입력 성공.");
						} else {
							dataSuccessArea.setText("데이터 입력 실패.");
						}
					} else {
						dataSuccessArea.setText("전화번호 중복.");
					}
				} else {
					dataSuccessArea.setText("이름이 없습니다.");
				}
			} else {
				dataSuccessArea.setText("전화번호가 없습니다.");
			}
		} else if (e.getSource().equals(dataModifyButton)) {
			adto.setOldCellNumber(oldCellNumberField.getText().trim());
			DBConnect.UpdateData(adto);
		}
	}

	public JButton getDataModifyButton() {
		return dataModifyButton;
	}
}
