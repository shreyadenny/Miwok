package com.example.miwok;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class ColorAdapter extends ArrayAdapter<Color> {
    private int mColorResourceId;
    public ColorAdapter(Activity context, ArrayList<Color> color, int colorResourceId) {
        super(context, 0, color);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View colorItemView = convertView;
        if (colorItemView == null) {
            colorItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.color_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Color currentColor = getItem(position);
        View textContainer = colorItemView.findViewById(R.id.colorlist);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        ImageView miwokImageView = (ImageView) colorItemView.findViewById(R.id.imageColor);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokImageView.setImageResource(currentColor.getmImageResourceId());
        textContainer.setBackgroundColor(color);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) colorItemView.findViewById(R.id.miwokColor);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentColor.getmMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) colorItemView.findViewById(R.id.englishColor);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentColor.getDefaultTranslation());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return colorItemView;
    }
}

