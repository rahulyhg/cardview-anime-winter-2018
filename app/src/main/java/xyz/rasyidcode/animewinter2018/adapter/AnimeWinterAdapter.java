package xyz.rasyidcode.animewinter2018.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import xyz.rasyidcode.animewinter2018.model.AnimeWinter;
import xyz.rasyidcode.animewinter2018.R;

/**
 * Created by jamil on 2/14/2018.
 */

public class AnimeWinterAdapter extends RecyclerView.Adapter<AnimeWinterAdapter.MyViewHolder>{

    private Context awContext;
    private List<AnimeWinter> animeWinterList;

    public AnimeWinterAdapter(Context _awContext, List<AnimeWinter> _animeList) {
        this.awContext = _awContext;
        this.animeWinterList = _animeList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.anime_winter_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        AnimeWinter animeWinter = animeWinterList.get(position);
        holder.animeTitle.setText(animeWinter.getTitle());
        holder.numEps.setText(animeWinter.getNumOfEps() + " eps");

        Glide.with(awContext).load(animeWinter.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopUpMenu(holder.overflow);
            }
        });
    }

    private void showPopUpMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(awContext, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu_anime_winter, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new MyMenuClickListener());
        popupMenu.show();
    }

    @Override
    public int getItemCount() {
        return animeWinterList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView animeTitle, numEps;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View itemView) {
            super(itemView);
            animeTitle = itemView.findViewById(R.id.anime_title);
            numEps = itemView.findViewById(R.id.num_eps);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            overflow = itemView.findViewById(R.id.overflow);
        }
    }

    class MyMenuClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuClickListener() {}

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_watch_later:
                    Toast.makeText(awContext, "Watch Later", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_add_to_favorite:
                    Toast.makeText(awContext, "Add to Favorite", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
}
