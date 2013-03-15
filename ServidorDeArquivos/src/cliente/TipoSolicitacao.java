/**
 * Enum que lista os tipos de solicitações que o cliente pode fazer...
 * @author Jorge Augusto C. dos Reis
 * Descrição:
 * Esta classe modela a Janela do Servidor Principal
 */

package cliente;

import java.io.Serializable;

public enum TipoSolicitacao implements Serializable {
    LISTAGEM_ARQUIVOS, UPLOAD, DOWNLOAD, DELETAR;
}
