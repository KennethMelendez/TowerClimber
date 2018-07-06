/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.text.based.consolegame.serviceLayer;

import com.sg.text.based.consolegame.model.Monster;
import com.sg.text.based.consolegame.dao.Dao;

/**
 *
 * @author kmlnd
 */
public class ServiceLayerImpl implements ServiceLayer {

    Dao dao;
    
    public ServiceLayerImpl(Dao dao){
        this.dao = dao;
    }
    
    @Override
    public void loadMonsters() {
        dao.loadMonsters();
    }

    @Override
    public Monster spawnRandomLowTierMonster() {
        return dao.spawnRandomLowTierMonster();
    }
    
}
