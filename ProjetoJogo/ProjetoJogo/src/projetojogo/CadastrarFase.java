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
public class CadastrarFase {
    public static ArrayList<PadraodasFases> fases = new ArrayList<PadraodasFases>();
    public static ArrayList<MonstroNormal> monstroNormal = new ArrayList<MonstroNormal>();
    public static ArrayList<Chefao> chefao = new ArrayList<Chefao>();
    
    public CadastrarFase() {
    }
    
    
    public static void addFase(PadraodasFases fases){
        CadastrarFase.fases.add(fases);
    }
    public static void addMonstroNormal(MonstroNormal monstroNormal){
        CadastrarFase.monstroNormal.add(monstroNormal);
    }
    public static void addChefao(Chefao chefao){
        CadastrarFase.chefao.add(chefao);
    }
}
