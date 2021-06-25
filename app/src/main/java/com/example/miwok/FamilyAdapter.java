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

public class FamilyAdapter extends ArrayAdapter<Family> {
    private int mColorResourceId;
    public FamilyAdapter(Activity context, ArrayList<Family> family, int colorResourceId) {
        super(context, 0, family);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View familyItemView = convertView;
        if (familyItemView == null) {
            familyItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.family_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Family currentFamily = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) familyItemView.findViewById(R.id.miwokFamily);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentFamily.getmMiwokTranslation());

        ImageView miwokImageView = (ImageView) familyItemView.findViewById(R.id.imageFamily);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokImageView.setImageResource(currentFamily.getmImageResourceId());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) familyItemView.findViewById(R.id.englishFamily);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentFamily.getDefaultTranslation());

        // Set the theme color for the list item
        View textContainer = familyItemView.findViewById(R.id.familylist);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return familyItemView;
    }
}
