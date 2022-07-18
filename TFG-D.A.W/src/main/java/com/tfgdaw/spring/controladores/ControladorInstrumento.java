package com.tfgdaw.spring.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.tfgdaw.spring.modelos.Instrumento;
import com.tfgdaw.spring.servicios.ServicioInstrumento;
import com.tfgdaw.spring.upload.storage.StorageService;

@Controller
public class ControladorInstrumento {

	@Autowired
	private ServicioInstrumento servicioInstrumento;

	@Autowired
	private StorageService storageService;

	private String ficheroEnviado;

	@GetMapping({ "/instrumento" })
	public String listado(Model model) {
		model.addAttribute("listaInstrumento", servicioInstrumento.findAll());
		return "listadoinstrumento";
	}

	@GetMapping("/instrumento/new")
	public String nuevoInstrumentoForm(Model model) {
		model.addAttribute("instrumentoForm", new Instrumento());
		return "form-instrumento";
	}

	@PostMapping("/instrumento/new/submit")
	public String nuevoInstrumentoSubmit(@Valid @ModelAttribute("instrumentoForm") Instrumento nuevoInstrumento,
			BindingResult bindingResult, @RequestParam("file") MultipartFile file) {

		if (bindingResult.hasErrors()) {
			return "form-instrumento";
		} else {
			if (!file.isEmpty()) {
				String imagen = storageService.store(file);
				nuevoInstrumento.setImagen(MvcUriComponentsBuilder
						.fromMethodName(FilesController.class, "serveFile", imagen).build().toUriString());

			}

			servicioInstrumento.add(nuevoInstrumento);
			return "redirect:/instrumento";
		}
	}

	@GetMapping("/instrumento/edit/{id}")
	public String editarInstrumentoForm(@PathVariable long id, Model model) {
		Instrumento instrumento = servicioInstrumento.findById(id);
		if (instrumento != null) {
			ficheroEnviado = instrumento.getImagen(); // para controlar si cambia el fichero
			model.addAttribute("instrumentoForm", instrumento);
			return "form-instrumento";
		} else {
			return "redirect:/instrumento/new";
		}
	}
	
	@PostMapping("/instrumento/edit/submit")
	public String editarInstrumentoPost(@Valid @ModelAttribute("instrumentoForm") Instrumento nuevoInstrumento,
			BindingResult bindingResult, @RequestParam("file") MultipartFile file) {

		System.out.println(ficheroEnviado + ", " + file.getName());
		if (bindingResult.hasErrors()) {			
			return "form-instrumento";	
		} else {			
			if (!file.isEmpty()) {
				String imagen = storageService.store(file);
				nuevoInstrumento.setImagen(MvcUriComponentsBuilder
						.fromMethodName(FilesController.class, "serveFile", imagen).build().toUriString());
				
			}else {
				nuevoInstrumento.setImagen(ficheroEnviado);
			}
			servicioInstrumento.edit(nuevoInstrumento);
			return "redirect:/instrumento";
		}
	}
	
	
    @GetMapping("/instrumento/delete/{id}")
    public String deleteInstrumento(@PathVariable("id") int id){
        servicioInstrumento.deleteInstrumento(id);
        return "redirect:/instrumento";
    }


}
