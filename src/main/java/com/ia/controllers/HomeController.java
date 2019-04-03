package com.ia.controllers;
import com.fasterxml.jackson.databind.MappingIterator;
import com.ia.dao.BaseCasoDao;
import com.ia.models.Avaliacao;
import com.ia.models.BaseDeCaso;
import com.ia.models.Companhia;
import com.ia.service.BaseCasoService;
import com.plateau.common.core.api.util.file.CSVReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.*;

@Controller
public class HomeController extends BaseController {

    @Resource
    private BaseCasoService baseCasoService;

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String HomePage(){
        return "homepage";
    }

    @RequestMapping(value = "/banco-casos" , method = RequestMethod.GET)
    public String BancoCasosPage(Model model){
        model.addAttribute("casos", this.baseCasoService.listCasos());
        return "banco-casos";
    }

    @RequestMapping(value = "/adicionar/casos/fixos", method = RequestMethod.POST)
    public RedirectView adicionarCasosFixos(RedirectAttributes redirectAttributes){
        try{


            List<List<String>> records = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("/sapmnt/home/I500738/Desktop/ia-project/src/resources/casos/casosIA.csv"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    records.add(Arrays.asList(values));
                }
            }

            BaseDeCaso baseDeCaso = new BaseDeCaso();
            baseDeCaso.setCompanhia(Companhia.NAMORAD);
            baseDeCaso.setImportanciaAvaliacao(Avaliacao.CINCO);
            baseDeCaso.setImportanciaOscar(Avaliacao.CINCO);
            baseDeCaso.setImportanciaSerRecente(Avaliacao.CINCO);
            baseDeCaso.setFilme("Green Book O guia");
            this.baseCasoService.addCaso(baseDeCaso);


        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return new RedirectView("/banco-casos");
    }

    @RequestMapping(value = "/caso/remove/{id}", method = RequestMethod.GET)
    public RedirectView removeCaso(@PathVariable("id") int id, RedirectAttributes redirectAttributes){

        try{
            this.baseCasoService.removeCaso(id);
            redirectAttributes.addFlashAttribute("msg", "Caso removido com Sucesso!");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        return new RedirectView("/banco-casos");
    }



}



