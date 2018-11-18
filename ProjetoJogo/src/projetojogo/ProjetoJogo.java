/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetojogo;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author braga
 */
public class ProjetoJogo {
        static int batalha(PadraoDoJogador jogador, int indice, ItemdeATK itemdeAtkMonstro, ItemdeDEF itemdeDefMonstro){ //batalha contra monstro normal
            int danoClasse = jogador.getClasses().get(0).getForca();
            int escudoClasse = jogador.getClasses().get(0).getDefesa();
            int danoItem = jogador.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk();
            int escudoItem = jogador.getClasses().get(0).getItemDef().get(0).getEscudo();
            int saude = jogador.getSaude();
            int danoTotal = danoClasse + danoItem;
            int escudoTotal = escudoClasse + escudoItem + saude;
            Scanner on = new Scanner(System.in);
            int indiceMonstro = indice;
            ListarFase.listarMonstrosEscolhido(indiceMonstro);
            int forcaMonstro = ListarFase.forcaTotalMonstro(indiceMonstro);
            int escudoMonstro = ListarFase.escudoTotalMonstro(indiceMonstro);
            int atacar = 0;
            int contadorAtaque = 0;
                while(true){
                    System.out.print("\nO Turno é seu, digite 1 quando quiser atacar: ");
                    atacar = on.nextInt();
                    if(atacar == 1){
                        //
                        escudoMonstro = escudoMonstro - danoTotal;
                        if (escudoMonstro>0){
                            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                            System.out.println("Escudo total do monstro agora está em:  "+ escudoMonstro);
                            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                        }
                        else if (escudoMonstro<= 0){
                            System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#");
                            System.out.println("Escudo do monstro chegou a 0, OU SEJA.. ELIMADO COM SUCESSO !!");
                            System.out.println("=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");
                            System.out.println("\nO Monstro dropou seus itens... ");
                            ListarFase.listarItensDropadosMonstroNormal(indiceMonstro);
                            System.out.print("\nDeseja pegar um dos itens? ([1] - SIM) ou ([2] - NÃO) : ");
                            int pegarItens = on.nextInt();
                            if (pegarItens == 1){
                                System.out.print(">>>>>>>>>>([1] - para Item de Atk) ou ([2] - para Item de Def)<<<<<<<<<< :");
                                int escolherItem = on.nextInt();
                                if (escolherItem == 1){//logica do item de atk
                                    ListarClasse.editarItemAtk(jogador, itemdeAtkMonstro);//mudamos item aqui
                                    danoClasse = jogador.getClasses().get(0).getForca();//aqui pra baixo é so pro print do seu danoTotal sair certo, já que mudou os valores.
                                    danoItem = jogador.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk();
                                    danoTotal = danoClasse + danoItem;
                                    System.out.println("Seu novo Status(sem recuperar seu escudo) agora é... ");
                                    System.out.println("**********************************************************************************");
                                    System.out.println("Dano Total = "+danoTotal);
                                    System.out.println("Escudo total = "+escudoTotal);
                                    System.out.println("**********************************************************************************");
                                    break;
                                }else{//logica do item de def
                                    PadraodasClasses classeEscolhida = jogador.classes.get(0);
                                    ListarClasse.editarItemDef(jogador, itemdeDefMonstro);//mudamos item aqui
                                    escudoClasse = jogador.getClasses().get(0).getDefesa();
                                    escudoItem = jogador.getClasses().get(0).getItemDef().get(0).getEscudo();
                                    saude = jogador.getSaude();
                                    escudoTotal = escudoClasse + escudoItem + saude;
                                    if (contadorAtaque>0){
                                        contadorAtaque = contadorAtaque * forcaMonstro;
                                        escudoTotal = escudoTotal - contadorAtaque;
                                    }
                                    System.out.println("Seu novo Status(sem recuperar seu escudo) agora é... ");
                                    System.out.println("**********************************************************************************");
                                    System.out.println("Dano Total = "+danoTotal);
                                    System.out.println("Escudo total = "+escudoTotal);
                                    System.out.println("**********************************************************************************");
                                    break;
                                }
                            }else{//se nao quiser pegar itens
                                System.out.println("Seu Status(sem recuperar seu escudo) agora é... ");
                                System.out.println("**********************************************************************************");
                                System.out.println("Dano Total = "+danoTotal);
                                System.out.println("Escudo total = "+escudoTotal);
                                System.out.println("**********************************************************************************");
                                break;
                            }
                            }
                        System.out.println("\nAgora é a vez do Monstro, Prepare-se !!");
                        System.out.println("=====================================================");
                        Random sorteio = new Random();
                        int aleatorio = (sorteio.nextInt(2));
                        if(aleatorio == 1){ //se o numero aleatorio for 1 entao o monstro te acerta
                            escudoTotal = escudoTotal - forcaMonstro;
                            contadorAtaque = contadorAtaque + 1;
                            if (escudoTotal>0){
                                System.out.println("Seu escudo total agora está em: "+ escudoTotal);
                                System.out.println("=====================================================");
                            }else if(escudoTotal<=0){
                                System.out.println("GAME OVER... :( parece que você não foi capaz desta vez, volta quando se sentir confiante.");
                                System.out.println("=====================================================");
                                System.exit(0);
                                //return; nao funciona dentro de funcao
                                //exit() nao funcionou;
                            }
                        }else{
                            System.out.println("O Monstro errou o golpe, mas que sorte a sua heim !!");
                            System.out.println("Seu Escudo continua em: "+escudoTotal);
                            System.out.println("=====================================================");
                        }
                    }
                }
            return escudoTotal;
        }
        static void batalhaBoss(PadraoDoJogador jogador, int indice, ItemdeATK itemdeAtkBoss, ItemdeDEF itemdeDefBoss, int escudoEnfrentBoss){ // batalha contra boss
            int danoClasse = jogador.getClasses().get(0).getForca();
            int escudoClasse = jogador.getClasses().get(0).getDefesa();
            int danoItem = jogador.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk();
            int escudoItem = jogador.getClasses().get(0).getItemDef().get(0).getEscudo();
            int saude = jogador.getSaude();
            int danoTotal = danoClasse + danoItem;
            int escudoTotal = escudoEnfrentBoss;
            Scanner on = new Scanner(System.in);
            int indiceBoss = indice;
            ListarFase.listarBossEnfrentando(indice);
            int forcaBoss = ListarFase.forcaTotalBoss(indiceBoss);
            int escudoBoss = ListarFase.escudoTotalBoss(indiceBoss);
            int atacar = 0;
            int contadorAtaque = 0;
            try { Thread.sleep (1000); } catch (InterruptedException ex) {}
            System.out.println("\n!!!!!\"BARULHOS AMEDRONTADORES\"!!!!!");
            try { Thread.sleep (1000); } catch (InterruptedException ex) {}
                while(true){
                    System.out.print("\nO Turno é seu, digite 1 quando quiser atacar: ");
                    atacar = on.nextInt();
                    if(atacar == 1){
                        //
                        escudoBoss = escudoBoss - danoTotal;
                        if (escudoBoss>0){
                            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                            System.out.println("Escudo total do Boss agora está em:  "+ escudoBoss);
                            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                        }
                        else if (escudoBoss<= 0){
                            System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#");
                            System.out.println("Escudo do Boss chegou a 0, OU SEJA.. EXTERMINADO COM SUCESSO !!!!");
                            System.out.println("=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");
                            System.out.println("\nO Boss dropou seus itens... ");
                            ListarFase.listarItensDropadosBoss(indice);
                            System.out.print("\nDeseja pegar um dos itens? ([1] - SIM) ou ([2] - NÃO) : ");
                            int pegarItens = on.nextInt();
                            if (pegarItens == 1){
                                System.out.print(">>>>>>>>>>([1] - para Item de Atk) ou ([2] - para Item de Def)<<<<<<<<<< :");
                                int escolherItem = on.nextInt();
                                if (escolherItem == 1){//logica do item de atk
                                    //PadraodasClasses classeEscolhida = jogador.classes.get(0);
                                    ListarClasse.editarItemAtk(jogador, itemdeAtkBoss);//mudamos item aqui
                                    danoClasse = jogador.getClasses().get(0).getForca();//aqui pra baixo é so pro print do seu danoTotal sair certo, já que mudou os valores.
                                    danoItem = jogador.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk();
                                    danoTotal = danoClasse + danoItem;
                                    System.out.println("Seu novo Status(sem recuperar seu escudo) agora é... ");
                                    System.out.println("**********************************************************************************");
                                    System.out.println("Dano Total = "+danoTotal);
                                    System.out.println("Escudo total = "+escudoTotal);
                                    System.out.println("**********************************************************************************");
                                    break;
                                }else{//logica do item de def
                                    PadraodasClasses classeEscolhida = jogador.classes.get(0);
                                    ListarClasse.editarItemDef(jogador, itemdeDefBoss);//mudamos item aqui
                                    escudoClasse = jogador.getClasses().get(0).getDefesa();
                                    escudoItem = jogador.getClasses().get(0).getItemDef().get(0).getEscudo();
                                    saude = jogador.getSaude();
                                    escudoTotal = escudoClasse + escudoItem + saude;
                                    if (contadorAtaque>0){
                                        contadorAtaque = contadorAtaque * forcaBoss;
                                        escudoTotal = escudoTotal - contadorAtaque;
                                    }
                                    System.out.println("Seu novo Status(sem recuperar seu escudo) agora é... ");
                                    System.out.println("**********************************************************************************");
                                    System.out.println("Dano Total = "+danoTotal);
                                    System.out.println("Escudo total = "+escudoTotal);
                                    System.out.println("**********************************************************************************");
                                    break;
                                }
                            }else{//se nao quiser pegar itens
                                break;
                            }
                            }
                        System.out.println("\nAgora é a vez do Boss, Prepare-se !!");
                        System.out.println("=====================================================");
                        Random sorteio = new Random();
                        int aleatorio = (sorteio.nextInt(2));
                        if(aleatorio == 1){ //se o numero aleatorio for 1 entao o monstro te acerta
                            escudoTotal = escudoTotal - forcaBoss;
                            contadorAtaque = contadorAtaque + 1;
                            if (escudoTotal>0){
                                System.out.println("Seu escudo total agora está em: "+ escudoTotal);
                                System.out.println("=====================================================");
                            }else if(escudoTotal<=0){
                                System.out.println("GAME OVER... :( parece que você não foi capaz desta vez, volta quando se sentir confiante.");
                                System.out.println("=====================================================");
                                System.exit(0);
                                //return; nao funciona em funcao
                                //exit() nao funcionou;
                            }
                        }else{
                            System.out.println("O Boss errou o golpe, mas que sorte a sua heim !!");
                            System.out.println("Seu Escudo continua em: "+escudoTotal);
                            System.out.println("=====================================================");
                        }
                    }
                }
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Criando Itens
        ItemdeATK martelo= new ItemdeATK("Martelo de Valhalla","Martelo forjado por Odin, para o equilíbrio do Universo", 30);
        ItemdeDEF escudoRag = new ItemdeDEF("Escudo do Ragnarok", "Escudo enviado para impedir o fim do Mundo.", 75);
        
        ItemdeATK arco = new ItemdeATK("Arco do cosmos","Boatos cercam a criação deste arco, porém o que sabemos é que muitos poucos sobrevivem com tamanho poder", 65);
        ItemdeDEF escudoElf= new ItemdeDEF("Ecudo élfico", "Escudo feito pelo ancião da Vila élfica em seus últimos anos de vida.", 65);
        
        ItemdeATK lamina = new ItemdeATK("Lamina Sanguinária","Parece frágil, porém é a mais perigosa da Europa Ocidental, sendo que na maioria dos casos, 1 corte desta lâmina é capaz de matar.", 70);
        ItemdeDEF cotaMalha = new ItemdeDEF("Cota de malha", "Pequena e fina camada de proteção, porém agil para movimentação.", 45);
        
        ItemdeATK cetro = new ItemdeATK("Cetro de Rá","Cetro mágico com o acumulo de décadas de concentração da energia de suas vítimas.", 75);
        ItemdeDEF escudoEner = new ItemdeDEF("Escudo de energia", "Escudo não seria a palavra exata para esta magia incrível, pode não ser tão resistente, porém é de rápida conjuração.", 55);
         
        ItemdeATK espadaGob = new ItemdeATK("Espada Goblin","Espada forjada em esconderijo Goblin", 15);
        ItemdeDEF armaduraPano= new ItemdeDEF("Armadura de Pano", "Armadura fabricada pela mãe do Goblin.", 10);
        
        ItemdeATK ossoRat = new ItemdeATK("Osso de Ratazana","Osso da última refeição do pequeno Slime", 10);
        ItemdeDEF escudoGosm= new ItemdeDEF("Escudo Gosmento", "Escudo fabricado no primeiro dia da vida do pequeno Slime.", 15);
        
        ItemdeATK porreteOgro = new ItemdeATK("Porrete de Ogro","Porrete tradicional de Ogro, passado de geração em geração.", 30);
        ItemdeDEF tangaOgro= new ItemdeDEF("Tanga de Ogro", "Tanga para cobrir suas partes íntimas, este Ogro não gosta de armaduras.", 5);
        
        ItemdeATK  presasmorc = new ItemdeATK("Presas de Morcego Sanguessuga","Presas que facilitam sugar sangue",40);  
        ItemdeDEF pelodemorce = new ItemdeDEF("Pelo de Morcego Sanguessuga","Pelos negros que cobrem o corpo todo",20);  
          
        ItemdeATK queliceras = new ItemdeATK("Quelíceras da Aranha Negra","Machucam e liberam veneno",45);  
        ItemdeDEF exoaranha = new ItemdeDEF("Exoesqueleto de Aranha Negra","Carapaça muito resistente",55);  
          
        ItemdeATK  machadohiena= new ItemdeATK("Machado poderoso de aventureiro","Machado poderoso para um aventureiro iniciante",55);  
        ItemdeDEF  armadurahiena= new ItemdeDEF("Armadura do Guerreiro","Armadura de ferro maciço ",65);  
          
        ItemdeATK  almafa= new ItemdeATK("Alma de Fantasma","Item muito requisitado por Magos iniciantes",30);  
        ItemdeDEF  poeiraf= new ItemdeDEF("Poeira Fantasmagórica","Item não poderoso porém muito bonito",30);  
          
        ItemdeATK  lascadep= new ItemdeATK("Lasca de Pedra","Criação especial da Gárgula",45);  
        ItemdeDEF  armaduradep= new ItemdeDEF("Armadura de Pedra","Tão dura quanto uma Gárgula",60);  
          
        ItemdeATK  cajmag= new ItemdeATK("Cajado do Mago Cinzento","Não se engane pela aparência, este item é muito poderoso",65);  
        ItemdeDEF  vestesmag= new ItemdeDEF("Vestes da Academia de Magia","Uniforme da escola de magia mais procurada em todo mundo",45);  
          
        ItemdeATK  ferraoven= new ItemdeATK("Ferrão Venenoso","Contém veneno e mata lentamente",65);  
        ItemdeDEF  carapver= new ItemdeDEF("Carapaça Vermelha","Suporta até o calor mais forte do Deserto",55);  
          
        ItemdeATK  dentesg= new ItemdeATK("Dentes Giratórios do Verme do Deserto","Mesmo morto estes dentes continuam a girar pela eternidade, se o portador desejar",70);  
        ItemdeDEF  areiap= new ItemdeDEF("Areia Processada","Gerada dentro do estômago do Verme",60);  
          
        ItemdeATK  bastaodam= new ItemdeATK("Bastão da Morte","Conhecido por ser a arma que define quem vive e morre",80);  
        ItemdeDEF  sarcofagop= new ItemdeDEF("Sarcófago Protetor","Que a bênção dos antigos Faraós o acompanhe",60);  
          
        ItemdeATK  dentedes= new ItemdeATK("Dente de Sabre","O famoso Dente de Sabre do Tigre mais perigoso do mundo",75);  
        ItemdeDEF  tunicab= new ItemdeDEF("Túnica Branca","Aquece Qualquer aventureiro",75);  
          
        ItemdeATK  maodeg= new ItemdeATK("Mão de Gorila","Um cruzado de direita dessa mão nocauteia qualquer um",75);  
        ItemdeDEF  escudodec= new ItemdeDEF("Escudo de Cipó","Achado na toca de Gorilas",85);  
          
        ItemdeATK  bastaorex= new ItemdeATK("Bastão Conjurador de Rex","Usada por tribos de magos na antiguidade para conjurar o Rei",85);  
        ItemdeDEF  esqueletoj= new ItemdeDEF("Esqueleto Jurássico","Ossos muito rígidos ",85);  
          
        ItemdeATK  harpal= new ItemdeATK("Harpa do Leão","Libera um poderoso rugido que atordoa adversários",80);  
        ItemdeDEF  jubac= new ItemdeDEF("Juba Congelada","Além de exibir poder é muito eficaz para se defender",100);  
          
        ItemdeATK  estacagel= new ItemdeATK("Estaca de Gelo","Parte do corpo do Golem de Gelo",95);  
        ItemdeDEF  escudogel= new ItemdeDEF("Escudo de gelo", "Parte do corpo do Golem de Gelo",95);  
          
        ItemdeATK  furacaogel= new ItemdeATK("Furacão de Gelo","Ninguém nunca pensou que desse para domar um furacão",105);  
        ItemdeDEF  nevep= new ItemdeDEF("Neve Protetora","É muito difícil atravessar essa barreira ",95);  
          
        ItemdeATK  triquei= new ItemdeATK("Tridente Queimado","Antigamente era posse de Poseidon",110);  
        ItemdeDEF  escudocinz= new ItemdeDEF("Escudo de Cinzas","O que restou de um monstro perturbado",100);  
          
        ItemdeATK  arcofogo= new ItemdeATK("Arco de Fogo","Das asas da Fênix surgiu um Arco extremamente preciso",100);  
        ItemdeDEF  armadurachamav= new ItemdeDEF("Armadura da Chama Viva","Dizem que essa armadura faz com que a Fênix renasça das cinzas",120);  
          
        ItemdeATK  espadaflam= new ItemdeATK("Espada Flamejante","Após a morde de um Dragão sua alma pode ser introduzida em um objeto, esta espada possuí a alma do dragão mais poderoso",130);  
        ItemdeDEF  couradrag= new ItemdeDEF("Couraça de Dragão","Nem mesmo a mais poderosa espada pode atravessá-la",100);  
          
        ItemdeATK  lancacav= new ItemdeATK("Lança de Cavaleiro","Antiga lança de um nobre cavaleiro",115);  
        ItemdeDEF  cabecaflam= new ItemdeDEF("Cabeça Flamejante","A lenda do Cavaleiro sem Cabeça continua",125);  
          
        ItemdeATK  cabechidra= new ItemdeATK("Cabeça de Hidra ","Uma arma para perder a cabeça",120);  
        ItemdeDEF  escamahidra= new ItemdeDEF("Escamas de Hidra","Tão fortes que até mesmo Hércules não conseguiu perfurar",130);  
          
        ItemdeATK  caudasq= new ItemdeATK("Cauda de Serpente de Quimera","Uma arma inteligente que pode atacar em áreas que aventureiros não conhecem do oponente",115);  
        ItemdeDEF  cerebroquim= new ItemdeDEF("Cérebro de Quimera","Porque um escudo potente quando se pode prever todos os movimentos em uma batalha",145);  
          
        ItemdeATK  chuvap= new ItemdeATK("Chuva de Pedras","Potente contra um exército de inimigos",125);  
        ItemdeDEF  cancaop= new ItemdeDEF("Canção da Proteção","Além de linda, pode proteger um aventureiro",145);  
          
        ItemdeATK  ferraduraaco= new ItemdeATK("Ferradura do Mar","Pode ser que sua sorte melhore com uma arma dessas",130);  
        ItemdeDEF  chifrecav= new ItemdeDEF("Chifre de Cavalo Marinho","Muito mais duro que um diamante",150);  
          
        ItemdeATK  tentaculoc= new ItemdeATK("Tentáculo do Cthulhu","Cthulhu não precisa de mais nada além de seus tentáculos e sua presença",150);  
        ItemdeDEF  tentaculocd= new ItemdeDEF("Tentáculo do Cthulhu ","Cthulhu não precisa de mais nada além de seus tentáculos e sua presença ",150);  
          
        ItemdeATK  espnegra= new ItemdeATK("Espada Negra","Apenas olhar para essa espada te destruir por completo",145);  
        ItemdeDEF  assasanjo= new ItemdeDEF("Assas de Anjo Caído"," Carregam penas negras como a própria escuridão",135);  
          
        ItemdeATK  cajdonecromante= new ItemdeATK("Cajado no Necromante","Poder suficiente para destruir mundos",145);  
        ItemdeDEF  capanecromante= new ItemdeDEF("Capa do Necromante","Presente especial do Rei Demônio",135);  
          
        ItemdeATK  presennsup= new ItemdeATK("Presença Suprema","Ninguém pode sobreviver a presença do senhor das trevas",999999);  
        ItemdeDEF  presensupr= new ItemdeDEF("Presença Suprema","Ninguém pode sobreviver a presença do senhor das trevas",200); 
        
        //Criando Classes
        PadraodasClasses guerreiro = new PadraodasClasses("Guerreiro","Força e Defesa altos, porém não sabe manusear armas complicadas.",25,25);
        PadraodasClasses arqueiro = new PadraodasClasses("Arqueiro","Força e Defesa não muito expressivos, porém alta habilidade com arcos.",15,10);
        PadraodasClasses ladino = new PadraodasClasses("Ladino","Força e Defesa base comuns, porém super agil com armas.",20,20);
        PadraodasClasses mago = new PadraodasClasses("Mago","Força e Defesa um pouco baixos, porém faz conjurações rápidas com suas magias e domina suas armas.",10,15);
        
        //Criando Monstros e seus itens
        MonstroNormal goblin = new MonstroNormal("Goblin","Saqueador malandro do vilarejo", 25,75);//voltar pra 25 de dano
        goblin.addItemATK(espadaGob);
        goblin.addItemDEF(armaduraPano);
        MonstroNormal slime = new MonstroNormal("Slime bebê","Recém nascido que incomoda muito", 25,75);
        slime.addItemATK(ossoRat);
        slime.addItemDEF(escudoGosm);
        Chefao ogro = new Chefao("Ogro Verde","O líder da caverna, que está furioso com a derrota de seu companheiro",25,100,"Este Ogro Verde sempre foi habilidoso desde criança, e nunca cansou de se gabar disso, agora que você está ameaçando seu trono ele não vai deixar barato!!");
        ogro.addItemATK(porreteOgro);
        ogro.addItemDEF(tangaOgro);
        
        MonstroNormal morcss = new MonstroNormal("Morcego Sanguessuga","O sugador de sangue voador", 30,80);
        morcss.addItemATK(presasmorc);
        morcss.addItemDEF(pelodemorce);
        MonstroNormal  arann= new MonstroNormal("Aranha Negra","Também conhecida como Viúva Negra", 40,70);
        arann.addItemATK(queliceras);
        arann.addItemDEF(exoaranha);
        Chefao  hiena= new Chefao("Hiena Mestiça","Um monstro nascido na Floresta do Pesadelo",45,100,"Com um começo de vida complicado esse a pequenina Hiena teve que aprender a se defender sozinha, atualmente vaga pela Floresta do Pesadelo em busca de aventureiros que possuam itens raros");
        hiena.addItemATK(machadohiena);
        hiena.addItemDEF(armadurahiena);
        
        MonstroNormal  espec= new MonstroNormal("Espectro","Algum dia foi alguém",5,5);
        espec.addItemATK(almafa);
        espec.addItemDEF(poeiraf);
        MonstroNormal  garg= new MonstroNormal("Gárgula","Coração de pedra",30,90);
        garg.addItemATK(lascadep);
        garg.addItemDEF(armaduradep);
        Chefao magoc= new Chefao("Mago Confuso","Poderoso Mago que cuida da Torre",110,55,"Após ser feita uma lavagem cerebral pelo Necromancer enlouqueceu e derrota tudo que entra em sua propriedade");
        magoc.addItemATK(cajmag);
        magoc.addItemDEF(vestesmag);
        
        MonstroNormal escpv = new MonstroNormal("Escorpião Vermelho","É muito conhecido por nômades que tentam cruzar o Deserto", 65,65);
        escpv.addItemATK(ferraoven);
        escpv.addItemDEF(carapver);
        MonstroNormal verme = new MonstroNormal("Verme de Areia do Deserto","Causa muitas mortes pelos buracos na areia", 80,50);
        verme.addItemATK(dentesg);
        verme.addItemDEF(areiap);
        Chefao anub= new Chefao("Anubis","O guardião e guia dos mortos",100,85,"Anubis percebeu um número anormal de seres sendo enviados ao seu encontro e quis saber o que estava acontecendo, quando chegou até você quis o resolver problema da forma mais rápida possível");
        anub.addItemATK(bastaodam);
        anub.addItemDEF(sarcofagop);
        
        MonstroNormal  tigreb= new MonstroNormal("Tigre Dente de Sabre Branco","Por seus pelos claros era \"coroado\" como o Rei dos Tigres Dente de Sabre", 90,50);
        tigreb.addItemATK(dentedes);
        tigreb.addItemDEF(tunicab);
        //paramos aqui
        MonstroNormal  gorila= new MonstroNormal("Gorila Gigante","Um monstro muito temido por vilarejos antigos", 70,70);
        gorila.addItemATK(maodeg);
        gorila.addItemDEF(escudodec);
        Chefao  rex= new Chefao("Tiranossauro Rex","Também conhecido como o Rei do período Jurássico",120,85,"O Tiranossauro Rex vê tudo que está em sua frente como uma presa, e desta vez não foi diferente ");
        rex.addItemATK(bastaorex);
        rex.addItemDEF(esqueletoj);
        
        MonstroNormal lc = new MonstroNormal("Leão Congelado","Um dos guardiões da montanha", 85,65);
        lc.addItemATK(harpal);
        lc.addItemDEF(jubac);
        MonstroNormal  goleng= new MonstroNormal("Golem de Gelo","Criatura formada apenas de gelo", 60,90);
        goleng.addItemATK(estacagel);
        goleng.addItemDEF(escudogel);
        Chefao  abomh= new Chefao("Abominável Homem das Neves","Em lugares não gelados é chamado de Pé Grande",110,115,"Tudo que este monstro não quer é ser visto, no caminho pela montanha você o observou e seguiu até que ele percebesse que estava lá");
        abomh.addItemATK(furacaogel);
        abomh.addItemDEF(nevep);
        
        MonstroNormal espc= new MonstroNormal("Espírito das Chamas","Uma chama de fogo viva ", 90,70);
        espc.addItemATK(triquei);
        espc.addItemDEF(escudocinz);
        MonstroNormal  fenix= new MonstroNormal("Fênix","Pássaro de fogo muito poderoso com a habilidade de renascer das cinzas após um período de tempo, é bom derrota-lo e correr", 85,75);
        fenix.addItemATK(arcofogo);
        fenix.addItemDEF(armadurachamav);
        Chefao dragao= new Chefao("Dragão de Fogo","Dragão com a pele tão forte quanto metal e bafo tão quente quanto um vulcão",125,120,"Todos os dragões gostam de riquezas, após descobrir uma montanha que possuía um grande tesouro resolveu toma-lo para si e até hoje, séculos depois o protege com sua vida ");
        dragao.addItemATK(espadaflam);
        dragao.addItemDEF(couradrag);
        
        MonstroNormal cavcab = new MonstroNormal("Cavaleiro sem Cabeça","Um nobre cavaleiro que perdeu a cabeça com o que estava acontecendo na época  ", 85,85);
        cavcab.addItemATK(lancacav);
        cavcab.addItemDEF(cabecaflam);
        MonstroNormal  hidra= new MonstroNormal("Hidra","Monstro de várias cabeças, quando uma é cortada nascem duas em seu lugar", 100,70);
        hidra.addItemATK(cabechidra);
        hidra.addItemDEF(escamahidra);
        Chefao quimera= new Chefao("Quimera","Não somente um monstro, sua inteligência cativa e apavora muitos",115,150,"Sempre teve como objetivo sair do abismo para poder estudar alguma forma transformar seu corpo à sua vontade, busca aventureiros com itens poderosos que possam tirá-lo de lá");
        quimera.addItemATK(caudasq);
        quimera.addItemDEF(cerebroquim);
        
        MonstroNormal maxxor = new MonstroNormal("Maxxor","Um monstro verde que pode habitar tanto em ambiente aquático quanto terrestre, suas habilidades consistem em usar sua alma para invocar feitiços", 145,130);
        maxxor.addItemATK(chuvap);
        maxxor.addItemDEF(cancaop);
        MonstroNormal cavm = new MonstroNormal("Cavalo Marinho Perverso","Nunca tente cavalgar em um desses ", 120,155);
        cavm.addItemATK(ferraduraaco);
        cavm.addItemDEF(chifrecav);
        Chefao  cthulhu= new Chefao("Cthulhu","Criatura milenar, boatos que ele foi criada junto com o planeta, ou quem sabe ele criou o próprio planeta",150,150,"Cthulhu achou esse RPG um jogo de criança e cansou de ficar nas sombras, agora pretende te matar com apenas 1 ataque e continuar com seus planos");
        cthulhu.addItemATK(tentaculoc);
        cthulhu.addItemDEF(tentaculocd);
        
        MonstroNormal  anjc= new MonstroNormal("Anjo Caído","Antigamente chamavam este ser de Deus", 140,145);
        anjc.addItemATK(espnegra);
        anjc.addItemDEF(assasanjo);
        MonstroNormal necrom = new MonstroNormal("Necromancer","O braço direito do Rei dos Demônios conhecido pelos seus feitos históricos em prol das forças do mal", 155,140);
        necrom.addItemATK(cajdonecromante);
        necrom.addItemDEF(capanecromante);
        Chefao  reidem= new Chefao("Rei Demônio","Durante a criação do universo todas as impurezas dos mundos foram armazenadas em um só local, dando vida ao ser mais diabólico que existe, até o Deus mais poderoso foi subjugado por ele",150,150," Dominar tudo e a todos é a motivação do ser supremo ");
        reidem.addItemATK(presennsup);
        reidem.addItemDEF(presensupr);
        

        
        //Cadastrando Classes para listá-las depois.
        guerreiro.addItemAtk(martelo);
        guerreiro.addItemDef(escudoRag);
        CadastrarClasse.addClasse(guerreiro);
        
        arqueiro.addItemAtk(arco);
        arqueiro.addItemDef(escudoElf);
        CadastrarClasse.addClasse(arqueiro);
        
        ladino.addItemAtk(lamina);
        ladino.addItemDef(cotaMalha);
        CadastrarClasse.addClasse(ladino);
        
        mago.addItemAtk(cetro);
        mago.addItemDef(escudoEner);
        CadastrarClasse.addClasse(mago);
        
        // cadastrando e listando fases
        PadraodasFases fase1 = new PadraodasFases("Caverna Escura","Em sua primeira aventura nada melhor do que chegar as cavernas ao redor da vila", 1);
        CadastrarFase.addMonstroNormal(goblin);
        CadastrarFase.addMonstroNormal(slime);
        CadastrarFase.addChefao(ogro);
        CadastrarFase.addFase(fase1);
        
        PadraodasFases fase2 = new PadraodasFases("Floresta do Pesadelo","Confunde aventureiros novatos facilmente ", 2);
        CadastrarFase.addMonstroNormal(morcss);
        CadastrarFase.addMonstroNormal(arann);
        CadastrarFase.addChefao(hiena);
        CadastrarFase.addFase(fase2);

        PadraodasFases fase3 = new PadraodasFases("Torre dos Ventos Uivantes","Antes conhecida como Torre da Sabedoria, caiu em desespero após uma breve visita do Necromancer", 3);
        CadastrarFase.addMonstroNormal(espec);
        CadastrarFase.addMonstroNormal(garg);
        CadastrarFase.addChefao(magoc);
        CadastrarFase.addFase(fase3);

        PadraodasFases fase4 = new PadraodasFases("Deserto do Desespero","Dizem que é possível ver vários oásis nesse local, seriam miragens?", 4);
        CadastrarFase.addMonstroNormal(escpv);
        CadastrarFase.addMonstroNormal(verme);
        CadastrarFase.addChefao(anub);
        CadastrarFase.addFase(fase4);

        PadraodasFases fase5 = new PadraodasFases("Ilha Esquecida","O tempo parou nessa ilha, é possível encontrar as mais primitivas formas de vida por lá", 5);
        CadastrarFase.addMonstroNormal(tigreb);
        CadastrarFase.addMonstroNormal(gorila);
        CadastrarFase.addChefao(rex);
        CadastrarFase.addFase(fase5);

        PadraodasFases fase6 = new PadraodasFases("Montanha Congelada","É a divisa entre dois países, aventureiros novatos que passam por lá podem se considerar intermediários", 6);
        CadastrarFase.addMonstroNormal(lc);
        CadastrarFase.addMonstroNormal(goleng);
        CadastrarFase.addChefao(abomh);
        CadastrarFase.addFase(fase6);

        PadraodasFases fase7 = new PadraodasFases("Vulcão da Discórdia","Após a posse de um Dragão muito poderoso a montanha que antes possuía uma vasta fauna e flora agora é um vulcão perigoso", 7);
        CadastrarFase.addMonstroNormal(espc);
        CadastrarFase.addMonstroNormal(fenix);
        CadastrarFase.addChefao(dragao);
        CadastrarFase.addFase(fase7);

        PadraodasFases fase8 = new PadraodasFases("Profundezas do Abismo","Lugar onde lendas se tornam reais", 8);
        CadastrarFase.addMonstroNormal(cavcab);
        CadastrarFase.addMonstroNormal(hidra);
        CadastrarFase.addChefao(quimera);
        CadastrarFase.addFase(fase8);

        PadraodasFases fase9 = new PadraodasFases("Cosmos Submerso","Após finalmente estar próximo do seu Destino Final, você foi teletransportado para um lugar simplesmente inexplicável, parece estar de baixo da agua, onde para qualquer lugar que você olhe só ache tentáculos, por que será?", 9);
        CadastrarFase.addMonstroNormal(maxxor);
        CadastrarFase.addMonstroNormal(cavm);
        CadastrarFase.addChefao(cthulhu);
        CadastrarFase.addFase(fase9);

        PadraodasFases fase10 = new PadraodasFases("Torre do Rei Demônio","O centro de tudo que é ruim, poucos conseguiram o adentrar porém ninguém saiu", 10);
        CadastrarFase.addMonstroNormal(anjc);
        CadastrarFase.addMonstroNormal(necrom);
        CadastrarFase.addChefao(reidem);
        CadastrarFase.addFase(fase10);

        //Cadastrando Jogador- INICIO DO JOGO
        System.out.println(">>>>>>>>>>>>>>> BREAKING THE SPACE TIME !! <<<<<<<<<<<<<<<");
        System.out.println("Bem vindo ao RPG que reúne todas mitologias e crenças em um só jogo, por favor, complete as informações abaixo.");
        Scanner in = new Scanner(System.in);
        System.out.print("Digite o seu Nome: ");
        String nome = in.nextLine();
        System.out.print("Digite sua idade: ");
        int idade = in.nextInt();
        System.out.println("Escolha uma das classes abaixo: ");
        ListarClasse.listarClasse();
        
        PadraoDoJogador jogador = null;
        int danoClasse;
        int escudoClasse;
        int danoItem;
        int escudoItem;
        int danoTotal = 0;
        int escudoTotal = 0;
        int saude;
        String escolhaCla = null;
        Scanner on = new Scanner(System.in);
        System.out.println("\nOlá "+nome+" !!");
        if (idade<21){
            System.out.println("Você parece um pouco novo para adentrar nessa aventura, mas já que insiste...");
        }else if (idade>=21){
            System.out.println("Ora, parece que temos um experiente aqui, pelo menos na idade.. agora resta saber se provará suas habilidades ou não, hmm...");
        }
        
        while (true){
            System.out.print("\nDigite o nome da Classe que escolheu: ");
            escolhaCla = on.nextLine();
            if (escolhaCla.equalsIgnoreCase("guerreiro")){
                jogador = new PadraoDoJogador(nome,idade,100,1,0); //nome,idade,saude,level,moeda;
                jogador.addClasse(guerreiro);
                break;
            }
            else if (escolhaCla.equalsIgnoreCase("arqueiro")){
                jogador = new PadraoDoJogador(nome,idade,100,1,0);
                jogador.addClasse(arqueiro);
                break;
            }
            else if (escolhaCla.equalsIgnoreCase("ladino")){
                jogador = new PadraoDoJogador(nome,idade,100,1,0);
                jogador.addClasse(ladino);
                break;
            }
            else if (escolhaCla.equalsIgnoreCase("mago")){
                jogador = new PadraoDoJogador(nome,idade,100,1,0);
                jogador.addClasse(mago);
                break;
            }
        }
        System.out.println("\n**********************************************************************************");
        System.out.println("Classe escolhida: "+escolhaCla);
        danoClasse = jogador.getClasses().get(0).getForca();
        escudoClasse = jogador.getClasses().get(0).getDefesa();
        danoItem = jogador.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk();
        escudoItem = jogador.getClasses().get(0).getItemDef().get(0).getEscudo();
        saude = jogador.getSaude();
        danoTotal = danoClasse + danoItem;
        escudoTotal = escudoClasse + escudoItem + saude;
        System.out.println("Sua Saúde começa em 100, você consegue aumentá-la conforme passa de Level.");
        System.out.println("Dano Total = "+danoTotal);
        System.out.println("Escudo total = "+escudoTotal);
        System.out.println("**********************************************************************************");
        
        System.out.println("\nAgora você estará entrando na primeira fase, leia atentamente as informações, pois terá que fazer uma escolha entre os 2 monstros normais.");
        System.out.println("Lembre-se que de acordo com o Monstro que você matar, ele irá dropar seus itens, você só poderá escolher pegar de Atk ou Def, e se pegar, ele substituirá seu atual.");
        int escudoEnfrentBoss = 0;
        //FASE 1
//>>>>>>>>>>>>>>>>>>COMEÇA AQUI ONDE VOCÊ IRÁ COPIAR A LÓGICA PARA COLAR MAIS EMBAIXO NAS OUTRAS FASES.
        ListarFase.listarFase(0,0,1); //PRIMEIRO VC PASSA O INDICE DA FASE, DPS O INDICE DO PRIMEIRO MONTRO, E EM SEGUIDA DO SEGUNDO... isso não lista o chefão, pra ficar mais legal pro jogador só descobrir após derrotar um dos monstros normais.
        while(true){ //Este while é super importante pois permite que voce possa errar o nome do monstro varias vezes, até acertar um dos dois.
            System.out.print("\nDigite qual monstro deseja atacar (sem acentos e sem \"ç\"): ");
            String escolhaMonstro;
            escolhaMonstro = on.nextLine();
            /*int forcaMonstro;
            int escudoMonstro;
            int indiceMonstro;*/
            if (escolhaMonstro.equalsIgnoreCase("goblin")){
                escudoEnfrentBoss = batalha(jogador,0,espadaGob,armaduraPano); //toda lógica da batalha esta simplesmente nisso kkk
                break;
                }
            else if (escolhaMonstro.equalsIgnoreCase("slime bebe")){
                escudoEnfrentBoss = batalha(jogador,1,ossoRat,escudoGosm);//esse número vai aumentando conforme a ordem em que adicionamos os monstros
                break;
            }      
        }

        System.out.println("\nParece que você conseguiu passar do primeiro Monstro, eu acabei de perder minha aposta, mas quero ver se consegue derrubar o grandão agora...");
        ListarFase.listarChefaoDaFase(0);//este índice 0 é pq é a primeira fase, depois é so ir aumentando nas outras
        batalhaBoss(jogador,0,porreteOgro,tangaOgro,escudoEnfrentBoss);
        try { Thread.sleep (500); } catch (InterruptedException ex) {}
        System.out.println(".");
        try { Thread.sleep (500); } catch (InterruptedException ex) {}
        System.out.println("..");
        try { Thread.sleep (500); } catch (InterruptedException ex) {}
        System.out.println("... éééérrr, parece que você conseguiu não é mesmo, tudo bem, o mérito foi seu, porém não se acostume, já que foi claramente sorte de principiante, e a partir daqui as coisas vão ficar mais desafiadoras hmm..");
        System.out.println("Pelo jeito você está com sorte mesmo, acabaram de me dizer aqui que a cada Chefe derrotado você passa de Level e recupera vida kkkk da prá acreditar? Pois é, estão pegando leve com você aparentemente.");
        jogador.setMoeda(10);
        jogador.setLevel(2);
        jogador.setSaude(200);
        danoClasse = jogador.getClasses().get(0).getForca();
        escudoClasse = jogador.getClasses().get(0).getDefesa();
        danoItem = jogador.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk();
        escudoItem = jogador.getClasses().get(0).getItemDef().get(0).getEscudo();
        saude = jogador.getSaude();
        danoTotal = danoClasse + danoItem;
        escudoTotal = escudoClasse + escudoItem + saude;
        jogador.listarJogadorPosBoss(jogador);
        System.out.println("******************************");
        System.out.println("Dano Total = "+danoTotal);
        System.out.println("Escudo total = "+escudoTotal);
        System.out.println("******************************");
//FECHA AQUI A LÓGICA ONDE VC PRECISA COPIAR PRA FASER AS PROXIMAS FASES<<<<<<<<<<<<<<<<<<<<<<<<

        //FASE 2
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Entrando na Fase 2...");
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        ListarFase.listarFase(1, 2, 3); //(int IndiceFase, int IndiceMonstro1, int IndiceMonstro2) 
        while(true){ //Este while é super importante pois permite que voce possa errar o nome do monstro varias vezes, até acertar um dos dois.
            System.out.print("\nDigite qual monstro deseja atacar (sem acentos e sem \"ç\"): ");
            String escolhaMonstro;
            escolhaMonstro = on.nextLine();
            /*int forcaMonstro;
            int escudoMonstro;
            int indiceMonstro;*/
            if (escolhaMonstro.equalsIgnoreCase("morcego sanguessuga")){
                escudoEnfrentBoss = batalha(jogador,2,presasmorc,pelodemorce); //toda lógica da batalha esta simplesmente nisso kkk
                break;
                }
            else if (escolhaMonstro.equalsIgnoreCase("aranha negra")){
                escudoEnfrentBoss = batalha(jogador,3,queliceras,exoaranha);//esse número vai aumentando conforme a ordem em que adicionamos os monstros
                break;
            }      
        }
        System.out.println("\nOlha, acho que temos alguém com um pouco de esperança aqui em kkkkkkk. se eu fosse você desistia...");
        ListarFase.listarChefaoDaFase(1);//este índice 0 é pq é a primeira fase, depois é so ir aumentando nas outras
        batalhaBoss(jogador,1,machadohiena,armadurahiena, escudoEnfrentBoss);
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Olha só, parece que temos um experiente mirim aqui, já que ainda não pretende desistir eu vou te insultar um pouco menos, ta ok?");
        jogador.setMoeda(20);
        jogador.setLevel(3);
        jogador.setSaude(300);
        danoClasse = jogador.getClasses().get(0).getForca();
        escudoClasse = jogador.getClasses().get(0).getDefesa();
        danoItem = jogador.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk();
        escudoItem = jogador.getClasses().get(0).getItemDef().get(0).getEscudo();
        saude = jogador.getSaude();
        danoTotal = danoClasse + danoItem;
        escudoTotal = escudoClasse + escudoItem + saude;
        jogador.listarJogadorPosBoss(jogador);
        System.out.println("******************************");
        System.out.println("Dano Total = "+danoTotal);
        System.out.println("Escudo total = "+escudoTotal);
        System.out.println("******************************");
        //fim da fase
        
        //FASE 3
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Entrando na Fase 3...");
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        ListarFase.listarFase(2, 4, 5); //(int IndiceFase, int IndiceMonstro1, int IndiceMonstro2) 
        while(true){ //Este while é super importante pois permite que voce possa errar o nome do monstro varias vezes, até acertar um dos dois.
            System.out.print("\nDigite qual monstro deseja atacar (sem acentos e sem \"ç\"): ");
            String escolhaMonstro;
            escolhaMonstro = on.nextLine();
            /*int forcaMonstro;
            int escudoMonstro;
            int indiceMonstro;*/
            if (escolhaMonstro.equalsIgnoreCase("espectro")){
                escudoEnfrentBoss = batalha(jogador,4,almafa,poeiraf); //toda lógica da batalha esta simplesmente nisso kkk
                break;
                }
            else if (escolhaMonstro.equalsIgnoreCase("gargula")){
                escudoEnfrentBoss = batalha(jogador,5,lascadep,armaduradep);//esse número vai aumentando conforme a ordem em que adicionamos os monstros
                break;
            }      
        }
        System.out.println("\nHm, você esta começando a se mostrar alguém interessante..");
        ListarFase.listarChefaoDaFase(2);//este índice 0 é pq é a primeira fase, depois é so ir aumentando nas outras
        batalhaBoss(jogador,2,cajmag,vestesmag,escudoEnfrentBoss);
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Até que foi divertido ver de camarote essa batalha kkk");
        jogador.setMoeda(30);
        jogador.setLevel(4);
        jogador.setSaude(400);
        danoClasse = jogador.getClasses().get(0).getForca();
        escudoClasse = jogador.getClasses().get(0).getDefesa();
        danoItem = jogador.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk();
        escudoItem = jogador.getClasses().get(0).getItemDef().get(0).getEscudo();
        saude = jogador.getSaude();
        danoTotal = danoClasse + danoItem;
        escudoTotal = escudoClasse + escudoItem + saude;
        jogador.listarJogadorPosBoss(jogador);
        System.out.println("******************************");
        System.out.println("Dano Total = "+danoTotal);
        System.out.println("Escudo total = "+escudoTotal);
        System.out.println("******************************");
        //fim da fase
        
        //FASE 4
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Entrando na Fase 4...");
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        ListarFase.listarFase(3, 6, 7); //(int IndiceFase, int IndiceMonstro1, int IndiceMonstro2) 
        while(true){ //Este while é super importante pois permite que voce possa errar o nome do monstro varias vezes, até acertar um dos dois.
            System.out.print("\nDigite qual monstro deseja atacar (sem acentos e sem \"ç\"): ");
            String escolhaMonstro;
            escolhaMonstro = on.nextLine();
            /*int forcaMonstro;
            int escudoMonstro;
            int indiceMonstro;*/
            if (escolhaMonstro.equalsIgnoreCase("escorpiao vermelho")){
                escudoEnfrentBoss = batalha(jogador,6,ferraoven,carapver); //toda lógica da batalha esta simplesmente nisso kkk
                break;
                }
            else if (escolhaMonstro.equalsIgnoreCase("verme de areia do deserto")){
                escudoEnfrentBoss = batalha(jogador,7,dentesg,areiap);//esse número vai aumentando conforme a ordem em que adicionamos os monstros
                break;
            }      
        }
        System.out.println("\nOlha só, acho que estava mesmo te subestimando, éer parabéns pela Vitória");
        ListarFase.listarChefaoDaFase(3);//este índice 0 é pq é a primeira fase, depois é so ir aumentando nas outras
        batalhaBoss(jogador,3,bastaodam,sarcofagop,escudoEnfrentBoss);
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Ual, você conseguiu mesmo matar o Anubis, eu morria de medo desse cara, como eu posso dizer,.. Obrigado!!");
        jogador.setMoeda(40);
        jogador.setLevel(5);
        jogador.setSaude(500);
        danoClasse = jogador.getClasses().get(0).getForca();
        escudoClasse = jogador.getClasses().get(0).getDefesa();
        danoItem = jogador.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk();
        escudoItem = jogador.getClasses().get(0).getItemDef().get(0).getEscudo();
        saude = jogador.getSaude();
        danoTotal = danoClasse + danoItem;
        escudoTotal = escudoClasse + escudoItem + saude;
        jogador.listarJogadorPosBoss(jogador);
        System.out.println("******************************");
        System.out.println("Dano Total = "+danoTotal);
        System.out.println("Escudo total = "+escudoTotal);
        System.out.println("******************************");
        //fim da fase
        
        //FASE 5
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Entrando na Fase 5...");
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        ListarFase.listarFase(4, 8, 9); //(int IndiceFase, int IndiceMonstro1, int IndiceMonstro2) 
        while(true){ //Este while é super importante pois permite que voce possa errar o nome do monstro varias vezes, até acertar um dos dois.
            System.out.print("\nDigite qual monstro deseja atacar (sem acentos e sem \"ç\"): ");
            String escolhaMonstro;
            escolhaMonstro = on.nextLine();
            /*int forcaMonstro;
            int escudoMonstro;
            int indiceMonstro;*/
            if (escolhaMonstro.equalsIgnoreCase("tigre dente de sabre branco")){
                escudoEnfrentBoss = batalha(jogador,8,dentedes,tunicab); //toda lógica da batalha esta simplesmente nisso kkk
                break;
                }
            else if (escolhaMonstro.equalsIgnoreCase("gorila gigante")){
                escudoEnfrentBoss = batalha(jogador,9,maodeg,escudodec);//esse número vai aumentando conforme a ordem em que adicionamos os monstros
                break;
            }      
        }
        System.out.println("\nCaramba, cuidado pois de agora em diante os monstros antes do Boss ficam cada vez mais fortes");
        ListarFase.listarChefaoDaFase(4);//este índice 0 é pq é a primeira fase, depois é so ir aumentando nas outras
        batalhaBoss(jogador,4,bastaorex,esqueletoj,escudoEnfrentBoss);
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Parece que alguém vai poder vender uns ossos de dinossouro pra fazer uma grana kkk");
        jogador.setMoeda(50);
        jogador.setLevel(6);
        jogador.setSaude(600);
        danoClasse = jogador.getClasses().get(0).getForca();
        escudoClasse = jogador.getClasses().get(0).getDefesa();
        danoItem = jogador.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk();
        escudoItem = jogador.getClasses().get(0).getItemDef().get(0).getEscudo();
        saude = jogador.getSaude();
        danoTotal = danoClasse + danoItem;
        escudoTotal = escudoClasse + escudoItem + saude;
        jogador.listarJogadorPosBoss(jogador);
        System.out.println("******************************");
        System.out.println("Dano Total = "+danoTotal);
        System.out.println("Escudo total = "+escudoTotal);
        System.out.println("******************************");
        //fim da fase

        //FASE 6
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Entrando na Fase 6...");
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        ListarFase.listarFase(5, 10, 11); //(int IndiceFase, int IndiceMonstro1, int IndiceMonstro2) 
        while(true){ //Este while é super importante pois permite que voce possa errar o nome do monstro varias vezes, até acertar um dos dois.
            System.out.print("\nDigite qual monstro deseja atacar (sem acentos e sem \"ç\"): ");
            String escolhaMonstro;
            escolhaMonstro = on.nextLine();
            /*int forcaMonstro;
            int escudoMonstro;
            int indiceMonstro;*/
            if (escolhaMonstro.equalsIgnoreCase("leao congelado")){
                escudoEnfrentBoss = batalha(jogador,10,harpal,jubac); //toda lógica da batalha esta simplesmente nisso kkk
                break;
                }
            else if (escolhaMonstro.equalsIgnoreCase("golem de gelo")){
                escudoEnfrentBoss = batalha(jogador,11,estacagel,escudogel);//esse número vai aumentando conforme a ordem em que adicionamos os monstros
                break;
            }      
        }
        System.out.println("\nBoa Amig... ée posso te chamar disso?");
        ListarFase.listarChefaoDaFase(5);//este índice 0 é pq é a primeira fase, depois é so ir aumentando nas outras
        batalhaBoss(jogador,5,furacaogel,nevep,escudoEnfrentBoss);
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Hahaha você acabou com ele, muito bom parceiro!!");
        jogador.setMoeda(60);
        jogador.setLevel(7);
        jogador.setSaude(700);
        danoClasse = jogador.getClasses().get(0).getForca();
        escudoClasse = jogador.getClasses().get(0).getDefesa();
        danoItem = jogador.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk();
        escudoItem = jogador.getClasses().get(0).getItemDef().get(0).getEscudo();
        saude = jogador.getSaude();
        danoTotal = danoClasse + danoItem;
        escudoTotal = escudoClasse + escudoItem + saude;
        jogador.listarJogadorPosBoss(jogador);
        System.out.println("******************************");
        System.out.println("Dano Total = "+danoTotal);
        System.out.println("Escudo total = "+escudoTotal);
        System.out.println("******************************");
        //fim da fase

        //FASE 7
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Entrando na Fase 7...");
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        ListarFase.listarFase(6, 12, 13); //(int IndiceFase, int IndiceMonstro1, int IndiceMonstro2) 
        while(true){ //Este while é super importante pois permite que voce possa errar o nome do monstro varias vezes, até acertar um dos dois.
            System.out.print("\nDigite qual monstro deseja atacar (sem acentos e sem \"ç\"): ");
            String escolhaMonstro;
            escolhaMonstro = on.nextLine();
            /*int forcaMonstro;
            int escudoMonstro;
            int indiceMonstro;*/
            if (escolhaMonstro.equalsIgnoreCase("espirito das chamas")){
                escudoEnfrentBoss = batalha(jogador,12,triquei,escudocinz); //toda lógica da batalha esta simplesmente nisso kkk
                break;
                }
            else if (escolhaMonstro.equalsIgnoreCase("fenix")){
                escudoEnfrentBoss = batalha(jogador,13,arcofogo,armadurachamav);//esse número vai aumentando conforme a ordem em que adicionamos os monstros
                break;
            }      
        }
        System.out.println("\nNice amigo, agora acaba com a raça desse Boss !! hehe");
        ListarFase.listarChefaoDaFase(6);//este índice 0 é pq é a primeira fase, depois é so ir aumentando nas outras
        batalhaBoss(jogador,6,espadaflam,couradrag,escudoEnfrentBoss);
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Mais uma criatura das antigas pra conta em kkk, muito bom !!");
        jogador.setMoeda(70);
        jogador.setLevel(8);
        jogador.setSaude(800);
        danoClasse = jogador.getClasses().get(0).getForca();
        escudoClasse = jogador.getClasses().get(0).getDefesa();
        danoItem = jogador.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk();
        escudoItem = jogador.getClasses().get(0).getItemDef().get(0).getEscudo();
        saude = jogador.getSaude();
        danoTotal = danoClasse + danoItem;
        escudoTotal = escudoClasse + escudoItem + saude;
        jogador.listarJogadorPosBoss(jogador);
        System.out.println("******************************");
        System.out.println("Dano Total = "+danoTotal);
        System.out.println("Escudo total = "+escudoTotal);
        System.out.println("******************************");
        //fim da fase
        
        //FASE 8
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Entrando na Fase 8...");
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        ListarFase.listarFase(7, 14, 15); //(int IndiceFase, int IndiceMonstro1, int IndiceMonstro2) 
        while(true){ //Este while é super importante pois permite que voce possa errar o nome do monstro varias vezes, até acertar um dos dois.
            System.out.print("\nDigite qual monstro deseja atacar (sem acentos e sem \"ç\"): ");
            String escolhaMonstro;
            escolhaMonstro = on.nextLine();
            /*int forcaMonstro;
            int escudoMonstro;
            int indiceMonstro;*/
            if (escolhaMonstro.equalsIgnoreCase("cavaleiro sem cabeca")){
                escudoEnfrentBoss = batalha(jogador,14,lancacav,cabecaflam); //toda lógica da batalha esta simplesmente nisso kkk
                break;
                }
            else if (escolhaMonstro.equalsIgnoreCase("hidra")){
                escudoEnfrentBoss = batalha(jogador,15,cabechidra,escamahidra);//esse número vai aumentando conforme a ordem em que adicionamos os monstros
                break;
            }      
        }
        System.out.println("\nBoa amigo, mas por favor tome muito cuidado pois algo me indica que você está cada vez mais próximo do .. FIM !!");
        ListarFase.listarChefaoDaFase(7);//este índice 0 é pq é a primeira fase, depois é so ir aumentando nas outras
        batalhaBoss(jogador,7,caudasq,cerebroquim,escudoEnfrentBoss);
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Parceiro, eu estou ficando com mau pressentimento, preste muita atenção em suas proximas batalhas, não quero perder meu único amigo..");
        jogador.setMoeda(80);
        jogador.setLevel(9);
        jogador.setSaude(900);
        danoClasse = jogador.getClasses().get(0).getForca();
        escudoClasse = jogador.getClasses().get(0).getDefesa();
        danoItem = jogador.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk();
        escudoItem = jogador.getClasses().get(0).getItemDef().get(0).getEscudo();
        saude = jogador.getSaude();
        danoTotal = danoClasse + danoItem;
        escudoTotal = escudoClasse + escudoItem + saude;
        jogador.listarJogadorPosBoss(jogador);
        System.out.println("******************************");
        System.out.println("Dano Total = "+danoTotal);
        System.out.println("Escudo total = "+escudoTotal);
        System.out.println("******************************");
        //fim da fase
        
        //FASE 9
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Entrando na Fase 9...");
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        ListarFase.listarFase(8, 16, 17); //(int IndiceFase, int IndiceMonstro1, int IndiceMonstro2) 
        while(true){ //Este while é super importante pois permite que voce possa errar o nome do monstro varias vezes, até acertar um dos dois.
            System.out.print("\nDigite qual monstro deseja atacar (sem acentos e sem \"ç\"): ");
            String escolhaMonstro;
            escolhaMonstro = on.nextLine();
            /*int forcaMonstro;
            int escudoMonstro;
            int indiceMonstro;*/
            if (escolhaMonstro.equalsIgnoreCase("maxxor")){
                escudoEnfrentBoss = batalha(jogador,16,chuvap,cancaop); //toda lógica da batalha esta simplesmente nisso kkk
                break;
                }
            else if (escolhaMonstro.equalsIgnoreCase("cavalo marinho perverso")){
                escudoEnfrentBoss = batalha(jogador,17,ferraduraaco,chifrecav);//esse número vai aumentando conforme a ordem em que adicionamos os monstros
                break;
            }      
        }
        System.out.println("\nEST..CO..DIFICUL...DE..ME..COMUNIC...CO...VOCE..SOCORRO!...");
        ListarFase.listarChefaoDaFase(8);//este índice 0 é pq é a primeira fase, depois é so ir aumentando nas outras
        batalhaBoss(jogador,8,tentaculoc,tentaculocd,escudoEnfrentBoss);
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("SE..VOC..ESTI...LEND..ISS..SAIBA..QU..EU..NUNC..ESQUECEREI..OBRIGAD..POR..TUDO..");
        jogador.setMoeda(90);
        jogador.setLevel(10);
        jogador.setSaude(1000);
        danoClasse = jogador.getClasses().get(0).getForca();
        escudoClasse = jogador.getClasses().get(0).getDefesa();
        danoItem = jogador.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk();
        escudoItem = jogador.getClasses().get(0).getItemDef().get(0).getEscudo();
        saude = jogador.getSaude();
        danoTotal = danoClasse + danoItem;
        escudoTotal = escudoClasse + escudoItem + saude;
        jogador.listarJogadorPosBoss(jogador);
        System.out.println("******************************");
        System.out.println("Dano Total = "+danoTotal);
        System.out.println("Escudo total = "+escudoTotal);
        System.out.println("******************************");
        //fim da fase
        
        //FASE 10
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Entrando na Fase 10...");
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        ListarFase.listarFase(9, 18, 19); //(int IndiceFase, int IndiceMonstro1, int IndiceMonstro2) 
        while(true){ //Este while é super importante pois permite que voce possa errar o nome do monstro varias vezes, até acertar um dos dois.
            System.out.print("\nDigite qual monstro deseja atacar (sem acentos e sem \"ç\"): ");
            String escolhaMonstro;
            escolhaMonstro = on.nextLine();
            /*int forcaMonstro;
            int escudoMonstro;
            int indiceMonstro;*/
            if (escolhaMonstro.equalsIgnoreCase("anjo caido")){
                escudoEnfrentBoss = batalha(jogador,18,espnegra,assasanjo); //toda lógica da batalha esta simplesmente nisso kkk
                break;
                }
            else if (escolhaMonstro.equalsIgnoreCase("necromancer")){
                escudoEnfrentBoss = batalha(jogador,19,cajdonecromante,capanecromante);//esse número vai aumentando conforme a ordem em que adicionamos os monstros
                break;
            }      
        }
        System.out.println("\n...\"barulhos estáticos\" ...");
        ListarFase.listarChefaoDaFase(9);//este índice 0 é pq é a primeira fase, depois é so ir aumentando nas outras
        batalhaBoss(jogador,9,presennsup,presensupr,escudoEnfrentBoss);
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.println("Não consigo acreditar CONSEGUIMOS !!! Muito obrigado por me salvar, e salvar o Mundo "+ nome+" você foi o melhor amigo que eu já tive, agora podemos COMEMORAR !!!");
        System.out.println("Estatísticas Finais Abaixo, Parabéns Pela Vitória !!");
        jogador.setMoeda(90);
        jogador.setLevel(11);
        jogador.setSaude(1100);
        danoClasse = jogador.getClasses().get(0).getForca();
        escudoClasse = jogador.getClasses().get(0).getDefesa();
        danoItem = jogador.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk();
        escudoItem = jogador.getClasses().get(0).getItemDef().get(0).getEscudo();
        saude = jogador.getSaude();
        danoTotal = danoClasse + danoItem;
        escudoTotal = escudoClasse + escudoItem + saude;
        jogador.listarJogadorPosBoss(jogador);
        System.out.println("******************************");
        System.out.println("Dano Total = "+danoTotal);
        System.out.println("Escudo total = "+escudoTotal);
        System.out.println("******************************");
        //fim da fase
        
    }
    
}
