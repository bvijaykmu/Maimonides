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
 * PanelConfiguracionSMSGestion.java
 *
 * Created on 18-may-2010, 13:35:47
 */
package com.codeko.apps.maimonides.conf;

import com.codeko.apps.maimonides.MaimonidesApp;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author codeko
 */
public class PanelConfiguracionSMSGestion extends javax.swing.JPanel {

    /** Creates new form PanelConfiguracionSMSGestion */
    public PanelConfiguracionSMSGestion() {
        initComponents();
        tfClave.setText(MaimonidesApp.getApplication().getConfiguracion().get("smsGestion.clave_servicio", ""));
        tfEntidad.setText(MaimonidesApp.getApplication().getConfiguracion().get("smsGestion.entidad", ""));
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
        jLabel2 = new javax.swing.JLabel();
        tfEntidad = new javax.swing.JTextField();
        bGuardar = new javax.swing.JButton();
        tfClave = new javax.swing.JPasswordField();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class).getContext().getResourceMap(PanelConfiguracionSMSGestion.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        tfEntidad.setText(resourceMap.getString("tfEntidad.text")); // NOI18N
        tfEntidad.setName("tfEntidad"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class).getContext().getActionMap(PanelConfiguracionSMSGestion.class, this);
        bGuardar.setAction(actionMap.get("guardar")); // NOI18N
        bGuardar.setName("bGuardar"); // NOI18N

        tfClave.setText(resourceMap.getString("tfClave.text")); // NOI18N
        tfClave.setName("tfClave"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfClave, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addComponent(tfEntidad, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(310, Short.MAX_VALUE)
                .addComponent(bGuardar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addComponent(bGuardar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Action(block = Task.BlockingScope.APPLICATION)
    public Task guardar() {
        return new GuardarTask(org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class));
    }

    private class GuardarTask extends org.jdesktop.application.Task<Object, Void> {

        GuardarTask(org.jdesktop.application.Application app) {
            super(app);
            setMessage("Guardando configuración...");
        }

        @Override
        protected Object doInBackground() {
            MaimonidesApp.getApplication().getConfiguracion().set("smsGestion.clave_servicio", new String(tfClave.getPassword()));
            MaimonidesApp.getApplication().getConfiguracion().set("smsGestion.entidad", tfEntidad.getText());
            //Guardamos el tipo de servicio a usar.
            MaimonidesApp.getApplication().getConfiguracion().set("sms.servicio", "smsGestion");
            return null;
        }

        @Override
        protected void succeeded(Object result) {
            setMessage("Datos guardados correctamente.");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField tfClave;
    private javax.swing.JTextField tfEntidad;
    // End of variables declaration//GEN-END:variables
}
