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
public class CadastrarItem {
    public static ArrayList<ItemdeATK> itemAtk = new ArrayList<>();
    public static ArrayList<ItemdeDEF> itemDef = new ArrayList<>();
    
    
    public static void addItemATK(ItemdeATK itemAtk){
        CadastrarItem.itemAtk.add(itemAtk);
    }
    
    public static void addItemDEF(ItemdeDEF itemDef){
        CadastrarItem.itemDef.add(itemDef);
    }

}

