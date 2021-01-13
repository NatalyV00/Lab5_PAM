package com.example.telemedicine.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.telemedicine.Models.DoctorModel;
import com.example.telemedicine.R;
import com.example.telemedicine.Utils.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class DoctorListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerAdapter;

    private FragmentHandler fragmentHandler;

    public DoctorListFragment(FragmentHandler fragmentHandler) {
        this.fragmentHandler = fragmentHandler;
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_doctor_list, null);

        mRecyclerAdapter = new RecyclerViewAdapter(fragmentHandler);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setAdapter(mRecyclerAdapter);

        // Add some values
        getDoctors();

        return view;
    }

    private void getDoctors() {
        List<DoctorModel> docList = new ArrayList<>();
        docList.add(new DoctorModel());
        docList.add(new DoctorModel());

        mRecyclerAdapter.setList(docList);
    }
}
