package Discounts;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Discounts {
    private List<Store> stores;

    public int readStores(InputStream in) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        stores = new ArrayList<>();

        stores = bufferedReader.lines()
                            .map(line -> new Store(line))
                            .collect(Collectors.toList());

        return stores.size();
    }

    public List<Store> byAverageDiscount(){
        return  stores.stream()
                        .sorted(Comparator.comparing(Store::getAverageDiscount).reversed()
                                            .thenComparing(Store::getName))
                        .limit(3)
                        .collect(Collectors.toList());
    }

    public List<Store> byTotalDiscount() {
        return stores.stream()
                .sorted(Comparator.comparing(Store::getTotalDiscount)
                                    .thenComparing(Store::getName))
                .limit(3)
                .collect(Collectors.toList());
    }

}
