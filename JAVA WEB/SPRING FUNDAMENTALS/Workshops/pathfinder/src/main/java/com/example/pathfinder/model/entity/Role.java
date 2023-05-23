package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.RoleNameEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "roles")
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoleNameEnum role;

    public Role() {
    }

    public RoleNameEnum getRole() {
        return role;
    }

    public Role setRole(RoleNameEnum role) {
        this.role = role;
        return this;
    }
}
