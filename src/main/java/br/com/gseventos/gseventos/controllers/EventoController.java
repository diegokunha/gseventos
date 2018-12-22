package br.com.gseventos.gseventos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gseventos.gseventos.models.Evento;
import br.com.gseventos.gseventos.services.EventoService;

@Controller
public class EventoController {

	@Autowired
	private EventoService es;
	
	@GetMapping("/formEvento")
	public ModelAndView formEvento(Evento evento) {
		ModelAndView mv = new ModelAndView("views/evento/eventoForm");
		mv.addObject("evento", evento);
		return mv;
	}
	
	@GetMapping("/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("views/evento/listaEvento");
		mv.addObject("evento", es.listaEvento());
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluiEvento(@PathVariable("id") long id) {
		es.exclui(id);
		
		return listaEventos();
	}
	
	@GetMapping("/editaEvento/{id}")
	public ModelAndView editaEvento(@PathVariable ("id") long id) {
		return formEvento(es.buscaEvento(id));
	}
	
	@PostMapping("/salvaEvento")
	public ModelAndView salvaEvento(@Valid Evento evento, BindingResult rs, RedirectAttributes att) {
		
		if(rs.hasErrors()) {
			att.addFlashAttribute("mensagem", "Favor preencher campos obrigatórios");
			formEvento(evento);
		}
		
		es.salvar(evento);
		att.addFlashAttribute("mensagem", "Evento incluído com sucesso");
		
		return listaEventos();
	}
	
}
