package com.davidtpate.teracast.ui;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.davidtpate.teracast.Constants;
import com.davidtpate.teracast.adapter.KeyAdapter;
import com.davidtpate.teracast.adapter.PodcastAdapter;
import com.davidtpate.teracast.model.PodcastList;

/**
 * A fragment representing a list of Podcasts.
 * <p/>
 * <p/>
 * Activities containing this fragment MUST implement the {@link com.davidtpate.teracast.ui.PodcastListFragment.OnPodcastInteractionListener}
 * interface.
 */
public class PodcastListFragment extends ListFragment {
    private PodcastList mPodcastList;

    private OnPodcastInteractionListener mListener;

    public static PodcastListFragment newInstance(PodcastList podcastList) {
        PodcastListFragment fragment = new PodcastListFragment();
        Bundle args = new Bundle();
        args.putParcelable(Constants.Extra.EXTRA_PODCAST_LIST, podcastList);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PodcastListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mPodcastList = getArguments().getParcelable(Constants.Extra.EXTRA_PODCAST_LIST);
        }

        setListAdapter(new PodcastAdapter(getActivity(), mPodcastList));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnPodcastInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnPodcastInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);

        if (mListener != null) {
            mListener.onSelectPodcast(((KeyAdapter) getListAdapter()).getItemKey(position));
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnPodcastInteractionListener {
        public void onSelectPodcast(String key);
    }
}
