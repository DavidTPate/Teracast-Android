package com.davidtpate.teracast.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.davidtpate.teracast.Constants;
import com.davidtpate.teracast.R;
import com.davidtpate.teracast.adapter.EpisodeAdapter;
import com.davidtpate.teracast.model.Episode;
import com.davidtpate.teracast.model.Podcast;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PodcastDetailFragment.OnPodcastDetailInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PodcastDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class PodcastDetailFragment extends Fragment {
    private Podcast mPodcast;
    private OnPodcastDetailInteractionListener mListener;

    @InjectView(R.id.iv_icon)
    ImageView icon;
    @InjectView(R.id.tv_title)
    TextView  title;
    @InjectView(R.id.tv_subtitle)
    TextView  subtitle;
    @InjectView(R.id.tv_author)
    TextView  author;
    @InjectView(R.id.tv_feed_url)
    TextView  feedUrl;
    @InjectView(R.id.tv_explicit)
    TextView  explicit;
    @InjectView(R.id.tv_logo)
    TextView  logo;
    @InjectView(R.id.tv_description)
    TextView  description;
    @InjectView(R.id.tv_summary)
    TextView  summary;
    @InjectView(R.id.tv_keywords)
    TextView  keywords;
    @InjectView(R.id.tv_language)
    TextView  language;
    @InjectView(R.id.tv_copyright)
    TextView  copyright;
    @InjectView(R.id.tv_categories)
    TextView  categories;
    @InjectView(R.id.lv_episodes)
    ListView episodes;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param podcast The podcast to be displayed.
     * @return A new instance of fragment PodcastDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PodcastDetailFragment newInstance(Podcast podcast) {
        PodcastDetailFragment fragment = new PodcastDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(Constants.Extra.EXTRA_PODCAST, podcast);
        fragment.setArguments(args);
        return fragment;
    }

    public PodcastDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPodcast = getArguments().getParcelable(Constants.Extra.EXTRA_PODCAST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View createView = inflater.inflate(R.layout.fragment_podcast_detail, container, false);

        ButterKnife.inject(this, createView);

        Picasso.with(getActivity()).load(mPodcast.getLogo()).into(icon);

        title.setText(mPodcast.getTitle());
        subtitle.setText(mPodcast.getSubtitle());
        author.setText(mPodcast.getAuthor());
        feedUrl.setText(mPodcast.getFeedUrl());
        explicit.setText(mPodcast.getExplcit());
        logo.setText(mPodcast.getLogo());
        description.setText(mPodcast.getDescription());
        summary.setText(mPodcast.getSummary());
        keywords.setText(mPodcast.getKeywords().toString());
        language.setText(mPodcast.getLanguage());
        copyright.setText(mPodcast.getCopyright());
        categories.setText(mPodcast.getCategories().toString());
        episodes.setAdapter(new EpisodeAdapter(getActivity(), mPodcast.getEpisodes()));
        return createView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            //mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnPodcastDetailInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnPodcastDetailInteractionListener {
        public void onEpisodeSelected(Episode episode);
    }

}
