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
 * PanelAlertasTutor.java
 *
 * Created on 17-jul-2010, 19:19:46
 */
package com.codeko.apps.maimonides.inicio;

import com.codeko.apps.maimonides.ICargable;
import com.codeko.apps.maimonides.MaimonidesApp;
import com.codeko.apps.maimonides.MaimonidesInputBlocker;
import com.codeko.apps.maimonides.MaimonidesUtil;
import com.codeko.apps.maimonides.asistencia.escolaridad.DatoPerdidaEscolaridadGlobal;
import com.codeko.apps.maimonides.asistencia.escolaridad.DatoPerdidaEscolaridadPorMaterias;
import com.codeko.apps.maimonides.elementos.Alumno;
import com.codeko.apps.maimonides.elementos.Profesor;
import com.codeko.apps.maimonides.elementos.Unidad;
import com.codeko.apps.maimonides.notificaciones.EnviarNotificacionesPerdidaEvaluacionContinuaGlobalTask;
import com.codeko.apps.maimonides.notificaciones.EnviarNotificacionesPerdidaEvaluacionContinuaMateriasTask;
import com.codeko.apps.maimonides.partes.cartas.DatoCartaPerdidaEscolaridadPorMaterias;
import com.codeko.apps.maimonides.usr.Usuario;
import com.codeko.swing.CdkProcesoLabel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;
import org.jdesktop.application.TaskEvent;
import org.jdesktop.application.TaskListener;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXHyperlink;

/**
 *
 * @author codeko
 */
public class PanelAlertasPerdidaEscolaridad extends javax.swing.JPanel implements ICargable {

