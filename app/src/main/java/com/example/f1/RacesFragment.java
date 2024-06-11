package com.example.f1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.f1.api.ApiClient;
import com.example.f1.api.F1Api;
import com.example.f1.api.RaceAdapter;
import com.example.f1.api.RaceResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RacesFragment extends Fragment {

    private ListView racesListView;
    private RaceAdapter raceAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_races, container, false);

        racesListView = view.findViewById(R.id.racesListView);

        F1Api api = ApiClient.getClient().create(F1Api.class);
        api.getRaces().enqueue(new Callback<RaceResponse>() {
            @Override
            public void onResponse(@NonNull Call<RaceResponse> call, @NonNull Response<RaceResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    raceAdapter = new RaceAdapter(getContext(), response.body().mrData.raceTable.races);
                    racesListView.setAdapter(raceAdapter);
                } else {
                    Toast.makeText(getContext(), "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<RaceResponse> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "Failed to retrieve data", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
