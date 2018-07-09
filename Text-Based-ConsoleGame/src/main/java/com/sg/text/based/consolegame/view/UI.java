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
        io.displayText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        io.displayText("");
        io.displayText(" Welcome to.. Tower Climber");
        io.displayText("");
        io.displayText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        io.displayText("");
        pressAnyKeyToContinue();
    }

    public Player battlePhase(Player player, Monster monster) {
        boolean isAlive = true;
        io.displayText("You encountered " + monster.getName() + " ...");
        io.displayText(monster.getBattleCry());
        pressAnyKeyToContinue();
        while(player.getHealthPoints() >= 0 || monster.getHealthPoints() >= 0){
            io.displayText(player.getName() +" HP : " + player.getHealthPoints() + " | " + monster.getName() +" HP : " + monster.getHealthPoints());
            io.displayText("");
            io.displayText(player.getName() + " attacks!");
            int playerHP = player.getHealthPoints();
            int monstersHP = monster.getHealthPoints() - player.getAttackPoints();
            io.displayText(monster.getName() +" HP : " + monstersHP);
            if(monstersHP <= 0){
                player.setExp(monster.getExp() + player.getExp());//set exp
                player.setGold(monster.getGold() + player.getGold());
                io.displayText("Current EXP : " + player.getExp());
                io.displayText("Current GOLD : " + player.getGold());
                break;
            } else {
                monster.setHealthPoints(monstersHP);
            }
            io.displayText(monster.getName() + " attacks!");
            pressAnyKeyToContinue();
            playerHP = playerHP - monster.getAttackPoints();
            playerHP += player.getDefensePoints();
            player.setHealthPoints(playerHP);
            if(playerHP <= 0){
                isAlive = false;
                break;
            } else {
                player.setHealthPoints(playerHP);
            }
        }
        io.battleCompleteMessage("You died..", "You survived!!", isAlive);
        return player;
    }
    
    public void pressAnyKeyToContinue() {
        io.readResponse("Press any key to continue.");
    }
    
    public String whatIsYourNamePrompt(){
        String name = io.readResponse("What is your name..?");
        return name;
    }
    
    public void welcomeUser(String name){
        io.displayText("Welcome ... " + name);
    }
    
    public void gameStory(){
        io.displayText("Can you survive the tower? ");
        io.displayText("*You proceed to enter the forbidden tower.*");
    }
    
    public void promptUserCongratsNewFloor(int floorNum){
        io.displayText("You reached a new floor! Floor : " + floorNum);
        this.pressAnyKeyToContinue();
    }

}
