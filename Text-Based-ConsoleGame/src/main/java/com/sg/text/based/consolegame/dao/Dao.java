/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.text.based.consolegame.dao;

import com.sg.text.based.consolegame.model.Monster;
import com.sg.text.based.consolegame.model.Player;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kmlnd
 */
public interface Dao {

    public void loadMonsters();

    public Monster spawnRandomLowTierMonster();

    public void setPlayerName(String playerName);

    public String getPlayerName();

    public Player getCurrentPlayerStats();

    public void setCurrentPlayerStats(Player currentPlayerStats);

    public void loadDefaultStats();

    public boolean checkIfNextFloor();

    public int getPlayerSteps();

    public void setPlayerSteps(int playerSteps);

    public int getTowerFloor();

    public void setTowerFloor(int towerFloor);

}
