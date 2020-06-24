package address_book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DBConnect {
	AddressDTO adto = new AddressDTO();

	private Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			String clname = "oracle.jdbc.driver.OracleDriver";
			Class.forName(clname);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "user2";
		String pw = "SOL";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public int AddData(AddressDTO adto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int cnt = 0;
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement("insert into address values (?,?,?,?,?,?,?,?,?,?)");
				pstmt.setString(1, adto.getName());
				pstmt.setString(2, adto.getCellNumber());
				pstmt.setString(3, adto.getCompany());
				pstmt.setString(4, adto.getEmail());
				pstmt.setString(5, adto.getClassification());
				pstmt.setString(6, adto.getDomicile());
				pstmt.setString(7, adto.getRelation());
				pstmt.setString(8, adto.getMemo());
				pstmt.setString(9, adto.getWebsite());
				pstmt.setString(10, adto.getMessenger());
				cnt = pstmt.executeUpdate();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;
	}

	public void SelectAllData(JTable table) {
		// TODO Auto-generated method stub
		DefaultTableModel dt = (DefaultTableModel) table.getModel();
		dt.setNumRows(0);
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			if (conn != null) {
				pstmt = conn.prepareStatement("select NAME, CELL_NUMBER, COMPANY, EMAIL, RELATION from address");
				rs = pstmt.executeQuery();
				String[] contents = new String[5];
				while (rs.next()) {
					contents[0] = rs.getString("NAME");
					contents[1] = rs.getString("CELL_NUMBER");
					contents[2] = rs.getString("COMPANY");
					contents[3] = rs.getString("EMAIL");
					contents[4] = rs.getString("RELATION");
					dt.addRow(contents);
				}
				table.getColumn("이름").setPreferredWidth(100);
				table.getColumn("휴대폰번호").setPreferredWidth(150);
				table.getColumn("직장").setPreferredWidth(100);
				table.getColumn("이메일").setPreferredWidth(200);
				table.getColumn("관계").setPreferredWidth(100);
				table.getTableHeader().setReorderingAllowed(false);// 이동 불가
				table.getTableHeader().setResizingAllowed(false);// 크기 조절 불가
			}
		} catch (SQLException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void SelectData(JTable table, String name) {
		// TODO Auto-generated method stub
		DefaultTableModel dt = (DefaultTableModel) table.getModel();
		dt.setNumRows(0);
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			if (conn != null) {
				String[] contents = new String[5];
				pstmt = conn.prepareStatement(
						"select NAME, CELL_NUMBER, COMPANY, EMAIL, RELATION from address where name = ?");
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();
				for (int i = 0; rs.next(); i++) {
					contents[0] = rs.getString("NAME");
					contents[1] = rs.getString("CELL_NUMBER");
					contents[2] = rs.getString("COMPANY");
					contents[3] = rs.getString("EMAIL");
					contents[4] = rs.getString("RELATION");
					dt.addRow(contents);
				}
				table.getColumn("이름").setPreferredWidth(100);
				table.getColumn("휴대폰번호").setPreferredWidth(150);
				table.getColumn("직장").setPreferredWidth(100);
				table.getColumn("이메일").setPreferredWidth(200);
				table.getColumn("관계").setPreferredWidth(100);
				table.getTableHeader().setReorderingAllowed(false);// 이동 불가
				table.getTableHeader().setResizingAllowed(false);// 크기 조절 불가
			}
		} catch (SQLException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public int SearchData(String number) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			if (conn != null) {
				pstmt = conn.prepareStatement("select * from address where CELL_NUMBER = ?");
				pstmt.setString(1, number);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					cnt++;
				}
			}
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
		} catch (SQLException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		}
		return cnt;
	}

	public AddressDTO SelectData(String CELL_NUMBER) {
		// TODO Auto-generated method stub
		AddressDTO adto = new AddressDTO();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			if (conn != null) {
				String[] contents = new String[5];
				pstmt = conn.prepareStatement(
						"select NAME, CELL_NUMBER, COMPANY, EMAIL, CLASSIFICATION, DOMICILE, RELATION, MEMO, WEBSITE, MESSENGER from address where CELL_NUMBER = ?");
				pstmt.setString(1, CELL_NUMBER);
				rs = pstmt.executeQuery();
				rs.next();
				adto.setName(rs.getString("NAME"));
				adto.setCellNumber(rs.getString("CELL_NUMBER"));
				adto.setCompany(rs.getString("COMPANY"));
				adto.setEmail(rs.getString("EMAIL"));
				adto.setClassification(rs.getString("CLASSIFICATION"));
				adto.setDomicile(rs.getString("DOMICILE"));
				adto.setRelation(rs.getString("RELATION"));
				adto.setMemo(rs.getString("MEMO"));
				adto.setWebsite(rs.getString("WEBSITE"));
				adto.setMessenger(rs.getString("MESSENGER"));
			}
		} catch (SQLException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return adto;
	}

	public void DeleteData(JTable table) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		int column = table.getSelectedColumn();
		String[] buttons = { "삭제", "취소" };
		int result = JOptionPane.showOptionDialog(null, "?????", null, JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, buttons, "취소");
		if (result == 0) {
			Connection conn = getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement("delete address where CELL_NUMBER=?");
				pstmt.setString(1, (String) table.getValueAt(row, 1));
				rs = pstmt.executeQuery();
			} catch (SQLException ie) {
				// TODO Auto-generated catch block
				ie.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
					if (rs != null)
						rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			SelectAllData(table);
		}
	}

	public void UpdateData(AddressDTO adto) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"update address SET NAME=?, CELL_NUMBER=?, COMPANY=?, EMAIL=?, CLASSIFICATION=?, DOMICILE=?, RELATION=?, MEMO=?, WEBSITE=?, MESSENGER=? where CELL_NUMBER=?");
			pstmt.setString(1, adto.getName());
			pstmt.setString(2, adto.getCellNumber());
			pstmt.setString(3, adto.getCompany());
			pstmt.setString(4, adto.getEmail());
			pstmt.setString(5, adto.getClassification());
			pstmt.setString(6, adto.getDomicile());
			pstmt.setString(7, adto.getRelation());
			pstmt.setString(8, adto.getMemo());
			pstmt.setString(9, adto.getWebsite());
			pstmt.setString(10, adto.getMessenger());
			pstmt.setString(11, adto.getOldCellNumber());
			rs = pstmt.executeQuery();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void DataExport(File filePath) throws IOException, SQLException {
		FileWriter writer = new FileWriter(filePath);
		writer.append(
				"\"성\",\"이름\",\"경칭\",\"중간이름\",\"호칭\",\"닉네임\",\"휴대폰번호\",\"이메일\",\"그룹명\",\"회사번호\",\"집번호\",\"회사Fax번호\",\"집Fax번호\",\"기타번호\",\"전화번호직접입력(전화종류)\",\"전화번호직접입력(번호)\",\"생일\",\"생일(양력음력)\",\"기념일(이름)\",\"기념일(날짜)\",\"회사.소속명\",\"부서명\",\"직책\",\"회사우편번호\",\"회사주소\",\"집우편번호\",\"집주소\",\"기타우편번호\",\"기타주소\",\"주소직접입력(주소이름)\",\"주소직접입력(우편번호)\",\"주소직접입력(주소정보)\",\"홈페이지\",\"메신저 타입\",\"메신저주소\",\"메모\",\"추가휴대폰번호1\",\"추가휴대폰번호2\",\"추가휴대폰번호3\",\"추가회사번호1\",\"추가회사번호2\",\"추가회사번호3\",\"추가집번호1\",\"추가집번호2\",\"추가집번호3\",\"추가회사Fax번호1\",\"추가회사Fax번호2\",\"추가회사Fax번호3\",\"추가집Fax번호1\",\"추가집Fax번호2\",\"추가집Fax번호3\",\"추가기타번호1\",\"추가기타번호2\",\"추가기타번호3\",\"추가이메일1\",\"추가이메일2\",\"추가이메일3\",\"추가홈페이지1\",\"추가홈페이지2\",\"추가홈페이지3\",\"추가그룹명1\",\"추가그룹명2\",\"추가그룹명3\",\n");
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rowCnt = 0;
		if (conn != null) {
			pstmt = conn.prepareStatement("select count(CELL_NUMBER) from address");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rowCnt = rs.getInt(1);
			}
			String[][] contents = new String[rowCnt][10];
			pstmt = conn.prepareStatement(
					"select NAME, CELL_NUMBER, COMPANY, EMAIL, CLASSIFICATION, DOMICILE, RELATION, MEMO, WEBSITE, MESSENGER from address order by name");
			rs = pstmt.executeQuery();
			for (int i = 0; rs.next(); i++) {
				contents[i][0] = rs.getString("NAME");
				contents[i][1] = rs.getString("CELL_NUMBER");
				contents[i][2] = rs.getString("COMPANY");
				contents[i][3] = rs.getString("EMAIL");
				contents[i][4] = rs.getString("CLASSIFICATION");
				contents[i][5] = rs.getString("DOMICILE");
				contents[i][6] = rs.getString("RELATION");
				contents[i][7] = rs.getString("MEMO");
				contents[i][8] = rs.getString("WEBSITE");
				contents[i][9] = rs.getString("MESSENGER");
//				System.out.println(contents[i][0]);
//				System.out.println(contents[i][1]);
//				System.out.println(contents[i][2]);
//				System.out.println(contents[i][3]);
//				System.out.println(contents[i][4]);
//				System.out.println(contents[i][5]);
//				System.out.println(contents[i][6]);
//				System.out.println(contents[i][7]);
//				System.out.println(contents[i][8]);
//				System.out.println(contents[i][9]);
				for (int j = 0; j < 10; j++) {
					if (contents[i][j] == null) {
						contents[i][j] = "";
					}
				}

				writer.append("\"");
				writer.append("\",\"");
				writer.append(contents[i][0]);
				for (int j = 0; j < 3; j++) {
					writer.append("\",\"");
				}
				writer.append(contents[i][6]);
				for (int j = 0; j < 2; j++) {
					writer.append("\",\"");
				}
				writer.append(contents[i][1]);
				for (int j = 0; j < 1; j++) {
					writer.append("\",\"");
				}
				writer.append(contents[i][3]);
				for (int j = 0; j < 1; j++) {
					writer.append("\",\"");
				}
				writer.append(contents[i][4]);
				for (int j = 0; j < 12; j++) {
					writer.append("\",\"");
				}
				writer.append(contents[i][2]);
				for (int j = 0; j < 6; j++) {
					writer.append("\",\"");
				}
				writer.append(contents[i][5]);
				for (int j = 0; j < 6; j++) {
					writer.append("\",\"");
				}
				writer.append(contents[i][8]);
				for (int j = 0; j < 2; j++) {
					writer.append("\",\"");
				}
				writer.append(contents[i][9]);
				for (int j = 0; j < 1; j++) {
					writer.append("\",\"");
				}
				writer.append(contents[i][7]);
				for (int j = 0; j < 27; j++) {
					writer.append("\",\"");
				}
				writer.append("\",");
				writer.append("\n");
			}
			writer.flush();
			writer.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
		}
	}

	public void DataImport(File filePath) throws IOException, SQLException {
		BufferedReader in = new BufferedReader(new FileReader(filePath));
		String line = in.readLine();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		while ((line = in.readLine()) != null) {
			String[] arr = line.split("\",\"");
			arr[0] = arr[0].substring(1);
			int cnt = 0;
			if (!arr[6].equals("") && arr[6] != null && arr[6].length() != 0) {
				if ((arr[0] + arr[1]) != null && !(arr[0] + arr[1]).equals("") && (arr[0] + arr[1]).length() != 0) {
					if (SearchData(arr[6]) == 0) {
						pstmt = conn.prepareStatement("insert into address values (?,?,?,?,?,?,?,?,?,?)");
						pstmt.setString(1, arr[0] + arr[1]);
						pstmt.setString(2, arr[6]);
						pstmt.setString(3, arr[20]);
						pstmt.setString(4, arr[7]);
						pstmt.setString(5, arr[8]);
						pstmt.setString(6, arr[26]);
						pstmt.setString(7, arr[4]);
						pstmt.setString(8, arr[25]);
						pstmt.setString(9, arr[32]);
						pstmt.setString(10, arr[34]);
						cnt = pstmt.executeUpdate();
					}
				}
			}
		}
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
		if (rs != null)
			rs.close();
	}
}