package com.endcode.flightapp;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements AirportAdapter.OnItemClickListener {

    private RecyclerView airportList;
    private AirportAdapter airportAdapter;
    private List<Airport> allAirports;
    private List<Airport> filteredAirports;
    private SearchView searchView;
    private SearchBar searchBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        airportList = view.findViewById(R.id.airport_list);
        searchView = view.findViewById(R.id.search_view);
        searchBar = view.findViewById(R.id.search_bar);

        allAirports = loadAirportsFromJson();
        filteredAirports = new ArrayList<>(allAirports);

        airportAdapter = new AirportAdapter(filteredAirports, this);
        airportList.setLayoutManager(new LinearLayoutManager(getContext()));
        airportList.setAdapter(airportAdapter);

        searchBar.inflateMenu(R.menu.searchbar_menu);
        searchBar.setOnMenuItemClickListener(menuItem -> {
            if (menuItem.getItemId() == R.id.action_search) {
                searchView.show();
                return true;
            }
            return false;
        });

        searchView.getEditText().setOnEditorActionListener((v, actionId, event) -> {
            searchBar.setText(searchView.getText());
            searchView.hide();
            filterAirports(searchView.getText().toString());
            return false;
        });

        return view;
    }

    private List<Airport> loadAirportsFromJson() {
        List<Airport> airports = new ArrayList<>();
        try {
            InputStream is = getContext().getAssets().open("airports.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");

            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Airport airport = new Airport(
                        jsonObject.getString("iata"),
                        jsonObject.getString("icao"),
                        jsonObject.getString("time"),
                        jsonObject.getString("city_code"),
                        jsonObject.getString("country_code"),
                        jsonObject.getString("airport"),
                        jsonObject.getString("latitude"),
                        jsonObject.getString("longitude"),
                        jsonObject.getString("elevation_ft"),
                        jsonObject.getString("region_name"),
                        jsonObject.getString("city"),
                        jsonObject.getString("county"),
                        jsonObject.getString("state"),
                        jsonObject.getString("type"),
                        jsonObject.getString("continent"),
                        jsonObject.getString("iso_region"),
                        jsonObject.getString("scheduled_service"),
                        jsonObject.getString("wikipedia_link"),
                        jsonObject.getString("home"),
                        jsonObject.getString("woeid"),
                        jsonObject.getString("phone"),
                        jsonObject.getString("email"),
                        jsonObject.getString("runway_length"),
                        jsonObject.getString("flightradar24_url"),
                        jsonObject.getString("radarbox_url"),
                        jsonObject.getString("flightaware_url")
                );
                airports.add(airport);

            }
        } catch (IOException | JSONException ex) {
            ex.printStackTrace();

        }
        return airports;

    }

    private void filterAirports(String query) {
        List<Airport> results = new ArrayList<>();
        for (Airport airport : allAirports) {
            if (airport.getCity().toLowerCase().contains(query.toLowerCase()) ||
                    airport.getAirport().toLowerCase().contains(query.toLowerCase()) ||
                    airport.getIata().toLowerCase().contains(query.toLowerCase())) {
                results.add(airport);
            }
        }
        airportAdapter.updateData(results);
    }

    @Override
    public void onItemClick(Airport airport) {
        Intent intent = new Intent(getContext(), AirportDetailActivity.class);
        intent.putExtra("airport", airport);
        startActivity(intent);
    }
}