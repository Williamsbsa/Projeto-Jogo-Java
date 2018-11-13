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
public class ListarItem {
    public static void listarItensATK(){
        for(int i=0; i<CadastrarItem.itemAtk.size(); i++){
            System.out.println("\nNome do item de Atk: " +CadastrarItem.itemAtk.get(i).getNome());
            System.out.println("Descricao: " +CadastrarItem.itemAtk.get(i).getDescricao());
            System.out.println("Dano: " +CadastrarItem.itemAtk.get(i).getDanoDeAtk());
        }
    }
    
    public static void listarItensDEF(){
        for(int i=0; i<CadastrarItem.itemDef.size(); i++){
            System.out.println("\nNome do item de Def: " +CadastrarItem.itemDef.get(i).getNome());
            System.out.println("Descricao: " +CadastrarItem.itemDef.get(i).getDescricao());
            System.out.println("Escudo: " +CadastrarItem.itemDef.get(i).getEscudo());
        }
    }

    public static void apagarItensAtk(int indice){
        CadastrarItem.itemAtk.remove(indice);
    }

    public static void apagarItensDef(int indice){
        CadastrarItem.itemDef.remove(indice);
    }

    public static void editarNomeItenATK(ItemdeATK p1, String nome){
        p1.setNome(nome);
    }

    public static void editarDescricaoItenATK(ItemdeATK p1, String descricao){
        p1.setDescricao(descricao);
    }    
    
    public static void editarAtaqueItenATK(ItemdeATK p1, int valor){
        p1.setDanoDeAtk(valor);
    }
    
    public static void editarNomeItenDef(ItemdeDEF d1, String nome){
        d1.setNome(nome);
    }
    
    public static void editarDescricaoItenDef(ItemdeDEF d1, String descricao){
        d1.setDescricao(descricao);
    }

    public static void editarEscudoItenDef(ItemdeDEF d1, int escudo){
        d1.setEscudo(escudo);
    }   


}
