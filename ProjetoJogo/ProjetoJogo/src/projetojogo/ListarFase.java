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
public class ListarFase {
    public static void listarMonstrosNormaisDaFase(){
        for(int i= 0;i<CadastrarFase.monstroNormal.size();i++){
            System.out.println("\nNome do Monstro: "+ CadastrarFase.monstroNormal.get(i).nome);
            System.out.println("Descricao: "+ CadastrarFase.monstroNormal.get(i).descricao);
            System.out.println("Forca: "+ CadastrarFase.monstroNormal.get(i).forca);
            System.out.println("Saude: "+ CadastrarFase.monstroNormal.get(i).saude);
            System.out.println("Nome item de Atk: "+ CadastrarFase.monstroNormal.get(i).itemAtk.get(0).getNome());
            System.out.println("Descricao item de Atk: "+ CadastrarFase.monstroNormal.get(i).itemAtk.get(0).getDescricao());
            System.out.println("Dano item de Atk: "+ CadastrarFase.monstroNormal.get(i).itemAtk.get(0).getDanoDeAtk());
            System.out.println("Nome item de Def: "+ CadastrarFase.monstroNormal.get(i).itemDef.get(0).getNome());
            System.out.println("Descricao item de Def: "+ CadastrarFase.monstroNormal.get(i).itemDef.get(0).getDescricao());
            System.out.println("Escudo item de Def: "+ CadastrarFase.monstroNormal.get(i).itemDef.get(0).getEscudo());
        }
    }
    
    public static void listarChefaoDaFase(){
        for(int i= 0;i<CadastrarFase.chefao.size();i++){
            System.out.println("\nNome do Chefao: "+ CadastrarFase.chefao.get(i).nome);
            System.out.println("Descricao: "+ CadastrarFase.chefao.get(i).descricao);
            System.out.println("Forca: "+ CadastrarFase.chefao.get(i).forca);
            System.out.println("Saude: "+ CadastrarFase.chefao.get(i).saude);
            System.out.println("Motivacao(Lore): "+ CadastrarFase.chefao.get(i).motivacao);
            System.out.println("Nome item de Atk: "+ CadastrarFase.chefao.get(i).itemAtk.get(0).getNome());
            System.out.println("Descricao item de Atk: "+ CadastrarFase.chefao.get(i).itemAtk.get(0).getDescricao());
            System.out.println("Dano item de Atk: "+ CadastrarFase.chefao.get(i).itemAtk.get(0).getDanoDeAtk());
            System.out.println("Nome item de Def: "+ CadastrarFase.chefao.get(i).itemDef.get(0).getNome());
            System.out.println("Descricao item de Def: "+ CadastrarFase.chefao.get(i).itemDef.get(0).getDescricao());
            System.out.println("Escudo item de Def: "+ CadastrarFase.chefao.get(i).itemDef.get(0).getEscudo());        
        }
    
    }    
    public static void listarFase(){
        for(int i= 0;i<CadastrarFase.fases.size();i++){
            System.out.println("\nNome da Fase: "+ CadastrarFase.fases.get(i).nome);
            System.out.println("Descricao: "+ CadastrarFase.fases.get(i).descricao);
            System.out.println("Level: "+ CadastrarFase.fases.get(i).level);
            listarMonstrosNormaisDaFase();
            listarChefaoDaFase();
        }
    }
    
    public static void apagarMonstroNormal(int indice){
        CadastrarFase.monstroNormal.remove(indice);
    }
    
    public static void apagarChefao(int indice){
        CadastrarFase.chefao.remove(indice);
    }
    
    public static void apagarFase(int indice){
        CadastrarFase.fases.remove(indice);
        apagarMonstroNormal(indice);
        apagarChefao(indice);
    }
    
    public static void editarNome(PadraodasFases p1, String nome){
        p1.setNome(nome);
    }
    
    public static void editarDescricao(PadraodasFases p1, String descricao){
        p1.setDescricao(descricao);
    }
    
    public static void editarLevel(PadraodasFases p1, int level){
        p1.setLevel(level);
    }
    
    public static void editarMonstroNormal(int indice, MonstroNormal monstroNormal){//n sei se vai dar certo
        CadastrarFase.monstroNormal.remove(indice);
        CadastrarFase.monstroNormal.add(monstroNormal);
    }
    
    public static void editarChefao(int indice, Chefao chefao){//n sei se vai dar certo
        CadastrarFase.chefao.remove(indice);
        CadastrarFase.chefao.add(chefao);
    }
    
}