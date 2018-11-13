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
public class ListarMonstros {
    public static void listarMonstroNormal(){
        for(int i= 0;i<CadastrarMonstro.monstroNormal.size();i++){
            System.out.println("\nNome do Monstro: "+ CadastrarMonstro.monstroNormal.get(i).nome);
            System.out.println("Descricao: "+ CadastrarMonstro.monstroNormal.get(i).descricao);
            System.out.println("Forca: "+ CadastrarMonstro.monstroNormal.get(i).forca);
            System.out.println("Saude: "+ CadastrarMonstro.monstroNormal.get(i).saude);
            System.out.println("Nome item de Atk: "+ CadastrarMonstro.monstroNormal.get(i).getItemAtk().get(0).getNome());
            System.out.println("Descricao item de Atk: "+ CadastrarMonstro.monstroNormal.get(i).getItemAtk().get(0).getDescricao());
            System.out.println("Dano item de Atk: "+ CadastrarMonstro.monstroNormal.get(i).getItemAtk().get(0).getDanoDeAtk());
            System.out.println("Nome item de Def: "+ CadastrarMonstro.monstroNormal.get(i).getItemDef().get(0).getNome());
            System.out.println("Descricao item de Def: "+ CadastrarMonstro.monstroNormal.get(i).getItemDef().get(0).getDescricao());
            System.out.println("Escudo item de Def: "+ CadastrarMonstro.monstroNormal.get(i).getItemDef().get(0).getEscudo());
        }
    }
    
    public static void listarChefao(){
        for(int i= 0;i<CadastrarMonstro.chefao.size();i++){
            System.out.println("\nNome do Chefao: "+ CadastrarMonstro.chefao.get(i).nome);
            System.out.println("Descricao: "+ CadastrarMonstro.chefao.get(i).descricao);
            System.out.println("Forca: "+ CadastrarMonstro.chefao.get(i).forca);
            System.out.println("Saude: "+ CadastrarMonstro.chefao.get(i).saude);
            System.out.println("Motivacao(Lore): "+ CadastrarMonstro.chefao.get(i).motivacao);
            System.out.println("Nome item de Atk: "+ CadastrarMonstro.chefao.get(i).getItemAtk().get(0).getNome());
            System.out.println("Descricao item de Atk: "+ CadastrarMonstro.chefao.get(i).getItemAtk().get(0).getDescricao());
            System.out.println("Dano item de Atk: "+ CadastrarMonstro.chefao.get(i).getItemAtk().get(0).getDanoDeAtk());
            System.out.println("Nome item de Def: "+ CadastrarMonstro.chefao.get(i).getItemDef().get(0).getNome());
            System.out.println("Descricao item de Def: "+ CadastrarMonstro.chefao.get(i).getItemDef().get(0).getDescricao());
            System.out.println("Escudo item de Def: "+ CadastrarMonstro.chefao.get(i).getItemDef().get(0).getEscudo());        
        }
    
    }
    
    public static void apagarMonstroNormal(int indice){
        CadastrarMonstro.monstroNormal.remove(indice);
    }

    public static void apagarChefao(int indice){
        CadastrarMonstro.chefao.remove(indice);
    }    

    public static void editarNomeMonstroNormal(MonstroNormal m1, String nome){
        m1.setNome(nome);
    }
    
    public static void editarDescricaoMonstroNormal(MonstroNormal m1, String descricao){
        m1.setDescricao(descricao);
    }
    public static void editarForcaMonstroNormal(MonstroNormal m1, int forca){
        m1.setForca(forca);
    }
    
    public static void editarSaudeMonstroNormal(MonstroNormal m1, int saude){
        m1.setSaude(saude);
    }
    public static void editarItemAtkMonstroNormal(MonstroNormal m1, ItemdeATK itemAtk){
        m1.itemAtk.remove(0);
        m1.addItemATK(itemAtk);
    }
    public static void editarItemDefMonstroNormal(MonstroNormal m1, ItemdeDEF itemDef){
        m1.itemDef.remove(0);
        m1.addItemDEF(itemDef);
    }
 
    public static void editarNomeChefao(Chefao c1, String nome){
        c1.setNome(nome);
    }
    
    public static void editarDescricaoChefao(Chefao c1, String descricao){
        c1.setDescricao(descricao);
    }
    public static void editarForcaChefao(Chefao c1, int forca){
        c1.setForca(forca);
    }
    
    public static void editarSaudeChefao(Chefao c1, int saude){
        c1.setSaude(saude);
    }
    public static void editarMotivacaoChefao(Chefao c1, String motivacao){
        c1.setMotivacao(motivacao);
    }
    
    public static void editarItemAtkChefao(Chefao c1, ItemdeATK itemAtk){
        c1.itemAtk.remove(0);
        c1.addItemATK(itemAtk);
    }
    public static void editarItemDefChefao(Chefao c1, ItemdeDEF itemDef){
        c1.itemDef.remove(0);
        c1.addItemDEF(itemDef);
    }    
    
}
