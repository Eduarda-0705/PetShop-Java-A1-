package model;

public class ServicoHigienico extends Servico implements ServicoPet {

   public ServicoHigienico(Pet pet){
    super("Higienização", pet);

   }


   @Override
    public String getDescricao() {
        return "Tosa Higiênica (inclui banho e tosa íntima, ouvidos, dentes e unhas)";
    }

    @Override
    public double getPrecoServico() {
        return 50.0;
    }

    @Override
    public int getDuracaoEstimada() {
    return 50; 
       }


    @Override
    public String toString() {
        return super.toString() + 
                "Descrição:" + getDescricao() +
                "Preço: R$" + getPrecoServico();
    }



}
