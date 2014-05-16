package com.davidtpate.teracast.event;

/**
 * Marker class for Otto.
 */
public class ProvideMediaProgressEvent {
	public int     progress;
	public int     max;

	public ProvideMediaProgressEvent(int progress, int max) {
		this.progress = progress;
		this.max = max;
	}
}
