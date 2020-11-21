package br.com.reinesmalz.dao;

import javax.persistence.TypedQuery;

import br.com.reinesmalz.model.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> {
	public Cliente buscarPorCPF(String cpf) {
	    String jpql = "select c from Cliente c where c.cpf = :cpf";
	    TypedQuery<Cliente> query = entityManager.createQuery(jpql,Cliente.class);
	    query.setParameter("cpf", cpf);
	   Cliente cliente = query.getSingleResult();
	    return cliente;
	  }
}
