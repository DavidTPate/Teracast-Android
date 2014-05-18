package com.davidtpate.teracast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.davidtpate.teracast.R;
import com.davidtpate.teracast.model.Podcast;
import com.davidtpate.teracast.model.PodcastList;
import com.squareup.picasso.Picasso;

public class PodcastAdapter extends BaseAdapter {
    private Context mContext;
    private PodcastList mPodcastList;
    private String[] mKeys;

    public PodcastAdapter(Context context, PodcastList podcastList) {
        mContext = context;
        mPodcastList = podcastList;
        if (mPodcastList != null && mPodcastList.getPodcastMap() != null) {
            mKeys = mPodcastList.getPodcastMap().keySet().toArray(new String[mPodcastList.getPodcastMap().size()]);
        }
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        if (mPodcastList == null || mPodcastList.getPodcastMap() == null) {
            return 0;
        }
        return mPodcastList.getPodcastMap().size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position
     *     Position of the item whose data we want within the adapter's
     *     data set.
     *
     * @return The data at the specified position.
     */
    @Override
    public Podcast getItem(int position) {
        if (mPodcastList == null || mPodcastList.getPodcastMap() == null || mKeys == null) {
            return null;
        }
        return mPodcastList.getPodcastMap().get(mKeys[position]);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position
     *     The position of the item within the adapter's data set whose row id we want.
     *
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link android.view.LayoutInflater#inflate(int, android.view.ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position
     *     The position of the item within the adapter's data set of the item whose view
     *     we want.
     * @param convertView
     *     The old view to reuse, if possible. Note: You should check that this view
     *     is non-null and of an appropriate type before using. If it is not possible to convert
     *     this view to display the correct data, this method can create a new view.
     *     Heterogeneous lists can specify their number of view types, so that this View is
     *     always of the right type (see {@link #getViewTypeCount()} and
     *     {@link #getItemViewType(int)}).
     * @param parent
     *     The parent that this view will eventually be attached to
     *
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Podcast podcast = getItem(position);
        ViewHolder holder = null;

        if (convertView != null) {
            Object tempView = convertView.getTag();
            if (tempView instanceof ViewHolder) {
                holder = (ViewHolder) tempView;
            }
        }

        if (holder == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.podcast_list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        Picasso.with(mContext).load(podcast.getLogo()).into(holder.icon);
        holder.title.setText(podcast.getTitle());
        holder.subtitle.setText(podcast.getDescription());

        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.iv_icon)
        ImageView icon;
        @InjectView(R.id.tv_title)
        TextView  title;
        @InjectView(R.id.tv_subtitle)
        TextView  subtitle;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
