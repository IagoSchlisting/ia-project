package com.ia.controllers;
import com.fasterxml.jackson.databind.MappingIterator;
import com.ia.dao.BaseCasoDao;
import com.ia.models.Avaliacao;
import com.ia.models.BaseDeCaso;
import com.ia.models.Companhia;
import com.ia.service.BaseCasoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
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



    @RequestMapping(value = "/adicionar/caso", method = RequestMethod.POST)
    public RedirectView adicionarCaso(WebRequest request, RedirectAttributes redirectAttributes){
        try{
                BaseDeCaso baseDeCaso = new BaseDeCaso();
                baseDeCaso.setImportanciaAvaliacao(Avaliacao.valueOf(request.getParameter("avaliacao")));
                baseDeCaso.setCompanhia(Companhia.valueOf(request.getParameter("companhia")));
                baseDeCaso.setImportanciaOscar(Avaliacao.valueOf(request.getParameter("oscar")));
                baseDeCaso.setImportanciaSerRecente(Avaliacao.valueOf(request.getParameter("recente")));
                baseDeCaso.setFilme(request.getParameter("filme"));
                this.baseCasoService.addCaso(baseDeCaso);
            redirectAttributes.addFlashAttribute("msg", "Caso adicionado com sucesso!");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return new RedirectView("/banco-casos");
    }


    @RequestMapping(value = "/adicionar/casos/fixos", method = RequestMethod.POST)
    public RedirectView adicionarCasosFixos(RedirectAttributes redirectAttributes){
        try{


            List<List<String>> records = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\i500738\\Desktop\\projects\\ia-project\\casosIA.csv"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    records.add(Arrays.asList(values));
                }
            }

            BaseDeCaso baseDeCaso;
            for(List<String> record : records) {
                baseDeCaso = new BaseDeCaso();
                baseDeCaso.setImportanciaAvaliacao(Avaliacao.valueOf(record.get(0).replaceAll("\\s+","")));
                baseDeCaso.setCompanhia(Companhia.valueOf(record.get(1).replaceAll("\\s+","")));
                baseDeCaso.setImportanciaOscar(Avaliacao.valueOf(record.get(2).replaceAll("\\s+","")));
                baseDeCaso.setImportanciaSerRecente(Avaliacao.valueOf(record.get(3).replaceAll("\\s+","")));
                baseDeCaso.setFilme(record.get(4));
                this.baseCasoService.addCaso(baseDeCaso);
            }


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



    @RequestMapping(value = "/gerar/recomendacoes" , method = RequestMethod.GET)
    public String GerarRecomendacoes(Model model, WebRequest request){

        Avaliacao oscar = Avaliacao.valueOf(request.getParameter("oscar"));
        Avaliacao avaliacao = Avaliacao.valueOf(request.getParameter("avaliacao"));
        Avaliacao recente = Avaliacao.valueOf(request.getParameter("recente"));
        Companhia companhia = Companhia.valueOf(request.getParameter("companhia"));

        List<BaseDeCaso> casos = this.baseCasoService.listCasos();
        Map<String, Integer> recomendacoes = new HashMap<String, Integer>();
        Map<String, Integer> recomendacoes_ordenado = new HashMap<String, Integer>();


        // Pesos
        // oscar - 1
        // avaliacao - 2
        // recente - 1
        // companhia - 3

        int semelhanca_oscar;
        int semelhanca_avalaliacao;
        int semelhanca_recente;
        int semelhanca_companhia;
        int semelhanca_total;

        int aux1;
        int aux2;

        for(BaseDeCaso caso : casos){

            //Semelhanca Companhia
            if(caso.getCompanhia() == companhia){
                semelhanca_companhia = 100;
            }else{
                semelhanca_companhia= 0;
            }

            // Semelhanca Oscar
            aux1 = this.getEnumIntValue(oscar);
            aux2 = this.getEnumIntValue(caso.getImportanciaOscar());
            semelhanca_oscar = 100 - (Math.abs(aux1 - aux2) * 20);

            // Semelhanca Recente
            aux1 = this.getEnumIntValue(recente);
            aux2 = this.getEnumIntValue(caso.getImportanciaSerRecente());
            semelhanca_recente = 100 - (Math.abs(aux1 - aux2) * 20);

            // Semelhanca Avaliacao
            aux1 = this.getEnumIntValue(avaliacao);
            aux2 = this.getEnumIntValue(caso.getImportanciaAvaliacao());
            semelhanca_avalaliacao = 100 - (Math.abs(aux1 - aux2) * 20);

            semelhanca_total = (semelhanca_oscar + semelhanca_recente + (semelhanca_avalaliacao * 2) + (semelhanca_companhia * 3))/7;
            recomendacoes.put(caso.getFilme(), semelhanca_total);
        }

        int maior = 0;
        String key = "";

        for(int i = 0; i < 5; i++){
            for(Map.Entry<String, Integer> recomendacao : recomendacoes.entrySet()){
                if(recomendacao.getValue() > maior){
                    maior = recomendacao.getValue();
                    key = recomendacao.getKey();
                }
            }
            recomendacoes.remove(key);
            recomendacoes_ordenado.put(key.toLowerCase().replaceAll(" ", "_"), maior);
            maior = 0;
        }
        model.addAttribute("recomendacoes", recomendacoes_ordenado);
        return "homepage";
    }


    public Integer getEnumIntValue(Avaliacao v_enum){
        switch (v_enum){
            case UM:
                return 1;
            case DOIS:
                return 2;
            case TRES:
                return 3;
            case QUATRO:
                return 4;
            case CINCO:
                return 5;
        }
        return 0;
    }

}



