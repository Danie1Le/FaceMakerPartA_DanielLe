// @author Daniel Le
package com.example.facemakerparta_danielle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;


import java.util.ArrayList;
import java.util.Random;

public class Face extends SurfaceView {
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);

        setWillNotDraw(false);
        //randomizes the variables
        randomize();

        setBackgroundColor(Color.WHITE);
    }

    public void randomize() {
        Random rand = new Random(); // makes a random generator to be used on the variables

        // randomly assign the variables with values 0 - 255 for each RGB value
        eyeColor = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        hairColor = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        skinColor = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

        // randomize with 0 - 3 for which hairstyle
        hairStyle = rand.nextInt(4);

        invalidate(); // redraw itself
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
        return this.eyeColor;
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

    public void onDraw(Canvas canvas) {
        // Get midpoints for horizontal and vertical
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Draw the face
        Paint skinColorVal = new Paint();
        skinColorVal.setColor(skinColor); // set color to that
        canvas.drawCircle(centerX, centerY, 500.0f, skinColorVal);

        // Draw the eyes of the face
        Paint EyeColorVal = new Paint();
        EyeColorVal.setColor(eyeColor); // set the color
        canvas.drawCircle(centerX - 200, centerY - 80, 50.0f, EyeColorVal);
        canvas.drawCircle(centerX + 200, centerY - 80, 50.0f, EyeColorVal);

        // Draw hair based on hairstyle
        Paint hairPaint = new Paint();
        hairPaint.setColor(hairColor); // set color
        if (hairStyle == 0) {
            // Draw Buzz cut
            canvas.drawRect(centerX - 500, centerY - 500, centerX + 500, centerY - 300, hairPaint); // top portion
            canvas.drawRect(centerX - 500, centerY - 500, centerX - 400, centerY - 100, hairPaint); // left side
            canvas.drawRect(centerX + 400, centerY - 500, centerX + 500, centerY - 100, hairPaint); // right side
        }
        else if (hairStyle == 1) {
            // draw a taper
            canvas.drawRect(centerX - 525, centerY - 200, centerX - 400, centerY - 100, hairPaint); // left side
            canvas.drawRect(centerX - 550, centerY - 400, centerX - 350, centerY - 200, hairPaint); // left side
            canvas.drawRect(centerX + 400, centerY - 200, centerX + 525, centerY - 100, hairPaint); // right side
            canvas.drawRect(centerX + 375, centerY - 400, centerX + 550, centerY - 200, hairPaint); // right side
            canvas.drawRect(centerX - 500, centerY - 550, centerX + 500, centerY - 300, hairPaint); // top portion
        } else if (hairStyle == 2) {
            // draw an Afro
            canvas.drawRect(centerX - 500, centerY - 500, centerX - 400, centerY - 100, hairPaint); // left side
            canvas.drawRect(centerX + 400, centerY - 500, centerX + 500, centerY - 100, hairPaint); // right side
            for (int i = 0; i < 5; i++) {
                canvas.drawCircle(centerX - 400.0f + (200 * i), centerY - 450.0f, 150, hairPaint); // for loop to create afro effect on top of head
            }
        } else if (hairStyle == 3) {
            // draw a fade
            // for loop to make it draw over and over to have a certain pattern
            for (int i = 0; i < 6; i++) {
                canvas.drawRect(centerX - 500 - (5 * i), centerY - 200 - (30 * i), centerX - 400 + (10 * i), centerY - 100 - (30 * i), hairPaint); // left side
                canvas.drawRect(centerX + 400 - (10 * i), centerY - 200 - (30 * i), centerX + 500 + (5 * i), centerY - 100 - (30 * i), hairPaint); // right side
                canvas.drawCircle(centerX - 375.0f + (150 * i), centerY - 450.0f, 170, hairPaint); // top part of hair
            }
        }
        else {
            // default to buzz
            canvas.drawRect(centerX - 500, centerY - 500, centerX + 500, centerY - 300, hairPaint); // top portion
            canvas.drawRect(centerX - 500, centerY - 500, centerX - 400, centerY - 100, hairPaint); // left side
            canvas.drawRect(centerX + 400, centerY - 500, centerX + 500, centerY - 100, hairPaint); // right side
        }
    }
}