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
public class ItemdeATK{
    private String nome;
    private String descricao;
    private int danoDeAtk;

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

    public int getDanoDeAtk() {
        return danoDeAtk;
    }

    public void setDanoDeAtk(int danoDeAtk) {
        this.danoDeAtk = danoDeAtk;
    }

    public ItemdeATK(String nome, String descricao, int danoDeAtk) {
        this.nome = nome;
        this.descricao = descricao;
        this.danoDeAtk = danoDeAtk;
    }
    
}
