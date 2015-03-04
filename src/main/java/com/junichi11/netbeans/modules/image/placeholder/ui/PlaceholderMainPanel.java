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

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;
import org.netbeans.api.annotations.common.CheckForNull;
import org.netbeans.api.editor.EditorRegistry;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.StatusDisplayer;
import org.openide.text.NbDocument;
import org.openide.util.NbBundle;

/**
 *
 * @author junichi11
 */
public class PlaceholderMainPanel extends javax.swing.JPanel implements ChangeListener {

    private static PlaceholderMainPanel defaultMainPanel;
    private static final long serialVersionUID = -8610347636891465814L;
    private static final Logger LOGGER = Logger.getLogger(PlaceholderMainPanel.class.getName());

    private final DefaultListModel<PlaceholderCategoryPanel> categoryListModel = new DefaultListModel<>();

    /**
     * Creates new form ImagePlaceholderMainPanel
     */
    public PlaceholderMainPanel() {
        initComponents();
        init();
    }

    private void init() {
        categoryList.setModel(categoryListModel);
        categoryList.setCellRenderer(new CategoryListCellRenderer(categoryList.getCellRenderer()));
    }

    public void addCategoryPanel(PlaceholderCategoryPanel panel) {
        categoryListModel.addElement(panel);
    }

    public void setSelectedCategoryPanel(PlaceholderCategoryPanel panel) {
        categoryList.setSelectedValue(panel, true);
    }

    @CheckForNull
    public PlaceholderCategoryPanel getSelectedPanel() {
        return categoryList.getSelectedValue();
    }

