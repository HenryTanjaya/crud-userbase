package com.lecturer.lecturer4.androidos.listener;

import com.lecturer.lecturer4.androidos.aabase.BaseFragment;

/**
 * Created by IT on 1/24/2018.
 */

public interface OnChangeLayoutListener {
    public void doChangeLayout(BaseFragment o);
    public void doBackPress();
    public void doFinish();
    public void setActiveFragment(BaseFragment o);
}
