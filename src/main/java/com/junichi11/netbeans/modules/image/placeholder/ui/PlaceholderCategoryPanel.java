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
package com.junichi11.netbeans.modules.image.placeholder.ui;

import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

/**
 *
 * @author junichi11
 */
public abstract class PlaceholderCategoryPanel extends JPanel {

    private static final long serialVersionUID = 9037855566074878181L;

    /**
     * Get category name.
     *
     * @return category name.
     */
    public abstract String getCategoryName();

    /**
     * Get width of a image.
     *
     * @return width of a image (> 0)
     */
    public abstract int getImageWidth();

    /**
     * Get height of a image.
     *
     * @return height of a image (> 0)
     */
    public abstract int getImageHeight();

    /**
     * Add a ChangeListener.
     *
     * @param listener
     */
    public abstract void addChangeListener(ChangeListener listener);

    /**
     * Remove a ChangeListener.
     *
     * @param listener
     */
    public abstract void removeChangeListener(ChangeListener listener);

    /**
     * Get url of placeholder.
     *
     * @return url of placeholder
     */
    public abstract String getUrl();

    /**
     * Save values as default.
     */
    public abstract void saveAsDefault();

    /**
     * Load values from default settings.
     */
    public abstract void loadDefault();

}
