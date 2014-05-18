

package com.davidtpate.teracast;

/**
 * Bootstrap constants
 */
public class Constants {
    private static final String PREFIX = "com.davidtpate.teracast";

    public static class System {
        /**
         * Wifi Lock Tag
         */
        public static final String SYSTEM_WIFI_LOCK = PREFIX + ".WIFI_LOCK";

        private System() {
        }
    }

    public static class Extra {
        private static final String EXTRA_PREFIX = PREFIX + ".extra";
        public static final String EXTRA_PODCAST = EXTRA_PREFIX + ".PODCAST";
        public static final String EXTRA_PODCAST_LIST = EXTRA_PREFIX + ".PODCAST_LIST";
        private Extra() {
        }

    }
}


