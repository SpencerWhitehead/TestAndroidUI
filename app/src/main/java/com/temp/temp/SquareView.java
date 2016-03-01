package com.temp.temp;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by whites5 on 2/24/16.
 */
public class SquareView extends FrameLayout {
    public boolean mIsShowingFront;

    public SquareView(Context context) {
        super(context);
        mIsShowingFront = true;
    }

    public void flipCard(View v) {
        if (mIsShowingFront)
            flipToBack(v);
        else
            flipToFront(v);
    }

    private void flipToBack(View view) {
        mIsShowingFront = false;

        // Create and commit a new fragment transaction that adds the fragment for the back of
        // the card, uses custom animations, and is part of the fragment manager's back stack.
//        getFragmentManager()
//                .beginTransaction()
//                        // Replace the default fragment animations with animator resources representing
//                        // rotations when switching to the back of the card, as well as animator
//                        // resources representing rotations when flipping back to the front (e.g. when
//                        // the system Back button is pressed).
//                .setCustomAnimations(
//                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
//                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)
//                        // Replace any fragments currently in the container view with a fragment
//                        // representing the next page (indicated by the just-incremented currentPage
//                        // variable).
//                .replace(view.getId(), new CardBackFragment())
//                        // Commit the transaction.
//                .commit();
    }

    private void flipToFront(View view) {
        mIsShowingFront = true;

        // Create and commit a new fragment transaction that adds the fragment for the back of
        // the card, uses custom animations, and is part of the fragment manager's back stack.
//        getFragmentManager()
//                .beginTransaction()
//                        // Replace the default fragment animations with animator resources representing
//                        // rotations when switching to the back of the card, as well as animator
//                        // resources representing rotations when flipping back to the front (e.g. when
//                        // the system Back button is pressed).
//                .setCustomAnimations(
//                        R.animator.card_flip_left_in,
//                        R.animator.card_flip_left_out,
//                        R.animator.card_flip_right_in,
//                        R.animator.card_flip_right_out)
//
//                        // Replace any fragments currently in the container view with a fragment
//                        // representing the next page (indicated by the just-incremented currentPage
//                        // variable).
//                .replace(view.getId(), new CardFrontFragment())
//                        // Commit the transaction.
//                .commit();
    }

    public void setShowingFront(boolean b) {
        this.mIsShowingFront = b;
    }
}

