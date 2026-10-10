package com.examenT2.LP2_T2_Hartmann_Patricio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.LP2_T2_Hartmann_Patricio.model.OrdenCompraHartmannPatricio;
import com.examenT2.LP2_T2_Hartmann_Patricio.service.OrdenCompraService;
import com.examenT2.LP2_T2_Hartmann_Patricio.service.ProveedorService;
import com.examenT2.LP2_T2_Hartmann_Patricio.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("ordenCompra")
@RequiredArgsConstructor
public class OrdenCompraController {

	private final OrdenCompraService ordenCompraService;
	private final ProveedorService proveedorService;

	@GetMapping({"", "/", "listado", "listadoHartmannPatricio"})
	public String listado(Model model) {
		model.addAttribute("lstOrdenes", ordenCompraService.getAll());
		return "listadoHartmannPatricio";
	}

	@GetMapping({"nuevo", "nuevoHartmannPatricio"})
	public String nuevo(Model model) {
		model.addAttribute("lstProveedores", proveedorService.getAll());
		model.addAttribute("ordenCompra", new OrdenCompraHartmannPatricio());
		return "nuevoHartmannPatricio";
	}

	@PostMapping("registrar")
	public String registrar(@ModelAttribute OrdenCompraHartmannPatricio ordenCompra, RedirectAttributes flash) {
		var response = ordenCompraService.create(ordenCompra);

		var alert = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("alert", alert);
		return "redirect:/ordenCompra/listado";
	}

	@GetMapping({"edicion/{id}", "edicionHartmannPatricio/{id}"})
	public String edicion(@PathVariable Integer id, Model model) {
		model.addAttribute("lstProveedores", proveedorService.getAll());
		model.addAttribute("ordenCompra", ordenCompraService.getOne(id));
		return "edicionHartmannPatricio";
	}

	@PostMapping("guardar")
	public String guardar(@ModelAttribute OrdenCompraHartmannPatricio ordenCompra, RedirectAttributes flash) {
		var response = ordenCompraService.update(ordenCompra);

		var alert = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("alert", alert);
		return "redirect:/ordenCompra/listado";
	}

}
