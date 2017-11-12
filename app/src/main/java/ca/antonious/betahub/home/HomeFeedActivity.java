package ca.antonious.betahub.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import ca.antonious.betahub.R;
import ca.antonious.betahub.data.MockRepositoryApi;
import ca.antonious.betahub.data.RepositoryApi;
import ca.antonious.betahub.models.Repository;
import ca.antonious.betahub.repository.details.RepositoryDetailsActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFeedActivity extends AppCompatActivity {

    private RepositoryApi repositoryApi;
    private HomeFeedAdapter homeFeedAdapter;
    private ProgressBar loadingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_feed);

        initializeViews();
        initializeGithubApi();
    }

    private void initializeViews() {
        loadingProgressBar = (ProgressBar) findViewById(R.id.loading_indicator);

        ListView homeFeedListView = (ListView) findViewById(R.id.home_list_view);
        homeFeedAdapter = new HomeFeedAdapter(this, R.id.home_list_view);

        homeFeedListView.setAdapter(homeFeedAdapter);
        homeFeedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Repository repository = (Repository) adapterView.getAdapter().getItem(i);
                launchRepositoryDetails(repository);
            }
        });
    }

    private void initializeGithubApi() {
        repositoryApi = new MockRepositoryApi();
    }

    private void launchRepositoryDetails(Repository repository) {
        Intent repositoryDetailsIntent = new Intent(this, RepositoryDetailsActivity.class);
        repositoryDetailsIntent.putExtra(RepositoryDetailsActivity.EXTRA_REPOSITORY, repository);
        startActivity(repositoryDetailsIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        repositoryApi.getPopularRepositories().enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                homeFeedAdapter.clear();
                homeFeedAdapter.addAll(response.body());
                loadingProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                Toast.makeText(HomeFeedActivity.this, "Looks like something went wrong", Toast.LENGTH_SHORT)
                        .show();
                
                loadingProgressBar.setVisibility(View.GONE);
            }
        });
    }
}
