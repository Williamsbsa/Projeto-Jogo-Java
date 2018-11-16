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
public class PadraoDoJogador {
    public String nome;
    public int idade;
    public ArrayList<PadraodasClasses> classes;
    public int saude;
    public int level;
    public int moeda;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public ArrayList<PadraodasClasses> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<PadraodasClasses> classes) {
        this.classes = classes;
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMoeda() {
        return moeda;
    }

    public void setMoeda(int moeda) {
        this.moeda = moeda;
    }

    public PadraoDoJogador(String nome, int idade, int saude, int level, int moeda) {
        this.nome = nome;
        this.idade = idade;
        this.saude = saude;
        this.level = level;
        this.moeda = moeda;
        this.classes = new ArrayList<PadraodasClasses>();
    }
    
    public void addClasse(PadraodasClasses classe){
        this.classes.add(classe);
    }
    
    public void listarJogadorPosBoss(PadraoDoJogador p1){
        System.out.println("\n"+p1.getNome()+" agora você está no Level: "+p1.getLevel());
        System.out.println("Suas moedas estão em: "+p1.getMoeda()+" -- você pega mais quando passa de Fase, porém não fique feliz pois não servem pra nada, até existia uma loja aqui pra comprar itens mas acabou falindo kkk.");
        System.out.println("Sua vida base(tirando obviamente seu escudo) está em: "+p1.getSaude());
        System.out.println("Nome do item de Atk: "+p1.getClasses().get(0).getItemAtk().get(0).getNome());
        System.out.println("Descrição do item de Atk: "+p1.getClasses().get(0).getItemAtk().get(0).getDescricao());
        System.out.println("Dano do item de Atk: "+p1.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk());
        System.out.println("Nome do item de Def: "+p1.getClasses().get(0).getItemDef().get(0).getNome());
        System.out.println("Descrição do item de Def: "+p1.getClasses().get(0).getItemDef().get(0).getDescricao());
        System.out.println("Escudo do item de Def: "+p1.getClasses().get(0).getItemDef().get(0).getEscudo());
        System.out.println("Nome da classe escolhida: "+p1.getClasses().get(0).getNome());
        System.out.println("Ataque base da classe: "+p1.getClasses().get(0).getForca());
        System.out.println("Defesa base da classe: "+p1.getClasses().get(0).getDefesa());
    }
}
