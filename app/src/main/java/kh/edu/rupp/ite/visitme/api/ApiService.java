package kh.edu.rupp.ite.visitme.api;

import java.util.List;

import kh.edu.rupp.ite.visitme.model.Places;
import kh.edu.rupp.ite.visitme.model.ProfileData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("top-places.json")
    Call<List<Places>> loadPlaces();

    @GET("user-profile.json")
    Call<ProfileData> loadProfileData();
}
