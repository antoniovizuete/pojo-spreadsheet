package io.github.antoniovizuete.pojospreadsheet.utils.iterator;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by avizuete on 22/02/2017.
 */
public abstract class AbstractIntegerSet<T extends IntegerIndex> implements IntegerSet<T> {
  protected Set<T> set = new HashSet<>();

  public T add() {
    return add(Math.max(set.size(), getMaxIndex()) + 1);
  }

  public T add(Integer index) {
    return Optional.ofNullable(get(index)).orElseGet(() -> {
      T item = createItem(index);
      set.add(item);
      return item;
    });
  }

  public T get(Integer index) {
    return set.stream().filter(item -> item.getIndex().equals(index)).findFirst().orElse(null);
  }

  public Integer getMaxIndex() {
    return set.stream().map(IntegerIndex::getIndex).max(Comparator.naturalOrder()).orElse(0);
  }
}
