package com.example.miwok;

public class Word {
    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private int mImageResourceId;

    private int mAudioResourceId;

    public Word(String defaultTranslation, String miwokTranslation, int imageId, int mediaId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageId;
        mAudioResourceId = mediaId;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getmImageResourceId(){
        return mImageResourceId;
    }

    public int getmAudioResourceId(){
        return mAudioResourceId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
