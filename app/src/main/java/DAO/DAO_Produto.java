package DAO;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import layout.CE.CE_Produto;

/**
 * Created by dijon on 25/01/2016.
 */
public class DAO_Produto {
    public List<CE_Produto> Obter(CE_Produto objeto) {
        StringBuilder str = new StringBuilder();
        str.append("select * from dual");
        List<CE_Produto> listaProduto = new ArrayList<CE_Produto>();
        return listaProduto;
    }

    public void Inserir(CE_Produto objeto) {
        StringBuilder str = new StringBuilder();
        str.append("insert into tb_produto");
        str.append("(id,nome,preco,descricao,tamanho,vendedor,ativo,tipo)");
        str.append("values(1, 'ARROZ', 4.50, 'ARROZ BLUE VILLE', 'N', 'DB SUPERMERCADOS', 'TRUE', 'C' )");
    }

    public void Alterar(CE_Produto objeto) {
        StringBuilder str = new StringBuilder();
        str.append("UPDATE tb_produto set VALORES ");
        str.append(" WHERE id = " + objeto.getId());

    }

    public void Excluir(CE_Produto objeto) {
        StringBuilder str = new StringBuilder();
        str.append("DELETE FROM tb_produto");
        str.append(" WHERE id = " + objeto.getId());
    }

    public Long ObterSequence() {
        StringBuilder str = new StringBuilder();
        str.append("select sequenceProduto.nextval from dual");

        return Long.parseLong("1");
    }
}
