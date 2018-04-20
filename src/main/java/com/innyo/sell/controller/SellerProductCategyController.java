package com.innyo.sell.controller;

import com.innyo.sell.dataobject.ProductCategory;
import com.innyo.sell.exception.SellException;
import com.innyo.sell.form.CategoryForm;
import com.innyo.sell.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Author: XM
 * @Description: 卖家类目
 * @Data: Create in 2018-04-20 13:04
 * @Modified by:
 */
@Controller
@RequestMapping("/seller/category")
public class SellerProductCategyController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 商品类目列表
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(Map<String ,Object> map){
        List<ProductCategory> categoryList= categoryService.findAll();

        map.put("categoryList",categoryList);
        return new ModelAndView("category/list",map);

    }

    /**
     * 展示
     * @param categoryId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public  ModelAndView index(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                               Map<String ,Object> map){
            if(categoryId !=null){
                   ProductCategory category =  categoryService.findOne(categoryId);
                   map.put("category",category);
            }
            return new ModelAndView("category/index",map);
    }

    /**
     * 提交保存
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form, BindingResult bindingResult,
                             Map<String ,Object> map){
        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/category/list");
            return new ModelAndView("common/error",map);
        }

        ProductCategory category = new ProductCategory();
        try {
            if (form.getCategoryId() != null) {
                category = categoryService.findOne(form.getCategoryId());
            }
            BeanUtils.copyProperties(form, category);
            categoryService.save(category);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/category/list");
            return new ModelAndView("common/error",map);
        }

        map.put("url","/sell/seller/category/list");
        return new ModelAndView("common/success",map);
    }
}
