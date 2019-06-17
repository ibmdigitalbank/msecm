package org.ibm.msecm.dao;

import org.ibm.msecm.entities.Doc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public interface DocRepository extends JpaRepository<Doc,Long> {
    public List<Doc> findAllByTypeContains(String Docname);
    public Doc findByClientIdEqualsAndTypeContains(Long id,String Docname);
    public List<Doc> findAllByClientIdEquals(Long clientId);
}
