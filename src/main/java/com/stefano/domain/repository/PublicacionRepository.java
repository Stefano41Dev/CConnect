package com.stefano.domain.repository;

import com.stefano.domain.models.Publicacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublicacionRepository extends MongoRepository<Publicacion, String> {

}
