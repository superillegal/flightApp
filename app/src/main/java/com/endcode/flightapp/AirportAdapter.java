package com.endcode.flightapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AirportAdapter extends RecyclerView.Adapter<AirportAdapter.AirportViewHolder> {
    private List<Airport> airports;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Airport airport);
    }

    public AirportAdapter(List<Airport> airports, OnItemClickListener listener) {
        this.airports = airports;
        this.listener = listener;
    }

    @Override
    public AirportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_airport, parent, false);
        return new AirportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AirportViewHolder holder, int position) {
        Airport airport = airports.get(position);
        holder.bind(airport, listener);
    }

    @Override
    public int getItemCount() {
        return airports.size();
    }

    public void updateData(List<Airport> newAirports) {
        airports.clear();
        airports.addAll(newAirports);
        notifyDataSetChanged();
    }

    static class AirportViewHolder extends RecyclerView.ViewHolder {
        TextView airportNameTextView, codeTextView, countryTextView, cityTextView;


        public AirportViewHolder(View itemView) {
            super(itemView);
            airportNameTextView = itemView.findViewById(R.id.airportNameTextView);
            cityTextView = itemView.findViewById(R.id.cityTextView);
            countryTextView = itemView.findViewById(R.id.countryTextView);
            codeTextView = itemView.findViewById(R.id.codeTextView);
        }

        public void bind(final Airport airport, final OnItemClickListener listener) {
            airportNameTextView.setText(airport.getAirport());
            countryTextView.setText(airport.getCounty());
            cityTextView.setText(airport.getCity());
            codeTextView.setText(airport.getIata() + " / " + airport.getIcao());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(airport);
                }
            });
        }
    }
}
