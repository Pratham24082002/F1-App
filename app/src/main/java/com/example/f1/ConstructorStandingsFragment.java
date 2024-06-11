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
import com.example.f1.api.ConstructorAdapter;
import com.example.f1.api.ConstructorStandingsResponse;
import com.example.f1.api.F1Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConstructorStandingsFragment extends Fragment {

    private ListView constructorStandingsListView;
    private ConstructorAdapter constructorAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_constructor_standings, container, false);

        constructorStandingsListView = view.findViewById(R.id.constructorStandingsListView);

        F1Api api = ApiClient.getClient().create(F1Api.class);
        api.getConstructorStandings().enqueue(new Callback<ConstructorStandingsResponse>() {
            @Override
            public void onResponse(@NonNull Call<ConstructorStandingsResponse> call, @NonNull Response<ConstructorStandingsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    constructorAdapter = new ConstructorAdapter(getContext(), response.body().mrData.standingsTable.standingsLists.get(0).constructorStandings);
                    constructorStandingsListView.setAdapter(constructorAdapter);
                } else {
                    Toast.makeText(getContext(), "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ConstructorStandingsResponse> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "Failed to retrieve data", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
