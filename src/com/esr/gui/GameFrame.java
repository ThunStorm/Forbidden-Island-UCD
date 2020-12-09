package com.esr.gui;

import com.esr.gui.updater.UpdaterAgent;
import com.esr.service.game.GameData;
import com.esr.service.game.component.adventurer.*;
import com.esr.gui.console.ConsolePanel;
import com.esr.gui.game.GamePanel;
import com.esr.gui.updater.LogAgent;
import com.esr.utils.CommonUtils;
import com.esr.utils.Constant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;


public class GameFrame extends JFrame {

//    public Subject subject;
    private GamePanel gamePanel;
    private ConsolePanel consolePanel;
    private JPanel jGamePanel;
    private Box consoleBoxPanel;

    public GameFrame(String title) throws HeadlessException {
        super(title);
        //Dimension frameSize = new Dimension(Constant.FRAME_WIDTH,Constant.FRAME_HEIGHT);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int screenWidth = toolkit.getScreenSize().width;
        int screenHeight = toolkit.getScreenSize().height;
        this.setResizable(false);

        this.setLayout(new BorderLayout(5, 5));
        this.setBounds((screenWidth - Constant.FRAME_WIDTH) / 2, (screenHeight - Constant.FRAME_HEIGHT) / 2, Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT);

        Init();
//        test();
    }

    public void Init(){
        LogAgent logAgent = new LogAgent();


        consolePanel = new ConsolePanel();
///////////////////////////////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> tilesOrder = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            tilesOrder.add(i);
        }
        Collections.shuffle(tilesOrder);
//        System.out.println(tilesOrder);
        int[] pos = new int[]{tilesOrder.indexOf(8), tilesOrder.indexOf(9), tilesOrder.indexOf(10), tilesOrder.indexOf(11)};

        ArrayList<Adventurer> adventurers = new ArrayList<>();
        adventurers.add(new Diver(0));
        adventurers.add(new Engineer(1));
        adventurers.add(new Explorer(2));
        adventurers.add(new Messenger(3));

///////////////////////////////////////////////////////////////////////////////////////////////////
        gamePanel = new GamePanel();

        jGamePanel = gamePanel.getGamePanel();
        consoleBoxPanel = consolePanel.getConsolePanel();

        this.add(consoleBoxPanel, BorderLayout.EAST);
        this.add(jGamePanel, BorderLayout.CENTER);

//        consoleButtons = consolePanel.getConsoleButtons();


        //the size AudioData object is limited under 1 MB when looped play;
//        Audio.BGM.LoopPlay();


    }

}
