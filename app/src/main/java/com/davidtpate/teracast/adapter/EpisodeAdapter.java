package com.davidtpate.teracast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.davidtpate.teracast.R;
import com.davidtpate.teracast.model.Episode;
import java.util.LinkedHashMap;

public class EpisodeAdapter extends BaseAdapter implements KeyAdapter {
    private Context  mContext;
    private LinkedHashMap<String, Episode> mEpisodeList;
    private String[]      mKeys;

    public EpisodeAdapter(Context context, LinkedHashMap<String, Episode> episodeList) {
        mContext = context;
        mEpisodeList = episodeList;
        if (mEpisodeList != null) {
            mKeys = mEpisodeList.keySet().toArray(new String[mEpisodeList.size()]);
        }
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        if (mEpisodeList == null || mEpisodeList == null) {
            return 0;
        }
        return mEpisodeList.size();
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
    public Episode getItem(int position) {
        if (mEpisodeList == null || mEpisodeList == null || mKeys == null) {
            return null;
        }
        return mEpisodeList.get(mKeys[position]);
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
        Episode episode = getItem(position);
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

        holder.title.setText(episode.getTitle());
        holder.subtitle.setText(episode.getDescription());

        return convertView;
    }

    @Override
    public String getItemKey(int position) {
        if (mKeys == null) {
            return null;
        }
        return mKeys[position];
    }

    static class ViewHolder {
        @InjectView(R.id.tv_title)
        TextView   title;
        @InjectView(R.id.tv_subtitle)
        TextView    subtitle;
        @InjectView(R.id.ib_play)
        ImageButton play;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
