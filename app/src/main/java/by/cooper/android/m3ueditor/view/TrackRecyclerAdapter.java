package by.cooper.android.m3ueditor.view;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import by.cooper.android.m3ueditor.model.Track;

public class TrackRecyclerAdapter extends RecyclerView.Adapter<TrackRecyclerAdapter.TrackBindingHolder> {

    @NonNull
    private List<Track> mTracks = new ArrayList<>();

    public TrackRecyclerAdapter(@NonNull List<Track> tracks) {
        this.mTracks = tracks;
    }

    @Override
    public TrackBindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // TODO: inflate view and return new TrackBindingHolder;
        return null;
    }

    @Override
    public void onBindViewHolder(TrackBindingHolder holder, int position) {
        // TODO: get track from list create ViewModel and execute pending binding
    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }

    public void setTracks(@NonNull final List<Track> tracks) {
        mTracks.clear();
        mTracks.addAll(tracks);
        notifyDataSetChanged();
    }

    public static final class TrackBindingHolder extends RecyclerView.ViewHolder {

        private final ViewDataBinding mBinding;

        public TrackBindingHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getBinding() {
            return mBinding;
        }
    }
}
