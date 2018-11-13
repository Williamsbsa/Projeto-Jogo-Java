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
public class PadraodasClasses {
    public String nome;
    public String descricao;
    public ArrayList<ItemdeATK> itemAtk;
    public ArrayList<ItemdeDEF> itemDef;
    public int forca;
    public int defesa;

    public PadraodasClasses(String nome, String descricao, int forca, int defesa) {
        this.nome = nome;
        this.descricao = descricao;
        this.forca = forca;
        this.defesa = defesa;
        this.itemAtk = new ArrayList<>();
        this.itemDef = new ArrayList<>();
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

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void addItemAtk(ItemdeATK itemAtk){
        this.itemAtk.add(itemAtk);
    }
    
    public void addItemDef(ItemdeDEF itemDef){
        this.itemDef.add(itemDef);
    }
}
