package upc.eetac.dsa;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<List<Track>> {  // FOR THE GET TRACKS

    public static final String BASE_URL = "http://localhost:8080/myapp/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        TrackManagerAPI tracksAPI = retrofit.create(TrackManagerAPI.class);

        Call<List<Track>> call = tracksAPI.getTracks();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
        if(response.isSuccessful()) {
            List<Track> trackList = response.body();
            trackList.forEach(change -> System.out.println(change.title));
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Track>> call, Throwable t) {
        t.printStackTrace();
    }
}
