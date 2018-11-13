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
public class CadastrarMonstro {
    public static ArrayList<MonstroNormal> monstroNormal = new ArrayList<MonstroNormal>();
    public static ArrayList<Chefao> chefao = new ArrayList<Chefao>();
    
    public static void addMonstroNormal(MonstroNormal monstroNormal){
        CadastrarMonstro.monstroNormal.add(monstroNormal);
    }
    
    public static void addChefao(Chefao chefao){
        CadastrarMonstro.chefao.add(chefao);
    }
}
