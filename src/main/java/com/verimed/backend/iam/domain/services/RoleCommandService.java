package com.verimed.backend.iam.domain.services;

import com.verimed.backend.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
