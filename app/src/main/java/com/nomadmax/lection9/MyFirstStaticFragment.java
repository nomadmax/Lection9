package com.nomadmax.lection9;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hugo.weaving.DebugLog;

/**
 * Created by Max on 10.03.16.
 */
public class MyFirstStaticFragment extends Fragment {


    @DebugLog
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_static_first, container, false);
        view.findViewById(R.id.show_dialog_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity()).setTitle("Title").setMessage("Message").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
            }
        });
        view.findViewById(R.id.show_dialog_fragment_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialogFragment dialogFragment = new MyDialogFragment();
                dialogFragment.show(getActivity().getSupportFragmentManager(), "fragDiag");
            }
        });
        return view;
    }


    @DebugLog
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @DebugLog
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @DebugLog
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @DebugLog
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    @DebugLog
    @Override
    public void onStart() {
        super.onStart();
    }
    @DebugLog
    @Override
    public void onResume() {
        super.onResume();
    }
    @DebugLog
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }
    @DebugLog
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
    @DebugLog
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    @DebugLog
    @Override
    public void onPause() {
        super.onPause();
    }
    @DebugLog
    @Override
    public void onStop() {
        super.onStop();
    }
    @DebugLog
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    @DebugLog
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    @DebugLog
    @Override
    public void onDetach() {
        super.onDetach();
    }
}
