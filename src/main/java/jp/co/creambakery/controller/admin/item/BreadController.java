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
@RequestMapping("/bread")
public class BreadController
{
    @Autowired
	private BreadRepository repository;

    @GetMapping("/list")
    public String breadList(Model model)
    {
        BeanFactory factory = new BeanFactory();
        var entity = repository.findAllNotDeleted();
        var breads = factory.createBreadList(entity);
        model.addAttribute("breads", breads);
        return "admin/item/bread/list";
    }

    @GetMapping("/update/{id}")
	public String getBreadupdate(@PathVariable Integer id, Model model)
    {
        BeanFactory factory = new BeanFactory();
        var entity = repository.getReferenceById(id);
		var bread = factory.createBean(entity);
        model.addAttribute("bread", bread);
		return "admin/item/bread/update";
	}

    @PostMapping("/update")
    public String postBreadUpdate(Integer id, @Valid @ModelAttribute
                                BreadForm form,BindingResult result)
    {
        Bread bread = repository.getReferenceById(id);
        BeanUtils.copyProperties(form, bread, "id", "deleted");
        repository.save(bread);
        return "admin/item/bread/complete";
    }

    @PostMapping("/delete")
    public String breadDelete(Integer id)
    {
        Bread bread = repository.getReferenceById(id);
        bread.setDeleted(1);
        repository.save(bread);
        return "admin/item/bread/complete";
    }

    @GetMapping("/{id}")
	public String breadDetail(@PathVariable Integer id, Model model)
    {
        BeanFactory factory = new BeanFactory();
        var entity = repository.getReferenceById(id);
		var bread = factory.createBean(entity);
        model.addAttribute("bread", bread);
		return "admin/item/bread/detail";
	}
}


