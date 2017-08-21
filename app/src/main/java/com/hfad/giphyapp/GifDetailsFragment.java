package com.hfad.giphyapp;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hfad.giphyapp.util.GIFLoader;

/**
 * Created by sarahzhou on 8/21/17.
 */
public class GifDetailsFragment extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View mView = inflater.inflate(R.layout.gif_details, null);
        builder.setView(mView);

        String url = getArguments().getString("url");
        String gif = getArguments().getString("gif");

        ImageView mGif = (ImageView) mView.findViewById(R.id.gif_img);
        TextView mText = (TextView) mView.findViewById(R.id.gif_url);

        GIFLoader.loadGIF(gif,mGif,this.getActivity());

        mText.setText(url);

        builder.setNegativeButton(R.string.back, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        return builder.create();
    }


}
