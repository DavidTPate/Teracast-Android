package com.davidtpate.teracast.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PodcastList implements Parcelable {
    public static final Type                            podcastMapType = new TypeToken<LinkedHashMap<String, Podcast>>() {}.getType();
    public static final Parcelable.Creator<PodcastList> CREATOR        = new Parcelable.Creator<PodcastList>() {
        public PodcastList createFromParcel(Parcel in) {
            return new PodcastList(in);
        }

        public PodcastList[] newArray(int size) {
            return new PodcastList[size];
        }
    };

    LinkedHashMap<String, Podcast> podcastMap;

    private PodcastList() {

    }

    public static PodcastList fromJson(String json) {
        PodcastList podcastList = new PodcastList();
        podcastList.podcastMap = new Gson().fromJson(json, podcastMapType);
        return podcastList;
    }

    private PodcastList(Parcel in) {
        Bundle bundle = in.readBundle();
        Set<String> keySet = bundle.keySet();
        for (String key : keySet) {
            if (podcastMap == null) {
                podcastMap = new LinkedHashMap<String, Podcast>();
            }

            podcastMap.put(key, bundle.<Podcast>getParcelable(key));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, Podcast> podcastEntry : podcastMap.entrySet()) {
            bundle.putParcelable(podcastEntry.getKey(), podcastEntry.getValue());
        }
        out.writeBundle(bundle);
    }

    public HashMap<String, Podcast> getPodcastMap() {
        return podcastMap;
    }

    @Override
    public String toString() {
        return "PodcastList{" +
               "podcastMap=" + podcastMap +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PodcastList that = (PodcastList) o;

        if (podcastMap != null ? !podcastMap.equals(that.podcastMap) : that.podcastMap != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return podcastMap != null ? podcastMap.hashCode() : 0;
    }
}
