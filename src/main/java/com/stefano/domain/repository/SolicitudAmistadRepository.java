package com.stefano.domain.repository;

import com.stefano.domain.models.SolicitudAmistad;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SolicitudAmistadRepository extends MongoRepository<SolicitudAmistad, String> {
}
