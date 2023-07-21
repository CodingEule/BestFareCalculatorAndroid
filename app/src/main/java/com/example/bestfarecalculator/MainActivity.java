package com.example.bestfarecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int days;
    int rides;

    TextView manyDays;
    TextView manyRides;
    TextView manyZones;
    CheckBox sparCard;
    RadioGroup destination;
    RadioButton sylt;
    RadioButton nyc;
    Button getBestOffer;
    TextView bestFare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manyDays = findViewById(R.id.days);
        manyRides = findViewById(R.id.rides);
        manyZones = findViewById(R.id.zones);
        sparCard = findViewById(R.id.sparcard);
        destination = findViewById(R.id.destinations);
        sylt = findViewById(R.id.sylt);
        nyc = findViewById(R.id.nyc);
        getBestOffer = findViewById(R.id.get_best_fare);
        bestFare = findViewById(R.id.best_fare);

        getBestOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int numberOfDays = Integer.parseInt(manyDays.getText().toString());
                final int numberOfRides = Integer.parseInt(manyRides.getText().toString());
                final int numberOfZones = Integer.parseInt(manyZones.getText().toString());
                final int destinationButton = destination.getCheckedRadioButtonId();
                final boolean sparCardValue = sparCard.isChecked();
                String answer;

                if(destinationButton == sylt.getId()){
                    SyltSVG ride = new SyltSVG(numberOfDays, numberOfRides, numberOfZones, sparCardValue);
                    answer = ride.getBestFare();
                }else if(destinationButton == nyc.getId()){
                    NYCTransit ride = new NYCTransit(numberOfDays, numberOfRides);
                    answer = ride.getBestFare();
                }else{
                    answer = "0";
                }

                bestFare.setText(answer);



            }
        });

    }
}