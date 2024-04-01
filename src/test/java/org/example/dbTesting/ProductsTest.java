package org.example.dbTesting;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductsTest extends AbstractTest{
    //enum ProductsFeatures {}

    @Test
    //Проверка размера таблицы
    void checkTableSize() throws SQLException {
        //given
        String sql = "SELECT * FROM products";
        Statement statement = getConnection().createStatement();
        int size = 0;
        //when
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            size++;
        }
        final Query query = getSession().createSQLQuery(sql).addEntity(ProductsEntity.class);
        //then
        Assertions.assertEquals(10, size);
        Assertions.assertEquals(10, query.list().size());
    }

    @ParameterizedTest
    //Проверка цены по наименованию из меню
    @CsvSource({"GOJIRA ROLL, 300", "COFFEE, 79", "NUTTY GRILLED SALAD, 1200"})
    void checkPriceByMenuName(String menuName, float price) throws SQLException {
        //given
        String sql = "SELECT * FROM products WHERE menu_name='" + menuName + "'";
        Statement statement = getConnection().createStatement();
        float currentPrice = 0;

        //when
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            currentPrice = resultSet.getFloat("price");
        }

        final Query query = getSession().createSQLQuery(sql).addEntity(ProductsEntity.class);
        ProductsEntity productsEntity = (ProductsEntity) query.uniqueResult();

        //then
        Assertions.assertEquals(price, currentPrice);
        Assertions.assertEquals(price, Float.valueOf(productsEntity.getPrice()));
    }

    @Test
    //Добавление записи в таблицу
    void addNewProductIntoTable() {
        //given
        ProductsEntity entity = new ProductsEntity();
        entity.setMenuName("BLACK TEA");
        entity.setPrice("55");

        //when
        Session session = getSession();
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();

        final Query query = getSession()
                .createSQLQuery("SELECT * FROM products WHERE menu_name = 'BLACK TEA'")
                .addEntity(ProductsEntity.class);

        ProductsEntity productsEntity = (ProductsEntity) query.uniqueResult();

        //then
        Assertions.assertNotNull(productsEntity);
        Assertions.assertEquals("BLACK TEA", productsEntity.getMenuName());
        Assertions.assertEquals("55.0", productsEntity.getPrice());
    }

    @Test
    //Удаление существующего продукта из таблицы
    void removeProductFromTableIfExists() {
        //given
        //String sql = "SELECT * FROM products WHERE price = '55'";
        final Query query = getSession().createSQLQuery("SELECT * FROM products WHERE price = '55'")
                .addEntity(ProductsEntity.class);
        ProductsEntity productsEntity = (ProductsEntity) query.uniqueResult();

        //when
        Session session = getSession();
        session.beginTransaction();
        session.delete(productsEntity);
        session.getTransaction().commit();

        //then
        final Query checkQuery = getSession().createSQLQuery("SELECT * FROM products WHERE price = 55")
                        .addEntity(ProductsEntity.class);
        ProductsEntity checkEntity = (ProductsEntity) checkQuery.uniqueResult();
        Assertions.assertNotNull(productsEntity);
        Assertions.assertNull(checkEntity);

    }
}
