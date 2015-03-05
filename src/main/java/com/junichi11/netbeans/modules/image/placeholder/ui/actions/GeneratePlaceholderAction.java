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
package com.junichi11.netbeans.modules.image.placeholder.ui.actions;

import com.junichi11.netbeans.modules.image.placeholder.ui.PlaceholderMainPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.loaders.DataObject;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "com.junichi11.netbeans.modules.image.placeholder.ui.actions.GeneratePlaceholderAction"
)
@ActionRegistration(
        iconBase = "com/junichi11/netbeans/modules/image/placeholder/resources/icon16.png",
        displayName = "#CTL_GeneratePlaceholderAction"
)
@ActionReferences({
    @ActionReference(path = "Menu/Edit", position = 3300),
    @ActionReference(path = "Editors/text/html/Popup", position = 4300),
    @ActionReference(path = "Editors/text/x-php5/Popup", position = 4300)
})
@Messages("CTL_GeneratePlaceholderAction=Generate Image Placeholder")
public final class GeneratePlaceholderAction implements ActionListener {

    private final DataObject context;

    public GeneratePlaceholderAction(DataObject context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                PlaceholderMainPanel.showDialog();
            }
        });
    }
}
