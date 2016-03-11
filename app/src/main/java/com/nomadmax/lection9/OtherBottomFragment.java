package com.nomadmax.lection9;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Max on 09.03.16.
 */
public class OtherBottomFragment extends Fragment {
    public static final String KEY_TEXT = "KEY_TEXT";

    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_bottom_fragment_layout, container, false);
        mTextView = (TextView) view.findViewById(R.id.text_view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView.setText(getArguments().getString(KEY_TEXT));
    }

    public static OtherBottomFragment newInstance(String _text) {
        Bundle args = new Bundle();
        args.putString(KEY_TEXT, _text);
        OtherBottomFragment fragment = new OtherBottomFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
