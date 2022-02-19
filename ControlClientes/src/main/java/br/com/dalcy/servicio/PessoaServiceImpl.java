package br.com.dalcy.servicio;

import br.com.dalcy.dao.PessoaDao;
import br.com.dalcy.domain.Pessoa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dalcimar
 */
@Service
public class PessoaServiceImpl implements PessoaService {
    
    @Autowired
    private PessoaDao pessoaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pessoa> listarPessoas() {
        return (List<Pessoa>) pessoaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Pessoa pessoa) {
        pessoaDao.save(pessoa);
    }

    @Override
    @Transactional
    public void eliminar(Pessoa pessoa) {
        pessoaDao.delete(pessoa);
    }

    @Override
    @Transactional(readOnly = true)
    public Pessoa encontrarPessoa(Pessoa pessoa) {
        return pessoaDao.findById(pessoa.getIdPessoa()).orElse(null);
    }

}
