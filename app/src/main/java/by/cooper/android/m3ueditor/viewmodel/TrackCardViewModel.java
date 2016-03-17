package by.cooper.android.m3ueditor.viewmodel;

import android.databinding.BaseObservable;
import android.support.annotation.NonNull;

import by.cooper.android.m3ueditor.model.Track;


public class TrackCardViewModel extends BaseObservable{

    @NonNull
    private Track mTrack;

    public TrackCardViewModel(@NonNull Track track) {
        mTrack = track;
    }


}
