package br.com.jefferson.estoque.model;

import br.com.jefferson.estoque.model.util.Tipo;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jeffe
 */
public interface Registros {


    public LocalDate getDataMovimento();

    public Tipo getTipo();

    public Terceiro getTerceiro();

    public List<Itens> getItens();
}
