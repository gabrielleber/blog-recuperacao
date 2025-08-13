package Controllers;

import Entities.Usuario;
import Repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    public UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @PostMapping

    public Usuario criarUsuario(@RequestBody Usuario usuario){
        this.usuarioRepository.save(usuario);
        return usuario;
    }

    @GetMapping

    public List<Usuario> listar(){
        return this.usuarioRepository.findAll();
    }


    @GetMapping

    public List<Usuario> exibirDetalhes(){
        return this.usuarioRepository.findById(Usuario);
    }


    @PutMapping("/{idUsuario}")
    public Usuario atualizarUsuario(
            @PathVariable Integer idUsuario,
            @RequestBody Usuario atualizar
    ){

        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        usuario.setNome(atualizar.getNome());
        usuario.setDataCadastro(atualizar.getEmail());


        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{idUsuario}")
    public Usuario DeletarUsuario(
            @PathVariable Integer idUsuario
    ){
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        usuarioRepository.delete(usuario);
        return usuario;
    }



}
