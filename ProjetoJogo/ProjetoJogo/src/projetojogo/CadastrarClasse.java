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
public class CadastrarClasse {
    public static ArrayList<PadraodasClasses> classe = new ArrayList<PadraodasClasses>();

    public CadastrarClasse() {
    }
    
    public static void addClasse(PadraodasClasses classe){
        CadastrarClasse.classe.add(classe);
    }
}
