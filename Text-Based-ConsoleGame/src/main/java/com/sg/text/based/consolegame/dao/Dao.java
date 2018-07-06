/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.text.based.consolegame.dao;

import com.sg.text.based.consolegame.model.Monster;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kmlnd
 */
public interface Dao {

    public void loadMonsters();

    public Monster spawnRandomLowTierMonster();
}
