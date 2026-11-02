package com.example.meating.ui.record;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.meating.MainActivity;
import com.example.meating.R;
import com.example.meating.databinding.FragmentRecordBinding;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.Date;

public class RecordFragment extends Fragment {

    private FragmentRecordBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecordViewModel viewModel =
                new ViewModelProvider(this).get(RecordViewModel.class);

        binding = FragmentRecordBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        MainActivity mainActivity = (MainActivity) getActivity();

        for (AbstractMap.SimpleEntry<Long, Float> r : mainActivity.records) {
            Date date = new Date(r.getKey());
            Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");

            ((TextView)root.findViewById(R.id.cash)).setText(format.format(date) + " $ " + r.getValue() + "\n");
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}