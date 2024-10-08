package org.example.Jogo;

public class Anjo extends Criatura {
    Anjo() {
        super();
    }

    void especial(Criatura atacado){
        aumentaResistencia(0.2);
    }
    String getDescricaoEspecial(){
        return "ganha 0.2 de resistência pelo resto do jogo)";
    };
}
