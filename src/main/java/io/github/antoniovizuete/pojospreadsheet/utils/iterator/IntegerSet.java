package io.github.antoniovizuete.pojospreadsheet.utils.iterator;

/**
 * Created by avizuete on 22/02/2017.
 */
public interface IntegerSet<T extends IntegerIndex> {
    T add(Integer index);
    T add();
    T get(Integer index);
    Integer getMaxIndex();
    T createItem(Integer index);
}
