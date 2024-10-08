package org.example.Jogo;

public class Demonio extends Criatura {
    Demonio() {
        super();
    }

    void especial(Criatura atacado){
        aumentaMultiplicador(0.2);
    }
    String getDescricaoEspecial(){
        return "ganha 0.2 de multiplicador de dano pelo resto do jogo)";
    };
}
