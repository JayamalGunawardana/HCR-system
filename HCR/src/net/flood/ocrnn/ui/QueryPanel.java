
package net.flood.ocrnn.ui;


import net.flood.ocrnn.*;
import net.flood.ocrnn.util.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class QueryPanel extends JPanel implements CharacterCanvas.DrawListener {
    private MainFrame frame;

    public QueryPanel(MainFrame frame, int width, int height) {
        this.frame = frame;
        setPreferredSize(new Dimension(width, height));
        initComponents();
        initListeners();
        initLayout();
    }

    private void initComponents() {
        charCanvas = new CharacterCanvas();
        charCanvas.setPreferredSize(new Dimension(CHAR_WINDOW_SIZE, CHAR_WINDOW_SIZE));
        charDrawer = new CharacterDrawer();
        charDrawer.setPreferredSize(new Dimension(CHAR_WINDOW_SIZE, CHAR_WINDOW_SIZE));
        clearCanvasButton = new JButton("Clear"); 
        clearCanvasButton.setPreferredSize(new Dimension(CHAR_WINDOW_SIZE, 30));
        inputTitleLabel = new JLabel("INPUT");
        inputTitleLabel.setFont(inputTitleLabel.getFont().deriveFont(Const.TITLE_FONT_SIZE));
        outputTitleLabel = new JLabel("OUTPUT");
        outputTitleLabel.setFont(outputTitleLabel.getFont().deriveFont(Const.TITLE_FONT_SIZE));
        trainButton = new JButton("Train"); 
        trainButton.setPreferredSize(new Dimension(CHAR_WINDOW_SIZE, 30));
        
        
    }

    private void initListeners() {
        clearCanvasButton.addActionListener(e -> charCanvas.clear());
        trainButton.addActionListener(e -> frame.showTrainingContent());
        charCanvas.setDrawListener(this);
    }

    private void initLayout() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGap(20)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(inputTitleLabel)
                                .addComponent(charCanvas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(clearCanvasButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(250)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(outputTitleLabel)
                                .addComponent(charDrawer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                 .addComponent(trainButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                )
                        .addGap(20)
                        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(20)
                        .addGroup(layout.createParallelGroup()
                                .addComponent(inputTitleLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(outputTitleLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                )
                        .addGap(20)
                        .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(charCanvas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(20)
                                        .addComponent(clearCanvasButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(charDrawer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(20)
                                        .addComponent(trainButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                         ))
//                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        
                        .addGap(20));
    }

   
    public void onDrawEnd() {
        Task<CharacterQueryResult> task = NumberIden.query(ImageUtils.deepCopy(charCanvas.getImg()));
        task.setListener(result -> {
            try {
                SwingUtilities.invokeAndWait(() -> {
                    
                    charDrawer.draw(result.getCharacter());

            });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void onDrawStart() {

    }

    private static int CHAR_WINDOW_SIZE = 200;
    private CharacterCanvas charCanvas;
    private CharacterDrawer charDrawer;
    private JButton clearCanvasButton;
    private JLabel inputTitleLabel;
    private JLabel outputTitleLabel;
    private JButton trainButton;
}

