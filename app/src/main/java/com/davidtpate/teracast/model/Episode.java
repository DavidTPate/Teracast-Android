package com.davidtpate.teracast.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Episode implements Parcelable {
    public static final Parcelable.Creator<Episode> CREATOR = new Parcelable.Creator<Episode>() {
        public Episode createFromParcel(Parcel in) {
            return new Episode(in);
        }

        public Episode[] newArray(int size) {
            return new Episode[size];
        }
    };
    String title;
    String link;
    String comments;
    String publishDate;
    String description;
    HashMap<String, Audio> audio;
    String duration;
    String subtitle;
    String summary;

    private Episode(Parcel in) {
        title = in.readString();
        link = in.readString();
        comments = in.readString();
        //TODO: Make this date.
        //publishDate = new Date(in.readLong());
        publishDate = in.readString();
        description = in.readString();

        Bundle audioBundle = in.readBundle();
        Set<String> audioKeySet = audioBundle.keySet();
        for (String key : audioKeySet) {
            if (audio == null) {
                audio = new HashMap<String, Audio>();
            }

            audio.put(key, audioBundle.<Audio>getParcelable(key));
        }

        duration = in.readString();
        subtitle = in.readString();
        summary = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(title);
        out.writeString(link);
        out.writeString(comments);
        //TODO: Make this date
        //out.writeLong(publishDate.getTime());
        out.writeString(publishDate);
        out.writeString(description);

        Bundle audioBundle = new Bundle();
        for (Map.Entry<String, Audio> audioEntry : audio.entrySet()) {
            audioBundle.putParcelable(audioEntry.getKey(), audioEntry.getValue());
        }
        out.writeBundle(audioBundle);

        out.writeString(duration);
        out.writeString(subtitle);
        out.writeString(summary);
    }

    @Override
    public String toString() {
        return "Episode{" +
               "title='" + title + '\'' +
               ", link='" + link + '\'' +
               ", comments='" + comments + '\'' +
               ", publishDate=" + publishDate +
               ", description='" + description + '\'' +
               ", audio=" + audio +
               ", duration='" + duration + '\'' +
               ", subtitle='" + subtitle + '\'' +
               ", summary='" + summary + '\'' +
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

        Episode episode = (Episode) o;

        if (audio != null ? !audio.equals(episode.audio) : episode.audio != null) {
            return false;
        }
        if (comments != null ? !comments.equals(episode.comments) : episode.comments != null) {
            return false;
        }
        if (description != null ? !description.equals(episode.description) : episode.description != null) {
            return false;
        }
        if (duration != null ? !duration.equals(episode.duration) : episode.duration != null) {
            return false;
        }
        if (link != null ? !link.equals(episode.link) : episode.link != null) {
            return false;
        }
        if (publishDate != null ? !publishDate.equals(episode.publishDate) : episode.publishDate != null) {
            return false;
        }
        if (subtitle != null ? !subtitle.equals(episode.subtitle) : episode.subtitle != null) {
            return false;
        }
        if (summary != null ? !summary.equals(episode.summary) : episode.summary != null) {
            return false;
        }
        if (title != null ? !title.equals(episode.title) : episode.title != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (audio != null ? audio.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (subtitle != null ? subtitle.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        return result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashMap<String, Audio> getAudio() {
        return audio;
    }

    public void setAudio(HashMap<String, Audio> audio) {
        this.audio = audio;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
