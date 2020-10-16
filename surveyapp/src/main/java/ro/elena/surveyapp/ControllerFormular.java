package ro.elena.surveyapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerFormular {

        @Autowired
        JdbcTemplate jdbcTemplate;

 @GetMapping("/save")
    public String save ( @RequestParam ("INTREBARE_A") String newINTREBARE_A, @RequestParam ("INTREBARE_B") String newINTREBARE_B, @RequestParam ("INTREBARE_C") String newINTREBARE_C, @RequestParam ("INTREBARE_D") String newINTREBARE_D, @RequestParam ("INTREBARE_E") String newINTREBARE_E, @RequestParam ("RASPUNS_FREE_TEXT") String newRASPUNS_FREE_TEXT ){
            FormularHTML formularHTML = new FormularHTML ();

             formularHTML.INTREBARE_A=newINTREBARE_A;
             formularHTML.INTREBARE_B = newINTREBARE_B;
             formularHTML.INTREBARE_C =newINTREBARE_C;
              formularHTML.INTREBARE_D = newINTREBARE_D;
             formularHTML.INTREBARE_E =newINTREBARE_E;
             formularHTML.RASPUNS_FREE_TEXT = newRASPUNS_FREE_TEXT;

     jdbcTemplate.update ("insert into survey.raspunsuri values (null, NOW(), ?, ?, ? ,?,?,?)",   newINTREBARE_A, newINTREBARE_B,  newINTREBARE_C, newINTREBARE_D, newINTREBARE_E, newRASPUNS_FREE_TEXT);
     return "redirect:https://elenadinu.github.io/demo4/";
        }

    }

