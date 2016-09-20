package BO;

import java.util.List;

import DAO.DAO_Produto;
import layout.CE.CE_Produto;

/**
 * Created by dijon on 25/01/2016.
 */
public class BO_Produto {
    public DAO_Produto daoProduto = new DAO_Produto();

    public List<CE_Produto> Obter(CE_Produto objeto)
    {
        return daoProduto.Obter(objeto);
    }

    public void Inserir(CE_Produto objeto)
    {
        daoProduto.Inserir(objeto);
    }

    public void Alterar(CE_Produto objeto)
    {
        daoProduto.Alterar(objeto);
    }

    public void Excluir(CE_Produto objeto)
    {
        daoProduto.Excluir(objeto);
    }

    public Long ObterSequence()
    {
        return daoProduto.ObterSequence();
    }
}
