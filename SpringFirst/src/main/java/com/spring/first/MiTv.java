package com.spring.first;

public class MiTv {
	private Speaker speaker;

	public MiTv() {
		System.out.println("MiTv aa 기본 생성자");
	}

	public MiTv(Speaker speaker) {
		System.out.println("MiTvs speaker 생성자");
		this.speaker = speaker;
	}
	public void volumeUp() {
		speaker.volumeUp();
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
}
