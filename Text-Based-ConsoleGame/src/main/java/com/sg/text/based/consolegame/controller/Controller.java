/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.text.based.consolegame.controller;

import com.sg.text.based.consolegame.model.Player;
import com.sg.text.based.consolegame.serviceLayer.ServiceLayer;
import com.sg.text.based.consolegame.view.UI;

/**
 *
 * @author kmlnd
 */
public class Controller {

    ServiceLayer sl;
    UI ui;

    public Controller(ServiceLayer sl, UI ui) {
        this.sl = sl;
        this.ui = ui;
    }

    public void run() {
        this.displayIntro();
        this.promptName();
        this.welcomeUser();
        this.battlePhase();

    }

    private void displayIntro() {
        ui.intro();
    }

    private void promptName() {
        String name = ui.whatIsYourNamePrompt();
        sl.setPlayerName(name);
        
        
    }

    private void welcomeUser() {
       ui.welcomeUser(sl.getPlayerName());
       sl.loadDefaultStats();
        
    }
    private void battlePhase(){
        Player player = sl.getCurrentPlayerStats();
        player = ui.battlePhase(player,sl.spawnRandomLowTierMonster());
        sl.setCurrentPlayerStats(player);
    }
}
