/*
 * Copyright 2016 Mario Contreras - marioc@nazul.net.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mx.iteso.msc.bda.banksimulator;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import mx.iteso.msc.bda.banksimulator.entities.*;

/**
 *
 * @author Mario Contreras - marioc@nazul.net
 */
public class TransferDialog extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;
    // The transfer
    private Transfer transfer = null;
    // The accounts
    private final List<Account> accounts;
    // The return value/status
    private int returnStatus = RET_CANCEL;

    /**
     * Creates new form TransferDialog
     * @param parent
     * @param modal
     * @param accounts
     */
    public TransferDialog(java.awt.Frame parent, boolean modal, List<Account> accounts) {
        super(parent, modal);
        initComponents();
        // Center
        setLocationRelativeTo(parent);
        // Populate comboboxes
        this.accounts = accounts;
        sourceComboBox.removeAllItems();
        accounts.stream().forEach((account) -> {
            sourceComboBox.addItem(account.toString());
        });
        destinationComboBox.removeAllItems();
        accounts.stream().forEach((account) -> {
            destinationComboBox.addItem(account.toString());
        });
        statusComboBox.removeAllItems();
        for(String s : TransferStatus.names()) {
            statusComboBox.addItem(s);
        }
        // Clear text field values
        idTextField.setText("");
        valueFormattedTextField.setValue(0.0);
        lastModifiedFormattedTextField.setValue(0);

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    public Transfer addTransfer() {
        this.setVisible(true);
        if (this.returnStatus == RET_OK) {
            Account source = null, destination = null;
            
            for(Account account : accounts) {
                if (account.getName().equals(sourceComboBox.getSelectedItem().toString()))
                    source = account;
                if (account.getName().equals(destinationComboBox.getSelectedItem().toString()))
                    destination = account;
            }
            this.transfer = new Transfer(source, destination, new Float(valueFormattedTextField.getText()));
        }
        return transfer;
    }
    
    public void modifyTransfer(Transfer transfer) {
//        this.transfer = transfer;
//        idTextField.setText(transfer.getId());
//        valueFormattedTextField.setText(transfer.getValue().toString());
//        this.setVisible(true);
//        if(this.returnStatus == RET_OK) {
//            this.transfer.setValue(new BigDecimal(valueFormattedTextField.getText()));
//        }
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }
    
    public Transfer getTransfer() {
        return transfer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        sourceLabel = new javax.swing.JLabel();
        sourceComboBox = new javax.swing.JComboBox<>();
        destinationLabel = new javax.swing.JLabel();
        destinationComboBox = new javax.swing.JComboBox<>();
        valueLabel = new javax.swing.JLabel();
        valueFormattedTextField = new javax.swing.JFormattedTextField();
        statusLabel = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        lastModifiedLabel = new javax.swing.JLabel();
        lastModifiedFormattedTextField = new javax.swing.JFormattedTextField();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setTitle("Transfer Dialog Window");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        title.setBackground(java.awt.SystemColor.text);
        title.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        title.setText("Transfer");
        title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        title.setOpaque(true);

        idLabel.setText("ID:");

        idTextField.setEditable(false);
        idTextField.setText("jTextField1");

        sourceLabel.setText("Source:");

        sourceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[sourceComboBox]" }));

        destinationLabel.setText("Destination:");

        destinationComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[destinationComboBox]" }));

        valueLabel.setText("Value:");

        valueFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        valueFormattedTextField.setText("[valueFormattedTextField]");

        statusLabel.setText("Status:");

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[statusComboBox]" }));
        statusComboBox.setEnabled(false);

        lastModifiedLabel.setText("Last Modified:");

        lastModifiedFormattedTextField.setEditable(false);
        lastModifiedFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        lastModifiedFormattedTextField.setText("[lastModifiedFormattedTextField]");

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(idLabel)
                                    .addComponent(sourceLabel)
                                    .addComponent(destinationLabel)
                                    .addComponent(valueLabel)
                                    .addComponent(statusLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lastModifiedLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valueFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(statusComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 98, Short.MAX_VALUE)
                                .addComponent(lastModifiedFormattedTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(sourceComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(destinationComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 44, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sourceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sourceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destinationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastModifiedFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastModifiedLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> destinationComboBox;
    private javax.swing.JLabel destinationLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JFormattedTextField lastModifiedFormattedTextField;
    private javax.swing.JLabel lastModifiedLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox<String> sourceComboBox;
    private javax.swing.JLabel sourceLabel;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel title;
    private javax.swing.JFormattedTextField valueFormattedTextField;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}

// EOF
