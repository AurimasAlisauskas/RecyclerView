package Adapter;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerview.DetailsActivity;
import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

import Model.ListItem;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<ListItem>listItems;

    public MyAdapter (Context context, List listItem) {
        this.context = context;
        this.listItems = listItem;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new ViewHolder(v, context, (ArrayList<ListItem>) listItems);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ListItem item = listItems.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.rating.setText(item.getRating());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView description;
        public TextView rating;

        public ViewHolder(View view, Context cxt, ArrayList<ListItem> items) {
            super(view);

            itemView.setOnClickListener(this);

            listItems = items;
            context = cxt;

            name = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            rating = itemView.findViewById(R.id.rating);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            ListItem item = listItems.get(position);

            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("name", item.getName());
            intent.putExtra("description", item.getDescription());
            intent.putExtra("rating", item.getRating());

            context.startActivity(intent);

            //Toast.makeText(context, item.getName(), Toast.LENGTH_LONG).show();
        }
    }

}
