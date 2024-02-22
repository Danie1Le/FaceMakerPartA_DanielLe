// @author Daniel Le
package com.example.facemakerparta_danielle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // declare variables to be used later on in the class
    private SeekBar seekBarRed;
    private SeekBar seekBarGreen;
    private SeekBar seekBarBlue;
    private TextView tvOne;
    private TextView tvTwo;
    private TextView tvThree;
    private Spinner HairOption;
    private RadioGroup radioGroup;
    private Face faceView;
    private Button randomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarRed = findViewById(R.id.RedVal);
        seekBarGreen = findViewById(R.id.GreenVal);
        seekBarBlue = findViewById(R.id.BlueVal);

         tvOne = findViewById(R.id.RedNum);
         tvTwo = findViewById(R.id.GreenNum);
         tvThree = findViewById(R.id.BlueNum);

        radioGroup = findViewById(R.id.RadioGroupOptions);

        randomButton = findViewById(R.id.RandomButton);
        faceView = findViewById(R.id.FaceDisplay);


        // Setup the seekBar progress for red
        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvOne.setVisibility(View.VISIBLE);
                // Sets the text based on progress value
                tvOne.setText("Red: " + progress);

                // this will adjust the color number for red if one of the radio button is selected
                // set to get the progress of redVal since the red seek bar is being touched and be able to find the value
                // keeps blue and green value the same
                if (radioGroup.getCheckedRadioButtonId() == R.id.hairRadioButton) {
                    faceView.setHairColor(Color.rgb(progress, seekBarGreen.getProgress(), seekBarBlue.getProgress()));
                }
                else if (radioGroup.getCheckedRadioButtonId() == R.id.eyesRadioButton) {
                    faceView.setEyeColor(Color.rgb(progress, seekBarGreen.getProgress(), seekBarBlue.getProgress()));
                }
                else if (radioGroup.getCheckedRadioButtonId() == R.id.skinRadioButton) {
                    faceView.setSkinColor(Color.rgb(progress, seekBarGreen.getProgress(), seekBarBlue.getProgress()));
                }
                faceView.invalidate(); // face redraws itself
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Setup the seekBar progress for Green
        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvThree.setVisibility(View.VISIBLE);
                tvThree.setText("Green: " + progress);

                // this will adjust the color number for green if one of the radio button is selected
                // set to get the progress of greenVal since the green seek bar is being touched and be able to find the value
                // keeps blue and red value the same
                if (radioGroup.getCheckedRadioButtonId() == R.id.hairRadioButton) {
                    faceView.setHairColor(Color.rgb(seekBarRed.getProgress(), progress, seekBarBlue.getProgress()));
                }
                else if (radioGroup.getCheckedRadioButtonId() == R.id.eyesRadioButton) {
                    faceView.setEyeColor(Color.rgb(seekBarRed.getProgress(), progress, seekBarBlue.getProgress()));
                }
                else if (radioGroup.getCheckedRadioButtonId() == R.id.skinRadioButton) {
                    faceView.setSkinColor(Color.rgb(seekBarRed.getProgress(), progress, seekBarBlue.getProgress()));
                }

                faceView.invalidate(); // face redraws itself
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Setup the seekBar progress for Blue
        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvTwo.setVisibility(View.VISIBLE);
                tvTwo.setText("Blue: " + progress);

                // this will adjust the color number for blue if one of the radio button is selected
                // set to get the progress of blueVal since the blue seek bar is being touched and be able to find the value
                // keeps red and green value the same
                if (radioGroup.getCheckedRadioButtonId() == R.id.hairRadioButton) {
                    faceView.setHairColor(Color.rgb(seekBarRed.getProgress(), seekBarGreen.getProgress(), progress));
                }
                else if (radioGroup.getCheckedRadioButtonId() == R.id.eyesRadioButton) {
                    faceView.setEyeColor(Color.rgb(seekBarRed.getProgress(), seekBarGreen.getProgress(), progress));
                }
                else if (radioGroup.getCheckedRadioButtonId() == R.id.skinRadioButton) {
                    faceView.setSkinColor(Color.rgb(seekBarRed.getProgress(), seekBarGreen.getProgress(), progress));
                }
                faceView.invalidate(); // face redraws itself
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRandomButtonClick(view);
            }
        });

        // Set up the Spinner for all the Hairstyles
        HairOption = findViewById(R.id.HairStyles);
        HairOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString(); // get item from adapter view
                Toast.makeText(MainActivity.this, "Selected Item: " + item, Toast.LENGTH_SHORT).show();
                faceView.setHairStyle(i);   // Set the selected hairstyle on the faceView
                faceView.invalidate(); // redraw itself
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        // Make an ArrayList to hold all of the hairstyle options for the spinner
        ArrayList<String> HairTypes = new ArrayList<>();
        HairTypes.add("Buzz");
        HairTypes.add("Taper");
        HairTypes.add("Afro");
        HairTypes.add("Fade");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, HairTypes);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        HairOption.setAdapter(adapter);

        // Set up the RadioGroup for hair, eyes, and skin RadioButtons
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                // Check which RadioButton is selected and update SeekBars
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
    }

    public void onRandomButtonClick(View view) {
        faceView.randomize(); // when clicked calls randomize method on Face object
        UpdateValues(); // calls method to update the UI values that is the current face shown
    }


    // Method to update SeekBars based on a color value
    private void updateSeekBars(int color) {
        seekBarRed.setProgress(Color.red(color));
        seekBarGreen.setProgress(Color.green(color));
        seekBarBlue.setProgress(Color.blue(color));
    }

    // Update the values based off the drawing of the face
    private void UpdateValues() {
        radioGroup = findViewById(R.id.RadioGroupOptions);

        // whichever radio button is selected, get the color values for that radio button and calls method to find each RGB value and set the seekbar to the number
        if (radioGroup.getCheckedRadioButtonId() == R.id.hairRadioButton) {
            updateSeekBars(faceView.getHairColor());
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.eyesRadioButton) {
            updateSeekBars(faceView.getEyeColor());
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.skinRadioButton) {
            updateSeekBars(faceView.getSkinColor());
        }
        HairOption.setSelection(faceView.getHairStyle()); // this updates what hairstyle is shown and updated to the spinner
    }
}