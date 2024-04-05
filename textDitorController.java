package controller;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import modell.textDitorModel;
import view.textEditorView;

public class textDitorController{
    private textEditorView view;
    private textDitorModel model;

    public textDitorController( textEditorView view, textDitorModel model) {
        this.view = view;
        this.model = model;
        view.getFileChooser().setFileSelectionMode(JFileChooser.FILES_ONLY);
        view.getFileChooser().addActionListener(new FileHandler());
    }

    private class FileHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Open")) {
                int returnValue = view.getFileChooser().showOpenDialog(view);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = view.getFileChooser().getSelectedFile();
                    try {
                        String content = model.openFile(file);
                        view.getTextArea().setText(content);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(view, "Error occurred while opening the file.");
                    }
                }
            } else if (e.getActionCommand().equals("Save")) {
                int returnValue = view.getFileChooser().showSaveDialog(view);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = view.getFileChooser().getSelectedFile();
                    try {
                        model.saveFile(file, view.getTextArea().getText());
                        JOptionPane.showMessageDialog(view, "File saved successfully.");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(view, "Error occurred while saving the file.");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
		
		  SwingUtilities.invokeLater(() -> {
			  textDitorModel model = new textDitorModel();
			  textEditorView view = new textEditorView();
	            new textDitorController(view, model);
	        });
	    }
}
