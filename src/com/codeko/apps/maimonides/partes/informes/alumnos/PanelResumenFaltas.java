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
 * PanelResumenFaltas.java
 *
 * Created on 11-may-2009, 9:57:13
 */
package com.codeko.apps.maimonides.partes.informes.alumnos;

import com.codeko.apps.maimonides.ICargable;
import com.codeko.apps.maimonides.MaimonidesUtil;
import com.codeko.apps.maimonides.alumnos.IFiltrableAlumno;
import com.codeko.apps.maimonides.elementos.Alumno;
import com.codeko.apps.maimonides.elementos.Curso;
import java.awt.Color;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author Codeko
 */
public class PanelResumenFaltas extends javax.swing.JPanel implements ICargable,IFiltrableAlumno {

    Color original = null;
    Alumno alumno = null;
    ResumenAsistenciaAlumno resumen = new ResumenAsistenciaAlumno();
    boolean cargado = false;

    /** Creates new form PanelResumenFaltas */
    public PanelResumenFaltas() {
        initComponents();
        original = tfTotal.getBackground();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    @Override
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
        if (alumno == null) {
            vaciar();
        }

    }

    @Override
    public void cargar() {
        MaimonidesUtil.ejecutarTask(this, "actualizar");
    }

    public ResumenAsistencia getResumen() {
        return resumen;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lRetrasos = new javax.swing.JLabel();
        tfRetrasos = new javax.swing.JTextField();
        tfRetrasosD = new javax.swing.JTextField();
        lInjustificadas = new javax.swing.JLabel();
        tfInjustificadas = new javax.swing.JTextField();
        tfInjusitificadasD = new javax.swing.JTextField();
        lJustificadas = new javax.swing.JLabel();
        tfJustificadas = new javax.swing.JTextField();
        tfJustificadasD = new javax.swing.JTextField();
        lTotal = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        tfTotalD = new javax.swing.JTextField();
        lSumanR = new javax.swing.JLabel();
        lSumaI = new javax.swing.JLabel();
        tfIR = new javax.swing.JTextField();
        tfIRD = new javax.swing.JTextField();
        lExpulsado = new javax.swing.JLabel();
        tfExpulsados = new javax.swing.JTextField();
        tfExpD = new javax.swing.JTextField();
        tfRetrasosDD = new javax.swing.JTextField();
        tfInjustificadasDD = new javax.swing.JTextField();
        tfJustificadasDD = new javax.swing.JTextField();
        tfIRDD = new javax.swing.JTextField();
        tfexpDD = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfTotalDD = new javax.swing.JTextField();
        jXTitledSeparator1 = new org.jdesktop.swingx.JXTitledSeparator();

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class).getContext().getResourceMap(PanelResumenFaltas.class);
        jLabel2.setFont(resourceMap.getFont("jLabel4.font")); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.16;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(resourceMap.getFont("jLabel4.font")); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setToolTipText(resourceMap.getString("jLabel3.toolTipText")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.16;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(resourceMap.getFont("jLabel4.font")); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setToolTipText(resourceMap.getString("jLabel4.toolTipText")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.16;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel1.add(jLabel4, gridBagConstraints);

        lRetrasos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lRetrasos.setIcon(resourceMap.getIcon("lRetrasos.icon")); // NOI18N
        lRetrasos.setText(resourceMap.getString("lRetrasos.text")); // NOI18N
        lRetrasos.setToolTipText(resourceMap.getString("lRetrasos.toolTipText")); // NOI18N
        lRetrasos.setName("lRetrasos"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel1.add(lRetrasos, gridBagConstraints);

        tfRetrasos.setEditable(false);
        tfRetrasos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfRetrasos.setText(resourceMap.getString("tfRetrasos.text")); // NOI18N
        tfRetrasos.setName("tfRetrasos"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        jPanel1.add(tfRetrasos, gridBagConstraints);

        tfRetrasosD.setEditable(false);
        tfRetrasosD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfRetrasosD.setName("tfRetrasosD"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        jPanel1.add(tfRetrasosD, gridBagConstraints);

        lInjustificadas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lInjustificadas.setIcon(resourceMap.getIcon("lInjustificadas.icon")); // NOI18N
        lInjustificadas.setText(resourceMap.getString("lInjustificadas.text")); // NOI18N
        lInjustificadas.setToolTipText(resourceMap.getString("lInjustificadas.toolTipText")); // NOI18N
        lInjustificadas.setName("lInjustificadas"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel1.add(lInjustificadas, gridBagConstraints);

        tfInjustificadas.setEditable(false);
        tfInjustificadas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfInjustificadas.setText(resourceMap.getString("tfInjustificadas.text")); // NOI18N
        tfInjustificadas.setName("tfInjustificadas"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        jPanel1.add(tfInjustificadas, gridBagConstraints);

        tfInjusitificadasD.setEditable(false);
        tfInjusitificadasD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfInjusitificadasD.setName("tfInjusitificadasD"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        jPanel1.add(tfInjusitificadasD, gridBagConstraints);

        lJustificadas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lJustificadas.setIcon(resourceMap.getIcon("lJustificadas.icon")); // NOI18N
        lJustificadas.setText(resourceMap.getString("lJustificadas.text")); // NOI18N
        lJustificadas.setToolTipText(resourceMap.getString("lJustificadas.toolTipText")); // NOI18N
        lJustificadas.setName("lJustificadas"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel1.add(lJustificadas, gridBagConstraints);

        tfJustificadas.setEditable(false);
        tfJustificadas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfJustificadas.setText(resourceMap.getString("tfJustificadas.text")); // NOI18N
        tfJustificadas.setName("tfJustificadas"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        jPanel1.add(tfJustificadas, gridBagConstraints);

        tfJustificadasD.setEditable(false);
        tfJustificadasD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfJustificadasD.setName("tfJustificadasD"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        jPanel1.add(tfJustificadasD, gridBagConstraints);

        lTotal.setFont(resourceMap.getFont("lTotal.font")); // NOI18N
        lTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lTotal.setText(resourceMap.getString("lTotal.text")); // NOI18N
        lTotal.setName("lTotal"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel1.add(lTotal, gridBagConstraints);

        tfTotal.setEditable(false);
        tfTotal.setFont(resourceMap.getFont("tfTotal.font")); // NOI18N
        tfTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfTotal.setText(resourceMap.getString("tfTotal.text")); // NOI18N
        tfTotal.setName("tfTotal"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel1.add(tfTotal, gridBagConstraints);

        tfTotalD.setEditable(false);
        tfTotalD.setFont(resourceMap.getFont("tfTotalD.font")); // NOI18N
        tfTotalD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfTotalD.setName("tfTotalD"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel1.add(tfTotalD, gridBagConstraints);

        lSumanR.setFont(resourceMap.getFont("lSumanR.font")); // NOI18N
        lSumanR.setIcon(resourceMap.getIcon("lSumanR.icon")); // NOI18N
        lSumanR.setText(resourceMap.getString("lSumanR.text")); // NOI18N
        lSumanR.setName("lSumanR"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 3, 0, 5);
        jPanel1.add(lSumanR, gridBagConstraints);

        lSumaI.setIcon(resourceMap.getIcon("lSumaI.icon")); // NOI18N
        lSumaI.setText(resourceMap.getString("lSumaI.text")); // NOI18N
        lSumaI.setName("lSumaI"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel1.add(lSumaI, gridBagConstraints);

        tfIR.setEditable(false);
        tfIR.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfIR.setText(resourceMap.getString("tfIR.text")); // NOI18N
        tfIR.setName("tfIR"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        jPanel1.add(tfIR, gridBagConstraints);

        tfIRD.setEditable(false);
        tfIRD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfIRD.setName("tfIRD"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        jPanel1.add(tfIRD, gridBagConstraints);

        lExpulsado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lExpulsado.setIcon(resourceMap.getIcon("lExpulsado.icon")); // NOI18N
        lExpulsado.setText(resourceMap.getString("lExpulsado.text")); // NOI18N
        lExpulsado.setToolTipText(resourceMap.getString("lExpulsado.toolTipText")); // NOI18N
        lExpulsado.setName("lExpulsado"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 3, 0, 5);
        jPanel1.add(lExpulsado, gridBagConstraints);

        tfExpulsados.setEditable(false);
        tfExpulsados.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfExpulsados.setName("tfExpulsados"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        jPanel1.add(tfExpulsados, gridBagConstraints);

        tfExpD.setEditable(false);
        tfExpD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfExpD.setName("tfExpD"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        jPanel1.add(tfExpD, gridBagConstraints);

        tfRetrasosDD.setEditable(false);
        tfRetrasosDD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfRetrasosDD.setText(resourceMap.getString("tfRetrasosDD.text")); // NOI18N
        tfRetrasosDD.setName("tfRetrasosDD"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        jPanel1.add(tfRetrasosDD, gridBagConstraints);

        tfInjustificadasDD.setEditable(false);
        tfInjustificadasDD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfInjustificadasDD.setText(resourceMap.getString("tfInjustificadasDD.text")); // NOI18N
        tfInjustificadasDD.setName("tfInjustificadasDD"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        jPanel1.add(tfInjustificadasDD, gridBagConstraints);

        tfJustificadasDD.setEditable(false);
        tfJustificadasDD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfJustificadasDD.setText(resourceMap.getString("tfJustificadasDD.text")); // NOI18N
        tfJustificadasDD.setName("tfJustificadasDD"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        jPanel1.add(tfJustificadasDD, gridBagConstraints);

        tfIRDD.setEditable(false);
        tfIRDD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfIRDD.setText(resourceMap.getString("tfIRDD.text")); // NOI18N
        tfIRDD.setName("tfIRDD"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        jPanel1.add(tfIRDD, gridBagConstraints);

        tfexpDD.setEditable(false);
        tfexpDD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfexpDD.setText(resourceMap.getString("tfexpDD.text")); // NOI18N
        tfexpDD.setName("tfexpDD"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        jPanel1.add(tfexpDD, gridBagConstraints);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jLabel1, gridBagConstraints);

        tfTotalDD.setEditable(false);
        tfTotalDD.setFont(resourceMap.getFont("tfTotalDD.font")); // NOI18N
        tfTotalDD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfTotalDD.setText(resourceMap.getString("tfTotalDD.text")); // NOI18N
        tfTotalDD.setName("tfTotalDD"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        jPanel1.add(tfTotalDD, gridBagConstraints);

        jXTitledSeparator1.setTitle(resourceMap.getString("jXTitledSeparator1.title")); // NOI18N
        jXTitledSeparator1.setName("jXTitledSeparator1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel1.add(jXTitledSeparator1, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    @Action(block = Task.BlockingScope.ACTION)
    public Task actualizar() {
        return new ActualizarTask(org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class));
    }

    @Override
    public boolean isCargado() {
        return this.cargado;
    }

    @Override
    public void setCargado(boolean cargado) {
        this.cargado = cargado;
    }

    private class ActualizarTask extends org.jdesktop.application.Task<Object, Void> {

        ActualizarTask(org.jdesktop.application.Application app) {
            super(app);
            vaciar();
        }

        @Override
        protected Object doInBackground() {
            setMessage("Actualizando...");
            getResumen().setAlumno(getAlumno());
            return null;
        }

        @Override
        protected void succeeded(Object result) {
            setCargado(true);
            setMessage("Resumen de asistencia cargado correctamente.");
            tfExpulsados.setText(getResumen().getExpulsadas() + "");
            tfIR.setText(getResumen().getInjustificasRetrasos() + "");
            tfInjustificadas.setText(getResumen().getInjustificadas() + "");
            tfJustificadas.setText(getResumen().getJustificadas() + "");
            tfRetrasos.setText(getResumen().getRetrasos() + "");
            tfTotal.setText(getResumen().getTotalFaltas() + "");

            tfIRD.setText(getResumen().getDiasInjustificosRetrasos() + "");
            tfInjusitificadasD.setText(getResumen().getDiasInjustificados() + "");
            tfJustificadasD.setText(getResumen().getDiasJustificadosReal() + "");
            tfRetrasosD.setText(getResumen().getDiasRetrasos() + "");
            tfTotalD.setText(getResumen().getDiasTotalFaltas() + "");
            tfExpD.setText(getResumen().getDiasExpulsados() + "");

            tfIRDD.setText(getResumen().getDiasDiferentesInjustificadasRetrasos() + "");
            tfInjustificadasDD.setText(getResumen().getDiasDiferentesInjustificadas() + "");
            tfJustificadasDD.setText(getResumen().getDiasDiferentesJustificadas() + "");
            tfRetrasosDD.setText(getResumen().getDiasDiferentesRetrasos() + "");
            tfTotalDD.setText(getResumen().getTotalDiasDiferentes() + "");
            tfexpDD.setText(getResumen().getDiasDiferentesExpulsiones() + "");
            //Ahora vemos si está cerca de perder la escolaridad
            if (getAlumno() != null && getAlumno().getObjetoCurso() != null) {
                Curso c = getAlumno().getObjetoCurso();
                //TODO Los colores y valores deberían ser configurables y compartidos con el otro ifnorme
                int total = getResumen().getTotalFaltas();
                tfTotal.setBackground(original);
                if (total >= c.getMaxFaltas()) {
                    tfTotal.setBackground(Color.RED);
                } else if (total >= (c.getMaxFaltas() * 0.8)) {
                    tfTotal.setBackground(Color.ORANGE);
                } else if (total >= (c.getMaxFaltas() * 0.5)) {
                    tfTotal.setBackground(Color.lightGray);
                }
            }
        }
    }

    @Override
    public void vaciar() {
        tfIR.setText("");
        tfInjustificadas.setText("");
        tfJustificadas.setText("");
        tfRetrasos.setText("");
        tfTotal.setText("");
        tfExpulsados.setText("");


        tfIRD.setText("");
        tfInjusitificadasD.setText("");
        tfJustificadasD.setText("");
        tfRetrasosD.setText("");
        tfTotalD.setText("");
        tfExpD.setText("");

        tfIRDD.setText("");
        tfInjustificadasDD.setText("");
        tfJustificadasDD.setText("");
        tfRetrasosDD.setText("");
        tfTotalDD.setText("");
        tfexpDD.setText("");
        setCargado(false);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXTitledSeparator jXTitledSeparator1;
    private javax.swing.JLabel lExpulsado;
    private javax.swing.JLabel lInjustificadas;
    private javax.swing.JLabel lJustificadas;
    private javax.swing.JLabel lRetrasos;
    private javax.swing.JLabel lSumaI;
    private javax.swing.JLabel lSumanR;
    private javax.swing.JLabel lTotal;
    private javax.swing.JTextField tfExpD;
    private javax.swing.JTextField tfExpulsados;
    private javax.swing.JTextField tfIR;
    private javax.swing.JTextField tfIRD;
    private javax.swing.JTextField tfIRDD;
    private javax.swing.JTextField tfInjusitificadasD;
    private javax.swing.JTextField tfInjustificadas;
    private javax.swing.JTextField tfInjustificadasDD;
    private javax.swing.JTextField tfJustificadas;
    private javax.swing.JTextField tfJustificadasD;
    private javax.swing.JTextField tfJustificadasDD;
    private javax.swing.JTextField tfRetrasos;
    private javax.swing.JTextField tfRetrasosD;
    private javax.swing.JTextField tfRetrasosDD;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JTextField tfTotalD;
    private javax.swing.JTextField tfTotalDD;
    private javax.swing.JTextField tfexpDD;
    // End of variables declaration//GEN-END:variables
}