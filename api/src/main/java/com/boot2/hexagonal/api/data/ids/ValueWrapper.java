package com.boot2.hexagonal.api.data.ids;

import java.util.Optional;

public interface ValueWrapper<T> {

  T value();

  default String stringValue() {
    return String.valueOf(value());
  }

  default Long longValue() {
    return Optional.ofNullable(value()).map(String::valueOf).map(Long::valueOf).orElse(null);
  }
}
