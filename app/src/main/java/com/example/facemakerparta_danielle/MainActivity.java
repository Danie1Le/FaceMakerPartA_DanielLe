// @author Daniel Le
package com.example.facemakerparta_danielle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializes SeekBars and TextViews
        SeekBar seekBarRed = findViewById(R.id.RedVal);
        SeekBar seekBarBlue = findViewById(R.id.BlueVal);
        SeekBar seekBarGreen = findViewById(R.id.GreenVal);
        TextView tvOne = findViewById(R.id.RedNum);
        TextView tvTwo = findViewById(R.id.GreenNum);
        TextView tvThree = findViewById(R.id.BlueNum);
        RadioButton HairButton = findViewById(R.id.hairRadioButton);
        RadioButton EyesButton = findViewById(R.id.eyesRadioButton);
        RadioButton SkinButton = findViewById(R.id.skinRadioButton);
        Button randomButton = findViewById(R.id.RandomButton);
        Face faceView = findViewById(R.id.FaceDisplay);


        // setup The seekBar progress for red
        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int Progress, boolean b) {
                tvOne.setVisibility(View.VISIBLE);
                //sets the text based on progress value
                tvOne.setText("Red: " + Progress + "");

                faceView.setHairColor(Color.rgb(Progress, seekBarGreen.getProgress(), seekBarBlue.getProgress()));
                faceView.invalidate();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // setup The seekBar progress for Green
        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int Progress, boolean b) {
                tvThree.setVisibility(View.VISIBLE);
                tvThree.setText("Blue: " + Progress + "");

                faceView.setHairColor(Color.rgb(seekBarRed.getProgress(), Progress, seekBarBlue.getProgress()));
                faceView.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // setup The seekBar progress for Blue
        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int Progress, boolean b) {
                tvTwo.setVisibility(View.VISIBLE);
                tvTwo.setText("Green: " + Progress + "");

                faceView.setHairColor(Color.rgb(seekBarRed.getProgress(), seekBarGreen.getProgress(), Progress));
                faceView.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // Set up the Spinner for all the Hairstyles
        Spinner spinner = findViewById(R.id.HairStyles);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "Selected Item: " + item, Toast.LENGTH_SHORT).show();
                faceView.setHairStyle(i);
                faceView.invalidate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Make an Arraylist to hold all of the hairstyle options for the spinner
        ArrayList<String> HairTypes = new ArrayList<>();
        HairTypes.add("Buzz");
        HairTypes.add("Taper");
        HairTypes.add("Afro");
        HairTypes.add("Fade");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, HairTypes);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);

        // Set up the RadioGroup for hair, eyes, and skin RadioButtons
        RadioGroup radioGroup = findViewById(R.id.RadioGroupOptions);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                // Check which RadioButton is selected and update SeekBars accordingly
                if (checkedId == R.id.hairRadioButton) {
                    updateSeekBars(faceView.getHairColor());
                }
                else if (checkedId == R.id.eyesRadioButton) {
                    updateSeekBars(faceView.getEyeColor());
                }
                else if (checkedId == R.id.skinRadioButton) {
                    updateSeekBars(faceView.getSkinColor());
                }
            }
        });

        setUpSeekBarListeners();
    }

    private void setUpSeekBarListeners() {

    }

    // Method to update SeekBars based on a color value
    private void updateSeekBars(int color) {
        SeekBar seekBarRed = findViewById(R.id.RedVal);
        SeekBar seekBarGreen = findViewById(R.id.GreenVal);
        SeekBar seekBarBlue = findViewById(R.id.BlueVal);

        seekBarRed.setProgress(Color.red(color));
        seekBarGreen.setProgress(Color.green(color));
        seekBarBlue.setProgress(Color.blue(color));
    }
}