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
 * PanelEditorRoles.java
 *
 * Created on 20-abr-2010, 12:37:05
 */
package com.codeko.apps.maimonides.usr;

/**
 *
 * @author codeko
 */
public class PanelEditorRoles extends javax.swing.JPanel {

    /** Creates new form PanelEditorRoles */
    public PanelEditorRoles() {
        initComponents();
    }

    public int getRoles() {
        int roles = 0;
        if (cbAdministrador.isSelected()) {
            roles |= Rol.ROL_ADMIN;
        }
        if (cbDirectivo.isSelected()) {
            roles |= Rol.ROL_DIRECTIVO;
        }
        if (cbJefeEstudios.isSelected()) {
            roles |= Rol.ROL_JEFE_ESTUDIOS;
        }
        if (cbProfesor.isSelected()) {
            roles |= Rol.ROL_PROFESOR;
        }
        return roles;
    }

    public void setRoles(int roles){
        cbAdministrador.setSelected((roles&Rol.ROL_ADMIN)==Rol.ROL_ADMIN);
        cbDirectivo.setSelected((roles&Rol.ROL_DIRECTIVO)==Rol.ROL_DIRECTIVO);
        cbJefeEstudios.setSelected((roles&Rol.ROL_JEFE_ESTUDIOS)==Rol.ROL_JEFE_ESTUDIOS);
        cbProfesor.setSelected((roles&Rol.ROL_PROFESOR)==Rol.ROL_PROFESOR);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbAdministrador = new javax.swing.JCheckBox();
        cbDirectivo = new javax.swing.JCheckBox();
        cbJefeEstudios = new javax.swing.JCheckBox();
        cbProfesor = new javax.swing.JCheckBox();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class).getContext().getResourceMap(PanelEditorRoles.class);
        cbAdministrador.setText(resourceMap.getString("cbAdministrador.text")); // NOI18N
        cbAdministrador.setName("cbAdministrador"); // NOI18N

        cbDirectivo.setText(resourceMap.getString("cbDirectivo.text")); // NOI18N
        cbDirectivo.setName("cbDirectivo"); // NOI18N

        cbJefeEstudios.setText(resourceMap.getString("cbJefeEstudios.text")); // NOI18N
        cbJefeEstudios.setName("cbJefeEstudios"); // NOI18N

        cbProfesor.setText(resourceMap.getString("cbProfesor.text")); // NOI18N
        cbProfesor.setName("cbProfesor"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAdministrador)
                    .addComponent(cbDirectivo)
                    .addComponent(cbJefeEstudios)
                    .addComponent(cbProfesor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbAdministrador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDirectivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbJefeEstudios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbProfesor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbAdministrador;
    private javax.swing.JCheckBox cbDirectivo;
    private javax.swing.JCheckBox cbJefeEstudios;
    private javax.swing.JCheckBox cbProfesor;
    // End of variables declaration//GEN-END:variables
}
