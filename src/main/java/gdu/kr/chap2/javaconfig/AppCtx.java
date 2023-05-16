package gdu.kr.chap2.javaconfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import gdu.kr.chap2.Camera;
import gdu.kr.chap2.DisplayMode;
import gdu.kr.chap2.InfraredRaySensor;

@Configuration //컨테이너 클래스 선언
//gdu.kr.chap2 패키지 중 @Component인 클래스의 객체 생성 = <context:component-scan..../>
@ComponentScan(basePackages = {"gdu.kr.chap2"})
public class AppCtx {
	@Bean //객체화. 메서드의 이름으로 객체가 저장.
	public Camera camera1() { //<bean id="camera1" ... />
		Camera c = new Camera();
		c.setNumber(1);
		return c;
	}
	@Bean
	public Camera camera2() {
		Camera c = new Camera();
		c.setNumber(2);
		return c;
	}
	@Bean
	public Camera camera3() {
		Camera c = new Camera();
		c.setNumber(3);
		return c;
	}
	@Bean
	public Camera camera4() {
		Camera c = new Camera();
		c.setNumber(4);
		return c;
	}
	@Bean
	@Qualifier("intrusionDetection")
	public InfraredRaySensor windowSensor() {
		return new InfraredRaySensor("창센서");
	}
	@Bean
	@Qualifier("intrusionDetection")
	public InfraredRaySensor doorSensor() {
		return new InfraredRaySensor("현관센서");
	}
	@Bean
	public InfraredRaySensor lampSensor() {
		return new InfraredRaySensor("전등센서");
	}
	@Bean
	public DisplayMode displayMode() {
		DisplayMode d = new DisplayMode();
		d.setType("GRID");
		return d;
	}
	
}
