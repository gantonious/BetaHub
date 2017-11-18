package ca.antonious.betahub.repository.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ca.antonious.betahub.R;
import ca.antonious.betahub.models.Repository;

public class RepositoryDetailsActivity extends AppCompatActivity {
    public static final String EXTRA_REPOSITORY = "RepositoryDetailsActivity.Repository";

    private TextView repositoryNameTextView;
    private TextView totalForksTextView;
    private TextView totalWatchersTextView;
    private TextView totalStarsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_details);

        initializeViews();

        Repository repository = (Repository) getIntent().getSerializableExtra(EXTRA_REPOSITORY);
        renderRepository(repository);
    }

    private void initializeViews() {
        repositoryNameTextView = (TextView) findViewById(R.id.repository_name);
        totalForksTextView = (TextView) findViewById(R.id.total_forks);
        totalWatchersTextView = (TextView) findViewById(R.id.total_watchers);
        totalStarsTextView = (TextView) findViewById(R.id.total_stars);
    }

    private void renderRepository(Repository repository) {
        repositoryNameTextView.setText(repository.getName());
        totalStarsTextView.setText(String.format("Total stars: %d", repository.getTotalStars()));
        totalWatchersTextView.setText(String.format("Total watchers: %d", repository.getTotalWatchers()));
        totalForksTextView.setText(String.format("Total forks: %d", repository.getTotalForks()));
    }
}
