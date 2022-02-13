package br.com.jefferson.estoque.util;

import br.jefferson.util.Util;
import javax.swing.JTextField;

/**
 *
 * @author 88717
 */
public class Utilidades {

    /**
     * Verifica se todos os campos estão preenchidos
     *
     * @param field campos a serem verificados
     * @return Se todos os campos estão preenchidos
     */
    public static boolean verificaPreenchimento(JTextField... fields) {
        for (JTextField field : fields) {
            if (Util.isNullOrBlank(field)) {
                field.grabFocus();
                return false;
            }
        }
        return true;
    }
}
