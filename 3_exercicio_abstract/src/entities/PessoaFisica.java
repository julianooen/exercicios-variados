package entities;

public class PessoaFisica extends Pessoa {
	private Double gastosSaude;

	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	@Override
	public Double impostoRenda() {
		if (super.getRendaAnual() < 20000) {
			return (super.getRendaAnual() * 0.15) - (this.gastosSaude * 0.5);
		} else {
			return (super.getRendaAnual() * 0.25) - (this.gastosSaude * 0.5);
		}

	}

}
