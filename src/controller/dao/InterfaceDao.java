package controller.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<Entidade> {
    void add(Entidade entity) throws SQLException;
    void update(Entidade entity, String id) throws SQLException;
    List<Entidade> getLista() throws SQLException;
    Entidade getPorId(String id) throws SQLException;
    void deletePorId(String id) throws SQLException;
}
