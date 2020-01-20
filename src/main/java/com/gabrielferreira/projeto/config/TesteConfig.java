package com.gabrielferreira.projeto.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gabrielferreira.projeto.modelo.entidade.Aluno;
import com.gabrielferreira.projeto.modelo.entidade.Contato;
import com.gabrielferreira.projeto.modelo.entidade.Pessoa;
import com.gabrielferreira.projeto.modelo.entidade.Professor;
import com.gabrielferreira.projeto.repositorio.AlunoRepositorio;
import com.gabrielferreira.projeto.repositorio.ContatoRepositorio;
import com.gabrielferreira.projeto.repositorio.PessoaRepositorio;
import com.gabrielferreira.projeto.repositorio.ProfessorRepositorio;

@Configuration
public class TesteConfig implements CommandLineRunner{

	@Autowired
	private PessoaRepositorio pessoaRepositorio;
	
	@Autowired
	private AlunoRepositorio alunoRepositorio;
	
	@Autowired
	private ProfessorRepositorio professorRepositorio;
	
	@Autowired
	private ContatoRepositorio contatoRepositorio;
	
	@Override
	public void run(String... args) throws Exception {

		Contato contato = new Contato(null,"ferreira@gmail.com","21212");
		Contato contato2 = new Contato(null,"g@gmail.com","2121");
		Contato contato3 = new Contato(null,"fff@gmail.com","2121");
		Contato contato4 = new Contato(null,"jabulani@gmail.com","21212");
		Contato contato5 = new Contato(null,"jojoo@gmail.com","2121");
		Contato contato6 = new Contato(null,"aaaaa@gmail.com","2121");
		
		Pessoa pessoa1 = new Aluno(null,"Gabriel","Ferreira","123",contato,"231",3,
				"Engenharia da computação");
		
		Pessoa pessoa2 = new Aluno(null,"Maria","Joaquina","345",contato2,"09090",90,
				"Engenharia da produção");
		
		Pessoa pessoa3 = new Aluno(null,"Joaquina","Fernanda","898988",contato3,"122222",70,
				"Engenharia da computação");
	
		Aluno aluno1 = (Aluno) pessoa1;
		Aluno aluno2 = (Aluno) pessoa2;
		Aluno aluno3 = (Aluno) pessoa3;
		
		contato.setPessoa(aluno1);
		contato2.setPessoa(aluno2);
		contato3.setPessoa(aluno3);
		
		Pessoa pessoa4 = new Professor(null,"João","Fernando","1234",contato4,"Física",2000.0);
		Pessoa pessoa5 = new Professor(null,"Gustavo","Matos","90909",contato5,"Cálculo",1500.0);
		Pessoa pessoa6 = new Professor(null,"Caroline","Matias","9090",contato6,"Cálculo 2",2500.0);
		
		Professor professor1 = (Professor) pessoa4;
		Professor professor2 = (Professor) pessoa5;
		Professor professor3 = (Professor) pessoa6;
		
		contato.setPessoa(professor1);
		contato2.setPessoa(professor2);
		contato3.setPessoa(professor3);
		
		pessoaRepositorio.saveAll(Arrays.asList(pessoa1,pessoa2,pessoa3,pessoa4,pessoa5,
				pessoa6));
		alunoRepositorio.saveAll(Arrays.asList(aluno1,aluno2,aluno3));
		professorRepositorio.saveAll(Arrays.asList(professor1,professor2,professor3));	
		contatoRepositorio.saveAll(Arrays.asList(contato,contato2,contato3));
	}

}
