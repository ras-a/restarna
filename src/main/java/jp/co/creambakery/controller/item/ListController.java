package jp.co.creambakery.controller.item;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.form.*;
import jp.co.creambakery.repository.*;

@Controller
public class ListController {
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	CreamRepository creamRepository;
	@Autowired
	BreadRepository breadRepository;

	@GetMapping("/list")
	public String list(Model model) {
		BeanFactory factory = new BeanFactory();
		model.addAttribute("items", factory.createItemList(itemRepository.findAllNotDeletedByStoreIsNotNull()));
		return "item/list";
	}

	@GetMapping("/cream/list")
	public String cream(Model model) {
		BeanFactory factory = new BeanFactory();
		model.addAttribute("creams", factory.createCreamList(creamRepository.findAll()));
		return "item/creamList";
	}

	@GetMapping("/bread/list")
	public String breadList(Model model) {
		BeanFactory factory = new BeanFactory();
		model.addAttribute("breads", factory.createBreadList(breadRepository.findAll()));
		return "item/breadList";
	}

	// 絞り込み画面
	@GetMapping("/filter")
	public String squ(Model model, @ModelAttribute("form") SearchForm form) {
		BeanFactory factory = new BeanFactory();
		form.setAsc(true);
		model.addAttribute("items", factory.createItemList(itemRepository.findAll()));
		model.addAttribute("breads", factory.createBreadList(breadRepository.findAll()));
		model.addAttribute("creams", factory.createCreamList(creamRepository.findAll()));
		return "item/search";
	}

	// 生地絞り込み
	@PostMapping("/filter")
	public String breadsq(Model model, @ModelAttribute("form") SearchForm form) {
		BeanFactory factory = new BeanFactory();

		System.out.println(form.getName().length());

		var items = factory.createItemList(switch (form.getSortBy()) {
			case 0 ->
				itemRepository.findAllFiltered(form.getBread(), form.getCreams(), form.getCreams().size(), form.getName());
			case 1 -> {
				if (form.getAsc())
					yield itemRepository.findAllFilteredOrderByName(form.getBread(), form.getCreams(), form.getCreams().size(), form.getName());
				else
					yield itemRepository.findAllFilteredOrderByNameDesc(form.getBread(), form.getCreams(), form.getCreams().size(), form.getName());
			}
			case 2 -> {
				if (form.getAsc())
					yield itemRepository.findAllFilteredOrderByPrice(form.getBread(), form.getCreams(), form.getCreams().size(), form.getName());
				else
					yield itemRepository.findAllFilteredOrderByPriceDesc(form.getBread(), form.getCreams(), form.getCreams().size(), form.getName());
			}
			case 3 -> {
				if (form.getAsc())
					yield itemRepository.findAllFilteredOrderByDate(form.getBread(), form.getCreams(), form.getCreams().size(), form.getName());
				else
					yield itemRepository.findAllFilteredOrderByDateDesc(form.getBread(), form.getCreams(), form.getCreams().size(), form.getName());
			}
			default -> throw new IllegalArgumentException();
		});

		model.addAttribute("items", items);
		model.addAttribute("breads", factory.createBreadList(breadRepository.findAll()));
		model.addAttribute("creams", factory.createCreamList(creamRepository.findAll()));
		return "item/search";
	}
}