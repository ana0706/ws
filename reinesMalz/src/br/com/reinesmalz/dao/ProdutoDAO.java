package br.com.reinesmalz.dao;

import javax.persistence.TypedQuery;

import br.com.reinesmalz.model.Produto;

public class ProdutoDAO extends GenericDAO<Produto> {
	public Produto buscarID(int idProduto) {
	    String jpql = "select c from Produto p where p.idProduto = :idProduto";
	    TypedQuery<Produto> query = entityManager.createQuery(jpql,Produto.class);
	    query.setParameter("idProduto", idProduto);
	    Produto produto = query.getSingleResult();
	    return produto;
	  } 
	

}
