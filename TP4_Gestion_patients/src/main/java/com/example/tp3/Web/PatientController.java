package com.example.tp3.Web;

import com.example.tp3.Repositories.PatientRepository;
import com.example.tp3.entities.Patient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String patients(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "size", defaultValue = "8") int size,
                           @RequestParam(value = "keyword", defaultValue = "") String keyword){
        Page<Patient> patientList = patientRepository.findByNomContains( keyword, PageRequest.of(page, size));
        model.addAttribute("patients", patientList.getContent());
        int pages[];
        if (patientList.getTotalPages() > 10) {
            pages = new int[10];
            if (page <= 5) {
                for (int i = 0; i < 10; i++)
                    pages[i] = i;
            } else {
                int j = 0;
                if (page >= (patientList.getTotalPages() - 5)) {
                    for (int i = patientList.getTotalPages() - 10; i < patientList.getTotalPages(); i++)
                        pages[j++] = i;
                } else {
                    for (int i = page - 5; i < (page + 5); i++)
                        pages[j++] = i;
                }
            }
        } else {
            pages = new int[patientList.getTotalPages()];
            for (int i = 0; i < patientList.getTotalPages(); i++)
                pages[i] = i;
        }
        model.addAttribute("pages", pages );
        model.addAttribute("currentPage", page);
        model.addAttribute("nbrPages", patientList.getTotalPages());
        model.addAttribute("size", size);
        model.addAttribute("keyword", keyword);
        model.addAttribute("maxPages", patientList.getTotalPages());
        return "Patients";
    }

    @GetMapping( path = "/delete")
    public String delete( @RequestParam(value = "id") Long id, @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "8") int size,
                          @RequestParam(value = "keyword", defaultValue = "") String keyword){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword+"&size="+size;
    }

    @GetMapping( path = "/")
    public String index( ){
        return "redirect:/index";
    }
}
