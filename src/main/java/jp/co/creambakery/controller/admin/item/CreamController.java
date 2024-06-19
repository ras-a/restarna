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
@RequestMapping("/cream")
public class CreamController 
{
    @Autowired
	CreamRepository repository;

    @GetMapping("/list")
    public String creamList(Model model)
    {
        BeanFactory factory = new BeanFactory();
        var entity = repository.findAllNotDeleted();
        var creams = factory.createCreamList(entity);
        model.addAttribute("creams", creams);
        return "admin/item/cream/list";
    }

    @GetMapping("/update/{id}")
	public String getCreamUpdate(@PathVariable Integer id, Model model)
    {
        BeanFactory factory = new BeanFactory();
        var entity = repository.getReferenceById(id);
		var cream = factory.createBean(entity);
        model.addAttribute("cream", cream);
		return "admin/item/cream/update";
	}

    @PostMapping("/update")
    public String postCreamUpdate(Integer id, @Valid @ModelAttribute 
                                CreamForm form,BindingResult result)
    {
        Cream cream = repository.getReferenceById(id);
        BeanUtils.copyProperties(form, cream, "id", "deleted");
        repository.save(cream);
        return "admin/item/cream/complete";
    }

    @PostMapping("/delete")
    public String creamDelete(Integer id)
    {
        Cream cream = repository.getReferenceById(id);
        cream.setDeleted(1);
        repository.save(cream);
        return "admin/item/cream/complete";
    }

    @GetMapping("/{id}")
	public String creamDetail(@PathVariable Integer id, Model model)
    {
        BeanFactory factory = new BeanFactory();
        var entity = repository.getReferenceById(id);
		var cream = factory.createBean(entity);
        model.addAttribute("cream", cream);
		return "admin/item/cream/detail";
	}
}