    @NbBundle.Messages({
        "PlaceholderCategoryPanel.title=Generate Image Placeholder URL"
    })
    public static void showDialog() {
        if (defaultMainPanel == null) {
            defaultMainPanel = new PlaceholderMainPanel();
            // add panels
            boolean first = true;
            final Collection<? extends PlaceholderCategoryPanel> categoryPanels = PlaceholderCategoryPanels.getCategoryPanels();
            for (PlaceholderCategoryPanel categoryPanel : categoryPanels) {
                categoryPanel.addChangeListener(defaultMainPanel);
                categoryPanel.loadDefault();
                defaultMainPanel.addCategoryPanel(categoryPanel);
                if (first) {
                    defaultMainPanel.setSelectedCategoryPanel(categoryPanel);
                    first = false;
                }
            }
        }

        DialogDescriptor descriptor = new DialogDescriptor(defaultMainPanel, Bundle.PlaceholderCategoryPanel_title(), false, DialogDescriptor.DEFAULT_OPTION, null, null);
        final Dialog dialog = DialogDisplayer.getDefault().createDialog(descriptor);
        descriptor.setButtonListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.pack();
        dialog.setVisible(true);
        defaultMainPanel.stateChanged(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        categoryScrollPane = new javax.swing.JScrollPane();
        categoryList = new javax.swing.JList<PlaceholderCategoryPanel>();
        categoryPanel = new javax.swing.JPanel();
        urlLabel = new javax.swing.JLabel();
        urlTextField = new javax.swing.JTextField();
        copyButton = new javax.swing.JButton();
        insertImgTagButton = new javax.swing.JButton();
        previewButton = new javax.swing.JButton();
        saveAsDefaultButton = new javax.swing.JButton();
        loadDefaultButton = new javax.swing.JButton();
        previewScrollPane = new javax.swing.JScrollPane();
        previewTextPane = new javax.swing.JTextPane();

        categoryList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                categoryListValueChanged(evt);
            }
        });
        categoryScrollPane.setViewportView(categoryList);

        categoryPanel.setLayout(new java.awt.BorderLayout());

        org.openide.awt.Mnemonics.setLocalizedText(urlLabel, org.openide.util.NbBundle.getMessage(PlaceholderMainPanel.class, "PlaceholderMainPanel.urlLabel.text")); // NOI18N

        urlTextField.setEditable(false);
        urlTextField.setText(org.openide.util.NbBundle.getMessage(PlaceholderMainPanel.class, "PlaceholderMainPanel.urlTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(copyButton, org.openide.util.NbBundle.getMessage(PlaceholderMainPanel.class, "PlaceholderMainPanel.copyButton.text")); // NOI18N
        copyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(insertImgTagButton, org.openide.util.NbBundle.getMessage(PlaceholderMainPanel.class, "PlaceholderMainPanel.insertImgTagButton.text")); // NOI18N
        insertImgTagButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertImgTagButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(previewButton, org.openide.util.NbBundle.getMessage(PlaceholderMainPanel.class, "PlaceholderMainPanel.previewButton.text")); // NOI18N
        previewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(saveAsDefaultButton, org.openide.util.NbBundle.getMessage(PlaceholderMainPanel.class, "PlaceholderMainPanel.saveAsDefaultButton.text")); // NOI18N
        saveAsDefaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsDefaultButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(loadDefaultButton, org.openide.util.NbBundle.getMessage(PlaceholderMainPanel.class, "PlaceholderMainPanel.loadDefaultButton.text")); // NOI18N
        loadDefaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDefaultButtonActionPerformed(evt);
            }
        });

        previewTextPane.setEditable(false);
        previewTextPane.setContentType("text/html"); // NOI18N
        previewScrollPane.setViewportView(previewTextPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(categoryScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(urlLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(urlTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(categoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previewScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 67, Short.MAX_VALUE)
                        .addComponent(loadDefaultButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveAsDefaultButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previewButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertImgTagButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(copyButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(categoryScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(previewScrollPane)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(urlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(urlLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(copyButton)
                            .addComponent(insertImgTagButton)
                            .addComponent(previewButton)
                            .addComponent(saveAsDefaultButton)
                            .addComponent(loadDefaultButton))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void categoryListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_categoryListValueChanged
        categoryPanel.removeAll();
        PlaceholderCategoryPanel selectedPanel = getSelectedPanel();
        if (selectedPanel != null) {
            categoryPanel.add(selectedPanel, BorderLayout.CENTER);
        }
        categoryPanel.revalidate();
        categoryPanel.repaint();
        stateChanged(null);
    }//GEN-LAST:event_categoryListValueChanged

    private void previewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewButtonActionPerformed
        PlaceholderCategoryPanel selectedPanel = getSelectedPanel();
        if (selectedPanel != null) {
            String url = selectedPanel.getUrl();
            int imageWidth = selectedPanel.getImageWidth();
            int imageHeight = selectedPanel.getImageHeight();
            float rate = 1;
            if (imageWidth > 200) {
                rate = imageWidth / 200;
            }
            int resizedWidth = imageWidth > 200 ? 200 : imageWidth;
            int resizedHeight = (int) (imageHeight / rate);
            String categoryName = selectedPanel.getCategoryName();
            previewTextPane.setText(String.format("<html><center><img src=\"%s\" width=\"%s\" height=\"%s\" alt=\"%s\"/></center></html>", // NOI18N
                    url,
                    resizedWidth,
                    resizedHeight,
                    categoryName));
        }
    }//GEN-LAST:event_previewButtonActionPerformed

    private void copyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyButtonActionPerformed
        PlaceholderCategoryPanel selectedPanel = getSelectedPanel();
        if (selectedPanel == null) {
            return;
        }
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection selection = new StringSelection(selectedPanel.getUrl());
        clipboard.setContents(selection, selection);
    }//GEN-LAST:event_copyButtonActionPerformed

    private void insertImgTagButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertImgTagButtonActionPerformed
        PlaceholderCategoryPanel selectedPanel = getSelectedPanel();
        if (selectedPanel != null) {
            JTextComponent editor = EditorRegistry.lastFocusedComponent();
            if (editor == null) {
                return;
            }
            final int caretPosition = editor.getCaretPosition();
            final StyledDocument document = (StyledDocument) editor.getDocument();
            if (document == null) {
                return;
            }

            // create img tag
            String url = selectedPanel.getUrl();
            String name = selectedPanel.getCategoryName();
            final String imgTag = String.format("<img src=\"%s\" alt=\"%s\" />", url, name); // NOI18N

            // insert
            try {
                NbDocument.runAtomicAsUser(document, new Runnable() {

                    @Override
                    public void run() {
                        try {
                            document.insertString(caretPosition, imgTag, null);
                        } catch (BadLocationException ex) {
                            LOGGER.log(Level.WARNING, ex.getMessage());
                        }
                    }
                });
            } catch (BadLocationException ex) {
                LOGGER.log(Level.WARNING, ex.getMessage());
            }
        }
    }//GEN-LAST:event_insertImgTagButtonActionPerformed

    @NbBundle.Messages({
        "# {0} - name",
        "PlaceholderMainPanel.message.save.as.default=Do you want to save values for {0} as default?",
        "PlaceholderMainPanel.message.saved=It has been saved."
    })
    private void saveAsDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsDefaultButtonActionPerformed
        PlaceholderCategoryPanel selectedPanel = getSelectedPanel();
        if (selectedPanel != null) {
            String categoryName = selectedPanel.getCategoryName();
            NotifyDescriptor.Confirmation message = new NotifyDescriptor.Confirmation(
                    Bundle.PlaceholderMainPanel_message_save_as_default(categoryName),
                    NotifyDescriptor.OK_CANCEL_OPTION,
                    NotifyDescriptor.QUESTION_MESSAGE
            );
            if (DialogDisplayer.getDefault().notify(message) == NotifyDescriptor.OK_OPTION) {
                selectedPanel.saveAsDefault();
                StatusDisplayer.getDefault().setStatusText(Bundle.PlaceholderMainPanel_message_saved());
            }
        }
    }//GEN-LAST:event_saveAsDefaultButtonActionPerformed

    private void loadDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDefaultButtonActionPerformed
        PlaceholderCategoryPanel selectedPanel = getSelectedPanel();
        if (selectedPanel == null) {
            return;
        }
        selectedPanel.loadDefault();
    }//GEN-LAST:event_loadDefaultButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<PlaceholderCategoryPanel> categoryList;
    private javax.swing.JPanel categoryPanel;
    private javax.swing.JScrollPane categoryScrollPane;
    private javax.swing.JButton copyButton;
    private javax.swing.JButton insertImgTagButton;
    private javax.swing.JButton loadDefaultButton;
    private javax.swing.JButton previewButton;
    private javax.swing.JScrollPane previewScrollPane;
    private javax.swing.JTextPane previewTextPane;
    private javax.swing.JButton saveAsDefaultButton;
    private javax.swing.JLabel urlLabel;
    private javax.swing.JTextField urlTextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void stateChanged(ChangeEvent e) {
        // update url
        PlaceholderCategoryPanel selectedPanel = getSelectedPanel();
        if (selectedPanel != null) {
            String url = selectedPanel.getUrl();
            urlTextField.setText(url);
        }
    }

    private static class CategoryListCellRenderer implements ListCellRenderer<PlaceholderCategoryPanel> {

        private final ListCellRenderer renderer;

        public CategoryListCellRenderer(ListCellRenderer renderer) {
            this.renderer = renderer;
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends PlaceholderCategoryPanel> list, PlaceholderCategoryPanel value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) renderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            String name = value.getCategoryName();
            label.setText(name);
            return label;
        }

    }
}
