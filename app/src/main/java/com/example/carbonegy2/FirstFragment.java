package com.example.carbonegy2;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    private MyDBHelper dbHelper;
    private TextView record1,record2,record3,record4,record5,record6;
    private int userId;

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




        record1 = view.findViewById(R.id.Record1);
        record2 = view.findViewById(R.id.Record2);
        record3 = view.findViewById(R.id.Record3);
        record4 = view.findViewById(R.id.Record4);
        record5 = view.findViewById(R.id.Record5);
        record6 = view.findViewById(R.id.Record6);

        dbHelper = new MyDBHelper(getActivity());

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String email = sharedPref.getString("email", "default_email");
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("users", new String[]{"id"}, "email = ?", new String[]{email}, null, null, null);
        if (cursor.moveToFirst()) {
            userId = cursor.getInt(0);
        }
        cursor.close();


        return view;
    }




}