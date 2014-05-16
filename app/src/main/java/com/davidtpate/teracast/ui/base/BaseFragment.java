package com.davidtpate.teracast.ui.base;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import butterknife.ButterKnife;

/**
 * Base class for all non-specialized Fragments.
 */
public abstract class BaseFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void showProgressBar() {
        getActivity().setProgressBarIndeterminateVisibility(true);
    }

    public void hideProgressBar() {
        getActivity().setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void onDestroyView() {
        ButterKnife.reset(this);
        super.onDestroyView();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
    }

    /**
     * Is this fragment still part of an activity and usable from the UI-thread?
     *
     * @return true if usable on the UI-thread, false otherwise
     */
    protected boolean isUsable() {
        return getActivity() != null;
    }
}
