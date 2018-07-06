/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.text.based.consolegame.view;

import com.sg.text.based.consolegame.model.Monster;
import com.sg.text.based.consolegame.model.Player;
import java.util.Scanner;

/**
 *
 * @author kmlnd
 */
public class UI {

    
    ConsoleIO io;
    
    public UI(ConsoleIO io) {
        this.io = io;
    }
    
    public void intro(){
        io.displayText(" Welcome to.. Tower Climber");
        io.displayText("");
        pressAnyKeyToContinue();
    }

    Player battlePhase(Player player, Monster monster) {
        boolean isAlive = true;
        io.displayText("You encountered " + monster.getName() + " ...");
        io.displayText(monster.getBattleCry());
        pressAnyKeyToContinue();
        while(player.getHealthPoints() >= 0 || monster.getHealthPoints() >= 0){
            io.displayText(player.getName() + " attacks!");
            int monstersHP = monster.getHealthPoints() - player.getAttackPoints();
            if(monstersHP <= 0){
                break;
            } else {
                monster.setHealthPoints(monstersHP);
            }
            io.displayText(monster.getName() + " attacks!");
            pressAnyKeyToContinue();
            int playersHP = player.getHealthPoints() - monster.getAttackPoints();
            if(playersHP <= 0){
                isAlive = false;
                break;
            } else {
                player.setHealthPoints(monstersHP);
            }
        }
        io.battleCompleteMessage("You died..", "You survived!!", isAlive);
        return player;
    }
    
    void pressAnyKeyToContinue() {
        io.readResponse("Press any key to continue.");
    }

}
