package org.example.Jogo;

public abstract class Criatura {
    private double vida;
    private double multiplicador;
    private double resistencia;
    private double energia;
    private double E;


    public Criatura() {
        vida = 10;
        multiplicador = 1;
        resistencia = 0;
        energia = 3;
        E = 0;
    }



    double getVida() {
        return vida;
    }

    protected void setVida(double vida) {
        this.vida = vida;
    }

    protected void aumentaVida(double valor) {
        vida += valor;
    }

    protected void diminuiVida(double valor){
        if(valor > vida){
            vida = 0;
        }
        else
            vida -= valor;
    }



    double getEnergia() {
        return energia;
    }

    protected void setEnergia(double energia) {
        this.energia = energia;
    }

    protected void aumentaEnergia(double valor) {
        energia += valor;
    }

    protected void diminuiEnergia(double valor) {
        energia -= valor;
    }



    protected void aumentaMultiplicador(double valor) {
        multiplicador += valor;
    }

    protected void diminuiMultiplicador(double valor) {
        multiplicador -= valor;
    }



    protected void setE(double Valor){
        E = Valor;
    }



    protected void aumentaResistencia(double valor) {
        resistencia += valor;
    }



    void ataque(Criatura atacado){
        double valor = multiplicador + E - atacado.resistencia;
        atacado.diminuiVida(valor);
        energia -= 1;
    }

    void energizar(){
        E = 0.5;
        energia -= 2;
    }

    void inicioTurno(boolean[] especialDragao){
        E = 0;
        energia += 2;
    }

    abstract void especial(Criatura atacado);

    abstract String getDescricaoEspecial();





}
