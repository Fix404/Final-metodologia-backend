package org.example.final_metodologia_backend.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serializable;

@Data
@MappedSuperclass
public abstract class Base implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;
}
