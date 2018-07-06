/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.text.based.consolegame.model;

import java.util.Objects;

/**
 *
 * @author kmlnd
 */
public class Monster extends Player {
    
    private String battleCry;

    public String getBattleCry() {
        return battleCry;
    }

    public void setBattleCry(String battleCry) {
        this.battleCry = battleCry;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.battleCry);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Monster other = (Monster) obj;
        if (!Objects.equals(this.battleCry, other.battleCry)) {
            return false;
        }
        return true;
    }
    
    
}
