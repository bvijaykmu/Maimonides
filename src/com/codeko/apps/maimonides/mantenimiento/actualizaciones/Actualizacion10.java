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


package com.codeko.apps.maimonides.mantenimiento.actualizaciones;

import com.codeko.apps.maimonides.mantenimiento.Actualizacion;

/**
 *
 * @author codeko
 */
public class Actualizacion10 extends Actualizacion {

    @Override
    public String getDescripcion() {
        return "Control de las lineas de faltas";
    }

    @Override
    public boolean necesitaConfirmacion() {
        return false;
    }

    @Override
    public boolean ejecutar() {
        boolean ret = true;
        if (!existeCampo("estado", "partes_alumnos")) {
            ret = ret & ejecutarSQL("ALTER TABLE `partes_alumnos` ADD COLUMN `estado` INT(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '0=No hay cambios, 1=Enviado' AFTER `posicion`");
        }
        ret = ret & ejecutarSQL("CREATE TRIGGER actualizar_estado_lineas_faltas BEFORE UPDATE ON partes_alumnos " +
                " FOR EACH ROW BEGIN " +
                " IF OLD.estado = 0 THEN " +
                " SET NEW.estado=1; " +
                " END IF; " +
                " END ");
        return ret;
    }
}
