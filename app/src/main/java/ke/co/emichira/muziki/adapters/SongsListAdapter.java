package ke.co.emichira.muziki.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import ke.co.emichira.muziki.R;
import ke.co.emichira.muziki.models.Song;
import ke.co.emichira.muziki.utils.MuzikiUtils;

/**
 * Created by michira on 10/3/17.
 */

public class SongsListAdapter extends RecyclerView.Adapter<SongsListAdapter.ItemHolder> {

    private List<Song> arraylist;
    private Context mContext;

    public SongsListAdapter(Activity context, List<Song> arraylist) {
        this.arraylist = arraylist;
        this.mContext = context;

    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_song, null);
        ItemHolder ml = new ItemHolder(v);
        return ml;
    }

    @Override
    public void onBindViewHolder(ItemHolder itemHolder, int i) {
        Song localItem = arraylist.get(i);

        itemHolder.title.setText(localItem.title);
        itemHolder.artist.setText(localItem.artistName);

        ImageLoader.getInstance().displayImage(MuzikiUtils.getAlbumArtUri(localItem.albumId).toString(), itemHolder.albumArt, new DisplayImageOptions
                .Builder()
                .cacheInMemory(true)
                .showImageOnFail(R.drawable.ic_launcher)
                .resetViewBeforeLoading(true)
                .build());

    }

    @Override
    public int getItemCount() {
        return (null != arraylist ? arraylist.size() : 0);
    }


    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView title,artist;
        protected ImageView albumArt;

        public ItemHolder(View view) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.song_title);
            this.artist = (TextView) view.findViewById(R.id.song_artist);
            this.albumArt=(ImageView) view.findViewById(R.id.albumArt);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }

    }
}
