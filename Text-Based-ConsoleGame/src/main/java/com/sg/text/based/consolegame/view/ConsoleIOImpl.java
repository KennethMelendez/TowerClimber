/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.text.based.consolegame.view;

import java.util.Scanner;

/**
 *
 * @author kmlnd
 */
public class ConsoleIOImpl implements ConsoleIO {

    Scanner userInput = new Scanner(System.in);
    
    @Override
    public void displayText(String message) {
        System.out.println(message);
    }

    @Override
    public void battleCompleteMessage(String dead, String survived, boolean isAlive) {
        if (isAlive) {
            System.out.println(survived);
        } else {
            System.out.println(dead);
        }
    }

    @Override
    public String readResponse(String message) {
        String result = "";
        displayText(message);
        result = userInput.nextLine();
        return result;
    }

   
}
