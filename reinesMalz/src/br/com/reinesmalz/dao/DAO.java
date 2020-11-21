 package br.com.reinesmalz.dao;
 import java.util.List;

//Especificação (muita genérica)
//T que pode ser utilizado por qualquer entidade ou classe
public interface DAO<T> {

//Definição dos métodos
T salvar(T entidade);
T atualizar(T entidade);
T buscarPorId(Integer id);
List<T> listar();
void apagar(Integer id);

}
