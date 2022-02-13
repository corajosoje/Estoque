
package br.com.jefferson.estoque.model.util;

/**
 *
 * @author jeffe
 */
public enum Tipo {
    
    ENTRADA, SAIDA;
   
    public String value() {
        return name();
    }

    public static Tipo fromValue(String v) {
        return valueOf(v);
    }
}
