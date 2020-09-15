package edu.td0.controllers;
import edu.td0.models.Categorie;
import edu.td0.models.Element;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;





@Controller
@SessionAttributes("items")


 
public class ItemController {
	
	@ModelAttribute("items") 
    public List<Element> getItems(){
        return new ArrayList<>();
    }
	@ModelAttribute("categories") 
    public List<Categorie> getCategorie(){
        return new ArrayList<>();
    }
	
	@RequestMapping("/index")
	public String index(@ModelAttribute("categories") List<Categorie> categories) {
		categories.add(new Categorie("test"));
		return "index";
	}

	
	
	
	@RequestMapping("/items")
	public String item(@ModelAttribute("items") List<Element> items) {
		return "viewItems";
	}

	
	//@RequestMapping("/items/addNew")
	//public String addNewItem() {
	//	return "viewNewItems";
	//}
	@PostMapping("items/addNew")
	public RedirectView addNew(@RequestParam String nom,@ModelAttribute("items") List<Element> items) {
		
		items.add(new Element(nom));
	    return new RedirectView("/items/");
	}
	@RequestMapping("items/inc/{nom}")
	public RedirectView incItem(@PathVariable String nom,@ModelAttribute("items") List<Element> items) {
		for (Element item : items) {
	        if (item.getNom().equals(nom)) {
	            item.incEvaluation();
	        }
	    }
	    return new RedirectView("/items/");
	}
	@RequestMapping("items/dec/{nom}")
	public RedirectView decItem(@PathVariable String nom,@ModelAttribute("items") List<Element> items) {
		for (Element item : items) {
	        if (item.getNom().equals(nom)) {
	            item.decEvaluation();
	        }
	    }
	    return new RedirectView("/items/");
	}
	@RequestMapping("items/delete/{nom}")
	public RedirectView deleteItem(@PathVariable String nom,@ModelAttribute("items") List<Element> items) {
		int i = 0;
		for (Element item : items) {
			
	        if (item.getNom().equals(nom)) {
	            items.remove(i);
	            break;
	        }
	        i++;
	    }
		i=0;
	    return new RedirectView("/items/");
	}
	
	

}



