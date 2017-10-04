package ke.co.emichira.muziki.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ke.co.emichira.muziki.models.Song;
import ke.co.emichira.muziki.R;
/**
 * Created by michira on 10/3/17.
 */

public class SongsListAdapter extends RecyclerView.Adapter<SongsListAdapter.AllSongsGridHolder> {

    private List<Song> allSongsList;
    private Context mContext;

    public SongsListAdapter(Context context, List<Song> allSongsList) {
        this.allSongsList = allSongsList;
        this.mContext = context;
    }

    @Override
    public AllSongsGridHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_song, null);
        AllSongsGridHolder ml = new AllSongsGridHolder(v);
        return ml;
    }

    @Override
    public void onBindViewHolder(AllSongsGridHolder allSongsGridHolder, int i) {
        Song allSongsItem = allSongsList.get(i);

        allSongsGridHolder.title.setText(allSongsItem.getTitle());
        allSongsGridHolder.artist.setText(allSongsItem.getArtist());

    }

    @Override
    public int getItemCount() {
        return (null != allSongsList ? allSongsList.size() : 0);
    }


    public class AllSongsGridHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView title,artist;

        public AllSongsGridHolder(View view) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.song_title);
            this.artist = (TextView) view.findViewById(R.id.song_artist);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }

    }
}
