package layout.CE;

/**
 * Created by dijon on 06/08/2016.
 */
public class CE_Fornecedor {

    public CE_Fornecedor(){}

    private Long id;
    private String nome;
    private String descricao;
    private String endereco;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
