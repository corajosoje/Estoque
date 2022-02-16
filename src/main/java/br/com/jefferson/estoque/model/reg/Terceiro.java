package br.com.jefferson.estoque.model.reg;

import br.com.jefferson.estoque.model.Persistable;
import br.jefferson.exeptions.DaoException;
import br.jefferson.util.Util;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Regstro de terceito
 *
 * @author jeffe
 */
@Entity
public class Terceiro implements Serializable, Persistable {

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

    @Override
    public void validade() throws DaoException {
        if (Util.isNullOrBlank(getNome())) {
            throw new DaoException("Campo Nome do Terceiro é obrigatório");
        }
        if (Util.isNullOrBlank(getCpf_cnpj())) {
            throw new DaoException("Campo CNPJ-CPF do Terceiro é obrigatório");
        }
    }

}
