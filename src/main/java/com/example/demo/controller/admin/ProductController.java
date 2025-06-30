package com.example.demo.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.UploadService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {
    private final ProductService productService;
    private final UploadService uploadService;

    public ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/product")
    public String getAllProducts(Model model) {
        List<Product> products = this.productService.fetchProducts();
        model.addAttribute("products", products);
        return "admin/product/show";
    }

    @GetMapping("admin/product/create")
    public String getCreateProduct(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping("admin/product/create")
    public String CreateProductPage(@ModelAttribute("newProduct") @Valid Product newProduct,
            BindingResult newBindingResult, @RequestParam("imageFile") MultipartFile file) {

        // validation
        List<FieldError> errors = newBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(error.getField() + "-" + error.getDefaultMessage());
        }
        if (newBindingResult.hasErrors()) {
            return "admin/product/create";
        }
        String imageString = this.uploadService.handleSaveUploadFile(file, "product");
        newProduct.setImage(imageString);
        this.productService.createProduct(newProduct);
        return "redirect:admin/product";
    }

    @GetMapping("admin/product/delete/{id}")
    public String getDeleteProductPage(Model model, @PathVariable Long id) {
        Product productDelete = new Product();
        productDelete.setId(id);
        model.addAttribute("productDelete", productDelete);
        return "admin/product/delete";
    }

    @PostMapping("admin/product/delete")
    public String postDeleteProductPage(@ModelAttribute("productDelete") Product productDelete, Model model) {
        if (productDelete.getId() == null) {
            model.addAttribute("error", "Product ID is missing");
            return "admin/product/delete";
        }
        productService.deleteProductById(productDelete.getId());
        return "redirect:/admin/product";
    }

    @RequestMapping("/admin/product/{id}")
    public String GetProductDetailPage(Model model, @PathVariable Long id) {
        Product pr = this.productService.fetchProductById(id).get();
        model.addAttribute("product", pr);
        model.addAttribute("id", id);
        return "admin/product/detail";
    }

    @GetMapping("/admin/product/update/{id}")
    public String getUpdateProductPage(Model model, @PathVariable Long id) {
        Product pr = this.productService.fetchProductById(id).get();
        model.addAttribute("productUpdate", pr);
        model.addAttribute("id", id);
        return "admin/product/update";
    }

    @PostMapping("admin/product/update")
    public String postUpdateProduct(@ModelAttribute("productUpdate") @Valid Product productUpdate,
            BindingResult newBindingResult, @RequestParam("imageFile") MultipartFile file) {
        // Validation
        if (newBindingResult.hasErrors()) {
            return "admin/product/update";
        }
        Product currentProduct = this.productService.fetchProductById(productUpdate.getId()).get();
        if (currentProduct != null) {
            // update new image
            if (!file.isEmpty()) {
                String img = this.uploadService.handleSaveUploadFile(file, "product");
                currentProduct.setImage(img);
            }
            currentProduct.setName(productUpdate.getName());
            currentProduct.setPrice(productUpdate.getPrice());
            currentProduct.setDetailDesc(productUpdate.getDetailDesc());
            currentProduct.setShortDesc(productUpdate.getShortDesc());
            currentProduct.setQuantity(productUpdate.getQuantity());
            currentProduct.setFactory(productUpdate.getFactory());
            currentProduct.setTarget(productUpdate.getTarget());
        }
        this.productService.createProduct(currentProduct);

        return "redirect:admin/product";
    }
}
