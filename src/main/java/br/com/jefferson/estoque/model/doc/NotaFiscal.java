package br.com.jefferson.estoque.model.doc;

import br.com.jefferson.estoque.model.reg.Cliente;
import br.com.jefferson.estoque.model.doc.item.Itens;
import br.com.jefferson.estoque.model.Persistable;
import br.com.jefferson.estoque.model.Registros;
import br.com.jefferson.estoque.model.reg.Terceiro;
import br.com.jefferson.estoque.model.util.Tipo;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jeffe
 */
@Entity
public class NotaFiscal implements Registros, Serializable, Persistable {

    @Id
    private String chave;

    @Temporal(TemporalType.DATE)
    private LocalDate dataMovimento;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @OneToOne
    private Terceiro terceiro;

    @OneToMany
    private List<Itens> itens;

    @OneToOne
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    @Override
    public LocalDate getDataMovimento() {
        return dataMovimento;
    }

    public void setData(LocalDate dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    @Override
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public Terceiro getTerceiro() {
        return terceiro;
    }

    public void setTerceiro(Terceiro terceiro) {
        this.terceiro = terceiro;
    }

    @Override
    public List<Itens> getItens() {
        return itens;
    }

    public void setItens(List<Itens> itens) {
        this.itens = itens;
    }

}
