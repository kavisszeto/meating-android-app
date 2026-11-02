package com.example.meating.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;



import com.example.meating.MainActivity;
import com.example.meating.R;
import com.example.meating.databinding.FragmentCartBinding;
import com.example.meating.ui.shop.Meat;

import java.util.Map;

import java.util.Map;

public class CartFragment extends Fragment {

    private FragmentCartBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        CartViewModel cartViewModel =
                new ViewModelProvider(this).get(CartViewModel.class);

        binding = FragmentCartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        MainActivity mainActivity = (MainActivity) getActivity();
        String str = "";
        float total = 0.0f;

        for (Map.Entry<Meat, Float> set : mainActivity.selectedMeats.entrySet()) {
            str += set.getKey().name + " $ " + set.getValue() + "\n";
            total += set.getValue();
        }

        float cashAfter = mainActivity.currentCash - total;

        str += "總共: $ " + total + "\n";
        str += "目前餘額: $ " + mainActivity.currentCash + "\n";
        str += "購買後餘額: $ " + cashAfter + "\n";

        ((TextView)root.findViewById(R.id.details)).setText(str);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.selectedMeats.clear();
        binding = null;
    }
}