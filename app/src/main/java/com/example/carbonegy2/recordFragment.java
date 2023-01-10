package com.example.carbonegy2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.text.InputType;
import android.view.KeyEvent;
import android.widget.TextView;
import android.view.inputmethod.EditorInfo;

import androidx.fragment.app.Fragment;

public class recordFragment extends Fragment {
    private Button button;
    private Button secondbutton;
    private Button electricbutton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_record, container, false);

        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        secondbutton = view.findViewById(R.id.secondbutton);
        secondbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showspinnerDialog();
            }
        });
        electricbutton = view.findViewById(R.id.electricbutton);
        electricbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showelectricDialog();
            }
        });

        return view;
    }

    private void showDialog() {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Enter your Carbon emission in Kg");

        final EditText input = new EditText(getActivity());
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Get the input text
                String inputText = input.getText().toString();
                int number = Integer.parseInt(inputText);

                // Do something with the input text here
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Cancel the dialog
                dialog.cancel();
            }
        });


        // Create and show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showspinnerDialog() {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Enter the distance you travelled in Km and choose vehicle");

        // Inflate a layout with an EditText and a Spinner
        View view = getLayoutInflater().inflate(R.layout.dialog_layout, null);
        final EditText input = view.findViewById(R.id.input);
        final Spinner spinner = view.findViewById(R.id.spinner);
        builder.setView(view);

        // Set the input type of the EditText to number and set an OnEditorActionListener
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // Close the dialog when the "enter" key is pressed

                    return true;
                }
                return false;
            }
        });

        // Set the spinner choices and adapter
        final String[] choices = {"SUV", "Sedan", "Motorbike", "Airplane"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, choices);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Get the input text and selected spinner item
                String inputText = input.getText().toString();
                int number = Integer.parseInt(inputText);
                String choice = spinner.getSelectedItem().toString();
                switch (choice) {
                    case "SUV":
                        number *= 3;
                        break;
                    case "Sedan":
                        number *= 2;
                        break;
                    case "Motorbike":
                        number *= 1.6;
                        break;
                    case "Airplane":
                        number *= 4;


                        // Do something with the input text and selected item here

                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Cancel the dialog
                dialog.cancel();
            }
        });

        // Create and show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void showelectricDialog() {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Enter your power usage for the month in Kw/h");

        final EditText input = new EditText(getActivity());
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Get the input text
                String inputText = input.getText().toString();
                int number = Integer.parseInt(inputText);

                // Do something with the input text here
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Cancel the dialog
                dialog.cancel();
            }
        });


        // Create and show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}



