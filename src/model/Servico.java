package model;

public abstract class Servico {

    private String tipo;
    private Pet pet;
    
    public Servico(String tipo, Pet pet) {
        this.tipo = tipo;
        this.pet = pet;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Tipo Serviço" + tipo +
                "Pet:" + pet.getNome();
    }

}
