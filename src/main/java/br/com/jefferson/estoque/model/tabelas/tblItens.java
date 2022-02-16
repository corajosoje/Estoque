package br.com.jefferson.estoque.model.tabelas;//.tblItens

import br.com.jefferson.estoque.model.doc.item.Itens;
import br.jefferson.table.TableDao;
import java.util.List;

/**
 *
 * @author 88717
 */
public class tblItens extends TableDao<Itens> {

    private final String[] colunas = {"Numero", "SKU", "Quantidade", "Custo", "Recuperaveis"};

    public tblItens(List<Itens> dados) {
        super.dados = dados;
        super.colunas = this.colunas;
    }

    public tblItens() {
        super.colunas = this.colunas;
    }

    @Override //{"Numero", "Serie", "Emissão", "Terceiro", "Data Entrada", "Chave", "Classificada"}
    public Object getValueAt(int rowIndex, int columnIndex) {
        Itens variavel = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return variavel.getNumero();
            case 1:
                return variavel.getSku().getCodigo();
            case 2:
                return variavel.getQuantidade();
            case 3:
                return variavel.getCusto();
            case 4:
                return variavel.getIcms()
                        + variavel.getCofins()
                        + variavel.getIpi()
                        + variavel.getPis()
                        + variavel.getSt();
        }
        return null;
    }

}
