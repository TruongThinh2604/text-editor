package modell;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class textDitorModel {
	    private File currentFile;

	    public String openFile(File file) throws IOException {
	        currentFile = file;
	        StringBuilder content = new StringBuilder();
	        try (BufferedReader reader = new BufferedReader(new FileReader(currentFile))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                content.append(line).append("\n");
	            }
	        }
	        return content.toString();
	    }
	    public void saveFile(File file, String content) throws IOException {
	        currentFile = file;
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))) {
	            writer.write(content);
	        }
	    }
	}


