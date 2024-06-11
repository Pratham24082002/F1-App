package com.example.f1.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.f1.R;

import java.util.List;

public class ConstructorAdapter extends BaseAdapter {
    private Context context;
    private List<ConstructorStandingsResponse.ConstructorStanding> constructors;

    public ConstructorAdapter(Context context, List<ConstructorStandingsResponse.ConstructorStanding> constructors) {
        this.context = context;
        this.constructors = constructors;
    }

    @Override
    public int getCount() {
        return constructors.size();
    }

    @Override
    public Object getItem(int position) {
        return constructors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.constructor_item, parent, false);
        }

        ConstructorStandingsResponse.ConstructorStanding constructorStanding = constructors.get(position);

        TextView nameTextView = convertView.findViewById(R.id.constructorNameTextView);
        TextView pointsTextView = convertView.findViewById(R.id.constructorPointsTextView);

        String constructorName = constructorStanding.constructor.name;
        String points = constructorStanding.points;

        nameTextView.setText(constructorName);
        pointsTextView.setText(points);

        return convertView;
    }
}
