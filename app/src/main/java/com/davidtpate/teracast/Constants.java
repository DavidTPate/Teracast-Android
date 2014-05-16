

package com.davidtpate.teracast;

/**
 * Bootstrap constants
 */
public class Constants {

    public static final int IMAGE_PLACEHOLDER = R.drawable.ic_contact_picture;
    public static final int SEEK_AMOUNT = 15000;

    public static class System {
        /**
         * Wifi Lock Tag
         */
        public static final String WIFI_LOCK_TAG = "com.wemakestuff.teracast.WIFI_LOCK";

        private System() {
        }
    }

    public static class Extra {
        public static final String NEWS_ITEM = "news_item";
        public static final String MEDIA_ITEM = "com.wemakestuff.teracast.extras.MEDIA_ITEM";
        public static final String USER = "user";

        private Extra() {
        }

    }

    public static class Intent {
        /**
         * Action prefix for all intents created
         */
        public static final String INTENT_PREFIX = "com.wemakestuff.teracast";
        /**
         * Value used to transfer Rss Items.
         */
        public static final String RSS_ITEM = INTENT_PREFIX + ".intent.RssItem";
        public static final String EXTRA_PODCAST = INTENT_PREFIX + ".intent.Podcast";
        public static final String ACTION_MEDIA_BUTTON = INTENT_PREFIX + ".action.MEDIA_BUTTON";

        private Intent() {
        }

    }

    public static class Notification {
        public static final int PLAYBACK_NOTIFICATION_ID = 42;
        public static final int TIMER_NOTIFICATION_ID = 1000; // Why 1000? Why not? :)

        private Notification() {
        }
    }

}


