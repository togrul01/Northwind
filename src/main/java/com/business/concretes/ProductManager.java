package com.business.concretes;

import com.business.abstracts.ProductService;
import com.core.DataResult;
import com.core.Result;
import com.core.SuccessDataResult;
import com.core.SuccessResult;
import com.dataAccess.abstracts.ProductDao;
import com.entities.concretes.Product;
import com.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductManager implements ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(productDao.findAll(), "Data Listed :");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<Product>>(productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.ASC, "productName");
        return new SuccessDataResult<List<Product>>(productDao.findAll(sort), "Successful");
    }

    @Override
    public Result add(Product product) {
        productDao.save(product);
        return new SuccessResult("Product added :");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>
                (productDao.getByProductName(productName), "Data Listed :");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>
                (productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data Listed :");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data Listed :");
    }

    @Override
    public DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>
                (productDao.getByCategory_CategoryIdIn(categories), "Data Listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>
                (productDao.getByProductNameContains(productName), "Data Listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                (productDao.getByProductNameStartsWith(productName), "Data Listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameEndsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                (productDao.getByProductNameEndsWith(productName), "Data Listed");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (productDao.getByNameAndCategory(productName, categoryId), "Data Listed");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductsWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(productDao.getProductsWithCategoryDetails(), "Data Listed");
    }
}
