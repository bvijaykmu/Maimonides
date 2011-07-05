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


package com.codeko.apps.maimonides.alumnos;

import com.codeko.apps.maimonides.MaimonidesApp;
import com.codeko.apps.maimonides.cartero.SMS;
import com.codeko.apps.maimonides.conf.mail.ConfiguracionMail;
import com.codeko.util.Num;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;


public class PanelEnvioSMSVoz extends javax.swing.JPanel {

    String numeroSMS = "";
    ConfiguracionMail conf = new ConfiguracionMail("VOZ");

    public PanelEnvioSMSVoz() {
        initComponents();
        setNumeroSMS("");
        recalcular();
        taTexto.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                recalcular();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                recalcular();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                recalcular();
            }
        });
    }

    private boolean recalcular() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class).getContext().getResourceMap(PanelEnvioSMSVoz.class);
        int restantes = getMaxCaracteres() - taTexto.getText().length();
        lCaracteres.setText(resourceMap.getString("lCaracteres.text", restantes)); // NOI18N
        return restantes > 0;
    }

    public String getNumeroSMS() {
        return numeroSMS;
    }

    public final void setNumeroSMS(String numeroSMS) {
        this.numeroSMS = numeroSMS;
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class).getContext().getResourceMap(PanelEnvioSMSVoz.class);
        lTitulo.setText(resourceMap.getString("lTitulo.text", numeroSMS)); // NOI18N
        setNumeroValido(Num.esNumero(numeroSMS));
    }

    public int getMaxCaracteres() {
        return conf.getMaximoCaracteres();
    }

    @Action(block = Task.BlockingScope.ACTION, enabledProperty = "numeroValido")
    public Task enviar() {
        return new EnviarTask(org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class));
    }

    private class EnviarTask extends org.jdesktop.application.Task<Boolean, Void> {

        EnviarTask(org.jdesktop.application.Application app) {
            super(app);
            setMessage("Enviando SMS a " + getNumeroSMS());
        }

        @Override
        protected Boolean doInBackground() {
            setMessage("Enviando SMS a " + getNumeroSMS());
            boolean ret = SMS.enviarSMS(getNumeroSMS(), taTexto.getText(), true);
            if (ret) {
                setMessage("SMS enviado correctamente");
            }
            return ret;
        }

        @Override
        protected void succeeded(Boolean result) {
            if (result) {
                JOptionPane.showMessageDialog(MaimonidesApp.getMaimonidesView().getFrame(), "SMS enviado correctamente", "SMS Enviado correctamente", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(MaimonidesApp.getMaimonidesView().getFrame(), "Error enviando SMS", "Error enviando SMS", JOptionPane.ERROR_MESSAGE);
            }
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

        lTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taTexto = new javax.swing.JTextArea();
        lCaracteres = new javax.swing.JLabel();
        bEnviar = new javax.swing.JButton();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class).getContext().getResourceMap(PanelEnvioSMSVoz.class);
        lTitulo.setText(resourceMap.getString("lTitulo.text")); // NOI18N
        lTitulo.setName("lTitulo"); // NOI18N

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        taTexto.setColumns(20);
        taTexto.setLineWrap(true);
        taTexto.setRows(5);
        taTexto.setWrapStyleWord(true);
        taTexto.setName("taTexto"); // NOI18N
        jScrollPane1.setViewportView(taTexto);

        lCaracteres.setText(resourceMap.getString("lCaracteres.text")); // NOI18N
        lCaracteres.setName("lCaracteres"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class).getContext().getActionMap(PanelEnvioSMSVoz.class, this);
        bEnviar.setAction(actionMap.get("enviar")); // NOI18N
        bEnviar.setText(resourceMap.getString("bEnviar.text")); // NOI18N
        bEnviar.setName("bEnviar"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lCaracteres, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bEnviar))
                    .addComponent(lTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bEnviar)
                    .addComponent(lCaracteres)))
        );
    }// </editor-fold>//GEN-END:initComponents
    private boolean numeroValido = false;

    public boolean isNumeroValido() {
        return numeroValido;
    }

    public void setNumeroValido(boolean b) {
        boolean old = isNumeroValido();
        this.numeroValido = b;
        firePropertyChange("numeroValido", old, isNumeroValido());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lCaracteres;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JTextArea taTexto;
    // End of variables declaration//GEN-END:variables
}
