package com.gabrielferreira.projeto.repositorio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gabrielferreira.projeto.modelo.entidade.Disciplina;

@Repository
public interface DisciplinaRepositorio extends JpaRepository<Disciplina,Integer> {

	@Query("select d from Disciplina d inner join d.itens p where p.pessoa.id = ?1")
	public List<Disciplina> getDisciplinas(Integer pessoaid);
	
	@Query("select d from Disciplina d where d.nome like %?1%")
	public List<Disciplina> findDisciplinaByNameDisciplina(String nome);
	
	public Disciplina findDisciplinaByNome(String nome);

	@Query("select d from Disciplina d where d.nome = :nome and d.id <> :id")
	public Disciplina findDisciplinaByNomeAtualizado
	(@Param("nome")String nome,
			@Param("id")Integer id);
	
	@Query("select d from Disciplina d where d.nome like :search%")
	Page<Disciplina> findByNome(String search,Pageable pageable);
}
