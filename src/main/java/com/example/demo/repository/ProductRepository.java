package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CategoryGroup;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCategoryJoin;
import com.example.demo.entity.ProductProjection;

@Repository
public interface ProductRepository
		extends PagingAndSortingRepository<Product, Long>, JpaSpecificationExecutor<Product> {
	
	
	/**
	>>> Test Procedure1
	
	DELIMITER $$
	CREATE PROCEDURE sp_findBetween(min decimal, max decimal)
	BEGIN
		SELECT * FROM product where price BETWEEN min and max;
	END $$
	DELIMITER ;
	
	>>> Test Procedure2
	
	DELIMITER $$
	CREATE PROCEDURE sp_findAll()
	BEGIN
		SELECT * FROM product;
	END $$
	DELIMITER ;
	
	
	*/
	
	
	@Query(value = "{call sp_findBetween(:min, :max)}", nativeQuery = true)
	public List<Product> findAllBetweenStoredProcedure(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

	@Query(value = "{call sp_findAll()}", nativeQuery = true)
	public List<Product> findAllWithStoredProcedure();

	Product findByName(final String name);

	@Query(value = "SELECT avg(price) FROM Product")
	public Double avg();

	@Query(value = "SELECT * FROM product order by id desc limit :limit", nativeQuery = true)
	public List<Product> findTopN(@Param("limit") int limit);

	@Query(value = "select * from product where price between :min and :max", nativeQuery = true)
	public List<Product> between(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

	@Query("from Product where price between :min and :max")
	public List<Product> findByPrice(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

	@Query("from Product where name like :keyword%")
	public List<Product> startsWith(@Param("keyword") String keyword);

	@Query("from Product where name like %:keyword")
	public List<Product> endsWith(@Param("keyword") String keyword);

	@Query("from Product where name like %:keyword%")
	public List<Product> contains(@Param("keyword") String keyword);

	@Query("from Product order by price asc")
	public List<Product> orderByAscending();

	@Query("from Product order by price desc")
	public List<Product> orderByDescending();

	@Query("from Product where price >= :min")
	public List<Product> findByPrice(@Param("min") BigDecimal min);

	@Query(value = "SELECT min(price) FROM Product")
	public BigDecimal min();

	@Query(value = "SELECT sum(quantity) FROM Product")
	public Long sumQuantities();

	@Query(value = "SELECT sum(quantity * price) FROM Product")
	public BigDecimal total();

	@Query(value = "SELECT max(price) FROM Product")
	public BigDecimal max();

	@Query("select new com.example.demo.entity.ProductCategoryJoin(p.id, p.name, p.price, p.category.id, p.category.name) from Product p, Category c where p.category = Cat1")
	public List<ProductCategoryJoin> productCategoryJoin();

	@Query("SELECT new com.example.demo.entity.ProductProjection(id, name, price) FROM Product")
	public List<ProductProjection> productProjection();

	@Query(value = "SELECT count(id) FROM Product where featured = :featured")
	public Long count(@Param("featured") boolean featured);

	@Query("select new com.example.demo.entity.CategoryGroup(p.category.id as categoryId, "
			+ "min(p.price) as minPrice, " + "max(p.price) as maxPrice, " + "sum(p.quantity) as sumQuantity, "
			+ "count(p.id) as countProduct, " + "avg(p.price) as avgPrice) " + "from Product p "
			+ "group by p.category.id")
	public List<CategoryGroup> groupBy();

}