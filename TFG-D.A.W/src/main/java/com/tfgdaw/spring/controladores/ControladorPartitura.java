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

import com.tfgdaw.spring.modelos.Partitura;
import com.tfgdaw.spring.servicios.ServicioInstrumento;
import com.tfgdaw.spring.servicios.ServicioPartitura;
import com.tfgdaw.spring.upload.storage.StorageService;

@Controller
public class ControladorPartitura {

	@Autowired
	private ServicioPartitura servicioPartitura;
	
	@Autowired
	private ServicioInstrumento servicioInstrumento;

	@Autowired
	private StorageService storageService;

	private String ficheroEnviado;

	@GetMapping({ "/partitura" })
	public String listado(Model model) {
		model.addAttribute("listapartitura", servicioPartitura.findAll());
		return "listadopartitura";
	}

	@GetMapping("/partitura/new")
	public String nuevoPartituraForm(Model model) {
		model.addAttribute("partituraForm", new Partitura());
		model.addAttribute("listainstrumento", servicioInstrumento.findAll());
		return "form-partitura";
	}

	@PostMapping("/partitura/new/submit")
	public String nuevoPartituraSubmit(@Valid @ModelAttribute("partituraForm") Partitura nuevoPartitura,
			BindingResult bindingResult, @RequestParam("file") MultipartFile file) {

		if (bindingResult.hasErrors()) {
			return "form-partitura";
		} else {
			if (!file.isEmpty()) {
				String archivo = storageService.store(file);
				nuevoPartitura.setArchivo(MvcUriComponentsBuilder
						.fromMethodName(FilesController.class, "serveFile", archivo).build().toUriString());

			}

			servicioPartitura.add(nuevoPartitura);
			return "redirect:/partitura";
		}
	}
	
	//Revisar

	@GetMapping("/partitura/edit/{id}")
	public String editarPartituraForm(@PathVariable long id, Model model) {
		Partitura partitura = servicioPartitura.findById(id);
		if (partitura != null) {
			ficheroEnviado = partitura.getArchivo(); // para controlar si cambia el fichero
			model.addAttribute("instrumentoForm", partitura);
			model.addAttribute("listainstrumento", servicioInstrumento.findAll());
			return "partitura";
		} else {
			return "redirect:/partitura/new";
		}
	}
	
	@PostMapping("/partitura/edit/submit")
	public String editarPartituraPost(@Valid @ModelAttribute("partituraForm") Partitura nuevoPartitura,
			BindingResult bindingResult, @RequestParam("file") MultipartFile file) {

		System.out.println(ficheroEnviado + ", " + file.getName());
		if (bindingResult.hasErrors()) {			
			return "form-instrumento";	
		} else {			
			if (!file.isEmpty()) {
				String archivo = storageService.store(file);
				nuevoPartitura.setArchivo(MvcUriComponentsBuilder
						.fromMethodName(FilesController.class, "serveFile", archivo).build().toUriString());
				
			}else {
				nuevoPartitura.setArchivo(ficheroEnviado);
			}
			servicioPartitura.edit(nuevoPartitura);
			return "redirect:/partitura";
		}
	}
	
	//------------------------------------------
	
    @GetMapping("/partitura/delete/{id}")
    public String deletePartitura(@PathVariable("id") int id){
        servicioPartitura.deletePartitura(id);
        return "redirect:/partitura";
    }
    
    
    //Vistas para el pdf
    @GetMapping("/partitura/view/{id}")
	public String viewPartitura(@PathVariable("id") int id, Model model) {
		model.addAttribute("partitura", servicioPartitura.findById(id));
		return "view-partitura";
	}
    
    
    //https://stackoverflow.com/questions/51299893/how-to-show-pdf-file-using-spring-web-application
    //https://stackoverflow.com/questions/40928344/spring-mvc-display-a-pdf-file-into-web-browser
    /*
    @GetMapping(value = "/pdf")
    public void showPDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        //response.setHeader("Content-Disposition", "attachment; filename=\"demo.pdf\"");
        InputStream inputStream = new FileInputStream(new File(rootLocation + "/Manjaro-User-Guide.pdf"));
        int nRead;
        while ((nRead = inputStream.read()) != -1) {
            response.getWriter().write(nRead);
        }
    } 
    */
    
    
}
