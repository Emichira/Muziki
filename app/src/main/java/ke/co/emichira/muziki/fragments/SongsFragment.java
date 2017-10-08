package ke.co.emichira.muziki.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ke.co.emichira.muziki.R;
import ke.co.emichira.muziki.adapters.SongsListAdapter;
import ke.co.emichira.muziki.dataloaders.SongLoader;


public class SongsFragment extends Fragment {


    private SongsListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_main, container, false);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));

        mAdapter = new SongsListAdapter(getActivity(), SongLoader.getAllSongs(getActivity()));
        recyclerView.setAdapter(mAdapter);

        return recyclerView;
    }

}
