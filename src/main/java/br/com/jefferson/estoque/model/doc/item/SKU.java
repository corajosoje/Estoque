
package br.com.jefferson.estoque.model.doc.item;

import br.com.jefferson.estoque.model.Persistable;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author jeffe
 */
@Entity
public class SKU implements Serializable ,Persistable{
    
    @Id
    private String codigo;
            
    private String descricao;

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
    
    
}
