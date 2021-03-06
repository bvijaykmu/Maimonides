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
 * PanelDetalleAsistencia.java
 *
 * Created on 10-may-2010, 17:47:49
 */
package com.codeko.apps.maimonides.partes.informes.alumnos;

import com.codeko.apps.maimonides.elementos.LineaParteAlumno;
import com.codeko.apps.maimonides.elementos.Profesor;
import com.codeko.util.Fechas;
import com.codeko.util.Str;

/**
 *
 * @author codeko
 */
public class PanelDetalleAsistencia extends javax.swing.JPanel {

    /** Creates new form PanelDetalleAsistencia */
    public PanelDetalleAsistencia() {
        initComponents();
    }

    public void setDatos(LineaParteAlumno l) {
        if (l != null) {
            setVisible(true);
            lValorMateria.setText(Str.noNulo(l.getHorario().getObjetoMateriaOActividad()));
            lValorProfesor.setText(Str.noNulo(Profesor.getNombreProfesor(l.getHorario().getProfesor())));
            lValorFecha.setText(Fechas.format(l.getParte().getFecha()));
        } else {
            setVisible(false);
            lValorMateria.setText("-");
            lValorProfesor.setText("-");
            lValorFecha.setText("-");
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

        lMateria = new javax.swing.JLabel();
        lValorMateria = new javax.swing.JLabel();
        lProfesor = new javax.swing.JLabel();
        lValorProfesor = new javax.swing.JLabel();
        bCerrar = new org.jdesktop.swingx.JXHyperlink();
        jLabel1 = new javax.swing.JLabel();
        lValorFecha = new javax.swing.JLabel();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class).getContext().getResourceMap(PanelDetalleAsistencia.class);
        lMateria.setText(resourceMap.getString("lMateria.text")); // NOI18N
        lMateria.setName("lMateria"); // NOI18N

        lValorMateria.setText(resourceMap.getString("lValorMateria.text")); // NOI18N
        lValorMateria.setName("lValorMateria"); // NOI18N

        lProfesor.setText(resourceMap.getString("lProfesor.text")); // NOI18N
        lProfesor.setName("lProfesor"); // NOI18N

        lValorProfesor.setText(resourceMap.getString("lValorProfesor.text")); // NOI18N
        lValorProfesor.setName("lValorProfesor"); // NOI18N

        bCerrar.setIcon(resourceMap.getIcon("bCerrar.icon")); // NOI18N
        bCerrar.setName("bCerrar"); // NOI18N
        bCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarActionPerformed(evt);
            }
        });

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        lValorFecha.setText(resourceMap.getString("lValorFecha.text")); // NOI18N
        lValorFecha.setName("lValorFecha"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lMateria, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(lProfesor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lValorProfesor, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lValorMateria, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lValorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))
                    .addComponent(bCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lMateria)
                            .addComponent(lValorMateria)
                            .addComponent(lValorFecha)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lProfesor)
                            .addComponent(lValorProfesor)))
                    .addComponent(bCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_bCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXHyperlink bCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lMateria;
    private javax.swing.JLabel lProfesor;
    private javax.swing.JLabel lValorFecha;
    private javax.swing.JLabel lValorMateria;
    private javax.swing.JLabel lValorProfesor;
    // End of variables declaration//GEN-END:variables
}
