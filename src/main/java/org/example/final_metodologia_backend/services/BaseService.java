package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.Base;
import org.example.final_metodologia_backend.repositories.BaseRepository;

import java.io.Serializable;

public abstract class BaseService<E extends Base, ID extends Serializable> {
    protected BaseRepository<E, ID> baseRepository;

    public BaseService(BaseRepository<E, ID> baseRepository) {this.baseRepository=baseRepository;}
}
