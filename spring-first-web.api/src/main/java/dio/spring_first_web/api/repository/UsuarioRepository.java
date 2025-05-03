package dio.spring_first_web.api.repository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dio.spring_first_web.api.model.Usuario;

@Repository
public class UsuarioRepository {

    public void save(Usuario usuario){
        if(usuario.getLogin()==null){
            throw new BusinessException("O campo login é obrigatorio");
        }
        if(usuario.getId()==null){
            System.out.println("Save - Recebendo Usuario na camada de repositório");
        }
        else{
            System.out.println("Update - Recebendo Usuario na camada de repositório");
        }

        System.out.println(usuario);
    }

    public void deleteById(Integer id){
        System.out.println(String.format("Delete/id - Recebendo o id: %d para excluir um Usuario",id));
        System.out.println(id);
    }

    public List<Usuario> findAll(){
        System.out.println("LIST - Listando os usuarios do sistema");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("gleyson", "password"));
        usuarios.add(new Usuario("frank", "masterpass"));
        return usuarios;
    }

    public Usuario findById(Integer id){
        System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar um Usuario",id));
        return new Usuario("gleyson", "password");
    }

    public Usuario findByUserName(String username){
        System.out.println(String.format("FIND/username - Recebendo o username: %s para ",username));
        return new Usuario("gleyson","password");
    }
}
