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
 * PanelInicio.java
 *
 * Created on 19-may-2010, 11:08:34
 */
package com.codeko.apps.maimonides;

import com.codeko.apps.maimonides.conf.PanelInfoConfiguracion;
import com.codeko.apps.maimonides.elementos.Profesor;
import com.codeko.apps.maimonides.elementos.Unidad;
import com.codeko.apps.maimonides.inicio.PanelAlertasConvivencia;
import com.codeko.apps.maimonides.inicio.PanelAlertasPerdidaEscolaridad;
import com.codeko.apps.maimonides.mantenimiento.PanelInfoCopiasSeguridad;
import com.codeko.apps.maimonides.partes.PanelInfoPartes;
import com.codeko.apps.maimonides.profesores.PanelClasesDelDia;
import com.codeko.apps.maimonides.seneca.PanelInfoSeneca;
import com.codeko.apps.maimonides.usr.Permisos;
import com.codeko.apps.maimonides.usr.Rol;
import com.codeko.apps.maimonides.usr.Usuario;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JPanel;

/**
 *
 * @author codeko
 */
public class PanelInicio extends javax.swing.JPanel implements IPanel, ICargable {

    boolean cargado = false;
    private boolean operativo = false;

    /** Creates new form PanelInicio */
    public PanelInicio() {
        initComponents();
        MaimonidesApp.getApplication().addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("anoEscolar".equals(evt.getPropertyName())) {
                    setOperativo(evt.getNewValue() != null);
                }
            }
        });
        setOperativo(MaimonidesApp.getApplication().getAnoEscolar() != null);
        this.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("operativo".equals(evt.getPropertyName())) {
                    cargar();
                }
            }
        });
    }

    public boolean isOperativo() {
        return operativo;
    }

    public final void setOperativo(boolean b) {
        boolean old = isOperativo();
        this.operativo = b;
        firePropertyChange("operativo", old, isOperativo());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        setName("maimonides.paneles.herramientas.pantalla_incial"); // NOI18N
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        panel.setName("panel"); // NOI18N

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        cargar();
    }//GEN-LAST:event_formAncestorAdded

    @Override
    public boolean puedoSusituir() {
        return true;
    }

    @Override
    public void cargar() {
        if (!isCargado() && isOperativo()) {
            setCargado(true);
            GroupLayout layout = (GroupLayout) panel.getLayout();

            ParallelGroup grp = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
            ParallelGroup grp2 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
            ParallelGroup grp3 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
            SequentialGroup sgrp = layout.createSequentialGroup();
            SequentialGroup sgrp2 = layout.createSequentialGroup();

            //Ahora vamos añadiendo los paneles
            if (Permisos.isRol(Rol.ROL_PROFESOR)) {
                PanelClasesDelDia pi = new PanelClasesDelDia();
                addPanel(pi, "Clases del día", grp3, sgrp);
            }
            if (Permisos.isRol(Rol.ROL_TUTOR)) {
                Usuario usr = MaimonidesApp.getApplication().getUsuario();
                Profesor p = null;
                if (usr != null) {
                    p = usr.getProfesor();
                }
                Unidad unidad = null;
                if (p != null) {
                    unidad = Unidad.getUnidadPorTutor(p.getId());
                }
                if (unidad != null) {
                    PanelAlertasPerdidaEscolaridad pi = new PanelAlertasPerdidaEscolaridad();
                    addPanel(pi, "Alertas pérdida de evaluación continua " + unidad, grp3, sgrp);
                    PanelAlertasConvivencia pc = new PanelAlertasConvivencia();
                    addPanel(pc, "Alertas partes de convivencia " + unidad, grp3, sgrp);
                }
            }
            if (Permisos.isRol(Rol.ROL_JEFE_ESTUDIOS)) {
                PanelInfoPartes pi = new PanelInfoPartes();
                addPanel(pi, "Partes de asistencia", grp3, sgrp);
                PanelInfoSeneca ps = new PanelInfoSeneca(true);
                addPanel(ps, "Envío de datos a Séneca", grp3, sgrp);
            }
            if (Permisos.isRol(Rol.ROL_ADMIN)) {
                //PanelInfoCopiasSeguridad ps = new PanelInfoCopiasSeguridad();
                //addPanel(ps, "Copias de seguridad", grp3, sgrp);
                PanelInfoConfiguracion pic = new PanelInfoConfiguracion();
                addPanel(pic, "Configuraciones", grp3, sgrp);
            }

            layout.setHorizontalGroup(grp2.addGroup(sgrp2.addContainerGap().addGroup(grp3).addContainerGap()));
            layout.setVerticalGroup(grp.addGroup(sgrp));
        }
    }

    private void addPanel(JPanel p, String titulo, ParallelGroup pararelGroup, SequentialGroup secuencialGroup) {
        p.setBorder(BorderFactory.createTitledBorder(titulo));
        secuencialGroup.addContainerGap().addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        pararelGroup.addComponent(p, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE);
    }

    @Override
    public void vaciar() {
        setCargado(false);
        panel.removeAll();
    }

    @Override
    public boolean isCargado() {
        return cargado;
    }

    @Override
    public void setCargado(boolean cargado) {
        this.cargado = cargado;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}