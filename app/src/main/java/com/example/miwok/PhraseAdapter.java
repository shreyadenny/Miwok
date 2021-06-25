package com.example.miwok;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.miwok.Color;
import com.example.miwok.Phrase;
import com.example.miwok.R;

import java.util.ArrayList;

public class PhraseAdapter extends ArrayAdapter<Phrase> {
    private int mColorResourceId;
    public PhraseAdapter(Activity context, ArrayList<Phrase> phrase, int colorResourceId) {
        super(context, 0, phrase);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View phraseItemView = convertView;
        if (phraseItemView == null) {
            phraseItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.phrase_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Phrase currentPhrase = getItem(position);

        //Image


        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) phraseItemView.findViewById(R.id.miwokPhrase);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentPhrase.getmMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) phraseItemView.findViewById(R.id.englishPhrase);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentPhrase.getDefaultTranslation());

        // Set the theme color for the list item
        View textContainer = phraseItemView.findViewById(R.id.phraselist);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return phraseItemView;
    }
}


