package upc.eetac.dsa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TrackManagerAPI {

    // GET a list of all existing Tracks
    @GET("tracks")
    Call<List<Track>> getTracks();

    // POST -> ADD a new Track
    @POST("tracks")
    Call<Track> addTrack(@Body Track track);

    // PUT -> EDIT an already existing Track
    @PUT("tracks")
    Call<Void> editTrack(@Body Track track);

    // DELETE an already existing Tack by id
    @DELETE("tracks/{id}")
    Call<Void> deleteTrack(@Path("id") String id);

}
