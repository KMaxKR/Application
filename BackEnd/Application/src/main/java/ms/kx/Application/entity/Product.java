package ms.kx.Application.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ms.kx.Application.exceptions.ProductNameException;
import ms.kx.Application.exceptions.ProductPriceException;
import ms.kx.Application.exceptions.ProductQuantityException;
import ms.kx.Application.exceptions.ProductSpecificationException;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "product_database", schema = "product_database")
@RequiredArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    @Getter @Setter
    private Long product_id;

    @Column(name = "product_name")
    @Getter
    private String product_name;

    @Column(name = "product_specification")
    @Getter
    private String product_specification;

    @Column(name = "product_price")
    @Getter
    private double product_price;

    @Column(name = "product_quantity")
    @Getter
    private int product_quantity;



    @Override
    public String toString() {
        return "Product{" + '\'' +
                "product_id=" + product_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", product_specification='" + product_specification + '\'' +
                ", product_price=" + product_price + '\'' +
                ", product_quantity=" + product_quantity + '\'' +
                '}';
    }

    public void setProduct_name(@NotNull String product_name) {
        if(!product_name.isBlank()) {
            this.product_name = product_name;
        }else {
            throw new ProductNameException("Product Name Can Not Be Blank");
        }
    }

    public void setProduct_specification(@NotNull String product_specification) {
        if (!product_specification.isBlank()) {
            this.product_specification = product_specification;
        }else{
            throw new ProductSpecificationException("Product Specification Can Not Be Blank");
        }
    }

    public void setProduct_price(double product_price) {
        if(product_price >= 0.1) {
            this.product_price = product_price;
        }else{
            throw new ProductPriceException("Price Can Not Be Less Than 0 ");
        }
    }

    public void setProduct_quantity(int product_quantity) {
        if (product_quantity >= 0) {
            this.product_quantity = product_quantity;
        }else{
            throw new ProductQuantityException("Product Quantity Can Not Be Negative");
        }
    }
}
