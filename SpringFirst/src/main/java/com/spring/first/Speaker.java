package com.spring.first;

public class Speaker {
	private int maxVolume;
	private String brand;
	private int currentVolume;

	public Speaker(String brand,int maxVolume) {
		super();
		this.brand = brand;
		this.maxVolume = maxVolume;
		System.out.printf("--%s 스피커생성 --",this.brand);
	}


	public void volumeUp() {
		currentVolume++;
		if (currentVolume < maxVolume) {
			currentVolume++;
		}
	}

	public void volumeDown() {
		if (currentVolume > 0) {
			currentVolume--;

		}
	}

	public String getBrand() {
		return brand;
	}
	public int getMaxVolume() {
		return maxVolume;
	}

	public int getCurrentVolume() {
		return currentVolume;
	}

}
