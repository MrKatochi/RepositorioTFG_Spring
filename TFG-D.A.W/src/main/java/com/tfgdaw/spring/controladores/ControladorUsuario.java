package com.tfgdaw.spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.tfgdaw.spring.servicios.ServicioUsuarios;
import com.tfgdaw.spring.upload.storage.StorageService;
import com.tfgdaw.spring.modelos.Usuario;

@Controller
public class ControladorUsuario {
	
	@Autowired
	ServicioUsuarios servicioUsuarios;
	@Autowired
	StorageService storageService;

	@GetMapping({ "/" })
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/auth/login")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}

	@PostMapping("/auth/register")
	public String register(@ModelAttribute Usuario usuario, @RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			String imagen = storageService.store(file);
			usuario.setAvatar(MvcUriComponentsBuilder.fromMethodName(FilesController.class, "serveFile", imagen).build()
					.toUriString());
		}
		servicioUsuarios.registrar(usuario);
		return "redirect:/index";
	}
	

}
