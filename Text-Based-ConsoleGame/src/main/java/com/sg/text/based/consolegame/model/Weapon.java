/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.text.based.consolegame.model;

/**
 *
 * @author kmlnd
 */
public class Weapon extends Item{
    private int attackBoost;

    public int getAttackBoost() {
        return attackBoost;
    }

    public void setAttackBoost(int attackBoost) {
        this.attackBoost = attackBoost;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.attackBoost;
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
        final Weapon other = (Weapon) obj;
        if (this.attackBoost != other.attackBoost) {
            return false;
        }
        return true;
    }
    
    
    
}
