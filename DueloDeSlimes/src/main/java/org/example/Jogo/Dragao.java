package org.example.Jogo;

public class Dragao extends Criatura {
    private static double vidaTurno;
    private static double energiaTurno;


    Dragao() {
        super();
        vidaTurno = 0;
    }

    void especial(Criatura atacado){
        vidaTurno = getVida();
        aumentaMultiplicador(0.2);
        diminuiEnergia(4);
    }
    void setEnergiaTurno(double energiaTurno) {
        this.energiaTurno = energiaTurno;
    }

    String getDescricaoEspecial(){
        return "ganha 0.2 de multiplicador de dano e invulnerabilidade por\n" +
                "um turno)";
    };

    @Override
    void inicioTurno(boolean[] especialDragao){
        if(especialDragao[0]){
            setVida(vidaTurno);
            setEnergia(energiaTurno);
            diminuiMultiplicador(0.2);
        }
        setE(0);
        aumentaEnergia(2);
    }

}
