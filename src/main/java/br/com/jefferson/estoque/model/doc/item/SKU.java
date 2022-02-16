package br.com.jefferson.estoque.model.doc.item;

import br.com.jefferson.estoque.model.Persistable;
import br.jefferson.exeptions.DaoException;
import br.jefferson.util.Util;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author jeffe
 */
@Entity
public class SKU implements Serializable, Persistable {

    @Id
    private String codigo;

    private String descricao;

    @Column(length = 8)
    private String ncm;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    @Override
    public void validade() throws DaoException {
        if (Util.isNullOrBlank(getCodigo())) {
            throw new DaoException("Campo Código é obrigatório");
        }
        if (Util.isNullOrBlank(getDescricao())) {
            throw new DaoException("Campo descrição é obrigatório");
        }
        if (!Util.isNullOrBlank(getNcm())) {
            if(ncm.length()!=8){
                throw new DaoException("Campo NCM deve conter 8 digitos");
            }
            for (char c : getNcm().toCharArray()) {
                if (Character.isDigit(c)) {
                    throw new DaoException("Campo NCM só pode conter numeros");
                }
                
            }

        }
    }
}
