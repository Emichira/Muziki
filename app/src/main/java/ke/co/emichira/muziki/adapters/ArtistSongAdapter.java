package ke.co.emichira.muziki.adapters;

import android.app.Activity;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ke.co.emichira.muziki.R;
import ke.co.emichira.muziki.models.Song;

/**
 * Created by michira on 10/3/17.
 */

public class ArtistSongAdapter extends RecyclerView.Adapter<ArtistSongAdapter.ItemHolder> {

    private List<Song> arraylist;
    private Activity mContext;

    public ArtistSongAdapter(Activity context, List<Song> arraylist) {
        this.arraylist = arraylist;
        this.mContext = context;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if (viewType == 0) {
            View v0 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.artist_detail_albums_header, null);
            ItemHolder ml = new ItemHolder(v0);
            return ml;
        } else {
            View v2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_artist_song, null);
            ItemHolder ml = new ItemHolder(v2);
            return ml;
        }
    }

    @Override
    public void onBindViewHolder(ItemHolder itemHolder, int i) {

        if (getItemViewType(i) == 0) {
            //nothing
            setUpAlbums(itemHolder.albumsRecyclerView);
        }
        else {
            Song localItem = arraylist.get(i);
            itemHolder.title.setText(localItem.title);
//            itemHolder.album.setText(localItem.albumName);

//            ImageLoader.getInstance().displayImage(TimberUtils.getAlbumArtUri(localItem.albumId).toString(), itemHolder.albumArt, new DisplayImageOptions.Builder().cacheInMemory(true).showImageOnFail(R.drawable.ic_empty_music2).resetViewBeforeLoading(true).build());
//            setOnPopupMenuListener(itemHolder, i - 1);
        }

    }

//    @Override
//    public void onViewRecycled(ItemHolder itemHolder) {
//
//        if (itemHolder.getItemViewType() == 0)
//            clearExtraSpacingBetweenCards(itemHolder.albumsRecyclerView);
//
//    }

    @Override
    public int getItemCount() {
        return (null != arraylist ? arraylist.size() : 0);
    }

    private void setUpAlbums(RecyclerView albumsRecyclerview) {

        albumsRecyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        albumsRecyclerview.setHasFixedSize(true);

        //to add spacing between cards
        int spacingInPixels = mContext.getResources().getDimensionPixelSize(R.dimen.spacing_card);
        albumsRecyclerview.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        albumsRecyclerview.setNestedScrollingEnabled(false);


//        ArtistAlbumAdapter mAlbumAdapter = new ArtistAlbumAdapter(mContext, ArtistAlbumLoader.getAlbumsForArtist(mContext, artistID));
//        albumsRecyclerview.setAdapter(mAlbumAdapter);
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView title, album;
        protected ImageView albumArt, menu;
        protected RecyclerView albumsRecyclerView;

        public ItemHolder(View view) {
            super(view);

            this.albumsRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_album);

            this.title = (TextView) view.findViewById(R.id.song_title);
//            this.album = (TextView) view.findViewById(R.id.song_album);
//            this.albumArt = (ImageView) view.findViewById(R.id.albumArt);
//            this.menu = (ImageView) view.findViewById(R.id.popup_menu);


            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            Handler handler = new Handler();
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    MusicPlayer.playAll(mContext, songIDs, getAdapterPosition() - 1, artistID, TimberUtils.IdType.Artist, false);
//                    NavigationUtils.navigateToNowplaying(mContext, true);
//                }
//            }, 100);

        }

    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {

            //the padding from left
            outRect.left = space;


        }
    }
}