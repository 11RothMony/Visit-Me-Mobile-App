package kh.edu.rupp.ite.visitme.adapter;

        import android.view.View;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.squareup.picasso.Picasso;

        import kh.edu.rupp.ite.visitme.databinding.ViewHorderProfileDataBinding;
        import kh.edu.rupp.ite.visitme.model.FavoritePlaceinProfile;
        import kh.edu.rupp.ite.visitme.model.ProfileData;

public class FavoritePlaceViewHolder extends RecyclerView.ViewHolder {

    private final ViewHorderProfileDataBinding binding;
    public FavoritePlaceViewHolder(ViewHorderProfileDataBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }

    public void bind(FavoritePlaceinProfile favoritePlaceinProfile){
        Picasso.get().load(favoritePlaceinProfile.getImageUrl()).into(binding.imageViewHolder);
        binding.titleImageFavorite.setText(favoritePlaceinProfile.getName());
        binding.titleImageFavorite.setText(favoritePlaceinProfile.getType());
    }
}

