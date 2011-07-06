/**
 *  Maimónides, gestión para centros escolares.
 *  Copyright Codeko and individual contributors
 *  as indicated by the @author tags.
 * 
 *  This is free software; you can redistribute it and/or modify it
 *  under the terms of the GNU General Public License as
 *  published by the Free Software Foundation; either version 2 of
 *  the License, or (at your option) any later version.
 * 
 *  This software is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *  General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public
 *  License along with this software; if not, write to the Free
 *  Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *  02110-1301 USA, or see the FSF site: http://www.fsf.org.
 *  
 *  For more information:
 *  maimonides@codeko.com
 *  http://codeko.com/maimonides
**/


/*
 * PanelConfiguracionesSMS.java
 *
 * Created on 18-may-2010, 13:32:46
 */
package com.codeko.apps.maimonides.conf;

import com.codeko.apps.maimonides.MaimonidesApp;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author codeko
 */
public class PanelConfiguracionesSMS extends javax.swing.JPanel {

    /** Creates new form PanelConfiguracionesSMS */
    public PanelConfiguracionesSMS() {
        initComponents();
        cbServicioSMS.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    ((CardLayout) panel.getLayout()).show(panel, e.getItem().toString());
                }
            }
        });
        //Ahora cargamos el tipo de servicio
        String tipo = MaimonidesApp.getApplication().getConfiguracion().get("sms.servicio", "mail");
        if (tipo.equals("mail")) {
            cbServicioSMS.setSelectedIndex(0);
        } else if (tipo.equals("smsGestion")) {
            cbServicioSMS.setSelectedIndex(1);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbServicioSMS = new javax.swing.JComboBox();
        panel = new javax.swing.JPanel();
        panelConfiguracionMail1 = new com.codeko.apps.maimonides.conf.mail.PanelConfiguracionMail("SMS");
        panelConfiguracionSMSGestion1 = new com.codeko.apps.maimonides.conf.PanelConfiguracionSMSGestion();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class).getContext().getResourceMap(PanelConfiguracionesSMS.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        cbServicioSMS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Servicio de Email a SMS", "SMSGestión" }));
        cbServicioSMS.setName("cbServicioSMS"); // NOI18N

        panel.setName("panel"); // NOI18N
        panel.setLayout(new java.awt.CardLayout());

        panelConfiguracionMail1.setName("panelConfiguracionMail1"); // NOI18N
        panel.add(panelConfiguracionMail1, "Servicio de Email a SMS");

        panelConfiguracionSMSGestion1.setName("panelConfiguracionSMSGestion1"); // NOI18N
        panel.add(panelConfiguracionSMSGestion1, "SMSGestión");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbServicioSMS, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbServicioSMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbServicioSMS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel;
    private com.codeko.apps.maimonides.conf.mail.PanelConfiguracionMail panelConfiguracionMail1;
    private com.codeko.apps.maimonides.conf.PanelConfiguracionSMSGestion panelConfiguracionSMSGestion1;
    // End of variables declaration//GEN-END:variables
}