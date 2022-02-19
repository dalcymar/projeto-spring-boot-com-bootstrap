package br.com.dalcy.web;


import br.com.dalcy.domain.Pessoa;
import br.com.dalcy.servicio.PessoaService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <p>Slf4l</p> é uma anotação do Lombok
 * 
 * @author Dalcimar
 */
@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PessoaService pessoaService;
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        
        var pessoas = pessoaService.listarPessoas();
        
        log.info("execuntando o controlador Spring MVC");
        log.info("usuario que fez login: " + user);
        model.addAttribute("pessoas", pessoas);
        var saldoTotal = 0D;
        for(var p: pessoas) {
            saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", pessoas.size());
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Pessoa pessoa) {
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Pessoa pessoa, Errors errores) {
        if(errores.hasErrors()) {
            return "modificar";
        }
        pessoaService.guardar(pessoa);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPessoa}")
    public String editar(Pessoa pessoa, Model model) {
        pessoa = pessoaService.encontrarPessoa(pessoa);
        model.addAttribute("pessoa", pessoa);
        return "modificar";
    }
    
    //@GetMapping("/eliminar/{idPessoa}")
    @GetMapping("/eliminar")
    public String eliminar(Pessoa pessoa) {
        pessoaService.eliminar(pessoa);
        return "redirect:/";
    }
}
