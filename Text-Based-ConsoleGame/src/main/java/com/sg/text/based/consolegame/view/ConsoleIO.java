/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.text.based.consolegame.view;

/**
 *
 * @author kmlnd
 */
public interface ConsoleIO {

    void displayText(String message);

    String readResponse(String message);    
    
    void battleCompleteMessage(String dead, String survived, boolean isAlive);
}
