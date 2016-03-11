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
public class ThirdFragment extends Fragment {

    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_bottom_fragment_layout, container, false);
        mTextView = (TextView) view.findViewById(R.id.text_view);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        mTextView.setText(((MainActivity) getActivity()).getDataFragment().getText());
    }
}