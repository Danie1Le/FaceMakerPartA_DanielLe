// @author Daniel Le
package com.example.facemakerparta_danielle;

import android.graphics.Canvas;

import java.util.Random;

public class Face {
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    public Face() {
        randomize(); // call the randomize method
    }

    public void randomize() {
        Random rand = new Random(); // makes a random generator to be used on the variables

        // randomly assign the variables with values 0 - 255
        skinColor = rand.nextInt(256);
        eyeColor  = rand.nextInt(256);
        hairColor = rand.nextInt(256);

        // randomize with 0 - 3
        hairStyle = rand.nextInt(4);
    }

    public void onDraw(Canvas Canvas) {
        // suppose to be empty for now
    }

    // setter and getter methods that would be used with the onDraw method
    public void setSkinColor(int skinColor) {
        this.skinColor = skinColor;
    }

    public int getSkinColor() {
        return this.skinColor;
    }

    public void setEyeColor(int eyeColor) {
        this.eyeColor = eyeColor;
    }

    public int getEyeColor() {
        return  this.eyeColor;
    }

    public void setHairColor(int hairColor) {
        this.hairColor = hairColor;
    }

    public int getHairColor() {
        return this.hairColor;
    }

    public void setHairStyle(int hairStyle) {
        this.hairStyle = hairStyle;
    }

    public int getHairStyle() {
        return this.hairStyle;
    }
}
