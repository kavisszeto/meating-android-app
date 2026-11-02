package com.example.meating.ui.member;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.meating.MainActivity;
import com.example.meating.LogInOutListener;
import com.example.meating.databinding.FragmentMemberBinding;
public class MemberFragment extends Fragment implements LogInOutListener  {

    static public MemberFragment instance;
    private FragmentMemberBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MemberViewModel viewModel =
                new ViewModelProvider(this).get(MemberViewModel.class);

        binding = FragmentMemberBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        setBtnsStatus();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        instance = null;
    }

    @Override
    public void onLogInSucceeded() {
        setBtnsStatus();
    }

    @Override
    public void onLogOutSucceeded() {
        setBtnsStatus();
    }

    public void setBtnsStatus() {
        MainActivity mainActivity = (MainActivity) getActivity();

        if(!mainActivity.hasBeenLoggedIn) {
            binding.btnLogIn.setVisibility(View.VISIBLE);
            binding.btnSignUp.setVisibility(View.VISIBLE);
            binding.navAddvalue.setVisibility(View.GONE);
            binding.navRecord.setVisibility(View.GONE);
            binding.navPersonal.setVisibility(View.GONE);
            binding.btnLogOut.setVisibility(View.GONE);
        } else {
            binding.btnLogIn.setVisibility(View.GONE);
            binding.btnSignUp.setVisibility(View.GONE);
            binding.navAddvalue.setVisibility(View.VISIBLE);
            binding.navRecord.setVisibility(View.VISIBLE);
            binding.navPersonal.setVisibility(View.VISIBLE);
            binding.btnLogOut.setVisibility(View.VISIBLE);
            Toast.makeText(getContext(), "Welcome back!", Toast.LENGTH_SHORT).show();
        }
    }
}