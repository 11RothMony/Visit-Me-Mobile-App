package kh.edu.rupp.ite.visitme.adapter;

        import android.view.LayoutInflater;
        import android.view.ViewGroup;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.List;

        import kh.edu.rupp.ite.visitme.model.FavoritePlaceinProfile;
        //import kh.edu.rupp.ite.visitme.model.Place;
        //import kh.edu.rupp.ite.visitme.databinding.ViewHolderProfileBinding;
        import kh.edu.rupp.ite.visitme.databinding.ViewHorderProfileDataBinding;

public class FavoritePlaceAdapter extends RecyclerView.Adapter<FavoritePlaceViewHolder> {

    private List<FavoritePlaceinProfile> data;

    public void setDataSet(List<FavoritePlaceinProfile> dataSet) {
        this.data = dataSet;
    }

    @NonNull
    @Override
    public FavoritePlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewHorderProfileDataBinding binding = ViewHorderProfileDataBinding.inflate(inflater, parent, false);
        return new FavoritePlaceViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritePlaceViewHolder holder, int position) {
        FavoritePlaceinProfile favoritePlace = data.get(position);
        holder.bind(favoritePlace);
    }

    @Override
    public int getItemCount() {
        if(data == null){
            return 0;
        } else {
            return data.size();
        }
    }
}

