package com.github.unknownpgr.raft;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Optional;

/**
 * A simple thread-safe key-value storage implementation.
 */
public class KeyValueStore {
  private final ConcurrentHashMap<String, String> store;

  /**
   * Creates a new empty key-value store.
   * The store is thread-safe and can be safely accessed from multiple threads.
   */
  public KeyValueStore() {
    this.store = new ConcurrentHashMap<>();
  }

  /**
   * Stores a value for the given key.
   *
   * @param key   the key to store the value for
   * @param value the value to store
   * @return the previous value associated with the key, or null if there was no
   *         mapping
   */
  public String put(String key, String value) {
    if (key == null || value == null) {
      throw new IllegalArgumentException("Key and value cannot be null");
    }
    return store.put(key, value);
  }

  /**
   * Retrieves the value for the given key.
   *
   * @param key the key to retrieve the value for
   * @return an Optional containing the value if it exists, or empty if no mapping
   *         exists
   */
  public Optional<String> get(String key) {
    if (key == null) {
      throw new IllegalArgumentException("Key cannot be null");
    }
    return Optional.ofNullable(store.get(key));
  }

  /**
   * Removes the mapping for the given key.
   *
   * @param key the key to remove
   * @return the previous value associated with the key, or null if there was no
   *         mapping
   */
  public String remove(String key) {
    if (key == null) {
      throw new IllegalArgumentException("Key cannot be null");
    }
    return store.remove(key);
  }

  /**
   * Checks if the store contains a mapping for the given key.
   *
   * @param key the key to check
   * @return true if the store contains a mapping for the key
   */
  public boolean containsKey(String key) {
    if (key == null) {
      throw new IllegalArgumentException("Key cannot be null");
    }
    return store.containsKey(key);
  }

  /**
   * Returns the number of key-value mappings in the store.
   *
   * @return the number of key-value mappings
   */
  public int size() {
    return store.size();
  }

  /**
   * Removes all mappings from the store.
   */
  public void clear() {
    store.clear();
  }
}