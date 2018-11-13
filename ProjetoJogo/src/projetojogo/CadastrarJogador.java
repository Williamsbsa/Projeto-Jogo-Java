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
public class CadastrarJogador {
    public static ArrayList<PadraoDoJogador> jogador = new ArrayList<PadraoDoJogador>();
    //public static ArrayList<ItemdeATK> itemAtk = new ArrayList<ItemdeATK>();
    //public static ArrayList<ItemdeDEF> itemDef = new ArrayList<ItemdeDEF>();
    
    public static void addJogador(PadraoDoJogador jogador){
        CadastrarJogador.jogador.add(jogador);
    }
    
    /*public static void addItemAtk(ItemdeATK itemAtk){
        CadastrarJogador.itemAtk.add(itemAtk);
    }
    
    public static void addItemDef(ItemdeDEF itemDef){
        CadastrarJogador.itemDef.add(itemDef);
    }*/
}
