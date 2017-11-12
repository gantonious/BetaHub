package ca.antonious.betahub.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import ca.antonious.betahub.R;
import ca.antonious.betahub.data.MockRepositoryApi;
import ca.antonious.betahub.data.RepositoryApi;
import ca.antonious.betahub.models.Repository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFeedActivity extends AppCompatActivity {

    private RepositoryApi repositoryApi;
    private HomeFeedAdapter homeFeedAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_feed);

        initializeGithubApi();
        initializeListView();
    }

    private void initializeListView() {
        homeFeedAdapter = new HomeFeedAdapter(this, R.id.home_list_view);
        ListView homeFeedListView = (ListView) findViewById(R.id.home_list_view);
        homeFeedListView.setAdapter(homeFeedAdapter);
    }

    private void initializeGithubApi() {
        repositoryApi = new MockRepositoryApi();
    }

    @Override
    protected void onResume() {
        super.onResume();

        repositoryApi.getPopularRepositories().enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                homeFeedAdapter.clear();
                homeFeedAdapter.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                Toast.makeText(HomeFeedActivity.this, "Looks like something went wrong", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}