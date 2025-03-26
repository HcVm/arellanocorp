package com.acorporation.app.dto;

import java.util.Set;

public class ActualizarRolDTO {
    private Set<Integer> permisos;

    public ActualizarRolDTO() {
    }

    public ActualizarRolDTO(Set<Integer> permisos) {
        this.permisos = permisos;
    }

    public Set<Integer> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<Integer> permisos) {
        this.permisos = permisos;
    }
}
