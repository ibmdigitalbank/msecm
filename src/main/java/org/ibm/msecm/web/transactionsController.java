package org.ibm.msecm.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.ibm.msecm.dao.DocRepository;
import org.ibm.msecm.entities.Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class transactionsController {
    @Autowired
    private DocRepository docRep;
    @GetMapping("/")
    public List<Doc> getAll(){
        return docRep.findAll();
    }
    @GetMapping("/parclient/{id}")
    public List<Doc> findAllByClient(@PathVariable Long id){
        return docRep.findAllByClientIdEquals(id);
    }
    @GetMapping("/parclientDocs/{id}")
    public List<Doc> findAllByClientDocs(@PathVariable Long id){
        return docRep.findAllByClientIdEquals(id);
    }
    @GetMapping("/docbyid/{id}")
    public Doc getDocById(@PathVariable Long id){
        return docRep.findById(id).get();
    }

    @GetMapping("/docsbyname/{id}/{type}")
    public Doc getDocByName(@PathVariable Long id,@PathVariable String type){
        return docRep.findByClientIdEqualsAndTypeContains(id,type);
    }
    @GetMapping("/doctestbyid/{id}")
    public String getDocsTest(@PathVariable Long id){
        String response="'"+id+"':{";
        response=response.concat("'CIN': true");
        response=response.concat(",'attestation_salaire': true");
        response=response.concat(",'certificat_residence': true");
        response=response.concat(",'bulletin_paie': true");
        response=response.concat("}");
        return response;
    }
    @PostMapping("/Doc")
    public Doc newOne(@RequestBody Doc o){
        return docRep.save(o);
    }


}
