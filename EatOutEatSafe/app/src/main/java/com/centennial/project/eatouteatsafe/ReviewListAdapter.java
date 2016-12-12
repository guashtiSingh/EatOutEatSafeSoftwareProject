package com.centennial.project.eatouteatsafe;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.centennial.project.eatouteatsafe.pojos.Review;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Jihee Seo on 11/28/2016.
 */

public class ReviewListAdapter extends BaseExpandableListAdapter {

    List<Review> reviews = null;
    Context context;

    private AdapterCallback adapterCallback;

    public interface AdapterCallback {

        void onMethodCallback(View view, String taskMode);
    }

    public ReviewListAdapter(Context context, List<Review> review)
    {
        this.context = context;
        this.reviews = review;

        try{
            this.adapterCallback = ((AdapterCallback)context);
        }catch(ClassCastException e){
            throw new ClassCastException("Activity must implement class.");
        }
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
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final Review review = (Review) this.getChild(groupPosition, childPosition);

        Log.d("group pos", groupPosition + "");
        Log.d("child pos", childPosition + "");


        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //convertView = layoutInflater.inflate(R.layout.review_listview_child, parent, false);
            convertView = layoutInflater.inflate(R.layout.review_listview_child, null);
        }

        //Context context = convertView.getContext();

        convertView.setFocusable(false);
        convertView.setClickable(false);

        TextView txtContent = (TextView) convertView.findViewById(R.id.txtContent);
        RelativeLayout lytEdit = (RelativeLayout) convertView.findViewById(R.id.lytEdit);
        ImageButton btnEdit = (ImageButton) convertView.findViewById(R.id.btnEdit);
        ImageButton btnDelete = (ImageButton) convertView.findViewById(R.id.btnDelete);

        SharedPreferences sessionPreferences = context.getSharedPreferences(LoginActivity.APP_PREFERENCES, MODE_PRIVATE);

        Log.d("isValidSession ", sessionPreferences.getBoolean("isValidSession",false) + "");

        if(sessionPreferences.getBoolean("isValidSession",true) == true && review.getAuthor_Id().equals(sessionPreferences.getString("Username", "")) ) {

            lytEdit.setVisibility(View.VISIBLE);
            btnEdit.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.VISIBLE);

            if(ReviewListActivity.review != null)
            {
                ReviewListActivity.review = new Review();
            }

            ReviewListActivity.review.setRes_Id(review.getRes_Id());
            ReviewListActivity.review.setReview_Id(review.getReview_Id());
            ReviewListActivity.review.setContent(review.getContent());
            ReviewListActivity.review.setTitle(review.getTitle());
            ReviewListActivity.review.setAuthor_name(review.getAuthor_name());
            ReviewListActivity.review.setAuthor_Id(review.getReview_Id());
            ReviewListActivity.review.setRate(review.getRate());

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adapterCallback.onMethodCallback(view, "UPDATE");

                    Log.d("2nd group pos", groupPosition + "");
                    Log.d("2nd child pos", childPosition + "");
                    //ReviewListActivity.review = reviews.get(groupPosition);
                    Log.d("Title: ", ReviewListActivity.review.getTitle());

                }
            });
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Do you want to remove?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    adapterCallback.onMethodCallback(v, "DELETE");
                                }
                            });
                    builder.setNegativeButton("No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            });
        }
        else
        {
            lytEdit.setVisibility(View.INVISIBLE);
            btnEdit.setVisibility(View.INVISIBLE);
            btnDelete.setVisibility(View.INVISIBLE);
        }
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
