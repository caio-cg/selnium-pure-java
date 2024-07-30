package com.example.demo2.pages;

import com.example.demo2.pages.commons.AssertThat;
import com.example.demo2.pages.commons.Clickable;
import com.example.demo2.pages.commons.Textable;
import com.example.demo2.pages.commons.Visible;

public class BasePageObject<T> {

    protected Commands cmd = new Commands();

    public T assertThat(AssertThat assertThat) {
        assertThat.apply();
        return ((T) this);
    }
}

class Commands implements Visible, Clickable, Textable {

}
