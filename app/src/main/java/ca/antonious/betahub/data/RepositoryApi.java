package ca.antonious.betahub.data;

import java.util.List;

import ca.antonious.betahub.models.Repository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by George on 2017-11-12.
 */

public interface RepositoryApi {
    @GET("/users/{username}/repos")
    Call<List<Repository>> getAllRepositories(@Path("username") String username);
}
