/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetojogo;

/**
 *
 * @author braga
 */
public class PadraodasFases {
    public String nome;
    public String descricao;
    public int level;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public PadraodasFases(String nome, String descricao, int level) {
        this.nome = nome;
        this.descricao = descricao;
        this.level = level;
    }
    
    
}
