package edu.td0.controllers;
import edu.td0.models.Categorie;
import edu.td0.models.Element;
import edu.td0.models.MessageView;

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
@SessionAttributes({"items","categories","message"})



 
public class ItemController {
	


	@ModelAttribute("items") 
    public List<Element> getItems(){
        return new ArrayList<>();
    }
	
	@ModelAttribute("categories") 
    public List<Categorie> getCategorie(){
		
        return new ArrayList<>();
    }
	
	@ModelAttribute("message") 
    public MessageView getMessage(){
		
		return new MessageView();
    }


	
	
	@RequestMapping("/")
	public String index(@ModelAttribute("categories") List<Categorie> categories,@ModelAttribute("message") MessageView message) {
		if(categories.size()==0) {
			Categorie amis = new Categorie("Amis");
			amis.addItem(new Element("Michel"));
			amis.addItem(new Element("Philippe"));
			categories.add(amis);

			categories.add(new Categorie("Famille"));
			categories.add(new Categorie("Professionnels"));
		}
		message.setMessage("");
		return "index";
	}

	
	
	
//	@RequestMapping("/items")
//	public String item(@ModelAttribute("items") List<Element> items) {
//		return "viewItems";
//	}
	
	//@RequestMapping("/items/new")
	//public String newitem(@ModelAttribute("items") List<Element> items) {
	//	return "index";
//	}

	

	@RequestMapping("/cat")
	public String addNewCat() {
		return "viewNewCat";
	}
	@PostMapping("newCat")
	public RedirectView NewCat(@RequestParam String nom,@ModelAttribute("categories") List<Categorie> categories,@ModelAttribute("message") MessageView message) {
		for(Categorie categorie : categories) {
			 if (categorie.getLibelle().equals(nom)) {
		        	message.setMessage("le nom de la catégorie est déjà utilisé");
		        	return new RedirectView("cat");
			 }
		}
		categories.add(new Categorie(nom));
		return new RedirectView("/");
	}

	
	@RequestMapping("deleteCat/{libelle}")
	public RedirectView delCat(@PathVariable String libelle,@ModelAttribute("categories") List<Categorie> categories) {
		int i = 0;
		int len = categories.size();
		for(Categorie categorie : categories) {
			
	        if (categorie.getLibelle().equals(libelle) && (len!=1)  ){
	        	categories.remove(i);
	        	i=0;
	        	break;
	            
	        }
	        i++;
	    }
		i=0;
		
	    return new RedirectView("/");
	}
	@RequestMapping("/addNewItem")
	public String addNewItem() {
		return "viewNewItems";
	}
	
	@PostMapping("NewItem")
	public RedirectView New(@RequestParam String nom,@RequestParam String cat,@ModelAttribute("categories") List<Categorie> categories, @ModelAttribute("message") MessageView message) {
		if(nom.length() > 8) {
        	message.setMessage("le nom de l'élément ne doit pas dépasser 8 caractères");
        	return new RedirectView("addNewItem");
		}
		for(Categorie categorie : categories) {
			 if (categorie.getLibelle().equals(cat)) {
				 for (Element item : categorie.getItems()) {
				        if (item.getNom().equals(nom)) {
				        	message.setMessage("Un élément porte déjà ce nom");
				        	return new RedirectView("addNewItem");
				        }
				    }   
				 message.setMessage("Elément ajouté avec succès !");
				 categorie.addItem(new Element(nom));
		            
			 }
		}
		return new RedirectView("/");
	}
	
	@RequestMapping("items/inc/{nom}")
	public RedirectView incItem(@PathVariable String nom,@ModelAttribute("categories") List<Categorie> categories) {
		Categorie active = new Categorie("active");
		for(Categorie categorie : categories) {
			for (Element item : categorie.getItems()) {
	        if (item.getNom().equals(nom)) {
	            item.incEvaluation();
	            active = categorie;
	            
	        }
	    }
		}
	    return new RedirectView("/"+"#"+active.getLibelle());
	}
	@RequestMapping("items/dec/{nom}")
	public RedirectView decItem(@PathVariable String nom,@ModelAttribute("categories") List<Categorie> categories) {
		Categorie active = new Categorie("active");
		for(Categorie categorie : categories) {
			for (Element item : categorie.getItems()) {
	        if (item.getNom().equals(nom)) {
	            item.decEvaluation();
	            active = categorie;
	        }
	    }
		}
	    return new RedirectView("/"+"#"+active.getLibelle());
	}
	@RequestMapping("items/delete/{nom}")
	public RedirectView deleteItem(@PathVariable String nom,@ModelAttribute("categories") List<Categorie> categories) {
		Categorie active = new Categorie("active");
		int i = 0;
		for(Categorie categorie : categories) {
			i=0;
		for (Element item : categorie.getItems()) {
	        if (item.getNom().equals(nom)) {
	            categorie.deleteItem(i);
	            active = categorie;
	            break;
	        }
	        i++;
	    }
		}
		i=0;
	    return new RedirectView("/"+"#"+active.getLibelle());
	}
	
	

}



