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
 * PanelVisionLineasHorarios.java
 *
 * Created on 22-abr-2009, 14:18:23
 */
package com.codeko.apps.maimonides.horarios;

import com.codeko.apps.maimonides.elementos.Horario;
import com.codeko.swing.CodekoAutoTableModel;
import com.codeko.util.Num;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Codeko
 */
public class PanelVisionLineasHorarios extends javax.swing.JPanel {

    CodekoAutoTableModel<Horario> modelo = new CodekoAutoTableModel<Horario>(Horario.class);

    /** Creates new form PanelVisionLineasHorarios */
    public PanelVisionLineasHorarios() {
        initComponents();
        //tabla.getColumnExt("Código").setVisible(false);
        tabla.getColumnExt("Año").setVisible(false);
        tabla.getColumnExt("Día").setCellRenderer(new DefaultTableCellRenderer() {

            @Override
            public void setValue(Object val) {
                int d = Num.getInt(val);
                String dia = DateFormatSymbols.getInstance().getWeekdays()[d + 1];
                setText(dia);
            }
        });

    }

    public void setDatos(ArrayList<Horario> datos) {
        modelo.vaciar();
        modelo.setDatos(datos);
        tabla.packAll();
    }

    void vaciar() {
        modelo.vaciar();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        tabla = new org.jdesktop.swingx.JXTable();

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        scroll.setName("scroll"); // NOI18N

        tabla.setModel(modelo);
        tabla.setColumnControlVisible(true);
        tabla.setName("tabla"); // NOI18N
        scroll.setViewportView(tabla);

        add(scroll, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scroll;
    private org.jdesktop.swingx.JXTable tabla;
    // End of variables declaration//GEN-END:variables
}
