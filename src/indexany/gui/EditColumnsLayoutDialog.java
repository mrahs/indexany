package indexany.gui;

import indexany.GuiColumn;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditColumnsLayoutDialog extends javax.swing.JDialog {

    /**
     * Creates new form EditColumnsLayoutDialog
     */
    public EditColumnsLayoutDialog(java.awt.Frame parent, boolean modal, Set<indexany.GuiColumn> columns) {
        super(parent, modal);
        initComponents();
        this.columns = columns;
        initialize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        colsPanel = new javax.swing.JPanel();
        colCombobox = new javax.swing.JComboBox();
        sizeCombobox = new javax.swing.JComboBox();
        horCombobox = new javax.swing.JComboBox();
        verCombobox = new javax.swing.JComboBox();
        colLabel = new javax.swing.JLabel();
        sizeLabel = new javax.swing.JLabel();
        horLabel = new javax.swing.JLabel();
        verLabel = new javax.swing.JLabel();
        doneButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Columns Layout");
        setResizable(false);

        javax.swing.GroupLayout colsPanelLayout = new javax.swing.GroupLayout(colsPanel);
        colsPanel.setLayout(colsPanelLayout);
        colsPanelLayout.setHorizontalGroup(
            colsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        colsPanelLayout.setVerticalGroup(
            colsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(colsPanel);

        colCombobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                colComboboxItemStateChanged(evt);
            }
        });

        sizeCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Long Row", "Short Row", "Tiny Row", "Multi Row" }));

        colLabel.setLabelFor(colCombobox);
        colLabel.setText("Column");

        sizeLabel.setLabelFor(sizeCombobox);
        sizeLabel.setText("Size");

        horLabel.setLabelFor(horCombobox);
        horLabel.setText("Hor.");

        verLabel.setLabelFor(verCombobox);
        verLabel.setText("Ver.");

        doneButton.setText("Done!");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(colLabel)
                    .addComponent(sizeLabel)
                    .addComponent(horLabel)
                    .addComponent(verLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(horCombobox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sizeCombobox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 143, Short.MAX_VALUE)
                    .addComponent(colCombobox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(verCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(doneButton)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sizeCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sizeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doneButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_doneButtonActionPerformed

    private void colComboboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_colComboboxItemStateChanged
        currentCol = getCol(colCombobox.getSelectedItem().toString());
        currentField = colFieldMap.get(colCombobox.getSelectedItem().toString());
        currentLabel = colLabelMap.get(colCombobox.getSelectedItem().toString());

        if (currentCol.getHeight() > 1) {
            sizeCombobox.setSelectedIndex(3);
        } else if (currentCol.getWidth() == 20) {
            sizeCombobox.setSelectedIndex(0);
        } else if (currentCol.getWidth() == 10) {
            sizeCombobox.setSelectedIndex(1);
        } else if (currentCol.getWidth() == 5) {
            sizeCombobox.setSelectedIndex(2);
        }

        if (horCombobox.getModel().getSize() > 0) {
            horCombobox.setSelectedIndex(currentCol.getY()+1);
            verCombobox.setSelectedIndex(currentCol.getX());
        }
    }//GEN-LAST:event_colComboboxItemStateChanged

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /*
//         * Set the Nimbus look and feel
//         */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /*
//         * If Nimbus (introduced in Java SE 6) is not available, stay with the
//         * default look and feel. For details see
//         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(EditColumnsLayoutDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(EditColumnsLayoutDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(EditColumnsLayoutDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EditColumnsLayoutDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /*
//         * Create and display the dialog
//         */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                EditColumnsLayoutDialog dialog = new EditColumnsLayoutDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    private void initialize() {
        int gw = 1;
        colLabelMap = new HashMap<>();
        colFieldMap = new HashMap<>();
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        layoutRows = columns.size();
        layoutCols = 3;
        colsPanel.setLayout(layout);
        labels = new JLabel[columns.size()];
        fields = new Component[columns.size()];
        int i = 0;
        for (indexany.GuiColumn col : columns) {
            colCombobox.addItem(col.getName());
            labels[i] = new JLabel();
            if (col.getType() == GuiColumn.EMAILS || col.getType() == GuiColumn.LINKS) {
                gw = 3;
                fields[i] = new JTextArea(3, 20);
                col.setHeight(3);
                col.setWidth(20);
            } else if (col.getType() == GuiColumn.INTEGER) {
                fields[i] = new JTextField(5);
                gw = 1;
                col.setHeight(1);
                col.setWidth(5);
            } else if (col.getType() == GuiColumn.DATE) {
                fields[i] = new JTextField(10);
                gw = 2;
                col.setHeight(1);
                col.setWidth(10);
            } else {
                fields[i] = new JTextField(20);
                gw = 3;
                col.setHeight(1);
                col.setWidth(20);
            }
            colLabelMap.put(col.getName(), labels[i]);
            labels[i].setText(col.getName());
            labels[i].setLabelFor(fields[i]);
            colFieldMap.put(col.getName(), fields[i]);

            // add to layout
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.LINE_END;
            colsPanel.add(labels[i], gbc);
            gbc.gridx = 1;
            gbc.gridwidth = gw;
            gbc.anchor = GridBagConstraints.LINE_START;
            col.setX(i);
            col.setY(0);
            colsPanel.add(fields[i], gbc);

            ++i;
        }
        for (int j = 0; j < layoutRows; ++j) {
            horCombobox.addItem(j);
        }
        for (int j = 0; j < layoutCols; ++j) {
            verCombobox.addItem(j);
        }

        colComboboxItemStateChanged(null);
    }

    private indexany.GuiColumn getCol(String name) {
        for (indexany.GuiColumn col : columns) {
            if (col.getName().equals(name)) {
                return col;
            }
        }
        return null;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox colCombobox;
    private javax.swing.JLabel colLabel;
    private javax.swing.JPanel colsPanel;
    private javax.swing.JButton doneButton;
    private javax.swing.JComboBox horCombobox;
    private javax.swing.JLabel horLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox sizeCombobox;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JComboBox verCombobox;
    private javax.swing.JLabel verLabel;
    // End of variables declaration//GEN-END:variables
    private Set<indexany.GuiColumn> columns;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    private int layoutRows, layoutCols;
    private JLabel[] labels;
    private Component[] fields;
    private Map<String, JLabel> colLabelMap;
    private Map<String, Object> colFieldMap;
    private indexany.GuiColumn currentCol;
    private Object currentField;
    private JLabel currentLabel;
}
