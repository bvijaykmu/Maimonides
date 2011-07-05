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
 * PanelAccesoSeneca.java
 *
 * Created on 30-mar-2009, 8:41:02
 */
package com.codeko.apps.maimonides.seneca;

import com.codeko.util.Str;

/**
 * Panel para la petición de usuario y clave de Séneca
 * @author Codeko
 */
public class PanelAccesoSeneca extends javax.swing.JPanel {

    /** Creates new form PanelAccesoSeneca */
    public PanelAccesoSeneca() {
        initComponents();
    }

    public void setDatos(String usuario, String clave, boolean recordad) {
        tfusuario.setText(Str.noNulo(usuario));
        tfClave.setText(Str.noNulo(clave));
        cbRecordar.setSelected(recordad);
    }

    public String getUsuario() {
        return tfusuario.getText().trim();
    }

    public String getClave() {
        return new String(tfClave.getPassword()).trim();
    }

    public boolean isRecordar() {
        return cbRecordar.isSelected();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lUsuario = new javax.swing.JLabel();
        lClave = new javax.swing.JLabel();
        tfusuario = new javax.swing.JTextField();
        tfClave = new javax.swing.JPasswordField();
        cbRecordar = new javax.swing.JCheckBox();
        cabAcceso = new org.jdesktop.swingx.JXHeader();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class).getContext().getResourceMap(PanelAccesoSeneca.class);
        lUsuario.setText(resourceMap.getString("lUsuario.text")); // NOI18N
        lUsuario.setName("lUsuario"); // NOI18N

        lClave.setText(resourceMap.getString("lClave.text")); // NOI18N
        lClave.setName("lClave"); // NOI18N

        tfusuario.setText(resourceMap.getString("tfusuario.text")); // NOI18N
        tfusuario.setName("tfusuario"); // NOI18N

        tfClave.setText(resourceMap.getString("tfClave.text")); // NOI18N
        tfClave.setName("tfClave"); // NOI18N

        cbRecordar.setText(resourceMap.getString("cbRecordar.text")); // NOI18N
        cbRecordar.setName("cbRecordar"); // NOI18N

        cabAcceso.setDescription(resourceMap.getString("cabAcceso.description")); // NOI18N
        cabAcceso.setIcon(resourceMap.getIcon("cabAcceso.icon")); // NOI18N
        cabAcceso.setTitle(resourceMap.getString("cabAcceso.title")); // NOI18N
        cabAcceso.setToolTipText(resourceMap.getString("cabAcceso.toolTipText")); // NOI18N
        cabAcceso.setName("cabAcceso"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cabAcceso, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lClave, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(lUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbRecordar, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(tfClave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(tfusuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(cabAcceso, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lClave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbRecordar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXHeader cabAcceso;
    private javax.swing.JCheckBox cbRecordar;
    private javax.swing.JLabel lClave;
    private javax.swing.JLabel lUsuario;
    private javax.swing.JPasswordField tfClave;
    private javax.swing.JTextField tfusuario;
    // End of variables declaration//GEN-END:variables
}
