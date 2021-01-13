package com.example.telemedicine.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.telemedicine.R;

public class NotificationFragment extends Fragment {

    private FragmentHandler fragmentHandler;

    public NotificationFragment(FragmentHandler fragmentHandler) {
        this.fragmentHandler = fragmentHandler;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, null);

        return view;
    }
}
