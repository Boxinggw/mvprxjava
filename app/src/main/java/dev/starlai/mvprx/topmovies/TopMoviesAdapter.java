package dev.starlai.mvprx.topmovies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.starlai.mvprx.R;
import dev.starlai.mvprx.repo.ViewModel;

/**
 * Created by izayoi on 11/17/2016.
 */

public class TopMoviesAdapter extends RecyclerView.Adapter<TopMoviesAdapter.ViewHolder> {

    private List<ViewModel> viewModels;

    public TopMoviesAdapter(List<ViewModel> viewModels) {
        this.viewModels = viewModels;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemName.setText(viewModels.get(position).getName());
        holder.countryName.setText(viewModels.get(position).getCountry());

    }

    @Override
    public int getItemCount() {
        return viewModels.size();
    }

    public class ViewHolder  extends  RecyclerView.ViewHolder{

        @BindView(R.id.textView_fragmentlist_task_name) TextView itemName;
        @BindView(R.id.textView_fragmentlist_country_name) TextView countryName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
