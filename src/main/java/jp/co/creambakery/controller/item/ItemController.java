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

	BeanFactory factory = new BeanFactory();

	@GetMapping("/{id}")
	public String details(@PathVariable Integer id, Model model) {
		var entity = repository.getReferenceById(id);
		var item = factory.createBean(entity);

		model.addAttribute("item", item);
		return "item/test";
	}
}
