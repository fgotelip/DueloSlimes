package org.example.Jogo;

public class Vampiro extends Criatura {
    Vampiro() {
        super();
    }

    void especial(Criatura atacado) {
        aumentaVida(1);
        atacado.diminuiVida(2);
        diminuiEnergia(4);
    }

    String getDescricaoEspecial(){
        return "causa 2 de dano e recupera 1 de vida)";
    };

}
