package br.com.gseventos.gseventos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gseventos.gseventos.models.Evento;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Long>{

}
