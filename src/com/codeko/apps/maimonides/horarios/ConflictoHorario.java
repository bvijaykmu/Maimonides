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


package com.codeko.apps.maimonides.horarios;

import com.codeko.apps.maimonides.elementos.Horario;
import com.codeko.swing.CdkAutoTablaCol;
import java.util.ArrayList;

/**
 * Copyright Codeko Informática 2008
 * www.codeko.com
 * @author Codeko
 */
public class ConflictoHorario {
    @CdkAutoTablaCol(ignorar=true)
    public static final int NO_HAY_ALUMNOS = 1;
    @CdkAutoTablaCol(ignorar=true)
    public static final int SOLAPADO_PROFESOR = 2;
    @CdkAutoTablaCol(ignorar=true)
    public static final int SOLAPADO_AULA = 3;
    @CdkAutoTablaCol(ignorar=true)
    public static final int SOLAPADO_ALUMNO = 4;
    int tipo = 0;
    String nombre = "";
    String descripcion = "";
    @CdkAutoTablaCol(editable=0,titulo="Horarios")
    ArrayList<Horario> horarios = new ArrayList<Horario>();
    @CdkAutoTablaCol(ignorar=true)
    Horario horario = null;

    public ConflictoHorario(Horario horario, int tipo, String nombre, String descripcion) {
        setHorario(horario);
        setTipo(tipo);
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public Horario getHorario() {
        return horario;
    }

    public final void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public final void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public final void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public final void setTipo(int tipo) {
        this.tipo = tipo;
    }


    public ArrayList<Horario> getHorarios() {
        return horarios;
    }
}
