package com.verimed.backend.iam.interfaces.rest.transform;

import com.verimed.backend.iam.domain.model.entities.Role;
import com.verimed.backend.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
