package com.example.f1.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.f1.R;

import java.util.List;

public class RaceAdapter extends BaseAdapter {
    private Context context;
    private List<RaceResponse.Race> races;

    public RaceAdapter(Context context, List<RaceResponse.Race> races) {
        this.context = context;
        this.races = races;
    }

    @Override
    public int getCount() {
        return races.size();
    }

    @Override
    public Object getItem(int position) {
        return races.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.race_item, parent, false);
        }

        RaceResponse.Race race = races.get(position);

        TextView nameTextView = convertView.findViewById(R.id.raceNameTextView);
        TextView dateTextView = convertView.findViewById(R.id.raceDateTextView);
        TextView locationTextView = convertView.findViewById(R.id.raceLocationTextView);

        String raceName = race.raceName;
        String date = race.date;
        String location = race.circuit.location.locality + ", " + race.circuit.location.country;

        nameTextView.setText(raceName);
        dateTextView.setText(date);
        locationTextView.setText(location);

        return convertView;
    }
}
