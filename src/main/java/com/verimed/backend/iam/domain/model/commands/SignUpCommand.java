package com.verimed.backend.iam.domain.model.commands;

import com.verimed.backend.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}
