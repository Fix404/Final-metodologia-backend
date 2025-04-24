package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.Base;
import org.example.final_metodologia_backend.services.BaseService;

import java.io.Serializable;

public abstract class BaseController<E extends Base, ID extends Serializable> {
    protected BaseService<E, ID> service;

    public BaseController(BaseService<E, ID> service) {this.service=service;}
}
