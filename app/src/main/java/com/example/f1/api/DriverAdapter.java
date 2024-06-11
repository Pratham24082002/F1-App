package com.example.f1.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.f1.R;

import java.util.List;

public class DriverAdapter extends BaseAdapter {
    private Context context;
    private List<DriverStandingsResponse.DriverStanding> drivers;

    public DriverAdapter(Context context, List<DriverStandingsResponse.DriverStanding> drivers) {
        this.context = context;
        this.drivers = drivers;
    }

    @Override
    public int getCount() {
        return drivers.size();
    }

    @Override
    public Object getItem(int position) {
        return drivers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.driver_item, parent, false);
        }

        DriverStandingsResponse.DriverStanding driverStanding = drivers.get(position);

        TextView nameTextView = convertView.findViewById(R.id.driverNameTextView);
        TextView pointsTextView = convertView.findViewById(R.id.driverPointsTextView);
        TextView teamNameTextView = convertView.findViewById(R.id.teamNameTextView);

        String driverName = driverStanding.driver.givenName + " " + driverStanding.driver.familyName;
        String points = driverStanding.points;
        String teamName = driverStanding.constructors.get(0).name;

        nameTextView.setText(driverName);
        pointsTextView.setText(points);
        teamNameTextView.setText(teamName);

        return convertView;
    }
}
