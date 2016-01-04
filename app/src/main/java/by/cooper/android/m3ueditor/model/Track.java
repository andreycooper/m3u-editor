package by.cooper.android.m3ueditor.model;



public class Track {
    private int mNumber;
    private String mName;
    private String mTitle;
    private String mLogo;
    private String mPath;

    public Track(int number, String name, String title, String logo, String path) {
        mNumber = number;
        mName = name;
        mTitle = title;
        mLogo = logo;
        mPath = path;
    }

    public int getNumber() {
        return mNumber;
    }

    public String getName() {
        return mName;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getLogo() {
        return mLogo;
    }

    public String getPath() {
        return mPath;
    }
}
