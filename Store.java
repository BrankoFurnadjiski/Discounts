package Discounts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Store {
    private String name;
    private List<Product> products;

    public Store(String row){
        String[] parts = row.split("\\s+");
        name = parts[0];
        products = new ArrayList<>();

        products = IntStream.range(1, parts.length)
                                .mapToObj(index -> parts[index])
                                .map(prices -> new Product(prices))
                                .collect(Collectors.toList());

    }

    public double getAverageDiscount() {
        return products.stream()
                .mapToInt(Product::getDiscoutnPercent)
                .sum() * 1.0 / products.size();
    }

    public String getName() {
        return name;
    }

    public int getTotalDiscount() {
        return products.stream().mapToInt(Product::getDiscount).sum();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        sb.append(String.format("Average discount: %.1f%%\n", getAverageDiscount()));
        sb.append(String.format("Total discount: %d\n", getTotalDiscount()));

        List<Product> temp = products.stream()
                .sorted(Comparator.comparing(Product::getDiscoutnPercent).reversed())
                .collect(Collectors.toList());

        IntStream.range(0, products.size()-1)
                .mapToObj(index -> temp.get(index))
                .sorted(Comparator.comparing(Product::getDiscoutnPercent).reversed())
                .forEach(product -> sb.append(product.toString()).append("\n"));

        sb.append(temp.get(temp.size()-1).toString());
        return sb.toString();
    }

}
