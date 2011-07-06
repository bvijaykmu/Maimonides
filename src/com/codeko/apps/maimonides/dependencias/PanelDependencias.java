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
 * PanelDependencias.java
 *
 * Created on 14-abr-2009, 10:27:02
 */
package com.codeko.apps.maimonides.dependencias;

import com.codeko.apps.maimonides.IPanel;
import com.codeko.apps.maimonides.MaimonidesApp;
import com.codeko.apps.maimonides.MaimonidesUtil;
import com.codeko.apps.maimonides.elementos.Dependencia;
import com.codeko.apps.maimonides.usr.Permisos;
import com.codeko.swing.CodekoAutoTableModel;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author Codeko
 */
public class PanelDependencias extends javax.swing.JPanel implements IPanel {

    CodekoAutoTableModel<Dependencia> modelo = new CodekoAutoTableModel<Dependencia>(Dependencia.class) {

        @Override
        public void elementoModificado(Dependencia elemento, int col, Object valor) {
            elemento.guardar();
        }
    };

    /** Creates new form PanelDependencias */
    public PanelDependencias() {
        initComponents();
        tabla.getColumnExt("Código").setVisible(false);

        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int pos = tabla.getSelectedRow();
                    setFilaSeleccionada(pos > -1);
                }
            }
        });

        modelo.setEditable(Permisos.edicion(getClass()));

        bNuevo.setEnabled(Permisos.creacion(getClass()));
        bNuevo.setVisible(Permisos.creacion(getClass()));

        bBorrar.setEnabled(Permisos.borrado(getClass()));
        bBorrar.setVisible(Permisos.borrado(getClass()));
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
        tabla = new org.jdesktop.swingx.JXTable();
        barraHerramientas = new javax.swing.JToolBar();
        bActualizar = new javax.swing.JButton();
        bNuevo = new javax.swing.JButton();
        bBorrar = new javax.swing.JButton();

        setName("maimonides.paneles.datos.dependencias"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tabla.setAutoCreateRowSorter(true);
        tabla.setModel(modelo);
        tabla.setColumnControlVisible(true);
        tabla.setName("tabla"); // NOI18N
        tabla.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tablaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        barraHerramientas.setRollover(true);
        barraHerramientas.setName("barraHerramientas"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class).getContext().getActionMap(PanelDependencias.class, this);
        bActualizar.setAction(actionMap.get("actualizar")); // NOI18N
        bActualizar.setFocusable(false);
        bActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bActualizar.setName("bActualizar"); // NOI18N
        bActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientas.add(bActualizar);

        bNuevo.setAction(actionMap.get("nuevo")); // NOI18N
        bNuevo.setFocusable(false);
        bNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bNuevo.setName("bNuevo"); // NOI18N
        bNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientas.add(bNuevo);

        bBorrar.setAction(actionMap.get("borrar")); // NOI18N
        bBorrar.setFocusable(false);
        bBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bBorrar.setName("bBorrar"); // NOI18N
        bBorrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientas.add(bBorrar);

        add(barraHerramientas, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tablaAncestorAdded
        MaimonidesUtil.ejecutarTask(this, "actualizar");
    }

    @Action(block = Task.BlockingScope.ACTION)
    public Task actualizar() {
        return new ActualizarTask(org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class));
    }//GEN-LAST:event_tablaAncestorAdded

    @Override
    public boolean puedoSusituir() {
        return true;
    }

    private class ActualizarTask extends org.jdesktop.application.Task<Object, Void> {

        ActualizarTask(org.jdesktop.application.Application app) {
            super(app);
            modelo.vaciar();

        }

        @Override
        protected Object doInBackground() {
            int max = MaimonidesUtil.getCount("dependencias");
            int count = 0;
            if (max > 0) {
                setProgress(count, 0, max);
            }
            setMessage("Cargando dependencias...");
            String sql = "SELECT * FROM dependencias WHERE ano=? ";
            PreparedStatement st = null;
            ResultSet res = null;
            try {
                st = (PreparedStatement) MaimonidesApp.getApplication().getConector().getConexion().prepareStatement(sql);
                st.setInt(1, MaimonidesApp.getApplication().getAnoEscolar().getId());
                res = st.executeQuery();
                while (res.next()) {
                    count++;
                    Dependencia d = new Dependencia();
                    try {
                        d.cargarDesdeResultSet(res);
                        modelo.addDato(d);
                        setProgress(count, 0, max);
                    } catch (Exception ex) {
                        Logger.getLogger(PanelDependencias.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelDependencias.class.getName()).log(Level.SEVERE, null, ex);
            }

            return null;
        }

        @Override
        protected void succeeded(Object result) {
            setMessage("Dependencias cargadas correctamente.");
            tabla.packAll();
        }
    }

    @Action(block = Task.BlockingScope.APPLICATION)
    public Task nuevo() {
        return new NuevoTask(org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class));
    }

    private class NuevoTask extends org.jdesktop.application.Task<Dependencia, Void> {

        NuevoTask(org.jdesktop.application.Application app) {
            super(app);
        }

        @Override
        protected Dependencia doInBackground() {
            setMessage("Creando dependencia...");
            Dependencia d = new Dependencia();
            d.setAnoEscolar(MaimonidesApp.getApplication().getAnoEscolar());
            d.setDescripcion("Nueva dependencia");
            d.setNombre("");
            if (!d.guardar()) {
                d = null;
            }
            return d;
        }

        @Override
        protected void succeeded(Dependencia result) {
            if (result != null && result.getId() != null) {
                modelo.addDato(result);
                int row=tabla.convertRowIndexToView(modelo.indexOf(result));
                tabla.scrollRowToVisible(row);
                tabla.editCellAt(row, 0, null);
                Object cec=tabla.getEditorComponent();
                if(cec instanceof JTextComponent){
                    ((JTextComponent)tabla.getEditorComponent()).requestFocus();
                    ((JTextComponent)tabla.getEditorComponent()).setCaretPosition(0);
                    ((JTextComponent)tabla.getEditorComponent()).selectAll();
                }
                setMessage("Dependencia creada correctamente.");
            } else {
                setMessage("Error creando dependencia.");
            }
        }
    }

    @Action(enabledProperty = "filaSeleccionada")
    public Task borrar() {
        return new BorrarTask(org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class));
    }

    private class BorrarTask extends org.jdesktop.application.Task<ArrayList<Dependencia>, Void> {

        ArrayList<Dependencia> a = null;
        boolean borrar = false;

        BorrarTask(org.jdesktop.application.Application app) {
            super(app);
            a = getObjetosSeleccionados();

            if (a != null) {
                int op = JOptionPane.showConfirmDialog(MaimonidesApp.getApplication().getMainFrame(), "¿Esta seguro de que quiere eliminar las lineas seleccionados (" + a.size() + ")?", "Borrar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                borrar = op == JOptionPane.YES_OPTION;
            }
            firePropertyChange("setIniciado", null, true);
        }

        @Override
        protected ArrayList<Dependencia> doInBackground() {
            //TODO Quizás habría que verificar primero que no se está usando
            if (a != null && borrar) {
                int count = 0;
                for (Dependencia ae : a) {
                    setProgress(++count, 0, a.size());
                    setMessage("Borrando dependencia: " + ae.getNombre() + "...");
                    ae.borrar();
                }
                setMessage("Dependencias borradas correctamente.");
                return a;
            }
            return null;
        }

        @Override
        protected void succeeded(ArrayList<Dependencia> result) {
            if (result != null) {
                firePropertyChange("setTerminado", null, true);
                modelo.quitarDatos(result);
            } else {
                firePropertyChange("setTerminado", null, false);
            }
        }
    }

    public ArrayList<Dependencia> getObjetosSeleccionados() {
        int[] sels = tabla.getSelectedRows();
        ArrayList<Dependencia> arts = new ArrayList<Dependencia>(sels.length);
        for (int pos : sels) {
            if (pos > -1) {
                pos = tabla.convertRowIndexToModel(pos);
                arts.add(modelo.getElemento(pos));
            }
        }
        return arts;
    }
    
    private boolean filaSeleccionada = false;

    public boolean isFilaSeleccionada() {
        return filaSeleccionada;
    }

    public void setFilaSeleccionada(boolean b) {
        boolean old = isFilaSeleccionada();
        this.filaSeleccionada = b;
        firePropertyChange("filaSeleccionada", old, isFilaSeleccionada());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizar;
    private javax.swing.JButton bBorrar;
    private javax.swing.JButton bNuevo;
    private javax.swing.JToolBar barraHerramientas;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTable tabla;
    // End of variables declaration//GEN-END:variables
}