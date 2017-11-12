package ca.antonious.betahub.data;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import ca.antonious.betahub.models.Repository;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by George on 2017-11-12.
 */

public class MockRepositoryApi implements RepositoryApi {
    @Override
    public Call<List<Repository>> getPopularRepositories() {
        return new Call<List<Repository>>() {
            @Override
            public Response<List<Repository>> execute() throws IOException {
                return null;
            }

            @Override
            public void enqueue(Callback<List<Repository>> callback) {
                callback.onResponse(this, Response.success(getDummyRepos()));
            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<List<Repository>> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };
    }

    private List<Repository> getDummyRepos() {
        Repository repository1 = new Repository();
        repository1.setName("tripods-web-services");
        repository1.setTotalStars(20);

        Repository repository2 = new Repository();
        repository2.setName("tripods-ios-app");
        repository1.setTotalStars(59);

        return Arrays.asList(repository1, repository2);
    }
}
