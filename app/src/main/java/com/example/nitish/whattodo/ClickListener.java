package com.example.nitish.whattodo;

import android.view.View;

/**
 * Created by nitish on 2/11/16.
 */

public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
