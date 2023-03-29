package org.acme.spring.web.controller;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.acme.spring.web.alticcisequence.vo.CacheResponseDTO;
import org.acme.spring.web.alticcisequence.vo.AlticciResponseDTO;
import org.acme.spring.web.alticcisequence.caching.CacheMemoizationManager;
import org.acme.spring.web.alticcisequence.service.AlticciSequenceService;

@RestController
@RequestMapping("/alticci")
public class AlticciSequenceController {

	@Inject
	AlticciSequenceService alticciSequenceService;

	@Inject
	CacheMemoizationManager cacheManager;

	
	@Cacheable("no-seq-memoization")
	@GetMapping("/{n}")
	@Produces({MediaType.APPLICATION_JSON})
	public ResponseEntity<AlticciResponseDTO> returnAlticciSequenceValue(@PathVariable("n") Long number) {
		return alticciSequenceService.calculateAlticciSequenceIndex(number);
	}

	
	@Cacheable("seq-memoization")
	@GetMapping("/memoizationCache/{n}")
	@Produces({MediaType.APPLICATION_JSON})
	public ResponseEntity<AlticciResponseDTO> returnAlticciSequenceValueMemoized(@PathVariable("n") Long number) {
		return alticciSequenceService.calculateAlticciSequenceIndexMemoization(number);
	}

	
	@GetMapping("/checkMemoCache")
	@Produces({ MediaType.APPLICATION_JSON })
	public ResponseEntity<CacheResponseDTO> checkMemoCache() {
		return alticciSequenceService.checkSequenceCache();
	}

	@PostMapping("/clearMemoCache")
	@Produces({ MediaType.APPLICATION_JSON })
	public ResponseEntity<CacheResponseDTO> clearCache() {
		return alticciSequenceService.deleteSequenceCache();
	}

}
