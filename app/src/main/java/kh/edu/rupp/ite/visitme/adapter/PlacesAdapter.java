package kh.edu.rupp.ite.visitme.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kh.edu.rupp.ite.visitme.databinding.ViewHolderPlacesBinding;
import kh.edu.rupp.ite.visitme.model.Places;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesViewHolder> {

    private List<Places> dataset;

    public void setPlaces(List<Places> dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewHolderPlacesBinding binding = ViewHolderPlacesBinding.inflate(inflater, parent, false);
        return new PlacesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesViewHolder holder, int position) {
        Places places = dataset.get(position);
        holder.bind(places);
    }

    @Override
    public int getItemCount() {
        if (dataset == null){
            return 0;
        }else {
            return dataset.size();
        }
    }
}
