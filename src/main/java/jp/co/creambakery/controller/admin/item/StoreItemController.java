package jp.co.creambakery.controller.admin.item;

import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.entity.*;
import jp.co.creambakery.form.*;
import jp.co.creambakery.repository.*;
@Controller
@RequestMapping("/store")
public class StoreItemController {
    @Autowired
	ItemRepository repository;

    @GetMapping("/list")
    public String getStoreItemList(Model model)
    {
        BeanFactory factory = new BeanFactory();
        var entity = repository.findAllStoreItems();
        var items = factory.createItemList(entity);
        model.addAttribute("items", items);
        return "admin/item/storeItem/list";
    }
    
    @GetMapping("/update/{id}")
	public String getStoreItemUpdate(@PathVariable Integer id, Model model)
    {
        BeanFactory factory = new BeanFactory();
        var entity = repository.getReferenceById(id);
		var item = factory.createBean(entity);
        model.addAttribute("item", item);
		return "admin/item/storeItem/update";
	}

    @PostMapping("/update")
    public String postStoreItemUpdate(Integer id, @Valid @ModelAttribute 
                                    ItemForm form,BindingResult result)
    {
        Item item = repository.getReferenceById(id);
        BeanUtils.copyProperties(form, item, "id");
        repository.save(item);
        return "admin/item/storeItem/complete";
    }

    @PostMapping("/delete")
    public String StoreItemDelete(Integer id)
    {
        Item item = repository.getReferenceById(id);
        item.setDeleted(1);
        repository.save(item);
        return "admin/item/storeItem/complete";
    }

    @GetMapping("/{id}")
	public String StoreItemDetail(@PathVariable Integer id, Model model)
    {
        BeanFactory factory = new BeanFactory();
        var entity = repository.getReferenceById(id);
        var item = factory.createBean(entity);
        BeanUtils.copyProperties(item, item);
        model.addAttribute("item", item);
		return "admin/item/storeItem/detail";
	}

}
