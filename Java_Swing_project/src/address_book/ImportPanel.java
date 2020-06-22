package address_book;

import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JPanel;

public class ImportPanel extends JPanel implements DropTargetListener {
	DBConnect DBConnect = new DBConnect();
	public ImportPanel() {
		this.setBounds(0, 50, 400, 400);
		this.setVisible(true);
		DropTarget DropPImport = new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, this, true, null);
	}

	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
		this.setBackground(new Color(100, 0, 0, 25));
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
	}

	@Override
	public void dragExit(DropTargetEvent dte) {
		// TODO Auto-generated method stub
		this.setBackground(new Color(255, 255, 255, 255));
	}

	@Override
	public void drop(DropTargetDropEvent dtde) {
		// TODO Auto-generated method stub
		this.setBackground(new Color(255, 255, 255, 255));
		System.out.println("임포트");

		if ((dtde.getDropAction() & DnDConstants.ACTION_COPY_OR_MOVE) != 0) {
			dtde.acceptDrop(dtde.getDropAction());
			Transferable tr = dtde.getTransferable();
			try {
				java.util.List list = (java.util.List) tr.getTransferData(DataFlavor.javaFileListFlavor);
				File FilePath = new File("" + list.get(0));
				DBConnect.DataImport(FilePath);
			} catch (UnsupportedFlavorException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
