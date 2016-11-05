package com.example.nitish.whattodo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nitish on 2/11/16.
 */

public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    LayoutInflater mLayoutInflater;


    public CustomPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View itemView = mLayoutInflater.inflate(R.layout.activity_display_to_do, container, false);

        TextView titletext = (TextView) itemView.findViewById(R.id.title);
        TextView detailstext = (TextView) itemView.findViewById(R.id.details);
        String title = MainActivity.todoList.get(position).getTitle();
        String details = MainActivity.todoList.get(position).getDetails();
        titletext.setText(title);
        if(!details.equals("")) {
            detailstext.setText(details);
        }
        container.addView(itemView);

        return itemView;

    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return MainActivity.todoList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return MainActivity.todoList.get(position).getTitle();
    }

}