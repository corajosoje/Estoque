package br.com.jefferson.estoque.model.doc;

import br.com.jefferson.estoque.model.Persistable;
import br.com.jefferson.estoque.model.reg.Terceiro;
import br.jefferson.exeptions.DaoException;
import br.jefferson.util.Util;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author 88717
 */
@Embeddable
public class IdDoc implements Serializable, Persistable {

    private Integer numero;

    @ManyToOne
    private Terceiro terceiro;

    @Column(length = 3)
    private String Serie;

    public Integer getId() {
        return numero;
    }

    public void setId(Integer numero) {
        this.numero = numero;
    }

    public Terceiro getTerceiro() {
        return terceiro;
    }

    public void setTerceiro(Terceiro terceiro) {
        this.terceiro = terceiro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.numero);
        hash = 43 * hash + Objects.hashCode(this.terceiro);
        hash = 43 * hash + Objects.hashCode(this.Serie);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IdDoc other = (IdDoc) obj;
        if (!Objects.equals(this.Serie, other.Serie)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.terceiro, other.terceiro)) {
            return false;
        }
        return true;
    }

    @Override
    public void validade() throws DaoException {
        if (Util.isNullOrBlank(getSerie())) {
            throw new DaoException("Campo Série é obrigatório");
        }
        if (getSerie().length() > 3) {
            throw new DaoException("Campo Série pode ter no maximo 3 caracteres");
        }
        if (getNumero() == null || getNumero() == 0) {
            throw new DaoException("Campo Número é obrigatório");
        }

        if (getTerceiro() == null) {
            throw new DaoException("Não foi atribuido um terceiro ao Documento");
        } else {
            getTerceiro().validade();
        }
    }

}
