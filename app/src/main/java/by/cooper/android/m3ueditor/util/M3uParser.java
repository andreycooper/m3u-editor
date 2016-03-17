package by.cooper.android.m3ueditor.util;


import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.cooper.android.m3ueditor.model.Track;
import rx.Observable;

public final class M3uParser {

    public static final String TAG = "M3uParser";
    // TODO: use new regexp with optional logo
    private static final String CHANNEL_PATTERN = "EXTINF:(\\d+)\\slogo=\"(.*?)\",(.*?)\\n(.*?)\\n";
    private static final int NUMBER_GROUP = 1;
    public static final int LOGO_GROUP = 3;
    public static final int NAME_GROUP = 4;
    public static final int PATH_GROUP = 5;

    public Observable<List<Track>> parseFile(String filename) {
        return Observable.just(readFile(filename))
                .filter(content -> !TextUtils.isEmpty(content))
                .map(content -> content.split("#"))
                .flatMap(Observable::from)
                .filter(trackStr -> trackStr.startsWith("EXTINF"))
                .map(this::parseTrack)
                .filter(track -> track != null)
                .doOnNext(track -> Log.d(TAG, "Track: " + track))
                .toList();
    }

    public void parseFileToList(@NonNull String filename, @NonNull List<Track> destinationList) {
        String content = readFile(filename);
        if (!TextUtils.isEmpty(content)) {
            String[] tracks = content.split("#");
            for (String trackString : tracks) {
                if (trackString.startsWith("EXTINF")) {
                    Track track = parseTrack(trackString);
                    if (track != null) {
                        Log.d(TAG, "Track: " + track);
                        destinationList.add(track);
                    }
                }
            }
        }
    }

    @Nullable
    private Track parseTrack(String track) {
        Pattern pattern = Pattern.compile(CHANNEL_PATTERN);
        Matcher matcher = pattern.matcher(track);
        if (matcher.find()) {
            return createTrack(matcher);
        }
        return null;
    }

    @NonNull
    private Track createTrack(Matcher matcher) {
        String trackNumber = matcher.group(NUMBER_GROUP);
        String logo = matcher.group(LOGO_GROUP);
        String name = matcher.group(NAME_GROUP);
        String path = matcher.group(PATH_GROUP);
        Track track = new Track();
        track.setNumber(Integer.parseInt(trackNumber));
        track.setName(name);
        track.setLogo(logo);
        track.setPath(path);
        return track;
    }

    private String readFile(String filename) {
        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard, filename);
        String line;
        StringBuilder text = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                text.append(line);
                text.append("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return text.toString();
    }

}
