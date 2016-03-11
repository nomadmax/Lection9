package com.nomadmax.lection9;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Max on 09.03.16.
 */
public class DataHeadlessFragment extends Fragment {

    public static final String KEY_TEXT = "KEY_TEXT";
    private String text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            restoreState(savedInstanceState);
        }
        setRetainInstance(true);
        return null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_TEXT, text);
    }

    private void restoreState(Bundle _savedInstanceState) {
        text = _savedInstanceState.getString(KEY_TEXT);
    }


    public String getText() {
        if (text == null) {
            text = "";
        }
        return text;
    }

    public void setText(String _text) {
        text = getText() + "\n" + _text;
    }
}
