package com.djw.jasonlibrarytools.utils.wigets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;


/**
 * Created by JasonDong on 2017/1/20.
 */

public class BottomDialog extends BottomSheetDialog {
    public BottomDialog(@NonNull Context context, View view) {
        super(context);
        initView(view);
    }

    private void initView(View view) {
        setContentView(view);
        View dialog = getDelegate().findViewById(android.support.design.R.id.design_bottom_sheet);
        final BottomSheetBehavior from = BottomSheetBehavior.from(dialog);
        from.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    dismiss();
                    from.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }
}
