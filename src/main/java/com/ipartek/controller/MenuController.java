package com.ipartek.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.messages.GestorMensajes;
import com.ipartek.model.Producto;
import com.ipartek.repository.InventarioRepository;
import com.ipartek.repository.ProductoRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class MenuController {
	
	@Autowired
	private InventarioRepository inventarioRepo;

	@RequestMapping("/menu_insertar")
	public String menu_insertar() {
		
		return "redirect:/";

	}
	
	@RequestMapping("/menu_mostrar")
	public String menu_mostrar(Model model,HttpSession session) {
	
		GestorMensajes.borrarMensaje(session);

		model.addAttribute("atr_lista_productos", inventarioRepo.findAll());

		return "verProductos";

	}
	
}
