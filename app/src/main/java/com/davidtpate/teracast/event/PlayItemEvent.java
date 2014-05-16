package com.davidtpate.teracast.event;

import com.wemakestuff.teracast.model.api.Episode;

/**
 * Marker class for Otto.
 */
public class PlayItemEvent {
    public Episode episode;

    public PlayItemEvent(Episode episode) {
        this.episode = episode;
    }
}
