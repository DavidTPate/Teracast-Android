package com.davidtpate.teracast;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import com.davidtpate.teracast.model.Podcast;
import com.davidtpate.teracast.model.PodcastList;
import com.davidtpate.teracast.module.RootModule;
import com.davidtpate.teracast.util.Ln;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.FROYO;

/**
 * Android Bootstrap application
 */
public class BaseApplication extends Application {

    private PodcastList mPodcastList = null;
    private static BaseApplication instance;

    /**
     * Create main application
     */
    public BaseApplication() {
        // Disable http.keepAlive on Froyo and below
        if (SDK_INT <= FROYO) {
            HttpRequest.keepAlive(false);
        }
    }

    /**
     * Create main application
     *
     * @param context
     */
    public BaseApplication(final Context context) {
        this();
        attachBaseContext(context);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        // Perform injection
        Injector.init(getRootModule(), this);

        BufferedReader reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.podcasts)));
        String fakeJson = "";
        String line;
        try
        {
            line = reader.readLine();
            while (line != null)
            {
                fakeJson = fakeJson + line;
                line = reader.readLine();
            }
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        instance.setPodcastList(PodcastList.fromJson(fakeJson));
    }

    private Object getRootModule() {
        return new RootModule();
    }


    /**
     * Create main application
     *
     * @param instrumentation
     */
    public BaseApplication(final Instrumentation instrumentation) {
        this();
        attachBaseContext(instrumentation.getTargetContext());
    }

    public static BaseApplication getInstance() {
        return instance;
    }

    public PodcastList getPodcastList() {
        return mPodcastList;
    }

    public void setPodcastList(PodcastList mPodcastList) {
        this.mPodcastList = mPodcastList;
    }
}