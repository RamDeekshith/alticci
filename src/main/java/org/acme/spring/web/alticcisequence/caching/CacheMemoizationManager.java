package org.acme.spring.web.alticcisequence.caching;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.math.BigInteger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import java.security.InvalidParameterException;
import org.springframework.stereotype.Component;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Component
public class CacheMemoizationManager {
	
	final Map<Long, BigInteger> cache = new HashMap<>();

	public void save(Long index, BigInteger value) {
		cache.put(index, value);
	}

	public BigInteger get(Long index) {
		return cache.get(
			Optional.ofNullable(index)
			.orElseThrow(() -> new InvalidParameterException("Cannot retrieve index of null"))
		);
	}

    public String clearCache() {
		cache.clear();
        return "The cache has been clear";
	}

	public String checkCacheStr() {
		return cache.entrySet().stream()
			.map(val -> "[ " + val.getKey() + " - " + val.getValue() + " ]")
			.collect(Collectors.joining("\n"));
	}

	@PostConstruct
	void startUp() {
		cache.put(0L, BigInteger.valueOf(0));
		cache.put(1L, BigInteger.valueOf(1));
		cache.put(2L, BigInteger.valueOf(1));
	}

}
