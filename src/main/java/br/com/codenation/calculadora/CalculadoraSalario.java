package br.com.codenation.calculadora;

public class CalculadoraSalario {

	public final double SALARIO_MINIMO = 1_039.00;

	/**
	 * Efetua o cálculo do salário, descontando o INSS e IRRF;
	 * 
	 * @param salarioBase
	 * @return
	 */
	public long calcularSalarioLiquido(double salarioBase) {
		if (salarioBase < SALARIO_MINIMO) {
			salarioBase = 0.0;
		} else {
			salarioBase -= calcularInss(salarioBase);
			salarioBase -= calcularIRRF(salarioBase);
		}
		return Math.round(salarioBase);
	}

	/**
	 * Retorna o valor do desconto do INSS referente ao salario Base informado.
	 * 
	 * @param salarioBase
	 * @return
	 */
	private double calcularInss(double salarioBase) {
		double desconto = 0;
		if (salarioBase <= 1500.00) {
			desconto = salarioBase * 0.08;
		} else if (salarioBase > 1500.00 && salarioBase <= 4000.00) {
			desconto = salarioBase * 0.09;
		} else {
			desconto = salarioBase * 0.11;
		}
		return Math.round(desconto);
	}

	/**
	 * Retorna o valor do desconto do IRRF referente ao salario Base informado.
	 * 
	 * @param salarioBase
	 * @return
	 */
	private double calcularIRRF(double salarioBase) {
		double desconto = 0;
		if (salarioBase <= 3_000.00) {
			desconto = 0;
		} else if (salarioBase > 3_000.00 && salarioBase <= 6_000.00) {
			desconto = salarioBase * 0.075;
		} else {
			desconto = salarioBase * 0.15;
		}
		return desconto;
	}

}
