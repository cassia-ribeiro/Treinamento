package br.com.ultracar.treinamento.restcontroladores;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ultracar.treinamento.entidades.Usuario;
import br.com.ultracar.treinamento.servicos.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	//criar usuario
	@PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario usuario) {
		Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
		return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
	}
	
	//editar usuario
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable(name = "id", required = true) Long idUsuario, @Valid @RequestBody Usuario usuario){
		Usuario usuarioSalvo = usuarioService.findOne(idUsuario);
		BeanUtils.copyProperties(usuario, usuarioSalvo, "id");	
		usuarioService.salvarUsuario(usuarioSalvo);
		return ResponseEntity.ok(usuarioSalvo);
		
	}

/*	@GetMapping
	public List<Usuario> findAll() {
		
		return usuarioService.findAll();
	}	*/
	
	
	@GetMapping
	public Page<Usuario> findAllUsuarioPage(Usuario usuario, Pageable pageable) {
		return usuarioService.findAllUsuarioPage(usuario, pageable);
	}
	//buscar um usuario
/*	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<?> buscarPeloId(@PathVariable(name = "id", required = true) Long idUsuario) {
		Usuario usuario = usuarioService.findOne(idUsuario);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
*/	

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPeloId(@PathVariable Long id) {
		Usuario usuario = usuarioService.findOne(id);
		 return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
	}	

	//deletar um usuario
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)  //Status 204 (Operacao ocorreu com sucesso e nao existe nada para retornar
	public void excluir(@PathVariable(name = "id", required = true) Long idUsuario) {
		Usuario usuario = usuarioService.findOne(idUsuario);
		usuarioService.deletarUsuario(usuario);
	}
	
	
}
