package org.example.Jogo;

public class Sereia extends Criatura {
    Sereia() {
        super();
    }

    //coloquei que o especial é usado quando a energia é >=6
    //ele diminuira a energia em 4, assim como em qualquer especial
    void especial(Criatura atacado){
        if(getEnergia() >= 6){
            atacado.setEnergia(-2);
            diminuiEnergia(4);
        }
        else
            System.out.println("Você precisa de pelo menos 6 de energia para usar esse especial");
    }

    String getDescricaoEspecial(){
        return "zera a energia do alvo porém é necessário ao menos 6 de energia para ser utilizado)";
    };
}
