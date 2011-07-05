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
 * PanelPartesPendientes.java
 *
 * Created on 4 de noviembre de 2008, 17:35
 */
package com.codeko.apps.maimonides.partes.informes;

import com.codeko.apps.maimonides.partes.*;
import com.codeko.apps.maimonides.IPanel;
import com.codeko.apps.maimonides.MaimonidesApp;
import com.codeko.apps.maimonides.MaimonidesUtil;
import com.codeko.apps.maimonides.elementos.ParteFaltas;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import com.codeko.swing.CodekoTableModel;
import com.codeko.util.Fechas;
import com.codeko.util.Obj;
import com.codeko.util.Str;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;
import org.jdesktop.swingx.sort.RowFilters;
import org.jdesktop.swingx.table.TableColumnExt;


public class PanelPartesPendientes extends javax.swing.JPanel implements IPanel {

    CodekoTableModel<ParteFaltas> modelo = new CodekoTableModel<ParteFaltas>(new ParteFaltas());
    boolean cargado = false;

    /** Creates new form PanelPartesPendientes */
    public PanelPartesPendientes() {
        initComponents();
        MaimonidesUtil.addMenuTabla(tabla, "Partes pendientes de digitalizar");
        tabla.getColumnExt("Código").setVisible(false);
        tabla.setAutoCreateRowSorter(true);
        TableColumnExt tc = tabla.getColumnExt("Fecha");
        tc.setCellRenderer(new DefaultTableCellRenderer() {

            @Override
            public void setValue(Object val) {
                setText(Fechas.format(val));
            }
        });
        tc.setMaxWidth(80);
        tabla.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
                    int row = tabla.rowAtPoint(e.getPoint());
                    editarParte(modelo.getElemento(tabla.convertRowIndexToModel(row)));
                }
            }
        });
        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                setParteSeleccionado(tabla.getSelectedRow() != -1);
            }
        });
        cbCurso.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = Str.noNulo(cbCurso.getSelectedItem());
                setFiltroTabla(obj.toString());
            }
        });
    }

    private void setFiltroTabla(String filtro) {
        if (filtro != null && !filtro.trim().equals("") && !filtro.trim().equals("Todos")) {
            tabla.setRowFilter(RowFilters.regexFilter(filtro,tabla.getColumnModel().getColumnIndex("Curso")));
        }else{
            tabla.setRowFilter(null);
        }
    }

    @Action
    private void editarParte(ParteFaltas parte) {
        PanelListaAlumnosParte.abrirEditorParte(parte);
    }

    public boolean isCargado() {
        return cargado;
    }

    public void setCargado(boolean cargado) {
        this.cargado = cargado;
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
        bHerramientas = new javax.swing.JToolBar();
        bActualizar = new javax.swing.JButton();
        bEditar = new javax.swing.JButton();
        pCurso = new javax.swing.JPanel();
        lCurso = new javax.swing.JLabel();
        cbCurso = new javax.swing.JComboBox();

        setName("Form"); // NOI18N
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

        scroll.setName("scroll"); // NOI18N

        tabla.setModel(modelo);
        tabla.setColumnControlVisible(true);
        tabla.setName("tabla"); // NOI18N
        scroll.setViewportView(tabla);

        add(scroll, java.awt.BorderLayout.CENTER);

        bHerramientas.setRollover(true);
        bHerramientas.setName("bHerramientas"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class).getContext().getActionMap(PanelPartesPendientes.class, this);
        bActualizar.setAction(actionMap.get("actualizar")); // NOI18N
        bActualizar.setFocusable(false);
        bActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bActualizar.setName("bActualizar"); // NOI18N
        bActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bHerramientas.add(bActualizar);

        bEditar.setAction(actionMap.get("editarParteSeleccionado")); // NOI18N
        bEditar.setFocusable(false);
        bEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bEditar.setName("bEditar"); // NOI18N
        bEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bHerramientas.add(bEditar);

        add(bHerramientas, java.awt.BorderLayout.PAGE_START);

        pCurso.setName("pCurso"); // NOI18N
        pCurso.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class).getContext().getResourceMap(PanelPartesPendientes.class);
        lCurso.setText(resourceMap.getString("lCurso.text")); // NOI18N
        lCurso.setName("lCurso"); // NOI18N
        pCurso.add(lCurso);

        cbCurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos" }));
        cbCurso.setName("cbCurso"); // NOI18N
        pCurso.add(cbCurso);

        add(pCurso, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
//    if (!Beans.isDesignTime() && !isCargado()) {
//        MaimonidesUtil.ejecutarTask(this, "actualizar");
//    }
}//GEN-LAST:event_formAncestorAdded

    @Action(block = Task.BlockingScope.APPLICATION)
    public Task actualizar() {
        return new ActualizarTask(org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class));
    }

    public static int getTotalPartes() {
        int total = 0;
        PreparedStatement st = null;
        ResultSet res = null;
        try {
            String sql = "SELECT count(*) AS total FROM partes AS p WHERE p.ano=? AND p.digitalizado=0 AND DATE(p.fecha)< DATE(NOW()) ";
            st = (PreparedStatement) MaimonidesApp.getApplication().getConector().getConexion().prepareStatement(sql);
            st.setInt(1, MaimonidesApp.getApplication().getAnoEscolar().getId());
            res = st.executeQuery();
            if (res.next()) {
                total = res.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPartesPendientes.class.getName()).log(Level.SEVERE, null, ex);
        }

        Obj.cerrar(res, st);
        return total;
    }

    private class ActualizarTask extends org.jdesktop.application.Task<Object, Void> {

        ActualizarTask(org.jdesktop.application.Application app) {
            super(app);
            modelo.vaciar();
            cbCurso.removeAllItems();
            cbCurso.addItem("Todos");
            setFiltroTabla("");
            setProgress(1);
        }

        @Override
        protected Object doInBackground() {
            PreparedStatement st = null;
            ResultSet res = null;
            try {
                int total = getTotalPartes() + 1;
                st = (PreparedStatement) MaimonidesApp.getApplication().getConector().getConexion().prepareStatement("SELECT distinct p.* FROM partes AS p LEFT JOIN cursos AS c ON c.curso=p.curso WHERE p.ano=? AND p.digitalizado=0 AND DATE(p.fecha)< DATE(NOW()) ORDER BY p.fecha DESC,c.posicion,p.id");
                st.setInt(1, MaimonidesApp.getApplication().getAnoEscolar().getId());
                res = st.executeQuery();
                int pos = 1;
                ArrayList<String> cursos = new ArrayList<String>();
                while (res.next() && !isCancelled()) {
                    pos++;
                    setMessage(String.format("Cargando partes de asistencias %d de %d...", pos - 1, total - 1));
                    setProgress(pos, 0, total);
                    ParteFaltas p = new ParteFaltas();
                    p.cargarDesdeResultSet(res);
                    modelo.addDato(p);
                    String curso = p.getCurso();
                    if (!cursos.contains(curso)) {
                        cursos.add(curso);
                    }
                }
                Collections.sort(cursos);
                for (String s : cursos) {
                    cbCurso.addItem(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelPartesPendientes.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                Obj.cerrar(st, res);
            }
            return null;
        }

        @Override
        protected void succeeded(Object result) {
            tabla.packAll();
            setCargado(true);
        }
    }
    private boolean parteSeleccionado = false;

    public boolean isParteSeleccionado() {
        return parteSeleccionado;
    }

    public void setParteSeleccionado(boolean b) {
        boolean old = isParteSeleccionado();
        this.parteSeleccionado = b;
        firePropertyChange("parteSeleccionado", old, isParteSeleccionado());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizar;
    private javax.swing.JButton bEditar;
    private javax.swing.JToolBar bHerramientas;
    private javax.swing.JComboBox cbCurso;
    private javax.swing.JLabel lCurso;
    private javax.swing.JPanel pCurso;
    private javax.swing.JScrollPane scroll;
    private org.jdesktop.swingx.JXTable tabla;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean puedoSusituir() {
        return true;
    }

    @Action(enabledProperty = "parteSeleccionado")
    public void editarParteSeleccionado() {
        int row = tabla.getSelectedRow();
        if (row > -1) {
            ParteFaltas p = modelo.getElemento(tabla.convertRowIndexToModel(row));
            editarParte(p);
        }

    }
}
