package com.verimed.backend.iam.domain.model.queries;

import com.acme.center.platform.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}
