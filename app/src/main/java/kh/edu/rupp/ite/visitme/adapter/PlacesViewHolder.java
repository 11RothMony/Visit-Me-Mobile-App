package kh.edu.rupp.ite.visitme.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import kh.edu.rupp.ite.visitme.databinding.ViewHolderPlacesBinding;
import kh.edu.rupp.ite.visitme.model.Places;

public class PlacesViewHolder extends RecyclerView.ViewHolder {

    private final ViewHolderPlacesBinding binding;
    public PlacesViewHolder(ViewHolderPlacesBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }
    public void bind(Places places){
        Picasso.get().load(places.getImageUrl()).into(binding.imgPlaces);
        binding.txtNamePlaces.setText(places.getName());
        binding.txtTitle.setText(places.getType());
        binding.distance.setText(String.valueOf((float) places.getDistance()));
    }
}
