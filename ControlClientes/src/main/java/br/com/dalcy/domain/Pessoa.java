package br.com.dalcy.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author Dalcimar
 */
@Data
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;
    
    @NotEmpty
    private String nome;
    
    @NotEmpty
    private String apelido;
    
    @NotEmpty
    @Email
    private String email;
    
    private String telefone;
    
    @NotNull
    private Double saldo;
}