    final org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class).getContext().getResourceMap(PanelAlertasPerdidaEscolaridad.class);
    PanelAlertasPerdidaEscolaridad auto = this;
    boolean cargado = false;
    TaskListener<Boolean, java.lang.Void> tl = new TaskListener<Boolean, java.lang.Void>() {

        @Override
        public void doInBackground(TaskEvent event) {
        }

        @Override
        public void process(TaskEvent event) {
        }

        @Override
        public void succeeded(TaskEvent event) {
        }

        @Override
        public void failed(TaskEvent event) {
        }

        @Override
        public void cancelled(TaskEvent event) {
        }

        @Override
        public void interrupted(TaskEvent event) {
        }

        @Override
        public void finished(TaskEvent event) {
            actualizarDatos();
        }
    };

    /** Creates new form PanelAlertasTutor */
    public PanelAlertasPerdidaEscolaridad() {
        initComponents();
    }

    private JXHyperlink getBotonOcultar(final JXCollapsiblePane panel, String texto) {
        final JXHyperlink boton = new JXHyperlink();
        boton.setIcon(resourceMap.getIcon("bOcultar.icon")); // NOI18N
        boton.setText(texto); // NOI18N
        boton.setToolTipText("Haga clic para mostrar/ocultar los detalles"); // NOI18N
        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setCollapsed(!panel.isCollapsed());
                if (panel.isCollapsed()) {
                    boton.setIcon(resourceMap.getIcon("bOcultar.icon"));
                } else {
                    boton.setIcon(resourceMap.getIcon("bOcultar.down.icon"));
                }
            }
        });
        boton.setAlignmentX(Component.LEFT_ALIGNMENT);
        return boton;
    }

    private JXCollapsiblePane getPanelDatos() {
        JXCollapsiblePane panelDatos = new org.jdesktop.swingx.JXCollapsiblePane();
        panelDatos.setCollapsed(true);
        panelDatos.getContentPane().setLayout(new javax.swing.BoxLayout(panelDatos.getContentPane(), javax.swing.BoxLayout.Y_AXIS));
        panelDatos.setAlignmentX(Component.LEFT_ALIGNMENT);
        return panelDatos;
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

    @Action(block = Task.BlockingScope.ACTION)
    public Task actualizar() {
        return new ActualizarTask(org.jdesktop.application.Application.getInstance(com.codeko.apps.maimonides.MaimonidesApp.class));
    }

    class ActualizarTask extends org.jdesktop.application.Task<ArrayList<Component>, Void> {

        ActualizarTask(org.jdesktop.application.Application app) {
            super(app);
            removeAll();
            CdkProcesoLabel cpl = new CdkProcesoLabel();
            cpl.setText("Verificando alertas de tutor...");
            cpl.setProcesando(true);
            add(cpl);
        }

        @Override
        protected ArrayList<Component> doInBackground() {
            ArrayList<Component> comps = new ArrayList<Component>();
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
                //Alumnos que van a perder la escolaridad por materias
                cargarPerdidaEvaluacionContinuaMaterias(comps, unidad);
                //Alumnos que van a perder la escolaridad global
                cargarPerdidaEvaluacionContinuaGlobal(comps, unidad);
            }
            return comps;
        }

        private void cargarPerdidaEvaluacionContinuaMaterias(ArrayList<Component> comps, Unidad unidad) {
            comps.add(new JLabel("<html><h3>Pérdidas de evaluación continua en alguna materia</h3>"));
            //Recupermos todos aquellos que van a perder la escolaridad
            ArrayList<DatoPerdidaEscolaridadPorMaterias> todos = DatoPerdidaEscolaridadPorMaterias.getDatosPerdidaEscolaridad(80, null, unidad, null, new GregorianCalendar());
            if (todos.isEmpty()) {
                comps.add(new JLabel("<html><b><font color='#009900'>No hay pérdidas de evaluación continua en materias</font></b>"));
            } else {
                final ArrayList<DatoPerdidaEscolaridadPorMaterias> noNotificados = new ArrayList<DatoPerdidaEscolaridadPorMaterias>();
                ArrayList<DatoPerdidaEscolaridadPorMaterias> casiPerdida = new ArrayList<DatoPerdidaEscolaridadPorMaterias>();
                ArrayList<DatoPerdidaEscolaridadPorMaterias> notificados = new ArrayList<DatoPerdidaEscolaridadPorMaterias>();
                for (DatoPerdidaEscolaridadPorMaterias d : todos) {
                    if (!d.isNotificado()) {
                        if (d.getPorcentaje() >= 100) {
                            noNotificados.add(d);
                        } else {
                            casiPerdida.add(d);
                        }
                    } else {
                        notificados.add(d);
                    }
                }
                if (!casiPerdida.isEmpty()) {
                    JXCollapsiblePane panelDatos = getPanelDatos();
                    comps.add(getBotonOcultar(panelDatos, "<html><h4><font color='#FF8000'>Cercanos a perderla (<b>" + casiPerdida.size() + "</b>)</font></h4>"));
                    comps.add(panelDatos);
                    final ArrayList<DatoPerdidaEscolaridadPorMaterias> datos = new ArrayList<DatoPerdidaEscolaridadPorMaterias>();
                    Alumno ultimoAlumno = null;
                    for (DatoPerdidaEscolaridadPorMaterias d : casiPerdida) {
                        if (!d.getAlumno().equals(ultimoAlumno)) {
                            if (datos.size() > 0) {
                                addLineaGenericaMaterias(panelDatos, datos);
                            }
                            datos.clear();
                            ultimoAlumno = d.getAlumno();
                        }
                        datos.add(d);
                    }
                }
                if (!noNotificados.isEmpty()) {
                    JXCollapsiblePane panelDatos = getPanelDatos();
                    FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
                    fl.setHgap(0);
                    fl.setVgap(0);
                    JPanel panelBoton = new JPanel(fl);
                    panelBoton.setAlignmentX(Component.LEFT_ALIGNMENT);
                    comps.add(panelBoton);
                    panelBoton.add(getBotonOcultar(panelDatos, "<html><h4><font color='#FF0000'>No notificados (<b>" + noNotificados.size() + "</b>)</font></h4>"));
                    panelBoton.add(Box.createRigidArea(new Dimension(10, 6)));
                    comps.add(panelDatos);
                    final ArrayList<DatoPerdidaEscolaridadPorMaterias> datos = new ArrayList<DatoPerdidaEscolaridadPorMaterias>();
                    Alumno ultimoAlumno = null;
                    for (DatoPerdidaEscolaridadPorMaterias d : noNotificados) {
                        if (!d.getAlumno().equals(ultimoAlumno)) {
                            if (datos.size() > 0) {
                                addLineaNotificacionMaterias(panelDatos, datos);
                            }
                            datos.clear();
                            ultimoAlumno = d.getAlumno();
                        }
                        datos.add(d);
                    }
                    if (datos.size() > 0) {
                        addLineaNotificacionMaterias(panelDatos, datos);
                    }
                    JXHyperlink l = new JXHyperlink();
                    l.setText("Notificar todos");
                    AbstractAction a = new AbstractAction() {

                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            int op = JOptionPane.showConfirmDialog(MaimonidesApp.getApplication().getMainFrame(), "Se van ha enviar las notificaciones de pérdida de evaluación continua.\n¿Enviar notificaciones?", "Confirmación de envío de notificaciones", JOptionPane.YES_NO_OPTION);
                            if (op == JOptionPane.YES_OPTION) {
                                EnviarNotificacionesPerdidaEvaluacionContinuaMateriasTask t = new EnviarNotificacionesPerdidaEvaluacionContinuaMateriasTask(MaimonidesApp.getApplication(), new GregorianCalendar(), unirDatosCarta(noNotificados));
                                t.setInputBlocker(new MaimonidesInputBlocker(t, Task.BlockingScope.APPLICATION, MaimonidesApp.getApplication().getMainFrame(), null));
                                t.addTaskListener(tl);
                                MaimonidesApp.getApplication().getContext().getTaskService().execute(t);
                            }
                        }
                    };
                    a.putValue(AbstractAction.SHORT_DESCRIPTION, l.getText());
                    a.putValue(AbstractAction.LONG_DESCRIPTION, l.getText());
                    a.putValue(AbstractAction.NAME, l.getText());
                    l.setAction(a);
                    l.setIcon(MaimonidesApp.getApplication().getContext().getResourceMap(auto.getClass()).getIcon("notificacionPerdidaEvaluacionContinuaGlobal.icon"));
                    l.setToolTipText("Haga clic para notificar las pérdidas de evalución continua.");
                    panelBoton.add(l);
                }
                if (!notificados.isEmpty()) {
                    JXCollapsiblePane panelDatos = getPanelDatos();
                    comps.add(getBotonOcultar(panelDatos, "<html><h4>Notificados (<b>" + notificados.size() + "</b>)</h4>"));
                    comps.add(panelDatos);
                    final ArrayList<DatoPerdidaEscolaridadPorMaterias> datos = new ArrayList<DatoPerdidaEscolaridadPorMaterias>();
                    Alumno ultimoAlumno = null;
                    for (DatoPerdidaEscolaridadPorMaterias d : notificados) {
                        if (!d.getAlumno().equals(ultimoAlumno)) {
                            if (datos.size() > 0) {
                                addLineaGenericaMaterias(panelDatos, datos);
                            }
                            datos.clear();
                            ultimoAlumno = d.getAlumno();
                        }
                        datos.add(d);
                    }
                }
            }
        }

        private void cargarPerdidaEvaluacionContinuaGlobal(ArrayList<Component> comps, Unidad unidad) {
            //Alumnos que van a perder la escolaridad global
            comps.add(new JLabel("<html><h3>Pérdidas de evaluación continua global</h3>"));
            //Recupermos todos aquellos que van a perder la escolaridad
            ArrayList<DatoPerdidaEscolaridadGlobal> todos = DatoPerdidaEscolaridadGlobal.getDatosPerdidaEscolaridad(80, null, unidad, null, new GregorianCalendar());
            if (todos.isEmpty()) {
                comps.add(new JLabel("<html><b><font color='#009900'>No hay pérdidas de evaluación continua global</font></b>"));
            } else {
                final ArrayList<DatoPerdidaEscolaridadGlobal> noNotificados = new ArrayList<DatoPerdidaEscolaridadGlobal>();
                ArrayList<DatoPerdidaEscolaridadGlobal> casiPerdida = new ArrayList<DatoPerdidaEscolaridadGlobal>();
                ArrayList<DatoPerdidaEscolaridadGlobal> notificados = new ArrayList<DatoPerdidaEscolaridadGlobal>();
                for (DatoPerdidaEscolaridadGlobal d : todos) {
                    if (!d.isNotificado()) {
                        if (d.getPorcentaje() >= 100) {
                            noNotificados.add(d);
                        } else {
                            casiPerdida.add(d);
                        }
                    } else {
                        notificados.add(d);
                    }
                }
                if (!casiPerdida.isEmpty()) {
                    JXCollapsiblePane panelDatos = getPanelDatos();
                    comps.add(getBotonOcultar(panelDatos, "<html><h4><font color='#FF8000'>Cercanos a perderla (<b>" + casiPerdida.size() + "</b>)</font></h4>"));
                    comps.add(panelDatos);
                    for (DatoPerdidaEscolaridadGlobal d : casiPerdida) {
                        JXHyperlink l = new JXHyperlink();
                        l.setText("<html><b>" + d.getAlumno() + "</b> (" + d.getFaltas() + "/" + d.getMaxFaltas() + "-" + d.getPorcentaje() + "%)");
                        l.putClientProperty("alumno", d.getAlumno());
                        l.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MaimonidesApp.getMaimonidesView().mostrarFichaAlumno((Alumno) ((JXHyperlink) e.getSource()).getClientProperty("alumno"));
                            }
                        });
                        panelDatos.add(l);
                    }
                }
                if (!noNotificados.isEmpty()) {
                    JXCollapsiblePane panelDatos = getPanelDatos();
                    FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
                    fl.setHgap(0);
                    fl.setVgap(0);
                    JPanel panelBoton = new JPanel(fl);
                    panelBoton.setAlignmentX(Component.LEFT_ALIGNMENT);
                    comps.add(panelBoton);
                    panelBoton.add(getBotonOcultar(panelDatos, "<html><h4><font color='#FF0000'>No notificados (<b>" + noNotificados.size() + "</b>)</font></h4>"));
                    panelBoton.add(Box.createRigidArea(new Dimension(10, 6)));
                    comps.add(panelDatos);
                    for (DatoPerdidaEscolaridadGlobal d : noNotificados) {
                        final ArrayList<DatoPerdidaEscolaridadGlobal> datos = new ArrayList<DatoPerdidaEscolaridadGlobal>();
                        datos.add(d);
                        JXHyperlink l = new JXHyperlink();
                        l.setText("<html><b>" + d.getAlumno() + "</b> (" + d.getFaltas() + "/" + d.getMaxFaltas() + ")");
                        l.putClientProperty("alumno", d.getAlumno());
                        l.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MaimonidesApp.getMaimonidesView().mostrarFichaAlumno((Alumno) ((JXHyperlink) e.getSource()).getClientProperty("alumno"));
                            }
                        });
                        JXHyperlink lNot = new JXHyperlink();
                        lNot.setText("Notificar");
                        AbstractAction a = new AbstractAction() {

                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                int op = JOptionPane.showConfirmDialog(MaimonidesApp.getApplication().getMainFrame(), "Se va ha enviar la notificación de pérdida de evaluación continua a " + datos.get(0).getAlumno() + "\n¿Enviar notificación?", "Confirmación de envío de notificación", JOptionPane.YES_NO_OPTION);
                                if (op == JOptionPane.YES_OPTION) {
                                    EnviarNotificacionesPerdidaEvaluacionContinuaGlobalTask t = new EnviarNotificacionesPerdidaEvaluacionContinuaGlobalTask(MaimonidesApp.getApplication(), new GregorianCalendar(), datos);
                                    t.setInputBlocker(new MaimonidesInputBlocker(t, Task.BlockingScope.APPLICATION, MaimonidesApp.getApplication().getMainFrame(), null));
                                    t.addTaskListener(tl);
                                    MaimonidesApp.getApplication().getContext().getTaskService().execute(t);
                                }
                            }
                        };
                        a.putValue(AbstractAction.SHORT_DESCRIPTION, lNot.getText());
                        a.putValue(AbstractAction.LONG_DESCRIPTION, lNot.getText());
                        a.putValue(AbstractAction.NAME, lNot.getText());
                        lNot.setAction(a);
                        lNot.setIcon(MaimonidesApp.getApplication().getContext().getResourceMap(auto.getClass()).getIcon("notificacionPerdidaEvaluacionContinuaGlobal.icon"));
                        lNot.setToolTipText("Haga clic para notificar la pérdida de evaluación continua global.");
                        panelDatos.add(getPanelBotonDoble(l, lNot));
                    }
                    JXHyperlink l = new JXHyperlink();
                    l.setText("Notificar todos");
                    AbstractAction a = new AbstractAction() {

                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            int op = JOptionPane.showConfirmDialog(MaimonidesApp.getApplication().getMainFrame(), "Se van ha enviar las notificaciones de pérdida de evaluación continua.\n¿Enviar notificaciones?", "Confirmación de envío de notificaciones", JOptionPane.YES_NO_OPTION);
                            if (op == JOptionPane.YES_OPTION) {
                                EnviarNotificacionesPerdidaEvaluacionContinuaGlobalTask t = new EnviarNotificacionesPerdidaEvaluacionContinuaGlobalTask(MaimonidesApp.getApplication(), new GregorianCalendar(), noNotificados);
                                t.setInputBlocker(new MaimonidesInputBlocker(t, Task.BlockingScope.APPLICATION, MaimonidesApp.getApplication().getMainFrame(), null));
                                t.addTaskListener(tl);
                                MaimonidesApp.getApplication().getContext().getTaskService().execute(t);
                            }
                        }
                    };
                    a.putValue(AbstractAction.SHORT_DESCRIPTION, l.getText());
                    a.putValue(AbstractAction.LONG_DESCRIPTION, l.getText());
                    a.putValue(AbstractAction.NAME, l.getText());
                    l.setAction(a);
                    l.setIcon(MaimonidesApp.getApplication().getContext().getResourceMap(auto.getClass()).getIcon("notificacionPerdidaEvaluacionContinuaGlobal.icon"));
                    l.setToolTipText("Haga clic para notificar las perdidas de evaluación continua global.");
                    panelBoton.add(l);
                }
                if (!notificados.isEmpty()) {
                    JXCollapsiblePane panelDatos = getPanelDatos();
                    comps.add(getBotonOcultar(panelDatos, "<html><h4>Notificados (<b>" + notificados.size() + "</b>)</font></h4>"));
                    comps.add(panelDatos);
                    for (DatoPerdidaEscolaridadGlobal d : notificados) {
                        JXHyperlink l = new JXHyperlink();
                        l.setText("<html><b>" + d.getAlumno() + "</b> (" + d.getFaltas() + "/" + d.getMaxFaltas() + ")");
                        l.putClientProperty("alumno", d.getAlumno());
                        l.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MaimonidesApp.getMaimonidesView().mostrarFichaAlumno((Alumno) ((JXHyperlink) e.getSource()).getClientProperty("alumno"));
                            }
                        });
                        panelDatos.add(l);
                    }
                }
            }
        }

        @Override
        protected void succeeded(ArrayList<Component> result) {
            removeAll();
            for (Component c : result) {
                add(c);
                Component comp = Box.createRigidArea(new Dimension(10, 0));
                add(comp);
            }
            updateUI();
        }
    }

    private ArrayList<DatoCartaPerdidaEscolaridadPorMaterias> unirDatosCarta(ArrayList<DatoPerdidaEscolaridadPorMaterias> todos) {
        ArrayList<DatoCartaPerdidaEscolaridadPorMaterias> datos = new ArrayList<DatoCartaPerdidaEscolaridadPorMaterias>();
        //Tenemos que unir todos los datos segun el alumno
        for (DatoPerdidaEscolaridadPorMaterias d1 : todos) {
            //vemos si ya existe el alumno
            DatoCartaPerdidaEscolaridadPorMaterias d2 = null;
            for (DatoCartaPerdidaEscolaridadPorMaterias d : datos) {
                if (d.getAlumno().equals(d1.getAlumno())) {
                    d2 = d;
                    break;
                }
            }
            if (d2 == null) {
                d2 = new DatoCartaPerdidaEscolaridadPorMaterias(d1.getAlumno());
                datos.add(d2);
            }
            d2.addDato(d1);
        }
        return datos;
    }

    private void addLineaGenericaMaterias(JPanel panelDatos, final ArrayList<DatoPerdidaEscolaridadPorMaterias> datos) {
        JXHyperlink l = new JXHyperlink();
        l.setText("<html><b>" + datos.get(0).getAlumno() + "</b>: ");// + );
        l.putClientProperty("alumno", datos.get(0).getAlumno());
        l.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MaimonidesApp.getMaimonidesView().mostrarFichaAlumno((Alumno) ((JXHyperlink) e.getSource()).getClientProperty("alumno"));
            }
        });
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
        fl.setHgap(0);
        fl.setVgap(0);
        JPanel panelBotonLinea = new JPanel(fl);
        panelBotonLinea.add(l);
        panelDatos.add(panelBotonLinea);
        for (DatoPerdidaEscolaridadPorMaterias d : datos) {
            JLabel li = new JLabel("     " + d.getMateria() + " (" + d.getFaltas() + "/" + d.getMaxFaltas() + "-" + d.getPorcentaje() + "%)");
            li.setAlignmentX(Component.LEFT_ALIGNMENT);
            fl = new FlowLayout(FlowLayout.LEFT);
            fl.setHgap(0);
            fl.setVgap(0);
            panelBotonLinea = new JPanel(fl);
            panelBotonLinea.add(li);
            panelDatos.add(panelBotonLinea);
        }
    }

    private void addLineaNotificacionMaterias(JPanel panelDatos, final ArrayList<DatoPerdidaEscolaridadPorMaterias> datos) {
        JXHyperlink l = new JXHyperlink();
        l.setText("<html><b>" + datos.get(0).getAlumno() + "</b>: ");
        l.putClientProperty("alumno", datos.get(0).getAlumno());
        l.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MaimonidesApp.getMaimonidesView().mostrarFichaAlumno((Alumno) ((JXHyperlink) e.getSource()).getClientProperty("alumno"));
            }
        });
        JXHyperlink lNot = new JXHyperlink();
        lNot.setText("Notificar");
        AbstractAction a = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int op = JOptionPane.showConfirmDialog(MaimonidesApp.getApplication().getMainFrame(), "Se va ha enviar la notificación de pérdida de evaluación continua a " + datos.get(0).getAlumno() + "\n¿Enviar notificación?", "Confirmación de envío de notificación", JOptionPane.YES_NO_OPTION);
                if (op == JOptionPane.YES_OPTION) {
                    EnviarNotificacionesPerdidaEvaluacionContinuaMateriasTask t = new EnviarNotificacionesPerdidaEvaluacionContinuaMateriasTask(MaimonidesApp.getApplication(), new GregorianCalendar(), unirDatosCarta(datos));
                    t.setInputBlocker(new MaimonidesInputBlocker(t, Task.BlockingScope.APPLICATION, MaimonidesApp.getApplication().getMainFrame(), null));
                    t.addTaskListener(tl);
                    MaimonidesApp.getApplication().getContext().getTaskService().execute(t);
                }
            }
        };
        a.putValue(AbstractAction.SHORT_DESCRIPTION, lNot.getText());
        a.putValue(AbstractAction.LONG_DESCRIPTION, lNot.getText());
        a.putValue(AbstractAction.NAME, lNot.getText());
        lNot.setAction(a);
        lNot.setIcon(MaimonidesApp.getApplication().getContext().getResourceMap(auto.getClass()).getIcon("notificacionPerdidaEvaluacionContinuaGlobal.icon"));
        lNot.setToolTipText("Haga clic para notificar la pérdida de evaluación continua.");
        panelDatos.add(getPanelBotonDoble(l, lNot));
        for (DatoPerdidaEscolaridadPorMaterias d : datos) {
            JLabel li = new JLabel("     " + d.getMateria() + " (" + d.getFaltas() + "/" + d.getMaxFaltas() + ")");
            li.setAlignmentX(Component.LEFT_ALIGNMENT);
            FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
            fl.setHgap(0);
            fl.setVgap(0);
            JPanel panelBotonLinea = new JPanel(fl);
            panelBotonLinea.add(li);
            panelDatos.add(panelBotonLinea);
        }
    }

    private JPanel getPanelBotonDoble(JXHyperlink boton1, JXHyperlink boton2) {
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
        fl.setHgap(0);
        fl.setVgap(0);
        JPanel panelBotonLinea = new JPanel(fl);
        panelBotonLinea.add(boton1);
        panelBotonLinea.add(Box.createRigidArea(new Dimension(10, 6)));
        panelBotonLinea.add(boton2);
        return panelBotonLinea;
    }

    @Override
    public void cargar() {
        if (!isCargado()) {
            actualizarDatos();
            setCargado(true);
        }
    }

    public void actualizarDatos() {
        MaimonidesUtil.ejecutarTask(this, "actualizar");
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
