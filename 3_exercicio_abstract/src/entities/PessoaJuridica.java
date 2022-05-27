package entities;

public class PessoaJuridica extends Pessoa {
	private Integer numFuncionarios;

	public PessoaJuridica(String nome, Double rendaAnual, Integer numFuncionarios) {
		super(nome, rendaAnual);
		this.numFuncionarios = numFuncionarios;
	}

	@Override
	public Double impostoRenda() {
		if (this.numFuncionarios <= 10) {
			return (super.getRendaAnual() * 0.16);
		} else {
			return (super.getRendaAnual() * 0.14);
		}

	}

}
