package BO;

import android.content.Context;

import java.util.List;

import DAO.DAO_Fornecedor;
import DATABASE.CriaBanco;
import layout.CE.CE_Fornecedor;

/**
 * Created by dijon on 07/08/2016.
 */
public class BO_Fornecedor {

    public BO_Fornecedor(Context context)
    {

    }
    public DAO_Fornecedor daoFornecedor = new DAO_Fornecedor();

    public List<CE_Fornecedor> Obter(CE_Fornecedor objeto)
    {
        return daoFornecedor.Obter(objeto);
    }

    public String Inserir(CE_Fornecedor objeto)
    {
       return daoFornecedor.Inserir(objeto);
    }

    public void Alterar(CE_Fornecedor objeto)
    {
        daoFornecedor.Alterar(objeto);
    }

    public void Excluir(CE_Fornecedor objeto)
    {
        daoFornecedor.Excluir(objeto);
    }

    public Long ObterSequence()
    {
        return daoFornecedor.ObterSequence();
    }
}
