package de.tjorven;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;

import javax.swing.*;

public class JEditor {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        FlatOneDarkIJTheme.setup();
        UIManager.setLookAndFeel(new FlatOneDarkIJTheme());
        new EditorFrame();
    }
}
