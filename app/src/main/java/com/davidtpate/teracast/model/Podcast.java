package com.davidtpate.teracast.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class Podcast implements Parcelable {
    public static final Parcelable.Creator<Podcast> CREATOR = new Parcelable.Creator<Podcast>() {
        public Podcast createFromParcel(Parcel in) {
            return new Podcast(in);
        }

        public Podcast[] newArray(int size) {
            return new Podcast[size];
        }
    };
    String       title;
    String       subtitle;
    String       author;
    String       feedUrl;
    String       explcit;
    String       logo;
    String       description;
    String       summary;
    List<String> keywords;
    String       language;
    String       copyright;
    List<String> categories;

    private Podcast(Parcel in) {
        title = in.readString();
        subtitle = in.readString();
        author = in.readString();
        feedUrl = in.readString();
        explcit = in.readString();
        logo = in.readString();
        description = in.readString();
        summary = in.readString();
        keywords = in.readArrayList(String.class.getClassLoader());
        language = in.readString();
        copyright = in.readString();
        categories = in.readArrayList(String.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(title);
        out.writeString(subtitle);
        out.writeString(author);
        out.writeString(feedUrl);
        out.writeString(explcit);
        out.writeString(logo);
        out.writeString(description);
        out.writeString(summary);
        out.writeList(keywords);
        out.writeString(language);
        out.writeString(copyright);
        out.writeList(categories);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public void setFeedUrl(String feedUrl) {
        this.feedUrl = feedUrl;
    }

    public String getExplcit() {
        return explcit;
    }

    public void setExplcit(String explcit) {
        this.explcit = explcit;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Podcast podcast = (Podcast) o;

        if (author != null ? !author.equals(podcast.author) : podcast.author != null) {
            return false;
        }
        if (categories != null ? !categories.equals(podcast.categories) : podcast.categories != null) {
            return false;
        }
        if (copyright != null ? !copyright.equals(podcast.copyright) : podcast.copyright != null) {
            return false;
        }
        if (description != null ? !description.equals(podcast.description) : podcast.description != null) {
            return false;
        }
        if (explcit != null ? !explcit.equals(podcast.explcit) : podcast.explcit != null) {
            return false;
        }
        if (feedUrl != null ? !feedUrl.equals(podcast.feedUrl) : podcast.feedUrl != null) {
            return false;
        }
        if (keywords != null ? !keywords.equals(podcast.keywords) : podcast.keywords != null) {
            return false;
        }
        if (language != null ? !language.equals(podcast.language) : podcast.language != null) {
            return false;
        }
        if (logo != null ? !logo.equals(podcast.logo) : podcast.logo != null) {
            return false;
        }
        if (subtitle != null ? !subtitle.equals(podcast.subtitle) : podcast.subtitle != null) {
            return false;
        }
        if (summary != null ? !summary.equals(podcast.summary) : podcast.summary != null) {
            return false;
        }
        if (title != null ? !title.equals(podcast.title) : podcast.title != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (subtitle != null ? subtitle.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (feedUrl != null ? feedUrl.hashCode() : 0);
        result = 31 * result + (explcit != null ? explcit.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (copyright != null ? copyright.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Podcast{" +
               "title='" + title + '\'' +
               ", subtitle='" + subtitle + '\'' +
               ", author='" + author + '\'' +
               ", feedUrl='" + feedUrl + '\'' +
               ", explcit='" + explcit + '\'' +
               ", logo='" + logo + '\'' +
               ", description='" + description + '\'' +
               ", summary='" + summary + '\'' +
               ", keywords=" + keywords +
               ", language='" + language + '\'' +
               ", copyright='" + copyright + '\'' +
               ", categories=" + categories +
               '}';
    }
}
