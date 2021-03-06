package com.example.meter.aggregator.generator;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties("meter.aggregator.generator")
@Validated
public class ElectricityMeasureGeneratorProperties {

	/**
	 * Interval in seconds between measures.
	 */
	@Min(5)
	@Max(60)
	private int periodicity = 10;

	private final Map<String, Zone> zones = new LinkedHashMap<>();

	public int getPeriodicity() {
		return this.periodicity;
	}

	public void setPeriodicity(int periodicity) {
		this.periodicity = periodicity;
	}

	public Map<String, Zone> getZones() {
		return this.zones;
	}

	@Validated
	public static class Zone  {

		@NotNull
		private String name;

		@Min(10)
		private int devicesCount = 50;

		private float powerLow = 2000;

		private float powerHigh = 4000;

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getDevicesCount() {
			return this.devicesCount;
		}

		public void setDevicesCount(int devicesCount) {
			this.devicesCount = devicesCount;
		}

		public float getPowerLow() {
			return this.powerLow;
		}

		public void setPowerLow(float powerLow) {
			this.powerLow = powerLow;
		}

		public float getPowerHigh() {
			return this.powerHigh;
		}

		public void setPowerHigh(float powerHigh) {
			this.powerHigh = powerHigh;
		}

	}

}
