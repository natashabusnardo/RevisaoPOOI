package revisao;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Funcionario extends Usuario {
	private String nome;
	private String email;
	private double[] horasTrabalhadas;
	private double[] valorHora;
	private static Date dataNasc;
	private String sexo;
	private String cargo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.length() > 0)
			this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.length() > 0)
			this.email = email;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		try {
			this.dataNasc = new SimpleDateFormat("dd/MM/yyyy").parse(dataNasc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setHorasTrabalhadas(double[] horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public void setValorHora(double[] valorHora) {
		this.valorHora = valorHora;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [nome=");
		builder.append(nome);
		builder.append("\n");
		builder.append("email ");
		builder.append(email);
		builder.append("\n");
		builder.append("Horas Trabalhadas ");
		builder.append(Arrays.toString(horasTrabalhadas));
		builder.append("\n");
		builder.append("Valor Hora ");
		builder.append(Arrays.toString(valorHora));
		builder.append("\n");
		builder.append("Data Nascimento");
		builder.append(dataNasc);
		builder.append("\n");
		builder.append("Sexo ");
		builder.append(sexo);
		builder.append("\n");
		builder.append("Cargo");
		builder.append(cargo);
		builder.append("\n");
		builder.append("Media Salarios:");
		builder.append(mediaSalario());
		builder.append("\n");
		builder.append("Maiores salarios:");
		builder.append(maioresSalarios(2));
		builder.append("\n");
		builder.append("Menores salarios");
		builder.append(menoresSalarios(2));
		builder.append("\n");
		builder.append("Meses Trabalhados: ");
		builder.append(mesesTrabalhados());
		builder.append("\n");
		builder.append("Anos trabalhados: ");
		builder.append(mesesTrabalhados() / 12);
		builder.append("\n");
		builder.append(anosMesesTrabalhados());
		builder.append("\n");
		builder.append("Ano da aposentadoria por contribuição: ");
		builder.append(aposentadoriaContribuicao());
		builder.append("\n");
		builder.append("Ano da aposentadoria por idade: ");
		builder.append(aposentadoriaIdade());
		builder.append("\n");
		builder.append("Idade atual: ");
		builder.append(idade());
		builder.append("\n");
		builder.append("Usuario=");
		builder.append(getUsuario());
		builder.append("\n");
		builder.append("Senha=");
		builder.append(getSenha());
		builder.append("]");
		return builder.toString();
	}

	public static int anoInteiro(Date dataNasc) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		String anoNasc = "";
		try {
			anoNasc = df.format(dataNasc);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Integer.parseInt(anoNasc);
	}

	private int idade() {
		int ano = LocalDateTime.now().getYear();
		return ano - anoInteiro(dataNasc);
	}

	public double[] salarioMes() {
		double[] salarioMes = new double[horasTrabalhadas.length];
		for (int i = 0; i < salarioMes.length; i++) {
			salarioMes[i] = horasTrabalhadas[i] * valorHora[i];
		}
		return salarioMes;
	}

	public double totalSalario() {
		double[] totalSalario = salarioMes();
		double soma = 0;

		for (int i = 0; i < totalSalario.length; i++) {
			soma += totalSalario[i];
		}

		return soma;
	}

	public double mediaSalario() {
		return totalSalario() / horasTrabalhadas.length;
	}

	public double[] maioresSalarios(int qtd) {
		double[] salarios = salarioMes();
		double[] maioresSalarios = new double[qtd];
		Arrays.sort(salarios);
		for (int i = 0; i < qtd; i++) {
			maioresSalarios[i] = salarios[(salarios.length - 1) - i];
		}
		return maioresSalarios;
	}

	public double[] menoresSalarios(int qtd) {
		double[] salarios = salarioMes();
		double[] maioresSalarios = new double[qtd];
		Arrays.sort(salarios);
		for (int i = 0; i < qtd; i++) {
			maioresSalarios[i] = salarios[i];
		}
		return maioresSalarios;
	}

	public int mesesTrabalhados() {
		return horasTrabalhadas.length;
	}

	public String anosMesesTrabalhados() {
		String anos_meses;
		int meses = mesesTrabalhados();
		if (meses > 12) {
			int anos = meses / 12;
			meses = meses - (anos * 12);
			anos_meses = "Anos e Meses Trabalhados: " + anos + " ano(s) e " + meses + " meses";
		} else
			anos_meses = "Meses Trabalhados: " + meses + " meses";

		return anos_meses;
	}

	public int aposentadoriaIdade() {

		int idade = idade();
		if (sexo.equals("masculino")) {
			int anosFaltando = 65 - idade;
			return anosFaltando + LocalDateTime.now().getYear();

		} else {
			int anosFaltando = 62 - idade;
			return anosFaltando + LocalDateTime.now().getYear();
		}
	}

	public int aposentadoriaContribuicao() {
		int anosTrabalhados = mesesTrabalhados() / 12;
		return 35 - anosTrabalhados + LocalDateTime.now().getYear();
	}

}