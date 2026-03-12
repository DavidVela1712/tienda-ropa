package com.proyectotiendaropa.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectotiendaropa.model.Buscar;
import com.proyectotiendaropa.model.Imagen;
import com.proyectotiendaropa.model.Marca;
import com.proyectotiendaropa.model.Ropa;
import com.proyectotiendaropa.model.RopaBusqueda;
import com.proyectotiendaropa.model.Usuario;
import com.proyectotiendaropa.resources.RopaRepository;
import com.proyectotiendaropa.service.MarcaService;
import com.proyectotiendaropa.service.RopaService;
import com.proyectotiendaropa.service.UsuarioService;

/**
 * Clase java que administra el controlador del index de la página.
 * 
 * @author David
 *
 */
@Controller
public class Controlador {

	@Autowired
	private BCryptPasswordEncoder passEncoder;

	@Autowired
	private RopaService ropaService;

	@Autowired
	private RopaRepository ropaRepository;

	@Autowired
	private MarcaService marcaService;

	@Autowired
	private UsuarioService usuarioService;

	private List<Integer> carrito = new ArrayList<Integer>();

	private List<Usuario> user = new ArrayList<Usuario>();

	/**
	 * Pre: --- Post: Las peticiones dirigidas a la URL "/" ejecuta el método
	 * operacionDeInicio, en este método ejecuta los select de los valores de la
	 * tabla libro y generos, además crea dos números aleatorios para mostrar 2
	 * ropas distintos aleatoriamente.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String operacionDeInicio(Model model) {
		List<Ropa> ropas = (List<Ropa>) ropaService.findAll();
		List<Imagen> imagen;
		List<RopaBusqueda> busqueda = new ArrayList<RopaBusqueda>();
		List<RopaBusqueda> busqueda2 = new ArrayList<RopaBusqueda>();
		RopaBusqueda ropaB = new RopaBusqueda();
		for (int i = 0; i < ropas.size(); i++) {
			List<String> imagenes = new ArrayList<String>();
			System.out.println(ropas.get(i).getIdRopa() + " - " + ropas.get(i).getIntro() + " - "
					+ ropas.get(i).getDescripcion() + " - " + ropas.get(i).getColor() + " - " + ropas.get(i).getGenero()
					+ " - " + ropas.get(i).getPrecio() + " - " + ropas.get(i).getTalla() + " - "
					+ ropas.get(i).getStock());
			imagen = ropas.get(i).getImagenes();
			for (int j = 0; j < imagen.size(); j++) {
				System.out.println(imagen.get(j).getIdImagen());
				String s = Base64.getEncoder().encodeToString(imagen.get(j).getImagen());
				s = "data:image/png;base64," + s;
				System.out.println(s);
				imagenes.add(s);
			}
			ropaB = new RopaBusqueda(ropas.get(i).getIdRopa(), ropas.get(i).getIntro(), ropas.get(i).getDescripcion(),
					imagenes, ropas.get(i).getPrecio());
			busqueda.add(ropaB);
		}
		for (int i = 0; i < 3; i++) {
			int aux = (int) Math.floor(Math.random() * ((busqueda.size() - 1) - 1 + 1) + 1);
			ropaB = busqueda.get(aux);
			busqueda2.add(ropaB);
			busqueda.remove(aux);
		}
		model.addAttribute("ropas", busqueda2);
		model.addAttribute("carrito", carrito);
		model.addAttribute("p1", "(");
		model.addAttribute("p2", ")");
		model.addAttribute("user", user);
		return "index";
	}

	@GetMapping(value = "/indexCarrito{id}")
	public String carritoCompraIndex(@PathVariable("id") Integer idRopa, Model model) {
		List<Ropa> ropas = (List<Ropa>) ropaService.findAll();
		List<Imagen> imagen;
		List<RopaBusqueda> busqueda = new ArrayList<RopaBusqueda>();
		List<RopaBusqueda> busqueda2 = new ArrayList<RopaBusqueda>();
		RopaBusqueda ropaB = new RopaBusqueda();
		for (int i = 0; i < ropas.size(); i++) {
			List<String> imagenes = new ArrayList<String>();
			System.out.println(ropas.get(i).getIdRopa() + " - " + ropas.get(i).getIntro() + " - "
					+ ropas.get(i).getDescripcion() + " - " + ropas.get(i).getColor() + " - " + ropas.get(i).getGenero()
					+ " - " + ropas.get(i).getPrecio() + " - " + ropas.get(i).getTalla() + " - "
					+ ropas.get(i).getStock());
			imagen = ropas.get(i).getImagenes();
			for (int j = 0; j < imagen.size(); j++) {
				System.out.println(imagen.get(j).getIdImagen());
				String s = Base64.getEncoder().encodeToString(imagen.get(j).getImagen());
				s = "data:image/png;base64," + s;
				System.out.println(s);
				imagenes.add(s);
			}
			ropaB = new RopaBusqueda(ropas.get(i).getIdRopa(), ropas.get(i).getIntro(), ropas.get(i).getDescripcion(),
					imagenes, ropas.get(i).getPrecio());
			busqueda.add(ropaB);
		}
		for (int i = 0; i < 3; i++) {
			int aux = (int) Math.floor(Math.random() * ((busqueda.size() - 1) - 1 + 1) + 1);
			ropaB = busqueda.get(aux);
			busqueda2.add(ropaB);
			busqueda.remove(aux);
		}
		carrito.add(idRopa);
		System.out.println("Carrito");
		for (int i = 0; i < carrito.size(); i++) {
			System.out.println("IdRopa " + carrito.get(i));
		}
		model.addAttribute("ropas", busqueda2);
		model.addAttribute("carrito", carrito);
		model.addAttribute("p1", "(");
		model.addAttribute("p2", ")");
		model.addAttribute("user", user);
		return "index";
	}

	@GetMapping(value = "/buscarCarrito{id}")
	public String carritoCompraBusqueda(@PathVariable("id") Integer idRopa, Model model) {
		List<Ropa> ropas = (List<Ropa>) ropaService.findAll();
		List<Imagen> imagen;
		List<RopaBusqueda> busqueda = new ArrayList<RopaBusqueda>();
		List<RopaBusqueda> busqueda2 = new ArrayList<RopaBusqueda>();
		RopaBusqueda ropaB = new RopaBusqueda();
		for (int i = 0; i < ropas.size(); i++) {
			List<String> imagenes = new ArrayList<String>();
			System.out.println(ropas.get(i).getIdRopa() + " - " + ropas.get(i).getIntro() + " - "
					+ ropas.get(i).getDescripcion() + " - " + ropas.get(i).getColor() + " - " + ropas.get(i).getGenero()
					+ " - " + ropas.get(i).getPrecio() + " - " + ropas.get(i).getTalla() + " - "
					+ ropas.get(i).getStock());
			imagen = ropas.get(i).getImagenes();
			for (int j = 0; j < imagen.size(); j++) {
				System.out.println(imagen.get(j).getIdImagen());
				String s = Base64.getEncoder().encodeToString(imagen.get(j).getImagen());
				s = "data:image/png;base64," + s;
				System.out.println(s);
				imagenes.add(s);
			}
			ropaB = new RopaBusqueda(ropas.get(i).getIdRopa(), ropas.get(i).getIntro(), ropas.get(i).getDescripcion(),
					imagenes, ropas.get(i).getPrecio());
			busqueda.add(ropaB);
		}
		for (int i = 0; i < 3; i++) {
			int aux = (int) Math.floor(Math.random() * ((busqueda.size() - 1) - 1 + 1) + 1);
			ropaB = busqueda.get(aux);
			busqueda2.add(ropaB);
			busqueda.remove(aux);
		}
		carrito.add(idRopa);
		System.out.println("Carrito");
		for (int i = 0; i < carrito.size(); i++) {
			System.out.println("IdRopa " + carrito.get(i));
		}
		model.addAttribute("ropas", busqueda2);
		model.addAttribute("carrito", carrito);
		model.addAttribute("p1", "(");
		model.addAttribute("p2", ")");
		model.addAttribute("user", user);
		return "buscador";
	}

	@GetMapping(value = "/compra")
	public String compra(Model model) {
		List<Imagen> imagen;
		List<RopaBusqueda> busqueda = new ArrayList<RopaBusqueda>();
		List<RopaBusqueda> compra = new ArrayList<RopaBusqueda>();
		RopaBusqueda ropaB = new RopaBusqueda();
		double cont = 0;
		for (int i = 0; i < carrito.size(); i++) {
			int aux = carrito.get(i);
			List<Ropa> ropas = ropaRepository.findById(aux);
			Ropa ropa = ropas.get(0);
			List<String> imagenes = new ArrayList<String>();
			imagen = ropa.getImagenes();
			cont = cont + ropa.getPrecio();
			for (int j = 0; j < imagen.size(); j++) {
				String s = Base64.getEncoder().encodeToString(imagen.get(j).getImagen());
				s = "data:image/png;base64," + s;
				imagenes.add(s);
				ropaB = new RopaBusqueda(ropa.getIdRopa(), ropa.getIntro(),
						ropa.getDescripcion(), ropa.getGenero(), ropa.getTalla(),
						ropa.getColor(), ropa.getPrecio(), ropa.getMarca(), imagenes);
				compra.add(ropaB);
			}
		}
		model.addAttribute("ropas", busqueda);
		model.addAttribute("compras", compra);
		model.addAttribute("carrito", carrito);
		model.addAttribute("p1", "(");
		model.addAttribute("p2", ")");
		model.addAttribute("user", user);
		model.addAttribute("precioFin", cont+"€");
		return "compra";
	}

	@GetMapping(value = "/buscador")
	public String buscador(Model model) {
		List<Ropa> ropas = (List<Ropa>) ropaService.findAll();
		List<Imagen> imagen;
		List<RopaBusqueda> busqueda = new ArrayList<RopaBusqueda>();
		RopaBusqueda ropaB = new RopaBusqueda();
		for (int i = 0; i < ropas.size(); i++) {
			List<String> imagenes = new ArrayList<String>();
			System.out.println(ropas.get(i).getIdRopa() + " - " + ropas.get(i).getIntro() + " - "
					+ ropas.get(i).getDescripcion() + " - " + ropas.get(i).getColor() + " - " + ropas.get(i).getGenero()
					+ " - " + ropas.get(i).getPrecio() + " - " + ropas.get(i).getTalla() + " - "
					+ ropas.get(i).getStock());
			imagen = ropas.get(i).getImagenes();
			for (int j = 0; j < imagen.size(); j++) {
				System.out.println(imagen.get(j).getIdImagen());
				String s = Base64.getEncoder().encodeToString(imagen.get(j).getImagen());
				s = "data:image/png;base64," + s;
				System.out.println(s);
				imagenes.add(s);
			}
			ropaB = new RopaBusqueda(ropas.get(i).getIdRopa(), ropas.get(i).getIntro(), ropas.get(i).getDescripcion(),
					imagenes, ropas.get(i).getPrecio());
			busqueda.add(ropaB);
		}
		model.addAttribute("ropas", busqueda);
		model.addAttribute("carrito", carrito);
		model.addAttribute("p1", "(");
		model.addAttribute("p2", ")");
		model.addAttribute("user", user);
		return "buscador";
	}

	@PostMapping(value = "/buscador")
	public String buscarRopa(@ModelAttribute Buscar ropa, Model model) {
		List<Ropa> ropas;
		List<Imagen> imagen;
		List<RopaBusqueda> busqueda = new ArrayList<RopaBusqueda>();
		System.out.println("Descripción: " + ropa.getDescripcion());
		System.out.println("Género: " + ropa.getGenero());
		System.out.println("Precio: " + ropa.getPrecio());
		if (ropa.getGenero().equals("") && ropa.getPrecio() == 0) {
			ropas = (List<Ropa>) ropaRepository.findByDescripcion(ropa.getDescripcion());
		} else if (ropa.getGenero().equals("H") || ropa.getGenero().equals("M") && ropa.getPrecio() == 0) {
			if (ropa.getGenero().equals("H")) {
				ropas = (List<Ropa>) ropaRepository.findByDescripcion10(ropa.getDescripcion());
			} else {
				ropas = (List<Ropa>) ropaRepository.findByDescripcion20(ropa.getDescripcion());
			}
		} else if (ropa.getGenero().equals("") && ropa.getPrecio() > 0) {
			if (ropa.getPrecio() == 1) {
				ropas = (List<Ropa>) ropaRepository.findByDescripcion01(ropa.getDescripcion());
			} else if (ropa.getPrecio() == 2) {
				ropas = (List<Ropa>) ropaRepository.findByDescripcion02(ropa.getDescripcion());
			} else {
				ropas = (List<Ropa>) ropaRepository.findByDescripcion03(ropa.getDescripcion());
			}
		} else {
			if (ropa.getGenero().equals("H") && ropa.getPrecio() == 1) {
				ropas = (List<Ropa>) ropaRepository.findByDescripcion11(ropa.getDescripcion());
			} else if (ropa.getGenero().equals("H") && ropa.getPrecio() == 2) {
				ropas = (List<Ropa>) ropaRepository.findByDescripcion12(ropa.getDescripcion());
			} else if (ropa.getGenero().equals("H") && ropa.getPrecio() == 3) {
				ropas = (List<Ropa>) ropaRepository.findByDescripcion13(ropa.getDescripcion());
			} else if (ropa.getGenero().equals("M") && ropa.getPrecio() == 1) {
				ropas = (List<Ropa>) ropaRepository.findByDescripcion21(ropa.getDescripcion());
			} else if (ropa.getGenero().equals("M") && ropa.getPrecio() == 2) {
				ropas = (List<Ropa>) ropaRepository.findByDescripcion22(ropa.getDescripcion());
			} else {
				ropas = (List<Ropa>) ropaRepository.findByDescripcion23(ropa.getDescripcion());
			}
		}
		RopaBusqueda ropaB = new RopaBusqueda();
		for (int i = 0; i < ropas.size(); i++) {
			List<String> imagenes = new ArrayList<String>();
			System.out.println(ropas.get(i).getIdRopa() + " - " + ropas.get(i).getIntro() + " - "
					+ ropas.get(i).getDescripcion() + " - " + ropas.get(i).getColor() + " - " + ropas.get(i).getGenero()
					+ " - " + ropas.get(i).getPrecio() + " - " + ropas.get(i).getTalla() + " - "
					+ ropas.get(i).getStock());
			imagen = ropas.get(i).getImagenes();
			for (int j = 0; j < imagen.size(); j++) {
				System.out.println(imagen.get(j).getIdImagen());
				String s = Base64.getEncoder().encodeToString(imagen.get(j).getImagen());
				s = "data:image/png;base64," + s;
				System.out.println(s);
				imagenes.add(s);
			}
			ropaB = new RopaBusqueda(ropas.get(i).getIdRopa(), ropas.get(i).getIntro(), ropas.get(i).getDescripcion(),
					imagenes, ropas.get(i).getPrecio());
			busqueda.add(ropaB);
		}
		model.addAttribute("ropas", busqueda);
		model.addAttribute("carrito", carrito);
		model.addAttribute("p1", "(");
		model.addAttribute("p2", ")");
		model.addAttribute("user", user);
		return "buscador";
	}

	@GetMapping("/generic")
	public String generic(Model model) {
		List<Ropa> ropas = (List<Ropa>) ropaService.findAll();
		List<Marca> marcas = (List<Marca>) marcaService.findAll();
		model.addAttribute("ropas", ropas);
		model.addAttribute("marcas", marcas);
		return "index";
	}

	@GetMapping(value = "/generic{id}")
	public String generic(@PathVariable("id") Integer id, Model model) {
		List<Ropa> ropas = (List<Ropa>) ropaService.findAll();
		List<Marca> marcas = (List<Marca>) marcaService.findAll();
		model.addAttribute("ropas", ropas);
		model.addAttribute("marcas", marcas);
		return "generic";
	}

	@GetMapping("/login")
	public String inicioDeSesion(Model model) {
		List<Ropa> ropas = (List<Ropa>) ropaService.findAll();
		List<Imagen> imagen;
		List<RopaBusqueda> busqueda = new ArrayList<RopaBusqueda>();
		List<RopaBusqueda> busqueda2 = new ArrayList<RopaBusqueda>();
		RopaBusqueda ropaB = new RopaBusqueda();
		for (int i = 0; i < ropas.size(); i++) {
			List<String> imagenes = new ArrayList<String>();
			System.out.println(ropas.get(i).getIdRopa() + " - " + ropas.get(i).getIntro() + " - "
					+ ropas.get(i).getDescripcion() + " - " + ropas.get(i).getColor() + " - " + ropas.get(i).getGenero()
					+ " - " + ropas.get(i).getPrecio() + " - " + ropas.get(i).getTalla() + " - "
					+ ropas.get(i).getStock());
			imagen = ropas.get(i).getImagenes();
			for (int j = 0; j < imagen.size(); j++) {
				System.out.println(imagen.get(j).getIdImagen());
				String s = Base64.getEncoder().encodeToString(imagen.get(j).getImagen());
				s = "data:image/png;base64," + s;
				System.out.println(s);
				imagenes.add(s);
			}
			ropaB = new RopaBusqueda(ropas.get(i).getIdRopa(), ropas.get(i).getIntro(), ropas.get(i).getDescripcion(),
					imagenes, ropas.get(i).getPrecio());
			busqueda.add(ropaB);
		}
		for (int i = 0; i < 3; i++) {
			int aux = (int) Math.floor(Math.random() * ((busqueda.size() - 1) - 1 + 1) + 1);
			ropaB = busqueda.get(aux);
			busqueda2.add(ropaB);
			busqueda.remove(aux);
		}
		model.addAttribute("ropas", busqueda2);
		model.addAttribute("carrito", carrito);
		model.addAttribute("p1", "(");
		model.addAttribute("p2", ")");
		model.addAttribute("user", user);
		return "login";
	}

	@GetMapping("/registro")
	public String registro(Model model) {
		return "registro";
	}

	@PostMapping(value = "/comprobarLogin")
	public String buscarUsuario(@ModelAttribute Usuario usuario, Model model) {
		List<Ropa> ropas = (List<Ropa>) ropaService.findAll();
		List<Imagen> imagen;
		List<RopaBusqueda> busqueda = new ArrayList<RopaBusqueda>();
		List<RopaBusqueda> busqueda2 = new ArrayList<RopaBusqueda>();
		RopaBusqueda ropaB = new RopaBusqueda();
		for (int i = 0; i < ropas.size(); i++) {
			List<String> imagenes = new ArrayList<String>();
			System.out.println(ropas.get(i).getIdRopa() + " - " + ropas.get(i).getIntro() + " - "
					+ ropas.get(i).getDescripcion() + " - " + ropas.get(i).getColor() + " - " + ropas.get(i).getGenero()
					+ " - " + ropas.get(i).getPrecio() + " - " + ropas.get(i).getTalla() + " - "
					+ ropas.get(i).getStock());
			imagen = ropas.get(i).getImagenes();
			for (int j = 0; j < imagen.size(); j++) {
				System.out.println(imagen.get(j).getIdImagen());
				String s = Base64.getEncoder().encodeToString(imagen.get(j).getImagen());
				s = "data:image/png;base64," + s;
				System.out.println(s);
				imagenes.add(s);
			}
			ropaB = new RopaBusqueda(ropas.get(i).getIdRopa(), ropas.get(i).getIntro(), ropas.get(i).getDescripcion(),
					imagenes, ropas.get(i).getPrecio());
			busqueda.add(ropaB);
		}
		for (int i = 0; i < 3; i++) {
			int aux = (int) Math.floor(Math.random() * ((busqueda.size() - 1) - 1 + 1) + 1);
			ropaB = busqueda.get(aux);
			busqueda2.add(ropaB);
			busqueda.remove(aux);
		}
		model.addAttribute("ropas", busqueda2);
		model.addAttribute("carrito", carrito);
		model.addAttribute("p1", "(");
		model.addAttribute("p2", ")");

		List<Usuario> usuarios = (List<Usuario>) usuarioService.findAll();
		Usuario usuario1;
		for (int i = 0; i < usuarios.size(); i++) {
			usuario1 = usuarios.get(i);
			boolean password = passEncoder.matches(usuario.getPassword(), usuario1.getPassword());
			if (usuario1.getCorreo().equals(usuario.getCorreo()) && password) {
				model.addAttribute("usuarios", usuarios);
				user.add(usuario1);
				model.addAttribute("user", user);
				return "index";
			}
		}
		return "login";
	}

	@GetMapping(value = "/cerrarSesion{id}")
	public String cerrarSesion(@PathVariable("id") Integer idUsuario, Model model) {
		List<Ropa> ropas = (List<Ropa>) ropaService.findAll();
		List<Imagen> imagen;
		List<RopaBusqueda> busqueda = new ArrayList<RopaBusqueda>();
		List<RopaBusqueda> busqueda2 = new ArrayList<RopaBusqueda>();
		RopaBusqueda ropaB = new RopaBusqueda();
		for (int i = 0; i < ropas.size(); i++) {
			List<String> imagenes = new ArrayList<String>();
			System.out.println(ropas.get(i).getIdRopa() + " - " + ropas.get(i).getIntro() + " - "
					+ ropas.get(i).getDescripcion() + " - " + ropas.get(i).getColor() + " - " + ropas.get(i).getGenero()
					+ " - " + ropas.get(i).getPrecio() + " - " + ropas.get(i).getTalla() + " - "
					+ ropas.get(i).getStock());
			imagen = ropas.get(i).getImagenes();
			for (int j = 0; j < imagen.size(); j++) {
				System.out.println(imagen.get(j).getIdImagen());
				String s = Base64.getEncoder().encodeToString(imagen.get(j).getImagen());
				s = "data:image/png;base64," + s;
				System.out.println(s);
				imagenes.add(s);
			}
			ropaB = new RopaBusqueda(ropas.get(i).getIdRopa(), ropas.get(i).getIntro(), ropas.get(i).getDescripcion(),
					imagenes, ropas.get(i).getPrecio());
			busqueda.add(ropaB);
		}
		for (int i = 0; i < 3; i++) {
			int aux = (int) Math.floor(Math.random() * ((busqueda.size() - 1) - 1 + 1) + 1);
			ropaB = busqueda.get(aux);
			busqueda2.add(ropaB);
			busqueda.remove(aux);
		}
		model.addAttribute("ropas", busqueda2);
		model.addAttribute("carrito", carrito);
		model.addAttribute("p1", "(");
		model.addAttribute("p2", ")");
		boolean usu = user.isEmpty();
		if (usu == false) {
			user.clear();
		}
		model.addAttribute("user", user);
		return "index";
	}

	@PostMapping("/agregarUsuario")
	public String agregarUsuario(@ModelAttribute Usuario usuario, Model model) {
		List<Usuario> usuarios = (List<Usuario>) usuarioService.findAll();
		Usuario usuario1;
		int pertenencia = 0;
		for (int i = 0; i < usuarios.size(); i++) {
			usuario1 = usuarios.get(i);
			if (usuario1.getCorreo().equals(usuario.getCorreo())) {
				pertenencia = 1;
			}
		}
		String vendedor = "0";
		if (usuario.getVendedor() != null) {
			vendedor = "1";
		}
		Usuario usuario2 = new Usuario(usuario.getNombre(), usuario.getCorreo(),
				passEncoder.encode(usuario.getPassword()), usuario.getCp(), usuario.getTelefono(), vendedor);
		System.out.println(
				usuario.getNombre() + " " + usuario.getCorreo() + " " + passEncoder.encode(usuario.getPassword()) + " "
						+ usuario.getCp() + " " + usuario.getTelefono() + " " + vendedor);
		if (pertenencia == 0) {
			usuarioService.addUsuario(usuario2);
			return "login";
		}
		System.out.println("usuarios size = " + usuarios.size());
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println(usuarios.get(i).getIdUsuario() + " - " + usuarios.get(i).getNombre() + " - "
					+ usuarios.get(i).getCorreo() + " - " + usuarios.get(i).getPassword() + " - "
					+ usuarios.get(i).getCp() + " - " + usuarios.get(i).getTelefono() + " - "
					+ usuarios.get(i).getVendedor());
		}
		model.addAttribute("usuarios", usuarios);
		return "registro";
	}
}
