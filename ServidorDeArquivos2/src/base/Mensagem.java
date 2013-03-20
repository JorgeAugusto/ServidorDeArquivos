/**
 * Classe que modela uma requisição
 * @author: Jorge Augusto C. dos Reis
 * @data..: 20/03/2013 às 13:39
 * @Descrição:
 */

package base;

import java.io.Serializable;

public class Mensagem implements Serializable {
    // Enum Interna
    public enum TipoMensagem {
        LISTA_ARQUIVOS, UPLOAD, DOWNLOAD, DELETAR, ESTADO;
    }

    private TipoMensagem    tipoRequisicao;
    private Object          infoRequisicao;

    public  Mensagem(TipoMensagem  tipoRequisicao, Object infoRequisicao) {
        set(tipoRequisicao, infoRequisicao);
    }

    public final void set(TipoMensagem  tipoRequisicao, Object infoRequisicao) {
        this.tipoRequisicao = tipoRequisicao;
        this.infoRequisicao = infoRequisicao;
    }

    public TipoMensagem getTipoMensagem() {
        return tipoRequisicao;
    }

    public Object getInfoRequisicao() {
        return infoRequisicao;
    }
}
