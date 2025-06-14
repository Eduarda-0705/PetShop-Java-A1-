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
        return 60.0;
    }

    @Override
    public String toString() {
        return super.toString() + 
                "Descrição:" + getDescricao() +
                "Preço: R$" + getPrecoServico();
    }



}
