package view;

import java.awt.BorderLayout;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import controller.textDitorController;
import modell.textDitorModel;

public class textEditorView extends JFrame{

	private JTextArea textarea;
	private JFileChooser filechooser;
	
	public textEditorView() {
		setTitle("text editor");
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textarea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textarea);
		add(scrollPane,BorderLayout.CENTER);
		
		JMenuBar menubar = new JMenuBar();
		JMenu fileMenu = new JMenu("file");
		JMenuItem openItem = new JMenuItem("open");
		JMenuItem saveItem = new JMenuItem("save");
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		menubar.add(fileMenu);
		setJMenuBar(menubar);
		
		filechooser = new JFileChooser();
		setVisible(true);

		
	}
	public JTextArea getTextArea() {
		return textarea;
	}
	public JFileChooser getFileChooser() {
		return filechooser;
	}
	
}

