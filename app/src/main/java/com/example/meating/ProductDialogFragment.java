package com.example.meating;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.meating.ui.shop.Meat;

public class ProductDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        MainActivity mainActivity = (MainActivity) getActivity();
        Meat m = mainActivity.meatForProductDialog;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View binding = inflater.inflate(R.layout.dialog_product, null);

        Spinner spinner = (Spinner) binding.findViewById(R.id.p_size);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.sizes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelected(true);
        ((TextView)binding.findViewById(R.id.p_price)).setText("$" + Float.toString(m.priceSmall));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        ((TextView)binding.findViewById(R.id.p_price)).setText("$" + Float.toString(m.priceSmall));
                        break;
                    case 1:
                        ((TextView)binding.findViewById(R.id.p_price)).setText("$" + Float.toString(m.priceMedium));
                        break;
                    case 2:
                        ((TextView)binding.findViewById(R.id.p_price)).setText("$" + Float.toString(m.priceLarge));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        AlertDialog alertDialog = builder.setView(binding)
                .setTitle(m.name)
                // Add action buttons
                .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity mainActivity = (MainActivity) getActivity();

                        switch(spinner.getSelectedItemPosition()) {
                            case 0:
                                mainActivity.selectedMeats.put(m, m.priceSmall);
                                break;
                            case 1:
                                mainActivity.selectedMeats.put(m, m.priceMedium);
                                break;
                            case 2:
                                mainActivity.selectedMeats.put(m, m.priceLarge);
                                break;
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ProductDialogFragment.this.getDialog().cancel();
                    }
                })
                .create();

        return alertDialog;
    }
}