// @author Daniel Le
package com.example.facemakerparta_danielle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.HardwarePropertiesManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        // initializes SeekBars and TextViews
        SeekBar seekBarRed;
        SeekBar seekBarBlue;
        SeekBar seekBarGreen;
        TextView tvOne;
        TextView tvTwo;
        TextView tvThree;

            //seekbar for Red
            seekBarRed = findViewById(R.id.RedVal);
            //seekbar for Green;
            seekBarGreen = findViewById(R.id.GreenVal);
            //seekbar for Blue;
            seekBarBlue = findViewById(R.id.BlueVal);

            //references the textview
            tvOne = findViewById(R.id.RedNum);
            tvTwo = findViewById(R.id.GreenNum);
            tvThree = findViewById(R.id.BlueNum);


            // setup The seekBar progress for red
            seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int Progress, boolean b) {
                    tvOne.setVisibility(View.VISIBLE);

                    //sets the text based on progress value
                    tvOne.setText("Red: " + Progress + "");
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

        // setup The seekBar progress for green
        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int Progress, boolean b) {
                    tvTwo.setVisibility(View.VISIBLE);
                    tvTwo.setText("Green: " + Progress + "");
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

        // setup The seekBar progress for blue
        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int Progress, boolean b) {
                    tvThree.setVisibility(View.VISIBLE);
                    tvThree.setText("Blue: " + Progress + "");
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
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        // Make an Arraylist to hold all of the hairstyle options for the spinner
        ArrayList<String> HairTypes = new ArrayList<>();
        HairTypes.add("Buzz");
        HairTypes.add("Taper");
        HairTypes.add("Cornrows");
        HairTypes.add("Fade");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, HairTypes);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);
    }
}


