package br.com.jefferson.estoque.model;

import br.com.jefferson.estoque.model.doc.IdDoc;
import br.com.jefferson.estoque.model.doc.item.Itens;
import br.com.jefferson.estoque.model.reg.Cliente;
import br.com.jefferson.estoque.model.util.Tipo;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jeffe
 */
public interface Registros {

    public Cliente getCliente();

    public LocalDate getDataMovimento();

    public Tipo getTipo();

    public IdDoc getIdDoc();

    public List<Itens> getItens();
}
