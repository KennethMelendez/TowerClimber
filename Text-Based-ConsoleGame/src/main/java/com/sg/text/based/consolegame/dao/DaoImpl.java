/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.text.based.consolegame.dao;

import com.sg.text.based.consolegame.model.Monster;
import com.sg.text.based.consolegame.model.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author kmlnd
 */
public class DaoImpl implements Dao {

    List<Monster> lowTierMonsters = new ArrayList<>();
    String playerName;
    Random randomizer = new Random();
    int playerSteps = 1;
    int towerFloor = 0;
    
    private Player currentPlayerStats;

    @Override
    public void loadMonsters() {

        lowTierMonsters.add(goblin());
        lowTierMonsters.add(bandit());
        lowTierMonsters.add(imp());
        lowTierMonsters.add(angryGoat());

    }
    
    
    @Override
    public boolean checkIfNextFloor(){
        return this.getPlayerSteps() % 10 == 0;
    }

    @Override
    public int getPlayerSteps() {
        return playerSteps;
    }
    
    

    @Override
    public void setPlayerSteps(int playerSteps) {
        this.playerSteps = playerSteps;
    }

    @Override
    public int getTowerFloor() {
        return towerFloor;
    }

    @Override
    public void setTowerFloor(int towerFloor) {
        this.towerFloor = towerFloor;
    }
    
    

    @Override
    public void loadDefaultStats() {
        Player newPlayer = new Player();
        newPlayer.setName(this.getPlayerName());
        newPlayer.setAttackPoints(5);
        newPlayer.setDefensePoints(1);
        newPlayer.setHealthPoints(15);
        newPlayer.setSpellPoints(0);
        this.setCurrentPlayerStats(newPlayer);
    }

    @Override
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    public Monster goblin() {
        //spawning new monster
        Monster goblin = new Monster();
        // setting the name and stats of the monster
        goblin.setName("Goblin");
        int maxHealthPoints = randomizer.nextInt(6) + 1;
        goblin.setHealthPoints(maxHealthPoints);
        int attack = randomizer.nextInt(5) + 1;
        goblin.setAttackPoints(attack);
        int defense = randomizer.nextInt(5) + 3;
        goblin.setDefensePoints(defense);
        goblin.setBattleCry("*grunts* *cackles*");
        goblin.setSpellPoints(0);
        goblin.setExp(2);
        goblin.setGold(2);
        return goblin;
    }

    public Monster bandit() {
        //spawning new monster
        Monster bandit = new Monster();
        // setting the name and stats of the monster
        bandit.setName("Bandit");
        int maxHealthPoints = randomizer.nextInt(5) + 1;
        bandit.setHealthPoints(maxHealthPoints);
        int attack = randomizer.nextInt(5) + 1;
        bandit.setAttackPoints(attack);
        int defense = randomizer.nextInt(5) + 3;
        bandit.setDefensePoints(defense);
        bandit.setBattleCry("*That's a nice watch you got there...*");
        bandit.setSpellPoints(0);
        bandit.setExp(2);
        bandit.setGold(5);
        return bandit;
    }

    public Monster imp() {
        //spawning new monster
        Monster imp = new Monster();
        // setting the name and stats of the monster
        imp.setName("Imp");
        int maxHealthPoints = randomizer.nextInt(7) + 1;
        imp.setHealthPoints(maxHealthPoints);
        int attack = randomizer.nextInt(5) + 1;
        imp.setAttackPoints(attack);
        int defense = randomizer.nextInt(5) + 3;
        imp.setDefensePoints(defense);
        imp.setBattleCry("*SHRIEEEEKSSS*");
        imp.setSpellPoints(0);
        imp.setExp(2);
        imp.setGold(1);
        return imp;
    }

    public Monster angryGoat() {
        //spawning new monster
        Monster angryGoat = new Monster();
        // setting the name and stats of the monster
        angryGoat.setName("AngryGoat");
        int maxHealthPoints = randomizer.nextInt(15) + 1;
        angryGoat.setHealthPoints(maxHealthPoints);
        int attack = randomizer.nextInt(5) + 1;
        angryGoat.setAttackPoints(attack);
        int defense = randomizer.nextInt(5) + 3;
        angryGoat.setDefensePoints(defense);
        angryGoat.setBattleCry("*I'm a goat, and I'm angry intellectual.*");
        angryGoat.setSpellPoints(0);
        angryGoat.setExp(2);
        angryGoat.setGold(1);
        return angryGoat;
    }

    @Override
    public Monster spawnRandomLowTierMonster() {
        loadMonsters();
        int spawner = randomizer.nextInt(lowTierMonsters.size() - 1) + 1;
        Monster currentMonster = lowTierMonsters.get(spawner);
        return currentMonster;
    }

    @Override
    public Player getCurrentPlayerStats() {
        return currentPlayerStats;
    }

    @Override
    public void setCurrentPlayerStats(Player currentPlayerStats) {
        this.currentPlayerStats = currentPlayerStats;
    }
    

}
