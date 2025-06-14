package model;

public class ServicoBanho extends Servico implements ServicoPet{

    private boolean tosaCompleta;


    public ServicoBanho(boolean tosaCompleta,  Pet pet) {
    super("Banho", pet);
    this.tosaCompleta = tosaCompleta;
    
    }


    @Override
    public String getDescricao() {
        return tosaCompleta ? "Banho com tosa completa" : "Banho simples";
    }

    
    @Override
    public double getPrecoServico() {
        return tosaCompleta ? 75.99 : 50.00;
    }


    @Override
    public String toString() {
        return super.toString() +
                "Descrição: " + getDescricao() +
                "Preço: R$" + getPrecoServico();

    }


}
