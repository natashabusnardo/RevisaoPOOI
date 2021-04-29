package revisao;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random r = new Random();
		Funcionario funcionario = new Funcionario();

		funcionario.setEmail("natasha@gmail.com");
		funcionario.setNome("natasha");
		funcionario.setSenha("senha");
		funcionario.setSexo("feminino");
		funcionario.setUsuario("natasha");
		funcionario.setDataNasc("12/01/2000");
		double[] hora_trabalhada = new double[15];

		for (int i = 0; i < hora_trabalhada.length; i++) {
			hora_trabalhada[i] = r.nextDouble() * 10 * 20;
		}
		funcionario.setHorasTrabalhadas(hora_trabalhada);
		double[] valor_hora = new double[15];
		for (int i = 0; i < valor_hora.length; i++) {
			valor_hora[i] = r.nextDouble() * 10 * 45;
		}
		funcionario.setValorHora(valor_hora);

		System.out.println(funcionario.toString());

	}
}
