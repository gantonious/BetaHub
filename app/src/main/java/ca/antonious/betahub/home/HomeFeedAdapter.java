package ca.antonious.betahub.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import ca.antonious.betahub.R;
import ca.antonious.betahub.models.Repository;

/**
 * Created by George on 2017-11-12.
 */

public class HomeFeedAdapter extends ArrayAdapter<Repository> {
    public HomeFeedAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = getListItemView(convertView, parent);
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.repository_name);

        Repository repository = getItem(position);
        nameTextView.setText(repository.getName());

        return listItemView;
    }

    private View getListItemView(@Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView != null) {
            return convertView;
        }
        return LayoutInflater.from(getContext()).inflate(R.layout.list_item_repository, parent, false);
    }
}
