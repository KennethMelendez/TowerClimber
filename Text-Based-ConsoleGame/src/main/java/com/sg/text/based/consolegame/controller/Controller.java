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
        this.plot();

        do {

            // checking the current step and resetting the step
            int currentStep = sl.getPlayerSteps();
            int currentFloor = sl.getTowerFloor();
            currentStep += 1;
            sl.setPlayerSteps(currentStep);

            //checking if its the next floor and then being able to trigger an event
            if (sl.checkIfNextFloor()) {

                Player setNewItemToPlayer = ui.promptStore(sl.getCurrentPlayerStats());
                sl.setCurrentPlayerStats(setNewItemToPlayer);

                currentFloor += 1;
                sl.setTowerFloor(currentFloor);
                this.newFloorPrompt(sl.getTowerFloor());

            } else {
                this.battlePhase();

            }

        } while (sl.getCurrentPlayerStats().getHealthPoints() > 0);

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

    private void plot() {
        ui.gameStory();
    }

    private void battlePhase() {
        Player player = sl.getCurrentPlayerStats();
        player = ui.battlePhase(player, sl.spawnRandomLowTierMonster());
        sl.setCurrentPlayerStats(player);
    }

    private void newFloorPrompt(int floor) {
        ui.promptUserCongratsNewFloor(floor);
    }

}
