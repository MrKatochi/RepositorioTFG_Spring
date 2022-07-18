package com.tfgdaw.spring.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.tfgdaw.spring.modelos.Obra;
import com.tfgdaw.spring.servicios.ServicioObra;
import com.tfgdaw.spring.upload.storage.StorageService;

@Controller
public class ControladorObra {
	@Autowired
	private ServicioObra servicioObra;
	

	@Autowired
	private StorageService storageService;

	//private String ficheroEnviado;

	@GetMapping({ "/obra" })
	public String listado(Model model) {
		model.addAttribute("listaobra", servicioObra.findAll());
		return "listadoobra";
	}

	@GetMapping("/obra/new")
	public String nuevoObraForm(Model model) {
		model.addAttribute("obraForm", new Obra());
		model.addAttribute("listaobra", servicioObra.findAll());
		return "form-obra";
	}

	@PostMapping("/obra/new/submit")
	public String nuevoObraSubmit(@Valid @ModelAttribute("obraForm") Obra nuevoObra,
			BindingResult bindingResult, @RequestParam("file") MultipartFile file) {

		if (bindingResult.hasErrors()) {
			return "form-obra";
		} else {
			if (!file.isEmpty()) {
				String audio = storageService.store(file);
				nuevoObra.setAudio(MvcUriComponentsBuilder
						.fromMethodName(FilesController.class, "serveFile", audio).build().toUriString());

			}

			servicioObra.add(nuevoObra);
			return "redirect:/obra";
		}
	}
}
