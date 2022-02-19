
package br.com.dalcy.servicio;

import br.com.dalcy.domain.Pessoa;
import java.util.List;

/**
 *
 * @author Dalcimar
 */
public interface PessoaService {
  
    List<Pessoa> listarPessoas();
    
    void guardar(Pessoa pessoa);
    
    void eliminar(Pessoa pessoa);
    
    Pessoa encontrarPessoa(Pessoa pessoa);
}
