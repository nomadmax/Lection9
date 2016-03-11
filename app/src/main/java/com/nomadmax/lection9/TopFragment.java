package com.nomadmax.lection9;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Max on 09.03.16.
 */
public class TopFragment extends Fragment{
    private EditText mEditText;
    private Button mButton;
    private EventHandler mEventHandler;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_top_fragment_layout, container, false);
        mEditText = (EditText) view.findViewById(R.id.edit_text);
        mButton = (Button) view.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEventHandler.onButtonOnePressed(mEditText.getText().toString());
            }
        });

        view.findViewById(R.id.button_other).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEventHandler.onButtonTwoPressed(mEditText.getText().toString());
            }
        });

        view.findViewById(R.id.button_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEventHandler.onButtonThreePressed(mEditText.getText().toString());
            }
        });

        view.findViewById(R.id.button_show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
        view.findViewById(R.id.show_dialog_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogFragment();
            }
        });
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void showDialogFragment() {
        MyDialogFragment dialogFragment = new MyDialogFragment();
        dialogFragment.show(getActivity().getSupportFragmentManager(), "dialog");
    }

    private void showAlertDialog() {
        AlertDialog dialog = new AlertDialog
                .Builder(getActivity())
                .setTitle("Title")
                .setMessage("Message")
                .setIcon(android.R.drawable.ic_btn_speak_now)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();

    }

    public void setEventHandler(EventHandler _eventHandler) {
        mEventHandler = _eventHandler;
    }

    public void releaseEventHandler() {
        mEventHandler = null;
    }
}
