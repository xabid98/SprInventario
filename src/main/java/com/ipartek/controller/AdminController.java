package com.ipartek.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.messages.GestorMensajes;
import com.ipartek.model.Inventario;
import com.ipartek.model.Producto;
import com.ipartek.repository.InventarioRepository;
import com.ipartek.repository.ProductoRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@Autowired
	private InventarioRepository inventarioRepo;

	@Autowired
	private ProductoRepository productoRepo;

	@RequestMapping("/borrarProducto/{id}")
	public String borrarProducto(@PathVariable int id, Model model, HttpSession session) {

		inventarioRepo.deleteById(id);
		model.addAttribute("atr_lista_productos", inventarioRepo.findAll());

		GestorMensajes.ponerMensaje(2, session);
		
	    return "verProductos";
	}

	@RequestMapping("/seleccionarProducto/{id}")
	public String seleccionarProducto(@PathVariable int id, Model model) {

		Optional<Inventario> inventario = inventarioRepo.findById(id);
		List<Producto> listaProducto = productoRepo.findAll();

		model.addAttribute("atr_inventario", inventario);
		model.addAttribute("atr_lista_productos", listaProducto);

		return "formModificar";
	}
	
	@RequestMapping("/modificarProducto")
	public String modificarProducto(@ModelAttribute Inventario atr_inventario,HttpSession session, Model model) {
		
		inventarioRepo.save(atr_inventario);
		model.addAttribute("atr_lista_productos", inventarioRepo.findAll());

		GestorMensajes.ponerMensaje(3, session);

		return "verProductos";
	}
	
	

	
}
