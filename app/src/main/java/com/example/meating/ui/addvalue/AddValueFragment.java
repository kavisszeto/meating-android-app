package com.example.meating.ui.addvalue;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.meating.MainActivity;
import com.example.meating.R;
import com.example.meating.databinding.FragmentAddvalueBinding;

public class AddValueFragment extends Fragment {
    public static AddValueFragment instance;
    private FragmentAddvalueBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        instance = this;

        AddValueViewModel viewModel =
                new ViewModelProvider(this).get(AddValueViewModel.class);

        binding = FragmentAddvalueBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        MainActivity mainActivity = (MainActivity) getActivity();
        ((TextView) root.findViewById(R.id.currentCash)).setText("目前餘額: " + mainActivity.currentCash);
        ((EditText) root.findViewById(R.id.input_amount)).setText("0.0");

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        instance = null;
    }

    public float getAddAmount() {
        String str = ((EditText) binding.getRoot().findViewById(R.id.input_amount)).getText().toString();
        return Float.parseFloat(str);
    }
}