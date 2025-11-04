package dev.jkit.ionview;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.RenderingMode;
import com.teamdev.jxbrowser.view.swing.BrowserView;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Create Chromium engine (hardware accelerated)
        Engine engine = Engine.newInstance(
                RenderingMode.HARDWARE_ACCELERATED
        );

        // Create a browser instance
        Browser browser = engine.newBrowser();

        browser.navigation().loadUrl("https://www.google.com");

        SwingUtilities.invokeLater(() -> {
            BrowserView view = BrowserView.newInstance(browser);

            JFrame frame = new JFrame("JxBrowser Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(1024, 720);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            frame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    engine.close();
                }
            });
        });
    }
}


