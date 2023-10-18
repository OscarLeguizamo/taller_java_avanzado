package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.entidades.AnimalesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARepository extends CrudRepository<AnimalesEntity/* change for adapter model */, String>,
        QueryByExampleExecutor<AnimalesEntity/* change for adapter model */> {
}
