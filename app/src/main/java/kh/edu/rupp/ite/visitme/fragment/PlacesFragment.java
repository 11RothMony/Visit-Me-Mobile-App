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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kh.edu.rupp.ite.visitme.adapter.PlacesAdapter;
import kh.edu.rupp.ite.visitme.api.ApiService;
import kh.edu.rupp.ite.visitme.databinding.FragmentHomeBinding;
import kh.edu.rupp.ite.visitme.databinding.FragmentPlacesBinding;
import kh.edu.rupp.ite.visitme.model.Places;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlacesFragment extends Fragment {
    private FragmentPlacesBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPlacesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadPlaces();
    }

    private void loadPlaces(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://smlp-pub.s3.ap-southeast-1.amazonaws.com/iteapp-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.loadPlaces().enqueue(new Callback<List<Places>>() {
            @Override
            public void onResponse(Call<List<Places>> call, Response<List<Places>> response) {
                if (response.isSuccessful()){
                    showPlaces(response.body());
                }else {
                    Toast.makeText(requireContext(), "Error data from server.", Toast.LENGTH_LONG).show();
                    Log.e("ite-app", "Error Data" + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Places>> call, Throwable throwable) {
                Toast.makeText(requireContext(), "Error data from server.", Toast.LENGTH_LONG).show();
                Log.e("ite-app", "Error data" + throwable.getMessage());
            }
        });
    }
    private void showPlaces(List<Places> places){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);

        PlacesAdapter adapter = new PlacesAdapter();
        adapter.setPlaces(places);
        binding.recyclerView.setAdapter(adapter);

    }
}
