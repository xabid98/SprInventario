package com.ipartek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.messages.GestorMensajes;
import com.ipartek.model.Inventario;
import com.ipartek.repository.InventarioRepository;
import com.ipartek.repository.ProductoRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class InventarioController {

	@Autowired
	private InventarioRepository inventarioRepo;
	@Autowired
	private ProductoRepository productoRepo;
	
	@RequestMapping("/actualizar_cantidad")
	 public String menuInventario(@ModelAttribute Inventario objeto_entidad, 
	  Model model, HttpSession session) {

	  inventarioRepo.save(objeto_entidad);
	  
	  GestorMensajes.ponerMensaje(1, session);
	  
	  model.addAttribute("atr_lista_productos", productoRepo.findAll());
	  model.addAttribute("objeto_entidad", new Inventario());

	  return "insertarProductos";
	 }

}
