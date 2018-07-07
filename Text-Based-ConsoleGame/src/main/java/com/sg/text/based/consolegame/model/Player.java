/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.text.based.consolegame.model;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author kmlnd
 */
public class Player {
    private String name;
    private int healthPoints;
    private int spellPoints;
    private int attackPoints;
    private int defensePoints;
    private Item[] inventory = new Item[4];
    private Spells[] spells = new Spells[4];
    private Weapon equipedWeapon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getSpellPoints() {
        return spellPoints;
    }

    public void setSpellPoints(int spellPoints) {
        this.spellPoints = spellPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public Item[] getInventory() {
        return inventory;
    }

    public void setInventory(Item[] inventory) {
        this.inventory = inventory;
    }

    public Spells[] getSpells() {
        return spells;
    }

    public void setSpells(Spells[] spells) {
        this.spells = spells;
    }

    public Weapon getEquipedWeapon() {
        return equipedWeapon;
    }

    public void setEquipedWeapon(Weapon equipedWeapon) {
        this.equipedWeapon = equipedWeapon;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + this.healthPoints;
        hash = 19 * hash + this.spellPoints;
        hash = 19 * hash + this.attackPoints;
        hash = 19 * hash + this.defensePoints;
        hash = 19 * hash + Arrays.deepHashCode(this.inventory);
        hash = 19 * hash + Arrays.deepHashCode(this.spells);
        hash = 19 * hash + Objects.hashCode(this.equipedWeapon);
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
        final Player other = (Player) obj;
        if (this.healthPoints != other.healthPoints) {
            return false;
        }
        if (this.spellPoints != other.spellPoints) {
            return false;
        }
        if (this.attackPoints != other.attackPoints) {
            return false;
        }
        if (this.defensePoints != other.defensePoints) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Arrays.deepEquals(this.inventory, other.inventory)) {
            return false;
        }
        if (!Arrays.deepEquals(this.spells, other.spells)) {
            return false;
        }
        if (!Objects.equals(this.equipedWeapon, other.equipedWeapon)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
