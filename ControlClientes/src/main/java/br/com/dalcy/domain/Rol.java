package br.com.dalcy.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Dalcimar
 */
@Entity
@Data
@Table(name="rol")
public class Rol implements Serializable {
   private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idRol;
   
   @NotEmpty
   private String nome;

}
