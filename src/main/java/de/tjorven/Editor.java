package de.tjorven;

import de.tjorven.listener.KeyListener;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Editor extends JPanel {
    private final JTextArea textArea;
    private boolean saved = true;

    public Editor() {
        setLayout(new BorderLayout());
        textArea = new JTextArea("");
        textArea.setSize(getSize());
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        add(textArea);
        textArea.addKeyListener(new KeyListener(this));
        updateUI();
    }

    public void save() {
        JFileChooser chooser = new JFileChooser(System.getenv("user.dir"));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.showSaveDialog(null);
        File selectedFile = chooser.getSelectedFile();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));
            writer.write(getText());
            writer.flush();
            setSaved(true);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
