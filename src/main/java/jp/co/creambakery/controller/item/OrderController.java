package jp.co.creambakery.controller.item;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.entity.*;
import jp.co.creambakery.repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * カート追加・内容を処理するコントローラー
 */
@Controller
@RequestMapping(path = "/order")
public class OrderController 
{
	@GetMapping
	public String getMethodName(@RequestParam String param) {
		
		return new String();
	}
	
}
