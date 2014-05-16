package com.davidtpate.teracast.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public interface Item {
    public View getView(Context context, View convertView, ViewGroup parent);
}
