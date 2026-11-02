package com.example.meating;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class LoginDiaLogFrament extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View binding = inflater.inflate(R.layout.dialog_signin, null);

        AlertDialog alertDialog = builder.setView(binding)
                .setTitle("Meating")
                // Add action buttons
                .setPositiveButton(R.string.login, null)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        LoginDiaLogFrament.this.getDialog().cancel();
                    }
                })
                .setNeutralButton(R.string.register, null)
                .create();

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                // 登錄按鈕
                Button pBtn = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                pBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String username = ((TextView) binding.findViewById(R.id.username)).getText().toString();
                        String password = ((TextView) binding.findViewById(R.id.password)).getText().toString();

                        if (username.equals("admin") && password.equals("admin")) {
                            MainActivity mainActivity = (MainActivity) getActivity();
                            mainActivity.onLogInSucceeded();
                            alertDialog.dismiss();
                        } else {
                            Toast.makeText(getContext(), "錯誤帳號或密碼", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                Button nBtn = alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
                nBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), RegisterActivity.class);
                        startActivity(intent);
                        alertDialog.dismiss();
                    }
                });

            }
        });

        return alertDialog;
    }
}