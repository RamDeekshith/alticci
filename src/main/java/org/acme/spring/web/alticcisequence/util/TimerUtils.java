package org.acme.spring.web.alticcisequence.util;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public final class TimerUtils {
	
	private LocalTime refStart;

	public TimerUtils(){ refStart = LocalTime.now(); };

	public void start() {
		refStart = LocalTime.now();
	}

	public void timeBreakPrint() {
		timeBreakPrint(null);
	}

	public void timeBreakPrint(String msg) {
		System.out.println(String.format(">>> %s - %s", 
			Optional.ofNullable(msg).orElse("EXEC."), 
			timeBreakFormat())
		);
	}

	public void timeBreakInPlacePrint() {
		timeBreakInPlacePrint(null);
	}

	public void timeBreakInPlacePrint(String msg) {
		System.out.println(String.format(">>> %s - %s", 
			Optional.ofNullable(msg).orElse("EXEC."), 
			timeBreakFormatInPlace()) 
		);
	}

	public String timeBreakFormat() {
		return formatDuration(timeBreak());
	}

	public String timeBreakFormatInPlace() {
		return formatDuration(timeBreakInPlace());
	}
	
	public Duration timeBreakInPlace() {
		Duration dur = timeBreak();
		refStart = LocalTime.now();
		return dur;
	}
	
	public Duration timeBreak() {
		return Duration.between(refStart, LocalTime.now());
	}

	private String formatDuration(Duration dur) {
		return String.format("Processing time: %d s %03d ms %d ns", 
		dur.toSeconds(),
		dur.toMillisPart(),
		dur.toNanosPart());
	}
}
