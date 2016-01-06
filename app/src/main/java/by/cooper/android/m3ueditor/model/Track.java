package by.cooper.android.m3ueditor.model;


public class Track {
    private int mNumber;
    private String mName;
    private String mTitle;
    private String mLogo;
    private String mPath;

    public Track() {
    }

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

    public void setNumber(int number) {
        mNumber = number;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getLogo() {
        return mLogo;
    }

    public void setLogo(String logo) {
        mLogo = logo;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }

    @Override
    public String toString() {
        return "Track{" +
                "mNumber=" + mNumber +
                ", mName='" + mName + '\'' +
                ", mTitle='" + mTitle + '\'' +
                ", mLogo='" + mLogo + '\'' +
                ", mPath='" + mPath + '\'' +
                '}';
    }
}
