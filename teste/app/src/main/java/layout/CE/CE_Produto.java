package layout.CE;

/**
 * Created by dijon on 24/01/2016.
 */
public class CE_Produto {
    private Long id;
    private String nome;
    private Double preco;
    private String descricao;
    private String tamanho;
    private CE_Fornecedor Fornecedor;
    private Boolean ativo;
    private String tipo;

    public CE_Produto() {    }

    public CE_Fornecedor getFornecedor() {
        return Fornecedor;
    }
    public void setFornecedor(CE_Fornecedor fornecedor) {
        Fornecedor = fornecedor;
    }

    public Boolean getAtivo() {
        return ativo;
    }
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

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

    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CE_Produto produto = (CE_Produto) o;

        if (id != null ? !id.equals(produto.id) : produto.id != null) return false;
        if (nome != null ? !nome.equals(produto.nome) : produto.nome != null) return false;
        if (preco != null ? !preco.equals(produto.preco) : produto.preco != null) return false;
        if (descricao != null ? !descricao.equals(produto.descricao) : produto.descricao != null)
            return false;
        if (tamanho != null ? !tamanho.equals(produto.tamanho) : produto.tamanho != null)
            return false;
        if (Fornecedor != null ? !Fornecedor.equals(produto.Fornecedor) : produto.Fornecedor != null)
            return false;
        if (ativo != null ? !ativo.equals(produto.ativo) : produto.ativo != null) return false;
        return !(ativo != null ? !ativo.equals(produto.ativo) : produto.ativo != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (preco != null ? preco.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (tamanho != null ? tamanho.hashCode() : 0);
        result = 31 * result + (Fornecedor != null ? Fornecedor.getId().hashCode() : 0);
        result = 31 * result + (ativo != null ? ativo.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", vendedor='" + Fornecedor.getNome() + '\'' +
                ", Ativo=" + ativo +
                ", Tipo='" + tipo + '\'' +
                '}';
    }
}
