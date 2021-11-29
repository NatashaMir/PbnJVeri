package io.github.natashamir.pbn_project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class PbnDialog extends Dialog {
    public PbnDialog(
            Frame oParent,
            String oHeader,
            String oText) {
        super(oParent, oHeader, true);

        Panel lPanel = new Panel();
        int NrLines;
        int Index;

        for (NrLines = 0; ; NrLines++) {
            Index = oText.indexOf("\n");
            if (Index < 0) {
                lPanel.add(new Label(oText));
                break;
            }
            lPanel.add(new Label(oText.substring(0, Index)));
            oText = oText.substring(Index + 1);
        }
        add(lPanel, "Center");

        Button mOk = new Button("OK");
        lPanel = new Panel();
        lPanel.add(mOk);
        add(lPanel, "South");

        mOk.addActionListener(new ActionListener() {
                                  public void actionPerformed(
                                          ActionEvent evt) {
                                      setVisible(false);
                                  }
                              }
        );

        addWindowListener(new WindowAdapter() {
                              public void windowClosing(
                                      WindowEvent evt) {
                                  setVisible(false);
                              }
                          }
        );

        setLocation(150, 150);
        setSize(300, 120 + NrLines * 30);
        show();
    }
}
