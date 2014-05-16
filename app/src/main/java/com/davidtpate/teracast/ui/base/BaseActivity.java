package com.davidtpate.teracast.ui.base;

import android.app.Activity;
import android.os.Bundle;
import butterknife.ButterKnife;
import com.android.debug.hv.ViewServer;
import com.davidtpate.teracast.BuildConfig;

/**
 * Base activity for an activity which does not use fragments.
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (BuildConfig.DEBUG) {
            ViewServer.get(this).addWindow(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (BuildConfig.DEBUG) {
            ViewServer.get(this).removeWindow(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (BuildConfig.DEBUG) {
            ViewServer.get(this).setFocusedWindow(this);
        }
    }

    @Override
    public void setContentView(int layoutResId) {
        super.setContentView(layoutResId);

        // Used to inject views with the Butterknife library
        ButterKnife.inject(this);
    }
}
