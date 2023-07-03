package de.tjorven;

import de.tjorven.listener.*;

import javax.swing.*;
import java.awt.*;

public class EditorFrame extends JFrame {
    Editor editor;

    public EditorFrame() {
        super("JEditor");
        setJMenuBar(getJMenuToolbar());
        setSize(new Dimension(600, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        editor = new Editor();
        add(editor);
        addWindowListener(new WindowCloseListener(editor, this));
    }

    public JMenuBar getJMenuToolbar() {
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem save = new JMenuItem("save");
        save.addActionListener(e -> editor.save());
        JMenuItem open = new JMenuItem("open");
        open.addActionListener(new OpenFileListener(editor));
        file.add(open);
        file.add(save);
        bar.add(file);
        return bar;
    }
}
