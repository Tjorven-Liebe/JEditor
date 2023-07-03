package de.tjorven.listener;

import de.tjorven.Editor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class OpenFileListener implements ActionListener {

    private final Editor editor;
    public OpenFileListener(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File openFile = open();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(openFile));
            StringBuilder text = new StringBuilder();
            reader.lines().forEach(line -> text.append(line).append("\n"));
            editor.getTextArea().setText(text.toString());
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public File open() {
        JFileChooser chooser = new JFileChooser(System.getenv("user.dir"));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.showOpenDialog(null);
        return chooser.getSelectedFile();
    }
}
