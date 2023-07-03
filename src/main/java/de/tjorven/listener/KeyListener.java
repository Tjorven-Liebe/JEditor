package de.tjorven.listener;

import de.tjorven.Editor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    private final Editor editor;

    public KeyListener(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (!editor.getText().equals(""))
            editor.setSaved(false);
        super.keyTyped(e);
    }

}
