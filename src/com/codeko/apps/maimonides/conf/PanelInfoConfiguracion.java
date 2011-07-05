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
 * PanelInfoConfiguracion.java
 *
 * Created on 18-may-2011, 12:22:56
 */
package com.codeko.apps.maimonides.conf;

import com.codeko.apps.maimonides.Configuracion;
import com.codeko.apps.maimonides.ICargable;
import com.codeko.apps.maimonides.MaimonidesApp;
import com.codeko.apps.maimonides.MaimonidesUtil;
import com.codeko.apps.maimonides.conf.mail.ConfiguracionMail;
import com.codeko.swing.CdkProcesoLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Box;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;
import org.jdesktop.swingx.JXHyperlink;

/**
 *
 * @author codeko
 */
public class PanelInfoConfiguracion extends javax.swing.JPanel implements ICargable {

    boolean cargado = false;

    /** Creates new form PanelInfoConfiguracion */
    public PanelInfoConfiguracion() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
    }// </editor-fold>//GEN-END:initComponents

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        cargar();
    }//GEN-LAST:event_formAncestorAdded

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void cargar() {
        if (!isCargado()) {
            actualizarDatos();
            setCargado(true);
        }
    }

    @Override
    public void vaciar() {
        setCargado(false);
    }

    @Override
    public boolean isCargado() {
        return cargado;
    }

    @Override
    public void setCargado(boolean cargado) {
        this.cargado = cargado;
    }

    public void actualizarDatos() {
        MaimonidesUtil.ejecutarTask(this, "actualizar");
    }

    @Action(block = Task.BlockingScope.ACTION)
    public Task actualizar() {
        return new ActualizarTask(org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class));
    }

    private class ActualizarTask extends org.jdesktop.application.Task<ArrayList<Component>, Void> {

        ArrayList<Component> comps = new ArrayList<Component>();

        ActualizarTask(org.jdesktop.application.Application app) {
            super(app);
            removeAll();
            CdkProcesoLabel cpl = new CdkProcesoLabel();
            cpl.setText("Verificando datos de configuración...");
            cpl.setProcesando(true);
            add(cpl);
        }

        @Override
        protected ArrayList<Component> doInBackground() {
            firePropertyChange("message", null, "Verificando datos de configuración...");
            Configuracion cfg = MaimonidesApp.getApplication().getConfiguracion();
            if (cfg.get("codigo_centro", "").equals("") || cfg.get("nombre_centro", "").equals("") || cfg.get("email_centro", "").equals("")) {
                JXHyperlink l = getLink("No estan definidos todos los datos del centro", "Haga clic para acceder a la configuración de datos del centro.", "mostrarPanelConfiguracion");
                comps.add(l);
            }
            //Verificamos que haya configuracion para envios de email
            if (!ConfiguracionMail.isConfigurado("EMAIL")) {
                JXHyperlink l = getLink("No esta configurado el envío de correos electrónicos", "Haga clic para acceder a la configuración de email.", "mostrarPanelConfiguracion");
                comps.add(l);
            }
            return comps;
        }

        private JXHyperlink getLink(String msg, String tooltip, final String command) {
            JXHyperlink l = new JXHyperlink();
            l.setForeground(Color.RED);
            l.setClickedColor(Color.RED);
            l.setUnclickedColor(Color.RED);
            l.setFont(l.getFont().deriveFont(Font.BOLD));
            l.setIcon(null);
            l.setText(msg);
            AbstractAction a = new AbstractAction() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    MaimonidesUtil.ejecutarTask(MaimonidesApp.getMaimonidesView(), command);
                }
            };
            a.putValue(AbstractAction.SHORT_DESCRIPTION, l.getText());
            a.putValue(AbstractAction.LONG_DESCRIPTION, l.getText());
            a.putValue(AbstractAction.NAME, l.getText());
            a.putValue(AbstractAction.SMALL_ICON, MaimonidesUtil.getActionTask(MaimonidesApp.getMaimonidesView(), command).getValue(AbstractAction.SMALL_ICON));
            l.setAction(a);
            l.setToolTipText(tooltip);
            return l;
        }

        @Override
        protected void succeeded(ArrayList<Component> result) {
            removeAll();
            for (Component c : result) {
                add(c);
                add(Box.createRigidArea(new Dimension(10, 6)));
            }
            updateUI();
        }
    }
}
