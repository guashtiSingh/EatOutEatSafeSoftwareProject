package com.centennial.project.eatouteatsafe;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.centennial.project.eatouteatsafe.pojos.Review;

import java.util.List;

/**
 * Created by Jihee Seo on 11/28/2016.
 */

public class ReviewListAdapter extends BaseExpandableListAdapter {

    List<Review> reviews = null;
    Context context;

    public ReviewListAdapter(Context context, List<Review> review)
    {
        this.context = context;
        this.reviews = review;
    }

    @Override
    public int getGroupCount() {
        return reviews.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //it's always 1 because content is always one for each title.
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return reviews.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.reviews.get(groupPosition);
        //return reviews.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition;
    }



    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        Review review = (Review) this.getGroup(groupPosition);

        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //convertView = layoutInflater.inflate(R.layout.review_listview_parent, parent, false);
            convertView = layoutInflater.inflate(R.layout.review_listview_parent, null);
        }

        convertView.setFocusable(false);
        convertView.setClickable(false);

        if(isExpanded){
            convertView.setBackgroundColor(Color.LTGRAY);
        }else{
            convertView.setBackgroundColor(Color.TRANSPARENT);
        }

        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
        TextView txtAuthor = (TextView) convertView.findViewById(R.id.txtAuthor);
        RatingBar ratingBar = (RatingBar) convertView.findViewById(R.id.ratingBar);

        txtTitle.setText(review.getTitle());
        txtTitle.setTypeface(null, Typeface.BOLD);
        txtAuthor.setText(review.getAuthor_Id());
        ratingBar.setRating(review.getRate());
        ratingBar.setEnabled(false);
        ratingBar.setFocusable(false);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        Review review = (Review) this.getChild(groupPosition, childPosition);

        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //convertView = layoutInflater.inflate(R.layout.review_listview_child, parent, false);
            convertView = layoutInflater.inflate(R.layout.review_listview_child, null);
        }

        convertView.setFocusable(false);
        convertView.setClickable(false);

        TextView txtContent = (TextView) convertView.findViewById(R.id.txtContent);
        txtContent.setText(review.getContent());

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
