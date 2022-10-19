package management.product.repository.impl;

import management.product.model.Product;
import management.product.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product as p", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
//        TypedQuery<Product> query = entityManager.createQuery("select p from Product as p where p.id=:id",Product.class);
//        query.setParameter("id" , id);
        return entityManager.find(Product.class,id);
    }

    @Override
    public void update( Product product) {
        entityManager.merge(product);
    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product as p where p.name like :name" , Product.class );
        query.setParameter("name","%"+name+"%");
        return query.getResultList();
    }
}
