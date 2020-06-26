package address_book;

import java.awt.Graphics;
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
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImportPanel extends JPanel implements DropTargetListener {
	DBConnect DBConnect = new DBConnect();
	ImageIcon icon = new ImageIcon("./img/1234.png");
	ImageIcon bubble = new ImageIcon("./img/speech_bubble_Import.png");

	public ImportPanel() {
		this.setBounds(0, 50, 400, 400);
		this.setVisible(false);
		DropTarget DropPImport = new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, this, true, null);
	}

	public void paint(Graphics g) {
		g.drawImage(icon.getImage(), 0, 125, null);
		g.drawImage(bubble.getImage(), 125, 40, null);
		setOpaque(false);
		super.paint(g);
	}

	public void Visible(boolean a) {
		if (a) {
			this.setVisible(a);
		} else {
			this.setVisible(a);
		}
	}

	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
	}

	@Override
	public void dragExit(DropTargetEvent dte) {
		// TODO Auto-generated method stub
	}

	@Override
	public void drop(DropTargetDropEvent dtde) {
		// TODO Auto-generated method stub
		if ((dtde.getDropAction() & DnDConstants.ACTION_COPY_OR_MOVE) != 0) {
			dtde.acceptDrop(dtde.getDropAction());
			Transferable tr = dtde.getTransferable();
			try {
				List list = (List) tr.getTransferData(DataFlavor.javaFileListFlavor);
				for (int i = 0; i < list.size(); i++) {
					File FilePath = new File("" + list.get(i));
					DBConnect.DataImport(FilePath);
				}
			} catch (UnsupportedFlavorException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
