package br.com.jefferson.estoque.model.reg;

import br.com.jefferson.estoque.model.Persistable;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Registro do Cliente do Sistema
 *
 * @author jeffe
 */
@Entity
public class Cliente implements Serializable, Persistable {

    @Id
    private String cpf_cnpj;

    private String nome;

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}