package jp.co.creambakery.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jp.co.creambakery.repository.ItemRepository;


@Controller
public class ItemController {
	@Autowired
	ItemRepository repository;

	@GetMapping("/{id}")
	public String details(@PathVariable Integer id, Model model) {
		model.addAttribute("item", repository.getReferenceById(id));
		return "details";
	}
}
