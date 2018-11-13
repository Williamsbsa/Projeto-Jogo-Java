/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetojogo;

import java.util.ArrayList;

/**
 *
 * @author braga
 */
public class MonstroNormal {
    public String nome;
    public String descricao;
    public int forca;
    public int saude;
    public ArrayList<ItemdeATK> itemAtk;
    public ArrayList<ItemdeDEF> itemDef;

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

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public ArrayList<ItemdeATK> getItemAtk() {
        return itemAtk;
    }

    public void setItemAtk(ArrayList<ItemdeATK> itemAtk) {
        this.itemAtk = itemAtk;
    }

    public ArrayList<ItemdeDEF> getItemDef() {
        return itemDef;
    }

    public void setItemDef(ArrayList<ItemdeDEF> itemDef) {
        this.itemDef = itemDef;
    }

    public MonstroNormal(String nome, String descricao, int forca, int saude) {
        this.nome = nome;
        this.descricao = descricao;
        this.forca = forca;
        this.saude = saude;
        this.itemAtk = new ArrayList<>();
        this.itemDef = new ArrayList<>();
    }
    
    public void addItemATK(ItemdeATK itemAtk){
        this.itemAtk.add(itemAtk);
    }
    
    public void addItemDEF(ItemdeDEF itemDef){
        this.itemDef.add(itemDef);
    }    
}
