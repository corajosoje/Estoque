package br.com.jefferson.estoque.model.doc.item;

import br.com.jefferson.estoque.model.Persistable;
import br.com.jefferson.estoque.model.Registros;
import br.jefferson.exeptions.DaoException;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author jeffe
 */
@Entity
public class Itens implements Serializable, Persistable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numero;

    @ManyToOne
    private SKU sku;

    private Double quantidade;
    private Double icms;
    private Double ipi;
    private Double st;
    private Double pis;
    private Double cofins;
    private Double custo;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public SKU getSku() {
        return sku;
    }

    public void setSku(SKU sku) {
        this.sku = sku;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getIcms() {
        return icms;
    }

    public void setIcms(Double icms) {
        this.icms = icms;
    }

    public Double getIpi() {
        return ipi;
    }

    public void setIpi(Double ipi) {
        this.ipi = ipi;
    }

    public Double getSt() {
        return st;
    }

    public void setSt(Double st) {
        this.st = st;
    }

    public Double getPis() {
        return pis;
    }

    public void setPis(Double pis) {
        this.pis = pis;
    }

    public Double getCofins() {
        return cofins;
    }

    public void setCofins(Double cofins) {
        this.cofins = cofins;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    @Override
    public void validade() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
