package de.tjorven.listener;

import de.tjorven.Editor;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowCloseListener extends WindowAdapter {

    private final Editor editor;
    private final JFrame frame;

    public WindowCloseListener(Editor editor, JFrame frame) {
        this.editor = editor;
        this.frame = frame;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (editor.getText() != null) {
            if (editor.isSaved())
                return;
            int option = JOptionPane.showConfirmDialog(null, "Do you want to save?");
            if (option == 0) {
                editor.save();
                frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
            } else if (option == 2 || option == -1) {
                frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
            } else frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        }
        super.windowClosing(e);
    }
}
