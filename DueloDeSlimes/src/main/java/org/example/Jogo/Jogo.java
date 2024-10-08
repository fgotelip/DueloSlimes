package org.example.Jogo;
import java.util.Scanner;


public class Jogo {

    private void vidasAtuais(Criatura a, Criatura b) {
        System.out.println("Vida atual dos slimes: A="+a.getVida()+" B="+b.getVida());
    }

    private boolean turnoDe(String jogador, Criatura player, Criatura opponent, boolean[] especialDragaoP, boolean[] especialDragaoO) {
        double energia = player.getEnergia();
        double vidaOpponent = opponent.getVida();

        especialDragaoP[0] = false;

        Scanner teclado = new Scanner(System.in);
        boolean verdade, naoEncerra = true;

        while(energia>0 && vidaOpponent>0 && naoEncerra) {
                System.out.println("---------------------\nTURNO DO SLIME " + jogador + "\n---------------------\n" );

                if (jogador.equals("A"))
                    vidasAtuais(player, opponent);
                else if (jogador.equals("B"))
                    vidasAtuais(opponent, player);

                System.out.println("Digite a habilidade para o slime " + jogador + " usar:" +
                        " (energia restante: " + player.getEnergia() + ")\n1: Ataque(custo:1" +
                        " de energia; dano causado:multiplicador + E - resistência\npor " +
                        "padrão multiplicador=1,E=0 e resistência=0)\n2: Energizar(custo:2" +
                        " de energia; E=0.5 naquele turno)\n3: Especial(custo:4 de energia;" +
                        player.getDescricaoEspecial() + "\n0: Passa a vez");

                verdade = true;
                while (verdade) {
                    try {
                        int habilidade = teclado.nextInt();
                        verdade = false;
                        switch (habilidade) {
                            case 1:
                                player.ataque(opponent);
                                break;
                            case 2:
                                player.energizar();
                                break;
                            case 3:
                                if(player instanceof Dragao){
                                    player.especial(opponent);
                                    especialDragaoP[0]=true;
                                    break;
                                }
                                player.especial(opponent);
                                break;
                            case 0:
                                naoEncerra = false;
                                break;
                            default:
                                verdade = true;
                                System.out.println("Digite um valor de habilidade válido:");
                                break;
                        }
                    } catch (Exception e) {
                        teclado.next();
                        System.out.println("Digite um valor de habilidade válido:");
                    }
                }
                energia = player.getEnergia();
                vidaOpponent = opponent.getVida();
        }
        if(especialDragaoP[0]) {
            ((Dragao)player).setEnergiaTurno(player.getEnergia());
        }

        if(vidaOpponent<=0 && !especialDragaoO[0]){
            return true;
        }
        return false;
    }

    private Criatura escolheAncestral(String player){
        Scanner teclado = new Scanner(System.in);

        boolean verdade = true;
        Criatura criatura = null;
        while(verdade) {
            System.out.println("Escolha o ancestral do slime "+player+": ");
            try {
                int ancestral = teclado.nextInt();
                verdade = false;
                switch(ancestral) {
                    case 1: return criatura = new Vampiro();
                    case 2: return criatura = new Dragao();
                    case 3: return criatura = new Sereia();
                    case 4: return criatura = new Anjo();
                    case 5: return criatura = new Demonio();
                    default: verdade = true;
                }
            } catch (Exception e) {
                teclado.next();
            }
        }
        return null;
    }


    public void jogar(){
        System.out.println("Bem vindo ao Jogo dos slimes!\n\nRegras:\n\n" +
                "Cada slime começa com vida=10 e energia=5.\nUm turno de jogada dura" +
                " enquanto ainda tiver energia disponível para gastar ou for escolhido" +
                " passar a vez.\nO jogo acaba quando a vida de algum slime for igual a 0.\n\n" +
                "As habilidades padrão disponíveis são:\n1: Ataque(custo:1 de energia" +
                "; dano causado:multiplicador + E - resistência\npor padrão multiplicador=1," +
                " E=0 e resistência=0)\n2: Energizar(custo:2 de energia; E=0.5 naquele turno)\n" +
                "3: Especial(custo:4 de energia; varia de acordo com o ancestral)\n0: Passa a vez\n" +
                "\nOs ancestrais diponíveis são:\n1-Vampiro: Causa 2 de dano e recupera 1 de vida." +
                "\n2-Dragão: Ganha 0.2 de multiplicador de dano e invulnerabilidade por um turno." +
                "\n3-Sereia: zera a energia do alvo porém é necessário ao menos 6 de energia para " +
                "ser utilizado.\n4-Anjo: Ganha 0.2 de resistência pelo resto do jogo." +
                "\n5-Demônio: Ganha 0.2 de multiplicador de dano pelo resto do jogo.");

        Criatura a = null;
        a = escolheAncestral("A");

        Criatura b = null;
        b = escolheAncestral("B");


        System.out.println("---------------------\nINICIANDO O JOGO\n---------------------\n");

        boolean [] especialDragaoA = {false};
        boolean [] especialDragaoB = {false};



        while(true) {
            a.inicioTurno(especialDragaoA);
            if(turnoDe("A",a,b,especialDragaoA,especialDragaoB)) {
                System.out.println("Parábens slime A você venceu!");
                break;
            }
            b.inicioTurno(especialDragaoB);
            if(turnoDe("B",b,a,especialDragaoB,especialDragaoA)) {
                System.out.println("Parábens slime B você venceu!");
                break;
            }
        }

    }
}
