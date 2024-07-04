package kh.edu.rupp.ite.visitme.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import kh.edu.rupp.ite.visitme.adapter.FavoritePlaceAdapter;
import kh.edu.rupp.ite.visitme.api.ApiService;
import kh.edu.rupp.ite.visitme.databinding.FragmentProfileBinding;
import kh.edu.rupp.ite.visitme.model.ProfileData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadProfileData();
    }

    private void loadProfileData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://smlp-pub.s3.ap-southeast-1.amazonaws.com/iteapp-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.loadProfileData().enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    disPlayProfile(response.body());

                }else {
                    Toast.makeText(requireContext(), "Error data from server.", Toast.LENGTH_LONG).show();
                    Log.e("ite-app", "Error Data" + response.message());
                }
            }

            @Override
            public void onFailure(Call<ProfileData> call, Throwable throwable) {
                Toast.makeText(requireContext(), "Error data from server.", Toast.LENGTH_LONG).show();
                Log.e("ite-app", "Error data" + throwable.getMessage());
            }
        });
    }


    private void disPlayProfile(ProfileData profile) {
        binding.firstName.setText(profile.getFirstName());
        binding.lastName.setText(profile.getLastName());
        binding.email.setText(profile.getEmail());
        binding.bio.setText(profile.getBio());
//        Picasso.get()
//                .load(profile.getCoverImage())
//                .into(binding.coverImage);
        Picasso.get()
                .load(profile.getProfileImage())
                .into(binding.imageProfile);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.recycleViewProfile.setLayoutManager(layoutManager);

        FavoritePlaceAdapter adapter = new FavoritePlaceAdapter();
        adapter.setDataSet(profile.getFavoritePlaces());
        binding.recycleViewProfile.setAdapter(adapter);

    }
}
