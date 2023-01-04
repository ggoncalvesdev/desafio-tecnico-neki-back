package com.neki.api.openapi.controller;

import com.neki.api.model.SkillModel;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.hateoas.PagedModel;

/* @Api(tags = "Skills") */
public interface SkillControllerOpenApi {
  PagedModel<SkillModel> listar(Pageable pageable);
}
