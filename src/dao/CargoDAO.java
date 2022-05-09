package dao;

import pojos.Cargo;

/**
 *
 * @author aaliagab generate
 */
public interface CargoDAO extends GenericDAO<Cargo, Integer>{
    Cargo getByNome(String nome) throws BussinessException;
}