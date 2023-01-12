package com.example.carbonegy2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        // Find the ProgressBar and set it to be determinate
        ProgressBar progressBar = view.findViewById(R.id.progress_bar);
        progressBar.setIndeterminate(false);

        // Set the progress value based on the current emission value
        int currentEmission = 75;
        int emissionsGoal = 100;
        int progress = (int) (((float) currentEmission / emissionsGoal) * 100);
        progressBar.setMax(100);
        progressBar.setProgress(progress);



        // TODO: Set the adapter for the ListView

        // Find the TextView and set its text
        TextView textView = view.findViewById(R.id.text_view);
        textView.setText("Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun Fact Fun");


        return view;
    }
}