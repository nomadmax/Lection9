package com.nomadmax.lection9;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements EventHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.static_fragments_layout);
        setContentView(R.layout.dinamic_fragments_layout);
        if (savedInstanceState == null) {
            commitHeadlessFragment();
            commitTopFragment();
            commitBottomFragment();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        TopFragment topFragment = (TopFragment) getSupportFragmentManager().findFragmentById(R.id.top_container);
        topFragment.releaseEventHandler();
    }

    @Override
    protected void onResume() {
        super.onResume();
        TopFragment topFragment = (TopFragment) getSupportFragmentManager().findFragmentById(R.id.top_container);
        topFragment.setEventHandler(this);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    private void commitTopFragment() {
        TopFragment topFragment = new TopFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.top_container, topFragment, "top")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    private void commitBottomFragment() {
        BottomFragment topFragment = new BottomFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.bottom_container, topFragment, "bottom")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }


    private void commitHeadlessFragment() {
        DataHeadlessFragment dataHeadlessFragment = new DataHeadlessFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(dataHeadlessFragment, "headless")
                .commit();
    }

    public DataHeadlessFragment getDataFragment () {
        return (DataHeadlessFragment) getSupportFragmentManager().findFragmentByTag("headless");
    }

//
    @Override
    public void onButtonOnePressed(String _text) {
        BottomFragment bottomFragment = (BottomFragment) getSupportFragmentManager().findFragmentByTag("bottom");
        if (bottomFragment != null) {
            bottomFragment.setText(_text);
        }
    }

    @Override
    public void onButtonTwoPressed(String _text) {
        OtherBottomFragment otherBottomFragment = OtherBottomFragment.newInstance(_text);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.bottom_container, otherBottomFragment, "other")
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    @Override
    public void onButtonThreePressed(String _text) {
        getDataFragment().setText(_text);
        ThirdFragment thirdFragment = new ThirdFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.bottom_container, thirdFragment, "third")
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

}
