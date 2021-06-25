package com.example.miwok;

public class Phrase {
    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private int mAudioResourceId;

    public Phrase(String defaultTranslation, String miwokTranslation, int mediaId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = mediaId;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation(){
        return mMiwokTranslation;
    }
    public int getmAudioResourceId(){
        return mAudioResourceId;
    }



}


