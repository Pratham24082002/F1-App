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
import com.example.f1.api.DriverAdapter;
import com.example.f1.api.DriverStandingsResponse;
import com.example.f1.api.F1Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DriverStandingsFragment extends Fragment {

    private ListView driverStandingsListView;
    private DriverAdapter driverAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_driver_standings, container, false);

        driverStandingsListView = view.findViewById(R.id.driverStandingsListView);

        F1Api api = ApiClient.getClient().create(F1Api.class);
        api.getDriverStandings().enqueue(new Callback<DriverStandingsResponse>() {
            @Override
            public void onResponse(@NonNull Call<DriverStandingsResponse> call, @NonNull Response<DriverStandingsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    driverAdapter = new DriverAdapter(getContext(), response.body().mrData.standingsTable.standingsLists.get(0).driverStandings);
                    driverStandingsListView.setAdapter(driverAdapter);
                } else {
                    Toast.makeText(getContext(), "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<DriverStandingsResponse> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "Failed to retrieve data", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
