/*
 * The MIT License
 *
 * Copyright 2015 junichi11.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.junichi11.netbeans.modules.image.placeholder.options;

import java.util.prefs.Preferences;

/**
 *
 * @author junichi11
 */
public final class PlaceKittenOptions extends PlaceholderOptions {

    private static final String PLACEKITTEN = "placekitten"; // NOI18N
    private static final String WIDTH = "width"; // NOI18N
    private static final String HEIGHT = "height"; // NOI18N
    private static final String GRAY = "gray"; // NOI18N
    private static final PlaceKittenOptions INSTANCE = new PlaceKittenOptions();

    private PlaceKittenOptions() {
    }

    public static PlaceKittenOptions getInstance() {
        return INSTANCE;
    }

    public int getWidth() {
        return getPreferences().getInt(WIDTH, 400);
    }

    public void setWidth(int width) {
        getPreferences().putInt(WIDTH, width);
    }

    public int getHeight() {
        return getPreferences().getInt(HEIGHT, 200);
    }

    public void setHeight(int height) {
        getPreferences().putInt(HEIGHT, height);
    }

    public boolean isGray() {
        return getPreferences().getBoolean(GRAY, false);
    }

    public void setGray(boolean isGray) {
        getPreferences().putBoolean(GRAY, isGray);
    }

    private Preferences getPreferences() {
        return getPreferences(PLACEKITTEN);
    }

}
