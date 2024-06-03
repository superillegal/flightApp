package com.endcode.flightapp;
import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

public class AirportDetailActivity extends AppCompatActivity {

    private TextView airportName;
    private TextView cityCountry;
    private TextView codes;
    private TextView latitude;
    private TextView longitude;
    private TextView elevation;
    private TextView region;
    private TextView state;
    private TextView type;
    private TextView continent;
    private TextView isoRegion;
    private TextView scheduledService;
    private TextView home;
    private TextView woeid;
    private TextView runwayLength;

    private Button wikipediaButton;
    private Button flightradar24Button;
    private Button radarboxButton;
    private Button flightawareButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport_detail);


        cityCountry = findViewById(R.id.cityCountryTextView);
        codes = findViewById(R.id.codesTextView);
        latitude = findViewById(R.id.latitudeTextView);
        longitude = findViewById(R.id.longitudeTextView);
        elevation = findViewById(R.id.elevationTextView);
        region = findViewById(R.id.regionTextView);
        state = findViewById(R.id.stateTextView);
        type = findViewById(R.id.typeTextView);
        continent = findViewById(R.id.continentTextView);
        isoRegion = findViewById(R.id.isoRegionTextView);
        scheduledService = findViewById(R.id.scheduledServiceTextView);
        home = findViewById(R.id.homeTextView);
        woeid = findViewById(R.id.woeidTextView);
        runwayLength = findViewById(R.id.runwayLengthTextView);


        wikipediaButton = findViewById(R.id.wikipediaButton);
        flightradar24Button = findViewById(R.id.flightradar24Button);
        radarboxButton = findViewById(R.id.radarboxButton);
        flightawareButton = findViewById(R.id.flightawareButton);

        Airport airport = getIntent().getParcelableExtra("airport");

        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);
        setSupportActionBar(topAppBar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if (airport != null) {
            topAppBar.setTitle(airport.getAirport());


            cityCountry.setText(String.format("%s, %s", airport.getCity(), airport.getCounty()));
            codes.setText(String.format("%s / %s", airport.getIata(), airport.getIcao()));
            latitude.setText(String.format("Latitude: %s", airport.getLatitude()));
            longitude.setText(String.format("Longitude: %s", airport.getLongitude()));
            elevation.setText(String.format("Elevation: %s", airport.getElevationFt()));
            region.setText(String.format("Region: %s", airport.getRegionName()));
            state.setText(String.format("State: %s", airport.getState()));
            type.setText(String.format("Type: %s", airport.getType()));
            continent.setText(String.format("Continent: %s", airport.getContinent()));
            isoRegion.setText(String.format("ISO Region: %s", airport.getIsoRegion()));
            scheduledService.setText(String.format("Scheduled Service: %s", airport.getScheduledService()));
            home.setText(String.format("Website: %s", airport.getHome()));
            woeid.setText(String.format("WOEID: %s", airport.getWoeid()));
            runwayLength.setText(String.format("Runway Length: %s", airport.getRunwayLength()));


            wikipediaButton.setOnClickListener(view -> openLink(airport.getWikipediaLink()));
            flightradar24Button.setOnClickListener(view -> openLink(airport.getFlightradar24Link()));
            radarboxButton.setOnClickListener(view -> openLink(airport.getRadarboxLink()));
            flightawareButton.setOnClickListener(view -> openLink(airport.getFlightawareLink()));
            codes.setText(airport.getIata() + " / " + airport.getIcao());
        }
    }
    private void openLink(String url) {
        if (url != null && !url.isEmpty()) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        }
    }
}
