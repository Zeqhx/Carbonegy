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

    RecyclerView rv;
    RecyclerView rv2;
    ArrayList<String> dataSource;
    LinearLayoutManager linearLayoutManager;
    MyRvAdapter myRvAdapter;
    MyRvAdapter2 myRvAdapter2;

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

//        record1 = view.findViewById(R.id.Record1);
//        record2 = view.findViewById(R.id.Record2);
//        record3 = view.findViewById(R.id.Record3);
//        record4 = view.findViewById(R.id.Record4);
//        record5 = view.findViewById(R.id.Record5);
//        record6 = view.findViewById(R.id.Record6);

        dbHelper = new MyDBHelper(getActivity());

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String email = sharedPref.getString("email", "default_email");
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("users", new String[]{"id"}, "email = ?", new String[]{email}, null, null, null);
        if (cursor.moveToFirst()) {
            userId = cursor.getInt(0);
        }
        cursor.close();

        //horizontal recyclerview
        rv = view.findViewById(R.id.horizontalRv);

        //save data source
        dataSource = new ArrayList<>();
        dataSource.add("The world can emit more than 2.4 million pounds of CO2 per second.");
        dataSource.add("Travelling by bike or foot emits a fraction of the CO2 *of a car*.");
        dataSource.add("Fossil fuel account for around 80-90 per cent of our CO2 emissions.");
        dataSource.add("Buildings emit 39 percent of the CO2 **released in the US**.");
        dataSource.add("More paper you use, more you are contributing to carbon emissions.");
        dataSource.add("On the scale of CO2 emissions,human sources far outweigh volcanoes.");

//        linearLayoutManager = (new LinearLayoutManager(getActivity()));
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
//        linearLayoutManager = new LinearLayoutManager(getActivity(),FirstFragment.classLinearLayoutManager.HORIZONTAL, false);

        myRvAdapter = new MyRvAdapter(dataSource);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(myRvAdapter);

        //vertical recyclerview
        rv2 = view.findViewById(R.id.verticalRv);

        //save data source
        dataSource = new ArrayList<>();
        dataSource.add("20km trip in sedan emits 20% carbon");
        dataSource.add("4.5km trip in SUV emits 13% carbon");
        dataSource.add("6.1km trip in motorbike emits 5% carbon");


        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        myRvAdapter2 = new MyRvAdapter2(dataSource);
        rv2.setLayoutManager(linearLayoutManager);
        rv2.setAdapter(myRvAdapter2);



        return view;
    }


    class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyHolder>{
        ArrayList<String> data;

        public MyRvAdapter(ArrayList<String> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(FirstFragment.this).inflate(R.layout.rv_item, parent, false);
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
            return new MyHolder(view);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            holder.funFact.setText(data.get(position));

        }

        class MyHolder extends RecyclerView.ViewHolder{

            TextView funFact;

            public MyHolder(@NonNull View itemView) {
                super(itemView);
                funFact = itemView.findViewById(R.id.funFact);
            }
        }

    }


    class MyRvAdapter2 extends RecyclerView.Adapter<MyRvAdapter2.MyHolder2>{
        ArrayList<String> data2;

        public MyRvAdapter2(ArrayList<String> data) {
            this.data2 = data;
        }

        @NonNull
        @Override
        public MyHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(FirstFragment.this).inflate(R.layout.rv_item, parent, false);
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list, parent, false);
            return new MyHolder2(view);
        }

        @Override
        public int getItemCount() {
            return data2.size();
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder2 holder, int position) {
            holder.recentRecord.setText(data2.get(position));

        }

        class MyHolder2 extends RecyclerView.ViewHolder{

            TextView recentRecord;

            public MyHolder2(@NonNull View itemView) {
                super(itemView);
                recentRecord = itemView.findViewById(R.id.recentRecord);
            }
        }

    }




}