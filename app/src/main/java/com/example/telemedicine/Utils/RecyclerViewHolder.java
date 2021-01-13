package com.example.telemedicine.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.telemedicine.Fragments.FragmentHandler;
import com.example.telemedicine.Models.DoctorModel;
import com.example.telemedicine.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public DoctorModel model;

    private LinearLayout layout;

    private FragmentHandler fragmentHandler;

    public RecyclerViewHolder(@NonNull View itemView, FragmentHandler fragmentHandler) {
        super(itemView);

        layout = itemView.findViewById(R.id.doctor_item);
        layout.setOnClickListener(this);
        this.fragmentHandler = fragmentHandler;
    }

    public void setItem(@NonNull DoctorModel model) {

        this.model = model;
    }

    @Override
    public void onClick(View view) {
        fragmentHandler.getMainActivity().setToolbarTitle("Doctor Details");
        fragmentHandler.loadDocDetailsFragment();
    }
}
