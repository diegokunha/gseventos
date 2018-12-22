package br.com.gseventos.gseventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gseventos.gseventos.models.Evento;
import br.com.gseventos.gseventos.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository er;
	
	public void salvar(Evento evento) {
		er.save(evento);
	}
	
	public void exclui(long id) {
		er.delete(id);
	}
	
	public List<Evento> listaEvento(){
		return (List<Evento>) er.findAll();
	}
	
	public Evento buscaEvento(long id) {
		return er.findOne(id);
	}
	
}
