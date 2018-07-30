/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.text.based.consolegame.view;

import com.sg.text.based.consolegame.model.Item;
import com.sg.text.based.consolegame.model.Monster;
import com.sg.text.based.consolegame.model.Player;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author kmlnd
 */
public class UI {

    ConsoleIO io;

    public UI(ConsoleIO io) {
        this.io = io;
    }

    public void intro() {
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
        while (player.getHealthPoints() >= 0 || monster.getHealthPoints() >= 0) {
            io.displayText(player.getName() + " HP : " + player.getHealthPoints() + " | " + monster.getName() + " HP : " + monster.getHealthPoints());
            io.displayText("");
            io.displayText(player.getName() + " attacks!");
            int playerHP = player.getHealthPoints();
            int monstersHP = monster.getHealthPoints() - player.getAttackPoints();
            io.displayText(monster.getName() + " HP : " + monstersHP);
            if (monstersHP <= 0) {
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
            if (playerHP <= 0) {
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

    public String whatIsYourNamePrompt() {
        String name = io.readResponse("What is your name..?");
        return name;
    }

    public void welcomeUser(String name) {
        io.displayText("Welcome ... " + name);
    }

    public void gameStory() {
        io.displayText("Can you survive the tower? ");
        io.displayText("*You proceed to enter the forbidden tower.*");
    }

    public void promptUserCongratsNewFloor(int floorNum) {
        io.displayText("You reached a new floor! Floor : " + floorNum);
        this.pressAnyKeyToContinue();
    }

    public Player promptStore(Player player) {

        Map<Integer, Item> storeItems = new HashMap<>();

        boolean askAgain = true;
        while (askAgain) {
            io.displayText("Gold : " + player.getGold());
            List<Item> playersInventory = player.getInventory();

            Item potion = new Item();
            potion.setId(UUID.randomUUID().toString().hashCode());
            potion.setName("Potion");
            potion.setCost(2);
            potion.setDescription("Increase health by 5");
            storeItems.put(potion.getId(), potion);

            Item superPotion = new Item();
            superPotion.setName("Super Potion");
            superPotion.setCost(5);
            superPotion.setDescription("Fully Restores Health");
            superPotion.setId(UUID.randomUUID().toString().hashCode());
            storeItems.put(superPotion.getId(), superPotion);

            displayStoreItems(new ArrayList<>(storeItems.values()));
            String response = io.readResponse("Press number key to purchase");

            try {
                switch (parseInt(response)) {
                    case 0:
                        io.displayText("Exiting store...");
                        askAgain = false;
                        break;
                    case 1:
                        if (player.getGold() >= potion.getCost()) {
                            playersInventory.add(potion);
                            player.setInventory(playersInventory);
                            io.displayText("You bought a potion!");
                            int outputAmount = player.getGold() - potion.getCost();
                            player.setGold(outputAmount);

                        } else {
                            io.displayText("Sorry not enough coin.");

                        }
                        break;
                    case 2:
                        if (player.getGold() >= superPotion.getCost()) {
                            playersInventory.add(superPotion);
                            player.setInventory(playersInventory);
                            io.displayText("You bought a Super Potion!");
                            int outputAmount = player.getGold() - superPotion.getCost();
                            player.setGold(outputAmount);

                        } else {
                            io.displayText("Sorry not enough coin.");

                        }
                        break;
                    default:
                        io.displayText("what...?");
                        break;
                }
            } catch (NumberFormatException ex) {
                io.displayText("huh...?");
            }
        }

        return player;
    }

    public void displayStoreItems(List<Item> items) {
        io.displayText("");
        int key = 0;
        io.displayText("Welcome to the store..");
        io.displayText("0. Exit Store");
        for (Item currentItems : items) {
            key++;
            io.displayText(key + ". " + currentItems.getName() + " : " + currentItems.getDescription());
        }
    }

    public void viewPlayersInventoryAndUseItem(Player player) {
        List<Item> items = player.getInventory();
        String response = io.readResponse("Press number key to purchase");
        int key = 0;
        for (Item currentItem : player.getInventory()) {

            io.displayText(key + ". " + currentItem.getName() + " : " + currentItem.getDescription());
            if (parseInt(response) == key) {
                items.remove(items.get(key));
                
                // code to use item here
                
                key++;
            }
        }

    }
}
