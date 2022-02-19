package br.com.dalcy.dao;

import br.com.dalcy.domain.Pessoa;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Dalcimar
 */
public interface PessoaDao extends CrudRepository<Pessoa, Long> {

    
}
