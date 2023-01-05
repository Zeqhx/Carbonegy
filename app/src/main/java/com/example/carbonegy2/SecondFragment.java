package com.example.carbonegy2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.carbonegy2.R;

public class SecondFragment extends Fragment {

    // Declare a context object
    Context context;
    int inputNumber;
    TextView textView;
    SharedPreferences sharedPreferences;  // Declare a shared preferences object

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        context = getActivity();
        sharedPreferences = context.getSharedPreferences("com.example.carbonegy2", Context.MODE_PRIVATE);
        inputNumber = sharedPreferences.getInt("input_number", 0);
        textView = view.findViewById(R.id.card);
        textView.setText("Your current goal is to reduce emissions by: " + String.valueOf(inputNumber) + "%");




        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNumberInputDialog();
            }
        });

        return view;
    }

    public void showNumberInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Enter a number");

        // Set up the input
        final EditText input = new
                EditText(context);
        // Specify the type of input expected; this, for example, sets the input as a number
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(3);  // Set the max length to 3
        input.setFilters(filters);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String inputValue = input.getText().toString();
                if (inputValue.isEmpty()) {
                    // Show an error message if the input value is empty
                    Toast.makeText(context, "Enter a number between 1 and 100", Toast.LENGTH_SHORT).show();
                    return;
                }

                inputNumber =  Integer.parseInt(inputValue);


                if (inputNumber >= 1 && inputNumber <= 100) {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("input_number", inputNumber);
                    editor.apply();
                    // Get the input value

                    textView.setText("Your current goal is to reduce emissions by: " + String.valueOf(inputNumber) + "%");
                    // Do something with the input value
                } else {
                    Toast.makeText(context, "Enter a number between 1 and 100", Toast.LENGTH_SHORT).show();

                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}

