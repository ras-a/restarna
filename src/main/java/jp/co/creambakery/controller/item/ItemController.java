package jp.co.creambakery.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jp.co.creambakery.bean.*;
import jp.co.creambakery.repository.*;


@Controller
public class ItemController {
	@Autowired
	ItemRepository repository;

	@GetMapping("/{id}")
	public String details(@PathVariable Integer id, Model model) {
		var factory = new BeanFactory();
		var entity = repository.getReferenceById(id);

		model.addAttribute("item", factory.createBean(entity));
		return "item/details";
	}
}
